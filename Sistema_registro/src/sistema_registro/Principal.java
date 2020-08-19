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
           f=Calendar.getInstance();
       
       int d=f.get(Calendar.DATE), mes=1+(f.get(Calendar.MONTH)), año=f.get(Calendar.YEAR);
       
       fechaHoy.setText(d+"-"+mes+"-"+año);
         this.setLocationRelativeTo(null);
        this.setTitle("Menú Principal");
        this.setIconImage(new ImageIcon(getClass().getResource("/Imagenes/Titulo.png")).getImage());
        jPanel1.setBackground(new Color(244,245,245,100));
             jPanel2.setBackground(new Color(244,245,245,190));
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
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lbl_NombreUsuario = new javax.swing.JLabel();
        lbl_NombreEmpleado = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        fechaHoy = new javax.swing.JLabel();
        fechaHoy1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btn_Alumno = new javax.swing.JButton();
        btn_Notas = new javax.swing.JButton();
        btn_Matricula = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btn_Empleados = new javax.swing.JButton();
        btn_Secciones = new javax.swing.JButton();
        btn_periodos = new javax.swing.JButton();
        btn_Asignaturas = new javax.swing.JButton();
        btn_cerrarSesion = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
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
        lbl_NombreUsuario.setBounds(192, 23, 380, 22);

        lbl_NombreEmpleado.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_NombreEmpleado.setText("Nombre Empleado");
        jPanel2.add(lbl_NombreEmpleado);
        lbl_NombreEmpleado.setBounds(172, 52, 390, 22);

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

        jLabel5.setFont(new java.awt.Font("OCR A Extended", 0, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(231, 246, 231));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logot.png"))); // NOI18N
        jLabel5.setText("TECHNIA UNIVERSITY");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 0, 540, 100));

        jPanel1.setBackground(new java.awt.Color(244, 245, 245));
        jPanel1.setLayout(null);

        btn_Alumno.setBackground(new java.awt.Color(199, 232, 221));
        btn_Alumno.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btn_Alumno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/empleado.png"))); // NOI18N
        btn_Alumno.setText("Alumno");
        btn_Alumno.setBorderPainted(false);
        btn_Alumno.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_Alumno.setDoubleBuffered(true);
        btn_Alumno.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_Alumno.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btn_Alumno.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
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
        jPanel1.add(btn_Alumno);
        btn_Alumno.setBounds(730, 200, 184, 120);

        btn_Notas.setBackground(new java.awt.Color(199, 232, 221));
        btn_Notas.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btn_Notas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Matricula.png"))); // NOI18N
        btn_Notas.setText("Notas");
        btn_Notas.setBorderPainted(false);
        btn_Notas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_Notas.setDoubleBuffered(true);
        btn_Notas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_Notas.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btn_Notas.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
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
        jPanel1.add(btn_Notas);
        btn_Notas.setBounds(1000, 200, 185, 120);

        btn_Matricula.setBackground(new java.awt.Color(199, 232, 221));
        btn_Matricula.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btn_Matricula.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Alumno.png"))); // NOI18N
        btn_Matricula.setText("Matrícula");
        btn_Matricula.setToolTipText("");
        btn_Matricula.setBorderPainted(false);
        btn_Matricula.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_Matricula.setDoubleBuffered(true);
        btn_Matricula.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_Matricula.setVerifyInputWhenFocusTarget(false);
        btn_Matricula.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btn_Matricula.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
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
        jPanel1.add(btn_Matricula);
        btn_Matricula.setBounds(460, 200, 185, 120);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        btn_Empleados.setBackground(new java.awt.Color(191, 228, 224));
        btn_Empleados.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btn_Empleados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/empledo2.png"))); // NOI18N
        btn_Empleados.setText("Empleados");
        btn_Empleados.setBorderPainted(false);
        btn_Empleados.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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

        btn_Secciones.setBackground(new java.awt.Color(191, 228, 224));
        btn_Secciones.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btn_Secciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/secciones.png"))); // NOI18N
        btn_Secciones.setText("Secciones");
        btn_Secciones.setToolTipText("");
        btn_Secciones.setBorderPainted(false);
        btn_Secciones.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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

        btn_periodos.setBackground(new java.awt.Color(191, 228, 224));
        btn_periodos.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btn_periodos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/periodo.png"))); // NOI18N
        btn_periodos.setText("Periodos");
        btn_periodos.setBorderPainted(false);
        btn_periodos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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

        btn_Asignaturas.setBackground(new java.awt.Color(191, 228, 224));
        btn_Asignaturas.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btn_Asignaturas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Asignatura.png"))); // NOI18N
        btn_Asignaturas.setText("Asignatura");
        btn_Asignaturas.setBorderPainted(false);
        btn_Asignaturas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_periodos, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Asignaturas, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Secciones, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Empleados, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(btn_cerrarSesion)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(btn_Empleados)
                .addGap(33, 33, 33)
                .addComponent(btn_Secciones)
                .addGap(33, 33, 33)
                .addComponent(btn_periodos)
                .addGap(30, 30, 30)
                .addComponent(btn_Asignaturas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(btn_cerrarSesion))
        );

        jPanel1.add(jPanel3);
        jPanel3.setBounds(0, 0, 307, 530);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("Cancelar Asigntura");
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton1.setOpaque(true);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setText("Añadir Aula");
        jButton2.setContentAreaFilled(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton2.setOpaque(true);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setText("Añadir Carrera");
        jButton3.setContentAreaFilled(false);
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton3.setOpaque(true);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(212, 212, 212)
                .addComponent(jButton1)
                .addGap(74, 74, 74)
                .addComponent(jButton2)
                .addGap(92, 92, 92)
                .addComponent(jButton3)
                .addContainerGap(245, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap())
        );

        jPanel1.add(jPanel4);
        jPanel4.setBounds(282, 0, 1030, 58);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 1310, 530));

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
        try {
            matricula = new Matricula();
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
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
         PeriodoHis periodo = null;
        try {
            periodo = new PeriodoHis();
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        periodo.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_periodosMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         Aula au = null;
        try {
            au = new Aula();
        } catch (SQLException ex) {
            Logger.getLogger(Aula.class.getName()).log(Level.SEVERE, null, ex);
        }
        au.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
          this.dispose();
         CancelarAsignatura aa = null;
         try {
             aa = new CancelarAsignatura();
         } catch (SQLException ex) {
             Logger.getLogger(CancelarAsignatura.class.getName()).log(Level.SEVERE, null, ex);
         }
        aa.setVisible(true);
        
    
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
            Carrera cc = null;
        try {
            cc = new Carrera();
        } catch (SQLException ex) {
            Logger.getLogger(Carrera.class.getName()).log(Level.SEVERE, null, ex);
        }
        cc.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private keeptoo.KGradientPanel kGradientPanel2;
    private javax.swing.JLabel lbl_NombreEmpleado;
    private javax.swing.JLabel lbl_NombreUsuario;
    // End of variables declaration//GEN-END:variables

}
