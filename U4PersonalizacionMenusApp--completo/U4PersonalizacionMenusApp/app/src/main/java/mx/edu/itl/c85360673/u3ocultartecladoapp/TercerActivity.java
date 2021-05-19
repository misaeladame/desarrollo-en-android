/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                       INSTITUTO TECNOLOGICO DE LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: ENE-JUN/2021    HORA: 10-11 HRS
:*
:*                                 Clase Activity
:*
:*  Archivo     : TercerActivity.java
:*  Autor       : Jose Misael Adame Sandoval     18131209
:*  Fecha       : 18/May/2021
:*  Compilador  : Android Studio 4.1.2
:*  Descripción : Clase que actua como un tercer activity, derivado del
:*                principal
:*
:*  Ultima modif:
:*  Fecha       Modificó             Motivo
:*==========================================================================================
:*
:*------------------------------------------------------------------------------------------*/

package mx.edu.itl.c85360673.u3ocultartecladoapp;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.LinearLayout;

public class TercerActivity extends MenuComunActivity {

    LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tercer);

        layout = (LinearLayout) findViewById ( R.id.layoutPrincipal );
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch ( id ) {
            case R.id.mniCambiarColorFondo:
                layout.setBackgroundColor ( Color.BLUE );
                return true;
            default  :
                return super.onOptionsItemSelected(item);
        }
    }
}
