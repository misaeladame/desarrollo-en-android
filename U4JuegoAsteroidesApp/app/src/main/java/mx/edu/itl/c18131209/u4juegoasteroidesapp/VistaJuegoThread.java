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
