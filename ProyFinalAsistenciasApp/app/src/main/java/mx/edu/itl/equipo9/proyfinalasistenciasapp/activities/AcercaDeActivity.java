/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                       INSTITUTO TECNOLOGICO DE LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: ENE-JUN/2021    HORA: 10-11 HRS
:*
:*            Activity que nos permite proporcionar informacion de la app
:*
:*  Archivo     : AcercaDeActivity.java
:*  Autor       : Jose Misael Adame Sandoval     18131209
:*                Cristian Barajas Cabrales      17130764
:*                Salma Lizeth Mazuca Reyna      17130801
:*                Cristian Gabriel Piña Rosales  18130588
:*  Fecha       : 25/06/2021
:*  Compilador  : Android Studio 4.0.1
:*  Descripcion : Activity que nos permite crear un xml para poder crear una vista para asi
:*                mandar a llamar a su Activity, con lo cual se proporcionar los datos de las
:*                personas que han desarrollado la app.
:*  Ultima modif:
:*  Fecha       Modificacion             Motivo
:*==========================================================================================
:*  dd/mmm/aaaa Fulanito de tal       Motivo de la modificacion, puede ser en mas de 1 renglon.
:*------------------------------------------------------------------------------------------*/

package mx.edu.itl.equipo9.proyfinalasistenciasapp.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import mx.edu.itl.equipo9.proyfinalasistenciasapp.R;

public class AcercaDeActivity extends AppCompatActivity {

    //----------------------------------------------------------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView ( R.layout.activity_acerca_de );
    }

    //----------------------------------------------------------------------------------------------

}