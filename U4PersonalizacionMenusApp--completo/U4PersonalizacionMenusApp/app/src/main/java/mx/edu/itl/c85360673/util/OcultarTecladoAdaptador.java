/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                       INSTITUTO TECNOLOGICO DE LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: ENE-JUN/2021    HORA: 10-11 HRS
:*
:*                                 Clase Ocultar
:*
:*  Archivo     : OcultarTecladoAdaptador.java
:*  Autor       : Jose Misael Adame Sandoval     18131209
:*  Fecha       : 18/May/2021
:*  Compilador  : Android Studio 4.1.2
:*  Descripción : Clase que permite ocultar el teclado en tiempo de ejecución
:*                de la aplicación
:*
:*  Ultima modif:
:*  Fecha       Modificó             Motivo
:*==========================================================================================
:*
:*------------------------------------------------------------------------------------------*/

package mx.edu.itl.c85360673.util;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public class OcultarTecladoAdaptador implements View.OnClickListener {

    private Activity activity;

    public OcultarTecladoAdaptador(Activity activity ) {
        this.activity = activity;
    }

    @Override
    public void onClick(View v) {
        View view = activity.getCurrentFocus();
        if ( view != null ) {
            InputMethodManager imm = (InputMethodManager)
                    activity.getSystemService ( Context.INPUT_METHOD_SERVICE ) ;
            imm.hideSoftInputFromWindow (
                    view.getWindowToken(),
                    InputMethodManager.HIDE_NOT_ALWAYS
            );
        }
    }
}
