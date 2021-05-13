package modelo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import mx.edu.itl.c85360673.u3spinnerejemploapp.R;

public class SpinnerClubesAdapter extends ArrayAdapter<Club> {

    //----------------------------------------------------------------------------------------------
    // Constructor

    public SpinnerClubesAdapter ( @NonNull Context context, ArrayList<Club> clubes ) {
        super ( context, 0, clubes );
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return inicializarView ( position, convertView, parent );
    }

    @Override
    public View getDropDownView ( int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return inicializarView ( position, convertView, parent );
    }

    //----------------------------------------------------------------------------------------------
    // Metodo personalizado para inicializar la vista del elemento dado por el argumento position

    private View inicializarView ( int position, @Nullable View convertView, @NonNull ViewGroup parent ) {
        // Configurar el View llamado convertView para inflar  spinner_fila_imagen_texto  y
        // establecer la imagen del logo del club y el nombre del club en el layout.


        return convertView;
    }

    //----------------------------------------------------------------------------------------------
}
