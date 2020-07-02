package Vista;

import com.mxrck.autocompleter.TextAutoCompleter;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import Modelo.ConectarBD;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableRowSorter;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Abinadad
 */
public class ConsultaProfesores extends javax.swing.JInternalFrame {
    protected Statement conexionBD = null;
    protected ResultSet consulta = null;
    public static boolean ban[] = {false, false, false, false, false, false, false, false, false, false};
    
    String titulos[] = {"Experiencia Educativa","NRC","Lunes","Martes","Miercoles","Jueves","Viernes","Sábado"};
    String fila[] = new String [8]; //Número de columnas equivalentes en ambas tablas (base de datos y el modulo de consulta)
    DefaultTableModel modelo;
    
    public ConsultaProfesores() {
        initComponents();
        
        BasicInternalFrameUI bi = (BasicInternalFrameUI)this.getUI();
        bi.setNorthPane(null);
        
        TextAutoCompleter preddiccionCampoProfesor = new TextAutoCompleter(txtNombreProfesor);
        
        Connection DatosDeModuloConsulta = ConectarBD.GetConnection();
        
        //INICIA LA CONSULTA
        try{
            conexionBD = (Statement)DatosDeModuloConsulta.createStatement();
            consulta = conexionBD.executeQuery("SELECT p.nombre, c.exp_educativa, c.nrc, GROUP_CONCAT(IF(r.dia_clases_clases = 'LUNES', r.horarios_clases, NULL)) LUNES, GROUP_CONCAT(IF(r.dia_clases_clases = 'MARTES', r.horarios_clases, NULL)) MARTES, GROUP_CONCAT(IF(r.dia_clases_clases = 'MIERCOLES', r.horarios_clases, NULL)) MIERCOLES, GROUP_CONCAT(IF(r.dia_clases_clases = 'JUEVES', r.horarios_clases, NULL)) JUEVES, GROUP_CONCAT(IF(r.dia_clases_clases = 'VIERNES', r.horarios_clases, NULL)) VIERNES, GROUP_CONCAT(IF(r.dia_clases_clases = 'SABADO', r.horarios_clases, NULL)) SABADO FROM profesor p	INNER JOIN curso c ON p.id_profesor = c.profesor INNER JOIN reserva r ON c.nrc= r.nrc_reserva	GROUP BY r.nrc_reserva;");               
            modelo = new DefaultTableModel(null,titulos){
                //Bloqueo de la funcion editar que trae JTable por default
                public boolean isCellEditable(int row, int column){
                    return false;
                }
            };
           
            
            //ASIGNACION DE DATOS
            while (consulta.next()){
                //CONSULTA DE AUTOCOMPLEMENTACIÓN
                preddiccionCampoProfesor.addItem(consulta.getString("p.nombre")); 
                
                //Llenado de tabla
                fila[0] = consulta.getString("c.exp_educativa");
                fila[1] = consulta.getString("c.nrc");
                fila[2] = consulta.getString("LUNES");
                fila[3] = consulta.getString("MARTES");
                fila[4] = consulta.getString("MIERCOLES");
                fila[5] = consulta.getString("JUEVES");
                fila[6] = consulta.getString("VIERNES");
                fila[7] = consulta.getString("SABADO");
                
                modelo.addRow(fila);
            }
            
            //LLENADO DE TABLA
            tblHorarioProfesores.setModel(modelo);
            TableColumn columna1 = tblHorarioProfesores.getColumn("Experiencia Educativa");
            columna1.setMaxWidth(75);
            TableColumn columna2 = tblHorarioProfesores.getColumn("NRC");
            TableColumn columna3 = tblHorarioProfesores.getColumn("Lunes");
            TableColumn columna4 = tblHorarioProfesores.getColumn("Martes");
            TableColumn columna5 = tblHorarioProfesores.getColumn("Miercoles");
            TableColumn columna6 = tblHorarioProfesores.getColumn("Jueves");
            TableColumn columna7 = tblHorarioProfesores.getColumn("Viernes");
            TableColumn columna8 = tblHorarioProfesores.getColumn("Sábado");
            


            //CIERRE DE VARIABLES
            consulta.close();
            conexionBD.close();
                
            }catch(SQLException de){
                JOptionPane.showMessageDialog(this, de.getMessage());
            }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblConsultarProfesores = new javax.swing.JLabel();
        lbNombreProfesor = new javax.swing.JLabel();
        txtNombreProfesor = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHorarioProfesores = new javax.swing.JTable();
        btnBuscarProfesor = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 219, 197));
        setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        setForeground(java.awt.Color.black);
        setMinimumSize(new java.awt.Dimension(24, 20));
        setPreferredSize(new java.awt.Dimension(941, 646));

        lblConsultarProfesores.setFont(new java.awt.Font("Consolas", 1, 48)); // NOI18N
        lblConsultarProfesores.setText("Buscar profesor");

        lbNombreProfesor.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        lbNombreProfesor.setText("Nombre del profesor:");

        tblHorarioProfesores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Experiencia Educativa", "NRC", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblHorarioProfesores);

        btnBuscarProfesor.setBackground(new java.awt.Color(255, 255, 255));
        btnBuscarProfesor.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        btnBuscarProfesor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/profesor.png"))); // NOI18N
        btnBuscarProfesor.setText("Buscar profesor");
        btnBuscarProfesor.setActionCommand("  Agregar Experiencia Educativa");
        btnBuscarProfesor.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnBuscarProfesor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProfesorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 903, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(lbNombreProfesor)
                        .addGap(18, 18, 18)
                        .addComponent(txtNombreProfesor, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscarProfesor, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblConsultarProfesores, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(146, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(lblConsultarProfesores)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNombreProfesor)
                    .addComponent(txtNombreProfesor, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarProfesor, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(138, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarProfesorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProfesorActionPerformed
        String nombreProfesorIngresado = txtNombreProfesor.getText();  
       
        Connection consultaProfesor = ConectarBD.GetConnection();
        
            try {
            conexionBD = (Statement)consultaProfesor.createStatement();                                                                                                                                                                             //ordenador.setRowFilter(RowFilter.regexFilter("(?i)" + text));
            consulta = conexionBD.executeQuery("SELECT c.exp_educativa, c.nrc, GROUP_CONCAT(IF(r.dia_clases_clases = 'LUNES', r.horarios_clases, NULL)) LUNES, GROUP_CONCAT(IF(r.dia_clases_clases = 'MARTES', r.horarios_clases, NULL)) MARTES, GROUP_CONCAT(IF(r.dia_clases_clases = 'MIERCOLES', r.horarios_clases, NULL)) MIERCOLES, GROUP_CONCAT(IF(r.dia_clases_clases = 'JUEVES', r.horarios_clases, NULL)) JUEVES, GROUP_CONCAT(IF(r.dia_clases_clases = 'VIERNES', r.horarios_clases, NULL)) VIERNES, GROUP_CONCAT(IF(r.dia_clases_clases = 'SABADO', r.horarios_clases, NULL)) SABADO FROM profesor p INNER JOIN curso c ON p.id_profesor = c.profesor INNER JOIN reserva r ON c.nrc= r.nrc_reserva WHERE CONCAT(UCASE(LEFT(p.nombre, 1)), LCASE(SUBSTRING(p.nombre, 2))) LIKE '"+nombreProfesorIngresado+"%'GROUP BY r.nrc_reserva;");               
            
            modelo = new DefaultTableModel(null,titulos);
            
                while(consulta.next()) {
                //CONSULTA DE DATOS EN TABLA
                fila[0] = consulta.getString("c.exp_educativa");
                fila[1] = consulta.getString("c.nrc");
                fila[2] = consulta.getString("LUNES");
                fila[3] = consulta.getString("MARTES");
                fila[4] = consulta.getString("MIERCOLES");
                fila[5] = consulta.getString("JUEVES");
                fila[6] = consulta.getString("VIERNES");
                fila[7] = consulta.getString("SABADO");
             
                
                modelo.addRow(fila); 
                
                }
                tblHorarioProfesores.setModel(modelo);
                TableColumn columna1 = tblHorarioProfesores.getColumn("Experiencia Educativa");
                columna1.setMaxWidth(75);
                TableColumn columna2 = tblHorarioProfesores.getColumn("NRC");
                TableColumn columna3 = tblHorarioProfesores.getColumn("Lunes");
                TableColumn columna4 = tblHorarioProfesores.getColumn("Martes");
                TableColumn columna5 = tblHorarioProfesores.getColumn("Miercoles");
                TableColumn columna6 = tblHorarioProfesores.getColumn("Jueves");
                TableColumn columna7 = tblHorarioProfesores.getColumn("Viernes");
                TableColumn columna8 = tblHorarioProfesores.getColumn("Sábado");
        
            consulta.close();
            consulta.close();      
        }catch (SQLException e) {
           JOptionPane.showMessageDialog(null,"Error al extraer los datos de la tabla");
        }
        txtNombreProfesor.setText("");
    }//GEN-LAST:event_btnBuscarProfesorActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarProfesor;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbNombreProfesor;
    private javax.swing.JLabel lblConsultarProfesores;
    private javax.swing.JTable tblHorarioProfesores;
    private javax.swing.JTextField txtNombreProfesor;
    // End of variables declaration//GEN-END:variables
}