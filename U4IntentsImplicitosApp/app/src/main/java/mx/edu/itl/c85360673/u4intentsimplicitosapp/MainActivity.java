/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                       INSTITUTO TECNOLOGICO DE LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: ENE-JUN/2021    HORA: 10-11 HRS
:*
:*                         Clase principal de la aplicación
:*
:*  Archivo     : MainActivity.java
:*  Autor       : José Misael Adame Sandoval     18131209
:*  Fecha       : 19/May/2021
:*  Compilador  : Android Studio 4.1.2
:*  Descripción : Clase que demuestra el uso de diferentes tipos de intent's implicitos,
:*                y Los botones que tiene son los siguientes:
:*
:*                •	Preparar llamada (sin lanzarla)
:*                •	Hacer llamada (lanzandola)
:*                •	Abrir página web
:*                •	Google Maps
:*                •	Abrir cámara fotográfica
:*                •	Enviar correo simple
:*                •	Abrir explorador de archivos
:*                •	Abrir galeria para seleccionar imagen
:*                •	Acerca de...
:*
:*  Ultima modif:
:*  Fecha       Modificó             Motivo
:*==========================================================================================
:*
:*------------------------------------------------------------------------------------------*/

package mx.edu.itl.c85360673.u4intentsimplicitosapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.Layout;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final int CODIGO_SELECCIONAR_ARCHIVO  = 1944;
    public static final int CODIGO_GALERIA_FOTOS        = 1945;

    private EditText edtTexto;
    private EditText edtLatitud;
    private EditText edtLongitud;
    private View     layout;
    private String   texto = "7141516";

    //----------------------------------------------------------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //----------------------------------------------------------------------------------------------
    // Preparar una llamada telefonica con el numero pero sin lanzarla.
    //                                   ACTION_DIAL
    //
    // Formato del URI:   tel:<numero>

    public void btnPrepararLlamadaClick    ( View v ) {
        layout    = getLayoutInflater().inflate ( R.layout.layout_edit_text_simple, null );
        edtTexto  = layout.findViewById  ( R.id.edtTexto );
        edtTexto.setText ( texto );

        AlertDialog.Builder builder = new AlertDialog.Builder ( this );
        builder.setTitle ( "No. Telefonico:" )
                .setView ( layout )
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // Abrir la aplicacion del telefono preparando el numero pero sin lanzar la llamada

                        String numero = edtTexto.getText().toString();

                        String uri = "tel:" + numero;
                        Intent intent = new Intent ( Intent.ACTION_DIAL, Uri.parse ( uri ) );
                        startActivity ( intent );

                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                })
                .create()
                .show();
    }

    //----------------------------------------------------------------------------------------------
    // MARCAR NUMERO TELEFONICO LANZANDO LA LLAMADA:
    //                                   ACTION_CALL
    //
    // Esta funcionalidad requiere el siguiente permiso en el AndroidManifest.xml
    // <uses-permission android:name="android.permission.CALL_PHONE"/>
    // Tambien requiere habilitar manualmente el permiso TELEFONO para esta app en los Ajustes
    // (Settings) del dispositivo.
    //
    // Formato del URI:   tel:<numero>

    public void btnHacerLlamadaClick       ( View v ) {
        layout    = getLayoutInflater().inflate ( R.layout.layout_edit_text_simple, null );
        edtTexto  = layout.findViewById  ( R.id.edtTexto );
        edtTexto.setText ( texto );

        AlertDialog.Builder builder = new AlertDialog.Builder ( this );
        builder.setTitle ( "No. Telefonico:" )
                .setView ( layout )
                .setPositiveButton("Llamar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // Abrir la aplicacion del telefono preparando el numero y lanzando la llamada

                        String numero = edtTexto.getText().toString();

                        String uri = "tel:" + numero;
                        Intent intent = new Intent ( Intent.ACTION_CALL, Uri.parse ( uri ) );
                        startActivity ( intent );

                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                })
                .create()
                .show();
    }

    //----------------------------------------------------------------------------------------------
    // Abrir el navegador en una pagina determinada
    //                                   ACTION_VIEW
    //
    // Formato del URI:   http://<direccion-pagina>

    public void  btnAbrirPaginaWebClick    ( View v ) {
        layout      = getLayoutInflater().inflate ( R.layout.layout_edit_text_simple, null );
        edtTexto  = layout.findViewById  ( R.id.edtTexto );
        edtTexto.setText ( "https://www.youtube.com/watch?v=DAN-1BfZLUo" );

        AlertDialog.Builder builder = new AlertDialog.Builder ( this );
        builder.setTitle ( "Direccion web:" )
                .setView ( layout )
                .setPositiveButton("Abrir", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // Verificamos si se debe completar la direccion de la pagina con http o https
                        String direccion = edtTexto.getText().toString();

                        String uri       = "";
                        if  (   direccion.startsWith ( "http://"  ) ||
                                direccion.startsWith ( "https://" )   )
                            uri       = direccion;
                        else
                            uri       = "http://" + direccion;

                        // Lanzamos el navegador en la pagina capturada
                        Intent intent = new Intent ( Intent.ACTION_VIEW, Uri.parse ( uri ) );
                        startActivity ( intent );


                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                })
                .create()
                .show();
    }

    //----------------------------------------------------------------------------------------------
    // Abrir Google Maps en una determinada ubicacion
    //                                 ACTION_VIEW
    //
    // Formato del URI:   geo:<latitud>:<longitud>

    public void btnGoogleMapsClick         ( View v ) {
        layout    = getLayoutInflater().inflate ( R.layout.layout_leer_lat_long, null );
        edtLatitud  = layout.findViewById  ( R.id.edtLatitud  );
        edtLongitud = layout.findViewById  ( R.id.edtLongitud );

        AlertDialog.Builder builder = new AlertDialog.Builder ( this );
        builder.setTitle ( "Datos de la ubicacion:" )
                .setView ( layout )
                .setPositiveButton("Mostrar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // Abrir la aplicacion del Google Maps

                        String latitud = edtLatitud.getText ().toString ();
                        String longitud = edtLongitud.getText ().toString ();
                        String uri = "geo:" + latitud + "," + longitud;

                        Intent intent = new Intent ( Intent.ACTION_VIEW, Uri.parse ( uri ) );
                        startActivity ( intent );

                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                })
                .create()
                .show();
    }

    //----------------------------------------------------------------------------------------------
    // Llamar a la app de la camara
    //                                ACTION_IMAGE_CAPTURE

    public void btnCamaraFotosClick       ( View v ) {

        Intent intent = new Intent ( MediaStore.ACTION_IMAGE_CAPTURE );
        startActivity ( intent );
    }

    //----------------------------------------------------------------------------------------------
    // Enviar correo electronico simple ( sin adjuntos )
    //                                  ACTION_SEND

    public void btnEnviarCorreoClick      ( View v ) {
        layout    = getLayoutInflater().inflate ( R.layout.layout_edit_text_simple, null );
        edtTexto  = layout.findViewById  ( R.id.edtTexto );
        texto = "HOLAAA :D";
        edtTexto.setText ( texto );

        AlertDialog.Builder builder = new AlertDialog.Builder ( this );
        builder.setTitle ( "Texto a enviar:" )
                .setView ( layout )
                .setPositiveButton("Enviar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String mensaje = edtTexto.getText().toString();

                        // Preparamos el intent con los datos formados para un mensaje de correo electronico
                        Intent intent = new Intent ( Intent.ACTION_SEND );
                        intent.setType  ( "text/plain" );
                        intent.putExtra ( Intent.EXTRA_EMAIL, new String [] { "jmisaeladame@gmail.com" } );
                        intent.putExtra ( Intent.EXTRA_CC,    new String [] { "misael_adame@protonmail.com"     } );
                        intent.putExtra ( Intent.EXTRA_SUBJECT, "Probando envio de correito :P"  );
                        intent.putExtra ( Intent.EXTRA_TEXT, mensaje );

                        startActivity   ( intent );
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                })
                .create()
                .show();
    }

    //----------------------------------------------------------------------------------------------
    // Abrir el Explorador de Archivos
    //                                  ACTION_GET_CONTENT

    public void btnExploradorArchsClick    ( View v ) {

        Intent intent = new Intent ( Intent.ACTION_GET_CONTENT );
        intent.setType  ( "*/*" );
        intent.addCategory ( Intent.CATEGORY_DEFAULT );

        try {

            startActivityForResult ( Intent.createChooser ( intent, "Seleccione una opción."),
                                     CODIGO_SELECCIONAR_ARCHIVO );

        } catch ( ActivityNotFoundException e){
            Toast.makeText(this, "Explorador de archivos no encontrado.\n" +
                          "Por favor instale un exploador de archivos.", Toast.LENGTH_LONG).show();
        }
    }

    //----------------------------------------------------------------------------------------------
    // Galeria de Fotos
    //                                ACTION_PICK

    public void btnAbrirGaleriaClick       ( View v ) {
        Intent intent = new Intent ( Intent.ACTION_PICK,
                                     MediaStore.Images.Media.EXTERNAL_CONTENT_URI );
        startActivityForResult ( intent, CODIGO_GALERIA_FOTOS );
    }

    //----------------------------------------------------------------------------------------------

    @Override
    protected void onActivityResult ( int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CODIGO_SELECCIONAR_ARCHIVO) {
            // Se invocó la app para explorar archivos

            if (resultCode == RESULT_OK) {
                // Obtenemos el URI del archivo seleccionado como un String y lo mostramos en pantalla
                String archivo = data.getDataString();

                new AlertDialog.Builder(this)
                        .setTitle("Uri del archivo seleccionado: ")
                        .setMessage(archivo)
                        .setNegativeButton("Aceptar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        })
                        .create()
                        .show();
            }
        } else if (requestCode == CODIGO_GALERIA_FOTOS ) {
            // Se invocó la app de la galeria de fotos

            if (resultCode == RESULT_OK) {
                // Obtenemos el URI de la foto como un string
                String uri = data.getDataString();

                // Abrimos el activity para mostrar la foto
                Intent intent = new Intent(this, FotoActivity.class);
                intent.putExtra ("uri", uri );
                startActivity(intent);
            }
        }
    }

    //----------------------------------------------------------------------------------------------

    public void btnAcercaDeClick ( View v ) {
        Intent intent = new Intent ( this, AcercaDeActivity.class );
        startActivity ( intent );
    }

}
