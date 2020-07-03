/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Curso;
import Modelo.MetodosCurso;
import Modelo.MetodosProfesores;
import Modelo.Profesor;
import Modelo.Recipiente;
import Modelo.Reservacion;
import Vista.ConsultaExpEdu;
import Vista.ConsultaProfesores;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Luis
 */
public class CtrlProfesores implements ActionListener{
    
    MetodosProfesores metodosProfesores = new MetodosProfesores();
    Recipiente recipiente = new Recipiente();
    ConsultaProfesores consultaProfesores = new ConsultaProfesores();
    DefaultTableModel modeloSalon = new DefaultTableModel();

    public CtrlProfesores( ConsultaProfesores consultaProfesores ) {
        this.consultaProfesores = consultaProfesores;
        this.consultaProfesores.btnBuscarProfesor.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
            if (e.getSource() == consultaProfesores.btnBuscarProfesor) {
            consultaProfesores.tblHorarioProfesores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Experiencia Educativa", "NRC", "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado"
            }
            ));
            MostrarDatosExpEdu(consultaProfesores.tblHorarioProfesores);
        }
    }
    
    public void MostrarDatosExpEdu(JTable tblExpEdu){
      modeloSalon = (DefaultTableModel)tblExpEdu.getModel();
      @SuppressWarnings("unchecked")
      List<Recipiente>lista=metodosProfesores.BusquedaProfesor(recipiente, consultaProfesores.txtNombreProfesor.getText());
      Object[]object = new Object [8];
      for (int i = 0; i < lista.size(); i++) {
        object[0] = lista.get(i).getExperienciaEducativa();
        object[1] = lista.get(i).getNrc();
        object[2] = lista.get(i).getDiaLunes();
        object[3] = lista.get(i).getDiaMartes();
        object[4] = lista.get(i).getDiaMiercoles();
        object[5] = lista.get(i).getDiaJueves();
        object[6] = lista.get(i).getDiaViernes();
        object[7] = lista.get(i).getDiaSabado();
        modeloSalon.addRow(object);
      }
      consultaProfesores.tblHorarioProfesores.setModel(modeloSalon);
    }
    
}
