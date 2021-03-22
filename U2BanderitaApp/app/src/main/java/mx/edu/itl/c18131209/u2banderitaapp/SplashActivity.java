package mx.edu.itl.c18131209.u2banderitaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        // Pasar a la pantalla principal despues de 5 segs
        new Handler ().postDelayed ( new Runnable () {
            @Override
            public void run () {
                Intent intent = new Intent( SplashActivity.this,  MainActivity.class );
                startActivity ( intent );
                finish ();
            }
        }, 5000 );
    }
}