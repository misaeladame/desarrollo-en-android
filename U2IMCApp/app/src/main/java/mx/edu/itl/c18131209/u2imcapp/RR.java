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
