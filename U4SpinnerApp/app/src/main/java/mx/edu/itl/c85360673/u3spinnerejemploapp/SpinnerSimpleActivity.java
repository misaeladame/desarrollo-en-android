package mx.edu.itl.c85360673.u3spinnerejemploapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class SpinnerSimpleActivity extends AppCompatActivity {

    Spinner spnMarcasDeAutos;
    String [] marcasDeAutos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_simple);

        // Se obtiene la referencia del spinner en el layout
        spnMarcasDeAutos = findViewById ( R.id.spnMarcasDeAutos);

        // Crear un adaptador ArrayAdapter desde un recurso R.array usando createFromResource ()
        // El 3er argumento es un tipo de TextView. En el simple_spinner_item los elementos salen pegaditos
        ArrayAdapter adaptador = ArrayAdapter.createFromResource( this,
                                    R.array.marcas_de_autos,
                                    android.R.layout.simple_spinner_item );
        adaptador.setDropDownViewResource ( android.R.layout.simple_spinner_dropdown_item );
        spnMarcasDeAutos.setAdapter ( adaptador );

        marcasDeAutos = getResources ().getStringArray ( R.array.marcas_de_autos);

        // En el adaptador se cambiar la vista que se usa para mostrar los elementos con setDropDownViewResource ().
        // En un simple_spinner_dropdown_item  los elementos salen mas separados.

        // Se establece el adaptador en el spinner
        spnMarcasDeAutos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                // 3 distintas formas de obtener el elemento seleccionado
                String s1 = adapterView.getItemAtPosition ( i ).toString ();
                String s2 = ( (TextView) view ).getText ().toString ();
                String s3 = marcasDeAutos[ i ];

                Toast.makeText ( SpinnerSimpleActivity.this, "Auto seleccionado : " + s1,
                        Toast.LENGTH_SHORT ).show ();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        // Se establece un listener del spinner para los eventos onItemSeelected

    }
}
