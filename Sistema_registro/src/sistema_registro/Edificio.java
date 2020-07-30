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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import sistema_registro.SQL.ConectorSQL;

/**
 *
 * @author asus
 */
public class Edificio extends javax.swing.JFrame {
    
    Connection con=null;
     String titulos [] = {"Id Edificio", "Nombre de Edificio", "Id Campus"};
     Statement stmt = null;
     DefaultTableModel modelo =  new DefaultTableModel();
    String var;

    /**
     * Creates new form Edificio
     */
    public Edificio() throws SQLException {
         this.con = ConectorSQL.obtenerConexion();
         initComponents();
        ArrayList<String> lista = new ArrayList<String>();
             lista = new Conexion_consulta().llenar_combo();
            for(int i = 0; i<lista.size();i++){
                cbo_idCampus.addItem(lista.get(i));
            }
             this.setLocationRelativeTo(null);
            this.setTitle("Edificios");
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

        btn_guardar = new javax.swing.JButton();
        btn_actualizar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lbl_titulo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btn_buscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla_Edificio = new javax.swing.JTable();
        txt_nombreEdificio = new javax.swing.JTextField();
        txt_idEdificio = new javax.swing.JTextField();
        cbo_idCampus = new javax.swing.JComboBox<>();
        lbl_idEdificio = new javax.swing.JLabel();
        lbl_nombreEdificio = new javax.swing.JLabel();
        lbl_campus = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_guardar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/botton_Guardar.png"))); // NOI18N
        btn_guardar.setText("Guardar");
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 145, 160, -1));

        btn_actualizar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_actualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/botton_Actualizar.png"))); // NOI18N
        btn_actualizar.setText("Actualizar");
        btn_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_actualizarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 194, 160, -1));

        btn_eliminar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/botton_Eliminar.png"))); // NOI18N
        btn_eliminar.setText("Eliminar");
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 258, 160, -1));

        jPanel1.setBackground(new java.awt.Color(232, 251, 249));

        lbl_titulo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbl_titulo.setText("Edificio");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(335, Short.MAX_VALUE)
                .addComponent(lbl_titulo)
                .addGap(302, 302, 302))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_titulo)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 710, 60));

        jPanel2.setBackground(new java.awt.Color(215, 236, 233));

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

        Tabla_Edificio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Edificio", "Edificio", "Campus"
            }
        ));
        Tabla_Edificio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tabla_EdificioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Tabla_Edificio);

        txt_nombreEdificio.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_nombreEdificio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nombreEdificioActionPerformed(evt);
            }
        });
        txt_nombreEdificio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_nombreEdificioKeyTyped(evt);
            }
        });

        txt_idEdificio.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_idEdificio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_idEdificioKeyTyped(evt);
            }
        });

        cbo_idCampus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un campus" }));
        cbo_idCampus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_idCampusActionPerformed(evt);
            }
        });

        lbl_idEdificio.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_idEdificio.setText("Id Edificio:");

        lbl_nombreEdificio.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_nombreEdificio.setText("Nombre del Edificio:");

        lbl_campus.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_campus.setText("Campus:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(btn_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(229, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbl_idEdificio)
                            .addComponent(lbl_nombreEdificio)
                            .addComponent(lbl_campus))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbo_idCampus, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txt_idEdificio, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_nombreEdificio, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(79, 79, 79))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(76, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_idEdificio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_idEdificio))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_nombreEdificio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_nombreEdificio))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbo_idCampus, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_campus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_buscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 710, 380));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/imagen 3.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 530));

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/boton_retroceder.png"))); // NOI18N
        jMenu1.setText("Regresar");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Aula.png"))); // NOI18N
        jMenuItem1.setText("Aula");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbo_idCampusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_idCampusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbo_idCampusActionPerformed

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
          
        String cadena1, cadena2;
        cadena1 = txt_idEdificio.getText();
        cadena2 = txt_nombreEdificio.getText();
        String id_campus = cbo_idCampus.getSelectedItem().toString().substring(0, 4);
        

        if ((txt_idEdificio.getText().equals("")) || (txt_nombreEdificio.getText().equals("")) 
                ||  (cbo_idCampus.getSelectedItem().equals("Seleccione una asignatura"))) {

            javax.swing.JOptionPane.showMessageDialog(this,"¡Debe llenar todos los campos! \n","¡AVISO!",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            txt_idEdificio.requestFocus();
            return;
        }

        if(existeEdificio()){
            return;
        }

        if(!validarLongitud(txt_idEdificio,1)){
            JOptionPane.showMessageDialog(null, "El id del edificio debe ser de 1 caracter", "Longitud de id del edificio", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        if(!validarLongitud(txt_nombreEdificio,10)){
            JOptionPane.showMessageDialog(null, "El Nombre de la asignatura es muy corto el mínimo es de 10 caracteres", "Longitud del nombre de asignatura", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
       
         
        

        try{
            PreparedStatement ps;
            ResultSet rs;

            ps=con.prepareStatement("Insert into Edificio (id_edificio, nombre_edificio,id_campus)"
                + "                VALUES(?,?,?)");
            ps.setString(1, txt_idEdificio.getText());
            ps.setString(2, txt_nombreEdificio.getText());
            ps.setString(3, id_campus);
         
            
            int res= ps.executeUpdate(); 
            JOptionPane.showMessageDialog(null, "Se ha guardado la información en Registro de edificio.");
             } catch ( Exception e) {
            System.out.println(e);
        
             JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        actualizarDatos();
        LimpiarCajas();
        
    }//GEN-LAST:event_btn_guardarActionPerformed

    private void btn_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_actualizarActionPerformed
      String nombreEdificio = txt_nombreEdificio.getText() + " ";
        if ((txt_idEdificio.getText().equals("")) || (txt_nombreEdificio.getText().equals("")) ||
            (cbo_idCampus.getSelectedItem().equals("Seleccione el campus"))) {

            javax.swing.JOptionPane.showMessageDialog(this,"¡Debe seleccionar el edificio a actualizar! \n","¡AVISO!",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            txt_nombreEdificio.requestFocus();
            return;
        }
        else if(JOptionPane.showConfirmDialog(null, "¿Está seguro que desea actualizar el registro del edificio" +nombreEdificio + "?", "Confirmación de actualización", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE
        ) == JOptionPane.YES_OPTION) {
            String id_campus = cbo_idCampus.getSelectedItem().toString().substring(0, 4);
            
            try {
                PreparedStatement ps;
                ResultSet rs;
                ps = con.prepareStatement("Update Edificio set"
                    + " id_edificio = ? ,"
                    + " nombre_edificio = ? , "
                    + " id_campus = ?  "
                  + " where id_edificio =\'"+txt_idEdificio.getText()+"\'");
                  ps.setString(1, txt_idEdificio.getText());
                  ps.setString(2, txt_nombreEdificio.getText());
                  ps.setString(3,id_campus);
                    
             int res = ps.executeUpdate();
            } catch (Exception e) {
                System.out.println(e);
            }
            
            actualizarDatos();
            LimpiarCajas();

        
        }
    }//GEN-LAST:event_btn_actualizarActionPerformed

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
        actualizarDatos();
    }//GEN-LAST:event_btn_buscarActionPerformed

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
       String Edificio = txt_idEdificio.getText() + " " + txt_nombreEdificio.getText();
          
           if ((txt_idEdificio.getText().equals("")) || (txt_nombreEdificio.getText().equals(""))  || (cbo_idCampus.getSelectedItem().equals(""))  ) {

            javax.swing.JOptionPane.showMessageDialog(this,"¡Debe seleccionar el edificio que desea eliminar! \n","¡AVISO!",javax.swing.JOptionPane.INFORMATION_MESSAGE);
           
        }
          else if (JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar el registro del edificio " + Edificio + "", "Confirmación de eliminación",
            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE
        ) == JOptionPane.YES_OPTION) {

            try {
                Statement st2 = con.createStatement();
                String sql = "Delete Edificio "
                + "where id_edificio = (Select id_edificio from Edificio where nombre_edificio = '"+txt_nombreEdificio.getText()+"')";

                int rs2 = st2.executeUpdate(sql);
                System.out.println(rs2);
                if(rs2 > 0){
                    JOptionPane.showMessageDialog(null, "Se ha borrado la información del edificio " + Edificio + " correctamente");

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

    private void txt_idEdificioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_idEdificioKeyTyped
       
        if (txt_idEdificio.getText().length() >= 2) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Número máximo de caracteres admitidos");
        }
        char a=evt.getKeyChar();
            if (evt.getKeyChar() == 8 || evt.getKeyChar() == 127 || 
                 evt.getKeyChar() == 0 || evt.getKeyChar() == 3 || evt.getKeyChar() == 22 
                 || evt.getKeyChar() == 26 || evt.getKeyChar() == 24 ) {
        return;
        }
         if(Character.isDigit(a) || !Character.isLetterOrDigit(a)){
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Sólo letras");
        }
    }//GEN-LAST:event_txt_idEdificioKeyTyped

    private void txt_nombreEdificioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nombreEdificioKeyTyped
       if (txt_nombreEdificio.getText().length() >= 40) {
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
             if(txt_nombreEdificio.getText().length() == 0){
                 evt.consume();
                 Toolkit.getDefaultToolkit().beep();
                 return;
             }
             if(txt_nombreEdificio.getText().substring(txt_nombreEdificio.getText().length() - 1).equals(" ")){
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
    }//GEN-LAST:event_txt_nombreEdificioKeyTyped

    private void Tabla_EdificioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tabla_EdificioMouseClicked
       if(Tabla_Edificio.getSelectedRow () >= 0){
            llenarCampos();
        }
    }//GEN-LAST:event_Tabla_EdificioMouseClicked

    private void btn_buscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_buscarMouseClicked
           rellenar();
        this.jScrollPane1.setEnabled(true);
        this.Tabla_Edificio.setEnabled(true);
    }//GEN-LAST:event_btn_buscarMouseClicked

    private void txt_nombreEdificioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nombreEdificioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nombreEdificioActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        Aula aa = null;
        try {
            aa = new Aula();
        } catch (SQLException ex) {
            Logger.getLogger(Aula.class.getName()).log(Level.SEVERE, null, ex);
        }
        aa.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

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
            java.util.logging.Logger.getLogger(Edificio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Edificio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Edificio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Edificio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Edificio().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Edificio.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tabla_Edificio;
    private javax.swing.JButton btn_actualizar;
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JComboBox<String> cbo_idCampus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_campus;
    private javax.swing.JLabel lbl_idEdificio;
    private javax.swing.JLabel lbl_nombreEdificio;
    private javax.swing.JLabel lbl_titulo;
    private javax.swing.JTextField txt_idEdificio;
    private javax.swing.JTextField txt_nombreEdificio;
    // End of variables declaration//GEN-END:variables

    private boolean existeEdificio() {
      try {
            Statement st = con.createStatement();
            String sql = "Select id_edificio from Edificio where id_edificio = '"+txt_idEdificio.getText()+"'";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                JOptionPane.showMessageDialog(null, "Ya existe esta Asignatura: "+txt_idEdificio.getText()+" ", "Codigo de asignatura ¡Ya existe!", JOptionPane.INFORMATION_MESSAGE);
                return true;
            }
            else{
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Edificio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
       
       private boolean validarLongitud(JTextField texto, int longitud){
       if(texto.getText().length() >= longitud){
           return true;
       }
       else{
           return false;
       }
    }

    private void actualizarDatos() {
        try {
               
               String sql = "SELECT * FROM Edificio";
               stmt = con.createStatement();
               ResultSet rs = stmt.executeQuery(sql);
               modelo = new DefaultTableModel(null, titulos);
               Tabla_Edificio.setModel(modelo);
                 while(rs.next()) {
                     
                          String []datos= new String[3];
                      datos[0] =rs.getString("id_edificio");
                      datos[1] =rs.getString("nombre_edificio");          
                      datos[2] =rs.getString("id_campus");
                      
                      
                     modelo.addRow(datos);
                      
                      centrar_datos();
                 }
            TableColumn TaRA = Tabla_Edificio.getColumn(titulos[0]);
            TaRA.setMaxWidth(300);
            TableColumn cRA= Tabla_Edificio.getColumn(titulos[1]);
            cRA.setMaxWidth(300);
            TableColumn idC= Tabla_Edificio.getColumn(titulos[2]);
           idC.setMaxWidth(300);
         
        }
        catch (Exception e) {
           
            System.err.println(e);
        }
    }

    private void centrar_datos() {
        
        DefaultTableCellRenderer modelocentrar = new DefaultTableCellRenderer();
        modelocentrar.setHorizontalAlignment(SwingConstants.CENTER);
         for (int i = 0; i <modelo.getRowCount(); i++) {
              Tabla_Edificio.getColumnModel().getColumn(i).setCellRenderer(modelocentrar);
             
         }
    }
    
    
       private void rellenar(){
      try {
                    String cap = "";
                    ResultSet rs2 = null;
                   var = JOptionPane.showInputDialog(this, "Ingrese el nombre del edificio que desea consultar", "Consulta del edificio", JOptionPane.QUESTION_MESSAGE);
                    if (var == null) {
                        JOptionPane.showMessageDialog(this, "La acción fue cancelada", "¡AVISO!", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        if (var.equals("")) {
                            JOptionPane.showMessageDialog(this, "Favor de ingresar el nombre del edificio \n que desea consultar", "¡AVISO!", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            String sql = "SELECT * FROM Edifcio where id_edificio='"+var+"' or nombre_edificio ='"+var+"'";
                            stmt = con.createStatement();
                            rs2 = stmt.executeQuery(sql);

                            if (rs2.next()) {
                                txt_idEdificio.setText(rs2.getString("id_edificio"));
                                txt_nombreEdificio.setText(rs2.getString("nombre_edificio"));
                               cbo_idCampus.setSelectedItem((rs2.getString("id_campus") + " - " + rs2.getString("nombre_campus")));
                               
                                
                            } else {
                                JOptionPane.showMessageDialog(null, "¡No se encuentra los datos: "+var+" ! Por favor verifique sí, lo escribio correctamente");
                            }
                        }

                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
    
    }

    private void LimpiarCajas() {
       
        txt_idEdificio.setText(null);
        txt_nombreEdificio.setText(null);
        cbo_idCampus.setSelectedIndex(0);
        
       
    }

    private void llenarCampos() {
      int i = Tabla_Edificio.getSelectedRow();
        txt_idEdificio.setText(Tabla_Edificio.getValueAt(i, 0).toString());
        txt_nombreEdificio.setText(Tabla_Edificio.getValueAt(i, 1).toString());
        cbo_idCampus.setSelectedItem(Tabla_Edificio.getValueAt(i, 2).toString());
     
    }


    
}
