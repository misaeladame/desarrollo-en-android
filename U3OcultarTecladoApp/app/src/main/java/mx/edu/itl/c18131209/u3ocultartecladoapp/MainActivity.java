package mx.edu.itl.c18131209.u3ocultartecladoapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.Toast;

import mx.edu.itl.c18131209.util.ClickLayoutAdaptadora;

public class MainActivity extends AppCompatActivity {

    LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout = (LinearLayout) findViewById ( R.id.layoutMain );
        layout.setOnClickListener ( new ClickLayoutAdaptadora (this ) );
    }

    @Override
    public void onBackPressed () {
        // Hacer nada cuando se pulse el botón ATRAS del dispositivo
    }

    @Override
    public boolean onCreateOptionsMenu ( Menu menu ) {
        getMenuInflater().inflate ( R.menu.menu_main_activity, menu );
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch ( id ) {
            case R.id.mniAcercaDe :
                Toast.makeText ( getApplicationContext(), "Acerca de..", Toast.LENGTH_SHORT ).show();
                break;
            case R.id.mniSalir :
                finish ();
        }

        return super.onOptionsItemSelected(item);
    }
}