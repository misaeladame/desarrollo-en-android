/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                       INSTITUTO TECNOLOGICO DE LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: ENE-JUN/2021    HORA: 10-11 HRS
:*
:*                          Clase principal de la app
:*
:*  Archivo     : MainActivity.java
:*  Autor       : Jose Misael Adame Sandoval     18131209
:*  Fecha       : 29/May/2021
:*  Compilador  : Android Studio 4.1.2
:*  Descripción : Clase que permite grabar, almacenar y reproducir audios en formato 3gp,
:*                los botones que tiene son los siguientes:
:*
:*                •	Grabar
:*                •	Detener
:*                •	Reproducir
:*                •	Acerca de...
:*
:*  Ultima modif:
:*  Fecha       Modificó             Motivo
:*==========================================================================================
:*
:*------------------------------------------------------------------------------------------*/

package teclag.c85360673.u4grabaraudioapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;

import mx.edu.itl.c18131209.androidlib.util.permisos.ChecadorDePermisos;
import mx.edu.itl.c18131209.androidlib.util.permisos.PermisoApp;

public class MainActivity extends AppCompatActivity {

    private PermisoApp [] permisosReq = {
        new PermisoApp ( Manifest.permission.RECORD_AUDIO, "Audio", true ),
        new PermisoApp ( Manifest.permission.READ_EXTERNAL_STORAGE, "Almacenamiento", true )
    };

    private TextView txtvMensajes;
    private EditText edtGuardarComo;
    private Button   btnGrabar;
    private Button   btnDetener;
    private Button   btnReproducir;


    private MediaRecorder mediaRecorder;
    private MediaPlayer mediaPlayer;
    private final String ruta = Environment.getExternalStorageDirectory ().getAbsolutePath () +
                                File.separator;
    private ContextWrapper cw;
    private String fichero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtvMensajes     = findViewById ( R.id.txtvMensaje );
        edtGuardarComo   = findViewById ( R.id.edtGuardarComo );
        btnGrabar        = findViewById ( R.id.btnGrabar );
        btnDetener       = findViewById ( R.id.btnDetener );
        btnReproducir    = findViewById ( R.id.btnReproducir );

        ChecadorDePermisos.checarPermisos ( this, permisosReq );

        txtvMensajes.setText ( "" );
        btnGrabar.setEnabled ( true );
        btnDetener.setEnabled ( false );
        btnReproducir.setEnabled ( false );

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if ( requestCode == ChecadorDePermisos.CODIGO_PEDIR_PERMISOS )
            ChecadorDePermisos.verificarPermisosSolicitados ( this, permisosReq, permissions, grantResults );
    }

    public void btnGrabarClick (View v ) throws IOException {
        //cw = new ContextWrapper(getApplicationContext());
        fichero = ruta + edtGuardarComo.getText().toString() + ".3gp";
        //File directorio = cw.getExternalFilesDir ( Environment.DIRECTORY_MUSIC );
        //fichero = String.valueOf ( new File ( directorio, edtGuardarComo.getText().toString() + ".3gp") );

        mediaRecorder = new MediaRecorder();
        // Establecer el MICROFONO como fuente de audio
        mediaRecorder.setAudioSource( MediaRecorder.AudioSource.MIC );
        // Establecemos el formato de archivo en 3GP
        mediaRecorder.setOutputFormat ( MediaRecorder.OutputFormat.THREE_GPP );
        // Establecer el codificador de audio
        mediaRecorder.setAudioEncoder ( MediaRecorder.AudioEncoder.AMR_WB );
        // Establecer el archivo de salida de la grabacion
        mediaRecorder.setOutputFile ( fichero );

        try {
            txtvMensajes.setText ( "Grabando..." );
            btnGrabar.setEnabled ( false );
            btnDetener.setEnabled ( true );
            btnReproducir.setEnabled ( false );

            mediaRecorder.prepare ();
            mediaRecorder.start ();
        } catch (IOException e) {
            txtvMensajes.setText ( "" );
            btnGrabar.setEnabled ( true );
            btnDetener.setEnabled ( false );
            btnReproducir.setEnabled ( false );


            Toast.makeText(this, "Fallo al hacer la grabacion", Toast.LENGTH_SHORT).show();
        }
    }

    public void btnDetenerClick ( View v ) {
        txtvMensajes.setText ( "" );
        btnGrabar.setEnabled ( true );
        btnDetener.setEnabled ( false );
        btnReproducir.setEnabled ( true );

        mediaRecorder.stop ();
        mediaRecorder.release ();
    }

    public void btnReproducirClick ( View v ) {
        mediaPlayer = new MediaPlayer ();
        try {
            // Configurar el archivo a reproducir
            mediaPlayer.setDataSource ( fichero );
            mediaPlayer.prepare ();
            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {

                    txtvMensajes.setText ( "Reproduciendo..." );
                    btnGrabar.setEnabled ( false );
                    btnDetener.setEnabled ( false );
                    btnReproducir.setEnabled ( false );

                    mediaPlayer.start ();
                }
            });
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    txtvMensajes.setText ( "" );
                    btnGrabar.setEnabled ( true );
                    btnDetener.setEnabled ( false );
                    btnReproducir.setEnabled ( true );

                    mediaPlayer.release ();
                }
            });

        } catch (IOException e) {
            txtvMensajes.setText ( "" );
            btnGrabar.setEnabled ( true );
            btnDetener.setEnabled ( false );
            btnReproducir.setEnabled ( false );


            Toast.makeText ( this, "Fallo al reproducir el audio.", Toast.LENGTH_SHORT ).show();
        }
    }

    public void btnAcercaDeClick ( View v ) {
        Intent intent = new Intent ( this, AcercaDeActivity.class );
        startActivity ( intent );
    }

}
