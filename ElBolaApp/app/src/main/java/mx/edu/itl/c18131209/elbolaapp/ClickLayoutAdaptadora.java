/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                       INSTITUTO TECNOLOGICO DE LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: ENE-JUN/2021    HORA: 10-11 HRS
:*
:*                                 Clase adaptadora
:*
:*  Archivo     : ClickLayoutAdaptadora.java
:*  Autor       : Jose Misael Adame Sandoval     18131209
:*  Fecha       : 02/May/2021
:*  Compilador  : Android Studio 4.1.2
:*  Descripción : Clase adaptadora que se puede utilizar en cualquier Layout el cual
:*                permite esconder el teclado al hacer clic en  cualquier parte
:*                de la pantalla
:*
:*  Ultima modif:
:*  Fecha       Modificó             Motivo
:*==========================================================================================
:*
:*------------------------------------------------------------------------------------------*/

package mx.edu.itl.c18131209.elbolaapp;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public class ClickLayoutAdaptadora implements View.OnClickListener {

    private Activity activity;

    //----------------------------------------------------------------------------------------------

    public ClickLayoutAdaptadora(Activity activity ) {
        this.activity = activity;
    }

    //----------------------------------------------------------------------------------------------

    @Override
    public void onClick(View v) {
        View view = activity.getCurrentFocus();
        if ( view != null ) {
            InputMethodManager imm = (InputMethodManager) activity.getSystemService (
                    Context.INPUT_METHOD_SERVICE );
            imm.hideSoftInputFromWindow ( view.getWindowToken(),
                    InputMethodManager.HIDE_NOT_ALWAYS );
        }
    }

    //----------------------------------------------------------------------------------------------

}
