package mx.edu.itl.c85360673.u3listview;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListaTextoImagenActivity extends AppCompatActivity {

    private ListView lstvClubes;

    private final String [] clubes        = { "Chelsea", "Barcelona", "Bayern Munich", "Dinamo Zagreb",
                                              "Dinamo Kiev" };
    private final String [] descripciones = { "Club londinense de Londres" ,
                                            "Club catalan multicampeon de la Champions",
                                            "Club aleman de Munich",
                                            "Club croata de la ciudad de Zagreb",
                                            "Club ucraniano de la capital Kiev"
                                          };
    private final int [] logos = { R.drawable.listview_chelsea,
                                   R.drawable.listview_barcelona,
                                   R.drawable.listview_bayern,
                                   R.drawable.listview_zagreb,
                                   R.drawable.listview_dinamokiev
                                 };

    //----------------------------------------------------------------------------------------------

    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_texto_imagen);

        lstvClubes = findViewById  ( R.id.lstvClubes );

        // Establecemos el Adapter para el ListView, el adapter será un objeto MiAdaptador


        // Establecemos un listener para el evento onItemClick del ListView


    }



    //----------------------------------------------------------------------------------------------

}
