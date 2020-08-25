/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema_registro;

import codigo.Conexion_consulta;
import static java.awt.Frame.ICONIFIED;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import sistema_registro.SQL.ConectorSQL;

/**
 *
 * @author Genesis & Willliam P 
 */
public class RequisitoAsignatura extends javax.swing.JFrame {
     String titulos[] = {"Id Requisitos", "Asignatura Requisito", "Id Carrera"};
    DefaultTableModel modelo = new DefaultTableModel();
    Connection con = null;
    Statement stmt = null;
    String var, var2;


    /**
     * Creates new form RequisitoAsignatura
     */
    public RequisitoAsignatura() throws SQLException {
        initComponents();
        ArrayList<String> lista = new ArrayList<String>();
             lista = new Conexion_consulta().llenar_combo2();
            for(int i = 0; i<lista.size();i++){
                cbo_idCarrera.addItem(lista.get(i));
            }
           
        this.con = ConectorSQL.obtenerConexion();
        actualizarDatos(); 
        this.setTitle("Asignatura Requisito");
         this.setIconImage(new ImageIcon(getClass().getResource("/Imagenes/Titulo.png")).getImage());
          this.btn_eliminar.setEnabled(false);
          this.btn_actualizar1.setEnabled(false);
          this.lbl_ReqA.setVisible(false);
           this.setLocationRelativeTo(null);
               
         
         
    }
    
    public RequisitoAsignatura(String nombreUsuario) throws SQLException {
        initComponents();
        ArrayList<String> lista = new ArrayList<String>();
             lista = new Conexion_consulta().llenar_combo2();
            for(int i = 0; i<lista.size();i++){
                cbo_idCarrera.addItem(lista.get(i));
            }
           
        this.con = ConectorSQL.obtenerConexion();
        actualizarDatos(); 
        this.setTitle("Asignatura Requisito");
         this.setIconImage(new ImageIcon(getClass().getResource("/Imagenes/Titulo.png")).getImage());
         this.lbl_usuario.setText(nombreUsuario);
          this.btn_eliminar.setEnabled(false);
          this.btn_actualizar1.setEnabled(false);
          this.setLocationRelativeTo(null);
         
         
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btn_guardar = new javax.swing.JButton();
        btn_actualizar1 = new javax.swing.JButton();
        btn_buscar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        lbl_idCarrera = new javax.swing.JLabel();
        lbl_idReqAs = new javax.swing.JLabel();
        txt_idReqAsig = new javax.swing.JTextField();
        lbl_NombreReqAs = new javax.swing.JLabel();
        cbo_idCarrera = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla_ReqAsignatura = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtA_NombreReqAsig = new javax.swing.JTextArea();
        btn_limpiar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lbl_titulo = new javax.swing.JLabel();
        lbl_ReqA = new javax.swing.JLabel();
        lbl_usuario = new javax.swing.JLabel();
        iconodeUsuario = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(215, 236, 233));

        btn_guardar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/botton_Guardar.png"))); // NOI18N
        btn_guardar.setText("Guardar");
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });

        btn_actualizar1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_actualizar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/botton_Actualizar.png"))); // NOI18N
        btn_actualizar1.setText("Actualizar");
        btn_actualizar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_actualizar1ActionPerformed(evt);
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

        lbl_idCarrera.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_idCarrera.setText("Id Carrera:");

        lbl_idReqAs.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_idReqAs.setText("Id  Asignatura:");

        txt_idReqAsig.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_idReqAsig.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_idReqAsigFocusLost(evt);
            }
        });
        txt_idReqAsig.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_idReqAsigKeyTyped(evt);
            }
        });

        lbl_NombreReqAs.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_NombreReqAs.setText(" Requisito Asignatura:");

        cbo_idCarrera.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una carrera:" }));

        Tabla_ReqAsignatura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Requisito", "Asignatura requisito", "Id Carrera"
            }
        ));
        Tabla_ReqAsignatura.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tabla_ReqAsignaturaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Tabla_ReqAsignatura);

        txtA_NombreReqAsig.setColumns(3);
        txtA_NombreReqAsig.setLineWrap(true);
        txtA_NombreReqAsig.setRows(5);
        txtA_NombreReqAsig.setWrapStyleWord(true);
        txtA_NombreReqAsig.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtA_NombreReqAsigKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(txtA_NombreReqAsig);

        btn_limpiar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_limpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/botton_Limpiar.png"))); // NOI18N
        btn_limpiar.setText("Limpiar");
        btn_limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_eliminar, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                    .addComponent(btn_limpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(191, 191, 191)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_idCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(cbo_idCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 736, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_actualizar1)
                    .addComponent(btn_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(lbl_NombreReqAs, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_idReqAs, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(170, 170, 170)
                                .addComponent(txt_idReqAsig, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_idReqAs)
                            .addComponent(txt_idReqAsig, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(lbl_NombreReqAs, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_guardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_actualizar1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_buscar)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_limpiar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_eliminar)
                        .addGap(34, 34, 34))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(lbl_idCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cbo_idCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(70, 70, 70)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 172, 870, 443));

        jPanel2.setBackground(new java.awt.Color(232, 251, 249));

        lbl_titulo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbl_titulo.setText("Requisito Asignatura");

        lbl_ReqA.setText("jLabel2");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(316, 316, 316)
                .addComponent(lbl_titulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 158, Short.MAX_VALUE)
                .addComponent(lbl_ReqA)
                .addGap(146, 146, 146))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_titulo)
                    .addComponent(lbl_ReqA))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 104, -1, -1));

        lbl_usuario.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_usuario.setText("Nombre Usuario");
        getContentPane().add(lbl_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(118, 41, 190, -1));

        iconodeUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/User.png"))); // NOI18N
        getContentPane().add(iconodeUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 11, 50, 70));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/imagen 3.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 920, 648));

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/boton_retroceder.png"))); // NOI18N
        jMenu1.setText("Regresar");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/books_3025.png"))); // NOI18N
        jMenuItem1.setText("Asignaturas");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Tabla_ReqAsignaturaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tabla_ReqAsignaturaMouseClicked
        if(Tabla_ReqAsignatura.getSelectedRow() >= 0){
            llenarCampos();
           
        }
    }//GEN-LAST:event_Tabla_ReqAsignaturaMouseClicked

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        String cadena1, cadena2, cadena3;
        cadena1 = txt_idReqAsig.getText();
        cadena2 = txtA_NombreReqAsig.getText();
        String id_facultad = cbo_idCarrera.getSelectedItem().toString().substring(0, 4);
        
        if((txt_idReqAsig.getText().equals(""))){
            javax.swing.JOptionPane.showMessageDialog(this,"Debe ingresar el código de la asignatura requisito.","Código asignatura requisito requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            txt_idReqAsig.requestFocus();
            return;
        }
          
        if((txtA_NombreReqAsig.getText().equals(""))){
            javax.swing.JOptionPane.showMessageDialog(this,"Debe ingresar el nombre de la asignatura requisito.","Nombre asignatura requisito requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            txtA_NombreReqAsig.requestFocus();
            return;
        }
        
         if((cbo_idCarrera.getSelectedItem().equals("Seleccione una carrera"))){
            javax.swing.JOptionPane.showMessageDialog(this,"Debe seleccionar una carrera para la asignatura requisito","Carrera de la asignatura requisito requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        

        if (existeRequisitoAsignatura()) {
            return;
        }
        
        if (existeidRequisitoAsignatura()) {
            return;
        }

        if (!validarLongitud(txt_idReqAsig, 4)) {
            JOptionPane.showMessageDialog(null, "El id para la asignatura requisito ingresado es muy pequeño, el mínimo es de 4 caracteres", "Longitud de id la asignatura requisito", JOptionPane.INFORMATION_MESSAGE);
            return;

        }

        if (!validarLongitud(txtA_NombreReqAsig,7)) {
            JOptionPane.showMessageDialog(null, "El  nombre de la asignatura requisito ingresado es muy pequeño, el mínimo es de 7 caracteres", "Longitud de nombre de la asignatura requisito", JOptionPane.INFORMATION_MESSAGE);
            return;

        }

        try {
            PreparedStatement ps;
            ResultSet rs;
            ps = con.prepareStatement("INSERT INTO Requisito_Asignatura (id_asignatura, RequisitoAsignatura,id_carrera)"
                + "                VALUES(?,?,?)");
            ps.setString(1, txt_idReqAsig.getText());
            ps.setString(2, txtA_NombreReqAsig.getText());
            ps.setString(3, id_facultad);
            int res = ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se ha guardado la información de la asignatura requisito");
        } catch (Exception e) {
            System.out.println(e);

        }

        actualizarDatos();
        LimpiarCajas();
    }//GEN-LAST:event_btn_guardarActionPerformed

    private void btn_actualizar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_actualizar1ActionPerformed

        String nombreAsignaturaRequisito = txtA_NombreReqAsig.getText() + " ";
        if ((txt_idReqAsig.getText().equals("")) || (txtA_NombreReqAsig.getText().equals("")) ||
            (cbo_idCarrera.getSelectedItem().equals("Seleccione la asignatura requisito"))) {

            javax.swing.JOptionPane.showMessageDialog(this,"¡Debe seleccionar la asignatura requisito a actualizar! \n","¡AVISO!",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            txtA_NombreReqAsig.requestFocus();
            return;
        }
        else if(JOptionPane.showConfirmDialog(null, "¿Está seguro que desea actualizar el registro de la asignatura requisito" + nombreAsignaturaRequisito + "?", "Confirmación de actualización", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE
        ) == JOptionPane.YES_OPTION) {
            String id_carrera = cbo_idCarrera.getSelectedItem().toString().substring(0, 3);
            try {
                PreparedStatement ps;
                ResultSet rs;
                ps = con.prepareStatement("Update Requisito_Asignatura set"
                    + " RequisitoAsignatura = ? ,"
                    + " id_asignatura = ? "
                    + " where id_asignatura =\'"+lbl_ReqA.getText()+"\'");

                ps.setString(1, txtA_NombreReqAsig.getText());
                ps.setString(2, txt_idReqAsig.getText());
                /* ps.setString(3, id_facultad);*/
                 this.btn_eliminar.setEnabled(false);
                 this.btn_actualizar1.setEnabled(false);
                 this.btn_guardar.setEnabled(true);
                int res = ps.executeUpdate();
            } catch (Exception e) {
                System.out.println(e);
            }

        }
        actualizarDatos();
        LimpiarCajas();
    }//GEN-LAST:event_btn_actualizar1ActionPerformed

    private void btn_buscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_buscarMouseClicked
        rellenar();
        this.jScrollPane1.setEnabled(true);
        this.Tabla_ReqAsignatura.setEnabled(true);
    }//GEN-LAST:event_btn_buscarMouseClicked

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
        actualizarDatos();
    }//GEN-LAST:event_btn_buscarActionPerformed

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
        String nombreAsignaturaRequisito = txtA_NombreReqAsig.getText();

        if ((txt_idReqAsig.getText().equals("")) || (txtA_NombreReqAsig.getText().equals("")) ||
            (cbo_idCarrera.getSelectedItem().equals("Seleccione la asignatura requisito"))) {

            javax.swing.JOptionPane.showMessageDialog(this,"¡Debe seleccionar la asignatura requisito a eliminar! \n","¡AVISO!",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            
            
        }
        else if(JOptionPane.showConfirmDialog(null,"¿Está seguro que desea eliminar el registro de la asignatura requisito "+nombreAsignaturaRequisito+"","Confirmación de eliminación",
            JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE
        )==JOptionPane.YES_OPTION){
            String id_carrera = cbo_idCarrera.getSelectedItem().toString().substring(0, 3);
            try{
                PreparedStatement ps;
                ResultSet rs;
                ps=con.prepareStatement("Delete Requisito_Asignatura "
                    + "where id_asignatura = (Select id_asignatura from Requisito_Asignatura   where RequisitoAsignatura = '"+txtA_NombreReqAsig.getText()+"')");
                this.btn_eliminar.setEnabled(false);
                 this.btn_actualizar1.setEnabled(false);
                 this.btn_guardar.setEnabled(true);
                int res= ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Se ha borrado la información de la asignatura requisito "+nombreAsignaturaRequisito+" correctamente");
                if(res > 0){
                }else {
                    JOptionPane.showMessageDialog(null, "¡Error al eliminar la información!");
                }
            } catch ( Exception e) {
                System.out.println(e);
            }
        }
        actualizarDatos();
        LimpiarCajas();
    }//GEN-LAST:event_btn_eliminarActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        
         this.dispose();
        Asignaturas a = null;
         try {
             a = new Asignaturas(lbl_usuario.getText());
         } catch (SQLException ex) {
             Logger.getLogger(Carrera.class.getName()).log(Level.SEVERE, null, ex);
         }
        a.setVisible(true);
        
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void txt_idReqAsigKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_idReqAsigKeyTyped
           if (txt_idReqAsig.getText().length() >= 6) {
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
    }//GEN-LAST:event_txt_idReqAsigKeyTyped

    private void txt_idReqAsigFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_idReqAsigFocusLost
        String id = txt_idReqAsig.getText();
        String upper = id.toUpperCase();
        txt_idReqAsig.setText(upper); 
    }//GEN-LAST:event_txt_idReqAsigFocusLost

    private void txtA_NombreReqAsigKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtA_NombreReqAsigKeyTyped

         if (txtA_NombreReqAsig.getText().length() >= 50) {
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
            if(txtA_NombreReqAsig.getText().length() == 0){
                evt.consume();
                Toolkit.getDefaultToolkit().beep();
                return;
            }
            if(txtA_NombreReqAsig.getText().substring(txtA_NombreReqAsig.getText().length() - 1).equals(" ")){
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

        
       
    }//GEN-LAST:event_txtA_NombreReqAsigKeyTyped

    private void btn_limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limpiarActionPerformed
        LimpiarCajas();
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_limpiarActionPerformed

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
            java.util.logging.Logger.getLogger(RequisitoAsignatura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RequisitoAsignatura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RequisitoAsignatura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RequisitoAsignatura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new RequisitoAsignatura().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(RequisitoAsignatura.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tabla_ReqAsignatura;
    private javax.swing.JButton btn_actualizar1;
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_limpiar;
    private javax.swing.JComboBox<String> cbo_idCarrera;
    private javax.swing.JLabel iconodeUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_NombreReqAs;
    private javax.swing.JLabel lbl_ReqA;
    private javax.swing.JLabel lbl_idCarrera;
    private javax.swing.JLabel lbl_idReqAs;
    private javax.swing.JLabel lbl_titulo;
    private javax.swing.JLabel lbl_usuario;
    private javax.swing.JTextArea txtA_NombreReqAsig;
    private javax.swing.JTextField txt_idReqAsig;
    // End of variables declaration//GEN-END:variables

    
    private boolean existeRequisitoAsignatura() {
        try {
            Statement st = con.createStatement();
            String sql = "Select RequisitoAsignatura from Requisito_Asignatura where RequisitoAsignatura = '" + txtA_NombreReqAsig.getText() + "'";
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "El nombre de la asignatura requisito." + txtA_NombreReqAsig.getText() + " ya existe", "La asignatura requisito ¡Ya existe!.", JOptionPane.INFORMATION_MESSAGE);
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Campus.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
     private boolean existeidRequisitoAsignatura() {
        try {
            Statement st = con.createStatement();
            String sql = "Select id_asignatura from Requisito_Asignatura where id_asignatura = '" + txt_idReqAsig.getText() + "'";
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "El id de la asignatura requisito. " + txt_idReqAsig.getText() + " ya existe", "El id asignatura requisito ¡Ya existe!.", JOptionPane.INFORMATION_MESSAGE);
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Campus.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }


    private boolean validarLongitud(JTextArea texto, int longitud) {
        if (texto.getText().length() >= longitud) {
            return true;
        } else {
            return false;
        }
    }
    
    private boolean validarLongitud( JTextField texto, int longitud) {
        if (texto.getText().length() >= longitud) {
            return true;
        } else {
            return false;
        }
    }

    private void llenarCampos() {
        int i = Tabla_ReqAsignatura.getSelectedRow();
        txt_idReqAsig.setText(Tabla_ReqAsignatura.getValueAt(i, 0).toString());
        txtA_NombreReqAsig.setText(Tabla_ReqAsignatura.getValueAt(i, 1).toString());
        cbo_idCarrera.setSelectedItem(Tabla_ReqAsignatura.getValueAt(i, 2).toString());
         lbl_ReqA.setText(Tabla_ReqAsignatura.getValueAt(i, 0).toString());
        this.btn_eliminar.setEnabled(true);
        this.btn_actualizar1.setEnabled(true);
        this.btn_guardar.setEnabled(false);

    }
  

private void rellenar() {
                try {
                    String cap = "";
                    ResultSet rs2 = null;
                   
                            String sql = "SELECT * FROM Requisito_Asignatura as a join Carrera as c on c.id_carrera = a.id_carrera  where id_asignatura='"+var+"' or RequisitoAsignatura ='"+var+"'";
                            stmt = con.createStatement();
                            rs2 = stmt.executeQuery(sql);

                            if (rs2.next()) {
                                txt_idReqAsig.setText(rs2.getString("id_asignatura"));
                                txtA_NombreReqAsig.setText(rs2.getString("RequisitoAsignatura"));
                               cbo_idCarrera.setSelectedItem(rs2.getString("id_carrera")+ " - " + rs2.getString("nombre_carrera"));
                            } else {
                                JOptionPane.showMessageDialog(null, "¡No se encuentra los datos: "+var+" ! Por favor verifique sí, lo escribio correctamente");
                            }
                        

                    
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
    }

      public void actualizarDatos() {
        try {
            String sql = "SELECT * FROM Requisito_Asignatura";
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            modelo = new DefaultTableModel(null, titulos);
            Tabla_ReqAsignatura.setModel(modelo);
            while (rs.next()) {
                String[] datos = new String[3];
                datos[0] = rs.getString("id_asignatura");
                datos[1] = rs.getString("RequisitoAsignatura");
                datos[2] =rs.getString("id_carrera");
                modelo.addRow(datos);
            }
            TableColumn ida = Tabla_ReqAsignatura.getColumn(titulos[0]);
            ida.setMaxWidth(300);
            ida.setIdentifier(ICONIFIED);
            TableColumn nRA = Tabla_ReqAsignatura.getColumn(titulos[1]);
            nRA.setMaxWidth(300);
            TableColumn cidc = Tabla_ReqAsignatura.getColumn(titulos[2]);
                cidc.setMaxWidth(150);
        } catch (Exception e) {
           /* JOptionPane.showMessageDialog(null, e.getMessage());*/
            System.err.println(e);
        }
    }

  private void LimpiarCajas(){
        txtA_NombreReqAsig.setText(null);
        txt_idReqAsig.setText(null);
        cbo_idCarrera.setSelectedIndex(0);
        this.btn_eliminar.setEnabled(false);
        this.btn_actualizar1.setEnabled(false);
        this.btn_guardar.setEnabled(true);
        
        
        
    }



}
