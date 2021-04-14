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
:*  Archivo     : BlancoActivity.java
:*  Autor       : Jose Misael Adame Sandoval     18131209
:*  Fecha       : 23/Mar/2021
:*  Compilador  : Android Studio 4.1.2
:*  Descripción : Clase que muestra la porción del color blanco y el escudo de la
:*                bandera de México
:*
:*  Ultima modif:
:*  Fecha       Modificó             Motivo
:*==========================================================================================
:*  13/Abr/2021 Misael Adame         Se agregaron métodos del Activity Lifecicle
:*------------------------------------------------------------------------------------------*/

package mx.edu.itl.c18131209.u2banderitaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class BlancoActivity extends AppCompatActivity {

    //----------------------------------------------------------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView ( R.layout.activity_blanco );
        Toast.makeText( this, "Blanco: onCreate", Toast.LENGTH_SHORT ).show ();
    }

    //----------------------------------------------------------------------------------------------

    public void cambiarSeccion ( View v ) {
        if ( v.getId() == R.id.btnBlancoSiguiente ) {
            // Invocamos el activity de la seccion Rojo
            Intent intent = new Intent ( this, RojoActivity.class );
            startActivity ( intent );
        } else if ( v.getId() == R.id.btnBlancoAtras ) {
            // Finalizamos este activity
            finish ();
        }
    }

    //----------------------------------------------------------------------------------------------

    @Override
    public void onStart () {
        super.onStart ();
        Toast.makeText( this, "Blanco: onStart", Toast.LENGTH_SHORT ).show ();
    }

    //----------------------------------------------------------------------------------------------

    @Override
    public void onResume () {
        super.onResume ();
        Toast.makeText( this, "Blanco: onResume", Toast.LENGTH_SHORT ).show ();
    }

    //----------------------------------------------------------------------------------------------

    @Override
    public void onPause () {
        super.onPause ();
        Toast.makeText( this, "Blanco: onPause", Toast.LENGTH_SHORT ).show ();
    }

    //----------------------------------------------------------------------------------------------

    @Override
    public void onStop () {
        super.onStop ();
        Toast.makeText( this, "Blanco: onStop", Toast.LENGTH_SHORT ).show ();
    }

    //----------------------------------------------------------------------------------------------

    @Override
    public void onDestroy () {
        super.onDestroy ();
        Toast.makeText( this, "Blanco: onDestroy", Toast.LENGTH_SHORT ).show ();
    }

    //----------------------------------------------------------------------------------------------

    @Override
    public void onRestart () {
        super.onRestart ();
        Toast.makeText( this, "Blanco: onRestart", Toast.LENGTH_SHORT ).show ();
    }

    //----------------------------------------------------------------------------------------------
}