/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema_registro;

import static java.awt.Frame.ICONIFIED;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import org.apache.commons.codec.digest.DigestUtils;
import sistema_registro.SQL.ConectorSQL;

/**
 *
 * @author Carlos
 */
public class Campus extends javax.swing.JFrame {

    String titulos[] = {"Id Campus", "Nombre Campus"};
    DefaultTableModel modelo = new DefaultTableModel();
    Connection con = null;
    Statement stmt = null;
    String var, var2;

    /**
     * Creates new form Campus
     */
    public Campus() throws SQLException {
        this.con = ConectorSQL.obtenerConexion();
        initComponents();
        actualizarDatos(); 
        this.setTitle("Campus");
         this.setIconImage(new ImageIcon(getClass().getResource("/Imagenes/Titulo.png")).getImage());
    }

    public Campus(String nombreUsuario) throws SQLException {
        this.con = ConectorSQL.obtenerConexion();
        initComponents();
        actualizarDatos(); 
        this.setTitle("Campus");
        this.lbl_usuario.setText(nombreUsuario);
         this.setIconImage(new ImageIcon(getClass().getResource("/Imagenes/Titulo.png")).getImage());
    }
    public void Actualizar() {

        String cadena1, cadena2;

        cadena1 = txt_idCampus.getText();
        cadena2 = txt_NombreCampus.getText();
       

        if (txt_NombreCampus.getText().equals("")) {

            javax.swing.JOptionPane.showMessageDialog(this, "1-. Consulte el nombre del campus\n 2-. Actualice el dato deseado en el campo correspondiente", "AVISO!", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        } else {

            try {

                stmt = con.createStatement();
                stmt.executeUpdate("update ignore campus set id_campus= '" + cadena1 + "' , nombre_campus = '" + cadena2 + "' where id_campus= '" + txt_idCampus.getText() + "' || nombre_campus = '" + txt_NombreCampus.getText() + "' ");
                System.out.println("Los valores han sido Actualizados");
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if (con != null) {
                    try {
                        con.close();
                        stmt.close();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
            javax.swing.JOptionPane.showMessageDialog(this, "Actualizado Correctamente!", "AVISO!", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        }
        this.txt_idCampus.setText("");
        this.txt_NombreCampus.setText("");
        actualizarDatos(); 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        iconodeUsuario = new javax.swing.JLabel();
        lbl_usuario = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btn_guardar = new javax.swing.JButton();
        btn_actualizar = new javax.swing.JButton();
        btn_buscar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla_Campus = new javax.swing.JTable();
        lbl_nombreCampus = new javax.swing.JLabel();
        txt_NombreCampus = new javax.swing.JTextField();
        txt_idCampus = new javax.swing.JTextField();
        lbl_idCampus = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lbl_titulo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        JMenuRegrear = new javax.swing.JMenu();
        JMIEmpleados = new javax.swing.JMenuItem();

        jMenu1.setText("File");
        jMenuBar2.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar2.add(jMenu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        iconodeUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/User.png"))); // NOI18N
        getContentPane().add(iconodeUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 50, 70));

        lbl_usuario.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_usuario.setText("Nombre Usuario");
        getContentPane().add(lbl_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 190, -1));

        jPanel1.setBackground(new java.awt.Color(215, 236, 233));

        btn_guardar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/botton_Guardar.png"))); // NOI18N
        btn_guardar.setText("Guardar");
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });

        btn_actualizar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_actualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/botton_Actualizar.png"))); // NOI18N
        btn_actualizar.setText("Actualizar");
        btn_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_actualizarActionPerformed(evt);
            }
        });

        btn_buscar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/botton_Consulta.png"))); // NOI18N
        btn_buscar.setText("Buscar");
        btn_buscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_buscarMouseClicked(evt);
            }
        });
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });

        btn_eliminar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/botton_Eliminar.png"))); // NOI18N
        btn_eliminar.setText("Eliminar");
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });

        Tabla_Campus.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Campus", "Nombre Campus"
            }
        ));
        Tabla_Campus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tabla_CampusMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Tabla_Campus);

        lbl_nombreCampus.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_nombreCampus.setText("Nombre del Campus:");

        txt_NombreCampus.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_NombreCampus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_NombreCampusActionPerformed(evt);
            }
        });
        txt_NombreCampus.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_NombreCampusKeyTyped(evt);
            }
        });

        txt_idCampus.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_idCampus.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_idCampusFocusLost(evt);
            }
        });
        txt_idCampus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_idCampusActionPerformed(evt);
            }
        });
        txt_idCampus.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_idCampusKeyTyped(evt);
            }
        });

        lbl_idCampus.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_idCampus.setText("ID Campus:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_actualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_guardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_buscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_eliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lbl_idCampus)
                            .addComponent(lbl_nombreCampus))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_idCampus, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_NombreCampus, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(280, 280, 280))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(btn_guardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_actualizar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_idCampus, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_idCampus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_nombreCampus)
                            .addComponent(txt_NombreCampus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_buscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_eliminar)))
                .addContainerGap(61, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, 880, 390));

        jPanel2.setBackground(new java.awt.Color(232, 251, 249));

        lbl_titulo.setBackground(new java.awt.Color(232, 251, 249));
        lbl_titulo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbl_titulo.setText("Campus");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(406, Short.MAX_VALUE)
                .addComponent(lbl_titulo)
                .addGap(390, 390, 390))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lbl_titulo)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 880, 70));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/imagen 3.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 580));

        jMenuBar1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        JMenuRegrear.setBackground(new java.awt.Color(255, 255, 255));
        JMenuRegrear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/boton_retroceder.png"))); // NOI18N
        JMenuRegrear.setText("Regresar");

        JMIEmpleados.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        JMIEmpleados.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        JMIEmpleados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/user-with-suit-and-plus-symbol_icon-icons.com_68275.png"))); // NOI18N
        JMIEmpleados.setText("Empleados");
        JMIEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMIEmpleadosActionPerformed(evt);
            }
        });
        JMenuRegrear.add(JMIEmpleados);

        jMenuBar1.add(JMenuRegrear);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JMIEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMIEmpleadosActionPerformed
           Empleado empleados = null;
        try {
            empleados = new Empleado(lbl_usuario.getText());
        } catch (SQLException ex) {
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, ex);
        }
        empleados.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_JMIEmpleadosActionPerformed

    private void txt_idCampusKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_idCampusKeyTyped
        if (txt_idCampus.getText().length() >= 4) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Número máximo de caracteres admitidos");
        }
        if (evt.getKeyChar() == 8 || evt.getKeyChar() == 127
            || evt.getKeyChar() == 0 || evt.getKeyChar() == 3 || evt.getKeyChar() == 22
            || evt.getKeyChar() == 26 || evt.getKeyChar() == 24) {
            return;
        }
        char a = evt.getKeyChar();
        if (!Character.isLetterOrDigit(a)) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Sólo letras y numeros");
        }
    }//GEN-LAST:event_txt_idCampusKeyTyped

    private void txt_NombreCampusKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_NombreCampusKeyTyped
        if (txt_NombreCampus.getText().length() >= 35) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Número máximo de caracteres admitidos");
        }
        if (evt.getKeyChar() == 8 || evt.getKeyChar() == 127
            || evt.getKeyChar() == 0 || evt.getKeyChar() == 3 || evt.getKeyChar() == 22
             || evt.getKeyChar() == 26 || evt.getKeyChar() == 24) {
            return;
        }
         if(evt.getKeyChar() == 32){
             if(txt_NombreCampus.getText().length() == 0){
                 evt.consume();
                 Toolkit.getDefaultToolkit().beep();
                 return;
             }
             if(txt_NombreCampus.getText().substring(txt_NombreCampus.getText().length() - 1).equals(" ")){
                 evt.consume();
                 Toolkit.getDefaultToolkit().beep();
             }
             return; 
         }
        char a = evt.getKeyChar();
        if (Character.isDigit(a)) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Sólo letras");
        }
    }//GEN-LAST:event_txt_NombreCampusKeyTyped

    private void txt_NombreCampusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_NombreCampusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_NombreCampusActionPerformed

    private void Tabla_CampusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tabla_CampusMouseClicked
        if (Tabla_Campus.getSelectedRow() >= 0) {
            llenarCampos();
        }
    }//GEN-LAST:event_Tabla_CampusMouseClicked

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
        String nombreCampus = txt_NombreCampus.getText() + " " + txt_idCampus.getText();
        
        if ((txt_idCampus.getText().equals("") || (txt_NombreCampus.getText().equals("")))) {
            JOptionPane.showMessageDialog(this, "¡Debe seleccionar el campo a eliminar!");
            
        }
        else if (JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar el registro del campus " + nombreCampus + "", "Confirmación de eliminación",
            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE
        ) == JOptionPane.YES_OPTION) {

            try {
                Statement st2 = con.createStatement();
                String sql = "Delete Campus "
                + "where id_campus = (Select id_campus from Campus where nombre_campus = '"+txt_NombreCampus.getText()+"')";

                int rs2 = st2.executeUpdate(sql);
                System.out.println(rs2);
                if(rs2 > 0){
                    JOptionPane.showMessageDialog(null, "Se ha borrado la información del campus " + nombreCampus + " correctamente");

                }else {
                    JOptionPane.showMessageDialog(null, "¡Error al eliminar la información!");

                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }

            /* try{
                PreparedStatement ps;
                ResultSet rs;
                ps=con.prepareStatement("Delete Campus "
                    + "where nombre_campus = '"+var+"' ");
                int res= ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Se ha borrado la información del empleado "+nombreCampus+" correctamente");
                if(res > 0){
                }else {
                    JOptionPane.showMessageDialog(null, "¡Error al eliminar la información!");
                }
            } catch ( Exception e) {
                System.out.println(e);
            }*/
            actualizarDatos();
            LimpiarCajas();
        }
    }//GEN-LAST:event_btn_eliminarActionPerformed

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed

        actualizarDatos();
     
    }//GEN-LAST:event_btn_buscarActionPerformed

    private void btn_buscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_buscarMouseClicked
        rellenar();
    }//GEN-LAST:event_btn_buscarMouseClicked

    private void btn_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_actualizarActionPerformed
        String nombreCampus = txt_NombreCampus.getText() + " ";
         if ((txt_idCampus.getText().equals("") || (txt_NombreCampus.getText().equals("")))) {
            JOptionPane.showMessageDialog(this, "¡Debe seleccionar el campus a actualizar!");
        }
           
         else if (JOptionPane.showConfirmDialog(null, "¿Está seguro que desea actualizar el registro del campus " + nombreCampus + "?", "Confirmación de actualización", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE
        ) == JOptionPane.YES_OPTION) {
            try {
                PreparedStatement ps;
                ResultSet rs;
                ps = con.prepareStatement("Update Campus set"
                    + " nombre_campus = ? ,"
                    + "id_campus = ? "
                    + " where id_campus =\'"+txt_idCampus.getText()+"\'");
                /*ps.setString(1, txt_NombreCampus.getText());*/
                ps.setString(1, txt_NombreCampus.getText());
                ps.setString(2, txt_idCampus.getText());
                int res = ps.executeUpdate();
            } catch (Exception e) {
                System.out.println(e);
            }
            actualizarDatos();
            LimpiarCajas();
        }

    }//GEN-LAST:event_btn_actualizarActionPerformed

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        String cadena1, cadena2;
        cadena1 = txt_idCampus.getText();
        cadena2 = txt_NombreCampus.getText();

        if((txt_idCampus.getText().equals(""))){
            javax.swing.JOptionPane.showMessageDialog(this,"Debe ingresar el id del campus.","Id campus  requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            txt_idCampus.requestFocus();
            return;
        }
        if((txt_NombreCampus.getText().equals(""))){
            javax.swing.JOptionPane.showMessageDialog(this,"Debe ingresar el nombre del campus."," nombre campus requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            txt_NombreCampus.requestFocus();
            return;
        }
        if (existeidCampus()) {
            return;
        }
        
        if (existeCampus()) {
            return;
        }

        if (!validarLongitud(txt_idCampus, 3)) {
            JOptionPane.showMessageDialog(null, "El ID del Campus es muy pequeño el mínimo es de 3 caracteres", "Longitud del ID del Campus", JOptionPane.INFORMATION_MESSAGE);
            return;

        }

        if (!validarLongitud(txt_NombreCampus, 5)) {
            JOptionPane.showMessageDialog(null, "El nombre del campus ingresado es muy pequeños el mínimo es de 5 caracteres", "Longitud del nombre", JOptionPane.INFORMATION_MESSAGE);
            return;

        }

        try {
            PreparedStatement ps;
            ResultSet rs;
            ps = con.prepareStatement("INSERT INTO Campus (id_campus, nombre_campus)"
                + "                VALUES(?,?)");
            ps.setString(1, txt_idCampus.getText());
            ps.setString(2, txt_NombreCampus.getText());
            int res = ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se ha guardado la información del campus: "+txt_NombreCampus.getText()+"");
        } catch (Exception e) {
            System.out.println(e);

        }
        actualizarDatos();
        LimpiarCajas();
    }//GEN-LAST:event_btn_guardarActionPerformed

    private void txt_idCampusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_idCampusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_idCampusActionPerformed

    private void txt_idCampusFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_idCampusFocusLost
        String id = txt_idCampus.getText();
        String upper = id.toUpperCase();
        txt_idCampus.setText(upper); 
    }//GEN-LAST:event_txt_idCampusFocusLost

    public void actualizarDatos() {
        try {
            String sql = "SELECT * FROM Campus";
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            modelo = new DefaultTableModel(null, titulos);
            Tabla_Campus.setModel(modelo);
            while (rs.next()) {
                String[] datos = new String[2];
                datos[0] = rs.getString("id_campus");
                datos[1] = rs.getString("nombre_campus");
                modelo.addRow(datos);
            }
            TableColumn idC = Tabla_Campus.getColumn(titulos[0]);
            idC.setMaxWidth(150);
            idC.setIdentifier(ICONIFIED);
            TableColumn cn = Tabla_Campus.getColumn(titulos[1]);
            cn.setMaxWidth(300);
        } catch (Exception e) {
           /* JOptionPane.showMessageDialog(null, e.getMessage());*/
            System.err.println(e);
        }
    }

    public void centrar_datos() {
        DefaultTableCellRenderer modelocentrar = new DefaultTableCellRenderer();
        modelocentrar.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i <modelo.getRowCount(); i++) {
              Tabla_Campus.getColumnModel().getColumn(i).setCellRenderer(modelocentrar);   
         }
    }

    /**
     *
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
            java.util.logging.Logger.getLogger(Campus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Campus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Campus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Campus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Campus().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Campus.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem JMIEmpleados;
    private javax.swing.JMenu JMenuRegrear;
    private javax.swing.JTable Tabla_Campus;
    private javax.swing.JButton btn_actualizar;
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JLabel iconodeUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_idCampus;
    private javax.swing.JLabel lbl_nombreCampus;
    private javax.swing.JLabel lbl_titulo;
    private javax.swing.JLabel lbl_usuario;
    private javax.swing.JTextField txt_NombreCampus;
    private javax.swing.JTextField txt_idCampus;
    // End of variables declaration//GEN-END:variables

    private boolean existeidCampus() {
        try {
            Statement st = con.createStatement();
            String sql = "Select id_campus from Campus where id_campus = '" + txt_idCampus.getText() + "'";
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "El id: " + txt_idCampus.getText() + " ya existe", "El id del campus ¡Ya existe!.", JOptionPane.INFORMATION_MESSAGE);
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Campus.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    private boolean existeCampus() {
        try {
            Statement st = con.createStatement();
            String sql = "Select nombre_campus from Campus where nombre_campus = '" + txt_NombreCampus.getText() + "'";
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "El nombre campus: " + txt_NombreCampus.getText() + " ya existe", "El campus ¡Ya existe!.", JOptionPane.INFORMATION_MESSAGE);
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Campus.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    private boolean validarLongitud(JTextField texto, int longitud) {
        if (texto.getText().length() >= longitud) {
            return true;
        } else {
            return false;
        }
    }

    private void llenarCampos() {
        int i = Tabla_Campus.getSelectedRow();
        txt_idCampus.setText(Tabla_Campus.getValueAt(i, 0).toString());
        txt_NombreCampus.setText(Tabla_Campus.getValueAt(i, 1).toString());

    }
  

private void rellenar() {
                try {
                    String cap = "";
                    ResultSet rs2 = null;
                   var = JOptionPane.showInputDialog(this, "Ingrese el nombre del campus que desea consultar", "Consulta de campus", JOptionPane.QUESTION_MESSAGE);
                    if (var == null) {
                        JOptionPane.showMessageDialog(this, "La acción fue cancelada", "¡AVISO!", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        if (var.equals("")) {
                            JOptionPane.showMessageDialog(this, "Favor de ingresar el nombre del campus \n que desea consultar", "¡AVISO!", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            String sql = "SELECT * FROM Campus where id_campus='"+var+"' or nombre_campus ='"+var+"'";
                            stmt = con.createStatement();
                            rs2 = stmt.executeQuery(sql);

                            if (rs2.next()) {
                                txt_idCampus.setText(rs2.getString("id_campus"));
                                txt_NombreCampus.setText(rs2.getString("nombre_campus"));
                            } else {
                                JOptionPane.showMessageDialog(null, "¡No se encuentra los datos: "+var+" ! Por favor verifique sí, lo escribio correctamente");
                            }
                        }

                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
    }

  private void LimpiarCajas(){
        txt_NombreCampus.setText(null);
        txt_idCampus.setText(null);
        
    }

}