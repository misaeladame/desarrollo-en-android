package mx.edu.itl.c85360673.u3listview;

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


    public void btnListaSencillaClick ( View v ) {
        Intent intent  = new Intent ( this, ListaSencillaActivity.class );
        startActivity ( intent );
    }

    public void btnListaTextoImagenClick ( View v ) {
        Intent intent  = new Intent ( this, ListaTextoImagenActivity.class );
        startActivity ( intent );
    }

    public void btnListaConCheckboxesClick ( View v ) {
        Intent intent  = new Intent ( this, ListaConCheckboxesActivity.class );
        startActivity ( intent );
    }
	
}
