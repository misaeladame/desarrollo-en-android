/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                       INSTITUTO TECNOLOGICO DE LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: ENE-JUN/2021    HORA: 10-11 HRS
:*
:*                                 Clase de hilos
:*
:*  Archivo     : VistaJuegoThread.java
:*  Autor       : Jose Misael Adame Sandoval     18131209
:*  Fecha       : 30/May/2021
:*  Compilador  : Android Studio 4.1.2
:*  Descripción : Clase que manipula un hilo (thread), para tener control
:*                cuando se esta corriendo la aplicación.
:*
:*  Ultima modif:
:*  Fecha       Modificó             Motivo
:*==========================================================================================
:*
:*------------------------------------------------------------------------------------------*/

package mx.edu.itl.c18131209.u4juegoasteroidesapp;

import android.util.Log;

public class VistaJuegoThread extends Thread {

    private VistaJuegoView vistaJuegoView;
    private int periodoSleep;

    public VistaJuegoThread ( VistaJuegoView vistaJuegoView, int periodo ) {
        super ();
        this.vistaJuegoView = vistaJuegoView;
        this.periodoSleep = periodo;
    }

    @Override
    public void run () {
        boolean corriendo = vistaJuegoView.isCorriendo ();
        while ( corriendo ) {
            corriendo = vistaJuegoView.isCorriendo();
            vistaJuegoView.actualizarFisica();
            try {
                Thread.sleep ( periodoSleep );
            } catch (InterruptedException e) {
                Log.e ( "Asteroides", e.toString() );
            }
        }
    }

}
