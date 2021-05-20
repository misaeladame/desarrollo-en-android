package mx.edu.itl.c85360673.u4intentsimplicitosapp;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;

public class FotoActivity extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foto);

        // Se recupera el argumento con la uri de la foto a mostrar
        String uri = getIntent ().getStringExtra  ("uri" );

        // Se muestra la foto
        imageView = findViewById ( R.id.imageView );
        imageView.setImageURI ( Uri.parse ( uri ) );
    }
}
