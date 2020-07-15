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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumn;
import org.apache.commons.codec.digest.DigestUtils;
import sistema_registro.SQL.ConectorSQL;

/**
 *
 * @author William P.
 */
public class TipoUsuario extends javax.swing.JFrame {

 Connection con = null;
    String titulos [] = {"Id Tipo Usuario ", "Tipo Usuario"};
    //String fila [] = new String[2];
    DefaultTableModel modelo =  new DefaultTableModel();
    Statement stmt = null;
    String var, var2;
    
    
    public TipoUsuario() throws SQLException {
        this.con = ConectorSQL.obtenerConexion ();
        initComponents();
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
        lbl_idTipo = new javax.swing.JLabel();
        lbl_TipoUsuario = new javax.swing.JLabel();
        txt_idTipo = new javax.swing.JTextField();
        txt_TipoUsuario = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla_TipoUsuarios = new javax.swing.JTable();
        btn_guardar = new javax.swing.JButton();
        btn_actualizar = new javax.swing.JButton();
        btn_buscar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        cbo_menuprincipal = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbl_titulo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbl_titulo.setText("Tipo de Usuario");

        lbl_idTipo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_idTipo.setText("Id Tipo de Usuario");

        lbl_TipoUsuario.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_TipoUsuario.setText("Tipo de Usuario");

        txt_idTipo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txt_TipoUsuario.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_TipoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_TipoUsuarioActionPerformed(evt);
            }
        });

        Tabla_TipoUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        Tabla_TipoUsuarios.setToolTipText("Presiona consulta para ver todos los empleados");
        Tabla_TipoUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tabla_TipoUsuariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Tabla_TipoUsuarios);

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
        btn_eliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_eliminarMouseClicked(evt);
            }
        });
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });

        jMenu1.setText("File");

        cbo_menuprincipal.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        cbo_menuprincipal.setText("Menu Principal");
        cbo_menuprincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_menuprincipalActionPerformed(evt);
            }
        });
        jMenu1.add(cbo_menuprincipal);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_TipoUsuario)
                            .addComponent(lbl_idTipo))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(txt_idTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txt_TipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(btn_guardar)
                        .addGap(35, 35, 35)
                        .addComponent(btn_actualizar)
                        .addGap(44, 44, 44)
                        .addComponent(btn_buscar)
                        .addGap(42, 42, 42)
                        .addComponent(btn_eliminar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(222, 222, 222)
                        .addComponent(lbl_titulo)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_titulo)
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_idTipo)
                    .addComponent(txt_idTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_TipoUsuario)
                    .addComponent(txt_TipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_guardar)
                    .addComponent(btn_actualizar)
                    .addComponent(btn_buscar)
                    .addComponent(btn_eliminar))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
       public void Actualizar() {

    String cadena1,cadena2;
                      
    
       cadena1 = txt_idTipo.getText();
       cadena2 = txt_TipoUsuario.getText();
    
    
     if (txt_idTipo.getText().equals("")) {

javax.swing.JOptionPane.showMessageDialog(this,"1) Consulte el Id del Usuario \n 2) Actualice el dato deseado en el campo correspondiente","AVISO!",javax.swing.JOptionPane.INFORMATION_MESSAGE);
}
     else {   

     try { 
         stmt = con.createStatement();
   
         stmt.executeUpdate("update ignore Tipo_Usuarios set id_tipoUsuario= '"+cadena1+"', TipoUsuario = '"+cadena2+"'  where id_tipoUsuario='"+txt_idTipo.getText()+"' || TipoUsuario = '"+txt_TipoUsuario.getText()+"'");

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
      
    
 this.txt_idTipo.setText("");
this.txt_TipoUsuario.setText("");
    
}
    }
       

        
       
       public boolean existeUsuario(){
        try {
            Statement st = con.createStatement();
            String sql = "Select id_tipoUsuario from Tipo_Usuarios where id_tipoUsuario = '"+txt_idTipo.getText()+"'";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                JOptionPane.showMessageDialog(null, "Ya existe este Id de Usuario: "+txt_idTipo.getText()+" ", "Id de usuario ¡Ya existe!", JOptionPane.INFORMATION_MESSAGE);
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
       
           private boolean validarLongitud(JTextField texto, int longitud){
       if(texto.getText().length() >= longitud){
           return true;
       }
       else{
           return false;
       }
    }
           
           public void ConsultarDatos(){
        try {
               //String sql = "select * from Tipo_Usuarios where id_tipoUsuario='"+txt_idTipo.getText()+"\'";
               String sql = "SELECT * FROM Tipo_Usuarios where id_tipoUsuario=\'"+txt_idTipo.getText()+"\'";
               stmt = con.createStatement();
               ResultSet rs = stmt.executeQuery(sql);
               
               modelo = new DefaultTableModel(null, titulos);
               Tabla_TipoUsuarios.setModel(modelo);
                 while(rs.next()) {
                     
                          String []datos= new String[2];
                      datos[0] =rs.getString("id_tipoUsuario");
                      datos[1] =rs.getString("Tipo_Usuario");
                      
                                          
                     modelo.addRow(datos);
                      
                      centrar_datos();
                 }
                       TableColumn idTi = Tabla_TipoUsuarios.getColumn(titulos[0]);
            idTi.setMaxWidth(125);
            idTi.setIdentifier(ICONIFIED);
            TableColumn cTU = Tabla_TipoUsuarios.getColumn(titulos[1]);
            cTU.setMaxWidth(165);
        }
        catch (Exception e) {
           
            System.err.println(e);
        }
           }
           
     public void centrar_datos() {
 
        DefaultTableCellRenderer modelocentrar = new DefaultTableCellRenderer();
        modelocentrar.setHorizontalAlignment(SwingConstants.CENTER);
        Tabla_TipoUsuarios.getColumnModel().getColumn(2).setCellRenderer(modelocentrar);
    }
        
     
    
       private void llenarCampos(){
        int i = Tabla_TipoUsuarios.getSelectedRow();
        txt_idTipo.setText(Tabla_TipoUsuarios.getValueAt(i, 1).toString());
        txt_TipoUsuario.setText(Tabla_TipoUsuarios.getValueAt(i, 2).toString());
        
    }
    
    private void cbo_menuprincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_menuprincipalActionPerformed
 
        this.dispose();
        Principal pp;
     try {
         pp = new Principal();
          pp.setVisible(true);
     } catch (SQLException ex) {
         Logger.getLogger(TipoUsuario.class.getName()).log(Level.SEVERE, null, ex);
     }   
    
    }//GEN-LAST:event_cbo_menuprincipalActionPerformed

    private void txt_TipoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_TipoUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_TipoUsuarioActionPerformed

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed

        String cadena1, cadena2;
        cadena1 = txt_idTipo.getText();
        cadena2 = txt_TipoUsuario.getText();

        if ((txt_idTipo.getText().equals("")) || (txt_TipoUsuario.getText().equals(""))  ) {

            javax.swing.JOptionPane.showMessageDialog(this,"¡Debe llenar todos los campos! \n","¡AVISO!",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            txt_idTipo.requestFocus();
            return;
        }

        if(existeUsuario()){
            return;
        }

        if(!validarLongitud(txt_idTipo,1)){
            JOptionPane.showMessageDialog(null, "El Id ingresado tiene que ser de un caracter", "Longitud de los Id", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        if(!validarLongitud(txt_TipoUsuario,5)){
            JOptionPane.showMessageDialog(null, "El Tipo de Usuario es muy corto el mínimo es de 5 caracteres", "Longitud de los Tipo de Usuario", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        try{
            PreparedStatement ps;
            ResultSet rs;

            ps=con.prepareStatement("Insert into Tipo_Usuarios (id_tipoUsuario, Tipo_Usuario)"
                + "                VALUES(?,?)");
            ps.setString(1, txt_idTipo.getText());
            ps.setString(2, txt_TipoUsuario.getText());
            int res= ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se ha guardado la información en Tipo de Usuario");
        } catch ( Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        ConsultarDatos();

    }//GEN-LAST:event_btn_guardarActionPerformed

    private void txt_TipoUsuarioKeyTyped(java.awt.event.KeyEvent evt) {                                          
        if (txt_TipoUsuario.getText().length() >= 35) {
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
    }       
    
    private void txt_idTipoKeyTyped(java.awt.event.KeyEvent evt) {                                      
        if (txt_idTipo.getText().length() >= 4) {
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
            JOptionPane.showMessageDialog(null, "Valido numeros y caracteres");
        }

    }                                     
    
    private void btn_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_actualizarActionPerformed

        String TipoUsuario = txt_idTipo.getText() + " " + txt_TipoUsuario.getText();

        if(JOptionPane.showConfirmDialog(null,"¿Está seguro que desea actualizar el registro del empleado "+TipoUsuario+"?","Confirmación de actualización",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE
        )==JOptionPane.YES_OPTION){
            

            try{
                PreparedStatement ps;
                ResultSet rs;
                ps=con.prepareStatement("Update Tipo_Usuarios "
                    + "set id_tipoUsuario = ?,"
                    + "Tipo_Usuario = ?"
                     + " where id_tipoUsuario =\'"+txt_idTipo.getText()+"\'");
                        
                ps.setString(1, txt_idTipo.getText());
                ps.setString(2, txt_TipoUsuario.getText());

                int res= ps.executeUpdate();
            } catch ( Exception e) {
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_btn_actualizarActionPerformed

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed

        ConsultarDatos();

    }//GEN-LAST:event_btn_buscarActionPerformed

    
    
    private void Tabla_TipoUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tabla_TipoUsuariosMouseClicked
        
          if(Tabla_TipoUsuarios.getSelectedRow () >= 0){
            llenarCampos();
        }
        
    }//GEN-LAST:event_Tabla_TipoUsuariosMouseClicked

    private void btn_buscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_buscarMouseClicked
       
          rellenar();
        this.jScrollPane1.setEnabled(true);
        this.Tabla_TipoUsuarios.setEnabled(true);
        
    }//GEN-LAST:event_btn_buscarMouseClicked

    private void btn_eliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_eliminarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_eliminarMouseClicked

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
        
          String TipoUsuario = txt_TipoUsuario.getText() + " " + txt_idTipo.getText();
        if (JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar el registro de Tipo de Usuario " + TipoUsuario + "", "Confirmación de eliminación",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE
        ) == JOptionPane.YES_OPTION) {
            
            try {
                Statement st2 = con.createStatement();
                String sql = "Delete Tipo_Usuarios " 
                        + "where id_tipoUsuario = (Select id_tipoUsuario from Tipo_Usuarios where Tipo_Usuario = '"+txt_TipoUsuario.getText()+"')";
                
                int rs2 = st2.executeUpdate(sql);
                System.out.println(rs2);
                if(rs2 > 0){ 
                    JOptionPane.showMessageDialog(null, "Se ha borrado la información del Tipo de Usuario " + TipoUsuario + " correctamente");

                  }else {
                      JOptionPane.showMessageDialog(null, "¡Error al eliminar la información!"); 
                      
                  }
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
           

        }
        
    }//GEN-LAST:event_btn_eliminarActionPerformed

    private void limpiar(){
        txt_idTipo.setText(null);
        txt_TipoUsuario.setText(null);
       
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        
            try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TipoUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TipoUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TipoUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TipoUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               try {
                    new TipoUsuario().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(TipoUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            });
        };
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tabla_TipoUsuarios;
    private javax.swing.JButton btn_actualizar;
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JMenuItem cbo_menuprincipal;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_TipoUsuario;
    private javax.swing.JLabel lbl_idTipo;
    private javax.swing.JLabel lbl_titulo;
    private javax.swing.JTextField txt_TipoUsuario;
    private javax.swing.JTextField txt_idTipo;
    // End of variables declaration//GEN-END:variables

 private void rellenar() {
        System.out.println(lbl_idTipo.getText());
        try {
            System.out.println(lbl_TipoUsuario.getText());
            Statement st = con.createStatement();
            String consulta = "Select * from Tipo_Usuarios where id_tipoUsuario = '" + lbl_idTipo.getText() + "'";
            ResultSet rs = st.executeQuery(consulta);
            System.out.println(rs.next());

            if (rs.next()) {
                try {
                    String cap = "";
                    ResultSet rs2 = null;
                   var = JOptionPane.showInputDialog(this, "Ingrese el Tipo de Usuario que desea consultar", "Consulta de Tipo Usuario", JOptionPane.QUESTION_MESSAGE);
                    if (var == null) {
                        JOptionPane.showMessageDialog(this, "La acción fue cancelada", "¡AVISO!", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        if (var.equals("")) {
                            JOptionPane.showMessageDialog(this, "Favor de ingresar los datos del  Tipo de Usuario \n que desea consultar", "¡AVISO!", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            String sql = "SELECT * FROM Tipo_Usuarios where id_tipoUsuario=\'"+txt_idTipo.getText()+"\' ";
                            stmt = con.createStatement();
                            rs2 = stmt.executeQuery(sql);

                            if (rs2.next()) {
                                txt_idTipo.setText(rs2.getString("idTipo"));
                                txt_TipoUsuario.setText(rs2.getString("TipoUsuario"));

                            } else {
                                JOptionPane.showMessageDialog(null, "¡No se encuentra los datos de Tipo Usuario ! Por favor verifique sí, lo escribio correctamente");
                            }

                        }

                    }
                } catch (Exception e) {
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


