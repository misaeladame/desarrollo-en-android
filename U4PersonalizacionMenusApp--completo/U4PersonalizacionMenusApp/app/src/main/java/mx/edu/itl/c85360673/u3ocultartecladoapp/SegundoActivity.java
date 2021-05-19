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
:*  Archivo     : SegundoActivity.java
:*  Autor       : Jose Misael Adame Sandoval     18131209
:*  Fecha       : 18/May/2021
:*  Compilador  : Android Studio 4.1.2
:*  Descripción : Clase que actua como un segundo activity, derivado del
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
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;


public class SegundoActivity extends MenuComunActivity {

    ConstraintLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segundo);

        layout = (ConstraintLayout) findViewById ( R.id.layoutPrincipal );
    }

    // Se sobreescribe el metodo onCreateOptionsMenu para agregar la nueva opcion
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Se llama a super para que recree el menu con las opciones en comun
        super.onCreateOptionsMenu(menu);

        // Agregamos la nueva opcion
        MenuItem mni = menu.add ( Menu.NONE, 44191944, Menu.NONE, "Opcion agregada"  );

        return true;
    }

    // Se sobre escribe el metodo onOptionsItemSelected para manejar la nueva opcion agregada
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch ( id ) {
            case R.id.mniCambiarColorFondo:
                layout.setBackgroundColor ( Color.GRAY );
                return true;
            case 44191944 :
                Toast.makeText( this, "Opcion agregada", Toast.LENGTH_SHORT ).show();
                return true;
            default  :
                return super.onOptionsItemSelected(item);  //
        }
    }
}
