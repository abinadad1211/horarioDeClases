/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Luis
 */
public class Horario {
    protected String folioHorario;
    protected String grupo;
    protected String programaEducativo;

    public Horario(String folioHorario, String grupo, String programaEducativo) {
        this.folioHorario = folioHorario;
        this.grupo = grupo;
        this.programaEducativo = programaEducativo;
    }
   
    public String getFolioHorario() {
        return folioHorario;
    }

    public void setFolioHorario(String folioHorario) {
        this.folioHorario = folioHorario;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getProgramaEducativo() {
        return programaEducativo;
    }

    public void setProgramaEducativo(String programaEducativo) {
        this.programaEducativo = programaEducativo;
    }
    
    
}
