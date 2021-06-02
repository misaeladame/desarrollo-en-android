/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                       INSTITUTO TECNOLOGICO DE LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: ENE-JUN/2021    HORA: 10-11 HRS
:*
:*                           Clase usando el acelerometro
:*
:*  Archivo     : AcelerometroActivity.java
:*  Autor       : Jose Misael Adame Sandoval     18131209
:*  Fecha       : 01/Jun/2021
:*  Compilador  : Android Studio 4.1.2
:*  Descripción : Clase que permite manipular la pelota usando el acelerometro
:*                del dispositivo
:*
:*  Ultima modif:
:*  Fecha       Modificó             Motivo
:*==========================================================================================
:*
:*------------------------------------------------------------------------------------------*/

package mx.edu.itl.c85360673.u4sensoresapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class AcelerometroActivity extends AppCompatActivity {

    private Pelota pelota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acelerometro);

        pelota = findViewById ( R.id.pelota );
    }

    @Override
    protected void onResume() {
        super.onResume();
        pelota.iniciar ();
    }

    @Override
    protected void onPause() {
        super.onPause();
        pelota.detener ();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        pelota.detener ();
    }
}
