package mx.edu.itl.c18131209.u2banderitaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnUnActivityUnLayoutClick ( View v ) {
        // Invocamos la ejecucion del activity BanderaCompletaActivity
        Intent intent = new Intent ( this,  BanderaCompletaActivity.class );
        startActivity ( intent );
    }

    public void btnUnActivityTresLayoutsClick ( View v ) {
        // Invocar la ejecucion del activity BanderaTresLayoutsActivity
        Intent intent = new Intent ( this, BanderaTresLayoutsActivity.class );
        startActivity ( intent );

    }

    public void btnTresActivityTresLayoutsClick ( View v ) {
        // Invocar la ejecucion del activity VerdeAActivity
        Intent intent = new Intent ( this, VerdeActivity.class );
        startActivity ( intent );
    }

    public void btnAcercaDeClick ( View v ) {
        Intent intent = new Intent ( this, AcercaDeActivity.class );
        startActivity ( intent );
    }

}