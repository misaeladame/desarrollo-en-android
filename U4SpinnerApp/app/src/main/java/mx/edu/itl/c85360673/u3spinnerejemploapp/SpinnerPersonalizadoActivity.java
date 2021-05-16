package mx.edu.itl.c85360673.u3spinnerejemploapp;

import androidx.appcompat.app.AppCompatActivity;
import modelo.Club;
import modelo.SpinnerClubesAdapter;

import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class SpinnerPersonalizadoActivity extends AppCompatActivity {

    private Spinner spnClubes;
    private ArrayList<Club> clubes;

    //----------------------------------------------------------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_personalizado);

        spnClubes = findViewById ( R.id.spnClubes );

        // Inicializar el ArrayList de clubes
        inicializarClubes ();

        // Crear el adapter del tipo SpinnerClubesAdapter y establecer el layout con  setDropDownViewResource ()
        SpinnerClubesAdapter adaptador = new SpinnerClubesAdapter ( this, clubes );
        adaptador.setDropDownViewResource ( android.R.layout.simple_spinner_dropdown_item );

        spnClubes.setAdapter ( adaptador );

        // Establecer el adaptador para el spinner


    }

    //----------------------------------------------------------------------------------------------

    private void inicializarClubes () {
        clubes = new ArrayList<> ( );
        // Agregar elementos al ArrayList
        clubes.add ( new Club ( "Dota 2", R.drawable.dota2 ) );
        clubes.add ( new Club ( "League of Legends", R.drawable.lol ) );
        clubes.add ( new Club ( "Half Life 2", R.drawable.half_life ) );
        clubes.add ( new Club ( "Counter Strike", R.drawable.counter_strike ) );
        clubes.add ( new Club ( "Left 4 Dead 2", R.drawable.l4d2 ) );

    }

    //----------------------------------------------------------------------------------------------

    public  void btnAceptarClick ( View v ) {
         // Recuperar el elemento seleccionado del Spinner y mostrar el nombre del club en un Toast
        Club club = (Club) spnClubes.getSelectedItem ();
        Toast.makeText ( this, "Videojuego seleccionado: " + club.getNombre (), Toast.LENGTH_SHORT ).show ();

    }

    //----------------------------------------------------------------------------------------------
}
