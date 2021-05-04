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

    private void reproducir_audio () {
        if ( mediaPlayer == null ) {
            mediaPlayer = MediaPlayer.create ( this, R.raw.tropicalisimo );
        }
        mediaPlayer.start ();
    }

    private void detener_audio () {
        if ( mediaPlayer != null ) {
            mediaPlayer.stop ();
            mediaPlayer = null;
        }
    }

    public void btnSpotifyClick ( View v ) {
        Intent intent = new Intent( this, ConciertoActivity.class );
        startActivity ( intent );
    }
}