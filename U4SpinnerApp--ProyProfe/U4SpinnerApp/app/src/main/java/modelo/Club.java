package modelo;

public class Club {
    private String nombre;
    private int    escudoID;

    public Club ( String nombre, int escudoID ) {
        this.nombre = nombre;
        this.escudoID = escudoID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEscudoID() {
        return escudoID;
    }

    public void setEscudoID(int escudoID) {
        this.escudoID = escudoID;
    }
}
