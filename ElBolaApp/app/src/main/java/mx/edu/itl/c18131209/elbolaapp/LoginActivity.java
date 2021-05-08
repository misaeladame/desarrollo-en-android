/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                       INSTITUTO TECNOLOGICO DE LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: ENE-JUN/2021    HORA: 10-11 HRS
:*
:*                                 Clase GUI Login
:*
:*  Archivo     : LoginActivity.java
:*  Autor       : Jose Misael Adame Sandoval     18131209
:*  Fecha       : 02/May/2021
:*  Compilador  : Android Studio 4.1.2
:*  Descripción : Clase que realiza la función de Login para acceder a las funciones
:*                principales de la aplicación.
:*
:*  Ultima modif:
:*  Fecha       Modificó             Motivo
:*==========================================================================================
:*
:*------------------------------------------------------------------------------------------*/

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

    //----------------------------------------------------------------------------------------------

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

    //----------------------------------------------------------------------------------------------

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

    //----------------------------------------------------------------------------------------------

    public void btnUsuarioClick ( View v ) {
        Intent intent = new Intent ( this, LeerDatoActivity.class );
        // Establecemos el dato que se traspasara al segundo activity
        intent.putExtra ( "usuario", edtUsuario.getText().toString() );
        startActivityForResult ( intent, CODIGO_USUARIO );
    }

    //----------------------------------------------------------------------------------------------

    public void btnContrasenaClick ( View v ) {
        Intent intent = new Intent ( this, LeerDatoActivity.class );
        // Establecemos el dato que se traspasara al segundo activity
        intent.putExtra ( "contrasena", edtContrasena.getText().toString() );
        startActivityForResult ( intent, CODIGO_CONTRASENA );
    }

    //----------------------------------------------------------------------------------------------

    public void btnAcercaDeClick ( View v ) {
        Intent intent = new Intent ( this, AcercaDeActivity.class );
        startActivity ( intent );
    }

    //----------------------------------------------------------------------------------------------

    @Override
    protected void onActivityResult ( int requestCode, int resultCode, @Nullable Intent data ) {
        super.onActivityResult ( requestCode, resultCode, data );
        // verificar el estado del resultado devuelto por LeerDatoActivity
        if ( resultCode == RESULT_OK ) {
            if ( requestCode == CODIGO_USUARIO ) {
                edtUsuario.setText ( data.getStringExtra ( "dato_nuevo" ) );
            } else if ( requestCode == CODIGO_CONTRASENA ) {
                edtContrasena.setText ( data.getStringExtra ( "dato_nuevo" ) );
            }
        } else if ( resultCode == RESULT_CANCELED ) {
            // Hacer algo si se cancela la captura del dato nuevo
        }
    }

    //----------------------------------------------------------------------------------------------

}