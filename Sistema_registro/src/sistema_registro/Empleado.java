/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema_registro;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import sistema_registro.SQL.ConectorSQL;

/**
 *
 * @author William
 */
public class Empleado extends javax.swing.JFrame {
     
    String titulos [] = {"Nombre","Apellido", "Salario", "Telefono", "idCampus", "NombreUsuario", "contraseña", "tipoUsuario"};
    String fila [] = new String[7];
    DefaultTableModel modelo;
    Connection con = null;
    Statement stmt = null;
    String var, var2;

    /**
     * Creates new form RegistroEmpleado
     */
    public Empleado() throws SQLException {
        this.con = ConectorSQL.obtenerConexion();
        initComponents();
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

    
    
     public void ConsultaIndividual() {
        String cap="";
ResultSet  rs = null;
        var2 = var;
        String sql2="Select  Nombre, Apellido, Salario, Telefono, Identidad, idCampus, NombreUsuario, contraseña, tipoUsuario FROM Empleados where Nombre = '"+var2+"'";

   try { 

String url = "jdbc:sqlserver://WIL212027:1433;"; 
String usuario = "admin"; 
 String contraseña = "admin";

Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance(); 


     con = DriverManager.getConnection(url,usuario,contraseña); 

if( con != null ) 
	System.out.println("Se ha establecido una conexión a la base de datos " + 
	                                       "\n " + url ); 
	
	stmt = con.createStatement(); 
                rs = stmt.executeQuery(sql2); 

	int i=1; 
	   while ( rs.next() ) { 

	           String Nombre = rs.getString("Nombre"); 
	           String Apellido = rs.getString("Apellido"); 
                   String Salario= rs.getString("Salario"); 
                   String Telefono = rs.getString("Telefono"); 
                   String Identidad = rs.getString("Identidad");
                   String idCampus = rs.getString("idCampus");
                   String NombreUsuario = rs.getString("NombreUsuario");
                     //String contraseña = rs.getString("contraseña");
                       String tipoUsuario = rs.getString("tipoUsuario");
	System.out.println("Sitio Web "+ (i++) + ":\n" 
	
                           + Nombre + "\n" 
                           + Apellido + "\n" 
                           + Salario+ "\n"
	          + Telefono + "\n"
                           + Identidad + "\n"
                           + idCampus + "\n"
                          + NombreUsuario+ "\n"
                           + contraseña + "\n"
                           + tipoUsuario + "\n\n" ); 


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
     
     
     
     
      public void Modificar() {

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
String url = "jdbc:sqlserver://WIL212027:1433;"; 
String usuario = "admin"; 
                  String contraseña = "admin"; 

Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance(); 
                  con = DriverManager.getConnection(url,usuario,contraseña); 
if( con != null ) 
System.out.println("Se ha establecido una conexión a la base de datos " +  
"\n " + url ); 

stmt = con.createStatement(); 
stmt.executeUpdate("update ignore usuarios set Nombre= '"+cadena1+"' , Apellido = '"+cadena2+"',Salario = '"+cadena3+"',Telefono = '"+cadena4+"', idCampus = '"+cadena5+"', NombreUsuario = "+cadena6+": contraseña = '"+cadena7+"', tipoUsuario = '"+cadena8+"' where Nombre= '"+txt_Nombre.getText()+"' || Apellido = '"+txt_Apellido.getText()+"' || Salario = '"+txt_Salario.getText()+"' || Telefono = '"+txt_Telefono.getText()+"' || idCampus = '"+cbo_idCampus.getSelectedItem()+"' || contraseña= '"+pwd_contraseña.getText()+"' || tipoUsuario = '"+cbo_tipoUsuario.getSelectedItem()+"'"); 

System.out.println("Los valores han sido Actualizados"); 
} 
catch( SQLException e ) { 
e.printStackTrace(); 
                  } catch (ClassNotFoundException ex) { 
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, ex);
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
        txt_Nombre = new javax.swing.JTextField();
        txt_Apellido = new javax.swing.JTextField();
        lbl_nombres = new javax.swing.JLabel();
        lbl_apellidos = new javax.swing.JLabel();
        lbl_salario = new javax.swing.JLabel();
        txt_Salario = new javax.swing.JTextField();
        lbl_nombreUsuario = new javax.swing.JLabel();
        txt_NombreUsuario = new javax.swing.JTextField();
        lbl_contraseña = new javax.swing.JLabel();
        btn_guardar = new javax.swing.JButton();
        lbl_telefono = new javax.swing.JLabel();
        lbl_idCampus = new javax.swing.JLabel();
        txt_Telefono = new javax.swing.JTextField();
        cbo_idCampus = new javax.swing.JComboBox<>();
        pwd_contraseña = new javax.swing.JPasswordField();
        btn_limpiar = new javax.swing.JButton();
        lbl_titulo = new javax.swing.JLabel();
        chb_mostrarContraseña = new javax.swing.JCheckBox();
        lbl_tipoUsuario = new javax.swing.JLabel();
        cbo_tipoUsuario = new javax.swing.JComboBox<>();
        btn_consultar = new javax.swing.JButton();
        btn_Modificar = new javax.swing.JButton();
        lbl_identidad = new javax.swing.JLabel();
        txt_Identidad = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        cbo_MenuPrincipal = new javax.swing.JMenuItem();
        cbo_ConsultaIndividual = new javax.swing.JCheckBoxMenuItem();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

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

        txt_Apellido.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_Apellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_ApellidoKeyTyped(evt);
            }
        });

        lbl_nombres.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_nombres.setText("Nombres");

        lbl_apellidos.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_apellidos.setText("Apellidos");

        lbl_salario.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_salario.setText("Salario");

        txt_Salario.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_Salario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_SalarioActionPerformed(evt);
            }
        });
        txt_Salario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_SalarioKeyTyped(evt);
            }
        });

        lbl_nombreUsuario.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_nombreUsuario.setText("Nombre De Usuario");

        txt_NombreUsuario.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        lbl_contraseña.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_contraseña.setText("Contraseña");

        btn_guardar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_guardar.setText("Guardar");
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });

        lbl_telefono.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_telefono.setText("Teléfono");

        lbl_idCampus.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_idCampus.setText("ID Campus");

        txt_Telefono.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_Telefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_TelefonoKeyTyped(evt);
            }
        });

        cbo_idCampus.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cbo_idCampus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbo_idCampus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_idCampusActionPerformed(evt);
            }
        });

        pwd_contraseña.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        pwd_contraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pwd_contraseñaActionPerformed(evt);
            }
        });

        btn_limpiar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_limpiar.setText("Limpiar");

        lbl_titulo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbl_titulo.setText("Registro de Empleado");

        chb_mostrarContraseña.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        chb_mostrarContraseña.setText("Mostrar contraseña");
        chb_mostrarContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chb_mostrarContraseñaActionPerformed(evt);
            }
        });

        lbl_tipoUsuario.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_tipoUsuario.setText("Tipo Usuario");

        cbo_tipoUsuario.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cbo_tipoUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbo_tipoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_tipoUsuarioActionPerformed(evt);
            }
        });

        btn_consultar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_consultar.setText("Consulta");
        btn_consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_consultarActionPerformed(evt);
            }
        });

        btn_Modificar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_Modificar.setText("Modificar");
        btn_Modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ModificarActionPerformed(evt);
            }
        });

        lbl_identidad.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_identidad.setText("Identidad");

        txt_Identidad.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_Identidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_IdentidadKeyTyped(evt);
            }
        });

        jMenu1.setText("Inicio");

        cbo_MenuPrincipal.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        cbo_MenuPrincipal.setText("Menu Principal");
        cbo_MenuPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_MenuPrincipalActionPerformed(evt);
            }
        });
        jMenu1.add(cbo_MenuPrincipal);

        cbo_ConsultaIndividual.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        cbo_ConsultaIndividual.setSelected(true);
        cbo_ConsultaIndividual.setText("Consulta Individual");
        cbo_ConsultaIndividual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_ConsultaIndividualActionPerformed(evt);
            }
        });
        jMenu1.add(cbo_ConsultaIndividual);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbl_apellidos)
                            .addComponent(lbl_nombres, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(63, 63, 63)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txt_Nombre, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_Apellido, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbl_telefono)
                            .addComponent(lbl_identidad)
                            .addComponent(lbl_salario))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addComponent(txt_Salario))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_Telefono, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_Identidad, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(lbl_tipoUsuario)
                        .addGap(69, 69, 69)
                        .addComponent(cbo_tipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(lbl_contraseña)
                        .addGap(18, 18, 18)
                        .addComponent(pwd_contraseña))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lbl_nombreUsuario)
                                .addGap(69, 69, 69)
                                .addComponent(txt_NombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(chb_mostrarContraseña)
                                .addGap(138, 138, 138))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lbl_idCampus)
                                .addGap(64, 64, 64)
                                .addComponent(cbo_idCampus, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(155, 155, 155))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(359, 359, 359))
            .addGroup(layout.createSequentialGroup()
                .addGap(274, 274, 274)
                .addComponent(btn_Modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_guardar)
                .addGap(18, 18, 18)
                .addComponent(btn_consultar)
                .addGap(18, 18, 18)
                .addComponent(btn_limpiar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(lbl_titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(96, 96, 96)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_nombres, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_nombreUsuario)
                    .addComponent(txt_NombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_Apellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_apellidos)
                    .addComponent(lbl_contraseña)
                    .addComponent(pwd_contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbo_idCampus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_idCampus))
                        .addComponent(txt_Salario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbl_salario))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_tipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbo_tipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_telefono)
                            .addComponent(txt_Telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_identidad)
                    .addComponent(txt_Identidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chb_mostrarContraseña)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 111, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_consultar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_limpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(73, 73, 73))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_SalarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_SalarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_SalarioActionPerformed

    private void chb_mostrarContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chb_mostrarContraseñaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chb_mostrarContraseñaActionPerformed

    private void pwd_contraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pwd_contraseñaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pwd_contraseñaActionPerformed

    private void cbo_tipoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_tipoUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbo_tipoUsuarioActionPerformed

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        String cadena3, cadena4, cadena5, cadena6, cadena7, cadena8, cadena9, cadena10, cadena11;
        cadena3 = txt_Nombre.getText();
        cadena4 = txt_Apellido.getText();
        cadena5 = txt_Salario.getText();
        cadena6 = txt_Telefono.getText();
        cadena7 = txt_Identidad.getText();
        cadena8 = cbo_idCampus.getSelectedItem().toString();
        cadena9 = txt_NombreUsuario.getText();
        cadena10 = pwd_contraseña.getText();
        cadena11 = cbo_tipoUsuario.getSelectedItem().toString();
        
        if ((txt_Nombre.getText().equals("")) || (txt_Apellido.getText().equals("")) || (txt_Salario.getText().equals(""))
         || (txt_Telefono.getText().equals(""))   || (txt_Identidad.getText().equals("")) || (cbo_idCampus.getSelectedItem().equals(null)) || (txt_NombreUsuario.getText().equals(""))|| (pwd_contraseña.getText().equals("")) || (cbo_tipoUsuario.getSelectedItem().equals(null)) ) {
            
            javax.swing.JOptionPane.showMessageDialog(this,"Debe llenar todos los campos \n","AVISO!",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            txt_Nombre.requestFocus();
        }
    }//GEN-LAST:event_btn_guardarActionPerformed

    private void txt_NombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_NombreKeyTyped
       char c = evt.getKeyChar();
       if((c < 'a' || c > 'z') && (c < 'A' || c >'Z') && (c > ' ' || c > ' '))evt.consume();
    }//GEN-LAST:event_txt_NombreKeyTyped

    private void txt_ApellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_ApellidoKeyTyped
       char c = evt.getKeyChar();
       if((c < 'a' || c > 'z') && (c < 'A' || c >'Z') && (c > ' ' || c > ' '))evt.consume();
    }//GEN-LAST:event_txt_ApellidoKeyTyped

    private void txt_TelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_TelefonoKeyTyped
        char c = evt.getKeyChar();
        if((c < '0' || c > '9'))evt.consume();
    }//GEN-LAST:event_txt_TelefonoKeyTyped

    private void txt_SalarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_SalarioKeyTyped
      char c = evt.getKeyChar();
      if((c < '0' || c > '9'))evt.consume();
    }//GEN-LAST:event_txt_SalarioKeyTyped

    private void txt_NombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_NombreActionPerformed
        
    }//GEN-LAST:event_txt_NombreActionPerformed

    private void btn_consultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_consultarActionPerformed
        
          
         this.dispose();
        
        ConsultasEmpleados u = null;
        try {
            u = new ConsultasEmpleados();
        } catch (SQLException ex) {
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        u.setVisible(true);
        
        
        
    }//GEN-LAST:event_btn_consultarActionPerformed

    private void cbo_MenuPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_MenuPrincipalActionPerformed
        this.dispose();
        
        Principal p = new Principal();
        p.setVisible(true);
    }//GEN-LAST:event_cbo_MenuPrincipalActionPerformed

    private void cbo_idCampusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_idCampusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbo_idCampusActionPerformed

    private void btn_ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ModificarActionPerformed
       
            Modificar ();   
        
    }//GEN-LAST:event_btn_ModificarActionPerformed

    private void cbo_ConsultaIndividualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_ConsultaIndividualActionPerformed
        
        String cap="";
        ResultSet rs = null; 
var = javax.swing.JOptionPane.showInputDialog(this,"Nombre del Usuario","Consultausuario",javax.swing.JOptionPane.QUESTION_MESSAGE);
        String sql="SELECT* FROM  usuarios WHERE nombre = '"+var+"'";
if(var == null)  
javax.swing.JOptionPane.showMessageDialog(this,"La accion fue cancelada","AVISO!",javax.swing.JOptionPane.INFORMATION_MESSAGE);
      else {
        if (var.equals("")) {
javax.swing.JOptionPane.showMessageDialog(this,"Favor de ingresar el nombre del empleado\nquedesea consultar","AVISO!",javax.swing.JOptionPane.INFORMATION_MESSAGE);
        }
         else {
        try {

String url = "jdbc:sqlserver://WIL212027:1433;";
String usuario = "admin";
            String contraseña = "admin";

Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance(); 
             con = DriverManager.getConnection(url,usuario,contraseña); 
if( con != null ) 
System.out.println("Se ha establecido una conexión a la base de datos " +  
"\n " + url ); 

stmt = con.createStatement(); 
rs = stmt.executeQuery(sql);

          while(rs.next()) {

               cap = rs.getString("tipoUsuario"); 

          if (cap.equals("administrador") || cap.equals("empleado") ) {

ConsultaIndividual();           
          }
}   // fin del bucle While

        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException ex) {
Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
       }

finally {
            if (con != null) {
                try {
con.close();
stmt.close();
                } catch ( Exception e ) { 
System.out.println( e.getMessage());
                }
              }
            }
           if ( !cap.equals("administrador") && !cap.equals("manager") && !cap.equals("servidor")) {
javax.swing.JOptionPane.showMessageDialog(this,"Elusuario no fueencontrado\n","ERROR!", javax.swing.JOptionPane.ERROR_MESSAGE);

          }
        }
      }  

        
    }//GEN-LAST:event_cbo_ConsultaIndividualActionPerformed

    private void txt_IdentidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_IdentidadKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_IdentidadKeyTyped

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
    private javax.swing.JButton btn_Modificar;
    private javax.swing.JButton btn_consultar;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_limpiar;
    private javax.swing.JCheckBoxMenuItem cbo_ConsultaIndividual;
    private javax.swing.JMenuItem cbo_MenuPrincipal;
    private javax.swing.JComboBox<String> cbo_idCampus;
    private javax.swing.JComboBox<String> cbo_tipoUsuario;
    private javax.swing.JCheckBox chb_mostrarContraseña;
    private javax.swing.JButton jButton1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel lbl_apellidos;
    private javax.swing.JLabel lbl_contraseña;
    private javax.swing.JLabel lbl_idCampus;
    private javax.swing.JLabel lbl_identidad;
    private javax.swing.JLabel lbl_nombreUsuario;
    private javax.swing.JLabel lbl_nombres;
    private javax.swing.JLabel lbl_salario;
    private javax.swing.JLabel lbl_telefono;
    private javax.swing.JLabel lbl_tipoUsuario;
    private javax.swing.JLabel lbl_titulo;
    private javax.swing.JPasswordField pwd_contraseña;
    private javax.swing.JTextField txt_Apellido;
    private javax.swing.JTextField txt_Identidad;
    private javax.swing.JTextField txt_Nombre;
    private javax.swing.JTextField txt_NombreUsuario;
    private javax.swing.JTextField txt_Salario;
    private javax.swing.JTextField txt_Telefono;
    // End of variables declaration//GEN-END:variables

    private void Item(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   // private void consulta() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
 // }

  

}
