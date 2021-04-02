/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                       INSTITUTO TECNOLOGICO DE LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: ENE-JUN/2021    HORA: 10-11 HRS
:*
:*               Clase que despliega una parte de la bandera de Mexico
:*
:*  Archivo     : VerdeActivity.java
:*  Autor       : Jose Misael Adame Sandoval     18131209
:*  Fecha       : 23/Mar/2021
:*  Compilador  : Android Studio 4.1.2
:*  Descripción : Clase que muestra la porción del color verde de la bandera
:*                de México
:*
:*  Ultima modif:
:*  Fecha       Modificó             Motivo
:*==========================================================================================
:*
:*------------------------------------------------------------------------------------------*/

package mx.edu.itl.c18131209.u2banderitaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class VerdeActivity extends AppCompatActivity {

    //----------------------------------------------------------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView ( R.layout.activity_verde );
    }

    //----------------------------------------------------------------------------------------------

    public void cambiarSeccion ( View v ) {
        if ( v.getId() == R.id.btnVerdeSiguiente ) {
            // Invocar al activity de la seccion blanco de la bandera
            Intent intent = new Intent ( this, BlancoActivity.class );
            startActivity ( intent );
        } else if ( v.getId() == R.id.btnVerdeAtras ) {
            // Finalizamos la ejecucion de este activity
            finish ();
        }
    }

    //----------------------------------------------------------------------------------------------

}