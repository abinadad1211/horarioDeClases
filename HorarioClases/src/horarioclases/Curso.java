/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package horarioclases;

/**
 *
 * @author Alexis
 */

public class Curso{
    protected String nrc;
    protected String exp_educativa;
    protected String profesor;

    public Curso(String nrc, String exp_educativa, String profesor) {
        this.nrc = nrc;
        this.exp_educativa = exp_educativa;
        this.profesor = profesor;
    }
    
    public String getNrc() {
        return nrc;
    }

    public void setNrc(String nrc) {
        this.nrc = nrc;
    }

    public String getExp_educativa() {
        return exp_educativa;
    }

    public void setExp_educativa(String exp_educativa) {
        this.exp_educativa = exp_educativa;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }
   
    
}