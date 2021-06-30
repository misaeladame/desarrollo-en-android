/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                       INSTITUTO TECNOLOGICO DE LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: ENE-JUN/2021    HORA: 10-11 HRS
:*
:*     Pantalla principal de la app que muestra botones para revisar alumnos, asistencia y materia
:*
:*  Archivo     : MainActivity.java
:*  Autor       : Jose Misael Adame Sandoval     18131209
:*                Cristian Barajas Cabrales      17130764
:*                Salma Lizeth Mazuca Reyna      17130801
:*                Cristian Gabriel Piña Rosales  18130588
:*  Fecha       : 25/06/2021
:*  Compilador  : Android Studio 4.0.1
:*  Descripcion : Pantalla principal de la app que muestra botones para revisar alumnos, asistencia
:*               y materia
:*  Ultima modif:
:*  Fecha       Modificacion             Motivo
:*==========================================================================================
:*  dd/mmm/aaaa Fulanito de tal       Motivo de la modificacion, puede ser en mas de 1 renglon.
:*------------------------------------------------------------------------------------------*/

package mx.edu.itl.equipo9.proyfinalasistenciasapp.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import mx.edu.itl.c18131209.androidlib.util.permisos.ChecadorDePermisos;
import mx.edu.itl.c18131209.androidlib.util.permisos.PermisoApp;
import mx.edu.itl.equipo9.proyfinalasistenciasapp.R;

public class MainActivity extends AppCompatActivity {

    //----------------------------------------------------------------------------------------------
    //Arreglo que nos permite ver nuestra libreria para ver cuantos permisos tiene esta app
    private final PermisoApp [] permisosReq = new PermisoApp [] {
            new PermisoApp ( Manifest.permission.READ_EXTERNAL_STORAGE, "Almacenamiento", true )
    };
    //==============================================================================================

    //----------------------------------------------------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ChecadorDePermisos.checarPermisos ( this, permisosReq );
    }
    //==============================================================================================

    //----------------------------------------------------------------------------------------------
    //OnRequestPermissionsResult que nos permie ver si el permiso fue aceptado
    @SuppressLint("MissingSuperCall")
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == ChecadorDePermisos.CODIGO_PEDIR_PERMISOS) {
            ChecadorDePermisos.verificarPermisosSolicitados(this, permisosReq, permissions, grantResults);
        }
    }
    //==============================================================================================

    //----------------------------------------------------------------------------------------------
    //Metodo de boton que nos permite ir al AcercaDeActivity y mostrar su xml
    public void btnAcercaDeClick ( View v ) {
        Intent intent = new Intent ( this, AcercaDeActivity.class );
        startActivity ( intent );
    }
    //==============================================================================================

    //----------------------------------------------------------------------------------------------
    //Metodo de boton que nos permite ir al AlumnosActivity y mostrar su xml
    public void btnAlumnosClick ( View v ) {
        Intent intent = new Intent ( this, AlumnosActivity.class );
        startActivity ( intent );
    }
    //==============================================================================================

    //----------------------------------------------------------------------------------------------
    //Metodo de boton que nos permite ir al MateriasActivity y mostrar su xml
    public void btnMateriasClick ( View v ) {
        Intent intent = new Intent ( this, MateriasActivity.class );
        startActivity ( intent );
    }
    //==============================================================================================

    //----------------------------------------------------------------------------------------------
    //Metodo de boton que nos permite ir al AsistenciasActivity y mostrar su xml
    public void btnAsistenciasClick ( View v ) {
        Intent intent = new Intent ( this, AsistenciasActivity.class );
        startActivity ( intent );
    }
    //==============================================================================================

}