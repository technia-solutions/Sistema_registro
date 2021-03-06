/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema_registro;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import sistema_registro.SQL.ConectorSQL;
import codigo.Conexion_consulta;
import java.awt.Toolkit;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import org.apache.commons.codec.digest.DigestUtils;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.view.JRSaveContributor;
import net.sf.jasperreports.view.JRViewer;

/**
 *
 * @author William
 */
public class Empleado extends javax.swing.JFrame {
     
    String titulos [] = {"Id Empleado","Nombre","Apellido", "Salario", "Teléfono", "Número de Identidad", "Campus", "Nombre de Usuario", "Tipo de Usuario"};
    //String fila [] = new String[9];
    DefaultTableModel modelo =  new DefaultTableModel();
    Connection con = null;
    Statement stmt = null;
    String var, var2;
    NumberFormat nf;
    final Calendar calendar = Calendar.getInstance();
    final java.util.Date  date = calendar.getTime();
    String fecha = new SimpleDateFormat("yyyyMMdd-hh.mm.ss").format(date);
    
    
    private void LimpiarCajas(){
        txt_Nombre.setText(null);
        txt_Apellido.setText(null);
        txt_Telefono.setText(null);
        txt_Salario.setText(null);
        txt_Identidad.setText(null);
       cbo_idCampus.setSelectedIndex(0);
        txt_NombreUsuario.setText(null);
        pwd_contraseña.setText(null);

    }
    

    /**
     * Creates new form RegistroEmpleado
     */
    
    public Empleado() throws SQLException {
        this.con = ConectorSQL.obtenerConexion();
        initComponents();
             ArrayList<String> lista = new ArrayList<String>();
             lista = new Conexion_consulta().llenar_combo();
            for(int i = 0; i<lista.size();i++){
                cbo_idCampus.addItem(lista.get(i));
            }
            ArrayList<String> lista2 = new ArrayList<String>();
             lista2 = new Conexion_consulta().llenar_tipoUsuario();
            for(int i = 0; i<lista2.size();i++){
                cbo_tipoUsuario.addItem(lista2.get(i));
            }
            this.setLocationRelativeTo(null);
            this.setTitle("Empleados");
            this.setIconImage(new ImageIcon(getClass().getResource("/Imagenes/Titulo.png")).getImage());
            this.btn_Actualizar.setEnabled(false);
            this.btn_Eliminar.setEnabled(false);
            
            
              Calendar f;
       
       f=Calendar.getInstance();
       
       int d=f.get(Calendar.DATE), mes=1+(f.get(Calendar.MONTH)), año=f.get(Calendar.YEAR);
       
        if(mes < 10){
           fechaHoy.setText(d+"/0"+mes+"/"+año);
       }
       if(mes >= 10){
          fechaHoy.setText(d+"/"+mes+"/"+año); 
       }
       nf = NumberFormat.getInstance(new Locale("en", "US"));
       this.lbl_numeroIdentidad.setVisible(true);
       this.lbl_nombreU.setVisible(false);
    } 
    
    public Empleado(String nombreUsuario) throws SQLException {
        this.con = ConectorSQL.obtenerConexion();
        initComponents();
             ArrayList<String> lista = new ArrayList<String>();
             lista = new Conexion_consulta().llenar_combo();
            for(int i = 0; i<lista.size();i++){
                cbo_idCampus.addItem(lista.get(i));
            }
            
             ArrayList<String> lista2 = new ArrayList<String>();
             lista2 = new Conexion_consulta().llenar_tipoUsuario();
            for(int i = 0; i<lista2.size();i++){
                cbo_tipoUsuario.addItem(lista2.get(i));
            }
            noVisible();
           
            Calendar f;
       
       f=Calendar.getInstance();
       
       int d=f.get(Calendar.DATE), mes=1+(f.get(Calendar.MONTH)), año=f.get(Calendar.YEAR);
       
      if(mes < 10){
           fechaHoy.setText(d+"/0"+mes+"/"+año);
       }
       if(mes >= 10){
          fechaHoy.setText(d+"/"+mes+"/"+año); 
       }
        String usuario = nombreUsuario;
        this.lbl_usuario.setText(usuario);
        this.setIconImage(new ImageIcon(getClass().getResource("/Imagenes/Titulo.png")).getImage());
        this.setLocationRelativeTo(null);
        this.btn_Actualizar.setEnabled(false);
        this.btn_Eliminar.setEnabled(false);
        this.lbl_numeroIdentidad.setVisible(false);
        this.lbl_nombreU.setVisible(false);
         habilitar(lbl_usuario.getText());
    } 
     private void noVisible(){
         btn_guardar.setVisible(false);
         btn_Actualizar.setVisible(false);
          btn_Eliminar.setVisible(false);
             btn_consultar.setVisible(false);
             menu_Imprimir.setVisible(false);
         }
        
        private void habilitar(String nombreUsuario){
     try {
         Statement st = con.createStatement();
         String sql = "select * from Acceso_Pantallas where nombre_usuario = '"+nombreUsuario+"'";
         ResultSet rs = st.executeQuery(sql);
         if(rs.next()){
             
         
                if(rs.getString("EmpleadosFunciones").contains("G")){
                    btn_guardar.setVisible(true);
                }
                if(rs.getString("EmpleadosFunciones").contains("A")){
                    btn_Actualizar.setVisible(true);
                }
                if(rs.getString("EmpleadosFunciones").contains("E")){
                  btn_Eliminar.setVisible(true);
                }
                       if(rs.getString("EmpleadosFunciones").contains("B")){
                  btn_consultar.setVisible(true);
                }
             
                           if(rs.getString("EmpleadosFunciones").contains("I")){
                 menu_Imprimir.setVisible(true);
                }
             
                
         }
         
     } catch (SQLException ex) {
         Logger.getLogger(Matricula.class.getName()).log(Level.SEVERE, null, ex);
     }
        }

    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    
   // public void AutoCompletar () {
//ResultSet rs= null;
//TextAutoCompletar tac = new TextAutompletar (txt_Nombre);
   // }

    
   /* 
     public void ConsultaIndividual() {
        String cap="";
        ResultSet  rs = null;
        var2 = var;
        String sql= "select nombres_empleado,apellido_empleado,salario,telefono_empleado,numero_identidad,nombre_usuario,id_campus,tipo_usuario  from Empleados as e join\n" +
        "Acceso as a on e.id_empleado = a.id_empleado";

   try { 
	stmt = con.createStatement(); 
        rs = stmt.executeQuery(sql); 

	int i=1; 
	   while ( rs.next() ) { 
	           String Nombre = rs.getString("nombres_empleado"); 
	           String Apellido = rs.getString("apellido_empleado"); 
                   String Salario= rs.getString("salario"); 
                   String Telefono = rs.getString("telefono_empleado"); 
                   String Identidad = rs.getString("numero_identidad");
                   String idCampus = rs.getString("id_campus");
                   String NombreUsuario = rs.getString("tipo_usuario");
                    txt_Nombre.setText(Nombre);
                    txt_Apellido.setText(Apellido);
                    txt_Salario.setText(Salario);
                    txt_Telefono.setText(Telefono);
                    txt_Identidad.setText(Identidad);
                    cbo_idCampus.setSelectedItem(idCampus);
                    txt_NombreUsuario.setText(NombreUsuario);
                    pwd_contraseña.setText(contraseña);
                    cbo_tipoUsuario.setSelectedItem(tipoUsuario);
	         } 
	        } 
catch( SQLException ex ) { 
ex.printStackTrace(); 
	                  } catch (InstantiationException ex) { 
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, ex);
        } 
	
	finally { 
	                  if ( rs != null ) { 
	                      try    {
	rs.close();
                             } catch( SQLException ex ) { 
	System.out.println( ex.getMessage()); 
	ex.printStackTrace(); 
	                      } 
	                  } 
	                  if ( stmt != null ) { 
	                      try    {
	stmt.close(); 
	                      } catch( SQLException ex ) { 
	System.out.println( ex.getMessage()); 
	ex.printStackTrace(); 
	                      } 
	                  } 
	                  if ( con != null ) { 
	                      try    {
	con.close(); 
	                      } catch( SQLException ex ) { 
	System.out.println( ex.getMessage()); 
	ex.printStackTrace(); 
         } 
       }
     }    
    
             
    }
     */
     
     
     
      public void Actualizar() {

    String cadena1,cadena2,cadena3,cadena4,cadena5,cadena6,cadena7,cadena8,cadena9;

       cadena1 = txt_Nombre.getText();
       cadena2 = txt_Apellido.getText();
       cadena3 = txt_Salario.getText();
       cadena4 = txt_Telefono.getText();
       cadena5 = txt_Identidad.getText();
       cadena6 = (String) cbo_idCampus.getSelectedItem();
       cadena7 = txt_NombreUsuario.getText();
       cadena8 = pwd_contraseña.getText();
       cadena9 = cbo_tipoUsuario.getSelectedItem().toString();


     if (txt_Nombre.getText().equals("")) {

javax.swing.JOptionPane.showMessageDialog(this,"1-. Consulte el nombre del empleado\n 2-. Actualice el dato deseado en el campo correspondiente","AVISO!",javax.swing.JOptionPane.INFORMATION_MESSAGE);
}
     else {   

     try { 
         
stmt = con.createStatement(); 
stmt.executeUpdate("update ignore usuarios set Nombre= '"+cadena1+"' , Apellido = '"+cadena2+"',Salario = '"+cadena3+"',Telefono = '"+cadena4+"', idCampus = '"+cadena5+"', NombreUsuario = "+cadena6+": contraseña = '"+cadena7+"', tipoUsuario = '"+cadena8+"' where Nombre= '"+txt_Nombre.getText()+"' || Apellido = '"+txt_Apellido.getText()+"' || Salario = '"+txt_Salario.getText()+"' || Telefono = '"+txt_Telefono.getText()+"' || idCampus = '"+cbo_idCampus.getSelectedItem()+"' || contraseña= '"+pwd_contraseña.getText()+"' || tipoUsuario = '"+cbo_tipoUsuario.getSelectedItem()+"'"); 

System.out.println("Los valores han sido Actualizados"); 
} 
catch( SQLException e ) { 
e.printStackTrace(); 
                  } 

finally { 
                  if ( con != null ) { 
                      try    {
con.close(); 
stmt.close(); 
                      } catch( Exception e ) { 
System.out.println( e.getMessage()); 
                      } 
                  } 
     }
javax.swing.JOptionPane.showMessageDialog(this,"Actualizado Correctamente!","AVISO!",javax.swing.JOptionPane.INFORMATION_MESSAGE);
     } 
this.txt_Nombre.setText("");
this.txt_Apellido.setText("");
this.txt_Salario.setText("");
this.txt_Telefono.setText("");
this.txt_Identidad.setText("");
this.cbo_idCampus.setSelectedItem("");
this:txt_NombreUsuario.setText("");
this.pwd_contraseña.setText("");
this.cbo_tipoUsuario.setSelectedItem("");
    }
     
     
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla_Empleados = new javax.swing.JTable();
        lbl_usuario = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btn_guardar = new javax.swing.JButton();
        btn_Actualizar = new javax.swing.JButton();
        btn_Eliminar = new javax.swing.JButton();
        btn_consultar = new javax.swing.JButton();
        btn_Limpiar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        chb_mostrarContraseña = new javax.swing.JCheckBox();
        lbl_nombres = new javax.swing.JLabel();
        txt_Nombre = new javax.swing.JTextField();
        lbl_apellidos = new javax.swing.JLabel();
        txt_Apellido = new javax.swing.JTextField();
        lbl_salario = new javax.swing.JLabel();
        lbl_telefono = new javax.swing.JLabel();
        txt_Telefono = new javax.swing.JTextField();
        lbl_identidad = new javax.swing.JLabel();
        txt_Identidad = new javax.swing.JTextField();
        lbl_nombreUsuario = new javax.swing.JLabel();
        txt_NombreUsuario = new javax.swing.JTextField();
        lbl_contraseña = new javax.swing.JLabel();
        pwd_contraseña = new javax.swing.JPasswordField();
        lbl_idCampus = new javax.swing.JLabel();
        cbo_idCampus = new javax.swing.JComboBox<>();
        lbl_tipoUsuario = new javax.swing.JLabel();
        cbo_tipoUsuario = new javax.swing.JComboBox<>();
        btn_rellenarCampos = new javax.swing.JButton();
        txt_Salario = new javax.swing.JTextField();
        lbl_numeroIdentidad = new javax.swing.JLabel();
        lbl_nombreU = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lbl_titulo = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        fechaHoy = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menu_MenuPrincipal = new javax.swing.JMenuItem();
        menu_desbloquearUsuario = new javax.swing.JMenuItem();
        menu_Campus = new javax.swing.JMenuItem();
        menu_tipoUsuario = new javax.swing.JMenuItem();
        menu_Imprimir = new javax.swing.JMenuItem();

        jButton1.setText("jButton1");

        jLabel3.setText("jLabel3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Tabla_Empleados.setBackground(new java.awt.Color(204, 204, 204));
        Tabla_Empleados.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Tabla_Empleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Empleado", "Nombres", "Apellidos", "Salario", "Télefono", "Número de Identidad", "Campus", "Nombre de Usuario", "Tipo de Usuario"
            }
        ));
        Tabla_Empleados.setToolTipText("Presiona consulta para ver todos los empleados");
        Tabla_Empleados.setAlignmentX(15.0F);
        Tabla_Empleados.setAlignmentY(15.0F);
        Tabla_Empleados.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Tabla_Empleados.setGridColor(new java.awt.Color(0, 0, 0));
        Tabla_Empleados.setIntercellSpacing(new java.awt.Dimension(3, 3));
        Tabla_Empleados.setMaximumSize(new java.awt.Dimension(60, 64));
        Tabla_Empleados.setPreferredSize(new java.awt.Dimension(200, 64));
        Tabla_Empleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tabla_EmpleadosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Tabla_Empleados);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 520, 1280, 118));

        lbl_usuario.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_usuario.setText("Nombre de Usuario");
        getContentPane().add(lbl_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 180, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/User.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 60, 70));

        jPanel1.setBackground(new java.awt.Color(215, 236, 233));
        jPanel1.setLayout(null);

        btn_guardar.setBackground(new java.awt.Color(235, 250, 251));
        btn_guardar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/botton_Guardar.png"))); // NOI18N
        btn_guardar.setText("  Guardar");
        btn_guardar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_guardar);
        btn_guardar.setBounds(40, 50, 150, 41);

        btn_Actualizar.setBackground(new java.awt.Color(235, 250, 251));
        btn_Actualizar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_Actualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/botton_Actualizar.png"))); // NOI18N
        btn_Actualizar.setText(" Actualizar");
        btn_Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ActualizarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Actualizar);
        btn_Actualizar.setBounds(40, 100, 150, 41);

        btn_Eliminar.setBackground(new java.awt.Color(235, 250, 251));
        btn_Eliminar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_Eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/botton_Eliminar.png"))); // NOI18N
        btn_Eliminar.setText(" Eliminar");
        btn_Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limpiarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Eliminar);
        btn_Eliminar.setBounds(40, 150, 150, 41);

        btn_consultar.setBackground(new java.awt.Color(235, 250, 251));
        btn_consultar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_consultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/botton_Consulta.png"))); // NOI18N
        btn_consultar.setText("Consultar");
        btn_consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_consultarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_consultar);
        btn_consultar.setBounds(40, 200, 150, 41);

        btn_Limpiar.setBackground(new java.awt.Color(235, 250, 251));
        btn_Limpiar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_Limpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/botton_Limpiar.png"))); // NOI18N
        btn_Limpiar.setText("Limpiar");
        btn_Limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Limpiarbtn_limpiarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Limpiar);
        btn_Limpiar.setBounds(40, 250, 150, 41);
        btn_Limpiar.getAccessibleContext().setAccessibleDescription("Limpiar Todos los campos");

        jButton2.setText("jButton2");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(70, 380, 73, 23);

        chb_mostrarContraseña.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        chb_mostrarContraseña.setText("Mostrar contraseña");
        chb_mostrarContraseña.setContentAreaFilled(false);
        chb_mostrarContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chb_mostrarContraseñaActionPerformed(evt);
            }
        });
        jPanel1.add(chb_mostrarContraseña);
        chb_mostrarContraseña.setBounds(940, 160, 147, 23);

        lbl_nombres.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_nombres.setText("Nombres:");
        jPanel1.add(lbl_nombres);
        lbl_nombres.setBounds(350, 70, 90, 22);

        txt_Nombre.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_Nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_NombreActionPerformed(evt);
            }
        });
        txt_Nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_NombreKeyTyped(evt);
            }
        });
        jPanel1.add(txt_Nombre);
        txt_Nombre.setBounds(440, 70, 200, 28);

        lbl_apellidos.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_apellidos.setText("Apellidos:");
        jPanel1.add(lbl_apellidos);
        lbl_apellidos.setBounds(350, 110, 80, 22);

        txt_Apellido.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_Apellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_ApellidoKeyTyped(evt);
            }
        });
        jPanel1.add(txt_Apellido);
        txt_Apellido.setBounds(440, 110, 200, 28);

        lbl_salario.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_salario.setText("Salario:");
        jPanel1.add(lbl_salario);
        lbl_salario.setBounds(370, 160, 60, 22);

        lbl_telefono.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_telefono.setText("  Teléfono:");
        jPanel1.add(lbl_telefono);
        lbl_telefono.setBounds(343, 210, 87, 22);

        txt_Telefono.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_Telefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_TelefonoActionPerformed(evt);
            }
        });
        txt_Telefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_TelefonoKeyTyped(evt);
            }
        });
        jPanel1.add(txt_Telefono);
        txt_Telefono.setBounds(440, 210, 200, 28);

        lbl_identidad.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_identidad.setText("Identidad:");
        jPanel1.add(lbl_identidad);
        lbl_identidad.setBounds(350, 260, 90, 22);

        txt_Identidad.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_Identidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_IdentidadKeyTyped(evt);
            }
        });
        jPanel1.add(txt_Identidad);
        txt_Identidad.setBounds(440, 260, 200, 28);

        lbl_nombreUsuario.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_nombreUsuario.setText("Nombre de Usuario:");
        jPanel1.add(lbl_nombreUsuario);
        lbl_nombreUsuario.setBounds(710, 80, 158, 22);

        txt_NombreUsuario.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_NombreUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_NombreUsuarioActionPerformed(evt);
            }
        });
        txt_NombreUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_NombreUsuarioKeyTyped(evt);
            }
        });
        jPanel1.add(txt_NombreUsuario);
        txt_NombreUsuario.setBounds(880, 80, 250, 28);

        lbl_contraseña.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_contraseña.setText("Contraseña:");
        jPanel1.add(lbl_contraseña);
        lbl_contraseña.setBounds(770, 130, 94, 22);

        pwd_contraseña.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        pwd_contraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pwd_contraseñaActionPerformed(evt);
            }
        });
        pwd_contraseña.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pwd_contraseñaKeyTyped(evt);
            }
        });
        jPanel1.add(pwd_contraseña);
        pwd_contraseña.setBounds(880, 130, 250, 28);

        lbl_idCampus.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_idCampus.setText("Campus:");
        jPanel1.add(lbl_idCampus);
        lbl_idCampus.setBounds(790, 190, 69, 22);

        cbo_idCampus.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cbo_idCampus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un campus" }));
        cbo_idCampus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_idCampusActionPerformed(evt);
            }
        });
        jPanel1.add(cbo_idCampus);
        cbo_idCampus.setBounds(880, 190, 250, 28);

        lbl_tipoUsuario.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_tipoUsuario.setText("Tipo de Usuario:");
        jPanel1.add(lbl_tipoUsuario);
        lbl_tipoUsuario.setBounds(730, 230, 140, 22);

        cbo_tipoUsuario.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cbo_tipoUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un tipo de usuario" }));
        cbo_tipoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_tipoUsuarioActionPerformed(evt);
            }
        });
        jPanel1.add(cbo_tipoUsuario);
        cbo_tipoUsuario.setBounds(880, 230, 250, 28);

        btn_rellenarCampos.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_rellenarCampos.setText("Buscar");
        btn_rellenarCampos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_rellenarCamposMouseClicked(evt);
            }
        });
        btn_rellenarCampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_rellenarCamposActionPerformed(evt);
            }
        });
        jPanel1.add(btn_rellenarCampos);
        btn_rellenarCampos.setBounds(610, 320, 110, 31);

        txt_Salario.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_Salario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_SalarioKeyTyped(evt);
            }
        });
        jPanel1.add(txt_Salario);
        txt_Salario.setBounds(440, 160, 200, 30);

        lbl_numeroIdentidad.setText("jLabel4");
        jPanel1.add(lbl_numeroIdentidad);
        lbl_numeroIdentidad.setBounds(440, 20, 200, 20);

        lbl_nombreU.setText("jLabel4");
        jPanel1.add(lbl_nombreU);
        lbl_nombreU.setBounds(890, 20, 140, 14);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 1240, 360));

        jPanel2.setBackground(new java.awt.Color(232, 251, 249));

        lbl_titulo.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        lbl_titulo.setText("Empleado");
        lbl_titulo.setAutoscrolls(true);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(512, 512, 512)
                .addComponent(lbl_titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(585, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_titulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, 50));

        jPanel3.setBackground(new java.awt.Color(232, 251, 249));
        jPanel3.setLayout(null);

        fechaHoy.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        fechaHoy.setText("Fecha hoy");
        jPanel3.add(fechaHoy);
        fechaHoy.setBounds(20, 10, 90, 17);

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 10, 120, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/imagen 3.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1320, 670));

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/menu.png"))); // NOI18N
        jMenu1.setText("Menú");

        menu_MenuPrincipal.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        menu_MenuPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        menu_MenuPrincipal.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        menu_MenuPrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/inicio.png"))); // NOI18N
        menu_MenuPrincipal.setText("Menu Principal");
        menu_MenuPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_MenuPrincipalActionPerformed(evt);
            }
        });
        jMenu1.add(menu_MenuPrincipal);

        menu_desbloquearUsuario.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        menu_desbloquearUsuario.setBackground(new java.awt.Color(255, 255, 255));
        menu_desbloquearUsuario.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        menu_desbloquearUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/boton__UsuarioDesbloqueado2.png"))); // NOI18N
        menu_desbloquearUsuario.setText("Desbloquear Usuario");
        menu_desbloquearUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_desbloquearUsuarioActionPerformed(evt);
            }
        });
        jMenu1.add(menu_desbloquearUsuario);

        menu_Campus.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        menu_Campus.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        menu_Campus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/boton_campus.png"))); // NOI18N
        menu_Campus.setText("Administrar Campus");
        menu_Campus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_CampusActionPerformed(evt);
            }
        });
        jMenu1.add(menu_Campus);

        menu_tipoUsuario.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_MASK));
        menu_tipoUsuario.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        menu_tipoUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/boton_TipoUsuario.png"))); // NOI18N
        menu_tipoUsuario.setText("Administrar Tipo de Usuario");
        menu_tipoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_tipoUsuarioActionPerformed(evt);
            }
        });
        jMenu1.add(menu_tipoUsuario);

        menu_Imprimir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        menu_Imprimir.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        menu_Imprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/print-printer-tool-with-printed-paper-outlined-symbol_icon-icons.com_57772.png"))); // NOI18N
        menu_Imprimir.setText("Imprimir");
        menu_Imprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_ImprimirActionPerformed(evt);
            }
        });
        jMenu1.add(menu_Imprimir);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void chb_mostrarContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chb_mostrarContraseñaActionPerformed
          if(chb_mostrarContraseña.isSelected()){
            pwd_contraseña.setEchoChar((char)0);
        }
        else{
            pwd_contraseña.setEchoChar('*');
        }
    }//GEN-LAST:event_chb_mostrarContraseñaActionPerformed

    private void pwd_contraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pwd_contraseñaActionPerformed
  
    }//GEN-LAST:event_pwd_contraseñaActionPerformed

    private void cbo_tipoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_tipoUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbo_tipoUsuarioActionPerformed

    public boolean existeUsuario(){
        try {
            Statement st = con.createStatement();
            String sql = "Select nombre_usuario from Acceso where nombre_usuario = '"+txt_NombreUsuario.getText()+"'";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                JOptionPane.showMessageDialog(null, "Ya existe el nombre de usuario: "+txt_NombreUsuario.getText()+" ", "Nombre de usuario ¡Ya existe!", JOptionPane.INFORMATION_MESSAGE);
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
    
    public boolean existeEmpleado(){
        try {
            Statement st = con.createStatement();
            String sql = "Select numero_identidad from Empleados where numero_identidad = '"+txt_Identidad.getText()+"'";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                JOptionPane.showMessageDialog(null, "El número de identidad: "+txt_Identidad.getText()+" ya existe", "Número de identidad ¡Ya existe!", JOptionPane.INFORMATION_MESSAGE);
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

    public boolean validarContraseñas(String contraseña){
        if(contraseña.length() > 7){
             if(politicasContraseña(contraseña)){
                 return true;
             }
             else{
                 JOptionPane.showMessageDialog(null, "La contraseña no cumple las siguientes directrices: \n 1. Debe contener al menos una letra minúscula (a-z)"
                         + "\n 2. Debe contener al menos una letra mayúscula (A-Z) \n 3. Debe contener al menos un número (0-9)", "¡Directrices de contraseña no cumplidas!", JOptionPane.ERROR_MESSAGE);
                 return false;
             }
        }
        else{
            JOptionPane.showMessageDialog(null, "La contraseña es muy pequeña debe ser de al menos 8 caracteres.", "Longitud de contraseña menor al requerido", JOptionPane.ERROR_MESSAGE); 
           return false;
        }    
    }
    
     public boolean validarSalario(String salario){
           String salario2; 
          //  salario2=txt_Salario.toString().substring(0,1)
        if(salario.length() < 10){
             if(!"0".equals(salario.substring(0,1))){
                 return true;
             }
             else{
                 JOptionPane.showMessageDialog(null, "El campo salario no puede comenzar con 0 ", "Error en campo salario", JOptionPane.ERROR_MESSAGE);
                 return false;
             }
        }
        else{
            
           return false; 
        }    
    }
     
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
    
    
    
    public boolean politicasContraseña(String contraseña){
        boolean tieneNumero = false; 
        boolean tieneMayusculas = false; 
        boolean tieneMinusculas = false;
        char c;
        
        for(int i=0; i<contraseña.length();i++){
            
            c = contraseña.charAt(i);
            if(Character.isDigit(c)){
                tieneNumero = true;
            }
            else if(Character.isUpperCase(c)){
                tieneMayusculas = true;
            }
            else if(Character.isLowerCase(c)){
                tieneMinusculas = true;
            }
            if(tieneNumero && tieneMayusculas && tieneMinusculas){
                return true;
            }
        }
        return false;
    }
    
    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
      try{
      String nombreEmpleado = "";
      String tipoUsuario = "";
      try{
        String cadena1, cadena2, cadena3, cadena4, cadena5, cadena6, cadena7, cadena8, cadena9;
        cadena1 = txt_Nombre.getText();
        cadena2 = txt_Apellido.getText();
        cadena3 = txt_Salario.getText();
        cadena4 = txt_Telefono.getText();
        cadena5 = txt_Identidad.getText();
        cadena6 = cbo_idCampus.getSelectedItem().toString();
        String id_campus = cbo_idCampus.getSelectedItem().toString().substring(0, 4);
        cadena8 = txt_NombreUsuario.getText();
        cadena9 = pwd_contraseña.getText();
        tipoUsuario = cbo_tipoUsuario.getSelectedItem().toString().substring(0,1);
        nombreEmpleado = txt_Nombre.getText() + " " + txt_Apellido.getText();
        
         if((txt_Nombre.getText().equals(""))){
            javax.swing.JOptionPane.showMessageDialog(this,"Debe ingresar los nombres del empleado.","Nombres del empleado requeridos",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            txt_Nombre.requestFocus();
            return;
        }
         
         if((txt_Apellido.getText().equals(""))){
             javax.swing.JOptionPane.showMessageDialog(this,"Debe ingresar los apellidos del empleado.","Apellidos del empleado requeridos",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            txt_Apellido.requestFocus();
            return;
        }
         
          if((txt_Salario.getText().equals(""))){
             javax.swing.JOptionPane.showMessageDialog(this,"Debe ingresar el salario del empleado.","Salario del empleado requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            txt_Salario.requestFocus();
            return;
        }
          
         if((txt_Telefono.getText().equals(""))){
             javax.swing.JOptionPane.showMessageDialog(this,"Debe ingresar el teléfono del empleado.","Teléfono del empleado requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            txt_Telefono.requestFocus();
            return;
        }
         
         if((txt_Identidad.getText().equals(""))){
            javax.swing.JOptionPane.showMessageDialog(this,"Debe ingresar el número de identidad del empleado.","Número de identidad del empleado requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            txt_Identidad.requestFocus();
            return;
         }
         
          if((txt_NombreUsuario.getText().equals(""))){
            javax.swing.JOptionPane.showMessageDialog(this,"Debe ingresar el nombre de usuario del empleado.","Nombre  de usuario del empleado requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            txt_NombreUsuario.requestFocus();
            return;
         }
        
          if((pwd_contraseña.getText().equals(""))){
            javax.swing.JOptionPane.showMessageDialog(this,"Debe ingresar la contraseña del usuario del empleado.","Contraseña de usuario del empleado requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            pwd_contraseña.requestFocus();
            return;
         }
          
           if((cbo_idCampus.getSelectedItem().equals("Seleccione un campus"))){
            javax.swing.JOptionPane.showMessageDialog(this,"Debe seleccionar un campus para el empleado","Campus del empleado requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }
           
            if((cbo_tipoUsuario.getSelectedItem().equals("Seleccione un tipo usuario"))){
            javax.swing.JOptionPane.showMessageDialog(this,"Debe seleccionar un tipo de usuario para el empleado","Tipo de usuario del empleado requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }
       
        
        if(existeEmpleado()){
            return;
        }
        
        if(existeUsuario()){
            return;
        }
        
       
        if(!validarSalario(txt_Salario.getText())){
            return;
        }
        
        if(!validarLongitudTelefono(txt_Telefono,8)){
            return;
        }
        
        
        
        if(!validarIdentidad(txt_Identidad.getText())){
            return;
            
        }
        
        
        if(!validarLongitud(txt_Nombre,5)){
            JOptionPane.showMessageDialog(null, "Los nombres ingresados son muy pequeños el mínimo es de 5 caracteres", "Longitud de los nombres", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
         if(!validarLongitud(txt_Apellido,5)){
            JOptionPane.showMessageDialog(null, "Los apellidos ingresados son muy pequeños el mínimo es de 5 caracteres", "Longitud de los apellidos", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
         
         if(!validarLongitud(txt_Salario,4)){
             
            JOptionPane.showMessageDialog(null, "El salario debe ser de mínimo 4 dígitos", "Longitud del salario", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
         
         
         
          if(!validarLongitud(txt_NombreUsuario,8)){
            JOptionPane.showMessageDialog(null, "El nombre de usuario debe ser de mínimo 8 caracteres", "Longitud del nombre de usuario", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        if(!validarContraseñas(cadena9)){
            return;
        }
        
          PreparedStatement ps;
          ResultSet rs;
        
          ps=con.prepareStatement("INSERT INTO Empleados (nombres_empleado, apellido_empleado, telefono_empleado, id_campus, salario, numero_identidad)"
                  + "                VALUES(?,?,?,?,?,?)");
                  ps.setString(1, txt_Nombre.getText());
                  ps.setString(2, txt_Apellido.getText());
                  ps.setString(3, txt_Telefono.getText());
                  ps.setString(4, id_campus);
                  ps.setString(5, txt_Salario.getText());
                  ps.setString(6, txt_Identidad.getText());
                  int res= ps.executeUpdate();
      } catch ( Exception e) {
            try {
                Log myLog; 
                String nombreArchivo = "src\\Logs\\Empleado " + fecha + ".txt";
                myLog = new Log(nombreArchivo);
                myLog.logger.setLevel(Level.SEVERE);
                myLog.logger.severe(e.getMessage() + " La causa fue: " + e.getCause());
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }  
        }
         try{
             Statement st2=con.createStatement();
            String contraseña=DigestUtils.md5Hex(pwd_contraseña.getText());
            String estadoDelUsuario = "";
            if(cbo_tipoUsuario.getSelectedItem().toString().substring(0,1).equals("A")){
                estadoDelUsuario = "Administrador";
            }
            else{
                 estadoDelUsuario = "Activo";
            }
            
            String sql ="Insert into Acceso(nombre_usuario,clave_acceso,id_tipoUsuario,estado,intentos) values('"+txt_NombreUsuario.getText()+"','"+contraseña+"','"+tipoUsuario+"','"+estadoDelUsuario+"',0)";
            int rs2 = st2.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Se ha guardado la informacion del empleado "+nombreEmpleado+" correctamente");
          }catch ( Exception e) {
          try {
                Log myLog; 
                String nombreArchivo = "src\\Logs\\Empleado " + fecha + ".txt";
                myLog = new Log(nombreArchivo);
                myLog.logger.setLevel(Level.SEVERE);
                myLog.logger.severe(e.getMessage() + " La causa fue: " + e.getCause());
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        limpiar();
        actualizarDatos();
      }
      catch(Exception e){
          try {
                Log myLog; 
                String nombreArchivo = "src\\Logs\\Empleado " + fecha + ".txt";
                myLog = new Log(nombreArchivo);
                myLog.logger.setLevel(Level.SEVERE);
                myLog.logger.severe(e.getMessage() + " La causa fue: " + e.getCause());
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
      }
    }//GEN-LAST:event_btn_guardarActionPerformed

    private boolean validarLongitud(JTextField texto, int longitud){
       if(texto.getText().length() >= longitud){
           return true;
       }
       else{
           return false;
       }
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
       JOptionPane.showMessageDialog(null, "El número de teléfono debe ser de 8 dígitos", "Longitud del número de telefono",JOptionPane.INFORMATION_MESSAGE);
       return false;
    }
    
    private boolean validarLongitudSalario(JTextField texto, int longitud){
       if(texto.getText().length() == longitud){
                Pattern pattern = Pattern.compile("[123456789]");
                Matcher matcher=pattern.matcher(texto.getText().substring(0,1));
                if(matcher.matches()){ 
                        return true;
                    }else{
                        JOptionPane.showMessageDialog(null, "El salario no puede comenzar con 0");
                        return false;
                    } 
       }
        else{
       }
       JOptionPane.showMessageDialog(null, "El salario debe ser de mínimo 4 dígitos", "Longitud del salario", JOptionPane.INFORMATION_MESSAGE);
       return false;
    }
  
    private void txt_NombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_NombreKeyTyped
       char a=evt.getKeyChar();
   
            if (evt.getKeyChar() == 8 || evt.getKeyChar() == 127 || 
                 evt.getKeyChar() == 0 || evt.getKeyChar() == 3 || evt.getKeyChar() == 22 
                 || evt.getKeyChar() == 26 || evt.getKeyChar() == 24) {
        return;
        }
         if(evt.getKeyChar() == 32){
             if(txt_Nombre.getText().length() == 0){
                 evt.consume();
                 Toolkit.getDefaultToolkit().beep();
                 return;
             }
             if(txt_Nombre.getText().substring(txt_Nombre.getText().length() - 1).equals(" ")){
                 evt.consume();
                 Toolkit.getDefaultToolkit().beep();
             }
             return; 
         }
        if(txt_Nombre.getText().length() >=40){
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Número máximo de caracteres admitidos");
        }
        
        if(Character.isDigit(a) || !Character.isLetterOrDigit(a) ){
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Sólo letras");
        }
    }//GEN-LAST:event_txt_NombreKeyTyped

    private void txt_ApellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_ApellidoKeyTyped
        char a=evt.getKeyChar();
            if (evt.getKeyChar() == 8 || evt.getKeyChar() == 127 || 
                 evt.getKeyChar() == 0 || evt.getKeyChar() == 3 || evt.getKeyChar() == 22 
                 || evt.getKeyChar() == 26 || evt.getKeyChar() == 24) {
        return;
        }
        if(evt.getKeyChar() == 32){
             if(txt_Apellido.getText().length() == 0){
                 evt.consume();
                 Toolkit.getDefaultToolkit().beep();
                 return;
             }
             if(txt_Apellido.getText().substring(txt_Apellido.getText().length() - 1).equals(" ")){
                 evt.consume();
                 Toolkit.getDefaultToolkit().beep();
             }
             return; 
         }
            
            
        if(txt_Apellido.getText().length() >=40){
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Número máximo de caracteres admitidos");
        }
 
        if(Character.isDigit(a) || !Character.isLetterOrDigit(a)){
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Sólo letras");
        }
    }//GEN-LAST:event_txt_ApellidoKeyTyped

    private void txt_TelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_TelefonoKeyTyped
        char a=evt.getKeyChar();
            if (evt.getKeyChar() == 8 || evt.getKeyChar() == 127 || 
                 evt.getKeyChar() == 0 || evt.getKeyChar() == 3 || evt.getKeyChar() == 22 
                 || evt.getKeyChar() == 26 || evt.getKeyChar() == 24) {
        return;
        }
        if(txt_Telefono.getText().length() >=8){
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Número máximo de dígitos admitidos");
        }
     
        if(Character.isLetter(a) || !Character.isLetterOrDigit(a)){
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Sólo números");
        }
    }//GEN-LAST:event_txt_TelefonoKeyTyped

    private void txt_NombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_NombreActionPerformed
        
    }//GEN-LAST:event_txt_NombreActionPerformed

    private void btn_consultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_consultarActionPerformed
        try{
        actualizarDatos();
        }
        catch(Exception e){
             try {
                Log myLog; 
                String nombreArchivo = "src\\Logs\\Empleado " + fecha + ".txt";
                myLog = new Log(nombreArchivo);
                myLog.logger.setLevel(Level.SEVERE);
                myLog.logger.severe(e.getMessage() + " La causa fue: " + e.getCause());
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btn_consultarActionPerformed

    public void actualizarDatos(){
        try {
               String sql = "select * from Empleados as e join Acceso as a on e.id_empleado = a.id_empleado join\n" +
"                Campus as c on c.id_campus = e.id_campus join \n" +
"               Tipo_Usuarios as t on a.id_tipoUsuario =  t.id_tipoUsuario";
               stmt = con.createStatement();
               ResultSet rs = stmt.executeQuery(sql);
               
               modelo = new DefaultTableModel(null,titulos);
               Tabla_Empleados.setModel(modelo);
               Locale locale = new Locale("es", "HN");      
               NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
               NumberFormat formatter = NumberFormat.getCurrencyInstance();
                 while(rs.next()) {
                      String []datos= new String[9];
                      datos[0] =rs.getString("id_empleado");
                      datos[1] =rs.getString("nombres_empleado");
                      datos[2] =rs.getString("apellido_empleado");
                      datos[3] =currencyFormatter.format(rs.getDouble("salario"));
                      datos[4] =rs.getString("telefono_empleado");
                      datos[5] =rs.getString("numero_identidad");
                      datos[6] =rs.getString("id_campus") + " - " + rs.getString("nombre_campus");
                      datos[7] =rs.getString("nombre_usuario");
                      datos[8] = rs.getString("Tipo_Usuario");
                      lbl_numeroIdentidad.setText("numero_identidad");
                      lbl_nombreU.setText("nombre_usuario");
                     // datos[8] =rs.getString(10);
                      modelo.addRow(datos);
                      
                      centrar_datos();
               }
                TableColumn idE = Tabla_Empleados.getColumn(titulos[0]);
                idE.setMaxWidth(125);
                idE.setIdentifier(ICONIFIED);
                TableColumn cn = Tabla_Empleados.getColumn(titulos[1]);
                cn.setMaxWidth(165);
                TableColumn ca = Tabla_Empleados.getColumn(titulos[2]);
                ca.setMaxWidth(165);
                TableColumn cs = Tabla_Empleados.getColumn(titulos[3]);
                cs.setMaxWidth(75);
                TableColumn ct = Tabla_Empleados.getColumn(titulos[4]);
                ct.setMaxWidth(90);
                TableColumn cid = Tabla_Empleados.getColumn(titulos[5]);
                cid.setMaxWidth(170);
                TableColumn cnomu = Tabla_Empleados.getColumn(titulos[6]);
                cnomu.setMaxWidth(165);
                TableColumn cidc = Tabla_Empleados.getColumn(titulos[7]);
                cidc.setMaxWidth(150);
                TableColumn ctipou = Tabla_Empleados.getColumn(titulos[8]);
                ctipou.setMaxWidth(95);
        }
        catch (Exception e) {
             try {
                Log myLog; 
                String nombreArchivo = "src\\Logs\\Empleado " + fecha + ".txt";
                myLog = new Log(nombreArchivo);
                myLog.logger.setLevel(Level.SEVERE);
                myLog.logger.severe(e.getMessage() + " La causa fue: " + e.getCause());
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void centrar_datos(){
 
        DefaultTableCellRenderer modelocentrar = new DefaultTableCellRenderer();
        modelocentrar.setHorizontalAlignment(SwingConstants.CENTER);
        Tabla_Empleados.getColumnModel().getColumn(2).setCellRenderer(modelocentrar);
    }
    private void menu_MenuPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_MenuPrincipalActionPerformed

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
        } catch (SQLException e) {
            try {
                Log myLog; 
                String nombreArchivo = "src\\Logs\\Empleado " + fecha + ".txt";
                myLog = new Log(nombreArchivo);
                myLog.logger.setLevel(Level.SEVERE);
                myLog.logger.severe(e.getMessage() + " La causa fue: " + e.getCause());
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_menu_MenuPrincipalActionPerformed

    private void cbo_idCampusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_idCampusActionPerformed

    }//GEN-LAST:event_cbo_idCampusActionPerformed

    int filas;
    
    private void btn_ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ActualizarActionPerformed
        try{
        String nombreEmpleado = txt_Nombre.getText() + " " + txt_Apellido.getText();
        
        if(JOptionPane.showConfirmDialog(null,"¿Está seguro que desea actualizar el registro del empleado "+nombreEmpleado+"?","Confirmación de actualización",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE
        )==JOptionPane.YES_OPTION){ 
     String id_campus = cbo_idCampus.getSelectedItem().toString().substring(0, 4);
     String tipoUsuario = cbo_tipoUsuario.getSelectedItem().toString().substring(0,1);
     String contraseña=DigestUtils.md5Hex(pwd_contraseña.getText());
     String contraseña2 = pwd_contraseña.getText();
     String identidad = txt_Identidad.getText();
     
      if((txt_Nombre.getText().equals(""))){
            javax.swing.JOptionPane.showMessageDialog(this,"Debe ingresar los nombres del empleado.","Nombres del empleado requeridos",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            txt_Nombre.requestFocus();
            return;
        }
         
         if((txt_Apellido.getText().equals(""))){
             javax.swing.JOptionPane.showMessageDialog(this,"Debe ingresar los apellidos del empleado.","Apellidos del empleado requeridos",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            txt_Apellido.requestFocus();
            return;
        }
         
          if((txt_Salario.getText().equals(""))){
             javax.swing.JOptionPane.showMessageDialog(this,"Debe ingresar el salario del empleado.","Salario del empleado requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            txt_Salario.requestFocus();
            return;
        }
          
         if((txt_Telefono.getText().equals(""))){
             javax.swing.JOptionPane.showMessageDialog(this,"Debe ingresar el teléfono del empleado.","Teléfono del empleado requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            txt_Telefono.requestFocus();
            return;
        }
         
         if((txt_Identidad.getText().equals(""))){
            javax.swing.JOptionPane.showMessageDialog(this,"Debe ingresar el número de identidad del empleadoo.","Número de identidad del empleado requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            txt_Identidad.requestFocus();
            return;
         }
         
          if((txt_NombreUsuario.getText().equals(""))){
            javax.swing.JOptionPane.showMessageDialog(this,"Debe ingresar el nombre de usuario del empleadoo.","Nombre  de usuario del empleado requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            txt_NombreUsuario.requestFocus();
            return;
         }
        
  
          
           if((cbo_idCampus.getSelectedItem().equals("Seleccione un campus"))){
            javax.swing.JOptionPane.showMessageDialog(this,"Debe seleccionar un campus para el empleado","Campus del empleado requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }
           
            if((cbo_tipoUsuario.getSelectedItem().equals("Seleccione un tipo usuario"))){
            javax.swing.JOptionPane.showMessageDialog(this,"Debe seleccionar un tipo de usuario para el empleado","Tipo de usuario del empleado requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }
     
        if(!pwd_contraseña.getText().equals("")){
            if(!validarContraseñas(contraseña2)){
            return;
            }
        }
        
       if(!validarSalario(txt_Salario.getText())){
            return;
        }
       if(!validarIdentidad(txt_Identidad.getText())){
            return;
            
        }
       
      try{
          Statement ps = con.createStatement();
          String cons = "Update Empleados "
                  + "set nombres_empleado = '"+txt_Nombre.getText()+"',"
                  + "apellido_empleado =  '"+txt_Apellido.getText()+"', "
                  + "telefono_empleado = '"+txt_Telefono.getText()+"', "
                  + "id_campus = '"+id_campus+"', "
                  + "salario = '"+txt_Salario.getText()+"', "
                  + "numero_identidad = '"+txt_Identidad.getText()+"'"
                  + "where numero_identidad = '"+lbl_numeroIdentidad.getText()+"'";
          int re = ps.executeUpdate(cons);
        } catch ( Exception e) {
            System.out.println(e);
        }
         try{
             if(contraseña2.equals("")){
              Statement st2=con.createStatement();
            
              String sql ="Update Acceso "
                      + "set nombre_usuario = '"+txt_NombreUsuario.getText()+"'"
                      + ",id_tipoUsuario= '"+tipoUsuario+"'"
                      + "where id_empleado = (Select id_empleado from Acceso where nombre_usuario = '"+lbl_nombreU.getText()+"')";
               int rs2 = st2.executeUpdate(sql);
              JOptionPane.showMessageDialog(null, "Se ha actualizado la información del empleado "+nombreEmpleado+" correctamente.");
              this.btn_guardar.setEnabled(true);
              this.btn_Actualizar.setEnabled(false);
              this.btn_Eliminar.setEnabled(false);
              limpiar();
              actualizarDatos();
              return;
             }
             
             Statement st2=con.createStatement();
            
              String sql ="Update Acceso "
                      + "set nombre_usuario = '"+txt_NombreUsuario.getText()+"'"
                      + ",clave_acceso = '"+contraseña+"',"
                      + "id_tipoUsuario= '"+tipoUsuario+"'"
                      + "where id_empleado = (Select id_empleado from Acceso where nombre_usuario = '"+lbl_nombreU.getText()+"')";
               int rs2 = st2.executeUpdate(sql);
              JOptionPane.showMessageDialog(null, "Se ha actualizado la información del empleado "+nombreEmpleado+" correctamente.");
              this.btn_guardar.setEnabled(true);
              this.btn_Actualizar.setEnabled(false);
              this.btn_Eliminar.setEnabled(false);
          }catch ( Exception e) {
           try {
                Log myLog; 
                String nombreArchivo = "src\\Logs\\Empleado " + fecha + ".txt";
                myLog = new Log(nombreArchivo);
                myLog.logger.setLevel(Level.SEVERE);
                myLog.logger.severe(e.getMessage() + " La causa fue: " + e.getCause());
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
         }
        limpiar();
        actualizarDatos();
        }
        catch ( Exception e){
           try {
                Log myLog; 
                String nombreArchivo = "src\\Logs\\Empleado " + fecha + ".txt";
                myLog = new Log(nombreArchivo);
                myLog.logger.setLevel(Level.SEVERE);
                myLog.logger.severe(e.getMessage() + " La causa fue: " + e.getCause());
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btn_ActualizarActionPerformed

    public void rellenar(){
        try {
            Statement st = con.createStatement();
            String consulta = "Select id_tipoUsuario from Tipo_Usuarios\n" +
                              "where id_tipoUsuario = (Select id_tipoUsuario from Acceso where nombre_usuario ='"+lbl_usuario.getText()+"')";
            ResultSet rs = st.executeQuery(consulta);           
            if(rs.next()){
                if(rs.getString("id_tipoUsuario").equals("A") || rs.getString("id_tipoUsuario").equals("S")){
                    try{
                    String cap="";
                    ResultSet rs2 = null;
                    var = JOptionPane.showInputDialog(this,"Ingrese los nombres, los apellidos o el número de identidad del empleado que desea consultar","Consulta de empleado",JOptionPane.QUESTION_MESSAGE);
                    if(var == null)
                        JOptionPane.showMessageDialog(this,"La acción fue cancelada","¡AVISO!",JOptionPane.INFORMATION_MESSAGE);
                    else {
                        if (var.equals("")) {
                            JOptionPane.showMessageDialog(this,"Favor de ingresar los datos del empleado\n que desea consultar","¡AVISO!",JOptionPane.INFORMATION_MESSAGE);
                        }
                        else{
                            String sql = "select * from Empleados as e join Acceso as a on e.id_empleado = a.id_empleado join\n" +
"               Campus as c on c.id_campus = e.id_campus join \n" +
"               Tipo_Usuarios as t on a.id_tipoUsuario =  t.id_tipoUsuario where numero_identidad = '"+var+"' or nombres_empleado = '"+var+"' or apellido_empleado = '"+var+"'";
                            stmt = con.createStatement();
                            rs2 = stmt.executeQuery(sql);
                        
                            if(rs2.next()) {
                                Locale locale = new Locale("es", "HN"); 
                                NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
                                txt_Nombre.setText(rs2.getString("nombres_empleado"));
                                txt_Apellido.setText(rs2.getString("apellido_empleado"));
                                txt_Salario.setText(currencyFormatter.format(rs2.getDouble("salario")).toString().substring(1));
                                txt_Telefono.setText(rs2.getString("telefono_empleado"));
                                txt_Identidad.setText(rs2.getString("numero_identidad"));
                                cbo_idCampus.setSelectedItem((rs2.getString("id_campus") + " - " + rs2.getString("nombre_campus")));
                                txt_NombreUsuario.setText(rs2.getString("nombre_usuario"));
                                cbo_tipoUsuario.setSelectedItem(rs2.getString("Tipo_Usuario")); 
                                lbl_numeroIdentidad.setText(rs2.getString("numero_identidad"));
                                lbl_nombreU.setText(rs2.getString("nombre_usuario"));
                                this.btn_Actualizar.setEnabled(true);
                                this.btn_Eliminar.setEnabled(true);
                            }
                            else{
                               JOptionPane.showMessageDialog(null,"¡No se encuentra el empleado! Por favor verifique sí, lo escribio correctamente");
                            }
                            
                        }
                        
                    }
                    }catch (Exception e) {
                       try {
                                Log myLog; 
                                String nombreArchivo = "src\\Logs\\Empleado " + fecha + ".txt";
                                myLog = new Log(nombreArchivo);
                                myLog.logger.setLevel(Level.SEVERE);
                                myLog.logger.severe(e.getMessage() + " La causa fue: " + e.getCause());
                            } catch (IOException ex) {
                                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            }
                }
                
                
            }
             else{
                            JOptionPane.showMessageDialog(null,"¡Sólo los administradores tienen acceso a esta función!");
                            }
                
            
        } catch (SQLException e) {
            try {
                Log myLog; 
                myLog = new Log("src\\Logs\\Empleado.txt");
                myLog.logger.setLevel(Level.SEVERE);
                myLog.logger.severe(e.getMessage() + " La causa fue: " + e.getCause());
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    private void txt_IdentidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_IdentidadKeyTyped
        char a=evt.getKeyChar();
            if (evt.getKeyChar() == 8 || evt.getKeyChar() == 127 || 
                 evt.getKeyChar() == 0 || evt.getKeyChar() == 3 || evt.getKeyChar() == 22 
                 || evt.getKeyChar() == 26 || evt.getKeyChar() == 24) {
        return;
        }
        if(txt_Identidad.getText().length() >=13){
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Número máximo de dígitos admitidos");
        }
        if(Character.isLetter(a) || !Character.isLetterOrDigit(a)){
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Solo números");
        }
    }//GEN-LAST:event_txt_IdentidadKeyTyped

    private void llenarCampos(){
        int i = Tabla_Empleados.getSelectedRow();
        txt_Nombre.setText(Tabla_Empleados.getValueAt(i, 1).toString());
        txt_Apellido.setText(Tabla_Empleados.getValueAt(i, 2).toString());
        txt_Salario.setText(Tabla_Empleados.getValueAt(i, 3).toString().substring(1));
        txt_Telefono.setText(Tabla_Empleados.getValueAt(i, 4).toString());
        txt_Identidad.setText(Tabla_Empleados.getValueAt(i, 5).toString());
        txt_NombreUsuario.setText(Tabla_Empleados.getValueAt(i, 7).toString());
        cbo_idCampus.setSelectedItem(Tabla_Empleados.getValueAt(i, 6).toString());
        cbo_tipoUsuario.setSelectedItem(Tabla_Empleados.getValueAt(i, 8).toString());
        lbl_numeroIdentidad.setText(Tabla_Empleados.getValueAt(i, 5).toString());
        lbl_nombreU.setText(Tabla_Empleados.getValueAt(i, 7).toString());
    }
    
    private void btn_EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_EliminarActionPerformed

        
    }//GEN-LAST:event_btn_EliminarActionPerformed

    
    
    private void btn_limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limpiarActionPerformed
        try{
        String nombreEmpleado = txt_Nombre.getText() + " " + txt_Apellido.getText();
           if(JOptionPane.showConfirmDialog(null,"¿Está seguro que desea eliminar el registro del empleado "+nombreEmpleado+"","Confirmación de eliminación",
                   JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE
            )==JOptionPane.YES_OPTION){   
     String id_campus = cbo_idCampus.getSelectedItem().toString().substring(0, 4);
       try{
             Statement st2=con.createStatement();
             Statement st3 = con.createStatement();
             String consulta = "Delete from Acceso_Pantallas where nombre_usuario ='"+lbl_nombreU.getText()+"'";
             int rs3 = st3.executeUpdate(consulta);
              String sql ="Delete from Acceso "
                      + "where id_empleado = (Select id_empleado from Acceso where nombre_usuario = '"+lbl_nombreU.getText()+"')";
               int rs2 = st2.executeUpdate(sql);
          }catch ( Exception e) {
           JOptionPane.showMessageDialog(null, e.getMessage()); 
        }
      try{
          PreparedStatement ps;
          ResultSet rs;
         Statement st=con.createStatement();
         String sql ="Delete from Empleados "
                      + "where numero_identidad = "+lbl_numeroIdentidad.getText()+"";
                  int res=st.executeUpdate(sql);
                  this.btn_guardar.setEnabled(true);
                  this.btn_Actualizar.setEnabled(false);
                  this.btn_Eliminar.setEnabled(false);
                  if(res > 0){ 
                      JOptionPane.showMessageDialog(null, "Se ha borrado la información del empleado "+nombreEmpleado+" correctamente"); 
                  }else {
                      JOptionPane.showMessageDialog(null, "¡Error al eliminar la información!"); 
                  }
      } catch ( Exception e) {
            System.out.println(e);
        }
         }
        limpiar();
        actualizarDatos();
        }
        catch(Exception e){
             try {
                Log myLog; 
                String nombreArchivo = "src\\Logs\\Empleado " + fecha + ".txt";
                myLog = new Log(nombreArchivo);
                myLog.logger.setLevel(Level.SEVERE);
                myLog.logger.severe(e.getMessage() + " La causa fue: " + e.getCause());
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btn_limpiarActionPerformed

    private void txt_IdentidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_IdentidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_IdentidadActionPerformed

    private void btn_Limpiarbtn_limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Limpiarbtn_limpiarActionPerformed

        limpiar();
        this.btn_guardar.setEnabled(true);
        this.btn_Actualizar.setEnabled(false);
        this.btn_Eliminar.setEnabled(false);

    }//GEN-LAST:event_btn_Limpiarbtn_limpiarActionPerformed

    private void btn_rellenarCamposMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_rellenarCamposMouseClicked
       try{
        rellenar();
       this.jScrollPane1.setEnabled(true);
       this.Tabla_Empleados.setEnabled(true);
       this.btn_guardar.setEnabled(false);
       }
       catch(Exception e){
           try {
                Log myLog; 
                String nombreArchivo = "src\\Logs\\Empleado " + fecha + ".txt";
                myLog = new Log(nombreArchivo);
                myLog.logger.setLevel(Level.SEVERE);
                myLog.logger.severe(e.getMessage() + " La causa fue: " + e.getCause());
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
       }
    }//GEN-LAST:event_btn_rellenarCamposMouseClicked

    private void limpiar(){
        txt_Nombre.setText(null);
        txt_Apellido.setText(null);
        txt_Salario.setText(null);
        txt_Telefono.setText(null);
        txt_Identidad.setText(null);
        txt_NombreUsuario.setText(null);
        pwd_contraseña.setText(null);
        cbo_idCampus.setSelectedIndex(0);
        cbo_tipoUsuario.setSelectedIndex(0);
        
    }
    private void txt_NombreUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_NombreUsuarioKeyTyped
       char a=evt.getKeyChar();
            if (evt.getKeyChar() == 8 || evt.getKeyChar() == 127 || 
                 evt.getKeyChar() == 0 || evt.getKeyChar() == 3 || evt.getKeyChar() == 22 
                 || evt.getKeyChar() == 46 || evt.getKeyChar() == 26 || evt.getKeyChar() == 24) {
        return;
        }
        
        if(txt_NombreUsuario.getText().length() >=25){
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Número máximo de caracteres admitidos");
        } 
        if(!Character.isLetterOrDigit(a) ){
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Sólo letras y numeros");
        }
    }//GEN-LAST:event_txt_NombreUsuarioKeyTyped

    private void pwd_contraseñaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pwd_contraseñaKeyTyped
       char a=evt.getKeyChar();
            if (evt.getKeyChar() == 8 || evt.getKeyChar() == 127 || 
                 evt.getKeyChar() == 0 || evt.getKeyChar() == 3 || evt.getKeyChar() == 22 
                 || evt.getKeyChar() == 26 || evt.getKeyChar() == 24) {
        return;
            }
            
        if(evt.getKeyChar() == 32 || evt.getKeyChar() == 124){
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
        if(pwd_contraseña.getText().length() >=25){
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Número máximo de caracteres admitidos");
        }
    }//GEN-LAST:event_pwd_contraseñaKeyTyped

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
  
           validarLongitudTelefono(txt_Telefono,8);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btn_rellenarCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_rellenarCamposActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_rellenarCamposActionPerformed

    private void Tabla_EmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tabla_EmpleadosMouseClicked
        if(Tabla_Empleados.getSelectedRow() >= 0){
            llenarCampos();
            this.btn_Actualizar.setEnabled(true);
            this.btn_Eliminar.setEnabled(true);
            this.btn_guardar.setEnabled(false);
        }
    }//GEN-LAST:event_Tabla_EmpleadosMouseClicked

    private void txt_TelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_TelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_TelefonoActionPerformed

    private void txt_NombreUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_NombreUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_NombreUsuarioActionPerformed

    private void menu_desbloquearUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_desbloquearUsuarioActionPerformed
        try{ 
        var = JOptionPane.showInputDialog(this,"Ingrese el nombre de usuario del empleado que desea desbloquar","Desbloqueo de usuarios",JOptionPane.QUESTION_MESSAGE);
            if(var == null){
                JOptionPane.showMessageDialog(this,"La acción fue cancelada","¡AVISO!",JOptionPane.INFORMATION_MESSAGE);
            }
                else if (var.equals("")) {
                        JOptionPane.showMessageDialog(this,"¡Por favor ingrese el nombre de usuario que desea desbloquear!","¡AVISO!",JOptionPane.INFORMATION_MESSAGE);
                                    }
                else{
                    try {
                        String consulta = "Select * from Acceso where nombre_usuario = '"+var+"'";
                        Statement st3 = con.createStatement();
                        ResultSet rs3 = st3.executeQuery(consulta);
                        if(rs3.next()){
                            if(rs3.getString("id_tipoUsuario").equals("A")){
                                 JOptionPane.showMessageDialog(this,"El usuario "+var+" es una cuenta de administración.");
                                return;
                            }
                            if(!rs3.getString("estado").equals("Bloqueado")){
                                JOptionPane.showMessageDialog(this,"El usuario "+var+" no se encuentra bloqueado.");
                                return;
                            }
                            
                        }
                        String sql = "update Acceso \n" +
                                     "set estado ='Activo',\n" +
                                     "intentos = 0"
                                     +"where nombre_usuario ='"+var+"'";
                    stmt = con.createStatement();
                    int rs = stmt.executeUpdate(sql);
                    if(rs >0){
                        JOptionPane.showMessageDialog(null,"Se ha desbloqueado exitosamente al usuario: "+var+"","Usuario desbloquedo satisfactoriamente",JOptionPane.INFORMATION_MESSAGE);
                    }
                    else{
                               JOptionPane.showMessageDialog(null,"¡No se encuentra el nombre de usuario! Por favor verifique sí, lo escribió correctamente","Nombre de usuario no encontrado",JOptionPane.ERROR_MESSAGE);
                            }
                    } catch (SQLException ex) {
                        Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
        }
        catch(Exception e){
             try {
                Log myLog; 
                String nombreArchivo = "src\\Logs\\Empleado " + fecha + ".txt";
                myLog = new Log(nombreArchivo);
                myLog.logger.setLevel(Level.SEVERE);
                myLog.logger.severe(e.getMessage() + " La causa fue: " + e.getCause());
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_menu_desbloquearUsuarioActionPerformed

    private void menu_CampusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_CampusActionPerformed
         Campus campus = null;
        try {
            campus = new Campus(lbl_usuario.getText());
        } catch (SQLException e) {
           try {
                Log myLog; 
                String nombreArchivo = "src\\Logs\\Empleado " + fecha + ".txt";
                myLog = new Log(nombreArchivo);
                myLog.logger.setLevel(Level.SEVERE);
                myLog.logger.severe(e.getMessage() + " La causa fue: " + e.getCause());
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        campus.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menu_CampusActionPerformed

    private void menu_tipoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_tipoUsuarioActionPerformed
        TipoUsuario tipoEmpleado = null;
        try {
            tipoEmpleado = new TipoUsuario(lbl_usuario.getText());
        } catch (SQLException e) {
            try {
                Log myLog; 
                String nombreArchivo = "src\\Logs\\Empleado " + fecha + ".txt";
                myLog = new Log(nombreArchivo);
                myLog.logger.setLevel(Level.SEVERE);
                myLog.logger.severe(e.getMessage() + " La causa fue: " + e.getCause());
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        tipoEmpleado.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menu_tipoUsuarioActionPerformed

    private void txt_SalarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_SalarioKeyTyped
char a=evt.getKeyChar();
        if (evt.getKeyChar() == 8 || evt.getKeyChar() == 127 ||
            evt.getKeyChar() == 0 || evt.getKeyChar() == 3 || evt.getKeyChar() == 22
            || evt.getKeyChar() == 26 || evt.getKeyChar() == 24 || evt.getKeyChar() == 46 || evt.getKeyChar() == 44) {
            return;
        }

        if(txt_Salario.getText().length() >=10){
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Número máximo de dígitos admitidos");
        }
        if(Character.isLetter(a) || !Character.isLetterOrDigit(a)){
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Sólo numeros");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_SalarioKeyTyped

    
    private void menu_ImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_ImprimirActionPerformed
      try {
            JasperReport reporte = null;
            String path = "src\\reportes\\Empleados.jasper";
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("nombreUsuario",lbl_usuario.getText());
            reporte = (JasperReport) JRLoader.loadObjectFromFile(path);
            JasperPrint jprint;
            jprint=JasperFillManager.fillReport(reporte,parameters,con);
            JasperViewer view = new JasperViewer(jprint,false);
            final JRViewer viewer = new JRViewer(jprint);
            JRSaveContributor[] contrbs = viewer.getSaveContributors();

            for (JRSaveContributor saveContributor : contrbs)
            {
                if (!(saveContributor instanceof net.sf.jasperreports.view.save.JRDocxSaveContributor || 
                        saveContributor instanceof net.sf.jasperreports.view.save.JRSingleSheetXlsSaveContributor 
                        || saveContributor instanceof net.sf.jasperreports.view.save.JRPdfSaveContributor))
                    viewer.removeSaveContributor(saveContributor);
            }
            view.setContentPane(viewer);
            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            view.setVisible(true);
             } catch (Exception e) {
              
            try {
                Log myLog;
                String nombreArchivo = "src\\Logs\\Empleado " + fecha + ".txt";
                myLog = new Log(nombreArchivo);
                myLog.logger.setLevel(Level.SEVERE);
                myLog.logger.severe(e.getMessage() + " La causa fue: " + e.getCause());
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
                 
        }   
        // TODO add your handling code here:
    }//GEN-LAST:event_menu_ImprimirActionPerformed

   
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
            java.util.logging.Logger.getLogger(Empleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Empleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Empleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Empleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Empleado().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tabla_Empleados;
    private javax.swing.JButton btn_Actualizar;
    private javax.swing.JButton btn_Eliminar;
    private javax.swing.JButton btn_Limpiar;
    private javax.swing.JButton btn_consultar;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_rellenarCampos;
    private javax.swing.JComboBox<String> cbo_idCampus;
    private javax.swing.JComboBox<String> cbo_tipoUsuario;
    private javax.swing.JCheckBox chb_mostrarContraseña;
    private javax.swing.JLabel fechaHoy;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_apellidos;
    private javax.swing.JLabel lbl_contraseña;
    private javax.swing.JLabel lbl_idCampus;
    private javax.swing.JLabel lbl_identidad;
    private javax.swing.JLabel lbl_nombreU;
    private javax.swing.JLabel lbl_nombreUsuario;
    private javax.swing.JLabel lbl_nombres;
    private javax.swing.JLabel lbl_numeroIdentidad;
    private javax.swing.JLabel lbl_salario;
    private javax.swing.JLabel lbl_telefono;
    private javax.swing.JLabel lbl_tipoUsuario;
    private javax.swing.JLabel lbl_titulo;
    private javax.swing.JLabel lbl_usuario;
    private javax.swing.JMenuItem menu_Campus;
    private javax.swing.JMenuItem menu_Imprimir;
    private javax.swing.JMenuItem menu_MenuPrincipal;
    private javax.swing.JMenuItem menu_desbloquearUsuario;
    private javax.swing.JMenuItem menu_tipoUsuario;
    private javax.swing.JPasswordField pwd_contraseña;
    private javax.swing.JTextField txt_Apellido;
    private javax.swing.JTextField txt_Identidad;
    private javax.swing.JTextField txt_Nombre;
    private javax.swing.JTextField txt_NombreUsuario;
    private javax.swing.JTextField txt_Salario;
    private javax.swing.JTextField txt_Telefono;
    // End of variables declaration//GEN-END:variables

    

   // private void consulta() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
 // }

  

}
