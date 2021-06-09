package mx.edu.itl.c18131209.u5preferenciasapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnAbrirPreferenciasClick ( View v ) {
        Intent intent = new Intent ( this, PreferenciasActivity.class );
        startActivity ( intent );
    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences pref = getSharedPreferences ( "mx.edu.itl.c18131209.u5preferenciasapp_preferences", MODE_PRIVATE );

        if ( pref != null  ) {
            boolean reprodMusica = pref.getBoolean ( "reproducir_musica", false );
        }

    }
}