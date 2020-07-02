package Controlador;

import Modelo.Curso;
import Modelo.MetodosCurso;
import Vista.ConsultaExpEdu;
import Vista.FrmConsultaExpEdu;
import java.awt.event.*;
import java.util.*;
import javax.swing.JTable;
import javax.swing.table.*;

public class CtrlCurso implements ActionListener{
    
    MetodosCurso metodosCurso = new MetodosCurso();
    Curso curso = new Curso();
    FrmConsultaExpEdu frmconsultaExpEdu = new FrmConsultaExpEdu();
    DefaultTableModel modelo = new DefaultTableModel();

    public CtrlCurso(FrmConsultaExpEdu frmconsultaExpEdu){
        this.frmconsultaExpEdu = frmconsultaExpEdu;
        this.frmconsultaExpEdu.btnConsultaExpEdu.addActionListener(this);
    }
  
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmconsultaExpEdu.btnConsultaExpEdu) {
          MostrarDatosExpEdu(frmconsultaExpEdu.tblExpEdu);
        }
        if (e.getSource() == frmconsultaExpEdu.btnConsultaNRC) {
            MostrarDatosNrc(frmconsultaExpEdu.tblExpEdu);
        }
    }

    public void MostrarDatosExpEdu(JTable tblExpEdu){
        modelo = (DefaultTableModel)tblExpEdu.getModel();
        List<Curso>lista=metodosCurso.BusquedaCursoExpEdu(curso);
        Object[]object = new Object [3];
        for (int i = 0; i < lista.size(); i++) {
            object[0] = lista.get(i).getNrc();
            object[1] = lista.get(i).getExperienciaEducativa();
            object[2] = lista.get(i).getProfesor();
            modelo.addRow(object);
        }
        frmconsultaExpEdu.tblExpEdu.setModel(modelo);
    }
    
    public void MostrarDatosNrc(JTable tblExpEdu){
        modelo = (DefaultTableModel)tblExpEdu.getModel();
        List<Curso>lista=metodosCurso.BusquedaCursoNRC(curso, frmconsultaExpEdu.txtNRC.getText());
        Object[]object = new Object [3];
        for (int i = 0; i < lista.size(); i++) {
            object[0] = lista.get(i).getNrc();
            object[1] = lista.get(i).getExperienciaEducativa();
            object[2] = lista.get(i).getProfesor();
            modelo.addRow(object);
        }
        frmconsultaExpEdu.tblExpEdu.setModel(modelo);
    }
    
}
 