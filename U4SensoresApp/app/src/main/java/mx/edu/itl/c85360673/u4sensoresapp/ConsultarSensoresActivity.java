/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                       INSTITUTO TECNOLOGICO DE LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: ENE-JUN/2021    HORA: 10-11 HRS
:*
:*                             Clase lista de sensores
:*
:*  Archivo     : ConsultarSensoresActivity.java
:*  Autor       : Jose Misael Adame Sandoval     18131209
:*  Fecha       : 01/Jun/2021
:*  Compilador  : Android Studio 4.1.2
:*  Descripción : Clase que permite ver una lista y la información de los
:*                sensores que tiene el dispositivo.
:*
:*  Ultima modif:
:*  Fecha       Modificó             Motivo
:*==========================================================================================
:*
:*------------------------------------------------------------------------------------------*/

package mx.edu.itl.c85360673.u4sensoresapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ConsultarSensoresActivity extends AppCompatActivity  {

    private SensorManager sensorManager;
    private TextView      txtvListaSensores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_sensores);

        txtvListaSensores = findViewById ( R.id.txtvListaSensores );
        txtvListaSensores.setText ( "" );

        // Obtenemos la lista de todos los sensores del dispositivo
        sensorManager = (SensorManager) getSystemService ( Context.SENSOR_SERVICE );
        List<Sensor> lstSensores = sensorManager.getSensorList ( Sensor.TYPE_ALL );

        int numSensores = 0;
        // Por cada sensor en la lista se imprime su nombre, fabricante y version del sensor.
        for ( Sensor sensor : lstSensores ) {
            txtvListaSensores.append ( ++numSensores + ": \n" );
            txtvListaSensores.append ( sensor.getName   () + "\n" );
            txtvListaSensores.append ( sensor.getVendor () + "\n" );
            txtvListaSensores.append ( "Version: " + sensor.getVersion() + "\n" );
            txtvListaSensores.append ( "\n" );
        }
        txtvListaSensores.append ( "Total : " + numSensores + " sensores fueron encontrados" );
    }
}
