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
public class Facultad extends javax.swing.JFrame {
     String titulos[] = {"Id Facultad", "Nombre Facultad"};
    DefaultTableModel modelo = new DefaultTableModel();
    Connection con = null;
    Statement stmt = null;
    String var, var2;

    /**
     * Creates new form Facultad
     */
    public Facultad() throws SQLException {
        initComponents();
         this.con = ConectorSQL.obtenerConexion();
         //actualizarDatos(); 
         this.setTitle("Facultad");
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

        txt_idfacultad = new javax.swing.JTextField();
        txt_NombreFacultad = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla_Facultad = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btn_guardar = new javax.swing.JButton();
        btn_actualizar = new javax.swing.JButton();
        btn_buscar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        lbl_nombreFacultad = new javax.swing.JLabel();
        lbl_idfacultad = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lbl_titulo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        Carrera = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_idfacultad.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_idfacultad.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_idfacultadFocusLost(evt);
            }
        });
        txt_idfacultad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_idfacultadKeyTyped(evt);
            }
        });
        getContentPane().add(txt_idfacultad, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 150, 180, -1));

        txt_NombreFacultad.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_NombreFacultad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_NombreFacultadActionPerformed(evt);
            }
        });
        txt_NombreFacultad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_NombreFacultadKeyTyped(evt);
            }
        });
        getContentPane().add(txt_NombreFacultad, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 210, 182, -1));

        Tabla_Facultad.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Facultad", "Facultad"
            }
        ));
        Tabla_Facultad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tabla_FacultadMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Tabla_Facultad);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 270, -1, 142));

        jPanel1.setBackground(new java.awt.Color(215, 236, 233));
        jPanel1.setLayout(null);

        btn_guardar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/botton_Guardar.png"))); // NOI18N
        btn_guardar.setText("Guardar");
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_guardar);
        btn_guardar.setBounds(24, 55, 160, 41);

        btn_actualizar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_actualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/botton_Actualizar.png"))); // NOI18N
        btn_actualizar.setText("Actualizar");
        btn_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_actualizarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_actualizar);
        btn_actualizar.setBounds(24, 107, 159, 41);

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
        jPanel1.add(btn_buscar);
        btn_buscar.setBounds(24, 159, 160, 41);

        btn_eliminar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/botton_Eliminar.png"))); // NOI18N
        btn_eliminar.setText("Eliminar");
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_eliminar);
        btn_eliminar.setBounds(24, 211, 160, 41);

        lbl_nombreFacultad.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_nombreFacultad.setText("Facultad:");
        jPanel1.add(lbl_nombreFacultad);
        lbl_nombreFacultad.setBounds(340, 90, 71, 22);

        lbl_idfacultad.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_idfacultad.setText("ID Facultad:");
        jPanel1.add(lbl_idfacultad);
        lbl_idfacultad.setBounds(310, 30, 96, 22);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 830, 340));

        jPanel2.setBackground(new java.awt.Color(232, 251, 249));

        lbl_titulo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbl_titulo.setText("Facultad");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(354, 354, 354)
                .addComponent(lbl_titulo)
                .addContainerGap(387, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(lbl_titulo)
                .addContainerGap())
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 830, 60));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/imagen 3.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 920, 500));

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/boton_retroceder.png"))); // NOI18N
        jMenu1.setText("Regresar");

        Carrera.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        Carrera.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/mortarboard_icon-icons.com_64579.png"))); // NOI18N
        Carrera.setText("Carrera");
        Carrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CarreraActionPerformed(evt);
            }
        });
        jMenu1.add(Carrera);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_buscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_buscarMouseClicked
       rellenar();
    }//GEN-LAST:event_btn_buscarMouseClicked

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed

        actualizarDatos();
    }//GEN-LAST:event_btn_buscarActionPerformed

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
        String nombreFacultad = txt_NombreFacultad.getText() + " " + txt_idfacultad.getText();
         if ((txt_idfacultad.getText().equals("") || (txt_NombreFacultad.getText().equals("")))) {
            JOptionPane.showMessageDialog(this, "¡Debe seleccionar la facultad que desea eliminar!");
        }
         else if (JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar el registro de facultad " + nombreFacultad + "", "Confirmación de eliminación",
            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE
        ) == JOptionPane.YES_OPTION) {

            try {
                Statement st2 = con.createStatement();
                String sql = "Delete Facultad "
                + "where id_facultad = (Select id_facultad from Facultad where nombre_facultad = '"+txt_NombreFacultad.getText()+"')";

                int rs2 = st2.executeUpdate(sql);
                System.out.println(rs2);
                if(rs2 > 0){
                    JOptionPane.showMessageDialog(null, "Se ha borrado la información de la facultad " + nombreFacultad + " correctamente");

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

    private void txt_idfacultadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_idfacultadKeyTyped
        if (txt_idfacultad.getText().length() >= 3) {
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
    }//GEN-LAST:event_txt_idfacultadKeyTyped

    private void txt_NombreFacultadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_NombreFacultadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_NombreFacultadActionPerformed

    private void txt_NombreFacultadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_NombreFacultadKeyTyped
        if (txt_NombreFacultad.getText().length() >= 40) {
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
             if(txt_NombreFacultad.getText().length() == 0){
                 evt.consume();
                 Toolkit.getDefaultToolkit().beep();
                 return;
             }
             if(txt_NombreFacultad.getText().substring(txt_NombreFacultad.getText().length() - 1).equals(" ")){
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
    }//GEN-LAST:event_txt_NombreFacultadKeyTyped

    private void Tabla_FacultadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tabla_FacultadMouseClicked
        if (Tabla_Facultad.getSelectedRow() >= 0) {
           llenarCampos();        }
    }//GEN-LAST:event_Tabla_FacultadMouseClicked

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        String cadena1, cadena2;
        cadena1 = txt_idfacultad.getText();
        cadena2 = txt_NombreFacultad.getText();

         
        if((txt_NombreFacultad.getText().equals(""))){
            javax.swing.JOptionPane.showMessageDialog(this,"Debe ingresar el id de la facultad.","Id facultad requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            txt_NombreFacultad.requestFocus();
            return;
        }
        
        if((txt_NombreFacultad.getText().equals(""))){
            javax.swing.JOptionPane.showMessageDialog(this,"Debe ingresar el nombre de la facultad.","Nombre facultad requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            txt_NombreFacultad.requestFocus();
            return;
        }
        

        if (existeFacultad()) {
            return;
        }
        
        if (existeidFacultad()) {
            return;
        }

        if (!validarLongitud(txt_idfacultad, 2)) {
            JOptionPane.showMessageDialog(null, "El id  ingresados es muy pequeño el mínimo es de 2 caracteres", "Longitud de id facultad", JOptionPane.INFORMATION_MESSAGE);
            return;

        }

        if (!validarLongitud(txt_NombreFacultad, 15)) {
            JOptionPane.showMessageDialog(null, "El nombre facultad ingresado es muy pequeños el mínimo es de 15 caracteres", "Longitud de  nombre facultad", JOptionPane.INFORMATION_MESSAGE);
            return;

        }

        try {
            PreparedStatement ps;
            ResultSet rs;
            ps = con.prepareStatement("INSERT INTO Facultad (id_facultad, nombre_facultad)"
                + "                VALUES(?,?)");
            ps.setString(1, txt_idfacultad.getText());
            ps.setString(2, txt_NombreFacultad.getText());
            int res = ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se ha guradod la información de la facultad");
        } catch (Exception e) {
            System.out.println(e);

        }
        actualizarDatos();
        LimpiarCajas();
    }//GEN-LAST:event_btn_guardarActionPerformed

    private void btn_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_actualizarActionPerformed
        String nombreCampus = txt_NombreFacultad.getText() + " ";
         
        if ((txt_idfacultad.getText().equals("") || (txt_NombreFacultad.getText().equals("")))) {
            JOptionPane.showMessageDialog(this, "¡Debe seleccionar la facultad que desea actualizar!");
        }

       else if (JOptionPane.showConfirmDialog(null, "¿Está seguro que desea actualizar el registro de facultad " + nombreCampus + "?", "Confirmación de actualización", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE
        ) == JOptionPane.YES_OPTION) {
            try {
                PreparedStatement ps;
                ResultSet rs;
                ps = con.prepareStatement("Update Facultad set"
                    + " nombre_facultad = ? ,"
                    + "id_facultad = ? "
                    + " where id_facultad =\'"+txt_idfacultad.getText()+"\'");
                /*ps.setString(1, txt_NombreCampus.getText());*/
                ps.setString(1, txt_NombreFacultad.getText());
                ps.setString(2, txt_idfacultad.getText());
                int res = ps.executeUpdate();
            } catch (Exception e) {
                System.out.println(e);
            }
            
            actualizarDatos();
            LimpiarCajas();
        }

    }//GEN-LAST:event_btn_actualizarActionPerformed

    private void CarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CarreraActionPerformed
        
          this.dispose();
       Carrera cc;
         try {
             cc = new Carrera();
             cc.setVisible(true);
         } catch (SQLException ex) {
             Logger.getLogger(Facultad.class.getName()).log(Level.SEVERE, null, ex);
         }
        
        
        
    }//GEN-LAST:event_CarreraActionPerformed

    private void txt_idfacultadFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_idfacultadFocusLost
          String id = txt_idfacultad.getText();
        String upper = id.toUpperCase();
        txt_idfacultad.setText(upper); 
    }//GEN-LAST:event_txt_idfacultadFocusLost

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
            java.util.logging.Logger.getLogger(Facultad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Facultad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Facultad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Facultad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Facultad().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Facultad.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Carrera;
    private javax.swing.JTable Tabla_Facultad;
    private javax.swing.JButton btn_actualizar;
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_idfacultad;
    private javax.swing.JLabel lbl_nombreFacultad;
    private javax.swing.JLabel lbl_titulo;
    private javax.swing.JTextField txt_NombreFacultad;
    private javax.swing.JTextField txt_idfacultad;
    // End of variables declaration//GEN-END:variables
 public void actualizarDatos() {
        try {
            String sql = "SELECT * FROM Facultad";
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            modelo = new DefaultTableModel(null, titulos);
            Tabla_Facultad.setModel(modelo);
            while (rs.next()) {
                String[] datos = new String[2];
                datos[0] = rs.getString("id_facultad");
                datos[1] = rs.getString("nombre_facultad");
                modelo.addRow(datos);
            }
            TableColumn idf = Tabla_Facultad.getColumn(titulos[0]);
            idf.setMaxWidth(150);
            idf.setIdentifier(ICONIFIED);
            TableColumn fn = Tabla_Facultad.getColumn(titulos[1]);
            fn.setMaxWidth(300);
        } catch (Exception e) {
           /* JOptionPane.showMessageDialog(null, e.getMessage());*/
            System.err.println(e);
        }
    }

    public void centrar_datos() {
        DefaultTableCellRenderer modelocentrar = new DefaultTableCellRenderer();
        modelocentrar.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i <modelo.getRowCount(); i++) {
              Tabla_Facultad.getColumnModel().getColumn(i).setCellRenderer(modelocentrar);
             
         }
    }

   
               

    private boolean existeFacultad() {
        try {
            Statement st = con.createStatement();
            String sql = "Select nombre_facultad from Facultad where nombre_facultad = '" + txt_NombreFacultad.getText() + "'";
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "El nombre facultad: " + txt_NombreFacultad.getText() + " ya existe", "La facultad ¡Ya existe!.", JOptionPane.INFORMATION_MESSAGE);
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Facultad.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
      private boolean existeidFacultad() {
        try {
            Statement st = con.createStatement();
            String sql = "Select id_facultad from Facultad where id_facultad = '" + txt_idfacultad.getText() + "'";
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "El id facultad: " + txt_idfacultad.getText() + " ya existe", "El id facultad ¡Ya existe!.", JOptionPane.INFORMATION_MESSAGE);
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Facultad.class.getName()).log(Level.SEVERE, null, ex);
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
        int i = Tabla_Facultad.getSelectedRow();
        txt_idfacultad.setText(Tabla_Facultad.getValueAt(i, 0).toString());
        txt_NombreFacultad.setText(Tabla_Facultad.getValueAt(i, 1).toString());

    }
  

private void rellenar() {
                try {
                    String cap = "";
                    ResultSet rs2 = null;
                  
                            String sql = "SELECT * FROM Facultad where id_facultad='"+var+"' or nombre_facultad ='"+var+"'";
                            stmt = con.createStatement();
                            rs2 = stmt.executeQuery(sql);

                            if (rs2.next()) {
                                txt_idfacultad.setText(rs2.getString("id_facultad"));
                                txt_NombreFacultad.setText(rs2.getString("nombre_facultad"));
                            }
                            
                        

                    
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
    }

  private void LimpiarCajas(){
        txt_NombreFacultad.setText(null);
        txt_idfacultad.setText(null);
      
        
    }



}
