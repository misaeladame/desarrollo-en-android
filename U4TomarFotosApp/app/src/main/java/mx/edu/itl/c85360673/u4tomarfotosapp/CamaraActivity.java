/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                       INSTITUTO TECNOLOGICO DE LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: ENE-JUN/2021    HORA: 10-11 HRS
:*
:*                        Clase con opciones de camara
:*
:*  Archivo     : MainActivity.java
:*  Autor       : Jose Misael Adame Sandoval     18131209
:*  Fecha       : 24/May/2021
:*  Compilador  : Android Studio 4.1.2
:*  Descripción : Clase que permite tomar fotografias y además cuenta con opciones
:*                para guardarlas, los botones que tiene son los siguientes:
:*
:*                •	1-Tomar foto
:*                •	2A-Guardar foto (en almacen interno privado)
:*                •	2B-Guardar foto en /DCIM/Camera
:*                •	3-Cargar foto en ImageView
:*
:*  Ultima modif:
:*  Fecha       Modificó             Motivo
:*==========================================================================================
:*
:*------------------------------------------------------------------------------------------*/

/*--------------------------------------------------------------------------------------------------

  Considerar que para el uso de la camara y para poder escribir en almacenamiento SD es necesario
  los siguientes permisos en el AndroidManifest:

    <uses-permission android:name="android.permission.CAMERA" />
    <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />

 -------------------------------------------------------------------------------------------------*/

package mx.edu.itl.c85360673.u4tomarfotosapp;


import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;

import android.net.Uri;
import android.os.Environment;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import androidx.appcompat.app.AppCompatActivity;
import util.imagenes.Imagen;


public class CamaraActivity extends AppCompatActivity implements View.OnClickListener {

    public static final int CODIGO_CAMARA  = 0;
    public static final int CALIDAD_IMAGEN = 5;  // Valor de 0-100, 100=calidad mas alta

    private Button    btnCamara,
                      btnGuardar,
                      btnCargar,
                      btnGuardarDCIM;
    private TextView  txtvPathTmp;
    private TextView  txtvPathDestino;
    private ImageView imgvFotoCapturada,
                      imgvFotoRecuperada;

    private Uri       mImagenUri;
    private String    strPathDestino;

    private int       calidadImagen = 5;
    private EditText  edtCalidad;

    //----------------------------------------------------------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.camara_main);

        // Referenciar en variables los objetos del layout 
        btnCamara          = (Button)    findViewById ( R.id.btnTomarFoto  );
        btnGuardar         = (Button)    findViewById ( R.id.btnGuardarAlmPrivado );
        btnCargar          = (Button)    findViewById ( R.id.btnCargarFoto );
        btnGuardarDCIM     = (Button)    findViewById ( R.id.btnGuardarAlmCompartido );
        txtvPathTmp        = (TextView)  findViewById ( R.id.txtvRutaTmp     );
        txtvPathDestino    = (TextView)  findViewById ( R.id.txtvRutaDestino );
        imgvFotoCapturada  = (ImageView) findViewById ( R.id.imageView       );
        imgvFotoRecuperada = (ImageView) findViewById ( R.id.imageView2      );
        edtCalidad         = (EditText)  findViewById ( R.id.edtCalidad      );

        // Registrar esta Activity como listener de los eventos clic sobre los botones
        btnCamara.setOnClickListener      ( this );
        btnCargar.setOnClickListener      ( this );
        btnGuardar.setOnClickListener     ( this );
        btnGuardarDCIM.setOnClickListener ( this );

        // Resolver problema a partir de API 24 en delante que no puede iniciar la app de la camara
        // Esta no es la forma mas correcta de hacer que funcione ya que lo que se esta haciendo
        // es anular politicas de seguridad. Lo correcto es la solucion con FileProvider que se
        // usa en el MainActivity de esta misma app.
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder ();
        StrictMode.setVmPolicy ( builder.build () );


    }

    //----------------------------------------------------------------------------------------------


    @Override
    public void onClick ( View v ) {
        calidadImagen = Integer.parseInt ( edtCalidad.getText().toString () );

        switch ( v.getId () ) {
            case R.id.btnTomarFoto :
                // TOMAR FOTO
                File file = this.crearArchivoTemporal ( "fotito", ".jpg" );
                file.delete ();
                mImagenUri = Uri.fromFile ( file );

                // Llamamos a la aplicacion del sistema de la camara
                Intent intent = new Intent ( "android.media.action.IMAGE_CAPTURE" );
                intent.putExtra            ( MediaStore.EXTRA_OUTPUT, mImagenUri  );
                startActivityForResult     ( intent, CODIGO_CAMARA                );

                break;
            case R.id.btnGuardarAlmPrivado :
                // GUARDAR FOTO
                Bitmap bitmap                     = ( (BitmapDrawable) imgvFotoCapturada.getDrawable () ).getBitmap ();

                // getDir (): [AndroidDoc] Recupera, creandolo si es necesario, un nuevo directorio en el que la app pueda colocar sus propios archivos de datos.
                // lgv-El directorio se localizara en almacenamiento interno privado, exclusivo para datos de la app. Ni el usuario del movil puede acceder por fuera.
                File directory                    = this.getDir ( "fotitoDir", Context.MODE_PRIVATE  );

                File mypath                       = new File ( directory, "fotito.jpg" );
                FileOutputStream fileOutputStream = null;

                try {
                    fileOutputStream = new FileOutputStream ( mypath );
                    bitmap.compress ( Bitmap.CompressFormat.JPEG, calidadImagen, fileOutputStream );
                    fileOutputStream.close ();

                } catch ( FileNotFoundException e ) {
                    e.printStackTrace ();
                } catch ( IOException e ) {

                }

                txtvPathDestino.setText (  mypath.getAbsolutePath() );
                strPathDestino =  "" + directory.getAbsolutePath ();

                break;
            case R.id.btnGuardarAlmCompartido :
                // GUARDAR FOTO
                Bitmap bitmap4                     = ( (BitmapDrawable) imgvFotoCapturada.getDrawable () ).getBitmap ();

                // FGil : Guardaremos la foto en  /sdcard/DCIM/Camera/fotito.jpg
                File directory4                    = new File ( Environment.getExternalStorageDirectory ().getAbsolutePath() + "/DCIM/Camera/" );
                File mypath4                       = new File ( directory4, "fotito.jpg" );
                FileOutputStream fileOutputStream4 = null;

                try {
                    fileOutputStream4 = new FileOutputStream ( mypath4 );

                    // compress ( format, quality, stream ): [AndroidDoc] Write a compressed version of the bitmap to the specified outputstream.
                    //                                                    quality: (int) Hint to the compressor, 0-100. 0 meaning compress for small size,
                    //                                                                   100 meaning compress for max quality.
                    //                                                                   Some formats, like PNG which is lossless, will ignore the quality setting
                    bitmap4.compress ( Bitmap.CompressFormat.JPEG, calidadImagen, fileOutputStream4 );
                    fileOutputStream4.close ();

                } catch ( FileNotFoundException e ) {
                    e.printStackTrace ();
                } catch ( IOException e ) {

                }

                txtvPathDestino.setText (  mypath4.getAbsolutePath() );
                strPathDestino =  "" + directory4.getAbsolutePath ();

                break;
            case R.id.btnCargarFoto :
                // CARGAR LA FOTO QUE SE GUARDO YA DESDE EL ALM. PRIVADO O COMPARTIDO, EL ULT QUE SE
                // HAYA USADO.
                File file1 = new File ( strPathDestino, "fotito.jpg" );
                Bitmap bitmap1 = null;
                try {
                    bitmap1 = BitmapFactory.decodeStream ( new FileInputStream ( file1 ) );
                } catch ( FileNotFoundException e ) {
                    e.printStackTrace();
                }
                imgvFotoRecuperada.setImageBitmap ( bitmap1 );
                break;
        }
    }

    //----------------------------------------------------------------------------------------------

    @Override
    protected void onActivityResult ( int requestCode, int resultCode, Intent data ) {
        if ( requestCode == CODIGO_CAMARA &&
                resultCode  == RESULT_OK         ) {

            // Reducir el tamaño de la imagen capturada y cargarla  en el imageview pequeño
            Bitmap bitmap = Imagen.reducirBitmap ( this, mImagenUri.toString(), 512, 512 );
            imgvFotoCapturada.setImageBitmap ( bitmap );
        }
        super.onActivityResult ( requestCode, resultCode, data );
    }

    //----------------------------------------------------------------------------------------------

    private File crearArchivoTemporal ( String part, String ext ) {
        // Obtenemos el directorio almacen primario  compartido/externo.
        File tempDir = Environment.getExternalStorageDirectory ();
        // Creamos una carpeta temporal si no existe
        tempDir = new File ( tempDir.getAbsolutePath () + "/temp_ITL/" );
        if  ( ! tempDir.exists () ) {
            tempDir.mkdir ();
        }

        try {
            // Creamos un archivo nuevo vacio en el directorio especificado por tempDir,
            // usando el prefijo y sufijo dados para generar su nombre.
            File tempArch = File.createTempFile ( part, ext, tempDir );
            // Desplegamos la ruta donde se guardara temporalmente la foto
            txtvPathTmp.setText ( tempArch.getAbsolutePath () );

            return tempArch;
        } catch ( IOException e ) {
            e.printStackTrace ();
        }
        return null ;
    }

    //----------------------------------------------------------------------------------------------

}
