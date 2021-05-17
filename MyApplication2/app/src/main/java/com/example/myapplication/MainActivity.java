package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    TextView edtxtdFecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtxtdFecha = findViewById(R.id.edtxtdFecha );

        Date fechaActual = Calendar.getInstance().getTime();

        edtxtdFecha.setText ( fechaActual.toString() );

    }
}