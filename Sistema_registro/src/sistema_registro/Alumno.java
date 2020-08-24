/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema_registro;

import codigo.Conexion_consulta;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import org.apache.commons.codec.digest.DigestUtils;
import sistema_registro.SQL.ConectorSQL;

/**
 *
 * @author Carlos
 */
public class Alumno extends javax.swing.JFrame {

    Connection con=null;
    String var;
    

    public Alumno() throws SQLException {
        initComponents();
        this.con = ConectorSQL.obtenerConexion();
         ArrayList<String> lista = new ArrayList<String>();
             lista = new Conexion_consulta().llenar_combo2();
            for(int i = 0; i<lista.size();i++){
                cbo_carrera.addItem(lista.get(i));
            }
            
            ArrayList<String> lista2 = new ArrayList<String>();
             lista = new Conexion_consulta().llenar_combo();
            for(int i = 0; i<lista.size();i++){
                cbo_campus.addItem(lista.get(i));
            }
            
             ArrayList<String> lista3 = new ArrayList<String>();
             lista3 = new Conexion_consulta().llenar_periodo();
            for(int i = 0; i<lista3.size();i++){
                cbo_periodo.addItem(lista3.get(i));
            }
             this.setTitle("Alumno");
             this.setIconImage(new ImageIcon(getClass().getResource("/Imagenes/Titulo.png")).getImage());
            
            
    
       Calendar f;
       
       f=Calendar.getInstance();
       
       int d=f.get(Calendar.DATE), mes=1+(f.get(Calendar.MONTH)), año=f.get(Calendar.YEAR);
       
      if(mes < 10){
           fechaHoy.setText(d+"/0"+mes+"/"+año);
       }
       if(mes >= 10){
          fechaHoy.setText(d+"/"+mes+"/"+año); 
       }
        this.lbl_cuenta.setVisible(false);
        this.lbl_numeroCuenta.setVisible(false);
        this.btn_actualizar.setEnabled(false);    
        ((JTextField) this.cld_fechaNacimiento.getDateEditor()).setEditable(false); 
    }
    
    public Alumno(String nombreUsuario) throws SQLException {
        initComponents();
        this.con = ConectorSQL.obtenerConexion();
         ArrayList<String> lista = new ArrayList<String>();
             lista = new Conexion_consulta().llenar_combo2();
            for(int i = 0; i<lista.size();i++){
                cbo_carrera.addItem(lista.get(i));
            }
            
            ArrayList<String> lista2 = new ArrayList<String>();
             lista = new Conexion_consulta().llenar_combo();
            for(int i = 0; i<lista.size();i++){
                cbo_campus.addItem(lista.get(i));
            }
            
             ArrayList<String> lista3 = new ArrayList<String>();
             lista3 = new Conexion_consulta().llenar_periodo();
            for(int i = 0; i<lista3.size();i++){
                cbo_periodo.addItem(lista3.get(i));
            }
             this.setTitle("Alumno");
             this.setIconImage(new ImageIcon(getClass().getResource("/Imagenes/Titulo.png")).getImage());
             
        this.con = ConectorSQL.obtenerConexion();
            String usuario = nombreUsuario;
       Calendar f;
       
       f=Calendar.getInstance();
       
       int d=f.get(Calendar.DATE), mes=1+(f.get(Calendar.MONTH)), año=f.get(Calendar.YEAR);
       
     if(mes < 10){
           fechaHoy.setText(d+"/0"+mes+"/"+año);
       }
       if(mes >= 10){
          fechaHoy.setText(d+"/"+mes+"/"+año); 
       }
       
        this.lbl_usuario.setText(usuario);
        this.lbl_cuenta.setVisible(false);
        this.lbl_numeroCuenta.setVisible(false);
        this.btn_actualizar.setEnabled(false); 
        ((JTextField) this.cld_fechaNacimiento.getDateEditor()).setEditable(false); 
        this.setTitle("Alumno");
        this.setIconImage(new ImageIcon(getClass().getResource("/Imagenes/Titulo.png")).getImage());
    }
    
    public boolean existeAlumno(){
       try {
            Statement st = con.createStatement();
            String sql = "Select numero_identidad from Alumno where numero_identidad = '"+txt_identidad.getText()+"'";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
           javax.swing.JOptionPane.showMessageDialog(this,"El número de identidad: "+txt_identidad.getText()+" ya existe","AVISO",javax.swing.JOptionPane.INFORMATION_MESSAGE);
                return true;
            }
            else{
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    
   }
    
    public boolean ValidarNumeroCuenta(String cuenta){
    Calendar f=Calendar.getInstance();
    int año=f.get(Calendar.YEAR);
      
        int numeroCuenta=Integer.parseInt(cuenta);
        if(numeroCuenta >= año){
            javax.swing.JOptionPane.showMessageDialog(this,"El número de cuenta es incorrecto","AVISO",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return true;
        }
        else{
            return false;
        }
       
        
        
        /*Calendar f=Calendar.getInstance();
    int año=f.get(Calendar.YEAR);
    
      String cuenta=txt_numeroCuenta.getText().toString().substring(0,3);
      String cuenta2=txt_numeroCuenta.getText().toString().substring(4,6);
      
      int numeroCuenta, numeroCuenta2;
      
      numeroCuenta=Integer.parseInt(cuenta);
      numeroCuenta2=Integer.parseInt(cuenta2);
      
      if(numeroCuenta > año){
           javax.swing.JOptionPane.showMessageDialog(this,"El número de cuenta es Incorrecto","AVISO",javax.swing.JOptionPane.INFORMATION_MESSAGE);
          return true;
      }else{
          return false;
      }*/
      
     
        
    }
    
    
     private boolean validarLongitudTelefono(JTextField texto, int longitud){
       if(texto.getText().length() == longitud){
                Pattern pattern = Pattern.compile("[23789]");
                Matcher matcher=pattern.matcher(texto.getText().substring(0,1));
                if(matcher.matches()){ 
                        return true;
                    }else{
                        JOptionPane.showMessageDialog(null, "El número de teléfono debe comenzar con: 2,3,7,8 o 9");
                        return false;
                    } 
       }
        else{
       }
       JOptionPane.showMessageDialog(null, "El número de teléfono debe ser de 8 dígitos", "Longitud del número de teléfono",JOptionPane.INFORMATION_MESSAGE);
       return false;
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        lbl_titulo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btn_agregarAlumnos = new javax.swing.JButton();
        btn_Limpiar = new javax.swing.JButton();
        btn_actualizar = new javax.swing.JButton();
        lbl_nombre = new javax.swing.JLabel();
        lbl_apellido = new javax.swing.JLabel();
        lbl_telefono = new javax.swing.JLabel();
        txt_telefono = new javax.swing.JTextField();
        txt_apellidos = new javax.swing.JTextField();
        txt_nombres = new javax.swing.JTextField();
        lbl_fechaNacimiento = new javax.swing.JLabel();
        cld_fechaNacimiento = new com.toedter.calendar.JDateChooser();
        cbo_carrera = new javax.swing.JComboBox<>();
        lbl_carrera = new javax.swing.JLabel();
        btn_buscar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        cbo_periodo = new javax.swing.JComboBox<>();
        cbo_campus = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        lbl_numeroCuenta = new javax.swing.JLabel();
        lbl_cuenta = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_identidad = new javax.swing.JTextField();
        lbl_usuario = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        fechaHoy = new javax.swing.JLabel();
        iconodeUsuario = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(232, 251, 249));

        lbl_titulo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbl_titulo.setText("Alumnos");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(546, 546, 546)
                .addComponent(lbl_titulo)
                .addContainerGap(575, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(lbl_titulo)
                .addContainerGap())
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 1210, 60));

        jPanel1.setBackground(new java.awt.Color(215, 236, 233));

        btn_agregarAlumnos.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_agregarAlumnos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/botton_Guardar.png"))); // NOI18N
        btn_agregarAlumnos.setText("Guardar");
        btn_agregarAlumnos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_agregarAlumnosMouseClicked(evt);
            }
        });
        btn_agregarAlumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregarAlumnosActionPerformed(evt);
            }
        });

        btn_Limpiar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_Limpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/botton_Limpiar.png"))); // NOI18N
        btn_Limpiar.setText("Limpiar");
        btn_Limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LimpiarActionPerformed(evt);
            }
        });

        btn_actualizar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_actualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/botton_Actualizar.png"))); // NOI18N
        btn_actualizar.setText("Actualizar");
        btn_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_actualizarActionPerformed(evt);
            }
        });

        lbl_nombre.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_nombre.setText("Nombres:");

        lbl_apellido.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_apellido.setText("Apellidos:");

        lbl_telefono.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_telefono.setText("Teléfono:");

        txt_telefono.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_telefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_telefonoActionPerformed(evt);
            }
        });
        txt_telefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_telefonoKeyTyped(evt);
            }
        });

        txt_apellidos.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_apellidos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_apellidosKeyTyped(evt);
            }
        });

        txt_nombres.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_nombres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nombresActionPerformed(evt);
            }
        });
        txt_nombres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_nombresKeyTyped(evt);
            }
        });

        lbl_fechaNacimiento.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_fechaNacimiento.setText("Fecha de nacimiento:");

        cld_fechaNacimiento.setBackground(new java.awt.Color(170, 226, 218));
        cld_fechaNacimiento.setAutoscrolls(true);
        cld_fechaNacimiento.setDateFormatString("dd/MM/yyyy");
        cld_fechaNacimiento.setMaxSelectableDate(new java.util.Date(1104562870000L));
        cld_fechaNacimiento.setMinSelectableDate(new java.util.Date(-1893430711000L));
        cld_fechaNacimiento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cld_fechaNacimientoKeyTyped(evt);
            }
        });

        cbo_carrera.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una carrera" }));
        cbo_carrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_carreraActionPerformed(evt);
            }
        });

        lbl_carrera.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_carrera.setText("Carrera:");

        btn_buscar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/botton_Consulta.png"))); // NOI18N
        btn_buscar.setText("Buscar");
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Período de ingreso:");

        cbo_periodo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione el período" }));
        cbo_periodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_periodoActionPerformed(evt);
            }
        });

        cbo_campus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un campus" }));
        cbo_campus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_campusActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Campus:");

        lbl_numeroCuenta.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_numeroCuenta.setText("Número de Cuenta:");

        lbl_cuenta.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_cuenta.setText("jLabel5");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Número de Identidad:");

        txt_identidad.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_identidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_identidadKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(82, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_buscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_agregarAlumnos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_actualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_Limpiar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(186, 186, 186)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_nombre)
                                    .addComponent(lbl_apellido))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_nombres, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_apellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_telefono, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_identidad, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbl_numeroCuenta)
                        .addGap(18, 18, 18)
                        .addComponent(lbl_cuenta)
                        .addGap(154, 154, 154)))
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(lbl_fechaNacimiento)
                    .addComponent(lbl_carrera))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbo_periodo, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbo_campus, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cld_fechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbo_carrera, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(69, 69, 69))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_numeroCuenta)
                            .addComponent(lbl_cuenta))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbl_nombre)
                                    .addComponent(txt_nombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txt_apellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2)
                                        .addComponent(cbo_periodo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lbl_apellido))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txt_telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4)
                                        .addComponent(cbo_campus, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lbl_telefono)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cbo_carrera, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbl_carrera)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txt_identidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3))
                            .addComponent(lbl_fechaNacimiento)
                            .addComponent(cld_fechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(btn_agregarAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_actualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_Limpiar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_buscar)))
                .addGap(18, 18, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, -1, 340));

        lbl_usuario.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_usuario.setText("Nombre Usuario");
        getContentPane().add(lbl_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 190, -1));

        jPanel3.setBackground(new java.awt.Color(232, 251, 249));
        jPanel3.setLayout(null);

        fechaHoy.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        fechaHoy.setText("Fecha hoy");
        jPanel3.add(fechaHoy);
        fechaHoy.setBounds(10, 10, 110, 16);

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 50, 120, 40));

        iconodeUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/User.png"))); // NOI18N
        getContentPane().add(iconodeUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 50, 70));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/imagen 3.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1320, 670));

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/menu.png"))); // NOI18N
        jMenu1.setText("Menú");
        jMenu1.setContentAreaFilled(false);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setBackground(new java.awt.Color(255, 255, 255));
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/inicio.png"))); // NOI18N
        jMenuItem2.setText("Menú Principal");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_telefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_telefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_telefonoActionPerformed

    private void cbo_carreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_carreraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbo_carreraActionPerformed

    private void txt_nombresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nombresActionPerformed
   
    }//GEN-LAST:event_txt_nombresActionPerformed

    private void btn_agregarAlumnosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_agregarAlumnosMouseClicked
      
    }//GEN-LAST:event_btn_agregarAlumnosMouseClicked

    public boolean validarIdentidad(String identidad){
        String id = identidad.substring(0, 1);
        
        if(identidad.length() < 13){
             JOptionPane.showMessageDialog(null, "El número de identidad es de 13 dígitos, usted ha ingresado solamente "+identidad.length()+" dígitos.", "Número de identidad muy corto", JOptionPane.ERROR_MESSAGE);
        }
        if(identidad.length() == 13){
             if("0".equals(id)){
                 return true;
             }
             else if("1".equals(id)){
                 return true;
             }
             else{
                 JOptionPane.showMessageDialog(null, "El número de identidad sólo puede comenzar con 0 o 1 ", "Error en campo identidad", JOptionPane.ERROR_MESSAGE);
                 return false;
             }
        }
        else{
           return false; 
        }    
    }
    private void btn_agregarAlumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregarAlumnosActionPerformed
        String numeroDeCuenta,nombreAlumno, apellidoAlumno, telefonoAlumno, idCarrera, identidad;
        numeroDeCuenta = "";
        nombreAlumno = txt_nombres.getText();
        apellidoAlumno = txt_apellidos.getText();
        telefonoAlumno = txt_telefono.getText();
        Date date = cld_fechaNacimiento.getDate();
        idCarrera = cbo_carrera.getSelectedItem().toString().substring(0, 4);
        String id_campus = cbo_campus.getSelectedItem().toString().substring(0, 4);
        String periodo2 = cbo_periodo.getSelectedItem().toString().substring(5, 6);
        String periodo = cbo_periodo.getSelectedItem().toString().substring(5, 6) + "0";
        
        
        identidad = txt_identidad.getText();
        
        if((txt_nombres.getText().equals(""))){
            javax.swing.JOptionPane.showMessageDialog(this,"Debe ingresar los nombres del alumno.","Nombres del alumno requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            txt_nombres.requestFocus();
            return;
        }
        
        if((txt_apellidos.getText().equals(""))){
             javax.swing.JOptionPane.showMessageDialog(this,"Debe ingresar los apellidos del alumno.","Apellidos del alumno requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            txt_apellidos.requestFocus();
            return;
        }
        
        if((txt_telefono.getText().equals(""))){
             javax.swing.JOptionPane.showMessageDialog(this,"Debe ingresar el teléfono del alumno.","Teléfono del alumno requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            txt_telefono.requestFocus();
            return;
        }
        
        if((txt_identidad.getText().equals(""))){
            javax.swing.JOptionPane.showMessageDialog(this,"Debe ingresar el número de identidad del alumno.","Número de identidad del alumno requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            txt_identidad.requestFocus();
            return;
         }
        
        
        if((cbo_carrera.getSelectedItem().equals("Seleccione una carrera"))){
            javax.swing.JOptionPane.showMessageDialog(this,"Debe seleccionar una carrera para el alumno.","Carrera del alumno requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
         if((cbo_periodo.getSelectedItem().equals("Seleccione el período"))){
            javax.swing.JOptionPane.showMessageDialog(this,"Debe seleccionar el período de inscripción del alumno.","Período de inscripción del alumno requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }
         
          if((cbo_campus.getSelectedItem().equals("Seleccione un campus"))){
            javax.swing.JOptionPane.showMessageDialog(this,"Debe seleccionar un campus para el alumno.","Campus del alumno requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }
          
     
        if((cld_fechaNacimiento.getDate()== null)){
             javax.swing.JOptionPane.showMessageDialog(this,"Debe ingresar la fecha de nacimiento del alumno.","Fecha de nacimiento del alumno requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        int mes1 = cld_fechaNacimiento.getDate().getMonth() + 1;
        int año1 = cld_fechaNacimiento.getDate().getYear() +1900;
        int dia1 = cld_fechaNacimiento.getDate().getDate();
        String fecha = año1 + "-" + mes1 +"-"+ dia1;
        
        if(existeAlumno()){
            return;
        }
        
         
        if(!validarLongitud(txt_nombres,5)){
            JOptionPane.showMessageDialog(null, "Los nombres ingresados son muy pequeños el mínimo es de 5 caracteres", "Longitud de los nombres", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
         if(!validarLongitud(txt_apellidos,5)){
            JOptionPane.showMessageDialog(null, "Los apellidos ingresados son muy pequeños el mínimo es de 5 caracteres", "Longitud de los apellidos", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        
         if(!validarLongitudTelefono(txt_telefono,8)){
            return;
        }
         
         if(!validarIdentidad(txt_identidad.getText())){
            return;
            
        }
         
         
       /* String cuenta=txt_numeroCuenta.getText().toString().substring(0,3);
          if(!ValidarNumeroCuenta(cuenta)){
            return;
        }*/

       
      try{
          PreparedStatement ps;
          ResultSet rs;
          ps=con.prepareStatement("INSERT INTO Alumno (numero_cuenta_alumno,nombres_alumno, apellidos_alumno, telefono_alumno, fecha_nacimiento, id_carrera, fecha_inscripcion,numero_identidad,id_campus,id_periodo)"
                  + "   "
                  + "             VALUES(?,?,?,?,?,?,?,?,?,?)");
          Calendar f;
       
       f=Calendar.getInstance();
       
       int d=f.get(Calendar.DATE), mes=1+(f.get(Calendar.MONTH)), año=f.get(Calendar.YEAR);
       
       String fecha2=(año+"-"+mes+"-"+d);
       fechaHoy.setText(fecha2);
       
      
       String consulta = "select campus,periodo,cantidad from NumerosCuenta\n" +
                          "where id_campus = '"+id_campus+"' and periodo = '"+periodo+"' ";
            Statement st1 = con.createStatement();
            ResultSet rs1;
            rs1 = st1.executeQuery(consulta);
            if(rs1.next()){
            int cantidad = Integer.parseInt(rs1.getString("cantidad")) + 1;
            numeroDeCuenta = f.get(Calendar.YEAR)+ rs1.getString("campus")+rs1.getString("periodo")+cantidad;
            String cons = "Update NumerosCuenta set cantidad = '"+cantidad+"'"
                        + "where id_campus = '"+id_campus+"' and periodo = '"+periodo+"'";
            Statement statement = con.createStatement();
            statement.executeUpdate(cons);
            }
                  ps.setString(1, numeroDeCuenta);
                  ps.setString(2, txt_nombres.getText());
                  ps.setString(3, txt_apellidos.getText());
                  ps.setString(4, txt_telefono.getText());
                  ps.setString(5,fecha);
                  ps.setString(6, idCarrera);
                  ps.setString(7,fechaHoy.getText());
                  ps.setString(8,identidad);
                  ps.setString(9,id_campus);
                  ps.setString(10,periodo2);
                  // ps.setString(7,((JTextField)cld_fechaNacimiento.getDateEditor().getUiComponent()).getText());
                  
                   // ps.setString(5,  cld_fechaNacimiento.getDateFormatString());
                  /* String fecha;
                  fecha= año+"/"+mes+"/"+dia;
                  ps.setString(5, fecha);*/
                 // ps.setString(7, fecha);
                  //ps.setString(7,  cld_fecha.getDateFormatString());
                 // ps.setString(7,  cld_fechaNacimiento.getDateFormatString());
                
                  int res= ps.executeUpdate();
                  if(res > 0){
                       JOptionPane.showMessageDialog(null, "Se ha guardado con éxito el alumno: "+txt_nombres.getText()+" "+txt_apellidos.getText()+""); 
                       limpiar();
                  }else {
                      JOptionPane.showMessageDialog(null, "Error al Guardar la informacion"); 
                  }
                  
       
      } catch ( Exception e) {
            System.out.println(e);
        }
        
        
        
        
        
        
        
        /* String numeroDeCuenta,nombreAlumno, apellidoAlumno, telefonoAlumno, idCarrera;
         
        numeroDeCuenta = txt_numeroCuenta.getText();
        nombreAlumno = txt_nombres.getText();
        apellidoAlumno = txt_apellidos.getText();
        telefonoAlumno = txt_telefono.getText();
        Date date = cld_fechaNacimiento.getDate();
     
        idCarrera = cbo_carrera.getSelectedItem().toString().substring(0, 4);
        String id_campus = cbo_carrera.getSelectedItem().toString().substring(0, 4);
       
        
        if  ((txt_numeroCuenta.getText().equals("")) || ((txt_nombres.getText().equals("")) || (txt_apellidos.getText().equals("")) || (txt_telefono.getText().equals(""))
         ||  (cld_fechaNacimiento.getDate().equals("")) || (cbo_carrera.getSelectedItem().equals("Seleccione un campus")) )) {
            
            javax.swing.JOptionPane.showMessageDialog(this,"Debe llenar todos los campos \n","AVISO!",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            txt_nombres.requestFocus();
            return;
        }
        
      if(existeAlumno()){
            return;
        }
        
      /* if(ValidarNumeroCuenta(numeroDeCuenta)){
            return;
        }*/
       
       
   
      
           
       
     
        
       /* if(!validarContraseñas(cadena10)){
            return;
        }*/
       
     /* try{
          
          PreparedStatement ps;
          ResultSet rs;
          ps=con.prepareStatement("INSERT INTO Alumno (numero_cuenta_alumno,nombres_alumno, apellidos_alumno, telefono_alumno, fecha_nacimiento, id_carrera, fecha_inscripcion)"
                  + "                VALUES(?,?,?,?,?,?,?)");
    
        Calendar f;
       
       f=Calendar.getInstance();
       
       int d=f.get(Calendar.DATE), mes=1+(f.get(Calendar.MONTH)), año=f.get(Calendar.YEAR);
       
       String fecha2=(año+"-"+mes+"-"+d);
       fechaHoy.setText(fecha2);
                
                 ps.setString(1, txt_numeroCuenta.getText());
                /*  String cuenta=txt_numeroCuenta.getText().toString().substring(0,3);
                   int numeroCuenta=Integer.parseInt(cuenta);
                 if(cuenta)*/
                 
                 /* ps.setString(2, txt_nombres.getText());
                  ps.setString(3, txt_apellidos.getText());
                  ps.setString(4, txt_telefono.getText());
                /*  dia=cld_fechaNacimiento.getCalendar().get(Calendar.DAY_OF_MONTH);
                  mes=cld_fechaNacimiento.getCalendar().get(Calendar.MONTH);
                  año=cld_fechaNacimiento.getCalendar().get(Calendar.YEAR);*/
          
                  /* ps.setString(5,((JTextField)cld_fechaNacimiento.getDateEditor().getUiComponent()).getText());
                  ps.setString(6, idCarrera);
                   ps.setString(7,fechaHoy.getText());
                   // ps.setString(5,  cld_fechaNacimiento.getDateFormatString());
                  /* String f;
                  f= año+"/"+mes+"/"+dia;
                  ps.setString(5, f);*/
                 // ps.setString(7, f);
                  //ps.setString(7,  cld_fecha.getDateFormatString());
                 // ps.setString(7,  cld_fechaNacimiento.getDateFormatString());
                
         
      
     
                /* int res= ps.executeUpdate();
                    
                  if(res > 0){
                       JOptionPane.showMessageDialog(null, "Se ha Guardado con Exito"); 
                  }else {
                      JOptionPane.showMessageDialog(null, "Error al Guardar la información"); 
                  }
                  
       
      } catch ( Exception e) {
   
          JOptionPane.showMessageDialog(null, "Error al Guardar la información"); 
            System.out.println(e);
             
        }*/
      
      
       
          
        
    }//GEN-LAST:event_btn_agregarAlumnosActionPerformed

    private void btn_LimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LimpiarActionPerformed
         limpiar();
    }//GEN-LAST:event_btn_LimpiarActionPerformed

    private void btn_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_actualizarActionPerformed
         String nombreAlumno = txt_nombres.getText() + " " + txt_apellidos.getText();
        
        if(JOptionPane.showConfirmDialog(null,"¿Está seguro que desea actualizar el registro del alumno: "+nombreAlumno+"?","Confirmación de actualización de alumno",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE
        )==JOptionPane.YES_OPTION){ 
            String idCarrera = cbo_carrera.getSelectedItem().toString().substring(0, 4);
            String id_campus = cbo_carrera.getSelectedItem().toString().substring(0, 4);
            int mes = cld_fechaNacimiento.getDate().getMonth() + 1;
            int año = cld_fechaNacimiento.getDate().getYear() +1900;
            int dia = cld_fechaNacimiento.getDate().getDate();
            String fecha = año + "-" + mes +"-"+ dia;
            String periodo = cbo_periodo.getSelectedItem().toString().substring(0, 1);
             if((txt_nombres.getText().equals(""))){
            javax.swing.JOptionPane.showMessageDialog(this,"Debe ingresar los nombres del alumno.","Nombres del alumno requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            txt_nombres.requestFocus();
            return;
        }
        
        if((txt_apellidos.getText().equals(""))){
             javax.swing.JOptionPane.showMessageDialog(this,"Debe ingresar los apellidos del alumno.","Apellidos del alumno requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            txt_apellidos.requestFocus();
            return;
        }
        
        if((txt_telefono.getText().equals(""))){
             javax.swing.JOptionPane.showMessageDialog(this,"Debe ingresar el teléfono del alumno.","Teléfono del alumno requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            txt_telefono.requestFocus();
            return;
        }
        
        if((txt_identidad.getText().equals(""))){
            javax.swing.JOptionPane.showMessageDialog(this,"Debe ingresar el número de identidad del alumno.","Número de identidad del alumno requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            txt_identidad.requestFocus();
            return;
         }
        
        
        if((cbo_carrera.getSelectedItem().equals("Seleccione una carrera"))){
            javax.swing.JOptionPane.showMessageDialog(this,"Debe seleccionar una carrera para el alumno.","Carrera del alumno requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
         if((cbo_periodo.getSelectedItem().equals("Seleccione el período"))){
            javax.swing.JOptionPane.showMessageDialog(this,"Debe seleccionar el período de inscripción del alumno.","Período de inscripción del alumno requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }
         
          if((cbo_campus.getSelectedItem().equals("Seleccione un campus"))){
            javax.swing.JOptionPane.showMessageDialog(this,"Debe seleccionar un campus para el alumno.","Campus del alumno requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }
          
     
        if((cld_fechaNacimiento.getDate()== null)){
             javax.swing.JOptionPane.showMessageDialog(this,"Debe ingresar la fecha de nacimiento del alumno.","Fecha de nacimiento del alumno requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
             if(!validarLongitudTelefono(txt_telefono,8)){
            return;
            }
            if(!validarIdentidad(txt_identidad.getText())){
            return;
            
        }
          try{
              PreparedStatement ps;
              ResultSet rs;
              ps=con.prepareStatement("Update Alumno\n" +
"                      set nombres_alumno = ?,\n" +
"                      apellidos_alumno = ?,\n" +
"                      telefono_alumno = ?,\n" +
"                      fecha_nacimiento = ?,\n" +
"                      id_carrera = ?,\n" +
"                      numero_identidad = ?,\n" +
"                      id_campus =?,\n" +
"                      id_periodo= ?\n" +
"                      where numero_cuenta_alumno = '"+var+"'\n" +
"                      or numero_identidad = '"+var+"'");
                      ps.setString(1,txt_nombres.getText());
                      ps.setString(2,txt_apellidos.getText());
                      ps.setString(3,txt_telefono.getText());
                      ps.setString(4,fecha);
                      ps.setString(5,idCarrera);
                      ps.setString(6,txt_identidad.getText());
                      ps.setString(7,id_campus);
                      ps.setString(8,periodo);
                      int res= ps.executeUpdate();
                      JOptionPane.showMessageDialog(null, "Se ha actualizado la información del alumno: "+nombreAlumno+" correctamente.");
                      this.btn_actualizar.setEnabled(false); 
                      this.lbl_numeroCuenta.setVisible(false);
                      this.lbl_cuenta.setVisible(false);
                      this.btn_agregarAlumnos.setEnabled(true);
                      limpiar();
            } catch ( Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
                
                
            }
         }
    }//GEN-LAST:event_btn_actualizarActionPerformed

    public void rellenar(){
                    try{
                    String cap="";
                    ResultSet rs2 = null;
                    var = JOptionPane.showInputDialog(this,"Ingrese el número de identidad, o el número de cuenta del alumno que desea consultar","Consulta de alumno",JOptionPane.QUESTION_MESSAGE);
                    if(var == null)
                        JOptionPane.showMessageDialog(this,"La acción fue cancelada","¡AVISO!",JOptionPane.INFORMATION_MESSAGE);
                    else {
                        if (var.equals("")) {
                            JOptionPane.showMessageDialog(this,"Favor de ingresar los datos del alumno\n que desea consultar","¡AVISO!",JOptionPane.INFORMATION_MESSAGE);
                        }
                        else{
                            String sql = "Select nombres_alumno,apellidos_alumno,telefono_alumno,fecha_nacimiento, c.id_carrera,nombre_carrera, "
                                        + "ca.id_campus,nombre_campus,numero_cuenta_alumno,a.id_periodo,descripcion,numero_identidad,ph.nombre_periodo_historico from alumno as a join Carrera as c on a.id_carrera = c.id_carrera\n" +
                                        "join Campus as ca on ca.id_campus = a.id_campus join periodo as j on j.id_periodo = a.id_periodo\n"
                                    + "join Periodo_historico as ph on ph.id_periodo = j.id_periodo" +
                                        " where numero_cuenta_alumno = '"+var+"' or numero_identidad = '"+var+"'";
                            Statement stmt = con.createStatement();
                            rs2 = stmt.executeQuery(sql);
                            if(rs2.next()) {
                                txt_nombres.setText(rs2.getString("nombres_alumno"));
                                txt_apellidos.setText(rs2.getString("apellidos_alumno"));
                                txt_telefono.setText(rs2.getString("telefono_alumno"));
                                cld_fechaNacimiento.setDate(rs2.getDate("fecha_nacimiento"));
                                cbo_carrera.setSelectedItem(rs2.getString("id_carrera") + " - " + rs2.getString("nombre_carrera"));
                                cbo_periodo.setSelectedItem(rs2.getString("nombre_periodo_historico") + " Período");
                                cbo_campus.setSelectedItem(rs2.getString("id_campus") + " - " + rs2.getString("nombre_campus"));
                                this.lbl_cuenta.setVisible(true);
                                this.lbl_numeroCuenta.setVisible(true);
                                lbl_cuenta.setText(rs2.getString("numero_cuenta_alumno"));
                                txt_identidad.setText(rs2.getString("numero_identidad"));
                                this.btn_actualizar.setEnabled(true); 
                                this.btn_agregarAlumnos.setEnabled(false);
                            }
                            else{
                               JOptionPane.showMessageDialog(null,"¡No se encuentra el alumno! Por favor verifique sí, lo escribió correctamente");
                            }
                        }  
                    }
                    }catch (Exception e) {
                            JOptionPane.showMessageDialog(null,e.getMessage());
                            }
     
        
    }
    private void txt_nombresKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nombresKeyTyped
        char a=evt.getKeyChar();
            if (evt.getKeyChar() == 8 || evt.getKeyChar() == 127 || 
                 evt.getKeyChar() == 0 || evt.getKeyChar() == 3 || evt.getKeyChar() == 22 
                 || evt.getKeyChar() == 26 || evt.getKeyChar() == 24 ) {
        return;
        }
            
             if(evt.getKeyChar() == 32){
             if(txt_nombres.getText().length() == 0){
                 evt.consume();
                 Toolkit.getDefaultToolkit().beep();
                 return;
             }
             if(txt_nombres.getText().substring(txt_nombres.getText().length() - 1).equals(" ")){
                 evt.consume();
                 Toolkit.getDefaultToolkit().beep();
             }
             return; 
         }
              
            
        if(txt_nombres.getText().length() >=40){
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Número máximo de caracteres admitidos");
        }
        
        if(Character.isDigit(a) || !Character.isLetterOrDigit(a)){
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Sólo letras");
        }
            
    }//GEN-LAST:event_txt_nombresKeyTyped

    private void txt_apellidosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_apellidosKeyTyped
        char a=evt.getKeyChar();
            if (evt.getKeyChar() == 8 || evt.getKeyChar() == 127 || 
                 evt.getKeyChar() == 0 || evt.getKeyChar() == 3 || evt.getKeyChar() == 22 
                 || evt.getKeyChar() == 26 || evt.getKeyChar() == 24 ) {
        return;
        }   
                 if(evt.getKeyChar() == 32){
             if(txt_apellidos.getText().length() == 0){
                 evt.consume();
                 Toolkit.getDefaultToolkit().beep();
                 return;
             }
             if(txt_apellidos.getText().substring(txt_apellidos.getText().length() - 1).equals(" ")){
                 evt.consume();
                 Toolkit.getDefaultToolkit().beep();
             }
             return; 
         }
              
        if(txt_apellidos.getText().length() >=40){
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Número máximo de caracteres admitidos");
        }
           if(Character.isDigit(a) || !Character.isLetterOrDigit(a)){
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Sólo letras");
        }
    }//GEN-LAST:event_txt_apellidosKeyTyped

    private void cld_fechaNacimientoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cld_fechaNacimientoKeyTyped
        char a=evt.getKeyChar();
        
   
    }//GEN-LAST:event_cld_fechaNacimientoKeyTyped

    private void txt_telefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_telefonoKeyTyped
        char a=evt.getKeyChar();
            if (evt.getKeyChar() == 8 || evt.getKeyChar() == 127 || 
                 evt.getKeyChar() == 0 || evt.getKeyChar() == 3 || evt.getKeyChar() == 22 
                 || evt.getKeyChar() == 26 || evt.getKeyChar() == 24) {
        return;
        }
        if(txt_telefono.getText().length() >=8){
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Número máximo de dígitos admitidos");
        }
      
        if(Character.isLetter(a) || !Character.isLetterOrDigit(a)){
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Sólo números");
        }
    }//GEN-LAST:event_txt_telefonoKeyTyped

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
        rellenar();
    }//GEN-LAST:event_btn_buscarActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
       try {
            String sql2 = "Select nombres_empleado + ' ' + apellido_empleado from Empleados where id_empleado = (select id_empleado from Acceso where nombre_usuario = '"+lbl_usuario.getText()+"')";
                Statement st2 = con.createStatement();
                ResultSet rs2 = st2.executeQuery(sql2);
                if(rs2.next()){
                Principal principal = new Principal(lbl_usuario.getText(),rs2.getString(1));
                principal.setVisible(true); 
                this.dispose();
                }
                else{
                    JOptionPane.showMessageDialog(null, "Error");
                }
        } catch (SQLException ex) {
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void cbo_periodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_periodoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbo_periodoActionPerformed

    private void cbo_campusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_campusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbo_campusActionPerformed

    private void txt_identidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_identidadKeyTyped
          char a=evt.getKeyChar();
            if (evt.getKeyChar() == 8 || evt.getKeyChar() == 127 || 
                 evt.getKeyChar() == 0 || evt.getKeyChar() == 3 || evt.getKeyChar() == 22 
                 || evt.getKeyChar() == 26 || evt.getKeyChar() == 24) {
        return;
        }
        if(txt_identidad.getText().length() >=13){
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Número máximo de dígitos admitidos");
        }
        if(Character.isLetter(a) || !Character.isLetterOrDigit(a)){
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Sólo números");
        }
    }//GEN-LAST:event_txt_identidadKeyTyped

        private void limpiar(){
        txt_nombres.setText(null);
        txt_apellidos.setText(null);
        txt_telefono.setText(null);
        cld_fechaNacimiento.setCalendar(null);
        cbo_carrera.setSelectedIndex(0);
        cbo_periodo.setSelectedIndex(0);
        cbo_campus.setSelectedIndex(0);
        txt_identidad.setText(null);
        lbl_numeroCuenta.setVisible(false);
        lbl_cuenta.setVisible(false);
        this.btn_actualizar.setEnabled(false);
        this.btn_agregarAlumnos.setEnabled(true);
        this.btn_buscar.setEnabled(true);
               
    }
        
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
            java.util.logging.Logger.getLogger(Alumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Alumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Alumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Alumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Alumno().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Alumno.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Limpiar;
    private javax.swing.JButton btn_actualizar;
    private javax.swing.JButton btn_agregarAlumnos;
    private javax.swing.JButton btn_buscar;
    private javax.swing.JComboBox<String> cbo_campus;
    private javax.swing.JComboBox<String> cbo_carrera;
    private javax.swing.JComboBox<String> cbo_periodo;
    private com.toedter.calendar.JDateChooser cld_fechaNacimiento;
    private javax.swing.JLabel fechaHoy;
    private javax.swing.JLabel iconodeUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lbl_apellido;
    private javax.swing.JLabel lbl_carrera;
    private javax.swing.JLabel lbl_cuenta;
    private javax.swing.JLabel lbl_fechaNacimiento;
    private javax.swing.JLabel lbl_nombre;
    private javax.swing.JLabel lbl_numeroCuenta;
    private javax.swing.JLabel lbl_telefono;
    private javax.swing.JLabel lbl_titulo;
    private javax.swing.JLabel lbl_usuario;
    private javax.swing.JTextField txt_apellidos;
    private javax.swing.JTextField txt_identidad;
    private javax.swing.JTextField txt_nombres;
    private javax.swing.JTextField txt_telefono;
    // End of variables declaration//GEN-END:variables

   
 private boolean validarLongitud(JTextField texto, int longitud){
       if(texto.getText().length() >= longitud){
           return true;
       }
       else{
           return false;
       }
    }

}
