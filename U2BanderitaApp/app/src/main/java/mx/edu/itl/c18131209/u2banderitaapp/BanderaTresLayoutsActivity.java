package mx.edu.itl.c18131209.u2banderitaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class BanderaTresLayoutsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verde);
    }

    public void cambiarSeccion ( View v ) {
        switch ( v.getId() ) {
            case R.id.btnVerdeSiguiente  : setContentView ( R.layout.activity_blanco);
                break;
            case R.id.btnVerdeAtras      : finish ();
                break;
            case R.id.btnBlancoSiguiente : setContentView ( R.layout.activity_rojo );
                break;
            case R.id.btnBlancoAtras     : setContentView ( R.layout.activity_verde );
                break;
            case R.id.btnRojoAtras       : setContentView ( R.layout.activity_blanco );
                break;
        }
    }
}