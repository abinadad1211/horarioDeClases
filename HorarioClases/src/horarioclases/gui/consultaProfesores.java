package horarioclases.gui;

import com.mxrck.autocompleter.TextAutoCompleter;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import conexionBaseDatos.ConectarBD;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableRowSorter;
/**
 *
 * @author Abinadad
 */
public class consultaProfesores extends javax.swing.JInternalFrame {
    protected Statement conexionBD = null;
    protected ResultSet consulta = null;
    public static boolean ban[] = {false, false, false, false, false, false, false, false, false, false};
    
    String titulos[] = {"Experiencia Educativa","NRC","Lunes","Martes","Miercoles","Jueves","Viernes","Sábado"};
    String fila[] = new String [8]; //Número de columnas equivalentes en ambas tablas (base de datos y el modulo de consulta)
    DefaultTableModel modelo;
    
    public consultaProfesores() {
        initComponents();
        
        BasicInternalFrameUI bi = (BasicInternalFrameUI)this.getUI();
        bi.setNorthPane(null);
        
        TextAutoCompleter prediccionCampoNombreProfesor = new TextAutoCompleter(txtNombreProfesor);
        
        Connection DatosDeModuloConsulta = ConectarBD.GetConnection();
        
                //INICIA LA CONSULTA
        try{
            conexionBD = (Statement)DatosDeModuloConsulta.createStatement();
            consulta = conexionBD.executeQuery("SELECT c.exp_educativa, c.nrc, r.dia_clases_clases, r.horarios_clases FROM profesor p INNER JOIN curso c ON p.id_profesor = c.profesor INNER JOIN reserva r ON c.nrc = r.nrc_reserva;");
            modelo = new DefaultTableModel(null,titulos);
            
            //ASIGNACION DE DATOS
            while (consulta.next()){
                //CONSULTA DE AUTOCOMPLEMENTACIÓN
                //prediccionCampoNombreProfesor.addItem(consulta.getString("p.nombre")); 
                
                //CONSULTA DE DATOS EN TABLA
                fila[0] = consulta.getString("c.exp_educativa");
                fila[1] = consulta.getString("c.nrc");
                
                if("LUNES".equals(consulta.getString("r.dia_clases_clases"))){
                    fila[2] = consulta.getString("r.horarios_clases");
                    ban[2]=true;
                    
                }else if("MARTES".equals(consulta.getString("r.dia_clases_clases"))){
                    fila[3] = consulta.getString("r.horarios_clases");
                    ban[3]=true;
                    
                }else if("MIERCOLES".equals(consulta.getString("r.dia_clases_clases"))){
                    fila[4] = consulta.getString("r.horarios_clases");
                    ban[4]=true;
                   
                }else if("JUEVES".equals(consulta.getString("r.dia_clases_clases"))){
                    fila[5] = consulta.getString("r.horarios_clases");
                    ban[5]=true;
                    
                }else if("VIERNES".equals(consulta.getString("r.dia_clases_clases"))){
                    fila[6] = consulta.getString("r.horarios_clases");
                    ban[6]=true;
                    
                }else if("SABADO".equals(consulta.getString("r.dia_clases_clases"))){
                    fila[7] = consulta.getString("r.horarios_clases");
                    ban[7]=true;
                    
                }
                
                //Iteracion para llenar con - los dias que no tiene clase el profesor
                for(int i=2; i<=7; i++){
                    if(ban[i]!=true){
                        fila[i]="- - - - - - - - - - - -";
                    }
                }
                
                modelo.addRow(fila);
            }
            
            //LLENADO DE TABLA
            tbHorarioProfesores.setModel(modelo);
            TableColumn columna1 = tbHorarioProfesores.getColumn("Experiencia Educativa");
            columna1.setMaxWidth(75);
            TableColumn columna2 = tbHorarioProfesores.getColumn("NRC");
            TableColumn columna3 = tbHorarioProfesores.getColumn("Lunes");
            TableColumn columna4 = tbHorarioProfesores.getColumn("Martes");
            TableColumn columna5 = tbHorarioProfesores.getColumn("Miercoles");
            TableColumn columna6 = tbHorarioProfesores.getColumn("Jueves");
            TableColumn columna7 = tbHorarioProfesores.getColumn("Viernes");
            TableColumn columna8 = tbHorarioProfesores.getColumn("Sábado");
            

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
        tbHorarioProfesores = new javax.swing.JTable();
        btnBuscarProfesor = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        setForeground(java.awt.Color.black);
        setMinimumSize(new java.awt.Dimension(24, 20));
        setPreferredSize(new java.awt.Dimension(941, 646));

        lblConsultarProfesores.setFont(new java.awt.Font("Consolas", 1, 48)); // NOI18N
        lblConsultarProfesores.setText("Buscar profesor");

        lbNombreProfesor.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        lbNombreProfesor.setText("Nombre del profesor:");

        tbHorarioProfesores.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tbHorarioProfesores);

        btnBuscarProfesor.setBackground(new java.awt.Color(255, 255, 255));
        btnBuscarProfesor.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        btnBuscarProfesor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cursos.png"))); // NOI18N
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(lbNombreProfesor)
                                .addGap(18, 18, 18)
                                .addComponent(txtNombreProfesor))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblConsultarProfesores)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscarProfesor)))
                .addContainerGap(30, Short.MAX_VALUE))
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
                    .addComponent(btnBuscarProfesor))
                .addGap(47, 47, 47)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(105, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarProfesorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProfesorActionPerformed
        String nombreProfesorIngresado = txtNombreProfesor.getText();  
       
        Connection consultaProfesor = ConectarBD.GetConnection();
        
            try {
            conexionBD = (Statement)consultaProfesor.createStatement();                                                                                                                                                                             //ordenador.setRowFilter(RowFilter.regexFilter("(?i)" + text));
            consulta = conexionBD.executeQuery("SELECT c.exp_educativa, c.nrc, r.dia_clases_clases, r.horarios_clases FROM profesor p INNER JOIN curso c ON p.id_profesor = c.profesor INNER JOIN reserva r ON c.nrc = r.nrc_reserva WHERE CONCAT(UCASE(LEFT(p.nombre, 1)), LCASE(SUBSTRING(p.nombre, 2))) like '"+nombreProfesorIngresado+"%';");               
            
            modelo = new DefaultTableModel(null,titulos);
            
                while(consulta.next()) {
                //CONSULTA DE DATOS EN TABLA
                fila[0] = consulta.getString("c.exp_educativa");
                fila[1] = consulta.getString("c.nrc");
                
                if("LUNES".equals(consulta.getString("r.dia_clases_clases"))){
                    fila[2] = consulta.getString("r.horarios_clases");
                    
                }else if("MARTES".equals(consulta.getString("r.dia_clases_clases"))){
                    fila[3] = consulta.getString("r.horarios_clases");  
                    
                }else if("MIERCOLES".equals(consulta.getString("r.dia_clases_clases"))){
                    fila[4] = consulta.getString("r.horarios_clases");
                    
                }else if("JUEVES".equals(consulta.getString("r.dia_clases_clases"))){
                    fila[5] = consulta.getString("r.horarios_clases");
                    
                }else if("VIERNES".equals(consulta.getString("r.dia_clases_clases"))){
                    fila[6] = consulta.getString("r.horarios_clases");
                    
                }else if("SABADO".equals(consulta.getString("r.dia_clases_clases"))){
                    fila[7] = consulta.getString("r.horarios_clases");
                   
                }else{
                
                }
                
                   modelo.addRow(fila);     
                }
                tbHorarioProfesores.setModel(modelo);
                TableColumn columna1 = tbHorarioProfesores.getColumn("Experiencia Educativa");
                columna1.setMaxWidth(75);
                TableColumn columna2 = tbHorarioProfesores.getColumn("NRC");
                TableColumn columna3 = tbHorarioProfesores.getColumn("Lunes");
                TableColumn columna4 = tbHorarioProfesores.getColumn("Martes");
                TableColumn columna5 = tbHorarioProfesores.getColumn("Miercoles");
                TableColumn columna6 = tbHorarioProfesores.getColumn("Jueves");
                TableColumn columna7 = tbHorarioProfesores.getColumn("Viernes");
                TableColumn columna8 = tbHorarioProfesores.getColumn("Sábado");
        
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
    private javax.swing.JTable tbHorarioProfesores;
    private javax.swing.JTextField txtNombreProfesor;
    // End of variables declaration//GEN-END:variables
}
