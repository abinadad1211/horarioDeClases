package horarioclases.gui;

import java.awt.Color;

public class PrincipalHorario extends javax.swing.JFrame {

    Color colorBotonSeleccion = new Color(24, 82, 190);
    Color colorBotonReposo = new Color (24, 82, 157);
    
    public PrincipalHorario() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pblNavegacion = new javax.swing.JPanel();
        btnHorario = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnProfesor = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        btnExpEdu = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        btnSalon = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        pnlBarra = new javax.swing.JPanel();
        lblCerrar = new javax.swing.JLabel();
        pnlhorario = new javax.swing.JPanel();
        pnlEscritorio = new javax.swing.JDesktopPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setForeground(java.awt.Color.white);
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pblNavegacion.setBackground(new java.awt.Color(24, 82, 157));
        pblNavegacion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnHorario.setBackground(new java.awt.Color(24, 82, 157));
        btnHorario.setPreferredSize(new java.awt.Dimension(26, 48));
        btnHorario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnHorarioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnHorarioMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnHorarioMousePressed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/calendarblack.png"))); // NOI18N

        javax.swing.GroupLayout btnHorarioLayout = new javax.swing.GroupLayout(btnHorario);
        btnHorario.setLayout(btnHorarioLayout);
        btnHorarioLayout.setHorizontalGroup(
            btnHorarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnHorarioLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel2)
                .addContainerGap(29, Short.MAX_VALUE))
        );
        btnHorarioLayout.setVerticalGroup(
            btnHorarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnHorarioLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel2)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pblNavegacion.add(btnHorario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 80, 70));

        btnProfesor.setBackground(new java.awt.Color(24, 82, 157));
        btnProfesor.setPreferredSize(new java.awt.Dimension(26, 48));
        btnProfesor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnProfesorMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnProfesorMouseExited(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/calendarblack.png"))); // NOI18N

        javax.swing.GroupLayout btnProfesorLayout = new javax.swing.GroupLayout(btnProfesor);
        btnProfesor.setLayout(btnProfesorLayout);
        btnProfesorLayout.setHorizontalGroup(
            btnProfesorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnProfesorLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel4)
                .addContainerGap(29, Short.MAX_VALUE))
        );
        btnProfesorLayout.setVerticalGroup(
            btnProfesorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnProfesorLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel4)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pblNavegacion.add(btnProfesor, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 80, 70));

        btnExpEdu.setBackground(new java.awt.Color(24, 82, 157));
        btnExpEdu.setPreferredSize(new java.awt.Dimension(26, 48));
        btnExpEdu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnExpEduMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnExpEduMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnExpEduMousePressed(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/calendarblack.png"))); // NOI18N

        javax.swing.GroupLayout btnExpEduLayout = new javax.swing.GroupLayout(btnExpEdu);
        btnExpEdu.setLayout(btnExpEduLayout);
        btnExpEduLayout.setHorizontalGroup(
            btnExpEduLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnExpEduLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel5)
                .addContainerGap(29, Short.MAX_VALUE))
        );
        btnExpEduLayout.setVerticalGroup(
            btnExpEduLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnExpEduLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel5)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pblNavegacion.add(btnExpEdu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 80, 70));

        btnSalon.setBackground(new java.awt.Color(24, 82, 157));
        btnSalon.setPreferredSize(new java.awt.Dimension(26, 48));
        btnSalon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSalonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSalonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnSalonMousePressed(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/calendarblack.png"))); // NOI18N

        javax.swing.GroupLayout btnSalonLayout = new javax.swing.GroupLayout(btnSalon);
        btnSalon.setLayout(btnSalonLayout);
        btnSalonLayout.setHorizontalGroup(
            btnSalonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnSalonLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel6)
                .addContainerGap(29, Short.MAX_VALUE))
        );
        btnSalonLayout.setVerticalGroup(
            btnSalonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnSalonLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel6)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pblNavegacion.add(btnSalon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 80, 70));

        getContentPane().add(pblNavegacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, 695));

        pnlBarra.setBackground(new java.awt.Color(255, 255, 255));

        lblCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/close.png"))); // NOI18N
        lblCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCerrarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlBarraLayout = new javax.swing.GroupLayout(pnlBarra);
        pnlBarra.setLayout(pnlBarraLayout);
        pnlBarraLayout.setHorizontalGroup(
            pnlBarraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBarraLayout.createSequentialGroup()
                .addContainerGap(914, Short.MAX_VALUE)
                .addComponent(lblCerrar)
                .addContainerGap())
        );
        pnlBarraLayout.setVerticalGroup(
            pnlBarraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBarraLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCerrar)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        getContentPane().add(pnlBarra, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 940, 50));

        pnlhorario.setBackground(new java.awt.Color(255, 255, 255));
        pnlhorario.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 48)); // NOI18N

        javax.swing.GroupLayout pnlEscritorioLayout = new javax.swing.GroupLayout(pnlEscritorio);
        pnlEscritorio.setLayout(pnlEscritorioLayout);
        pnlEscritorioLayout.setHorizontalGroup(
            pnlEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 940, Short.MAX_VALUE)
        );
        pnlEscritorioLayout.setVerticalGroup(
            pnlEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 638, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlhorarioLayout = new javax.swing.GroupLayout(pnlhorario);
        pnlhorario.setLayout(pnlhorarioLayout);
        pnlhorarioLayout.setHorizontalGroup(
            pnlhorarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlEscritorio)
        );
        pnlhorarioLayout.setVerticalGroup(
            pnlhorarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlhorarioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlEscritorio))
        );

        getContentPane().add(pnlhorario, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 44, 940, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHorarioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHorarioMouseEntered
        btnHorario.setBackground(colorBotonSeleccion);
    }//GEN-LAST:event_btnHorarioMouseEntered

    private void btnHorarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHorarioMouseExited
        btnHorario.setBackground(colorBotonReposo);
    }//GEN-LAST:event_btnHorarioMouseExited

    private void btnProfesorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProfesorMouseEntered
        btnProfesor.setBackground(colorBotonSeleccion);
    }//GEN-LAST:event_btnProfesorMouseEntered

    private void btnProfesorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProfesorMouseExited
        btnProfesor.setBackground(colorBotonReposo);
    }//GEN-LAST:event_btnProfesorMouseExited

    private void btnExpEduMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExpEduMouseEntered
        btnExpEdu.setBackground(colorBotonSeleccion);
    }//GEN-LAST:event_btnExpEduMouseEntered

    private void btnExpEduMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExpEduMouseExited
        btnExpEdu.setBackground(colorBotonReposo);
    }//GEN-LAST:event_btnExpEduMouseExited

    private void btnSalonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalonMouseEntered
        btnSalon.setBackground(colorBotonSeleccion);
    }//GEN-LAST:event_btnSalonMouseEntered

    private void btnSalonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalonMouseExited
        btnSalon.setBackground(colorBotonReposo);
    }//GEN-LAST:event_btnSalonMouseExited

    private void lblCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarMouseClicked
        System.exit(0);
    }//GEN-LAST:event_lblCerrarMouseClicked

    private void btnHorarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHorarioMousePressed
        // TODO add your handling code here:
        CrearHorario Opcion1  = new CrearHorario();
        //ConsultaExpEdu Opcion3  = new ConsultaExpEdu();
        pnlEscritorio.add(Opcion1);
        Opcion1.show();
    }//GEN-LAST:event_btnHorarioMousePressed

    private void btnExpEduMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExpEduMousePressed
        // TODO add your handling code here:
        ConsultaExpEdu Opcion3  = new ConsultaExpEdu();
        pnlEscritorio.add(Opcion3);
        Opcion3.show();
    }//GEN-LAST:event_btnExpEduMousePressed

    private void btnSalonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalonMousePressed
        // TODO add your handling code here:
        ConsultaSalon Opcion4  = new ConsultaSalon();
        pnlEscritorio.add(Opcion4);
        Opcion4.show();
    }//GEN-LAST:event_btnSalonMousePressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PrincipalHorario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrincipalHorario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrincipalHorario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrincipalHorario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new PrincipalHorario().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnExpEdu;
    private javax.swing.JPanel btnHorario;
    private javax.swing.JPanel btnProfesor;
    private javax.swing.JPanel btnSalon;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lblCerrar;
    private javax.swing.JPanel pblNavegacion;
    private javax.swing.JPanel pnlBarra;
    private javax.swing.JDesktopPane pnlEscritorio;
    private javax.swing.JPanel pnlhorario;
    // End of variables declaration//GEN-END:variables
}
