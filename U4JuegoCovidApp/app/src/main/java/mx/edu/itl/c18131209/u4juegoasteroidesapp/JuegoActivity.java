/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                       INSTITUTO TECNOLOGICO DE LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: ENE-JUN/2021    HORA: 10-11 HRS
:*
:*                          Clase principal del juego
:*
:*  Archivo     : JuegoActivity.java
:*  Autor       : Jose Misael Adame Sandoval     18131209
:*  Fecha       : 30/May/2021
:*  Compilador  : Android Studio 4.1.2
:*  Descripción : Clase que realiza las principales acciones del juego, es decir,
:*                es lo que se ejecuta cuando se abre, se pone en pausa y cuando
:*                se cierra el juego.
:*
:*  Ultima modif:
:*  Fecha       Modificó             Motivo
:*==========================================================================================
:*
:*------------------------------------------------------------------------------------------*/

package mx.edu.itl.c18131209.u4juegoasteroidesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;

public class JuegoActivity extends AppCompatActivity {

    private VistaJuegoView vistaJuegoView;
    private MediaPlayer mplayAudioFondo;
    private MediaPlayer mplayAudioDisparo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.juego_layout);

        this.setVolumeControlStream ( AudioManager.STREAM_MUSIC );

        vistaJuegoView = findViewById ( R.id.vistaJuegoView );

        mplayAudioFondo = MediaPlayer.create ( this, R.raw.audio_fondo );
        mplayAudioFondo.setLooping ( true );

        mplayAudioDisparo = MediaPlayer.create ( this, R.raw.audio_disparo );
        vistaJuegoView.setAudioDisparo ( mplayAudioDisparo );

    }

    @Override
    protected void onResume() {
        super.onResume();
        if ( mplayAudioFondo != null )
            mplayAudioFondo.start ();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if ( mplayAudioFondo != null )
            mplayAudioFondo.pause ();
    }

    @Override
    protected void onDestroy() {

        if ( mplayAudioFondo != null )
            mplayAudioFondo.stop ();
        if ( mplayAudioDisparo != null )
            mplayAudioDisparo.stop ();


        vistaJuegoView.setCorriendo( false );
        VistaJuegoThread hilo = vistaJuegoView.getVistaJuegoThread();
        try {
            hilo.join();
        } catch (InterruptedException e) {
            Log.e ( "Asteroides", e.toString() );
        }
        super.onDestroy();
    }
}