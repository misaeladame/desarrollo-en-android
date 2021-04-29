package mx.edu.itl.c18131209.elbolaapp;

public class MiSingleton {
    private MiSingleton instancia = null;

    // Declarar las variables que seran compartidos por el Singleton
    private String usuario;
    private String contrasena;

    private MiSingleton () {
        // Inicializaciones de los datos compartidos
        usuario = "";
        contrasena = "";
    }

    public MiSingleton getInstancia () {
        if ( instancia == null ) {
            instancia = new MiSingleton ();
        }
        return instancia;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

}
