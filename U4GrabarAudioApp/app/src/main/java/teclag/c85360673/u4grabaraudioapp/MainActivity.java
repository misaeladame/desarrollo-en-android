package teclag.c85360673.u4grabaraudioapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
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
    private String ruta = Environment.getExternalStorageDirectory ().getAbsolutePath () +
                          File.separator;
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

    public void btnGrabarClick (View v ) {
        fichero = ruta + edtGuardarComo.getText().toString() + ".3gp";

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
