package mx.edu.itl.c18131209.u5preferenciasapp;

import android.os.Bundle;
import android.preference.PreferenceActivity;

public class PreferenciasActivity extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource ( R.xml.pantalla_preferencias );

    }
}