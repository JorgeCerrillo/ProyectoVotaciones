package Modelo;

/**
 *
 * @author Jorge
 */
public class Votante {

    private int id;
    private String dni;
    private String contraseña;
    private boolean votado;

    public Votante(int id) {
        this.id = id;
    }

    public Votante(String dni) {
        this.dni = dni;
    }

    public Votante(String dni, String contraseña) {
        this(dni);

        this.contraseña = contraseña;

    }

    public Votante(int id, String dni, String contraseña, boolean votado) {
        
        this(dni, contraseña);
        this.id=id;
        this.votado=votado;
        
        

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String Contraseña) {
        this.contraseña = Contraseña;
    }

    public boolean isVotado() {
        return votado;
    }

    public void setVotado(boolean votado) {
        this.votado = votado;
    }

    @Override
    public String toString() {
        return "Votante{" + "id=" + id + ", dni=" + dni + ", password=" + contraseña + ", votado=" + votado + '}';
    }
}
