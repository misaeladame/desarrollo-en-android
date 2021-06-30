/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                       INSTITUTO TECNOLOGICO DE LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: ENE-JUN/2021    HORA: 10-11 HRS
:*
:*        Clase Asistencias que nos permitira tener ciertas variables para poder utilizar.
:*
:*  Archivo     : Asistencia.java
:*  Autor       : Jose Misael Adame Sandoval     18131209
:*                Cristian Barajas Cabrales      17130764
:*                Salma Lizeth Mazuca Reyna      17130801
:*                Cristian Gabriel Piña Rosales  18130588
:*  Fecha       : 25/06/2021
:*  Compilador  : Android Studio 4.0.1
:*  Descripcion : Clase Asistencias que nos permitira tener ciertas variables para poder utilizar
:*                al momento de cargar los archivos.
:*  Ultima modif:
:*  Fecha       Modificacion             Motivo
:*==========================================================================================
:*  dd/mmm/aaaa Fulanito de tal       Motivo de la modificacion, puede ser en mas de 1 renglon.
:*------------------------------------------------------------------------------------------*/

package mx.edu.itl.equipo9.proyfinalasistenciasapp.modelos;

public class Asistencias {

    //----------------------------------------------------------------------------------------------
    //Variables que constituiran la Asistencias.
    private int id;
    private String numeroDeControl;
    private String alumno;
    private String materia;
    private int presente;
    private int justificado;
    private int total;
    private String porcentaje;
    //==============================================================================================

    //----------------------------------------------------------------------------------------------
    //Constructor de la clase Asistencias.
    public Asistencias() {
        this.id = 0;
        this.numeroDeControl = "";
        this.alumno = "";
        this.materia = "";
        this.presente = 0;
        this.justificado = 0;
        this.total = 0;
    }
    //==============================================================================================

    //----------------------------------------------------------------------------------------------
    //Getter que permitira el regresar la variable id.
    public int getId() {
        return id;
    }
    //==============================================================================================

    //----------------------------------------------------------------------------------------------
    //Setter que permitira recibir la variable id.
    public void setId(int id) {
        this.id = id;
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
    //Getter que permitira el regresar la variable alumno.
    public String getAlumno() {
        return alumno;
    }
    //==============================================================================================

    //----------------------------------------------------------------------------------------------
    //Setter que permitira recibir la variable alumno.
    public void setAlumno(String alumno) {
        this.alumno = alumno;
    }
    //==============================================================================================

    //----------------------------------------------------------------------------------------------
    //Getter que permitira el regresar la variable materia.
    public String getMateria() {
        return materia;
    }
    //==============================================================================================

    //----------------------------------------------------------------------------------------------
    //Setter que permitira recibir la variable materia.
    public void setMateria(String materia) {
        this.materia = materia;
    }
    //==============================================================================================

    //----------------------------------------------------------------------------------------------
    //Getter que permitira el regresar la variable presente.
    public int getPresente() {
        return presente;
    }
    //==============================================================================================

    //----------------------------------------------------------------------------------------------
    //Setter que permitira recibir la variable presente.
    public void setPresente(int presente) {
        this.presente += presente;
    }
    //==============================================================================================

    //----------------------------------------------------------------------------------------------
    //Getter que permitira el regresar la variable justificado.
    public int getJustificado() {
        return justificado;
    }
    //==============================================================================================

    //----------------------------------------------------------------------------------------------
    //Setter que permitira recibir la variable justificado.
    public void setJustificado(int justificado) {
        this.justificado += justificado;
    }
    //==============================================================================================

    //----------------------------------------------------------------------------------------------
    //Getter que permitira el regresar la variable total.
    public int getTotal() {
        return total;
    }
    //==============================================================================================

    //----------------------------------------------------------------------------------------------
    //Setter que permitira recibir la variable total.
    public void setTotal(int total) {
        this.total = total;
    }
    //==============================================================================================

    //----------------------------------------------------------------------------------------------
    //Getter que permitira el regresar la variable porcentaje.
    public String getPorcentaje () {
        return porcentaje;
    }
    //==============================================================================================

    //----------------------------------------------------------------------------------------------
    //Setter que permitira recibir y calcular la variable porcentaje.
    public void setPorcentaje (String materia, int total ) {
        int resultado = 0;
        switch ( materia ) {
            case "ANDR":
                resultado = (int) (( total / 51f ) * 100);
                this.porcentaje = resultado + " %";
                break;
            case "LA2":
                resultado = (int) (( total / 61f ) * 100);
                this.porcentaje = resultado + " %";
                break;
            case "TAP":
                resultado = (int) (( total / 52f ) * 100);
                this.porcentaje = resultado + " %";
                break;
            default:
        }
    }
    //==============================================================================================

}
