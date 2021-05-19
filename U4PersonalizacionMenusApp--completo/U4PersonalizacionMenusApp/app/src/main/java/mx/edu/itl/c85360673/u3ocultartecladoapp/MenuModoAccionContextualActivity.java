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
:*  Archivo     : MenuContextualFlotanteActivity.java
:*  Autor       : Jose Misael Adame Sandoval     18131209
:*  Fecha       : 18/May/2021
:*  Compilador  : Android Studio 4.1.2
:*  Descripción : Clase que contiene un ejemplo sencillo de un menú con el modo
:*                acción contextual
:*
:*  Ultima modif:
:*  Fecha       Modificó             Motivo
:*==========================================================================================
:*
:*------------------------------------------------------------------------------------------*/

package mx.edu.itl.c85360673.u3ocultartecladoapp;

import android.os.Bundle;
import android.util.Log;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MenuModoAccionContextualActivity extends AppCompatActivity implements View.OnLongClickListener {

    ImageView imgvImagen;
    ActionMode mImagenActionMode = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_modo_accion_contextual);

        // El ImageView va a responder al click largo ( onLongClick )
        imgvImagen = ( ImageView ) findViewById ( R.id.imgvImagen);
        imgvImagen.setOnLongClickListener ( this );
    }

    @Override
    public boolean onLongClick ( View v ) {
        if ( v.getId() == R.id.imgvImagen) {
            // Si se hizo clic largo sobre la imagen...
            if ( mImagenActionMode != null ) {
                return false;
            }
            // Crear el objeto ActionMode estableciendo el listener ActionMode para la imagen
            mImagenActionMode = startActionMode ( mImagenActionModeListener );
            v.setSelected ( true );
            return true;
        }
        return false;
    }

    // Se define una variable que implementa la interface ActionMode.Callback
    // Esta variable fungirá como listener de la accion que se seleccione del menu contextual
    private ActionMode.Callback  mImagenActionModeListener = new ActionMode.Callback() {

        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            // Se infla el menu que aparecerá en modo de accion contextual para la Imagen
            mode.getMenuInflater().inflate ( R.menu.menu_modo_accion_contextual, menu );
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            // Se selecciono una opción de acción del menu contextual, ejecutar la accion que consiste en cambiar la imagen
            int id = item.getItemId();
            switch ( id ) {
                case R.id.mniModoAccionContextCopiar : imgvImagen.setImageResource ( R.drawable.descarga     );break;
                case R.id.mniModoAccionContextCortar : imgvImagen.setImageResource ( R.drawable.descarga2    );break;
                case R.id.mniModoAccionContextPegar  : imgvImagen.setImageResource ( R.drawable.driver_type4 );break;
                default                              : return false;
            }
            return true;
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {
            // Anular el objeto ActionMode
            mImagenActionMode = null;
        }
    } ;
}
