/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                       INSTITUTO TECNOLOGICO DE LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: ENE-JUN/2021    HORA: 10-11 HRS
:*
:*                                 Clase de dibujo
:*
:*  Archivo     : Pelota.java
:*  Autor       : Jose Misael Adame Sandoval     18131209
:*  Fecha       : 01/Jun/2021
:*  Compilador  : Android Studio 4.1.2
:*  Descripción : Clase que dibuja una pelota y permite su manipulación con sus
:*                atributos de de coordenadas x, y, el radio y el alto.
:*
:*  Ultima modif:
:*  Fecha       Modificó             Motivo
:*==========================================================================================
:*
:*------------------------------------------------------------------------------------------*/

package mx.edu.itl.c85360673.u4sensoresapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

import androidx.annotation.Nullable;

public class Pelota extends View implements SensorEventListener  {

    private SensorManager sensorManager;
    private Sensor sensor;

    private int x;
    private int y;
    private int radio = 50;
    private int ancho;
    private int alto;
    private Paint paint;

    public Pelota(Context context, @Nullable AttributeSet attrs) {
        super ( context, attrs );

        // Obtener las dimensiones de la pantalla del dispositivo
        Display pantalla = ( (WindowManager) context.getSystemService ( Context.WINDOW_SERVICE ) )
                            .getDefaultDisplay ();
        Point dimensiones = new Point ();
        pantalla.getSize ( dimensiones );

        ancho = dimensiones.x;
        alto = dimensiones.y;
        x = ancho / 2;
        y = alto / 2;

        // Establecer el color con el que se pinta la pelota
        paint = new Paint ();
        paint.setColor ( Color.BLUE );

        // Obtenemos la instancia del acelerometro
        sensorManager = (SensorManager) context.getSystemService ( Context.SENSOR_SERVICE );
        sensor = sensorManager.getDefaultSensor ( Sensor.TYPE_ACCELEROMETER );
    }

    public void iniciar () {
        sensorManager.registerListener ( this, sensor, SensorManager.SENSOR_DELAY_UI );
    }

    public void detener () {
        sensorManager.unregisterListener ( this, sensor );
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        // Calculamos la nueva posicion x, y de la pelota en base a las lecturas del acelerometro
        // en los ejes X , Y.
        x -= sensorEvent.values [ 0 ] * 2;
        y += sensorEvent.values [ 1 ] * 2;

        // Verificar si no se sobrepasa los limites de la pantalla
        if ( x < radio )
            x = radio;
        else if ( x > ancho - radio )
            x = ancho - radio;

        if ( y < radio )
            y = radio;
        else if ( y > alto - radio )
            y = alto - radio;

        // Invocar invalidate () de este View para invocar el método draw ()
        invalidate ();
    }

    @Override
    public void draw ( Canvas canvas ) {
        super.draw(canvas);
        // Dibujar la pelota en las coord x, y
        canvas.drawCircle ( x, y, radio, paint );
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
