/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                       INSTITUTO TECNOLOGICO DE LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: ENE-JUN/2021    HORA: 10-11 HRS
:*
:*             Main que nos deja crear un xml para utilizarlo como pantalla de carga
:*
:*  Archivo     : SplashActivity.java
:*  Autor       : Jose Misael Adame Sandoval     18131209
:*                Cristian Barajas Cabrales      17130764
:*                Salma Lizeth Mazuca Reyna      17130801
:*                Cristian Gabriel Piña Rosales  18130588
:*  Fecha       : 25/06/2021
:*  Compilador  : Android Studio 4.0.1
:*  Descripcion : Main que nos permite utilizar su respectivo xml para aplicarlo en la aplicacion
:*                para dar una pantalla de carga
:*  Ultima modif:
:*  Fecha       Modificacion             Motivo
:*==========================================================================================
:*  dd/mmm/aaaa Fulanito de tal       Motivo de la modificacion, puede ser en mas de 1 renglon.
:*------------------------------------------------------------------------------------------*/

package mx.edu.itl.equipo9.proyfinalasistenciasapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import mx.edu.itl.equipo9.proyfinalasistenciasapp.R;

public class SplashActivity extends AppCompatActivity {

    //----------------------------------------------------------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Hacer la transicion al loginActivity despues de 3 segundos
        new Handler ().postDelayed ( new Runnable () {
            @Override
            public void run () {
                Intent intent = new Intent( SplashActivity.this,  MainActivity.class );
                startActivity ( intent );
                finish ();
            }
        }, 3000 );
    }

    //----------------------------------------------------------------------------------------------

}