/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema_registro;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import sistema_registro.SQL.ConectorSQL;

/**
 *
 * @author Mitsuki
 */
public class Principal extends javax.swing.JFrame {
    Connection con;
    ImageIcon Imagen[]=new ImageIcon[3];

    
     Calendar f;
       
     
     
    public Principal() throws SQLException {
        this.con = ConectorSQL.obtenerConexion();
        
        
        
        try {
            Login login=new Login();
            // this.lbl_NombreEmpleado.setText(login.getTxt_usuario().getText());
            
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }

        initComponents();
          f=Calendar.getInstance();
       
       int d=f.get(Calendar.DATE), mes=1+(f.get(Calendar.MONTH)), año=f.get(Calendar.YEAR);
       
       fechaHoy.setText(d+"-"+mes+"-"+año);
       /* for (int i = 1; i < 3; i++) {
            Imagen[i]=new ImageIcon(getClass().getResource("/imagenes/"+i+".jpg"));
        }
        lblvisor.setIcon(Imagen[1]);
       
        Timer timer=new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                 int contador = 0;
                contador++;
                lblvisor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/"+contador+".jpg")));
                if (contador==3)contador=1 ;
                    
            }
        });
        timer.start();
        */
        this.setLocationRelativeTo(null);
        this.setTitle("Menú Principal");
        this.setIconImage(new ImageIcon(getClass().getResource("/Imagenes/Titulo.png")).getImage());
        jPanel1.setBackground(new Color(244,245,245,100));
             jPanel2.setBackground(new Color(244,245,245,190));
             
             
    }
    public Principal(String nombreUsuario,String nombreEmpleado) throws SQLException{
        this.con = ConectorSQL.obtenerConexion();
        
          initComponents();
        this.setLocationRelativeTo(null);
        
        String a=nombreUsuario;
        this.lbl_NombreUsuario.setText(a);
        
        String b=nombreEmpleado;
        this.lbl_NombreEmpleado.setText(b);
        
        this.setTitle("Menú Principal");
        this.setIconImage(new ImageIcon(getClass().getResource("/Imagenes/Titulo.png")).getImage());
        
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
        jPanel1 = new javax.swing.JPanel();
        btn_Alumno = new javax.swing.JButton();
        btn_Matricula = new javax.swing.JButton();
        btn_Notas = new javax.swing.JButton();
        btn_Asignaturas = new javax.swing.JButton();
        btn_Secciones = new javax.swing.JButton();
        btn_periodos = new javax.swing.JButton();
        btn_Empleados = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lbl_NombreUsuario = new javax.swing.JLabel();
        lbl_NombreEmpleado = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        fechaHoy = new javax.swing.JLabel();
        fechaHoy1 = new javax.swing.JLabel();
        lblvisor = new javax.swing.JLabel();
        btn_cerrarSesion = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

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
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(244, 245, 245));

        btn_Alumno.setBackground(new java.awt.Color(127, 226, 214));
        btn_Alumno.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btn_Alumno.setText("Alumno");
        btn_Alumno.setBorderPainted(false);
        btn_Alumno.setDoubleBuffered(true);
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

        btn_Matricula.setBackground(new java.awt.Color(127, 226, 214));
        btn_Matricula.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btn_Matricula.setText("Matrícula");
        btn_Matricula.setToolTipText("");
        btn_Matricula.setBorderPainted(false);
        btn_Matricula.setDoubleBuffered(true);
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

        btn_Notas.setBackground(new java.awt.Color(127, 226, 214));
        btn_Notas.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btn_Notas.setText("Notas");
        btn_Notas.setBorderPainted(false);
        btn_Notas.setDoubleBuffered(true);
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

        btn_Asignaturas.setBackground(new java.awt.Color(127, 226, 214));
        btn_Asignaturas.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btn_Asignaturas.setText("Asignatura");
        btn_Asignaturas.setBorder(null);
        btn_Asignaturas.setBorderPainted(false);
        btn_Asignaturas.setDoubleBuffered(true);
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

        btn_Secciones.setBackground(new java.awt.Color(127, 226, 214));
        btn_Secciones.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btn_Secciones.setText("Secciones");
        btn_Secciones.setToolTipText("");
        btn_Secciones.setBorderPainted(false);
        btn_Secciones.setDoubleBuffered(true);
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

        btn_periodos.setBackground(new java.awt.Color(127, 226, 214));
        btn_periodos.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btn_periodos.setText("Periodos");
        btn_periodos.setBorderPainted(false);
        btn_periodos.setDoubleBuffered(true);
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

        btn_Empleados.setBackground(new java.awt.Color(127, 226, 214));
        btn_Empleados.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btn_Empleados.setText("Empleados");
        btn_Empleados.setBorderPainted(false);
        btn_Empleados.setDoubleBuffered(true);
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_Empleados, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_periodos, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Secciones, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Asignaturas, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Notas, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Matricula, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Alumno, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(94, Short.MAX_VALUE)
                .addComponent(btn_Alumno, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_Matricula, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_Notas, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_Empleados, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_Asignaturas, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_Secciones, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_periodos, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 260, 530));

        jPanel2.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Usuario:");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(92, 52, 76, 22);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Empleado:");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(92, 23, 95, 22);

        lbl_NombreUsuario.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_NombreUsuario.setText("Nombre Usuario");
        jPanel2.add(lbl_NombreUsuario);
        lbl_NombreUsuario.setBounds(192, 23, 127, 22);

        lbl_NombreEmpleado.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_NombreEmpleado.setText("Nombre Empleado");
        jPanel2.add(lbl_NombreEmpleado);
        lbl_NombreEmpleado.setBounds(172, 52, 145, 22);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/User.png"))); // NOI18N
        jPanel2.add(jLabel4);
        jLabel4.setBounds(20, 10, 64, 64);

        fechaHoy.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        fechaHoy.setText("Fecha hoy");
        jPanel2.add(fechaHoy);
        fechaHoy.setBounds(1190, 30, 80, 16);

        fechaHoy1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        fechaHoy1.setText("      Fecha:");
        jPanel2.add(fechaHoy1);
        fechaHoy1.setBounds(1100, 30, 80, 16);

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 1310, 80));

        lblvisor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/4.jpg"))); // NOI18N
        getContentPane().add(lblvisor, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 180, 1050, 530));

        btn_cerrarSesion.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btn_cerrarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/boton_cerrarsesion.png"))); // NOI18N
        btn_cerrarSesion.setText("Cerrar Sesión");
        btn_cerrarSesion.setContentAreaFilled(false);
        btn_cerrarSesion.setDefaultCapable(false);
        btn_cerrarSesion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_cerrarSesion.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btn_cerrarSesion.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
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
        getContentPane().add(btn_cerrarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 20, -1, -1));

        jLabel5.setFont(new java.awt.Font("OCR A Extended", 0, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(231, 246, 231));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logot.png"))); // NOI18N
        jLabel5.setText("TECHNIA UNIVERSITY");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 540, 100));

        jLabel3.setBackground(new java.awt.Color(255, 255, 102));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondoprincipal.jpg"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1410, 750));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_AsignaturasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AsignaturasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_AsignaturasActionPerformed

    private void btn_AsignaturasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_AsignaturasMouseClicked
         Asignaturas asignatura = null;
        try {
            asignatura = new Asignaturas();
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        asignatura.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_AsignaturasMouseClicked

    private void btn_SeccionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SeccionesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_SeccionesActionPerformed

    private void btn_SeccionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_SeccionesMouseClicked
         Secciones seccion = null;
        try {
            seccion = new Secciones();
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            nota = new Notas();
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        nota.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_NotasMouseClicked

    private void btn_AlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AlumnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_AlumnoActionPerformed

    private void btn_AlumnoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_AlumnoMouseClicked
         Alumno alumno = null;
        try {
            alumno = new Alumno(lbl_NombreUsuario.getText());
            alumno.setVisible(true);
            this.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btn_AlumnoMouseClicked

    private void btn_EmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_EmpleadosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_EmpleadosActionPerformed

    private void btn_EmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_EmpleadosMouseClicked
        Statement st;
  
        try {
            st = con.createStatement();
            String consulta = "Select Tipo_Usuario from Tipo_Usuarios\n" +
                              "where id_tipoUsuario = (Select id_tipoUsuario from Acceso where nombre_usuario ='"+lbl_NombreUsuario.getText()+"')";
            ResultSet rs = st.executeQuery(consulta);
            if(rs.next()){
                if(rs.getString("Tipo_Usuario").equals("Administrador")){
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
            
            if(JOptionPane.showConfirmDialog(principal,"¿Está seguro que desea cerrar sesión?","Cerrar sesión del usuario "+lbl_NombreUsuario.getText()+"",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE
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
         PeriodoHistorico periodo = null;
         periodo = new PeriodoHistorico();
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
    private javax.swing.JLabel fechaHoy;
    private javax.swing.JLabel fechaHoy1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private keeptoo.KGradientPanel kGradientPanel2;
    private javax.swing.JLabel lbl_NombreEmpleado;
    private javax.swing.JLabel lbl_NombreUsuario;
    private javax.swing.JLabel lblvisor;
    // End of variables declaration//GEN-END:variables

}
