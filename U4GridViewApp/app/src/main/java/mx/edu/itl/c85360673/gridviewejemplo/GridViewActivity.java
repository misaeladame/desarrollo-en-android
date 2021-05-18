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

    final Integer [] logos = { R.drawable.logo_dota2, R.drawable.logo_counter_strike,
                               R.drawable.logo_half_life, R.drawable.logo_l4d2,
                               R.drawable.logo_lol, R.drawable.logo_portal,
                               R.drawable.logo_rocket_league, R.drawable.logo_team_fortress_2  };

    private GridView grdvVideojuegos;
    private GridAdaptador  adaptador;

    //------------------------------------------------------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView ( R.layout.activity_grid_view);

        // Crear el Adapter y establecerlo como adapter en el GridView
        grdvVideojuegos = findViewById ( R.id.grdvVideojuegos);
        adaptador = new GridAdaptador ( this, R.layout.gridview_item_imagen, logos);
        grdvVideojuegos.setAdapter ( adaptador );

        grdvVideojuegos.setOnItemClickListener ( this );

    }

    //------------------------------------------------------------------------------------------

    @Override
    public void onItemClick ( AdapterView<?> adapterView, View view, int i, long l ) {
        Intent intent = new Intent( this, GridViewDetalleActivity.class );

        // Pasamos como argumento al otro activity el ID del recurso drawable del escudo seleccionado
        intent.putExtra ( "logo", logos[ i ] );
        startActivity ( intent );
    }

    //------------------------------------------------------------------------------------------

    public class GridAdaptador extends ArrayAdapter {
        private Integer [] logos;
        private int        layoutResId;
        private LayoutInflater inflater;

        //------------------------------------------------------------------------------------------
        // Constructor

        public GridAdaptador(@NonNull Context context, int resource, @NonNull Integer [] logos) {
            // Llamar al constructor de la clase padre y guardar los argumentos en variables de la clase
            super ( context, resource, logos);
            this.logos = logos;
            layoutResId = resource;
            inflater = LayoutInflater.from ( context );
        }

        //------------------------------------------------------------------------------------------

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            // Implementar la personalizacion de convertView inflando primero el layout que va a utilizar
            if ( convertView == null ) {
                convertView = inflater.inflate ( layoutResId, parent, false );
            }

            ImageView imgLogo = convertView.findViewById ( R.id.imgvLogo);
            imgLogo.setScaleType ( ImageView.ScaleType.FIT_XY );

            // Si al hacer deslizamiento por las imagenes se alenta se deberá sustituir la forma
            // tradicional de cargar el drawable por una forma mas eficiente, por ejemplo, con la
            // libreria Glide de BumpTech.
            // imgLogo.setImageResource ( escudos [ position ] )
            Glide.with( imgLogo.getContext() ).load ( logos[ position ] ).into ( imgLogo );

            return convertView;
        }

        //------------------------------------------------------------------------------------------
    }
}
