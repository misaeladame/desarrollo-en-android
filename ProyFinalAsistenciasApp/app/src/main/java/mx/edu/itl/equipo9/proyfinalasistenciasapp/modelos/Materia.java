/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                       INSTITUTO TECNOLOGICO DE LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: ENE-JUN/2021    HORA: 10-11 HRS
:*
:*            Clase Materia que nos permitira tener ciertas variables para poder utilizar.
:*
:*  Archivo     : Materia.java
:*  Autor       : Jose Misael Adame Sandoval     18131209
:*                Cristian Barajas Cabrales      17130764
:*                Salma Lizeth Mazuca Reyna      17130801
:*                Cristian Gabriel Piña Rosales  18130588
:*  Fecha       : 25/06/2021
:*  Compilador  : Android Studio 4.0.1
:*  Descripcion : Clase Materia que nos permitira tener ciertas variables para poder utilizar
:*                al momento de cargar los archivos.
:*  Ultima modif:
:*  Fecha       Modificacion             Motivo
:*==========================================================================================
:*  dd/mmm/aaaa Fulanito de tal       Motivo de la modificacion, puede ser en mas de 1 renglon.
:*------------------------------------------------------------------------------------------*/

package mx.edu.itl.equipo9.proyfinalasistenciasapp.modelos;

public class Materia {

    //----------------------------------------------------------------------------------------------
    //Variables que constituiran la clase Materia.
    private String clave;
    private String nombre;
    //==============================================================================================

    //----------------------------------------------------------------------------------------------
    //Constructor de la clase Materia.
    public Materia (String clave, String nombre) {
        this.clave = clave;
        this.nombre = nombre;
    }
    //==============================================================================================

    //----------------------------------------------------------------------------------------------
    //Getter que permitira el regresar la variable clave.
    public String getClave() {
        return clave;
    }
    //==============================================================================================

    //----------------------------------------------------------------------------------------------
    //Setter que permitira recibir la variable clave.
    public void setClave(String clave) {
        this.clave = clave;
    }
    //==============================================================================================

    //----------------------------------------------------------------------------------------------
    //Getter que permitira el regresar la variable nombre.
    public String getNombre() {
        return nombre;
    }
    //==============================================================================================

    //----------------------------------------------------------------------------------------------
    //Setter que permitira recibir la variable nombre.
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    //==============================================================================================

}
