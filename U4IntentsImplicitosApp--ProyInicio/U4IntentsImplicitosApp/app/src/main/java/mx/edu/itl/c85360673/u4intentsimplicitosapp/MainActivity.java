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
    private String   texto = "";

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

                        // *** COMPLETAR EL CODIGO AQUI ***

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

                        // *** COMPLETAR EL CODIGO AQUI ***

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
        edtTexto.setText ( "www.itlalaguna.edu.mx" );

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

                        // *** COMPLETAR EL CODIGO AQUI ***

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

                        // *** COMPLETAR EL CODIGO AQUI ***

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

        // *** COMPLETAR EL CODIGO AQUI ***
    }

    //----------------------------------------------------------------------------------------------
    // Enviar correo electronico simple ( sin adjuntos )
    //                                  ACTION_SEND

    public void btnEnviarCorreoClick      ( View v ) {
        layout    = getLayoutInflater().inflate ( R.layout.layout_edit_text_simple, null );
        edtTexto  = layout.findViewById  ( R.id.edtTexto );
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
                        intent.putExtra ( Intent.EXTRA_EMAIL, new String [] { "fgil@universoft.com.mx" } );
                        intent.putExtra ( Intent.EXTRA_CC,    new String [] { "gilvif@hotmail.com"     } );
                        intent.putExtra ( Intent.EXTRA_SUBJECT, "Probando envio de correo basico"  );
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

        // *** COMPLETAR EL CODIGO AQUI ***

        try {

            // *** COMPLETAR EL CODIGO AQUI ***

        } catch ( ActivityNotFoundException e){
            Toast.makeText(this, "Explorador de archivos no encontrado.\n" +
                          "Por favor instale un exploador de archivos.", Toast.LENGTH_LONG).show();
        }
    }

    //----------------------------------------------------------------------------------------------
    // Galeria de Fotos
    //                                ACTION_PICK

    public void btnAbrirGaleriaClick       ( View v ) {
        // *** COMPLETAR EL CODIGO AQUI ***
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
}
