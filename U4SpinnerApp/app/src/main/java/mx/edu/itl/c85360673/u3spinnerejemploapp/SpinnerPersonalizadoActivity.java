package mx.edu.itl.c85360673.u3spinnerejemploapp;

import androidx.appcompat.app.AppCompatActivity;
import modelo.Videojuego;
import modelo.SpinnerVideojuegosAdapter;

import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class SpinnerPersonalizadoActivity extends AppCompatActivity {

    private Spinner spnVideojuegos;
    private ArrayList<Videojuego> videojuegos;

    //----------------------------------------------------------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_personalizado);

        spnVideojuegos = findViewById ( R.id.spnVideojuegos);

        // Inicializar el ArrayList de clubes
        inicializarClubes ();

        // Crear el adapter del tipo SpinnerClubesAdapter y establecer el layout con  setDropDownViewResource ()
        SpinnerVideojuegosAdapter adaptador = new SpinnerVideojuegosAdapter( this, videojuegos);
        adaptador.setDropDownViewResource ( android.R.layout.simple_spinner_dropdown_item );

        spnVideojuegos.setAdapter ( adaptador );

        // Establecer el adaptador para el spinner


    }

    //----------------------------------------------------------------------------------------------

    private void inicializarClubes () {
        videojuegos = new ArrayList<> ( );
        // Agregar elementos al ArrayList
        videojuegos.add ( new Videojuego( "Dota 2", R.drawable.dota2 ) );
        videojuegos.add ( new Videojuego( "League of Legends", R.drawable.lol ) );
        videojuegos.add ( new Videojuego( "Half Life 2", R.drawable.half_life ) );
        videojuegos.add ( new Videojuego( "Counter Strike", R.drawable.counter_strike ) );
        videojuegos.add ( new Videojuego( "Left 4 Dead 2", R.drawable.l4d2 ) );

    }

    //----------------------------------------------------------------------------------------------

    public void btnAceptarClick ( View v ) {
        // Recuperar el elemento seleccionado del Spinner y mostrar el nombre del club en un Toast
        Videojuego videojuego = (Videojuego) spnVideojuegos.getSelectedItem ();
        Toast.makeText ( this, "Videojuego seleccionado: " + videojuego.getNombre (), Toast.LENGTH_SHORT ).show ();

    }

    //----------------------------------------------------------------------------------------------
}
