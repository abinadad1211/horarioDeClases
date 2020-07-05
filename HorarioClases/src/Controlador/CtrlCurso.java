package Controlador;

import Modelo.Curso;
import Modelo.MetodosCurso;
import Vista.ConsultaExpEdu;
import java.awt.event.*;
import java.util.*;
import javax.swing.JTable;
import javax.swing.table.*;

public class CtrlCurso implements ActionListener{
    MetodosCurso metodosCurso = new MetodosCurso();
    Curso curso = new Curso();
    ConsultaExpEdu consultaExpEdu = new ConsultaExpEdu();
    DefaultTableModel modelo = new DefaultTableModel();

    public CtrlCurso(ConsultaExpEdu consultaExpEdu){
        this.consultaExpEdu = consultaExpEdu;
        this.consultaExpEdu.btnConsultaExpEdu.addActionListener(this);
        this.consultaExpEdu.btnConsultaNRC.addActionListener(this);
    }
  
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == consultaExpEdu.btnConsultaExpEdu) {
            consultaExpEdu.tblExpEdu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NRC", "Experiencia Educativa", "Profesor"
            }
            ));
            MostrarDatosExpEdu(consultaExpEdu.tblExpEdu);
        }
        if (e.getSource() == consultaExpEdu.btnConsultaNRC) {
            consultaExpEdu.tblExpEdu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NRC", "Experiencia Educativa", "Profesor"
            }
            ));
            MostrarDatosNrc(consultaExpEdu.tblExpEdu);
        }
    }

    public void MostrarDatosExpEdu(JTable tblExpEdu){
        modelo = (DefaultTableModel)tblExpEdu.getModel();
        @SuppressWarnings("unchecked")
        List<Curso>lista=metodosCurso.BusquedaCursoExpEdu(curso, consultaExpEdu.txtExpEdu.getText());
        Object[]object = new Object [3];
        for (int i = 0; i < lista.size(); i++) {
            object[0] = lista.get(i).getNrc();
            object[1] = lista.get(i).getExperienciaEducativa();
            object[2] = lista.get(i).getProfesor();
            modelo.addRow(object);
        }
        consultaExpEdu.tblExpEdu.setModel(modelo);
    }
    
    public void MostrarDatosNrc(JTable tblExpEdu){
        modelo = (DefaultTableModel)tblExpEdu.getModel();
        @SuppressWarnings("unchecked")
        List<Curso> lista = metodosCurso.BusquedaCursoNRC(curso, consultaExpEdu.txtNRC.getText());
        Object[]object = new Object [3];
        for (int i = 0; i < lista.size(); i++) {
            object[0] = lista.get(i).getNrc();
            object[1] = lista.get(i).getExperienciaEducativa();
            object[2] = lista.get(i).getProfesor();
            modelo.addRow(object);
        }
        consultaExpEdu.tblExpEdu.setModel(modelo);
    }
    
    public void InsertarCurso (){
        
    }
    
}
 