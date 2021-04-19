/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                       INSTITUTO TECNOLOGICO DE LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: ENE-JUN/2021    HORA: 10-11 HRS
:*
:*                                 Clase Obtener Strings
:*
:*  Archivo     : RR.java
:*  Autor       : Jose Misael Adame Sandoval     18131209
:*  Fecha       : 16/Abr/2021
:*  Compilador  : Android Studio 4.1.2
:*  Descripción : Clase que obtiene los recursos de los strings.xml para la adaptación
:*                de la aplicación a distintos idiomas.
:*
:*  Ultima modif:
:*  Fecha       Modificó             Motivo
:*==========================================================================================
:*
:*------------------------------------------------------------------------------------------*/

package mx.edu.itl.c18131209.u2imcapp;

import android.content.Context;

public class RR {

    public static Context contexto;

    //----------------------------------------------------------------------------------------------

    public static String s ( int id ) {
        return contexto.getResources().getString( id );
    }

    //----------------------------------------------------------------------------------------------

}
