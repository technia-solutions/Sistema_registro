/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import sistema_registro.Empleado;
import sistema_registro.SQL.ConectorSQL;
/**
 *
 * @author Carlos
 */
public class TipoUsuarioPrueba {
     Connection con = null;
     
     public TipoUsuarioPrueba(){
         try {
             this.con = ConectorSQL.obtenerConexion();
         } catch (SQLException ex) {
             System.out.println(ex.getMessage());
         }
     }
     
     public static void main(String args[]){
         new TipoUsuarioPrueba().guardarTipoUsuario("T","Tecnicosss");
         new TipoUsuarioPrueba().buscarTipoUsuario();
     }
     
     public void guardarTipoUsuario(String idTipoUsuario, String nombreTipoUsuario){
         
       
       
        if((idTipoUsuario.equals(""))){
            javax.swing.JOptionPane.showMessageDialog(null,"Debe ingresar el id del tipo de usuario.","Id tipo usuario requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
         if((nombreTipoUsuario.equals(""))){
            javax.swing.JOptionPane.showMessageDialog(null,"Debe ingresar el nombre del tipo de usuario.","Nombre tipo usuario requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        
        if(existeUsuario(nombreTipoUsuario)){
            return;
        }
        
        if(existeidUsuario(idTipoUsuario)){
            return;
        }

        if(!validarLongitud(idTipoUsuario,1)){
            JOptionPane.showMessageDialog(null, "El Id ingresado tiene que ser de un caracter", "Longitud de los Id", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        if(!validarLongitud(nombreTipoUsuario,5)){
            JOptionPane.showMessageDialog(null, "El Tipo de Usuario es muy corto el mínimo es de 5 caracteres", "Longitud de los Tipo de Usuario", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        if (!validarLongitudMax(idTipoUsuario, 1)) {
            JOptionPane.showMessageDialog(null, "El id ingresado es muy grande el máximo es de 1 caracteres, usted ingresó " + idTipoUsuario.length() + " caracteres.", "Longitud de id facultad", JOptionPane.INFORMATION_MESSAGE);
            return;

        }
        if (!validarLongitudMax(nombreTipoUsuario, 20)) {
            JOptionPane.showMessageDialog(null, "El nombre del tipo de usuario ingresado es muy grande el máximo es de 20 caracteres, usted ingresó " + nombreTipoUsuario.length() + " caracteres.", "Longitud de id facultad", JOptionPane.INFORMATION_MESSAGE);
            return;

        }
        
        if(contieneNumeros(idTipoUsuario)){
            JOptionPane.showMessageDialog(null, "El id del tipo de usuario no puede contener números");
            return;
        }
        
        if(contieneNumeros(nombreTipoUsuario)){
            JOptionPane.showMessageDialog(null, "El nombre del tipo de usuario no puede contener números");
            return;
        }
        

        try{
            PreparedStatement ps;
            ResultSet rs;

            ps=con.prepareStatement("Insert into Tipo_Usuarios (id_tipoUsuario, Tipo_Usuario)"
                + "                VALUES(?,?)");
            ps.setString(1, idTipoUsuario);
            ps.setString(2, nombreTipoUsuario);
            int res= ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se ha guardado la información en Tipo de Usuario");
        } catch ( Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
     }
     
     public void actualizarTipoUsuario(String idTipoUsuario, String nombreTipoUsuario){
         
         
         if ((idTipoUsuario.equals("")) || (nombreTipoUsuario.equals(""))) {
            
            javax.swing.JOptionPane.showMessageDialog(null,"¡Debe seleccionar el tipo usuario a actualizar! \n","¡AVISO!",javax.swing.JOptionPane.INFORMATION_MESSAGE);
           
        }
         
         if(!validarLongitud(idTipoUsuario,1)){
            JOptionPane.showMessageDialog(null, "El Id ingresado tiene que ser de un caracter", "Longitud de los Id", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
         
         if(!validarLongitud(nombreTipoUsuario,5)){
            JOptionPane.showMessageDialog(null, "El Tipo de Usuario es muy corto el mínimo es de 5 caracteres", "Longitud de los Tipo de Usuario", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
         
          if (!validarLongitudMax(idTipoUsuario, 1)) {
            JOptionPane.showMessageDialog(null, "El id ingresado es muy grande el máximo es de 1 caracteres, usted ingresó " + idTipoUsuario.length() + " caracteres.", "Longitud de id tipo de usuario", JOptionPane.INFORMATION_MESSAGE);
            return;

        }
        if (!validarLongitudMax(nombreTipoUsuario, 20)) {
            JOptionPane.showMessageDialog(null, "El nombre del tipo de usuario ingresado es muy grande el máximo es de 20 caracteres, usted ingresó " + nombreTipoUsuario.length() + " caracteres.", "Longitud de nombre del tipo de usuario", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        if(contieneNumeros(nombreTipoUsuario)){
            JOptionPane.showMessageDialog(null, "El nombre del tipo de usuario no puede contener números");
            return;
        }
        
        if(contieneNumeros(idTipoUsuario)){
            JOptionPane.showMessageDialog(null, "El id del tipo de usuario no puede contener números");
            return;
        }
        
      

       else if(JOptionPane.showConfirmDialog(null,"¿Está seguro que desea actualizar el registro del empleado "+nombreTipoUsuario+"?","Confirmación de actualización",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE
        )==JOptionPane.YES_OPTION){
            

            try{
                PreparedStatement ps;
                ResultSet rs;
                ps=con.prepareStatement("Update Tipo_Usuarios "
                    + "set id_tipoUsuario = ?,"
                    + "Tipo_Usuario = ?"
                     + " where id_tipoUsuario =\'"+idTipoUsuario+"\'");
                        
                ps.setString(1, idTipoUsuario);
                ps.setString(2, nombreTipoUsuario);
                int res= ps.executeUpdate();
            } catch ( Exception e) {
                System.out.println(e);
                              JOptionPane.showMessageDialog(null, "No se ha realizado la actualización por: \n 1.El tipo de usuario ya fue definido."
                         + "\n 2. No se encuentra el id del tipo usuario a actualizar.","¡Error al Actualizar!", JOptionPane.ERROR_MESSAGE);
            }
        }
     }
     
     public void eliminarTipoUsuario(String idTipoUsuario,String nombreTipoUsuario){
           
           if ((nombreTipoUsuario.equals(""))) {
            
            javax.swing.JOptionPane.showMessageDialog(null,"¡Debe seleccionar el tipo usuario a eliminar! \n","¡AVISO!",javax.swing.JOptionPane.INFORMATION_MESSAGE);
           
        }
          
       else if (JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar el registro de Tipo de Usuario " + nombreTipoUsuario + "", "Confirmación de eliminación",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE
        ) == JOptionPane.YES_OPTION) {
            
            try {
                 if (!existeidUsuario(idTipoUsuario)) {
                    JOptionPane.showMessageDialog(null, "El id del tipo de usuario: " + idTipoUsuario + " no existe");
                    return;
                }
                if (!existeUsuario(nombreTipoUsuario)) {
                    JOptionPane.showMessageDialog(null, "El tipo de usuario: " + nombreTipoUsuario + " no existe");
                    return;
                }
                Statement st2 = con.createStatement();
                String sql = "Delete Tipo_Usuarios " 
                        + "where id_tipoUsuario = '"+idTipoUsuario+"'";
                
                int rs2 = st2.executeUpdate(sql);
                System.out.println(rs2);
                if(rs2 > 0){ 
                    JOptionPane.showMessageDialog(null, "Se ha borrado la información del Tipo de Usuario " + nombreTipoUsuario + " correctamente");

                  }else {
                      JOptionPane.showMessageDialog(null, "¡Error al eliminar la información!"); 
                      
                  }
                
            } catch (Exception e) {
                //JOptionPane.showMessageDialog(null, e.getMessage());
                JOptionPane.showMessageDialog(null, "Error al borrar la información, podría ser por: \n 1.Tipo de Usuario ya está definido."
                         + "\n 2. No se encuentra el id del tipo usuario a borrar.","¡Error al Borrar!", JOptionPane.ERROR_MESSAGE);
            }
        }
     }
     
    public void buscarTipoUsuario(){
        try {
           String sql = "SELECT * FROM Tipo_Usuarios";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
               String []datos= new String[2];
                      datos[0] =rs.getString("id_tipoUsuario");
                      datos[1] =rs.getString("Tipo_Usuario"); 
                System.out.println("Id Tipo de Usuario: " + datos[0] +" - "+"Nombre Tipo de Usuario: " + datos[1]);
            }
        } catch (Exception e) {
           /* JOptionPane.showMessageDialog(null, e.getMessage());*/
            System.err.println(e);
        }
    }
     
        private boolean existeUsuario(String nombreTipoUsuario){
        try {
            Statement st = con.createStatement();
            String sql = "Select Tipo_Usuario from Tipo_Usuarios where Tipo_Usuario = '"+nombreTipoUsuario+"'";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                JOptionPane.showMessageDialog(null, "Ya existe este nombre de Usuario: "+nombreTipoUsuario+" ", "Nombre de usuario ¡Ya existe!", JOptionPane.INFORMATION_MESSAGE);
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
       
       private boolean existeidUsuario(String idTipoUsuario){
        try {
            Statement st = con.createStatement();
            String sql = "Select id_tipoUsuario from Tipo_Usuarios where id_tipoUsuario = '"+idTipoUsuario+"'";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                JOptionPane.showMessageDialog(null, "Ya existe este Id de Usuario: "+idTipoUsuario+" ", "Id de usuario ¡Ya existe!", JOptionPane.INFORMATION_MESSAGE);
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
       
       private boolean validarLongitud(String texto, int longitud) {
        if (texto.length() >= longitud) {
            return true;
        } else {
            return false;
        }
    }
       
 
      private boolean validarLongitudMax(String texto, int longitud) {
        if (texto.length() <= longitud) {
            return true;
        } else {
            return false;
        }
    }
       private boolean contieneNumeros(String texto){
          for (int i = 0; i < texto.length(); i++) {
              if(Character.isDigit(texto.charAt(i)))
                  return true;
          }
          return false;
      }
     
}
