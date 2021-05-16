package mx.edu.itl.c85360673.u3spinnerejemploapp;

import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class SpinnerSimpleActivity extends AppCompatActivity {

    Spinner spnClubesLigaMx;
    String [] clubes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_simple);

        // Se obtiene la referencia del spinner en el layout
        spnClubesLigaMx = findViewById ( R.id.spnClubesLigaMx );

        // Crear un adaptador ArrayAdapter desde un recurso R.array usando createFromResource ()
        // El 3er argumento es un tipo de TextView. En el simple_spinner_item los elementos salen pegaditos
        ArrayAdapter adaptador = ArrayAdapter.createFromResource( this,
                                    R.array.clubes_liga_mx,
                                    android.R.layout.simple_spinner_item );
        adaptador.setDropDownViewResource ( android.R.layout.simple_spinner_dropdown_item );
        spnClubesLigaMx.setAdapter ( adaptador );

        clubes = getResources ().getStringArray ( R.array.clubes_liga_mx );

        // En el adaptador se cambiar la vista que se usa para mostrar los elementos con setDropDownViewResource ().
        // En un simple_spinner_dropdown_item  los elementos salen mas separados.

        // Se establece el adaptador en el spinner
        spnClubesLigaMx.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                // 3 distintas formas de obtener el elemento seleccionado
                String s1 = adapterView.getItemAtPosition ( i ).toString ();
                String s2 = ( (TextView) view ).getText ().toString ();
                String s3 = clubes [ i ];

                Toast.makeText ( SpinnerSimpleActivity.this, "Auto seleccionado :" + s1,
                        Toast.LENGTH_SHORT ).show ();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        // Se establece un listener del spinner para los eventos onItemSeelected

    }
}
