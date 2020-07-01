package horarioclases;

/**
 * @author Alexis
 */

public class Curso{
    protected String nrc;
    protected String expEducativa;
    protected String profesor; 
    
    public Curso(String nrc, String exp_educativa, String profesor) {
        this.nrc = nrc;
        this.expEducativa = exp_educativa;
        this.profesor = profesor;
    }
    
    public String getNrc() {
        return nrc;
    }

    public void setNrc(String nrc) {
        this.nrc = nrc;
    }

    public String getExp_educativa() {
        return expEducativa;
    }

    public void setExp_educativa(String exp_educativa) {
        this.expEducativa = exp_educativa;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }
   
    
}