/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                       INSTITUTO TECNOLOGICO DE LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: ENE-JUN/2021    HORA: 10-11 HRS
:*
:*                          Clase principal de la app
:*
:*  Archivo     : MainActivity.java
:*  Autor       : Jose Misael Adame Sandoval     18131209
:*  Fecha       : 01/Jun/2021
:*  Compilador  : Android Studio 4.1.2
:*  Descripción : Clase que permite ver y monitorear los sensores del teléfono,
:*                los botones que tiene son los siguientes:
:*
:*                •	Consultar lista de sensores
:*                •	Monitorear sensores
:*                •	Acelerómetro
:*                •	Acerca de...
:*
:*  Ultima modif:
:*  Fecha       Modificó             Motivo
:*==========================================================================================
:*
:*------------------------------------------------------------------------------------------*/

package mx.edu.itl.c85360673.u4sensoresapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnConsultarSensoresClick ( View v ) {
        Intent intent = new Intent ( this, ConsultarSensoresActivity.class );
        startActivity ( intent );
    }

    public void btnMonitorearSensoresClick ( View v ) {
        Intent intent = new Intent ( this, MonitorearSensoresActivity.class );
        startActivity ( intent );
    }

    public void btnAcelerometroClick ( View v ) {
        Intent intent = new Intent ( this, AcelerometroActivity.class );
        startActivity ( intent );
    }

    public void btnAcercaDeClick ( View v ) {
        Intent intent = new Intent ( this, AcercaDeActivity.class );
        startActivity ( intent );
    }
}
