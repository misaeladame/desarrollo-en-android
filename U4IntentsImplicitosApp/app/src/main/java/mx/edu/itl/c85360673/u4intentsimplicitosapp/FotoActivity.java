/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                       INSTITUTO TECNOLOGICO DE LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: ENE-JUN/2021    HORA: 10-11 HRS
:*
:*                                     Clase foto
:*
:*  Archivo     : FotoActivity.java
:*  Autor       : Jose Misael Adame Sandoval     18131209
:*  Fecha       : 19/May/2021
:*  Compilador  : Android Studio 4.1.2
:*  Descripción : Clase que muestra una foto de la galería con el tamaño de
:*               la pantalla del Activity.
:*
:*  Ultima modif:
:*  Fecha       Modificó             Motivo
:*==========================================================================================
:*
:*------------------------------------------------------------------------------------------*/

package mx.edu.itl.c85360673.u4intentsimplicitosapp;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;

public class FotoActivity extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foto);

        // Se recupera el argumento con la uri de la foto a mostrar
        String uri = getIntent ().getStringExtra  ("uri" );

        // Se muestra la foto
        imageView = findViewById ( R.id.imageView );
        imageView.setImageURI ( Uri.parse ( uri ) );
    }
}
