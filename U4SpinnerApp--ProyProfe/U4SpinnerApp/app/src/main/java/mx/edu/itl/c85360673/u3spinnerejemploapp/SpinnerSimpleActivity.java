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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_simple);

        // Se obtiene la referencia del spinner en el layout
        spnClubesLigaMx = findViewById ( R.id.spnClubesLigaMx );

        // Crear un adaptador ArrayAdapter desde un recurso R.array usando createFromResource ()
        // El 3er argumento es un tipo de TextView. En el simple_spinner_item los elementos salen pegaditos


        // En el adaptador se cambiar la vista que se usa para mostrar los elementos con setDropDownViewResource ().
        // En un simple_spinner_dropdown_item  los elementos salen mas separados.

        // Se establece el adaptador en el spinner

        // Se establece un listener del spinner para los eventos onItemSeelected

    }
}
