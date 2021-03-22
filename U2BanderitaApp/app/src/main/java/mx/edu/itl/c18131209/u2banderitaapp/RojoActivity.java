package mx.edu.itl.c18131209.u2banderitaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class RojoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView ( R.layout.activity_rojo );
    }

    public void cambiarSeccion ( View v ) {
        if ( v.getId() == R.id.btnRojoAtras ) {
            // Finalizamos este activity
            finish ();
        }
    }
}