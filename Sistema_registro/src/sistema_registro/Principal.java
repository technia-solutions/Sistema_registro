/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema_registro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import sistema_registro.SQL.ConectorSQL;

/**
 *
 * @author Mitsuki
 */
public class Principal extends javax.swing.JFrame {
    Connection con;

     
    public Principal() throws SQLException {
        this.con = ConectorSQL.obtenerConexion();
        
        try {
            Login login=new Login();
            // this.lbl_NombreEmpleado.setText(login.getTxt_usuario().getText());
            
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }

        initComponents();
        this.setLocationRelativeTo(null);
 
 
    }
    public Principal(String nombreUsuario,String nombreEmpleado) throws SQLException{
        this.con = ConectorSQL.obtenerConexion();
        
          initComponents();
        this.setLocationRelativeTo(null);
        
        String a=nombreUsuario;
        this.lbl_NombreUsuario.setText(a);
        
        String b=nombreEmpleado;
        this.lbl_NombreEmpleado.setText(b);
        
    }
  

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel2 = new keeptoo.KGradientPanel();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbl_NombreUsuario = new javax.swing.JLabel();
        lbl_NombreEmpleado = new javax.swing.JLabel();
        btn_Empleados = new javax.swing.JButton();
        btn_Asignaturas = new javax.swing.JButton();
        btn_Alumno = new javax.swing.JButton();
        btn_Matricula = new javax.swing.JButton();
        btn_Secciones = new javax.swing.JButton();
        btn_Notas = new javax.swing.JButton();
        btn_periodos = new javax.swing.JButton();
        btn_cerrarSesion = new javax.swing.JButton();

        javax.swing.GroupLayout kGradientPanel2Layout = new javax.swing.GroupLayout(kGradientPanel2);
        kGradientPanel2.setLayout(kGradientPanel2Layout);
        kGradientPanel2Layout.setHorizontalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        kGradientPanel2Layout.setVerticalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        kGradientPanel1.setkEndColor(new java.awt.Color(204, 255, 204));
        kGradientPanel1.setkStartColor(new java.awt.Color(0, 153, 153));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Empleado:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Usuario:");

        lbl_NombreUsuario.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_NombreUsuario.setText("Nombre Usuario");

        lbl_NombreEmpleado.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_NombreEmpleado.setText("Nombre Empleado");

        btn_Empleados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/button_empleados.png"))); // NOI18N
        btn_Empleados.setContentAreaFilled(false);
        btn_Empleados.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/button_empleados (1).png"))); // NOI18N
        btn_Empleados.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/button_empleados (1).png"))); // NOI18N
        btn_Empleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_EmpleadosMouseClicked(evt);
            }
        });
        btn_Empleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_EmpleadosActionPerformed(evt);
            }
        });

        btn_Asignaturas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/button_asignaturas.png"))); // NOI18N
        btn_Asignaturas.setBorder(null);
        btn_Asignaturas.setContentAreaFilled(false);
        btn_Asignaturas.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/button_asignaturas (1).png"))); // NOI18N
        btn_Asignaturas.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/button_asignaturas (1).png"))); // NOI18N
        btn_Asignaturas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_AsignaturasMouseClicked(evt);
            }
        });
        btn_Asignaturas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AsignaturasActionPerformed(evt);
            }
        });

        btn_Alumno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/button_alumno (1).png"))); // NOI18N
        btn_Alumno.setContentAreaFilled(false);
        btn_Alumno.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/button_alumno (2).png"))); // NOI18N
        btn_Alumno.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/button_alumno (2).png"))); // NOI18N
        btn_Alumno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_AlumnoMouseClicked(evt);
            }
        });
        btn_Alumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AlumnoActionPerformed(evt);
            }
        });

        btn_Matricula.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/button_matricula.png"))); // NOI18N
        btn_Matricula.setContentAreaFilled(false);
        btn_Matricula.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/button_matricula (1).png"))); // NOI18N
        btn_Matricula.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_MatriculaMouseClicked(evt);
            }
        });
        btn_Matricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_MatriculaActionPerformed(evt);
            }
        });

        btn_Secciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/button_secciones.png"))); // NOI18N
        btn_Secciones.setContentAreaFilled(false);
        btn_Secciones.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/button_secciones (1).png"))); // NOI18N
        btn_Secciones.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/button_secciones (1).png"))); // NOI18N
        btn_Secciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_SeccionesMouseClicked(evt);
            }
        });
        btn_Secciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SeccionesActionPerformed(evt);
            }
        });

        btn_Notas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/button_notas.png"))); // NOI18N
        btn_Notas.setContentAreaFilled(false);
        btn_Notas.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/button_notas (1).png"))); // NOI18N
        btn_Notas.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/button_notas (1).png"))); // NOI18N
        btn_Notas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_NotasMouseClicked(evt);
            }
        });
        btn_Notas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_NotasActionPerformed(evt);
            }
        });

        btn_periodos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/button_periodo.png"))); // NOI18N
        btn_periodos.setContentAreaFilled(false);
        btn_periodos.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/button_periodo (1).png"))); // NOI18N
        btn_periodos.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/button_periodo (1).png"))); // NOI18N
        btn_periodos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_periodosMouseClicked(evt);
            }
        });
        btn_periodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_periodosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_NombreEmpleado)
                            .addComponent(lbl_NombreUsuario)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_Alumno, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_Asignaturas, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(btn_Empleados, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(btn_Matricula, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                .addGap(261, 261, 261)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_periodos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Notas, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btn_Secciones, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(103, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2))
                    .addContainerGap(657, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_Notas, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbl_NombreEmpleado)
                        .addGap(33, 33, 33)
                        .addComponent(lbl_NombreUsuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                        .addComponent(btn_Empleados)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_Asignaturas, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_Alumno)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_Matricula, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 53, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(btn_periodos)
                        .addGap(18, 18, 18)
                        .addComponent(btn_Secciones)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel1)
                    .addGap(33, 33, 33)
                    .addComponent(jLabel2)
                    .addContainerGap(449, Short.MAX_VALUE)))
        );

        btn_cerrarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/button_cerrar-sesion.png"))); // NOI18N
        btn_cerrarSesion.setContentAreaFilled(false);
        btn_cerrarSesion.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/button_cerrar-sesion (1).png"))); // NOI18N
        btn_cerrarSesion.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/button_cerrar-sesion (1).png"))); // NOI18N
        btn_cerrarSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_cerrarSesionMouseClicked(evt);
            }
        });
        btn_cerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cerrarSesionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap(837, Short.MAX_VALUE)
                .addComponent(btn_cerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_cerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_AsignaturasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AsignaturasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_AsignaturasActionPerformed

    private void btn_AsignaturasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_AsignaturasMouseClicked
         Asignaturas asignatura = null;
         asignatura = new Asignaturas();
        asignatura.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_AsignaturasMouseClicked

    private void btn_SeccionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SeccionesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_SeccionesActionPerformed

    private void btn_SeccionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_SeccionesMouseClicked
         Secciones seccion = null;
         seccion = new Secciones();
        seccion.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_SeccionesMouseClicked

    private void btn_MatriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_MatriculaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_MatriculaActionPerformed

    private void btn_MatriculaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_MatriculaMouseClicked
         Matricula matricula = null;
         matricula = new Matricula();
        matricula.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_MatriculaMouseClicked

    private void btn_NotasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_NotasMouseClicked
         Notas nota = null;
         nota = new Notas();
        nota.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_NotasMouseClicked

    private void btn_AlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AlumnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_AlumnoActionPerformed

    private void btn_AlumnoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_AlumnoMouseClicked
         Alumno alumno = null;
         alumno = new Alumno();
        alumno.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_AlumnoMouseClicked

    private void btn_EmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_EmpleadosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_EmpleadosActionPerformed

    private void btn_EmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_EmpleadosMouseClicked
        Statement st;
  
        try {
            st = con.createStatement();
            String consulta = "Select tipo_usuario from Acceso where nombre_usuario = '"+lbl_NombreUsuario.getText()+"'";
            ResultSet rs = st.executeQuery(consulta);
            if(rs.next()){
                if(rs.getString("tipo_usuario").equals("A")){
                     
        Empleado empleado = null;
        try {
            
            empleado = new Empleado(lbl_NombreUsuario.getText());
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        empleado.setVisible(true);
        this.dispose();
                }
                 else{
                JOptionPane.showMessageDialog(null,"Solo los administradores tienen acceso a esta pantalla");
            }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
           
             
       
            
            
           
       
    }//GEN-LAST:event_btn_EmpleadosMouseClicked

      
    
    private void btn_cerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cerrarSesionActionPerformed
       
    }//GEN-LAST:event_btn_cerrarSesionActionPerformed

    private void btn_cerrarSesionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cerrarSesionMouseClicked
  
             
        
         JFrame principal=new JFrame("EXIT");

        try {
            Login login=new Login();
            
            if(JOptionPane.showConfirmDialog(principal,"Estas seguro que quieres cerrar sesión"
        )==JOptionPane.YES_OPTION){
            dispose();
            login.setVisible(true);
            
        }
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
       
           
            
        

     
        /* try {
            login = new Login();
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        login.setVisible(true);
        this.dispose();*/
  
        
       
    }//GEN-LAST:event_btn_cerrarSesionMouseClicked

    private void btn_NotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_NotasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_NotasActionPerformed

    private void btn_periodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_periodosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_periodosActionPerformed

    private void btn_periodosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_periodosMouseClicked
         Periodos periodo = null;
         periodo = new Periodos();
        periodo.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_periodosMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])  {
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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Principal().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
   
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Alumno;
    private javax.swing.JButton btn_Asignaturas;
    private javax.swing.JButton btn_Empleados;
    private javax.swing.JButton btn_Matricula;
    private javax.swing.JButton btn_Notas;
    private javax.swing.JButton btn_Secciones;
    private javax.swing.JButton btn_cerrarSesion;
    private javax.swing.JButton btn_periodos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private keeptoo.KGradientPanel kGradientPanel1;
    private keeptoo.KGradientPanel kGradientPanel2;
    private javax.swing.JLabel lbl_NombreEmpleado;
    private javax.swing.JLabel lbl_NombreUsuario;
    // End of variables declaration//GEN-END:variables

}