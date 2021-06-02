/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                       INSTITUTO TECNOLOGICO DE LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: ENE-JUN/2021    HORA: 10-11 HRS
:*
:*                        Clase de monitoreo de sensores
:*
:*  Archivo     : MonitorearSensoresActivity.java
:*  Autor       : Jose Misael Adame Sandoval     18131209
:*  Fecha       : 01/Jun/2021
:*  Compilador  : Android Studio 4.1.2
:*  Descripción : Clase que permite observar en como funciona en tiempo real los
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
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class MonitorearSensoresActivity extends AppCompatActivity implements SensorEventListener  {

    private SensorManager sensorManager;
    private List<Sensor>  listaSensores;
    private TextView      aTextView [][] = new TextView [ 51 ][ 3 ];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monitorear_sensores);

        // Obtenemos la referencia del LinearLayout donde se mostraran las lecturas de todos los sensores
        LinearLayout linLayRaiz = (LinearLayout) findViewById ( R.id.linLayRaiz );

        // Obtenemos la lista de sensores
        sensorManager = (SensorManager) getSystemService ( Context.SENSOR_SERVICE );
        listaSensores = sensorManager.getSensorList ( Sensor.TYPE_ALL );

        int n = 0;
        // Por cada sensor agregaremos textviews para mostrar sus lecturas
        for ( Sensor sensor : listaSensores  ) {
            // Creamos un textview con el nombre del sensor y lo agregamos al LinearLayout de
            // la lista de sensores
            TextView mTextView = new TextView ( this );
            mTextView.setText ( sensor.getName() );
            linLayRaiz.addView ( mTextView );

            // Creamos otro LinearLayout para colocar aqui textviews con las lecturas del sensor,
            // este linearlayout estara debajo del textview del nombre del sensor
            LinearLayout mLinearLayout = new LinearLayout ( this );
            linLayRaiz.addView ( mLinearLayout );

            // Creamos cada uno de los 3 textviews donde se mostraran las lecturas del sensor
            for ( int i = 0; i < 3; i++ ) {
                aTextView [ n ][ i ] = new TextView ( this );
                aTextView [ n ][ i ].setText ( "?" );
                aTextView [ n ][ i ].setWidth ( 87 );
            }

            // Cada fila de lecturas consta de 6 textviews horizontalmente dispuestos:
            // Primer par de textviews:  uno con la leyenda X y el segundo para poner su lectura en X
            TextView xTextView = new TextView ( this );
            xTextView.setText ( " X: " );
            mLinearLayout.addView ( xTextView );
            mLinearLayout.addView ( aTextView [ n ][ 0 ] );

            // Segundo par de textviews:  uno con la leyenda Y y el segundo para poner su lectura en Y
            TextView yTextView = new TextView ( this );
            yTextView.setText ( " Y: " );
            mLinearLayout.addView ( yTextView );
            mLinearLayout.addView ( aTextView [ n ][ 1 ] );

            // Tercer par de textviews:  uno con la leyenda Z y el segundo para poner su lectura en Z
            TextView zTextView = new TextView ( this );
            zTextView.setText ( " Z: " );
            mLinearLayout.addView ( zTextView );
            mLinearLayout.addView ( aTextView [ n ][ 2 ] );

            n++;
        }
    }

    @Override
    protected void onResume() {
        super.onResume  ();

        // Registrar a este activity como listener de cada uno de los sensores del dispositivo
        for ( Sensor sensor : listaSensores  ) {
            sensorManager.registerListener ( this, sensor, SensorManager.SENSOR_DELAY_UI );
        }
    }

    @Override
    protected void onPause() {
        super.onPause  ();

        // Cancelar el registro de este activity como listener de todos los sensores
        sensorManager.unregisterListener ( this );
    }

    @Override
    protected void onDestroy() {
        super.onDestroy ();

        // Cancelar el registro de este activity como listener de todos los sensores
        sensorManager.unregisterListener ( this );
    }

    @Override
    public void onSensorChanged  ( SensorEvent sensorEvent ) {

        synchronized ( this ) {
            int n = 0;

            // Buscamos el sensor que generó el evento en la lista de sensores
            for ( Sensor sensor : listaSensores ) {
                if ( sensorEvent.sensor == sensor ) {
                    // Por cada una de las lecturas del sensor en los ejes X, Y, Z mostrarlas en los textviews
                    for ( int i = 0; i < sensorEvent.values.length  && i < 3; i++ ) {
                        aTextView [ n ][ i ].setText ( Float.toString ( sensorEvent.values [ i ]  ) );
                    }
                }
                n++;
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

}
