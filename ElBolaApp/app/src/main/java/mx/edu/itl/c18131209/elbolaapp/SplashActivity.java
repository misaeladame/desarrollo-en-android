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
:*  Fecha       : 20/Abr/2021
:*  Compilador  : Android Studio 4.1.2
:*  Descripción : Clase que hace de Splash en el que invoca a la pantalla del login
:*                de la aplicacion (LoginActivity.java)
:*
:*  Ultima modif:
:*  Fecha       Modificó             Motivo
:*==========================================================================================
:*
:*------------------------------------------------------------------------------------------*/

package mx.edu.itl.c18131209.elbolaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Hacer la transicion al loginActivity despues de 3 segundos
        new Handler ().postDelayed ( new Runnable () {
            @Override
            public void run () {
                Intent intent = new Intent( mx.edu.itl.c18131209.elbolaapp.SplashActivity.this,  LoginActivity.class );
                startActivity ( intent );
                finish ();
            }
        }, 3000 );
    }
}