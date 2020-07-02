package Controlador;

import Modelo.Curso;
import Modelo.MetodosCurso;
import Vista.ConsultaExpEdu;
import Vista.PrincipalHorario;
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
    }

    public CtrlCurso() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public CtrlCurso(PrincipalHorario principalHorario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == consultaExpEdu.btnConsultaExpEdu) {
            MostrarDatosExpEdu(consultaExpEdu.tblExpEdu);
        }
    }

    public void MostrarDatosExpEdu(JTable tblExpEdu){
        modelo = (DefaultTableModel)tblExpEdu.getModel();
        List<Curso>lista=metodosCurso.LlenarTablaCurso(curso);
        Object[]object = new Object [3];
        for (int i = 0; i < lista.size(); i++) {
            object[0] = lista.get(i).getNrc();
            object[1] = lista.get(i).getExp_educativa();
            object[2] = lista.get(i).getProfesor();
            modelo.addRow(object);
        }
        consultaExpEdu.tblExpEdu.setModel(modelo);
    }
    
    }
 