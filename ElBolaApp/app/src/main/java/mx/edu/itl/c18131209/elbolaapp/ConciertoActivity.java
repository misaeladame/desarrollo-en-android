/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                       INSTITUTO TECNOLOGICO DE LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: ENE-JUN/2021    HORA: 10-11 HRS
:*
:*                                 Clase concierto
:*
:*  Archivo     : ConciertoActivity.java
:*  Autor       : Jose Misael Adame Sandoval     18131209
:*  Fecha       : 04/May/2021
:*  Compilador  : Android Studio 4.1.2
:*  Descripción : Clase que reproduce video mp4 de un concierto de una banda de rock lml
:*
:*  Ultima modif:
:*  Fecha       Modificó             Motivo
:*==========================================================================================
:*
:*------------------------------------------------------------------------------------------*/

package mx.edu.itl.c18131209.elbolaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class ConciertoActivity extends AppCompatActivity {

    //----------------------------------------------------------------------------------------------

    private VideoView videoView;

    //----------------------------------------------------------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_concierto);

        // Configuremos el objeto VideoView para la reproducción del video
        videoView = findViewById ( R.id.videoView );

        String uriPath = "android.resource://" + getPackageName () +"/" + R.raw.la_pachanga;
        Uri uri = Uri.parse ( uriPath );
        videoView.setVideoURI ( uri );
        videoView.setMediaController ( new MediaController( this ) );
        videoView.requestFocus ();
        videoView.start ();
    }

    //----------------------------------------------------------------------------------------------

}