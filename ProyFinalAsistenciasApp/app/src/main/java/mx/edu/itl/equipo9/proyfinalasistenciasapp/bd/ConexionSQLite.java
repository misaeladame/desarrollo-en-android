/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                       INSTITUTO TECNOLOGICO DE LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: ENE-JUN/2021    HORA: 10-11 HRS
:*
:*                Clase que nos permite crear las tablas y la conexion a SQLite.
:*
:*  Archivo     : ConexionSQLite.java
:*  Autor       : Jose Misael Adame Sandoval     18131209
:*                Cristian Barajas Cabrales      17130764
:*                Salma Lizeth Mazuca Reyna      17130801
:*                Cristian Gabriel Piña Rosales  18130588
:*  Fecha       : 25/06/2021
:*  Compilador  : Android Studio 4.0.1
:*  Descripcion : Clase que nos permite crear las tablas y la conexion a SQLite con la
:*                base de datos realizada.
:*  Ultima modif:
:*  Fecha       Modificacion             Motivo
:*==========================================================================================
:*  dd/mmm/aaaa Fulanito de tal       Motivo de la modificacion, puede ser en mas de 1 renglon.
:*------------------------------------------------------------------------------------------*/

package mx.edu.itl.equipo9.proyfinalasistenciasapp.bd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ConexionSQLite extends SQLiteOpenHelper {

    //----------------------------------------------------------------------------------------------
    //Creacion de la tabla de Alumnos para poder almacenar los datos temporalmente
    final String TABLA_ALUMNO = "CREATE TABLE Alumno ( alu_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                                                      "alu_numero_control TEXT NOT NULL UNIQUE," +
                                                      "alu_nombre_completo TEXT NOT NULL)";
    //==============================================================================================

    //----------------------------------------------------------------------------------------------
    //Creacion de la tabla de Materias para poder almacenar los datos temporalmente
    final String TABLA_MATERIA = "CREATE TABLE Materia ( mat_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                                                        "mat_clave TEXT NOT NULL UNIQUE," +
                                                        "mat_nombre TEXT NOT NULL)";
    //==============================================================================================

    //----------------------------------------------------------------------------------------------
    //Creacion de la tabla de Asistencias para poder almacenar los datos temporalmente
    final String TABLA_ASISTENCIAS = "CREATE TABLE Asistencia ( asi_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                                                 "alu_numero_control TEXT NOT NULL, " +
                                                                 "mat_nombre INTEGER NOT NULL, " +
                                                                 "asi_fecha DATE NOT NULL," +
                                                                 "asi_presente INTEGER NOT NULL," +
                                                                 "asi_justificado INTEGER NOT NULL)";
    //==============================================================================================


    //----------------------------------------------------------------------------------------------
    //Eliminacion de las tablas
    final String ELIMINAR_TABLA_ALUMNOS = "DROP TABLE Alumno";
    final String ELIMINAR_TABLA_MATERIA = "DROP TABLE Materia";
    //==============================================================================================

    //----------------------------------------------------------------------------------------------
    //Metodo que nos permite crear la conexion de las tablas
    public ConexionSQLite(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    //==============================================================================================

    //----------------------------------------------------------------------------------------------
    //OnCreate que nos permine la creacion de las tablas
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL ( TABLA_ALUMNO );
        sqLiteDatabase.execSQL ( TABLA_MATERIA );
        sqLiteDatabase.execSQL ( TABLA_ASISTENCIAS );
    }
    //==============================================================================================

    //----------------------------------------------------------------------------------------------
    //OnUpgrade que nos permite realizar ciertas acciones y actualizaciones
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL ( ELIMINAR_TABLA_ALUMNOS );
        sqLiteDatabase.execSQL ( ELIMINAR_TABLA_MATERIA );
        onCreate ( sqLiteDatabase );
    }
    //==============================================================================================

}
