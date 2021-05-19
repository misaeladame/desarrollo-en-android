/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                       INSTITUTO TECNOLOGICO DE LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: ENE-JUN/2021    HORA: 10-11 HRS
:*
:*                                 Clase menú
:*
:*  Archivo     : MenuComunActivity.java
:*  Autor       : Jose Misael Adame Sandoval     18131209
:*  Fecha       : 18/May/2021
:*  Compilador  : Android Studio 4.1.2
:*  Descripción : Clase que contiene un ejemplo sencillo de un menú común Activity
:*
:*  Ultima modif:
:*  Fecha       Modificó             Motivo
:*==========================================================================================
:*
:*------------------------------------------------------------------------------------------*/

package mx.edu.itl.c85360673.u3ocultartecladoapp;


import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


// Esta clase es la superclase de los Activity's que van a compartir un menu en comun
// En este caso el menu tendrá 2 opciones en comun: Acerca de y Cambiar el color de fondo de la pantalla.

public class MenuComunActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate ( R.menu.menu_comun, menu );
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch ( id ) {
            case R.id.mniAcercaDe : Toast.makeText ( this, "TecLaguna v1.0", Toast.LENGTH_SHORT ).show (); break;
            default               : return super.onOptionsItemSelected(item);
        }
        return true;
    }
}
