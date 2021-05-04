package mx.edu.itl.c18131209.elbolaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class ConciertoActivity extends AppCompatActivity {

    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_concierto);

        // Configuremos el objeto VideoView para la reproducción del video
        videoView = findViewById ( R.id.videoView );

        String uriPath = "android.resource://" + getPackageName () +"/" + R.raw.la_pachanga;
        Uri uri = Uri.parse ( uriPath );
        videoView.setVideoURI ( uri );
        videoView.setMediaController ( new MediaController( this ) );
        videoView.requestFocus ();
        videoView.start ();
    }
}