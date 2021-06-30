/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                       INSTITUTO TECNOLOGICO DE LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: ENE-JUN/2021    HORA: 10-11 HRS
:*
:*     Main que nos permitira mostrar las astistencias de los alumnos que tiene el profesor
:*                              Fernando Gil.
:*
:*  Archivo     : AsistenciaActivity.java
:*  Autor       : Jose Misael Adame Sandoval     18131209
:*                Cristian Barajas Cabrales      17130764
:*                Salma Lizeth Mazuca Reyna      17130801
:*                Cristian Gabriel Piña Rosales  18130588
:*  Fecha       : 25/06/2021
:*  Compilador  : Android Studio 4.0.1
:*  Descripcion : Main que nos permitira mostrar las astistencias de los alumnos que tiene el
:*                 profesor Fernando Gil.
:*  Ultima modif:
:*  Fecha       Modificacion             Motivo
:*==========================================================================================
:*  dd/mmm/aaaa Fulanito de tal       Motivo de la modificacion, puede ser en mas de 1 renglon.
:*------------------------------------------------------------------------------------------*/

package mx.edu.itl.equipo9.proyfinalasistenciasapp.activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import mx.edu.itl.equipo9.proyfinalasistenciasapp.R;
import mx.edu.itl.equipo9.proyfinalasistenciasapp.bd.ConexionSQLite;
import mx.edu.itl.equipo9.proyfinalasistenciasapp.modelos.Asistencias;

import android.content.ClipData;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AsistenciasActivity extends AppCompatActivity {

    //----------------------------------------------------------------------------------------------
    //Variables que se utilizaran en este activity para referenciarlos a los atributos del xml
    ListView listViewAsistencias;
    ArrayList<String> listaInformacion;
    ArrayList<Asistencias> listaAsistencias;
    ConexionSQLite conn;
    TableLayout tlFechaAlumno;
    TextView tvNombreAlumnoFecha;

    //----------------------------------------------------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asistencias);

        conn = new ConexionSQLite(getApplicationContext(), "dbasistencias", null, 1);

        listViewAsistencias = findViewById(R.id.listViewAsistencias);

        consultarListaAsistencias();

        ArrayAdapter adaptador = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaInformacion );
        listViewAsistencias.setAdapter ( adaptador );

        listViewAsistencias.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                setContentView(R.layout.activity_detalle_fecha_alumno);
                tlFechaAlumno = findViewById(R.id.tlFechaAlumno);
                tvNombreAlumnoFecha = findViewById(R.id.tvNombreAlumnoFecha);


                ConexionSQLite conn = new ConexionSQLite ( view.getContext(),"dbasistencias", null, 1 );
                SQLiteDatabase db = conn.getWritableDatabase ();
                Cursor fila = db.rawQuery("SELECT * FROM Asistencia WHERE alu_numero_control = '"+listaAsistencias.get(i).getNumeroDeControl()+"'ORDER BY asi_fecha ASC", null);
                fila.moveToFirst();
                tvNombreAlumnoFecha.setText ( "Numero de control: " +fila.getString ( 1 ) );
                do {
                    View registro = LayoutInflater.from(view.getContext()).inflate(R.layout.item_tabla_detalle_fecha_alumno_layout, null, false);
                    TextView tvFecha = registro.findViewById(R.id.tvFecha);

                    tvFecha.setText ( fila.getString(3 ) );

                    tlFechaAlumno.addView ( registro);

                } while (fila.moveToNext() );
            }
        });

    }
    //==============================================================================================

    //----------------------------------------------------------------------------------------------
    //Metodo que nos permitira obtener la lista de asistencia
    private void obtenerLista () {
        listaInformacion = new ArrayList<String>();

        for (  int i = 0; i < listaAsistencias.size(); i++) {
            listaInformacion.add("Numero de control: "+listaAsistencias.get(i).getNumeroDeControl()+"\n"
                                +"Alumno: " +listaAsistencias.get(i).getAlumno()+"\n"
                                +"Materia: " +listaAsistencias.get(i).getMateria()+ "\n"
                                +"Presente: " +listaAsistencias.get(i).getPresente()+ "\n"
                                +"Justificado: " +listaAsistencias.get(i).getJustificado()+ "\n"
                                +"Total: " +listaAsistencias.get(i).getTotal()+ "\n"
                                +"Porcentaje: " +listaAsistencias.get(i).getPorcentaje());
        }
    }
    //==============================================================================================

    //----------------------------------------------------------------------------------------------
    //Metodo que nos permitira leer el archivo de asistencias para posteriormente cargarlo
    public void getListaAsistencias ( Uri uri, String filePath) {
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader bReader = null;

        String numeroControlRegEx = "([A-Z]?[1][5-9][1][0-9]{5,6})";
        Pattern patron = Pattern.compile ( numeroControlRegEx );
        String[] file_separator = filePath.split("/");
        String nombreArchivo = file_separator[file_separator.length-1];
        String[] separadorFila2 = nombreArchivo.split(" ");
        String fecha = separadorFila2[0];
        String materia = separadorFila2[1].split("-")[0];

        try {
            InputStream inputStream = getContentResolver().openInputStream(uri);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String lineaTexto;

            ConexionSQLite base = new ConexionSQLite( this, "dbasistencias", null, 1 );
            SQLiteDatabase db = base.getWritableDatabase();
            db.beginTransaction();
            while((lineaTexto = bufferedReader.readLine())!=null){
                Matcher m = patron.matcher(lineaTexto);
                if (m.find()){
                    String numeroDeControl = m.group();
                    String[] file_sep3 = lineaTexto.split(" ");
                    String opcion = file_sep3[file_sep3.length-1].toLowerCase();
                    ContentValues contentV = new ContentValues();
                    contentV.put("alu_numero_control",numeroDeControl);
                    contentV.put("mat_nombre",materia);
                    contentV.put("asi_fecha",fecha);
                    if(opcion.equals("presente"))
                        contentV.put("asi_presente",1);
                    else
                        contentV.put("asi_presente",0);

                    if(opcion.equals("justificado"))
                        contentV.put("asi_justificado",1);
                    else
                        contentV.put("asi_justificado",0);

                    db.insert("Asistencia",null,contentV);
                }
                Toast.makeText(this,"Asistencias insertadas correctamente",Toast.LENGTH_SHORT).show();
            }
            db.setTransactionSuccessful();
            db.endTransaction();


        }catch (Exception e){
            Toast.makeText(this,"Error: "+e,Toast.LENGTH_SHORT).show();

        }finally {
            if(fis !=null){
                try {
                    fis.close();
                }catch (Exception e){
                    Toast.makeText(this,"Error: "+e,Toast.LENGTH_SHORT).show();

                }
            }
        }

    }
    //==============================================================================================

    //----------------------------------------------------------------------------------------------
    //Metodo que nos permite cargar el archivo de asistencias
    public void btnCargarAsistenciasClick ( View v ) {


        try {
            Intent intent = new Intent();
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
            intent.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(Intent.createChooser(intent, "Select a File to Upload"), 962);


        } catch(Exception e){
            Toast.makeText(this, "Please install a File Manager.",
                    Toast.LENGTH_SHORT).show();
        }


    }
    //==============================================================================================

    // SI JALA
    //----------------------------------------------------------------------------------------------
    //ActivityResult que nos permite meter los datos a la base de datos y agregarlo a un ListView
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable  Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 962) {
            SQLiteDatabase db = conn.getReadableDatabase();
            db.execSQL("DROP TABLE Asistencia");

            db.execSQL("CREATE TABLE Asistencia ( asi_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                                                "alu_numero_control TEXT NOT NULL,"  +
                                                "mat_nombre INTEGER NOT NULL," +
                                                "asi_fecha DATE NOT NULL, "+
                                                "asi_presente INTEGER NOT NULL," +
                                                "asi_justificado INTEGER NOT NULL)");

            //mClipData - cuando son varios archivos
            ClipData cd = data.getClipData();
            if (cd != null) {
                for (int i = 0; i < cd.getItemCount(); i++) {
                    ClipData.Item item = cd.getItemAt(i);
                    String path = item.getUri().getPath();
                    Uri uri = item.getUri();
                    getListaAsistencias(uri, path);
                }
            }
            consultarListaAsistencias();

            ArrayAdapter adaptador = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaInformacion );
            listViewAsistencias.setAdapter ( adaptador );
        }
    }
    //==============================================================================================

    //----------------------------------------------------------------------------------------------
    //Metodo que nos permite ir a una nueva vista para ver la fecha de asistencias
    public void consultarListaAsistencias() {
        //ConexionSQLite conn = new ConexionSQLite ( this,"dbasistencias", null, 1 );
        //SQLiteDatabase db = conn.getWritableDatabase ();
        SQLiteDatabase db = conn.getReadableDatabase();
        Cursor fila = db.rawQuery("SELECT * FROM Alumno", null);
        ArrayList<Asistencias> listAsistencias = new ArrayList<>();
        listaAsistencias = new ArrayList<Asistencias>();
        Asistencias alumno = null;

        if ( fila.moveToFirst() ) {
            do {
                alumno = new Asistencias();
                alumno.setNumeroDeControl(fila.getString(1));
                alumno.setAlumno(fila.getString(2));

                listAsistencias.add(alumno);

            } while (fila.moveToNext() ); //228032
        }
        fila.close();

        for ( Asistencias alum : listAsistencias ) {
            fila = db.rawQuery ( "SELECT * FROM Asistencia WHERE alu_numero_control = '"+alum.getNumeroDeControl()+"'",null );
            if ( fila.moveToFirst() ) {
                do {
                    alum.setMateria(fila.getString(2));
                    alum.setPresente(fila.getShort(4));
                    alum.setJustificado(fila.getShort(5));

                } while (fila.moveToNext());

                alum.setTotal(alum.getPresente() + alum.getJustificado());
                alum.setPorcentaje( alum.getMateria(), alum.getTotal() );
                listaAsistencias.add(alum);
            }
            fila.close();
        }
        obtenerLista();
    }
    //==============================================================================================
}