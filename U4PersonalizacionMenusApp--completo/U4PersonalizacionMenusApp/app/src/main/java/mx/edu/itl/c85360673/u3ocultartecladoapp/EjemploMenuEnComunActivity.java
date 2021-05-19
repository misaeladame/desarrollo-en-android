/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                       INSTITUTO TECNOLOGICO DE LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: ENE-JUN/2021    HORA: 10-11 HRS
:*
:*                                 Clase de un menú
:*
:*  Archivo     : EjemploMenuEnComunActivity.java
:*  Autor       : Jose Misael Adame Sandoval     18131209
:*  Fecha       : 18/May/2021
:*  Compilador  : Android Studio 4.1.2
:*  Descripción : Clase que muestra un ejemplo sencillo de un menú en común
:*
:*  Ultima modif:
:*  Fecha       Modificó             Motivo
:*==========================================================================================
:*
:*------------------------------------------------------------------------------------------*/

package mx.edu.itl.c85360673.u3ocultartecladoapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class EjemploMenuEnComunActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejemplo_menu_en_comun);
    }

    public void btnActivity2Click ( View v ) {
        Intent i = new Intent ( this, SegundoActivity.class );
        startActivity ( i );
    }

    public void btnActivity3Click ( View v ) {
        Intent i = new Intent ( this, TercerActivity.class );
        startActivity ( i );

    }
}
