/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                       INSTITUTO TECNOLOGICO DE LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: ENE-JUN/2021    HORA: 10-11 HRS
:*
:*                                Clase GUI Splash
:*
:*  Archivo     : SplashActivity.java
:*  Autor       : Jose Misael Adame Sandoval     18131209
:*  Fecha       : 23/Mar/2021
:*  Compilador  : Android Studio 4.1.2
:*  Descripción : Clase que hace de Splash en el que invoca a la pantalla principal
:*                de la aplicacion (MainActivity.java)
:*
:*  Ultima modif:
:*  Fecha       Modificó             Motivo
:*==========================================================================================
:*
:*------------------------------------------------------------------------------------------*/

package mx.edu.itl.c18131209.u2imcapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    //----------------------------------------------------------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        // Pasar a la pantalla principal despues de 2 segs
        new Handler ().postDelayed ( new Runnable () {
            @Override
            public void run () {
                Intent intent = new Intent( mx.edu.itl.c18131209.u2imcapp.SplashActivity.this,  MainActivity.class );
                startActivity ( intent );
                finish ();
            }
        }, 2000 );
    }

    //----------------------------------------------------------------------------------------------

}