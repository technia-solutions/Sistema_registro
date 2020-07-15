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
                stmt.executeUpdate("update ignore campus set ID Campus= '" + cadena1 + "' , Nombre Campus = '" + cadena2 + "' where ID Campus= '" + txt_idCampus.getText() + "' || Nombre Campus = '" + txt_NombreCampus.getText() + "' ");
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

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_titulo = new javax.swing.JLabel();
        lbl_idCampus = new javax.swing.JLabel();
        lbl_nombreCampus = new javax.swing.JLabel();
        txt_idCampus = new javax.swing.JTextField();
        txt_NombreCampus = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla_Campus = new javax.swing.JTable();
        btn_guardar = new javax.swing.JButton();
        btn_actualizar = new javax.swing.JButton();
        btn_buscar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbl_titulo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbl_titulo.setText("Campus");

        lbl_idCampus.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_idCampus.setText("ID Campus");

        lbl_nombreCampus.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_nombreCampus.setText("Nombre del Campus");

        txt_idCampus.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_idCampus.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_idCampusKeyTyped(evt);
            }
        });

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(255, 255, 255)
                        .addComponent(lbl_titulo))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_nombreCampus)
                            .addComponent(lbl_idCampus))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(txt_idCampus, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txt_NombreCampus))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(btn_guardar)
                        .addGap(40, 40, 40)
                        .addComponent(btn_actualizar)
                        .addGap(33, 33, 33)
                        .addComponent(btn_buscar)
                        .addGap(37, 37, 37)
                        .addComponent(btn_eliminar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(lbl_titulo)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_idCampus)
                    .addComponent(txt_idCampus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_nombreCampus)
                    .addComponent(txt_NombreCampus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_guardar)
                    .addComponent(btn_actualizar)
                    .addComponent(btn_buscar)
                    .addComponent(btn_eliminar))
                .addContainerGap(91, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        String cadena1, cadena2;
        cadena1 = txt_idCampus.getText();
        cadena2 = txt_NombreCampus.getText();

        if ((txt_idCampus.getText().equals("") || (txt_NombreCampus.getText().equals("")))) {
            JOptionPane.showMessageDialog(this, "¡Debe llenar todos los campos!");
        }

        if (existeCampus()) {
            return;
        }

        if (!validarLongitud(txt_idCampus, 2)) {
            JOptionPane.showMessageDialog(null, "Los nombres ingresados son muy pequeños el mínimo es de 2 caracteres", "Longitud de los nombres", JOptionPane.INFORMATION_MESSAGE);
            return;

        }

        if (!validarLongitud(txt_NombreCampus, 5)) {
            JOptionPane.showMessageDialog(null, "Los nombres ingresados son muy pequeños el mínimo es de 5 caracteres", "Longitud de los nombres", JOptionPane.INFORMATION_MESSAGE);
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
            JOptionPane.showMessageDialog(null, "Se ha guradod la información del campus");
        } catch (Exception e) {
            System.out.println(e);

        }
        actualizarDatos();
    }//GEN-LAST:event_btn_guardarActionPerformed

    private void txt_NombreCampusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_NombreCampusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_NombreCampusActionPerformed

    private void txt_NombreCampusKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_NombreCampusKeyTyped
        if (txt_NombreCampus.getText().length() >= 35) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Número máximo de caracteres admitidos");
        }
        if (evt.getKeyChar() == 8 || evt.getKeyChar() == 127
                || evt.getKeyChar() == 0 || evt.getKeyChar() == 3 || evt.getKeyChar() == 22
                || evt.getKeyChar() == 32 || evt.getKeyChar() == 26 || evt.getKeyChar() == 24) {
            return;
        }
        char a = evt.getKeyChar();
        if (Character.isDigit(a)) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Sólo letras");
        }
    }//GEN-LAST:event_txt_NombreCampusKeyTyped

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

    private void btn_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_actualizarActionPerformed
        String nombreCampus = txt_NombreCampus.getText() + " ";
        
        if (JOptionPane.showConfirmDialog(null, "¿Está seguro que desea actualizar el registro del empleado " + nombreCampus + "?", "Confirmación de actualización", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE
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
           
        }
        
       
    }//GEN-LAST:event_btn_actualizarActionPerformed

    private void Tabla_CampusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tabla_CampusMouseClicked
        if (Tabla_Campus.getSelectedRow() >= 0) {
            llenarCampos();
        }
    }//GEN-LAST:event_Tabla_CampusMouseClicked

    private void btn_buscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_buscarMouseClicked
        rellenar();
        this.jScrollPane1.setEnabled(true);
        this.Tabla_Campus.setEnabled(true);
    }//GEN-LAST:event_btn_buscarMouseClicked

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed

        actualizarDatos(); 
    }//GEN-LAST:event_btn_buscarActionPerformed

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
        String nombreCampus = txt_NombreCampus.getText() + " " + txt_idCampus.getText();
        if (JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar el registro de campus " + nombreCampus + "", "Confirmación de eliminación",
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
            

        }
    }//GEN-LAST:event_btn_eliminarActionPerformed

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
                centrar_datos();
            }
            TableColumn idC = Tabla_Campus.getColumn(titulos[0]);
            idC.setMaxWidth(125);
            idC.setIdentifier(ICONIFIED);
            TableColumn cn = Tabla_Campus.getColumn(titulos[1]);
            cn.setMaxWidth(205);
        } catch (Exception e) {
           /* JOptionPane.showMessageDialog(null, e.getMessage());*/
            System.err.println(e);
        }
    }

    public void centrar_datos() {
        DefaultTableCellRenderer modelocentrar = new DefaultTableCellRenderer();
        modelocentrar.setHorizontalAlignment(SwingConstants.CENTER);
        Tabla_Campus.getColumnModel().getColumn(1).setCellRenderer(modelocentrar);
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
    private javax.swing.JTable Tabla_Campus;
    private javax.swing.JButton btn_actualizar;
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_idCampus;
    private javax.swing.JLabel lbl_nombreCampus;
    private javax.swing.JLabel lbl_titulo;
    private javax.swing.JTextField txt_NombreCampus;
    private javax.swing.JTextField txt_idCampus;
    // End of variables declaration//GEN-END:variables

    private boolean existeCampus() {
        try {
            Statement st = con.createStatement();
            String sql = "Select id_campus from Campus where nombre_campus = '" + txt_NombreCampus.getText() + "'";
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "El nombre campus: " + txt_NombreCampus.getText() + " ya existe", "El campus ¡Ya existe!", JOptionPane.INFORMATION_MESSAGE);
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
        System.out.println(lbl_idCampus.getText());
        try {
            System.out.println(lbl_nombreCampus.getText());
            Statement st = con.createStatement();
            String consulta = "Select * from Campus where id_campus = '" + lbl_idCampus.getText() + "'";
            ResultSet rs = st.executeQuery(consulta);
            System.out.println(rs.next());

            if (rs.next()) {
                try {
                    String cap = "";
                    ResultSet rs2 = null;
                   var = JOptionPane.showInputDialog(this, "Ingrese el campus que desea consultar", "Consulta el campus", JOptionPane.QUESTION_MESSAGE);
                    if (var == null) {
                        JOptionPane.showMessageDialog(this, "La acción fue cancelada", "¡AVISO!", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        if (var.equals("")) {
                            JOptionPane.showMessageDialog(this, "Favor de ingresar los datos del campus\n que desea consultar", "¡AVISO!", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            String sql = "SELECT * FROM Campus where id_campus=\'"+txt_idCampus.getText()+"\' ";
                            stmt = con.createStatement();
                            rs2 = stmt.executeQuery(sql);

                            if (rs2.next()) {
                                txt_idCampus.setText(rs2.getString("id_campus"));
                                txt_NombreCampus.setText(rs2.getString("nombre_campus"));

                            } else {
                                JOptionPane.showMessageDialog(null, "¡No se encuentra el campus! Por favor verifique sí, lo escribio correctamente");
                            }

                        }

                    }
                } catch (HeadlessException | SQLException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            } else {
               /* JOptionPane.showMessageDialog(null, "¡Sólo los administradores tienen acceso a esta función!");*/
            }

        } catch (SQLException ex) {
            Logger.getLogger(Campus.class.getName()).log(Level.SEVERE, null, ex);
        }

    
    }

}
