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
    protected enum diaSemana{Lunes, Martes, Miercoles, Jueves, Viernes, Sabado}; //Falta ver ocmo funcionan los enums
    protected String horaDia; //Se puede hacer enum
    protected String salon;    

    public Reservacion() { //Agregar constructores
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

    
}


