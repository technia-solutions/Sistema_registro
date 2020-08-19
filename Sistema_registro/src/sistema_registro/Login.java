/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema_registro;

import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import org.apache.commons.codec.digest.DigestUtils;
import sistema_registro.SQL.ConectorSQL;
/**
 *
 * @author Carlos
 */
public class Login extends javax.swing.JFrame {
    Connection con;
    int intentos = 2;
    /**
     * Creates new form Sistema_registro2
     */
    public Login() throws SQLException {
        setTitle("Login");
        this.con = ConectorSQL.obtenerConexion();
        initComponents();
        this.setLocationRelativeTo(null);
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

        kGradientPanel1 = new keeptoo.KGradientPanel();
        jPanel1 = new javax.swing.JPanel();
        btn_ingresar = new javax.swing.JButton();
        lbl_usuario = new javax.swing.JLabel();
        lbl_contraseña = new javax.swing.JLabel();
        chb_mostrarContraseña = new javax.swing.JCheckBox();
        pwd_contraseña = new javax.swing.JPasswordField();
        txt_usuario = new javax.swing.JTextField();
        lbl_logo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        kGradientPanel1.setkEndColor(new java.awt.Color(0, 153, 53));
        kGradientPanel1.setkStartColor(new java.awt.Color(0, 153, 151));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        btn_ingresar.setBackground(new java.awt.Color(0, 153, 51));
        btn_ingresar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_ingresar.setForeground(new java.awt.Color(255, 255, 255));
        btn_ingresar.setText("Ingresar");
        btn_ingresar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_ingresar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                btn_ingresarFocusGained(evt);
            }
        });
        btn_ingresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_ingresarMouseClicked(evt);
            }
        });
        btn_ingresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ingresarActionPerfomed(evt);
            }
        });

        lbl_usuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/User_Circle2.png"))); // NOI18N

        lbl_contraseña.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/pass.png"))); // NOI18N

        chb_mostrarContraseña.setBackground(new java.awt.Color(255, 255, 255));
        chb_mostrarContraseña.setText("Mostrar contraseña");
        chb_mostrarContraseña.setActionCommand("jCheckBox1");
        chb_mostrarContraseña.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        chb_mostrarContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chb_mostrarContraseñaActionPerformed(evt);
            }
        });

        pwd_contraseña.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pwd_contraseñaKeyTyped(evt);
            }
        });

        txt_usuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_usuarioKeyTyped(evt);
            }
        });

        lbl_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Titulo.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbl_contraseña)
                                .addGap(18, 18, 18)
                                .addComponent(pwd_contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbl_usuario)
                                .addGap(18, 18, 18)
                                .addComponent(txt_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btn_ingresar, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(109, 109, 109))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lbl_logo, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(188, 188, 188))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(chb_mostrarContraseña)
                        .addGap(199, 199, 199))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(lbl_logo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(2, 2, 2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbl_contraseña)
                        .addGap(214, 214, 214))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_usuario))
                        .addGap(19, 19, 19)
                        .addComponent(pwd_contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(chb_mostrarContraseña)
                        .addGap(18, 18, 18)
                        .addComponent(btn_ingresar, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(90, 90, 90))))
        );

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap(242, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(218, 218, 218))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(91, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_ingresarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btn_ingresarFocusGained

    }//GEN-LAST:event_btn_ingresarFocusGained

    private void btn_ingresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ingresarMouseClicked

    }//GEN-LAST:event_btn_ingresarMouseClicked

    private void btn_ingresarActionPerfomed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ingresarActionPerfomed
        try {
            String usuario = txt_usuario.getText();
            String contraseña = String.valueOf(pwd_contraseña.getText());
            String contraseñaEncriptada=DigestUtils.md5Hex(contraseña);
            String sql = "SELECT * from Acceso where nombre_usuario ='" +usuario+ "' and clave_acceso='"+contraseñaEncriptada+"' COLLATE Latin1_General_CS_AS";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            String verificar = "Select estado from acceso where nombre_usuario = '"+usuario+"'";
            Statement stmt = con.createStatement();
            ResultSet r2 = stmt.executeQuery(verificar);
            if(isEmpty()){
                getToolkit().beep();
                JOptionPane.showMessageDialog(null, "Por favor llene todos los campos.", "Ingrese sus datos", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
           if(r2.next()){
              if(r2.getString("estado").equals("Bloqueado")){
                    JOptionPane.showMessageDialog(null, "El usuario: "+usuario+" está bloqueado por favor comuníquese con el administrador.", "Usuario bloqueado", JOptionPane.INFORMATION_MESSAGE);
                    pwd_contraseña.setText("");
                    return;
                }
            }
            
            if(rs.next()){
                if(rs.getString("estado").equals("Bloqueado")){
                    JOptionPane.showMessageDialog(null, "El usuario: "+usuario+" está bloqueado por favor comuníquese con el administrador.", "Usuario bloqueado", JOptionPane.INFORMATION_MESSAGE);
                    pwd_contraseña.setText("");
                    return;
                }
                if(rs.getString("estado").equals("Activo") || rs.getString("estado").equals("Administrador")){
                String sql2 = "Select nombres_empleado + ' ' + apellido_empleado from Empleados where id_empleado = (select id_empleado from Acceso where nombre_usuario = '"+usuario+"')";
                Statement st2 = con.createStatement();
                ResultSet rs2 = st2.executeQuery(sql2);
                        if(rs2.next()){
                        String consul = "update Acceso \n" +
                                        "set intentos = 0\n" +
                                        "where nombre_usuario = '"+txt_usuario.getText()+"'";
                        Statement ss = con.createStatement();
                        int actualizarIntentos = ss.executeUpdate(consul);
                        Principal principal = new Principal(usuario,rs2.getString(1));
                        principal.setVisible(true); 
                        this.dispose();
                        }
                    }
                }
             else{
                    try {
                         String consulta = "SELECT * from Acceso where nombre_usuario ='"+usuario+"'";
                         Statement st3 = con.createStatement();
                         ResultSet rs3 = st3.executeQuery(consulta);
                        if(rs3.next()){
                            if(!rs3.getString("estado").equals("Administrador")){
                                if(rs3.getString("nombre_usuario").equals(usuario)){
                                    getToolkit().beep();
                                    int in = Integer.parseInt(rs3.getString("intentos")) + 1 ;
                                    String sql4 = "update Acceso \n" +
                                                  "set intentos = '"+in+"'\n" +
                                                  "where nombre_usuario = '"+usuario+"' ";
                                    Statement st4 = con.createStatement();
                                    int rs4 = st4.executeUpdate(sql4);
                                    if(rs3.getString("intentos").equals("2")){
                                        Statement st2 = con.createStatement();
                                        String sql2 = "Update Acceso set estado = 'Bloqueado' where nombre_usuario ='"+usuario+"'";
                                        int columnas = st2.executeUpdate(sql2);
                                        JOptionPane.showMessageDialog(null, "El usuario: "+usuario+" ha sido bloqueado por favor comuníquese con el administrador.", "Usuario bloqueado", JOptionPane.INFORMATION_MESSAGE);
                                        this.dispose();
                                        return;
                                    }
                                    int intentosRestantes = intentos - Integer.parseInt(rs3.getString("intentos"));
                                    JOptionPane.showMessageDialog(null, "El nombre de usuario o contraseña no coinciden, todavia tiene "+intentosRestantes+" intentos.", "Las credenciales no concuerdan", JOptionPane.ERROR_MESSAGE);
                                    pwd_contraseña.setText("");
                                }
                             }
                            else{
                            JOptionPane.showMessageDialog(null, "El nombre de usuario o contraseña no coinciden", "Las credenciales no concuerdan", JOptionPane.ERROR_MESSAGE);
                        }
                        
                        }
                         else{
                            JOptionPane.showMessageDialog(null, "El nombre de usuario o contraseña no coinciden", "Las credenciales no concuerdan", JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    }
          /* else{
                 JOptionPane.showMessageDialog(null, "El nombre de usuario o contraseña no coinciden", "Las credenciales no concuerdan", JOptionPane.ERROR_MESSAGE);
            } */

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }

    }//GEN-LAST:event_btn_ingresarActionPerfomed

    private void chb_mostrarContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chb_mostrarContraseñaActionPerformed
        if(chb_mostrarContraseña.isSelected()){
            pwd_contraseña.setEchoChar((char)0);
        }
        else{
            pwd_contraseña.setEchoChar('*');
        }
    }//GEN-LAST:event_chb_mostrarContraseñaActionPerformed

    
    private void txt_usuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_usuarioKeyTyped
    if(txt_usuario.getText().length() >=25){
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Número máximo de caracteres admitidos.");
        }
        char a=evt.getKeyChar();
    }//GEN-LAST:event_txt_usuarioKeyTyped

    private void pwd_contraseñaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pwd_contraseñaKeyTyped
      if(pwd_contraseña.getText().length() >=25){
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Número máximo de caracteres admitidos.");
        }
    }//GEN-LAST:event_pwd_contraseñaKeyTyped

       private boolean isEmpty(){
        if("".equals(txt_usuario.getText()) || "".equals(pwd_contraseña.getText()))
        return true;
        else
            return false;
    }
    
    /**
     * @param args the command line arguments
     */
   
     public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new Login().setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_ingresar;
    private javax.swing.JCheckBox chb_mostrarContraseña;
    private javax.swing.JPanel jPanel1;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JLabel lbl_contraseña;
    private javax.swing.JLabel lbl_logo;
    private javax.swing.JLabel lbl_usuario;
    private javax.swing.JPasswordField pwd_contraseña;
    private javax.swing.JTextField txt_usuario;
    // End of variables declaration//GEN-END:variables
}
