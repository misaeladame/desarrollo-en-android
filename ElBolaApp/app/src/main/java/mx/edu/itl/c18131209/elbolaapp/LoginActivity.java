package mx.edu.itl.c18131209.elbolaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

public class LoginActivity extends AppCompatActivity {

    LinearLayout layout;
    private EditText edtUsuario;
    private EditText edtContrasena;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        layout = (LinearLayout) findViewById ( R.id.layoutLogin );
        layout.setOnClickListener ( new ClickLayoutAdaptadora (this ) );

        // Asignamos las referencias a los EditText en la IU
        edtUsuario  = findViewById ( R.id.edtUsuario );
        edtContrasena = findViewById ( R.id.edtContrasena );
    }

    public void btnEntrarClick ( View v ) {
        String usuario = edtUsuario.getText().toString();
        String contrasena = edtContrasena.getText().toString();

        if ( usuario.equals ( "admin" ) && contrasena.equals ( "android" ) ) {
            Intent intent = new Intent ( this, MainActivity.class );
            startActivity ( intent );
        } else {
            if ( ! usuario.equals ( "admin" ) ) {
                edtUsuario.setError ( "Usuario incorrecto" );
            } else {
                edtContrasena.setError ( "Contraseña incorrecta" );
            }
        }
    }

    public void btnUsuarioClick ( View v ) {
        Intent intent = new Intent ( this, LeerDatoActivity.class );
        // Establecemos el dato que se traspasara al segundo activity
        intent.putExtra ( "usuario", edtUsuario.getText().toString() );
        startActivity ( intent );
    }

    public void btnContrasenaClick ( View v ) {
        Intent intent = new Intent ( this, LeerDatoActivity.class );
        // Establecemos el dato que se traspasara al segundo activity
        intent.putExtra ( "contrasena", edtUsuario.getText().toString() );
        startActivity ( intent );
    }
}