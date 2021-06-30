/*--------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                       INSTITUTO TECNOLOGICO DE LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: ENE-JUN/2021    HORA: 10-11 HRS
:*
:*    Activity que nos permitira mostrar las materias que imparte el profesor Fernando Gil.
:*
:*  Archivo     : MateriasActivity.java
:*  Autor       : Jose Misael Adame Sandoval     18131209
:*                Cristian Barajas Cabrales      17130764
:*                Salma Lizeth Mazuca Reyna      17130801
:*                Cristian Gabriel Piña Rosales  18130588
:*  Fecha       : 25/06/2021
:*  Compilador  : Android Studio 4.0.1
:*  Descripcion : Activity que nos permitira mostrar las materias que imparte el
:*                profesor Fernando Gil.
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
import mx.edu.itl.equipo9.proyfinalasistenciasapp.modelos.Materia;
import mx.edu.itl.equipo9.proyfinalasistenciasapp.modelos.Modelo;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.jaiselrahman.filepicker.activity.FilePickerActivity;
import com.jaiselrahman.filepicker.config.Configurations;
import com.jaiselrahman.filepicker.model.MediaFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MateriasActivity extends AppCompatActivity {

    //----------------------------------------------------------------------------------------------
    //Variables que se utilizaran en este activity para referenciarlos a los atributos del xml
    TableLayout tlMaterias;
    Button cargarMaterias;
    //==============================================================================================

    //----------------------------------------------------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materias);

        tlMaterias = findViewById(R.id.tlMaterias);
        cargarMaterias = findViewById(R.id.button4);
    }
    //==============================================================================================

    //----------------------------------------------------------------------------------------------
    //Metodo que lee un archivo y obtine y lo va almacenando en un arreglo
    public void getListaMaterias ( String filePath ) {
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader bReader = null;

        try {
            fis = new FileInputStream ( filePath );
            isr = new InputStreamReader (fis);
            bReader = new BufferedReader ( isr );
            String line = null;
            String[] strMateria;

            while ( true ) {
                line = bReader.readLine ();
                if ( line == null ) {
                    break;
                } else {
                    strMateria = line.split(",");
                    Materia mat = new Materia ( strMateria[0], strMateria[1] );
                    Modelo obj = new Modelo ();
                    obj.insertaMateria( MateriasActivity.this, mat );
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Cerrar el archivo
            try {
                bReader.close();
                isr.close();
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
    //==============================================================================================

    //----------------------------------------------------------------------------------------------
    //Metodo click, para llamar el metodo que nos proporcionara los datos
    public void btnCargarMateriasClick ( View v ) {
        btnLeerClick();

    }
    //==============================================================================================

    //----------------------------------------------------------------------------------------------
    //Metodo que nos permite abrir el explorador de archivos para poder seleccionar los archivos deseados
    public void btnLeerClick () {

        if ( isAlmExtLeible () ) {

            Intent intent = new Intent ( MateriasActivity.this,
                    FilePickerActivity.class );

            intent.putExtra ( FilePickerActivity.CONFIGS, new Configurations.Builder()
                    .setCheckPermission(true)
                    .setShowFiles(true)
                    .setShowImages(false)
                    .setShowVideos(false)
                    .setMaxSelection(1)
                    .setSuffixes("txt")
                    .setSkipZeroSizeFiles(true)
                    .build());

            startActivityForResult(intent, 102);

            Toast.makeText ( this, "Archivo Materias cargado exitosamente", Toast.LENGTH_SHORT ).show();

        } else
            Toast.makeText ( this, "El almacenamiento externo no esta habilitado para SOLO LECTURA", Toast.LENGTH_SHORT ).show();

    }
    //==============================================================================================

    //----------------------------------------------------------------------------------------------
    //Metodo que nos permitira verificar el estado del almacenamiento
    public boolean isAlmExtLeible () {
        String estado = Environment.getExternalStorageState();
        if (    estado.equals ( Environment.MEDIA_MOUNTED )   ||
                estado.equals ( Environment.MEDIA_MOUNTED_READ_ONLY ) )
            return true;
        return false;
    }
    //==============================================================================================

    //----------------------------------------------------------------------------------------------
    //ActivityResult que nos permitira cargar la lista de materias
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && data != null) {
            ArrayList<MediaFile> mediaFiles = data.getParcelableArrayListExtra(
                    FilePickerActivity.MEDIA_FILES
            );

            String path = mediaFiles.get(0).getPath();

            getListaMaterias(path);

            llenarTabla();

            Toast.makeText ( this, "Archivo Materias cargado exitosamente", Toast.LENGTH_SHORT ).show();

            cargarMaterias.setEnabled ( false );
        }
    }
    //==============================================================================================

    //----------------------------------------------------------------------------------------------
    //Metodo que llenara la tabla despues de leer los datos en la base de datos
    public void llenarTabla () {
        ConexionSQLite conn = new ConexionSQLite ( this,"dbasistencias", null, 1 );
        SQLiteDatabase db = conn.getWritableDatabase ();
        Cursor fila = db.rawQuery("SELECT * FROM Materia", null);
        fila.moveToFirst();
        do {
            View registro = LayoutInflater.from(this).inflate(R.layout.item_tabla_materias_layout, null, false);
            TextView tvId = registro.findViewById(R.id.tvId);
            TextView tvClave = registro.findViewById(R.id.tvClave);
            TextView tvNombre = registro.findViewById(R.id.tvNombre);

            tvId.setText ( fila.getString(0 ) );
            tvClave.setText ( fila.getString(1 ) );
            tvNombre.setText ( fila.getString(2 ) );

            tlMaterias.addView(registro);

        } while (fila.moveToNext() );
    }
    //==============================================================================================
}