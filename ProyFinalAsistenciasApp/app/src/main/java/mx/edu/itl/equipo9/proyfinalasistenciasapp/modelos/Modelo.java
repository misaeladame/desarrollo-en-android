/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                       INSTITUTO TECNOLOGICO DE LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: ENE-JUN/2021    HORA: 10-11 HRS
:*
:*    Clase Modelo que nos permitira saber el estado e inserciones a la base de datos.
:*
:*  Archivo     : Modelo.java
:*  Autor       : Jose Misael Adame Sandoval     18131209
:*                Cristian Barajas Cabrales      17130764
:*                Salma Lizeth Mazuca Reyna      17130801
:*                Cristian Gabriel Piña Rosales  18130588
:*  Fecha       : 25/06/2021
:*  Compilador  : Android Studio 4.0.1
:*  Descripcion : Clase Modelo que nos permitira saber el estado de la base de datos y a su
:*                hacerle sus respectivas modificaciones.
:*  Ultima modif:
:*  Fecha       Modificacion             Motivo
:*==========================================================================================
:*  dd/mmm/aaaa Fulanito de tal       Motivo de la modificacion, puede ser en mas de 1 renglon.
:*------------------------------------------------------------------------------------------*/

package mx.edu.itl.equipo9.proyfinalasistenciasapp.modelos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import mx.edu.itl.equipo9.proyfinalasistenciasapp.bd.ConexionSQLite;
import mx.edu.itl.equipo9.proyfinalasistenciasapp.modelos.Alumno;

public class Modelo {

    //----------------------------------------------------------------------------------------------
    //Metodo que nos permite saber y regresar el estado de la base de datos
    public SQLiteDatabase getConn ( Context context ) {
        ConexionSQLite conn = new ConexionSQLite ( context,"dbasistencias", null, 1 );
        SQLiteDatabase db = conn.getWritableDatabase ();
        return db;
    }
    //==============================================================================================

    //----------------------------------------------------------------------------------------------
    //Metodo que nos permite colocar el alumno en la tabla SQLite Alumno
    public int insertaAlumno(Context context, Alumno alum) {
        int res = 0;
        String sql = "INSERT INTO Alumno (alu_numero_control, alu_nombre_completo)" +
                     "VALUES ('"+alum.getNumeroDeControl ()+"','"+alum.getNombreCompleto ()+"')";

        SQLiteDatabase db = this.getConn(context);
        try {
            db.execSQL(sql);
            res = 1;
        } catch ( Exception e ) {
            e.printStackTrace();
        }
        return res;
    }
    //==============================================================================================

    //----------------------------------------------------------------------------------------------
    //Metodo que nos permite colocar el alumno en la tabla SQLite Materia
    public int insertaMateria(Context context, Materia mat) {
        int res = 0;
        String sql = "INSERT INTO Materia (mat_clave, mat_nombre)" +
                      "VALUES ('"+mat.getClave ()+"','"+mat.getNombre () +"')";

        SQLiteDatabase db = this.getConn(context);
        try {
            db.execSQL(sql);
            res = 1;
        } catch ( Exception e ) {
            e.printStackTrace();
        }
        return res;
    }
    //==============================================================================================

}
