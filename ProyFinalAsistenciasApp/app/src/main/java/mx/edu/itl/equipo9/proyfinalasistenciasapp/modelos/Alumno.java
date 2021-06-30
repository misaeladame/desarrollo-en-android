/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                       INSTITUTO TECNOLOGICO DE LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: ENE-JUN/2021    HORA: 10-11 HRS
:*
:*            Clase Alumno que nos permitira tener ciertas variables para poder utilizar.
:*
:*  Archivo     : Alumno.java
:*  Autor       : Jose Misael Adame Sandoval     18131209
:*                Cristian Barajas Cabrales      17130764
:*                Salma Lizeth Mazuca Reyna      17130801
:*                Cristian Gabriel Piña Rosales  18130588
:*  Fecha       : 25/06/2021
:*  Compilador  : Android Studio 4.0.1
:*  Descripcion : Clase Alumno que nos permitira tener ciertas variables para poder utilizar al momento de
:*                cargar los archivos.
:*  Ultima modif:
:*  Fecha       Modificacion             Motivo
:*==========================================================================================
:*  dd/mmm/aaaa Fulanito de tal       Motivo de la modificacion, puede ser en mas de 1 renglon.
:*------------------------------------------------------------------------------------------*/

package mx.edu.itl.equipo9.proyfinalasistenciasapp.modelos;

public class Alumno {

    //----------------------------------------------------------------------------------------------
    //Variables que constituiran la clase Alumno.
    private String numeroDeControl;
    private String nombreCompleto;
    //==============================================================================================

    //----------------------------------------------------------------------------------------------
    //Constructor de la clase alumno.
    public Alumno ( String numeroDeControl, String nombreCompleto ) {
        this.numeroDeControl = numeroDeControl;
        this.nombreCompleto = nombreCompleto;
    }
    //==============================================================================================

    //----------------------------------------------------------------------------------------------
    //Getter que permitira el regresar la variable numeroDeControl.
    public String getNumeroDeControl() {
        return numeroDeControl;
    }
    //==============================================================================================

    //----------------------------------------------------------------------------------------------
    //Setter que permitira recibir la variable numeroDeControl.
    public void setNumeroDeControl(String numeroDeControl) {
        this.numeroDeControl = numeroDeControl;
    }
    //==============================================================================================

    //----------------------------------------------------------------------------------------------
    //Getter que permitira el regresar la variable nombreCompleto.
    public String getNombreCompleto() {
        return nombreCompleto;
    }
    //==============================================================================================

    //----------------------------------------------------------------------------------------------
    //Setter que permitira recibir la variable nombreCompleto.
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }
    //==============================================================================================

}
