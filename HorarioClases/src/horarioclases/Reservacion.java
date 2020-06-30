/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package horarioclases;

/**
 *
 * @author Luis
 */
public class Reservacion {
    protected enum diaSemana{LUNES, MARTES, MIERCOLES, JUEVES, VIERNES, SABADO}; //Falta ver ocmo funcionan los enums
    protected String horaDia; //Se puede hacer enum
    protected String salon;  
    
    diaSemana diaSemana;

    public Reservacion(String horaDia, String salon, diaSemana diaSemana) {
        this.horaDia = horaDia;
        this.salon = salon;
        this.diaSemana = diaSemana;
    }

    
    public String getHoraDia() {
        return horaDia;
    }

    public void setHoraDia(String horaDia) {
        this.horaDia = horaDia;
    }

    public String getSalon() {
        return salon;
    }

    public void setSalon(String salon) {
        this.salon = salon;
    }

    public diaSemana getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(diaSemana diaSemana) {
        this.diaSemana = diaSemana;
    }
    
}


