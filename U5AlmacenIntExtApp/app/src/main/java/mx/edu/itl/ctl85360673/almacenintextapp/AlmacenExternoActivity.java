package mx.edu.itl.ctl85360673.almacenintextapp;

import android.os.Environment;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AlmacenExternoActivity extends AppCompatActivity {

    private EditText editText;
    private String   texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_almacen_externo);

        // Recuperamos la referencia al EditText en el layout
        editText = (EditText) findViewById ( R.id.editText );
    }

    public void btnGuardarClick ( View v ) {
        if ( isAlmExtEscribible () ) {
            // Obtener la ruta raiz del almacenamiento externo
            File rutaExt = Environment.getExternalStorageDirectory();

            // Formamos la ruta donde guardaremos el archivo, en este caso en la carpeta de las fotos de la camara
            String rutaArchivo = rutaExt.getAbsolutePath() + "/DCIM/Camera";

            // Asociamos un File para el archivo en la ruta anterior
            File archivo = new File(rutaArchivo, "MiArchivo.txt");

            // Creamos, escribimos y cerramos el archivo
            try {
                BufferedWriter br = new BufferedWriter(
                        new FileWriter(archivo));
                br.write(editText.getText().toString());
                br.close();
            } catch (IOException ex) {
                Toast.makeText ( this, "ERROR: " + ex, Toast.LENGTH_LONG ).show();
            }
        } else
            Toast.makeText ( this, "El almacenamiento externo no esta MONTADO", Toast.LENGTH_SHORT ).show();
    }

    public void btnLeerClick ( View v ) {
        if ( isAlmExtLeible () ) {
            // Obtener la ruta raiz del almacenamiento externo
            File rutaExt = Environment.getExternalStorageDirectory();

            // Formamos la ruta donde esta guardado el archivo, en este caso en la carpeta de las fotos de la camara
            String rutaArchivo = rutaExt.getAbsolutePath() + "/DCIM/Camera";

            // Asociamos un File para el archivo en la ruta anterior
            File archivo = new File(rutaArchivo, "MiArchivo.txt");

            // Abrimos, leemos y cerramos el archivo
            try {
                BufferedReader br = new BufferedReader(
                        new FileReader(archivo));

                editText.setText("");
                String linea;
                while ((linea = br.readLine()) != null)
                    editText.append(linea + "\n");
                br.close();
            } catch (IOException ex) {
                Toast.makeText ( this, "ERROR: " + ex, Toast.LENGTH_LONG ).show();
            }
        } else
            Toast.makeText ( this, "El almacenamiento externo no esta habilitado para SOLO LECTURA", Toast.LENGTH_SHORT ).show();
    }

    public void btnInformaClick ( View v ) {
        // Obtener la ruta raiz del almacenamiento externo
        File rutaExt = Environment.getExternalStorageDirectory();
        editText.setText ( "Carpeta de Almacen Externo: \n" +
                            rutaExt.getAbsolutePath () + "\n" );

        // Mostramos el espacio total y el espacio libre del almacen externo en MB
        editText.append ( "Espacio total (MB): " + ( rutaExt.getTotalSpace() / ( 1024 * 1024 ) ) + "\n" );
        editText.append ( "Espacio libre (MB): " + ( rutaExt.getFreeSpace () / ( 1024 * 1024 ) ) + "\n" );

        // Obtener los archivos que hay en la carpeta donde guardamos nuestro archivo de texto
        String carpeta = rutaExt.getAbsolutePath() + "/DCIM/Camera";
        File rutaMiArchivo = new File ( carpeta );
        String listaArchivos []  = rutaMiArchivo.list();

        // Mostrar la lista de archivos
        editText.append ( "Lista de archivos en: " + carpeta + "\n" );
        for ( String archivo : listaArchivos ) {
            editText.append ( archivo + "\n" );
        }
    }

    public boolean isAlmExtEscribible () {
        String estado = Environment.getExternalStorageState ();
        if ( estado.equals ( Environment.MEDIA_MOUNTED ) ) {
            return true;
        }
        return false;
    }

    public boolean isAlmExtLeible () {
        String estado = Environment.getExternalStorageState();
        if (    estado.equals ( Environment.MEDIA_MOUNTED )   ||
                estado.equals ( Environment.MEDIA_MOUNTED_READ_ONLY ) )
            return true;
        return false;
    }


}
