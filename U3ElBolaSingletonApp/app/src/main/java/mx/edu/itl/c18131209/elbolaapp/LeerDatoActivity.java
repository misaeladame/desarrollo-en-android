package mx.edu.itl.c18131209.elbolaapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

public class LeerDatoActivity extends AppCompatActivity {

    ConstraintLayout layout;
    private EditText edtDato;
    private String llave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leer_dato);

        layout = findViewById ( R.id.layoutLeerDato );
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
        // Establecemos el valor del resultado que se devolvera a LoginActivity
        Intent intent = getIntent ();
        intent.putExtra ( "dato_nuevo", edtDato.getText ().toString () );
        setResult ( RESULT_OK, intent );
        finish ();
    }

    public void btnCancelarClick ( View v ) {
        setResult ( RESULT_CANCELED );
        finish ();
    }
}