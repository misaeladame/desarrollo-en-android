package mx.edu.itl.ctl85360673.almacenintextapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnAlmacenIntClick ( View v ) {
        Intent intent = new Intent ( this, AlmacenInternoActivity.class );
        startActivity ( intent );
    }

    public void btnAlmacenExtClick ( View v ) {
        Intent intent = new Intent ( this, AlmacenExternoActivity.class );
        startActivity ( intent );

    }
}
