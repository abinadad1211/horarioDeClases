package horarioclases.gui;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.*;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.plaf.InternalFrameUI;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class ConsultaExpEdu extends javax.swing.JInternalFrame {
    
   Connection con = null;
   Statement stmt = null;
   String titulos[] = {"NRC","Experiencia Educativa","Profesor"};
   String fila[] = new String [7]; //Ese [7] qué significa? 
   DefaultTableModel modelo;

   public ConsultaExpEdu() {
        initComponents();
        
        //Quitar la barra de titulo
        BasicInternalFrameUI bi = (BasicInternalFrameUI)this.getUI();
        bi.setNorthPane(null);

   }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblExpEdu = new javax.swing.JTable();
        lblConsultaExpEdu = new javax.swing.JLabel();
        lblNRC = new javax.swing.JLabel();
        btnConsultarExpEdu = new javax.swing.JButton();
        btnConsultarNRC = new javax.swing.JButton();
        txtNRC = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        setForeground(java.awt.Color.black);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

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
        jScrollPane1.setViewportView(tblExpEdu);

        lblConsultaExpEdu.setFont(new java.awt.Font("Consolas", 1, 48)); // NOI18N
        lblConsultaExpEdu.setText("Consultar Experiencias Educativas");

        lblNRC.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        lblNRC.setText("NRC:");

        btnConsultarExpEdu.setBackground(new java.awt.Color(255, 255, 255));
        btnConsultarExpEdu.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        btnConsultarExpEdu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cursos.png"))); // NOI18N
        btnConsultarExpEdu.setText("Consultar Experiencias Educativas");
        btnConsultarExpEdu.setActionCommand("  Agregar Experiencia Educativa");
        btnConsultarExpEdu.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnConsultarExpEdu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarExpEduActionPerformed(evt);
            }
        });

        btnConsultarNRC.setBackground(new java.awt.Color(255, 255, 255));
        btnConsultarNRC.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        btnConsultarNRC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cursos.png"))); // NOI18N
        btnConsultarNRC.setText("Consultar NRC");
        btnConsultarNRC.setActionCommand("  Agregar Experiencia Educativa");
        btnConsultarNRC.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnConsultarNRC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarNRCActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lblNRC)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtNRC, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lblConsultaExpEdu)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(127, 127, 127)
                                .addComponent(btnConsultarNRC, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(118, 118, 118)
                                .addComponent(btnConsultarExpEdu)))
                        .addGap(0, 54, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lblConsultaExpEdu)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblNRC)
                    .addComponent(txtNRC, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConsultarExpEdu, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConsultarNRC, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConsultarExpEduActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarExpEduActionPerformed
 
        //INICIA CONSULTA SQL        
        String url = "jdbc:mysql://lis401.cbjqnknzqkto.us-east-2.rds.amazonaws.com:3306/horario_de_clases";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection conexion = (java.sql.Connection) DriverManager.getConnection(url, "admin", "-Lis401-samsung1"); //Sustituir valores por variables
               java.sql.Statement instruccion = conexion.createStatement();
               String sql = "SELECT nrc, exp_educativa, CONCAT_WS(\" \",profesor.nombre, profesor.paterno, profesor.materno) AS nombre_completo FROM curso INNER JOIN profesor ON curso.profesor = profesor.id_profesor;";
               ResultSet rs = instruccion.executeQuery(sql);
               modelo = new DefaultTableModel(null,titulos);
            
               while(rs.next()) {
                   
                   fila[0] = rs.getString("nrc");
                   fila[1] = rs.getString("exp_educativa");
                   fila[2] = rs.getString("nombre_completo");
                   
                   modelo.addRow(fila);     
               }
               tblExpEdu.setModel(modelo);
                TableColumn columna1 = tblExpEdu.getColumn("NRC");
                columna1.setMaxWidth(75);
                TableColumn columna2 = tblExpEdu.getColumn("Experiencia Educativa");
                TableColumn columna3 = tblExpEdu.getColumn("Profesor");
        
            rs.close();
            instruccion.close();
            conexion.close();       
        }
        catch (ClassNotFoundException | SQLException e) {
            
            JOptionPane.showMessageDialog(null,"Error al extraer los datos de la tabla");
        }
//AQUI TERMINA 
    }//GEN-LAST:event_btnConsultarExpEduActionPerformed

    private void btnConsultarNRCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarNRCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnConsultarNRCActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsultarExpEdu;
    private javax.swing.JButton btnConsultarNRC;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblConsultaExpEdu;
    private javax.swing.JLabel lblNRC;
    private javax.swing.JTable tblExpEdu;
    private javax.swing.JTextField txtNRC;
    // End of variables declaration//GEN-END:variables
}
