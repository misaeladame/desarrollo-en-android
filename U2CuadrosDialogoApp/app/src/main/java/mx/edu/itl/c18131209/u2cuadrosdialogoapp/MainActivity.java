/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                       INSTITUTO TECNOLOGICO DE LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: ENE-JUN/2021    HORA: 10-11 HRS
:*
:*          Clase que despliega distintos cuadros de mensaje y dialogos basicos
:*
:*  Archivo     : MainActivity.java
:*  Autor       : José Misael Adame Sandoval     18131209
:*  Fecha       : 16/Mar/2021
:*  Compilador  : Android Studio 4.1.2
:*  Descripción : Los diálogos de alerta a presentar serán los siguientes:
:*
:*                •	Toast de duracion corta
:*                •	Toast de duracion larga
:*                •	Mensaje Snack de duración corta
:*                •	Cuadro de dialogo simple
:*                •	Cuadro de dialogo con botón OK
:*                •	Cuadro de dialogo con botón OK y Cancelar
:*                •	Cuadro de dialogo con lista de opciones
:*                •	Cuadro de dialogo con lista de opciones selección única
:*                •	Cuadro de dialogo con lista de opciones selección multiple
:*                •	Cuadro de dialogo con un diseño de usuario y contraseña incrustado
:*                •	Cuadro de dialogo Acerca de
:*
:*  Ultima modif:
:*  Fecha       Modificó             Motivo
:*==========================================================================================
:*
:*------------------------------------------------------------------------------------------*/

package mx.edu.itl.c18131209.u2cuadrosdialogoapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //----------------------------------------------------------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //----------------------------------------------------------------------------------------------
    // Mensaje Toast de duracion corta

    public void btnToastCortoClick ( View v ) {
        Toast.makeText ( this, "Toast corto", Toast.LENGTH_SHORT ).show ();
    }

    //----------------------------------------------------------------------------------------------
    // Mensaje Toast de duracion larga

    public void btnToastLargoClick ( View v ) {
        Toast.makeText ( this, "Toast largo", Toast.LENGTH_LONG ).show ();
    }

    //----------------------------------------------------------------------------------------------
    // Mensaje Snackbar

    public void btnSnackClick ( View v ) {
        LinearLayout linearLayout = (LinearLayout) findViewById ( R.id.linearLayoutRaiz );

        Snackbar.make( linearLayout, "Esto es un Snackbar", Snackbar.LENGTH_SHORT ).show ();
    }

    //----------------------------------------------------------------------------------------------
    // Cuadro de dialogo basico

    public void btnDialogoBasicoClick ( View v ) {
        AlertDialog.Builder builder = new AlertDialog.Builder ( this );
        builder.setMessage ( "Cuadro de dialogo basico" ).create ().show ();
    }

    //----------------------------------------------------------------------------------------------
    // Cuadro de dialogo basico con boton OK

    public void btnDialogoBasicoOKClick ( View v ) {
        AlertDialog.Builder builder = new AlertDialog.Builder ( this );
        builder.setTitle ( "Android" )
                .setMessage ( "Dialogo basico con boton OK" )
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mostrarToast("Click en ACEPTAR" );
                    }
                })
                .create ()
                .show ();
    }

    //----------------------------------------------------------------------------------------------
    // Cuadro de dialogo basico con boton OK y CANCELAR

    public void btnDialogoBasicoOKCANCELClick ( View v ) {
        AlertDialog.Builder builder = new AlertDialog.Builder ( this );
        builder.setTitle ( "Android" )
                .setMessage ( "Dialogo basico con boton OK y CANCEL" )
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        mostrarToast("Click en ACEPTAR" );
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss ();
                    }
                })
                .create ()
                .show ();
    }

    //----------------------------------------------------------------------------------------------

    public void mostrarToast ( String mensaje ) {
        Toast.makeText ( this, mensaje, Toast.LENGTH_SHORT ).show ();
    }

    //----------------------------------------------------------------------------------------------
    // Cuadro de dialogo con lista de opciones basicas

    private CharSequence colores [] = { "Verde", "Blanco", "Rojo" };
    public void btnDialogoListaBasicaClick ( View V ) {
        AlertDialog.Builder builder = new AlertDialog.Builder ( this );
        builder.setTitle ( "Escoja un color bonito:" )
                .setItems(colores, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        mostrarToast ( "Color seleccionado: " + colores [ i ] );
                    }
                } )
                .create ()
                .show ();
    }

    //----------------------------------------------------------------------------------------------
    // Cuadro de dialogo con lista de opciones con botones de radio y seleccion unica

    int iColorFavorito = 2; // Por default el rojo
    public void btnDialogoListaSeleccionUnicaClick ( View v ) {
        AlertDialog.Builder builder = new AlertDialog.Builder ( this );
        builder.setTitle ( "Escoge tu color favorito:" )
                .setSingleChoiceItems(colores, iColorFavorito, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        iColorFavorito = i;
                        mostrarToast ( "Escogió: " + colores [ i ] );
                    }
                } )
                .setPositiveButton ( "Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        mostrarToast ( "Nuevo color favorito: " + colores [ iColorFavorito ] );
                    }
                } )
                .create ()
                .show ();

    }

    //----------------------------------------------------------------------------------------------
    // Cuadro de dialogo con lista de opciones con casillas de verificacion para seleccion múltiple

    private boolean coloresSeleccionados [] = { false, false, false }; // Ninguno aparecera seleccionado
    private ArrayList<String> coloresFavoritos = new ArrayList<> ();

    public void btnDialogoListaSeleccionMultipleClick ( View v ) {
        AlertDialog.Builder builder = new AlertDialog.Builder (this );
        builder.setTitle ( "Seleccione sus colores favoritos:" )
                .setMultiChoiceItems(colores, coloresSeleccionados, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                        if ( b ) {
                            mostrarToast ( "Color seleccionado: " + colores [ i ] );
                            coloresFavoritos.add ( colores [ i ].toString () );
                        }
                        else {
                            mostrarToast ("Color deseleccionado: " + colores [ i ] );
                            coloresFavoritos.remove ( colores [ i ].toString () );
                        }
                    }
                })
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        mostrarToast ("Colores favoritos: " + coloresFavoritos );
                    }
                })
                .create ()
                .show ();
    }

    //----------------------------------------------------------------------------------------------
    // Cuadro de dialogo con un layout de Login incrustado y botones Aceptar y Cancelar

    private View login_layout;
    private EditText edtUsuario;
    private EditText edtContrasena;

    public void btnDialogoLayoutIncrustadoClick ( View v ) {
        // Obtener la instancia del layout de Login y de sus campos Usuario y Contraseña
        login_layout = getLayoutInflater().inflate ( R.layout.login_layout, null );
        edtUsuario = login_layout.findViewById ( R.id.edtNombre );
        edtContrasena = login_layout.findViewById ( R.id.edtContrasena );

        AlertDialog.Builder builder = new AlertDialog.Builder ( this );
        builder.setTitle ( "Acceso" )
                .setIcon ( R.drawable.itl )
                .setView ( login_layout )
                .setPositiveButton("Entrar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        mostrarToast("Bienvenido: " +
                                edtUsuario.getText ().toString () + " (" +
                                edtContrasena.getText ().toString () + ")"
                        );
                    }
                })
                .setNegativeButton("Salir", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss (); // cerrar el dialogo sin hacer nada
                    }
                })
                .setCancelable ( false )
                .create ()
                .show ();
    }

    //----------------------------------------------------------------------------------------------
    // Cuadro de mensaje de ACERCA DE

    public void btnAcercaDeClick ( View v ) {
        AlertDialog.Builder builder = new AlertDialog.Builder ( this );
        builder.setTitle ( "Acerca de" )
                .setIcon ( R.drawable.itl )
                .setMessage ( "CuadrosDialogoApp v1.0 \n\n" +
                              "TecNM Campus La Laguna \n\n" +
                              "por Jose Misael Adame Sandoval (18131209) \n\n" +
                              "(C) Derechos reservados 2021. Torreon, Coah. Mexico" )
                .create ()
                .show ();
    }

    //----------------------------------------------------------------------------------------------
}