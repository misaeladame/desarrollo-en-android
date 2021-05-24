/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                       INSTITUTO TECNOLOGICO DE LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: ENE-JUN/2021    HORA: 10-11 HRS
:*
:*                          Clase principal de la app
:*
:*  Archivo     : MainActivity.java
:*  Autor       : Jose Misael Adame Sandoval     18131209
:*  Fecha       : 24/May/2021
:*  Compilador  : Android Studio 4.1.2
:*  Descripción : Clase que permite enviar un mensaje SMS a otro
:*                telefono celular
:*
:*  Ultima modif:
:*  Fecha       Modificó             Motivo
:*==========================================================================================
:*
:*------------------------------------------------------------------------------------------*/

package mx.edu.itl.c85360673.u4smsenvioapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import mx.edu.itl.c18131209.androidlib.util.permisos.ChecadorDePermisos;
import mx.edu.itl.c18131209.androidlib.util.permisos.PermisoApp;


public class MainActivity extends AppCompatActivity {
    private EditText      edtTelefonoDestino;
    private EditText      edtMensaje;

    private PermisoApp [] permisosReq = new PermisoApp [] {
            new PermisoApp ( Manifest.permission.SEND_SMS, "SMS", true ),
            new PermisoApp ( Manifest.permission.CALL_PHONE, "Telefono", false ),
            new PermisoApp ( Manifest.permission.READ_EXTERNAL_STORAGE, "Almacenamiento", false )
    };

    //----------------------------------------------------------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtTelefonoDestino = findViewById(R.id.edtTelefonoDestino);
        edtMensaje = findViewById(R.id.edtMensaje);

        ChecadorDePermisos.checarPermisos ( this, permisosReq );
    }

    //----------------------------------------------------------------------------------------------


    @Override
    public void onRequestPermissionsResult(
            int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults ) {
        if ( requestCode == ChecadorDePermisos.CODIGO_PEDIR_PERMISOS ) {
            ChecadorDePermisos.verificarPermisosSolicitados ( this, permisosReq, permissions, grantResults );
        }

    }

    public void btnVerPermisosClick ( View v ) {

    }

    //----------------------------------------------------------------------------------------------

    public void btnEnviarClick (View v ) {
        if ( validarDatos () == false )
            return;

        SmsManager smsMgr = SmsManager.getDefault();
        smsMgr.sendTextMessage (
                edtTelefonoDestino.getText().toString(),
                null,
                edtMensaje.getText().toString(),
                null,
                null
        );

        Toast.makeText (this, "SMS enviado",
                         Toast.LENGTH_SHORT ).show();
        edtMensaje.setText ( "" );
    }

    //----------------------------------------------------------------------------------------------

    private boolean validarDatos () {
        if ( edtTelefonoDestino.getText().toString().isEmpty() ) {
            edtTelefonoDestino.setError ( "Telefono no puede ser vacio" );
            return false;
        }

        if ( edtMensaje.getText().toString().isEmpty() ) {
            edtMensaje.setError ( "Proporcione un mensaje a enviar" );
            return false;
        }
        return true;
    }

    //----------------------------------------------------------------------------------------------

    public void btnAcercaDeClick ( View v ) {
        Intent intent = new Intent ( this, AcercaDeActivity.class );
        startActivity ( intent );
    }
}
