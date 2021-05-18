package mx.edu.itl.c85360673.gridviewejemplo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class GridViewDetalleActivity extends AppCompatActivity {

    private ImageView imgvLogoDetalle;

    //------------------------------------------------------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view_detalle);
        getSupportActionBar().hide();

        imgvLogoDetalle = findViewById ( R.id.imgvLogoDetalle);

        // Recuperamos de los argumentos del activity el ID del drawable del logo a mostrar
        Integer logo = getIntent ().getIntExtra ( "logo", 0 );

        imgvLogoDetalle.setScaleType ( ImageView.ScaleType.FIT_XY );
        // Reemplazamos la forma tradicional de cargar el recurso ImageView por la libreria Glide
        // imgvEscudoDetalle.setImageResource ( logo );
        Glide.with ( imgvLogoDetalle.getContext() ).load( logo ).into (imgvLogoDetalle);

    }

     //------------------------------------------------------------------------------------------
}
