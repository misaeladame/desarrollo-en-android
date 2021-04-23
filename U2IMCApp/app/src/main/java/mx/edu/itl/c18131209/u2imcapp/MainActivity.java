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
:*  16/Abr/2021 Misael Adame         Adaptar la aplicación al idioma inglés
:*
:*  23/Abr/2021 Misael Adame         Uso de los métodos de la clase Log
:*------------------------------------------------------------------------------------------*/

package mx.edu.itl.c18131209.u2imcapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
        edtPeso = findViewById(R.id.edtPeso);
        edtEstatura = findViewById(R.id.edtEstatura);

        // Establecer la referencia del contexto de este Activity en la clase RR
        RR.contexto = this;

    }

    //----------------------------------------------------------------------------------------------

    public void btnCalcularIMCClick(View v) {
        if (edtPeso.getText().toString().isEmpty() || edtEstatura.getText().toString().isEmpty()) {
            mostrarMensajeError ();
        } else {
            determinarCondicion ();
        }
    }

    //----------------------------------------------------------------------------------------------

    public void determinarCondicion () {
        float peso = Float.parseFloat(edtPeso.getText().toString());
        float estatura = Float.parseFloat(edtEstatura.getText().toString());
        float imc = 0;

        Log.d ("JMAS", "estatura = " +estatura );
        Log.d ("JMAS", "peso = " +peso );
        Log.v ("MA", "hola" );

        imc = (float) (peso / Math.pow(estatura, 2));
        if (imc > 0 && imc < 15)
            mostrarMensajeCondicion(imc, RR.s ( R.string.txt_delgadez_muy_severa ) );
        else if (imc >= 15 && imc <= 15.9)
            mostrarMensajeCondicion(imc, RR.s ( R.string.txt_delgadez_severa ) );
        else if (imc >= 16 && imc <= 18.4)
            mostrarMensajeCondicion(imc, RR.s ( R.string.txt_delgadez ) );
        else if (imc >= 18.5 && imc <= 24.9)
            mostrarMensajeCondicion(imc, RR.s ( R.string.txt_peso_saludable ) );
        else if (imc >= 25 && imc <= 29.9)
            mostrarMensajeCondicion(imc, RR.s ( R.string.txt_sobrepeso ) );
        else if (imc >= 30 && imc <= 34.9)
            mostrarMensajeCondicion(imc, RR.s ( R.string.txt_obesidad_moderada ) );
        else if (imc >= 35 && imc <= 39.9)
            mostrarMensajeCondicion(imc, RR.s ( R.string.txt_obesidad_severa ) );
        else if (imc >= 40)
            mostrarMensajeCondicion(imc, RR.s ( R.string.txt_obesidad_muy_severa ) );
        else
            mostrarMensajeError();
    }

    //----------------------------------------------------------------------------------------------

    public void btnAcercaDeClick ( View v ) {
        Intent intent = new Intent ( this, AcercaDeActivity.class );
        startActivity ( intent );
    }

    //----------------------------------------------------------------------------------------------

    public void mostrarMensajeCondicion ( float imc, String condicion ) {
        AlertDialog.Builder builder = new AlertDialog.Builder ( this );
        builder.setTitle ( RR.s ( R.string.txt_imc ) +" "  +imc )
                .setMessage ( RR.s ( R.string.txt_su_condicion_es ) +" " +condicion )
                .setPositiveButton ( RR.s ( R.string.txt_aceptar ) , new DialogInterface.OnClickListener () {
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
        builder.setTitle( RR.s ( R.string.txt_error ) )
                .setMessage ( RR.s ( R.string.txt_numero_positivo ) )
                .setPositiveButton( RR.s ( R.string.txt_aceptar ), new DialogInterface.OnClickListener() {
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