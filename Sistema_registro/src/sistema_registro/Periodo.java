/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema_registro;

import static java.awt.Frame.ICONIFIED;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import sistema_registro.SQL.ConectorSQL;

/**
 *
 * @author William & Genesis
 */
public class Periodo extends javax.swing.JFrame {

       String titulos[] = {"Id Período", "Período", "Descripción"};
    DefaultTableModel modelo = new DefaultTableModel();
    Connection con = null;
    Statement stmt = null;
    String var, var2;
    
    
    public Periodo() throws SQLException {
         this.con = ConectorSQL.obtenerConexion ();
        initComponents();
    }
    
    public Periodo(String nombreUsuario) throws SQLException {
         this.con = ConectorSQL.obtenerConexion ();
        initComponents();
        
        this.lbl_usuario.setText(nombreUsuario);
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        lbl_titulo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lbl_idPeriodo = new javax.swing.JLabel();
        lbl_NomPer = new javax.swing.JLabel();
        lbl_descripcion = new javax.swing.JLabel();
        txt_idPeriodo = new javax.swing.JTextField();
        txt_periodo = new javax.swing.JTextField();
        txt_descripcion = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla_Periodo = new javax.swing.JTable();
        btn_guardar = new javax.swing.JButton();
        btn_actualizar = new javax.swing.JButton();
        btn_buscar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        lbl_usuario = new javax.swing.JLabel();
        iconodeUsuario = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu = new javax.swing.JMenu();
        jMenuPrincipal = new javax.swing.JMenuItem();
        jMenuPrincipal1 = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(232, 251, 249));

        lbl_titulo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbl_titulo.setText("Período");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(306, 306, 306)
                .addComponent(lbl_titulo)
                .addContainerGap(315, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_titulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 700, -1));

        jPanel2.setBackground(new java.awt.Color(215, 236, 233));

        lbl_idPeriodo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_idPeriodo.setText("Id Período:");

        lbl_NomPer.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_NomPer.setText("Nombre del Período:");

        lbl_descripcion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_descripcion.setText("Descripción Período:");

        txt_idPeriodo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_idPeriodo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_idPeriodoKeyTyped(evt);
            }
        });

        txt_periodo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_periodo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_periodoKeyTyped(evt);
            }
        });

        txt_descripcion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_descripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_descripcionKeyTyped(evt);
            }
        });

        Tabla_Periodo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Periodo", "Nombre Periodo", "Descripcion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Tabla_Periodo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tabla_PeriodoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Tabla_Periodo);

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_actualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_guardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_buscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_eliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_NomPer)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(lbl_descripcion)
                                        .addGap(26, 26, 26))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(lbl_idPeriodo)
                                        .addGap(24, 24, 24)))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_periodo, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_idPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(173, 173, 173)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lbl_descripcion)
                                .addComponent(txt_descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(38, 38, 38))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(btn_guardar)
                            .addGap(28, 28, 28)
                            .addComponent(btn_actualizar)
                            .addGap(18, 18, 18)
                            .addComponent(btn_buscar)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_idPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_idPeriodo))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_NomPer)
                            .addComponent(txt_periodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btn_eliminar)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38))))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, 700, 410));

        lbl_usuario.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_usuario.setText("Nombre Usuario");
        getContentPane().add(lbl_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 190, -1));

        iconodeUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/User.png"))); // NOI18N
        getContentPane().add(iconodeUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 50, 70));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/imagen 3.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, 570));

        jMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/menu.png"))); // NOI18N
        jMenu.setText("Menu");

        jMenuPrincipal.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        jMenuPrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/boton_retroceder.png"))); // NOI18N
        jMenuPrincipal.setText("Regresar");
        jMenuPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuPrincipalActionPerformed(evt);
            }
        });
        jMenu.add(jMenuPrincipal);

        jMenuPrincipal1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        jMenuPrincipal1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/inicio.png"))); // NOI18N
        jMenuPrincipal1.setText("Menu Principal");
        jMenuPrincipal1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuPrincipal1ActionPerformed(evt);
            }
        });
        jMenu.add(jMenuPrincipal1);

        jMenuBar1.add(jMenu);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        
         String cadena1, cadena2, cadena3;
        cadena1 = txt_idPeriodo.getText();
        cadena2 = txt_periodo.getText();
        cadena3 = txt_descripcion.getText();
        
        if((txt_idPeriodo.getText().equals(""))){
            javax.swing.JOptionPane.showMessageDialog(this,"Debe ingresar el id período.","Id de período requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            txt_idPeriodo.requestFocus();
            return;
        }
          
        if((txt_periodo.getText().equals(""))){
            javax.swing.JOptionPane.showMessageDialog(this,"Debe ingresar el período.","Período requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            txt_periodo.requestFocus();
            return;
        }
        
         if((txt_descripcion.getText().equals(""))){
            javax.swing.JOptionPane.showMessageDialog(this,"Debe ingresar una descripcion del período","Descripcion del período",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
         
        
        if (existeidPeriodo()) {
            return;
        }

        if (!validarLongitud(txt_idPeriodo, 1)) {
            JOptionPane.showMessageDialog(null, "El id período ingresado es muy pequeño, el mínimo es de 1caracteres", "Longitud de id período", JOptionPane.INFORMATION_MESSAGE);
            return;

        }

        if (!validarLongitud(txt_periodo,1 )) {
            JOptionPane.showMessageDialog(null, "El  período ingresado es muy pequeño, el mínimo es de 1 caracter", "Longitud del período", JOptionPane.INFORMATION_MESSAGE);
            return;

        }
        
         if (!validarLongitud(txt_descripcion,10 )) {
            JOptionPane.showMessageDialog(null, "La descripcion del período ingresado es muy pequeño, el mínimo es de 10 caracter", "Longitud del período", JOptionPane.INFORMATION_MESSAGE);
            return;

        }

        try {
            PreparedStatement ps;
            ResultSet rs;
            ps = con.prepareStatement("INSERT INTO Periodo (id_periodo, periodo ,descripcion)"
                + "                VALUES(?,?,?)");
            ps.setString(1, txt_idPeriodo.getText());
            ps.setString(2, txt_periodo.getText());
            ps.setString(3, txt_descripcion.getText());
            int res = ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se ha guardado la información del período");
        } catch (Exception e) {
            System.out.println(e);

        }

        actualizarDatos();
        LimpiarCajas();
        
    }//GEN-LAST:event_btn_guardarActionPerformed

    private void Tabla_PeriodoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tabla_PeriodoMouseClicked
           if(Tabla_Periodo.getSelectedRow() >= 0){
            llenarCampos();
        }
    }//GEN-LAST:event_Tabla_PeriodoMouseClicked

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
       
        actualizarDatos();
        
    }//GEN-LAST:event_btn_buscarActionPerformed

    private void jMenuPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuPrincipalActionPerformed

       PeriodoHis pp = null;
        try {
            pp = new PeriodoHis(lbl_usuario.getText());
        } catch (SQLException ex) {
            Logger.getLogger(Carrera.class.getName()).log(Level.SEVERE, null, ex);
        }
        pp.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_jMenuPrincipalActionPerformed

    private void btn_buscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_buscarMouseClicked
        
        rellenar();
        this.jScrollPane1.setEnabled(true);
        this.Tabla_Periodo.setEnabled(true);
        
    }//GEN-LAST:event_btn_buscarMouseClicked

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
         String nombrePeriodo = txt_idPeriodo.getText() + " " + txt_descripcion.getText();
        
        if ((txt_idPeriodo.getText().equals("") || (txt_periodo.getText().equals("")))) {
            JOptionPane.showMessageDialog(this, "¡Debe seleccionar el período a eliminar!");
            
        }
        else if (JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar el registro del período " + nombrePeriodo + ".", "Confirmación de eliminación",
            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE
        ) == JOptionPane.YES_OPTION) {

            try {
                Statement st2 = con.createStatement();
                String sql = "Delete Periodo "
                + "where id_periodo = (Select id_periodo from Periodo where id_periodo = '"+txt_idPeriodo.getText()+"')";

                int rs2 = st2.executeUpdate(sql);
                System.out.println(rs2);
                if(rs2 > 0){
                    JOptionPane.showMessageDialog(null, "Se ha borrado la información del período " + nombrePeriodo + " correctamente.");

                }else {
                    JOptionPane.showMessageDialog(null, "¡Error al eliminar la información!");

                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }

           
            actualizarDatos();
            LimpiarCajas();
        }
    }//GEN-LAST:event_btn_eliminarActionPerformed

    private void btn_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_actualizarActionPerformed
            String nombrePeriodo = txt_idPeriodo.getText() + " " +txt_descripcion.getText() + " ";
         if ((txt_idPeriodo.getText().equals("") || (txt_periodo.getText().equals("")) || (txt_descripcion.getText().equals("")))) {
            JOptionPane.showMessageDialog(this, "¡Debe seleccionar el período a actualizar!");
        }
           
         else if (JOptionPane.showConfirmDialog(null, "¿Está seguro que desea actualizar el registro del período " + nombrePeriodo + "?.", "Confirmación de actualización", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE
        ) == JOptionPane.YES_OPTION) {
            try {
                PreparedStatement ps;
                ResultSet rs;
                ps = con.prepareStatement("Update Periodo set"
                    + " id_periodo = ? ,"
                    + " periodo = ? ,"
                    + "descripcion = ? "
                    + " where id_periodo =\'"+txt_idPeriodo.getText()+"\'");
                ps.setString(1, txt_idPeriodo.getText());
                ps.setString(2, txt_periodo.getText());
                 ps.setString(3, txt_descripcion.getText());
                int res = ps.executeUpdate();
            } catch (Exception e) {
                System.out.println(e);
            }
            actualizarDatos();
            LimpiarCajas();
        }
    }//GEN-LAST:event_btn_actualizarActionPerformed

    private void txt_idPeriodoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_idPeriodoKeyTyped
          char a=evt.getKeyChar();
            if (evt.getKeyChar() == 8 || evt.getKeyChar() == 127 || 
                 evt.getKeyChar() == 0 || evt.getKeyChar() == 3 || evt.getKeyChar() == 22 
                 || evt.getKeyChar() == 26 || evt.getKeyChar() == 24) {
        return;
        }
        if(txt_idPeriodo.getText().length() >=3){
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Número máximo de dígitos admitidos");
        }
        if(Character.isLetter(a) || !Character.isLetterOrDigit(a)){
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Solo números");
        }
    }//GEN-LAST:event_txt_idPeriodoKeyTyped

    private void txt_periodoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_periodoKeyTyped
         char a=evt.getKeyChar();
            if (evt.getKeyChar() == 8 || evt.getKeyChar() == 127 || 
                 evt.getKeyChar() == 0 || evt.getKeyChar() == 3 || evt.getKeyChar() == 22 
                 || evt.getKeyChar() == 26 || evt.getKeyChar() == 24) {
        return;
        }
        if(txt_periodo.getText().length() >=1){
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Número máximo de dígitos admitidos");
        }
        if(Character.isLetter(a) || !Character.isLetterOrDigit(a)){
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Solo números");
        }
    }//GEN-LAST:event_txt_periodoKeyTyped

    private void txt_descripcionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_descripcionKeyTyped
char a=evt.getKeyChar();
   
            if (evt.getKeyChar() == 8 || evt.getKeyChar() == 127 || 
                 evt.getKeyChar() == 0 || evt.getKeyChar() == 3 || evt.getKeyChar() == 22 
                 || evt.getKeyChar() == 26 || evt.getKeyChar() == 24) {
        return;
        }
         if(evt.getKeyChar() == 32){
             if(txt_descripcion.getText().length() == 0){
                 evt.consume();
                 Toolkit.getDefaultToolkit().beep();
                 return;
             }
             if(txt_descripcion.getText().substring(txt_descripcion.getText().length() - 1).equals(" ")){
                 evt.consume();
                 Toolkit.getDefaultToolkit().beep();
             }
             return; 
         }
        if(txt_descripcion.getText().length() >=15){
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Número máximo de caracteres admitidos");
        }
        
        if(Character.isDigit(a) || !Character.isLetterOrDigit(a) ){
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Sólo letras");
        }      
    }//GEN-LAST:event_txt_descripcionKeyTyped

    private void jMenuPrincipal1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuPrincipal1ActionPerformed
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
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuPrincipal1ActionPerformed

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
            java.util.logging.Logger.getLogger(Periodo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Periodo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Periodo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Periodo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Periodo().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Periodo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tabla_Periodo;
    private javax.swing.JButton btn_actualizar;
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JLabel iconodeUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuPrincipal;
    private javax.swing.JMenuItem jMenuPrincipal1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_NomPer;
    private javax.swing.JLabel lbl_descripcion;
    private javax.swing.JLabel lbl_idPeriodo;
    private javax.swing.JLabel lbl_titulo;
    private javax.swing.JLabel lbl_usuario;
    private javax.swing.JTextField txt_descripcion;
    private javax.swing.JTextField txt_idPeriodo;
    private javax.swing.JTextField txt_periodo;
    // End of variables declaration//GEN-END:variables


    
     private boolean existeidPeriodo() {
        try {
            Statement st = con.createStatement();
            String sql = "Select id_periodo from Periodo where id_periodo = '" + txt_idPeriodo.getText() + "'";
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "El id del período " + txt_idPeriodo.getText() + " ya existe", "El id período ¡Ya existe!.", JOptionPane.INFORMATION_MESSAGE);
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
        int i = Tabla_Periodo.getSelectedRow();
        txt_idPeriodo.setText(Tabla_Periodo.getValueAt(i, 0).toString());
        txt_periodo.setText(Tabla_Periodo.getValueAt(i, 1).toString());
        txt_descripcion.setText(Tabla_Periodo.getValueAt(i, 2).toString());

    }
  

private void rellenar() {
                try {
                    String cap = "";
                    ResultSet rs2 = null;
                  
                            String sql = "SELECT * FROM Periodo where id_periodo='"+var+"' or periodo ='"+var+"'";
                            stmt = con.createStatement();
                            rs2 = stmt.executeQuery(sql);

                            if (rs2.next()) {
                                txt_idPeriodo.setText(rs2.getString("id_periodo"));
                                txt_periodo.setText(rs2.getString("periodo"));
                                txt_descripcion.setText(rs2.getString("descripcion"));
                               
                            } 
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
    }

      public void actualizarDatos() {
        try {
            String sql = "SELECT * FROM Periodo";
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            modelo = new DefaultTableModel(null, titulos);
            Tabla_Periodo.setModel(modelo);
            while (rs.next()) {
                String[] datos = new String[3];
                datos[0] = rs.getString("id_periodo");
                datos[1] = rs.getString("periodo");
                datos[2] =rs.getString("descripcion");
                modelo.addRow(datos);
            }
            TableColumn idP = Tabla_Periodo.getColumn(titulos[0]);
            idP.setMaxWidth(300);
            idP.setIdentifier(ICONIFIED);
            TableColumn Per = Tabla_Periodo.getColumn(titulos[1]);
            Per.setMaxWidth(300);
            TableColumn desc = Tabla_Periodo.getColumn(titulos[2]);
                desc.setMaxWidth(150);
        } catch (Exception e) {
            System.err.println(e);
        }
    }

  private void LimpiarCajas(){
        txt_periodo.setText(null);
        txt_idPeriodo.setText(null);
           txt_descripcion.setText(null);
        
        
        
    }
  
  
    
}
