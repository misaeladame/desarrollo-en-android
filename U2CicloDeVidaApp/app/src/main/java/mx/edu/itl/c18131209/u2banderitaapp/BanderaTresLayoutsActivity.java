/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                       INSTITUTO TECNOLOGICO DE LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: ENE-JUN/2021    HORA: 10-11 HRS
:*
:*                       Clase que despliega la bandera de Mexico
:*
:*  Archivo     : BanderaTresLayoutsActivity.java
:*  Autor       : Jose Misael Adame Sandoval     18131209
:*  Fecha       : 23/Mar/2021
:*  Compilador  : Android Studio 4.1.2
:*  Descripción : Clase que muestra la bandera de México en tres partes con en un activity
:*                y tres layouts.
:*
:*  Ultima modif:
:*  Fecha       Modificó             Motivo
:*==========================================================================================
:*
:*------------------------------------------------------------------------------------------*/

package mx.edu.itl.c18131209.u2banderitaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class BanderaTresLayoutsActivity extends AppCompatActivity {

    //----------------------------------------------------------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verde);
    }

    //----------------------------------------------------------------------------------------------

    public void cambiarSeccion ( View v ) {
        switch ( v.getId() ) {
            case R.id.btnVerdeSiguiente  : setContentView ( R.layout.activity_blanco);
                break;
            case R.id.btnVerdeAtras      : finish ();
                break;
            case R.id.btnBlancoSiguiente : setContentView ( R.layout.activity_rojo );
                break;
            case R.id.btnBlancoAtras     : setContentView ( R.layout.activity_verde );
                break;
            case R.id.btnRojoAtras       : setContentView ( R.layout.activity_blanco );
                break;
        }
    }

    //----------------------------------------------------------------------------------------------

}