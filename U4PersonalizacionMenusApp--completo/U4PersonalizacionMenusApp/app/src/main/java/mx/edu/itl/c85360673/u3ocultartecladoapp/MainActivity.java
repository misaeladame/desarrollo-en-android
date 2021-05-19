/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                       INSTITUTO TECNOLOGICO DE LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: ENE-JUN/2021    HORA: 10-11 HRS
:*
:*                                 Clase principal
:*
:*  Archivo     : MainActivity.java
:*  Autor       : Jose Misael Adame Sandoval     18131209
:*  Fecha       : 18/May/2021
:*  Compilador  : Android Studio 4.1.2
:*  Descripción : Clase principal de la aplicación Personalización Menús App
:*
:*  Ultima modif:
:*  Fecha       Modificó             Motivo
:*==========================================================================================
:*
:*------------------------------------------------------------------------------------------*/

package mx.edu.itl.c85360673.u3ocultartecladoapp;

import android.content.Intent;
import android.graphics.Color;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import mx.edu.itl.c85360673.util.OcultarTecladoAdaptador;

public class MainActivity extends AppCompatActivity {

    LinearLayout layout;
    EditText     edtNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Definir el manejador del onClick sobre el layout principal, cuando se de click sobre el
        // layout la clase ClickLayoutAdapter  manejará el evento
        layout = (LinearLayout) findViewById ( R.id.id_layout );
        layout.setOnClickListener ( new OcultarTecladoAdaptador( this ) );

        edtNombre = (EditText) findViewById ( R.id.edtNombre );
    }

    // Creamos el menu de la Actividad que aparecerá en la barra de acciones (ActionBar)
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate ( R.menu.menu_main_activity, menu );
        return super.onCreateOptionsMenu(menu);
    }

    // Manejamos las selecciones en el menu de la Actividad
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch ( id ) {
            case R.id.mniCambiarColorLetra   : edtNombre.setTextColor ( Color.RED ); break;
            case R.id.mniTamano8   :           edtNombre.setTextSize ( 8  ); item.setChecked ( ! item.isChecked() ); break;
            case R.id.mniTamano12  :           edtNombre.setTextSize ( 12 ); item.setChecked ( ! item.isChecked() ); break;
            case R.id.mniTamano20  :           edtNombre.setTextSize ( 20 ); item.setChecked ( ! item.isChecked() ); break;
            case R.id.mniAcercaDe  :           Toast.makeText ( getApplicationContext(), "Acerca De...", Toast.LENGTH_SHORT ).show ();
                                               break;
            case R.id.mniSalir      :          finish ();
            default                 :          return super.onOptionsItemSelected(item);
        }
        return true;
    }

    public void menuAcercaDeClick ( MenuItem item ) {

    }


    // Otra forma de manejar las seleccion de una opcion de menu es mediante el atributo onClick de ese MenuItem
    public void mniColorFondoPrincipalClick ( MenuItem item ) {
        layout.setBackgroundColor ( Color.YELLOW );
    }

    @Override
    public void onBackPressed () {
        // Hacer nada cuando se pulse el boton ATRAS del dispositivo
        Toast.makeText ( this, "Use la opcion Salir del menu", Toast.LENGTH_SHORT ).show ();
    }

    //----------------------------------------------------------------------------------------------
    //      METODOS PARA INVOCAR LOS OTROS EJEMPLOS DE MENUS

    public void btnActivitysMenuComunClick ( View v ) {
        Intent i = new Intent ( this, EjemploMenuEnComunActivity.class );
        startActivity ( i );
    }

    public void btnMenuContextualFlotante ( View v ) {
        Intent i = new Intent ( this, MenuContextualFlotanteActivity.class );
        startActivity ( i );
    }

    public void btnMenuModoContextualClick ( View v ) {
        Intent i = new Intent ( this, MenuModoAccionContextualActivity.class );
        startActivity ( i );
    }

    public void btnMenuPopupClick ( View v ) {
        Intent i = new Intent ( this, MenuPopupActivity.class );
        startActivity ( i );
    }

    public void btnAcercaDeClick ( View v ) {
        Intent intent = new Intent ( this, AcercaDeActivity.class );
        startActivity ( intent );
    }

    //----------------------------------------------------------------------------------------------

}
