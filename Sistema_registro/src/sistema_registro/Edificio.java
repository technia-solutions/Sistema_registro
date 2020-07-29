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

        lbl_titulo = new javax.swing.JLabel();
        lbl_nombreEdificio = new javax.swing.JLabel();
        txt_idEdificio = new javax.swing.JTextField();
        lbl_idEdificio = new javax.swing.JLabel();
        txt_nombreEdificio = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla_Edificio = new javax.swing.JTable();
        btn_guardar = new javax.swing.JButton();
        btn_actualizar = new javax.swing.JButton();
        btn_buscar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        lbl_campus = new javax.swing.JLabel();
        cbo_idCampus = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbl_titulo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbl_titulo.setText("Edificio");

        lbl_nombreEdificio.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_nombreEdificio.setText("Nombre del Edificio:");

        txt_idEdificio.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_idEdificio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_idEdificioKeyTyped(evt);
            }
        });

        lbl_idEdificio.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_idEdificio.setText("Id Edificio:");

        txt_nombreEdificio.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_nombreEdificio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_nombreEdificioKeyTyped(evt);
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

        btn_guardar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_guardar.setText("Guardar");
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });

        btn_actualizar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
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
        btn_eliminar.setText("Eliminar");
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });

        lbl_campus.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_campus.setText("Campus:");

        cbo_idCampus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un campus" }));
        cbo_idCampus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_idCampusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(97, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbl_campus)
                            .addComponent(lbl_nombreEdificio)
                            .addComponent(lbl_idEdificio))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(20, 20, 20)
                                    .addComponent(txt_idEdificio, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addComponent(txt_nombreEdificio)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(cbo_idCampus, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_guardar)
                        .addGap(40, 40, 40)
                        .addComponent(btn_actualizar)
                        .addGap(33, 33, 33)
                        .addComponent(btn_buscar)
                        .addGap(37, 37, 37)
                        .addComponent(btn_eliminar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(212, 212, 212)
                        .addComponent(lbl_titulo)))
                .addGap(104, 104, 104))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(lbl_titulo)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_idEdificio)
                    .addComponent(txt_idEdificio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_nombreEdificio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_nombreEdificio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_campus)
                    .addComponent(cbo_idCampus, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_guardar)
                    .addComponent(btn_actualizar)
                    .addComponent(btn_buscar)
                    .addComponent(btn_eliminar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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