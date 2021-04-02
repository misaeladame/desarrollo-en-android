/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                       INSTITUTO TECNOLOGICO DE LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: ENE-JUN/2021    HORA: 10-11 HRS
:*
:*                          Clase que calcula el IMC
:*
:*  Archivo     : MainActivity.java
:*  Autor       : Jose Misael Adame Sandoval     18131209
:*  Fecha       : 25/Mar/2021
:*  Compilador  : Android Studio 4.1.2
:*  Descripción : Muestra mediante un AlertDialog el resultado del calculo del IMC usando
:*               la fórmula:
:*                   IMC = masa / estatura^2
:*               Los botones del MainAnctivity son los siguientes:
:*
:*                •	Calcular IMC
:*                •	Acerca De...
:*
:*  Ultima modif:
:*  Fecha       Modificó             Motivo
:*==========================================================================================
:*
:*------------------------------------------------------------------------------------------*/

package mx.edu.itl.c18131209.u2imcapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private EditText edtPeso;
    private EditText edtEstatura;

    //----------------------------------------------------------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Obtenemos las referencias a los editText de la interfaz de usuario
        edtPeso = findViewById( R.id.edtPeso );
        edtEstatura = findViewById( R.id.edtEstatura );
    }

    //----------------------------------------------------------------------------------------------

    public void btnCalcularIMCClick ( View v ) {

        if ( edtPeso.getText().toString().isEmpty() || edtEstatura.getText().toString().isEmpty() ) {
            mostrarMensajeError ();
        } else {
            float peso = Float.parseFloat ( edtPeso.getText ().toString () );
            float estatura = Float.parseFloat ( edtEstatura.getText ().toString () );
            float imc = 0;

            imc = (float) ( peso / Math.pow ( estatura, 2) );
            if ( imc > 0 && imc < 15 )
                mostrarMensajeCondicion ( imc, "Delgadez muy severa" );
            else if ( imc >= 15 && imc <= 15.9 )
                mostrarMensajeCondicion ( imc, "Delgadez Severa");
            else if ( imc >= 16 && imc <= 18.4 )
                mostrarMensajeCondicion ( imc, "Delgadez");
            else if ( imc >= 18.5 && imc <= 24.9)
                mostrarMensajeCondicion ( imc, "Peso Saludable");
            else if ( imc >= 25 && imc <= 29.9 )
                mostrarMensajeCondicion ( imc, "Sobrepeso");
            else if ( imc >= 30 && imc <= 34.9 )
                mostrarMensajeCondicion ( imc, "Obesidad Moderada");
            else if ( imc >= 35 && imc <= 39.9 )
                mostrarMensajeCondicion ( imc, "Obesidad severa");
            else if ( imc >= 40 )
                mostrarMensajeCondicion ( imc, "Obesidad muy severa (obesidad morbida)");
            else
                mostrarMensajeError();
        }
    }

    //----------------------------------------------------------------------------------------------

    public void btnAcercaDeClick ( View v ) {
        Intent intent = new Intent ( this, AcercaDeActivity.class );
        startActivity ( intent );
    }

    //----------------------------------------------------------------------------------------------

    public void mostrarMensajeCondicion ( float imc, String condicion ) {
        AlertDialog.Builder builder = new AlertDialog.Builder ( this );
        builder.setTitle ( "IMC = " +imc )
                .setMessage ( "Su condicion de salud es: " +condicion )
                .setPositiveButton ( "Aceptar", new DialogInterface.OnClickListener () {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss ();
                    }
                } )
                .create ()
                .show ();
    }

    //----------------------------------------------------------------------------------------------

    public void mostrarMensajeError () {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Error")
                .setMessage ( "Ingrese un numero positivo" )
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                })
                .create()
                .show();
    }

    //----------------------------------------------------------------------------------------------

}