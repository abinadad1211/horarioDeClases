
package Controlador;

import Modelo.MetodosReservacion;
import Modelo.Recipiente;
import Vista.ConsultaReservacion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CtrlReservacion implements ActionListener{
    
    MetodosReservacion metodosReservacion = new MetodosReservacion();
    Recipiente recipiente = new Recipiente();
    ConsultaReservacion consultaReservacion = new ConsultaReservacion();
    DefaultTableModel modeloReservacion = new DefaultTableModel();

    public CtrlReservacion( ConsultaReservacion consultaReservacion ) {
        this.consultaReservacion = consultaReservacion;
        this.consultaReservacion.btnBuscarSalon.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
            if (e.getSource() == consultaReservacion.btnBuscarSalon) {
            consultaReservacion.tblReservacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Experiencia Educativa", "NRC", "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado"
            }
            ));
            MostrarDatosExpEdu(consultaReservacion.tblReservacion);
        }
    }
    
    public void MostrarDatosExpEdu(JTable tblExpEdu){
      modeloReservacion = (DefaultTableModel)tblExpEdu.getModel();
      @SuppressWarnings("unchecked")
      List<Recipiente>lista=metodosReservacion.BusquedaAula(recipiente, consultaReservacion.cmbSalon.getSelectedItem().toString());
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
        modeloReservacion.addRow(object);
      }
      consultaReservacion.tblReservacion.setModel(modeloReservacion);
    }
    
}