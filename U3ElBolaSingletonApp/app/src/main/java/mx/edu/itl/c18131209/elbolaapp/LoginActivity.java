package mx.edu.itl.c18131209.elbolaapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

public class LoginActivity extends AppCompatActivity {

    LinearLayout layout;

    public static final int CODIGO_USUARIO = 10;
    public static final int CODIGO_CONTRASENA = 20;

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
        // Establecemos el dato que se traspasara al segundo activity en el Singleton
        MiSingleton.getInstancia ().setUsuario ( edtUsuario.getText ().toString () );
        MiSingleton.getInstancia ().setCodigoLogin ( CODIGO_USUARIO );
        startActivityForResult ( intent, CODIGO_USUARIO );
    }

    public void btnContrasenaClick ( View v ) {
        Intent intent = new Intent ( this, LeerDatoActivity.class );
        // Establecemos el dato que se traspasara al segundo activity en el Singleton
        MiSingleton.getInstancia ().setContrasena ( edtContrasena.getText ().toString () );
        MiSingleton.getInstancia ().setCodigoLogin ( CODIGO_CONTRASENA );
        startActivityForResult ( intent, CODIGO_CONTRASENA );
    }

    @Override
    protected void onActivityResult ( int requestCode, int resultCode, @Nullable Intent data ) {
        super.onActivityResult ( requestCode, resultCode, data );
        // verificar el estado del resultado devuelto por LeerDatoActivity
        if ( resultCode == RESULT_OK ) {
            if ( requestCode == CODIGO_USUARIO ) {
                edtUsuario.setText ( MiSingleton.getInstancia ().getUsuario () );
            } else if ( requestCode == CODIGO_CONTRASENA ) {
                edtContrasena.setText (  MiSingleton.getInstancia ().getContrasena () );
            }
        } else if ( resultCode == RESULT_CANCELED ) {
            // Hacer algo si se cancela la captura del dato nuevo
        }
    }
}