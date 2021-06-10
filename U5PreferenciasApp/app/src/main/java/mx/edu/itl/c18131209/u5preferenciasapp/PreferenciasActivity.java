package mx.edu.itl.c18131209.u5preferenciasapp;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;

public class PreferenciasActivity extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // addPreferencesFromResource ( R.xml.pantalla_preferencias );
        getFragmentManager().beginTransaction().replace ( android.R.id.content, new PreferenciasFragment () ).commit ();
    }

    public static class PreferenciasFragment extends PreferenceFragment {
        @Override
        public void onCreate ( final Bundle savedInstanceState ) {
            super.onCreate ( savedInstanceState );
            addPreferencesFromResource ( R.xml.pantalla_preferencias );
        }
    }
}