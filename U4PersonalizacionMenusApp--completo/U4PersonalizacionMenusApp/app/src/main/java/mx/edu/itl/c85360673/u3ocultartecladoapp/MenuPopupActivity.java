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
:*  Archivo     : MenuPopActivity.java
:*  Autor       : Jose Misael Adame Sandoval     18131209
:*  Fecha       : 18/May/2021
:*  Compilador  : Android Studio 4.1.2
:*  Descripción : Clase que contiene un ejemplo sencillo de un menú PopUp
:*
:*  Ultima modif:
:*  Fecha       Modificó             Motivo
:*==========================================================================================
:*
:*------------------------------------------------------------------------------------------*/

package mx.edu.itl.c85360673.u3ocultartecladoapp;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.PopupMenu;

import androidx.appcompat.app.AppCompatActivity;

public class MenuPopupActivity extends AppCompatActivity implements View.OnLongClickListener,
                                                                    PopupMenu.OnMenuItemClickListener {

    EditText edtApodo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_popup);

        edtApodo = (EditText) findViewById ( R.id.edtApodo );
        edtApodo.setOnLongClickListener ( this );
    }

    @Override
    public boolean onLongClick(View v) {
        int id = v.getId();
        if ( id == R.id.edtApodo ) {
            configurar_popmenu_apodo ( v );
            return true;
        }
        return false;
    }

    private void configurar_popmenu_apodo ( View v ) {
        PopupMenu popupMenu = new PopupMenu ( this, v );
        popupMenu.getMenuInflater().inflate ( R.menu.menu_popup_apodo, popupMenu.getMenu() );
        popupMenu.setOnMenuItemClickListener ( this );
        popupMenu.show();
    }


    @Override
    public boolean onMenuItemClick(MenuItem item) {
        int id = item.getItemId ();
        switch ( id ) {
            case R.id.mniApodoAmlo    : edtApodo.setText ( "Inge Gil"    ); break;
            case R.id.mniApodoBorolas : edtApodo.setText ( "Chespi" );break;
            case R.id.mniApodoPenita  : edtApodo.setText ( "Tio Oswi"  );break;
            default                   : return false;
        }
        return true;
    }


}
