package mx.edu.itl.c18131209.elbolaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

public class LeerDatoActivity extends AppCompatActivity {

    LinearLayout layout;
    private EditText edtDato;
    private String llave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leer_dato);

        layout = (LinearLayout) findViewById ( R.id.layoutLogin );
        layout.setOnClickListener ( new ClickLayoutAdaptadora (this ) );

        // Obtener la referencia del EditText en la IU para el dato
        edtDato = findViewById ( R.id.edtDato );

        // Recuperamos el valor del argumento que viene desde loginActivity
        Intent i = getIntent ();
        String dato = i.getStringExtra ( "usuario" );

        if ( dato != null ) {
            edtDato.setText ( dato );
            llave = "usuario";
        } else {
            dato = i.getStringExtra ( "contrasena" );
            edtDato.setText ( dato );
            llave = "contrasena";
        }
    }

    public void btnAceptarClick ( View v ) {

    }

    public void btnCancelarClick ( View v ) {

    }
}