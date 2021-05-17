package mx.edu.itl.c85360673.gridviewejemplo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;


public class GridViewActivity extends AppCompatActivity implements AdapterView.OnItemClickListener
{

    final Integer [] escudos = { R.drawable.escudo_barcelona, R.drawable.escudo_bayern,
                                 R.drawable.escudo_chelsea,   R.drawable.escudo_dinamokiev,
                                 R.drawable.escudo_dormunt,   R.drawable.escudo_gotemburgo,
                                 R.drawable.escudo_leipzig,   R.drawable.escudo_zagreb  };

    private GridView       grdvClubes;
    private GridAdaptador  adaptador;

    //------------------------------------------------------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView ( R.layout.activity_grid_view);

        // Crear el Adapter y establecerlo como adapter en el GridView

    }

    //------------------------------------------------------------------------------------------

    @Override
    public void onItemClick ( AdapterView<?> adapterView, View view, int i, long l ) {
        Intent intent = new Intent( this, GridViewDetalleActivity.class );

        // Pasamos como argumento al otro activity el ID del recurso drawable del escudo seleccionado
        intent.putExtra ( "escudo", escudos [ i ] );
        startActivity ( intent );
    }

    //------------------------------------------------------------------------------------------

    public class GridAdaptador extends ArrayAdapter {
        private Integer [] escudos;
        private int        layoutResId;
        private LayoutInflater inflater;

        //------------------------------------------------------------------------------------------
        // Constructor

        public GridAdaptador(@NonNull Context context, int resource, @NonNull Integer [] escudos ) {
            // Llamar al constructor de la clase padre y guardar los argumentos en variables de la clase
        }

        //------------------------------------------------------------------------------------------

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            // Implementar la personalizacion de convertView inflando primero el layout que va a utilizar

            return convertView;
        }

        //------------------------------------------------------------------------------------------
    }
}
