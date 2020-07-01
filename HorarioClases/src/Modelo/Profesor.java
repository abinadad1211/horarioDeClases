package Modelo;

/**
 *
 * @author Luis
 * @author Abinadad
 */
public class Profesor {
    protected String idProfesor;
    protected String nombre;
    protected String apellidoMaterno;
    protected String apellidoPaterno;
 
    public Profesor() {
    }

    public Profesor(String idProfesor, String nombre, String apellidoMaterno, String apellidoPaterno) {
        this.idProfesor = idProfesor;
        this.nombre = nombre;
        this.apellidoMaterno = apellidoMaterno;
        this.apellidoPaterno = apellidoPaterno;
    }
    
    public String getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(String idProfesor) {
        this.idProfesor = idProfesor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }  
}
