/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                       INSTITUTO TECNOLOGICO DE LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: ENE-JUN/2021    HORA: 10-11 HRS
:*
:*                                Clase GUI Principal
:*
:*  Archivo     : MainActivity.java
:*  Autor       : Jose Misael Adame Sandoval     18131209
:*  Fecha       : 02/May/2021
:*  Compilador  : Android Studio 4.1.2
:*  Descripción : Reproduce imagenes, audios dependiendo del boton usado.
:*                Los botones del MainAnctivity son los siguientes:
:*
:*                •	Rock: Se muestra una imagen de una guitarra
:*                •	Romance: Se muestra una imagen de un atardecer
:*                •	Diplomado Android: Se muestra una iamgen de un equipo de sonido
:*                •	Party: Se reproduce una canción de rock en inglés
:*                •	Spotify: Invoca al ConciertoActivity
:*
:*                - Además hay un horizontalScrollView en el cual contiene distintas
:*                  imágenes de bandas de rock.
:*
:*  Ultima modif:
:*  Fecha       Modificó             Motivo
:*==========================================================================================
:*
:*------------------------------------------------------------------------------------------*/

package mx.edu.itl.c18131209.elbolaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {

    private Button btnFiesta;
    private MediaPlayer mediaPlayer = null;

    //----------------------------------------------------------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Asignar la referencia del boton de la party
        btnFiesta = findViewById ( R.id.btnFiesta );
        // Registrar este activity como listener de los eventos Touch del boton Party
        btnFiesta.setOnTouchListener ( this );
        // Establecer el canal de audio para reproducción de música
        setVolumeControlStream ( AudioManager.STREAM_MUSIC );

    }

    //----------------------------------------------------------------------------------------------

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent ) {
        if ( view.getId() == R.id.btnFiesta ) {
            switch ( motionEvent.getAction () ) {
                case MotionEvent.ACTION_DOWN : reproducir_audio ();  break;
                case MotionEvent.ACTION_UP   : detener_audio ();  break;

            }
            return true;
        }

        return false;
    }

    //----------------------------------------------------------------------------------------------

    private void reproducir_audio () {
        if ( mediaPlayer == null ) {
            mediaPlayer = MediaPlayer.create ( this, R.raw.la_muralla_verde );
        }
        mediaPlayer.start ();
    }

    //----------------------------------------------------------------------------------------------

    private void detener_audio () {
        if ( mediaPlayer != null ) {
            mediaPlayer.stop ();
            mediaPlayer = null;
        }
    }

    //----------------------------------------------------------------------------------------------

    public void btnSpotifyClick ( View v ) {
        Intent intent = new Intent( this, ConciertoActivity.class );
        startActivity ( intent );
    }

    //----------------------------------------------------------------------------------------------

}