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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
       DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
       int d=f.get(Calendar.DATE), mes=1+(f.get(Calendar.MONTH)), año=f.get(Calendar.YEAR);
       
       if(mes < 10){
           fechaHoy.setText(d+"/0"+mes+"/"+año);
       }
       if(mes >= 10){
          fechaHoy.setText(d+"/"+mes+"/"+año); 
       }

        this.btn_accesoPantallas.setVisible(false);
        this.setLocationRelativeTo(null);
        this.setTitle("Menú Principal");
        this.setIconImage(new ImageIcon(getClass().getResource("/Imagenes/Titulo.png")).getImage());
        jPanel1.setBackground(new Color(244,245,245,100));
             jPanel2.setBackground(new Color(244,245,245,190));
        deshabilitarPantallas();
       
             
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
       
      if(mes < 10){
           fechaHoy.setText(d+"/0"+mes+"/"+año);
       }
       if(mes >= 10){
          fechaHoy.setText(d+"/"+mes+"/"+año); 
       }
        this.btn_accesoPantallas.setVisible(false);
        this.setLocationRelativeTo(null);
        this.setTitle("Menú Principal");
        this.setIconImage(new ImageIcon(getClass().getResource("/Imagenes/Titulo.png")).getImage());
        jPanel1.setBackground(new Color(244,245,245,100));
        jPanel2.setBackground(new Color(244,245,245,190));
         //deshabilitarPantallas();
         activarPermisos(this.lbl_NombreUsuario.getText());
    }
    
    public void deshabilitarPantallas(){
       btn_Empleados.setEnabled(false);
       btn_Secciones.setEnabled(false);
       btn_periodos.setEnabled(false);
       btn_Asignaturas.setEnabled(false);
       btn_Matricula.setEnabled(false);
       btn_Alumno.setEnabled(false);
       btn_Notas.setEnabled(false);
       btn_CancelarAsignatura.setEnabled(false);
       btn_Aula.setEnabled(false);
       btn_Carrera.setEnabled(false);
    }
    
    public void habilitarPantallas(){
       btn_Empleados.setEnabled(true);
       btn_Secciones.setEnabled(true);
       btn_periodos.setEnabled(true);
       btn_Asignaturas.setEnabled(true);
       btn_Matricula.setEnabled(true);
       btn_Alumno.setEnabled(true);
       btn_Notas.setEnabled(true);
       btn_CancelarAsignatura.setEnabled(true);
       btn_Aula.setEnabled(true);
       btn_Carrera.setEnabled(true);
    }
    
    public void activarPermisos(String nombreUsuario){
        
        try {
                Statement st2 = con.createStatement();
                String sql2 = "select id_tipoUsuario from Acceso where nombre_usuario = '"+nombreUsuario+"'";
                ResultSet rs2 = st2.executeQuery(sql2);
                if(rs2.next()){
                    if(rs2.getString("id_tipoUsuario").equals("A")){
                        this.btn_accesoPantallas.setVisible(true);
                    }
                }
                
            Statement st = con.createStatement();
            String sql = "select * from Acceso_Pantallas where nombre_usuario = '"+nombreUsuario+"'";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                if(rs.getString("Empleados").equals("1")){
                    btn_Empleados.setEnabled(true);
                }
                if(rs.getString("Secciones").equals("1")){
                    btn_Secciones.setEnabled(true);
                }
                if(rs.getString("Periodos").equals("1")){
                    btn_periodos.setEnabled(true);
                }
                if(rs.getString("Asignatura").equals("1")){
                    btn_Asignaturas.setEnabled(true);
                }
                if(rs.getString("Matricula").equals("1")){
                    btn_Matricula.setEnabled(true);
                }
                
                 if(rs.getString("Alumno").equals("1")){
                    btn_Alumno.setEnabled(true);
                }
                if(rs.getString("Notas").equals("1")){
                    btn_Notas.setEnabled(true);
                }
                if(rs.getString("CancelarAsignatura").equals("1")){
                    btn_CancelarAsignatura.setEnabled(true);
                }
                if(rs.getString("Aula").equals("1")){
                    btn_Aula.setEnabled(true);
                }
                if(rs.getString("Carrera").equals("1")){
                    btn_Carrera.setEnabled(true);
                }
                

            }
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
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
        btn_accesoPantallas = new javax.swing.JButton();
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
        btn_CancelarAsignatura = new javax.swing.JButton();
        btn_Aula = new javax.swing.JButton();
        btn_Carrera = new javax.swing.JButton();
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

        btn_accesoPantallas.setBackground(new java.awt.Color(199, 232, 221));
        btn_accesoPantallas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cog_icon_125323.png"))); // NOI18N
        btn_accesoPantallas.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btn_accesoPantallas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_accesoPantallas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_accesoPantallas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_accesoPantallasActionPerformed(evt);
            }
        });
        getContentPane().add(btn_accesoPantallas, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, 20, 60, 50));

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
        fechaHoy.setBounds(1160, 30, 130, 16);

        fechaHoy1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        fechaHoy1.setText("      Fecha:");
        jPanel2.add(fechaHoy1);
        fechaHoy1.setBounds(1080, 30, 80, 16);

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
        btn_Alumno.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Alumno.setDoubleBuffered(true);
        btn_Alumno.setEnabled(false);
        btn_Alumno.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
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
        btn_Notas.setBorder(null);
        btn_Notas.setBorderPainted(false);
        btn_Notas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Notas.setDoubleBuffered(true);
        btn_Notas.setEnabled(false);
        btn_Notas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
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
        btn_Matricula.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Matricula.setDoubleBuffered(true);
        btn_Matricula.setEnabled(false);
        btn_Matricula.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_Matricula.setVerifyInputWhenFocusTarget(false);
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
        btn_Empleados.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Empleados.setDoubleBuffered(true);
        btn_Empleados.setEnabled(false);
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
        btn_Secciones.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Secciones.setDoubleBuffered(true);
        btn_Secciones.setEnabled(false);
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
        btn_periodos.setText("Períodos");
        btn_periodos.setBorderPainted(false);
        btn_periodos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_periodos.setDoubleBuffered(true);
        btn_periodos.setEnabled(false);
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
        btn_Asignaturas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Asignaturas.setDoubleBuffered(true);
        btn_Asignaturas.setEnabled(false);
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
                .addGap(81, 81, 81)
                .addComponent(btn_Empleados)
                .addGap(33, 33, 33)
                .addComponent(btn_Secciones)
                .addGap(33, 33, 33)
                .addComponent(btn_periodos)
                .addGap(30, 30, 30)
                .addComponent(btn_Asignaturas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(btn_cerrarSesion))
        );

        jPanel1.add(jPanel3);
        jPanel3.setBounds(0, 0, 307, 530);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        btn_CancelarAsignatura.setBackground(new java.awt.Color(255, 255, 255));
        btn_CancelarAsignatura.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_CancelarAsignatura.setText("Cancelar Asignatura");
        btn_CancelarAsignatura.setBorderPainted(false);
        btn_CancelarAsignatura.setContentAreaFilled(false);
        btn_CancelarAsignatura.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_CancelarAsignatura.setEnabled(false);
        btn_CancelarAsignatura.setOpaque(true);
        btn_CancelarAsignatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CancelarAsignaturaActionPerformed(evt);
            }
        });

        btn_Aula.setBackground(new java.awt.Color(255, 255, 255));
        btn_Aula.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_Aula.setText("Añadir Aula");
        btn_Aula.setBorderPainted(false);
        btn_Aula.setContentAreaFilled(false);
        btn_Aula.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Aula.setEnabled(false);
        btn_Aula.setOpaque(true);
        btn_Aula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AulaActionPerformed(evt);
            }
        });

        btn_Carrera.setBackground(new java.awt.Color(255, 255, 255));
        btn_Carrera.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_Carrera.setText("Añadir Carrera");
        btn_Carrera.setBorderPainted(false);
        btn_Carrera.setContentAreaFilled(false);
        btn_Carrera.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Carrera.setEnabled(false);
        btn_Carrera.setOpaque(true);
        btn_Carrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CarreraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(212, 212, 212)
                .addComponent(btn_CancelarAsignatura)
                .addGap(74, 74, 74)
                .addComponent(btn_Aula)
                .addGap(92, 92, 92)
                .addComponent(btn_Carrera)
                .addContainerGap(237, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_CancelarAsignatura)
                    .addComponent(btn_Aula)
                    .addComponent(btn_Carrera))
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
    Asignaturas asignatura = null;
        try {
            asignatura = new Asignaturas(lbl_NombreUsuario.getText());
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        asignatura.setVisible(true);
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_btn_AsignaturasActionPerformed

    private void btn_AsignaturasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_AsignaturasMouseClicked
        
    }//GEN-LAST:event_btn_AsignaturasMouseClicked

    private void btn_SeccionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SeccionesActionPerformed
   Secciones seccion = null;
        try {
            seccion = new Secciones(lbl_NombreUsuario.getText());
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        seccion.setVisible(true);
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_btn_SeccionesActionPerformed

    private void btn_SeccionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_SeccionesMouseClicked
      
    }//GEN-LAST:event_btn_SeccionesMouseClicked

    private void btn_MatriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_MatriculaActionPerformed
          Matricula matricula = null;
        try {
            matricula = new Matricula(lbl_NombreUsuario.getText());
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        matricula.setVisible(true);
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_MatriculaActionPerformed

    private void btn_MatriculaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_MatriculaMouseClicked
       
    }//GEN-LAST:event_btn_MatriculaMouseClicked

    private void btn_NotasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_NotasMouseClicked
     
    }//GEN-LAST:event_btn_NotasMouseClicked

    private void btn_AlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AlumnoActionPerformed
     Alumno alumno = null;
        try {
            alumno = new Alumno(lbl_NombreUsuario.getText());
            alumno.setVisible(true);
            this.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_AlumnoActionPerformed

    private void btn_AlumnoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_AlumnoMouseClicked
        
        
    }//GEN-LAST:event_btn_AlumnoMouseClicked

    private void btn_EmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_EmpleadosActionPerformed
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
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_EmpleadosActionPerformed

    private void btn_EmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_EmpleadosMouseClicked
 
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
        Notas nota = null;
        try {
            nota = new Notas(lbl_NombreUsuario.getText());
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        nota.setVisible(true);
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_NotasActionPerformed

    private void btn_periodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_periodosActionPerformed
       PeriodoHis periodo = null;
        try {
            periodo = new PeriodoHis(lbl_NombreUsuario.getText());
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        periodo.setVisible(true);
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_periodosActionPerformed

    private void btn_periodosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_periodosMouseClicked
      
    }//GEN-LAST:event_btn_periodosMouseClicked

    private void btn_AulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AulaActionPerformed
         Aula au = null;
        try {
            au = new Aula(lbl_NombreUsuario.getText());
        } catch (SQLException ex) {
            Logger.getLogger(Aula.class.getName()).log(Level.SEVERE, null, ex);
        }
        au.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_AulaActionPerformed

    private void btn_CancelarAsignaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CancelarAsignaturaActionPerformed
          this.dispose();
         CancelarAsignatura aa = null;
         try {
             aa = new CancelarAsignatura(lbl_NombreUsuario.getText());
         } catch (SQLException ex) {
             Logger.getLogger(CancelarAsignatura.class.getName()).log(Level.SEVERE, null, ex);
         }
        aa.setVisible(true);
        
    
    }//GEN-LAST:event_btn_CancelarAsignaturaActionPerformed

    private void btn_CarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CarreraActionPerformed
            Carrera cc = null;
        try {
            cc = new Carrera(lbl_NombreUsuario.getText());
        } catch (SQLException ex) {
            Logger.getLogger(Carrera.class.getName()).log(Level.SEVERE, null, ex);
        }
        cc.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_CarreraActionPerformed

    private void btn_accesoPantallasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_accesoPantallasActionPerformed
            Acceso_Pantallas ap = null;
        try {
            ap = new Acceso_Pantallas(lbl_NombreUsuario.getText());
        } catch (SQLException ex) {
            Logger.getLogger(Acceso_Pantallas.class.getName()).log(Level.SEVERE, null, ex);
        }
        ap.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_accesoPantallasActionPerformed

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
    private javax.swing.JButton btn_Aula;
    private javax.swing.JButton btn_CancelarAsignatura;
    private javax.swing.JButton btn_Carrera;
    private javax.swing.JButton btn_Empleados;
    private javax.swing.JButton btn_Matricula;
    private javax.swing.JButton btn_Notas;
    private javax.swing.JButton btn_Secciones;
    private javax.swing.JButton btn_accesoPantallas;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private keeptoo.KGradientPanel kGradientPanel2;
    private javax.swing.JLabel lbl_NombreEmpleado;
    private javax.swing.JLabel lbl_NombreUsuario;
    // End of variables declaration//GEN-END:variables

}
