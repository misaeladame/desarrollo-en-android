/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                       INSTITUTO TECNOLOGICO DE LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: ENE-JUN/2021    HORA: 10-11 HRS
:*
:*          Clase que despliega la bandera de Mexico
:*
:*  Archivo     : MainActivity.java
:*  Autor       : Jose Misael Adame Sandoval     18131209
:*  Fecha       : 16/Mar/2021
:*  Compilador  : Android Studio 4.1.2
:*  Descripción : Los botones para desplegar a la Bandera de Mexico que son los siguientes:
:*
:*                •	Banderita 1 Activity - 1 Layout
:*                •	Banderita 1 Activity - 3 Layout
:*                •	Banderita 3 Activity - 3 Layout
:*                •	Acerca De...
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

public class MainActivity extends AppCompatActivity {

    //----------------------------------------------------------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //----------------------------------------------------------------------------------------------

    public void btnUnActivityUnLayoutClick ( View v ) {
        // Invocamos la ejecucion del activity BanderaCompletaActivity
        Intent intent = new Intent ( this,  BanderaCompletaActivity.class );
        startActivity ( intent );
    }

    //----------------------------------------------------------------------------------------------

    public void btnUnActivityTresLayoutsClick ( View v ) {
        // Invocar la ejecucion del activity BanderaTresLayoutsActivity
        Intent intent = new Intent ( this, BanderaTresLayoutsActivity.class );
        startActivity ( intent );

    }

    //----------------------------------------------------------------------------------------------

    public void btnTresActivityTresLayoutsClick ( View v ) {
        // Invocar la ejecucion del activity VerdeAActivity
        Intent intent = new Intent ( this, VerdeActivity.class );
        startActivity ( intent );
    }

    //----------------------------------------------------------------------------------------------

    public void btnAcercaDeClick ( View v ) {
        Intent intent = new Intent ( this, AcercaDeActivity.class );
        startActivity ( intent );
    }

    //----------------------------------------------------------------------------------------------

}