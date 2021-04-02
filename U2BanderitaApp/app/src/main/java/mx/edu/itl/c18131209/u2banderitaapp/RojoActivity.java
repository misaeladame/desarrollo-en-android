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
:*  Archivo     : RojoActivity.java
:*  Autor       : Jose Misael Adame Sandoval     18131209
:*  Fecha       : 23/Mar/2021
:*  Compilador  : Android Studio 4.1.2
:*  Descripción : Clase que muestra la porción del color rojo de la bandera
:*                de México
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

public class RojoActivity extends AppCompatActivity {

    //----------------------------------------------------------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView ( R.layout.activity_rojo );
    }

    //----------------------------------------------------------------------------------------------

    public void cambiarSeccion ( View v ) {
        if ( v.getId() == R.id.btnRojoAtras ) {
            // Finalizamos este activity
            finish ();
        }
    }

    //----------------------------------------------------------------------------------------------

}