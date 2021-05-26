/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                       INSTITUTO TECNOLOGICO DE LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                            DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: ENE-JUN/2021    HORA: 10-11 HRS
:*
:*                                 Clase de imagenes
:*
:*  Archivo     : Imagen.java
:*  Autor       : Jose Misael Adame Sandoval     18131209
:*  Fecha       : 24/May/2021
:*  Compilador  : Android Studio 4.1.2
:*  Descripción : Clase que obtiene los elementos de una imagen como alto y ancho,
:*                con el proposito de reducir su Bitmap
:*
:*  Ultima modif:
:*  Fecha       Modificó             Motivo
:*==========================================================================================
:*
:*------------------------------------------------------------------------------------------*/

package util.imagenes;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.widget.Toast;

import java.io.FileNotFoundException;

public class Imagen {

    public static Bitmap reducirBitmap (Context context, String strUri, int maxAncho, int maxAlto ) {
        try {
            final BitmapFactory.Options options = new BitmapFactory.Options ();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeStream  ( context.getContentResolver()
                                                 .openInputStream ( Uri.parse ( strUri ) ),
                               null,
                                          options );
            options.inSampleSize = (int) Math.max (
                    Math.ceil ( options.outWidth / maxAncho ),
                    Math.ceil ( options.outHeight / maxAlto )
            );
            options.inJustDecodeBounds = false;
            return BitmapFactory.decodeStream ( context.getContentResolver()
                                                       .openInputStream ( Uri.parse ( strUri ) ),
                                                null,
                                                 options );
        } catch ( FileNotFoundException ex ) {
            Toast.makeText ( context, "Archivo no encontrado.", Toast.LENGTH_LONG ).show ();
            ex.printStackTrace ();
            return null;
        }
    }
}
