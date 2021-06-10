package mx.edu.itl.c18131209.u5preferenciasapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnAbrirPreferenciasClick ( View v ) {
        Intent intent = new Intent ( this, PreferenciasActivity.class );
        startActivity ( intent );
    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences pref = getSharedPreferences ( "mx.edu.itl.c18131209.u5preferenciasapp_preferences", MODE_PRIVATE );

        if ( pref != null  ) {
            boolean reprodMusica = pref.getBoolean ( "reproducir_musica", false );
            int tipoGraficos = Integer.parseInt ( pref.getString ( "tipo_de_graficos", "100" ) );
            int numFragmentos = Integer.parseInt ( pref.getString ( "numero_de_fragmentos", "44" ) );
            boolean activarModoMultilple = pref.getBoolean ( "activar_modo_multiple", false );
            String tonoAlarma = pref.getString ( "tono_de_alarma", "<ninguno>" );

            AlertDialog.Builder builder = new AlertDialog.Builder ( this );
            builder.setMessage ( "Reproducir musica: " + reprodMusica + "\n" +
                    "Tipo de Graficos:  " + tipoGraficos + "\n" +
                    "No. Fragmentos  :  " + numFragmentos + "\n" +
                    "Activar Modo Mult: " + activarModoMultilple + "\n" +
                    "Tono de alarma:    " + tonoAlarma
            )
                    .create()
                    .show();

        } else {
            Toast.makeText ( this, "No se encontro el archivo de preferencias", Toast.LENGTH_LONG ).show ();
        }

    }
}