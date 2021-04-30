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
        if ( MiSingleton.getInstancia().getCodigoLogin() == LoginActivity.CODIGO_USUARIO )
            edtDato.setText ( MiSingleton.getInstancia().getUsuario() );
        else if ( MiSingleton.getInstancia().getCodigoLogin() == LoginActivity.CODIGO_CONTRASENA )
            edtDato.setText ( MiSingleton.getInstancia().getContrasena() );
    }

    public void btnAceptarClick ( View v ) {
        // Establecemos el valor del resultado en el Singleton que se devolvera a LoginActivity
        if ( MiSingleton.getInstancia().getCodigoLogin() == LoginActivity.CODIGO_USUARIO )
            MiSingleton.getInstancia ().setUsuario ( edtDato.getText ().toString () );
        else if ( MiSingleton.getInstancia().getCodigoLogin() == LoginActivity.CODIGO_CONTRASENA )
            MiSingleton.getInstancia ().setContrasena ( edtDato.getText ().toString () );

        setResult ( RESULT_OK );
        finish ();
    }

    public void btnCancelarClick ( View v ) {
        setResult ( RESULT_CANCELED );
        finish ();
    }
}