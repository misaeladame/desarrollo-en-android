package mx.edu.itl.c85360673.u3listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListaConCheckboxesActivity extends AppCompatActivity {

    private ListView          lstvAnimales;
    private ArrayList<String> seleccionados;

    private String [] animales = { "Perro", "Gato", "Raton", "Paloma", "Elefante", "Leon",
                                   "Leona", "Ballena", "Gaviota", "Vibora", "Gusano" } ;

    //----------------------------------------------------------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_con_checkboxes);

        lstvAnimales = findViewById ( R.id.lstvAnimales );

    }

    //----------------------------------------------------------------------------------------------

    public void btnElementosSeleccionadosClick ( View v ) {


    }

    //----------------------------------------------------------------------------------------------
}
