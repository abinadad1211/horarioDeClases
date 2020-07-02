package Controlador;

import Modelo.Curso;
import Modelo.MetodosCurso;
import Vista.AgregarCurso;
import Vista.ConsultaExpEdu;
import java.awt.event.*;
import javax.swing.JOptionPane;

public class CtrlCurso implements ActionListener{
    
    private Curso curso;
    private MetodosCurso metodosCurso;
    private AgregarCurso agregarCurso;
    private ConsultaExpEdu consultaExpEdu;

    public CtrlCurso(Curso curso, MetodosCurso metodosCurso, AgregarCurso agregarCurso, ConsultaExpEdu consultaExpEdu) {
        this.curso = curso;
        this.metodosCurso = metodosCurso;
        this.agregarCurso = agregarCurso;
        this.consultaExpEdu = consultaExpEdu;
        this.consultaExpEdu.btnConsultaNRC.addActionListener(this);
        this.consultaExpEdu.btnConsultaExpEdu.addActionListener(this);
    }
        
    public void iniciar(){
        if(metodosCurso.LlenarTablaCurso(curso)){
           }else {
               JOptionPane.showMessageDialog(null, "Error en la Base de Datos");
            }
    }

    @Override
    public void actionPerformed(ActionEvent e){
    
        if(e.getSource() == consultaExpEdu.btnConsultaNRC){
           curso.setNrc(consultaExpEdu.txtNRC.getText());
           
           if(metodosCurso.BusquedaCursoNRC(curso)){
               
               JOptionPane.showMessageDialog(null, "Exito en la busqueda");
               limpiar();
           }else {
               JOptionPane.showMessageDialog(null, "Error en la busqueda");
               limpiar();
           }
        }
        
        if(e.getSource() == consultaExpEdu.btnConsultaExpEdu){
           curso.setExp_educativa(consultaExpEdu.txtExpEdu.getText());
           
           if(metodosCurso.BusquedaCursoExpEdu(curso)){
               
               JOptionPane.showMessageDialog(null, "Exito en la busqueda");
               limpiar();
           }else {
               JOptionPane.showMessageDialog(null, "Error en la busqueda");
               limpiar();
           }
        }
    }
    
    public void limpiar (){
        consultaExpEdu.txtNRC.setText(null);
        consultaExpEdu.txtExpEdu.setText(null);
    }
    
}
