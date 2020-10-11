/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.apache.commons.codec.digest.DigestUtils;
import sistema_registro.Login;
import sistema_registro.Principal;
import sistema_registro.SQL.ConectorSQL;

/**
 *
 * @author Carlos
 */
public class LoginPrueba {
    Connection con;
     int intentos = 2;
    
    public LoginPrueba(){
        try {
            this.con = ConectorSQL.obtenerConexion();
        } catch (SQLException ex) {
            Logger.getLogger(LoginPrueba.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void ingresar(String usuario, String contraseña){
         try {
            String contraseñaEncriptada=DigestUtils.md5Hex(contraseña);
            String sql = "SELECT * from Acceso where nombre_usuario ='" +usuario+ "' and clave_acceso='"+contraseñaEncriptada+"' COLLATE Latin1_General_CS_AS";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            String verificar = "Select estado from acceso where nombre_usuario = '"+usuario+"'";
            Statement stmt = con.createStatement();
            ResultSet r2 = stmt.executeQuery(verificar);
            if(isEmpty(usuario,contraseña)){
                JOptionPane.showMessageDialog(null, "Por favor llene todos los campos.", "Ingrese sus datos", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
           if(r2.next()){
              if(r2.getString("estado").equals("Bloqueado")){
                    JOptionPane.showMessageDialog(null, "El usuario: "+usuario+" está bloqueado por favor comuníquese con el administrador.", "Usuario bloqueado", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
            }
            
            if(rs.next()){
                if(rs.getString("estado").equals("Bloqueado")){
                    JOptionPane.showMessageDialog(null, "El usuario: "+usuario+" está bloqueado por favor comuníquese con el administrador.", "Usuario bloqueado", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                if(rs.getString("estado").equals("Activo") || rs.getString("estado").equals("Administrador")){
                String sql2 = "Select nombres_empleado + ' ' + apellido_empleado from Empleados where id_empleado = (select id_empleado from Acceso where nombre_usuario = '"+usuario+"')";
                Statement st2 = con.createStatement();
                ResultSet rs2 = st2.executeQuery(sql2);
                        if(rs2.next()){
                        String consul = "update Acceso \n" +
                                        "set intentos = 0\n" +
                                        "where nombre_usuario = '"+usuario+"'";
                        Statement ss = con.createStatement();
                        int actualizarIntentos = ss.executeUpdate(consul);
                        Principal principal = new Principal(usuario,rs2.getString(1));
                        principal.setVisible(true);
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
                                        return;
                                    }
                                    int intentosRestantes = intentos - Integer.parseInt(rs3.getString("intentos"));
                                    JOptionPane.showMessageDialog(null, "El nombre de usuario o contraseña no coinciden, todavia tiene "+intentosRestantes+" intentos.", "Las credenciales no concuerdan", JOptionPane.ERROR_MESSAGE);
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
    }
    
    private boolean isEmpty(String usuario, String contraseña){
        if("".equals(usuario) || "".equals(contraseña))
        return true;
        else
            return false;
        }
}
