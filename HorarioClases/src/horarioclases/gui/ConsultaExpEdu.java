package horarioclases.gui;

import com.mxrck.autocompleter.TextAutoCompleter;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import conexionBaseDatos.ConectarBD;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class ConsultaExpEdu extends javax.swing.JInternalFrame {
    protected Statement conexionBD = null;
    protected ResultSet consulta = null;
    
   String titulos[] = {"NRC","Experiencia Educativa","Profesor"};
   String fila[] = new String [3]; //Número de columnas equivalentes en ambas tablas (base de datos y el modulo de consulta)
   DefaultTableModel modelo;

   public ConsultaExpEdu() {
        initComponents();
        
        //Quitar la barra de titulo
        BasicInternalFrameUI bi = (BasicInternalFrameUI)this.getUI();
        bi.setNorthPane(null);
        
//INICIA CARGA DE MODULO
        TextAutoCompleter prediccionCampoExpEdu = new TextAutoCompleter(txtExpEdu);
        TextAutoCompleter prediccionCampoNRC = new TextAutoCompleter(txtNRC);

        //CONEXIÓN CON LA BASE DE DATOS
        Connection DatosDeModuloConsulta = ConectarBD.GetConnection();
        //INICIA LA CONSULTA
            try{
                conexionBD = (Statement)DatosDeModuloConsulta.createStatement();
                consulta = conexionBD.executeQuery("SELECT nrc, exp_educativa, CONCAT_WS(\" \",profesor.nombre, profesor.paterno, profesor.materno) AS nombre_completo FROM curso INNER JOIN profesor ON curso.profesor = profesor.id_profesor;");
                modelo = new DefaultTableModel(null,titulos);
                
                //ASIGNACION DE DATOS
                    while (consulta.next()){
                    //CONSULTA DE AUTOCOMPLEMENTACIÓN
                    prediccionCampoNRC.addItem(consulta.getString("nrc")); 
                    prediccionCampoExpEdu.addItem(consulta.getString("exp_educativa"));
                    //CONSULTA DE DATOS EN TABLA
                    fila[0] = consulta.getString("nrc");
                    fila[1] = consulta.getString("exp_educativa");
                    fila[2] = consulta.getString("nombre_completo");
                    modelo.addRow(fila);
                    }
                //LLENADO DE TABLA
                tblExpEdu.setModel(modelo);
                TableColumn columna1 = tblExpEdu.getColumn("NRC");
                columna1.setMaxWidth(75);
                TableColumn columna2 = tblExpEdu.getColumn("Experiencia Educativa");
                TableColumn columna3 = tblExpEdu.getColumn("Profesor");

                //CIERRE DE VARIABLES
                consulta.close();
                conexionBD.close();
                
            }catch(SQLException de){
                    JOptionPane.showMessageDialog(this, de.getMessage());
            }
//FINALIZA CARGA DE MODULO

   }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        FondoModuloConsulta = new javax.swing.JPanel();
        ResultadoModuloConsulta = new javax.swing.JScrollPane();
        tblExpEdu = new javax.swing.JTable();
        lblConsultaExpEdu = new javax.swing.JLabel();
        lblNRC = new javax.swing.JLabel();
        btnConsultaNRC = new javax.swing.JButton();
        txtExpEdu = new javax.swing.JTextField();
        lblExpEdu = new javax.swing.JLabel();
        txtNRC = new javax.swing.JTextField();
        btnConsultaExpEdu = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        setForeground(java.awt.Color.black);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        FondoModuloConsulta.setBackground(new java.awt.Color(255, 255, 255));
        FondoModuloConsulta.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        tblExpEdu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "NRC", "Experiencia Educativa", "Profesor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ResultadoModuloConsulta.setViewportView(tblExpEdu);

        lblConsultaExpEdu.setFont(new java.awt.Font("Consolas", 1, 48)); // NOI18N
        lblConsultaExpEdu.setText("Consultar Experiencias Educativas");

        lblNRC.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        lblNRC.setText("NRC:");

        btnConsultaNRC.setBackground(new java.awt.Color(255, 255, 255));
        btnConsultaNRC.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        btnConsultaNRC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cursos.png"))); // NOI18N
        btnConsultaNRC.setText("Consultar NRC");
        btnConsultaNRC.setActionCommand("  Agregar Experiencia Educativa");
        btnConsultaNRC.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnConsultaNRC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultaNRCActionPerformed(evt);
            }
        });

        lblExpEdu.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        lblExpEdu.setText("Experiencia Educativa:");

        btnConsultaExpEdu.setBackground(new java.awt.Color(255, 255, 255));
        btnConsultaExpEdu.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        btnConsultaExpEdu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cursos.png"))); // NOI18N
        btnConsultaExpEdu.setText("Buscar Experiencia Educativa");
        btnConsultaExpEdu.setActionCommand("  Agregar Experiencia Educativa");
        btnConsultaExpEdu.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnConsultaExpEdu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultaExpEduActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout FondoModuloConsultaLayout = new javax.swing.GroupLayout(FondoModuloConsulta);
        FondoModuloConsulta.setLayout(FondoModuloConsultaLayout);
        FondoModuloConsultaLayout.setHorizontalGroup(
            FondoModuloConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FondoModuloConsultaLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(FondoModuloConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(FondoModuloConsultaLayout.createSequentialGroup()
                        .addGroup(FondoModuloConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblConsultaExpEdu)
                            .addGroup(FondoModuloConsultaLayout.createSequentialGroup()
                                .addGap(126, 126, 126)
                                .addComponent(lblNRC)
                                .addGap(18, 18, 18)
                                .addComponent(txtNRC)
                                .addGap(451, 451, 451)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(FondoModuloConsultaLayout.createSequentialGroup()
                        .addComponent(lblExpEdu)
                        .addGap(18, 18, 18)
                        .addComponent(txtExpEdu, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(551, 551, 551))))
            .addGroup(FondoModuloConsultaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(FondoModuloConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FondoModuloConsultaLayout.createSequentialGroup()
                        .addComponent(ResultadoModuloConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 910, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(FondoModuloConsultaLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnConsultaNRC, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(150, 150, 150)
                        .addComponent(btnConsultaExpEdu, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(152, 152, 152))))
        );
        FondoModuloConsultaLayout.setVerticalGroup(
            FondoModuloConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FondoModuloConsultaLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lblConsultaExpEdu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(FondoModuloConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNRC, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNRC))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(FondoModuloConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtExpEdu, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblExpEdu))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(FondoModuloConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConsultaNRC, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConsultaExpEdu, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(ResultadoModuloConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(FondoModuloConsulta, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 941, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConsultaNRCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultaNRCActionPerformed
        // CODIGO INICIO
        String NrcIngresado = txtNRC.getText();        
        Connection consultaNRC = ConectarBD.GetConnection();
        
        try {
            conexionBD = (Statement)consultaNRC.createStatement();
            consulta = conexionBD.executeQuery("SELECT nrc, exp_educativa, CONCAT_WS(' ',profesor.nombre, profesor.paterno, profesor.materno) AS nombre_completo FROM curso INNER JOIN profesor ON curso.profesor = profesor.id_profesor WHERE nrc = '"+NrcIngresado+"';");               
            modelo = new DefaultTableModel(null,titulos);
            
               while(consulta.next()) {
                   fila[0] = consulta.getString("nrc");
                   fila[1] = consulta.getString("exp_educativa");
                   fila[2] = consulta.getString("nombre_completo");
                   modelo.addRow(fila);     
               }
                tblExpEdu.setModel(modelo);
                TableColumn columna1 = tblExpEdu.getColumn("NRC");
                columna1.setMaxWidth(75);
                TableColumn columna2 = tblExpEdu.getColumn("Experiencia Educativa");
                TableColumn columna3 = tblExpEdu.getColumn("Profesor");
        
            consulta.close();
            consulta.close();      
        }catch (SQLException e) {
           JOptionPane.showMessageDialog(null,"Error al extraer los datos de la tabla");
        }
        txtNRC.setText("");
        //CODIGO FIN
    }//GEN-LAST:event_btnConsultaNRCActionPerformed

    private void btnConsultaExpEduActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultaExpEduActionPerformed
        // CODIGO INICIO
        String ExpEduIngresada = txtExpEdu.getText();        
        Connection consultaExpEdu = ConectarBD.GetConnection();
        
        try {
            conexionBD = (Statement)consultaExpEdu.createStatement();
            consulta = conexionBD.executeQuery("SELECT nrc, exp_educativa, CONCAT_WS(' ',profesor.nombre, profesor.paterno, profesor.materno) AS nombre_completo FROM curso INNER JOIN profesor ON curso.profesor = profesor.id_profesor WHERE exp_educativa = '"+ExpEduIngresada+"';");               
            modelo = new DefaultTableModel(null,titulos);
            
               while(consulta.next()) {
                   fila[0] = consulta.getString("nrc");
                   fila[1] = consulta.getString("exp_educativa");
                   fila[2] = consulta.getString("nombre_completo");
                   modelo.addRow(fila);     
               }
               
                tblExpEdu.setModel(modelo);
                TableColumn columna1 = tblExpEdu.getColumn("NRC");
                columna1.setMaxWidth(75);
                TableColumn columna2 = tblExpEdu.getColumn("Experiencia Educativa");
                TableColumn columna3 = tblExpEdu.getColumn("Profesor");
        
            consulta.close();
            consulta.close();      
        }catch (SQLException e) {
        JOptionPane.showMessageDialog(null,"Error al extraer los datos de la tabla");
        }
        txtExpEdu.setText("");
        //CODIGO FIN
    }//GEN-LAST:event_btnConsultaExpEduActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel FondoModuloConsulta;
    private javax.swing.JScrollPane ResultadoModuloConsulta;
    private javax.swing.JButton btnConsultaExpEdu;
    private javax.swing.JButton btnConsultaNRC;
    private javax.swing.JLabel lblConsultaExpEdu;
    private javax.swing.JLabel lblExpEdu;
    private javax.swing.JLabel lblNRC;
    private javax.swing.JTable tblExpEdu;
    private javax.swing.JTextField txtExpEdu;
    private javax.swing.JTextField txtNRC;
    // End of variables declaration//GEN-END:variables
}
