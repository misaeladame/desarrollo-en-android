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


        // Establecer el adaptador para el spinner

    }

    //----------------------------------------------------------------------------------------------

    private void inicializarClubes () {
        clubes = new ArrayList<> ( );
        // Agregar elementos al ArrayList
    }

    //----------------------------------------------------------------------------------------------

    public  void btnAceptarClick ( View v ) {
         // Recuperar el elemento seleccionado del Spinner y mostrar el nombre del club en un Toast
    }

    //----------------------------------------------------------------------------------------------
}
