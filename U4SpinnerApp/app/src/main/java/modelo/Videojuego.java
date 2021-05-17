package modelo;

public class Videojuego {
    private String nombre;
    private int logoID;

    public Videojuego(String nombre, int logoID) {
        this.nombre = nombre;
        this.logoID = logoID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getLogoID() {
        return logoID;
    }

    public void setLogoID(int logoID) {
        this.logoID = logoID;
    }
}
