/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

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
import sistema_registro.Edificio;
import static org.codehaus.groovy.ast.tools.GeneralUtils.stmt;
import sistema_registro.SQL.ConectorSQL;

/**
 *
 * @author asus
 */
public class EdificioTest {
    Connection con = null;
    Statement stmt = null;
    
    
   public EdificioTest() {
    try{
        this.con = ConectorSQL.obtenerConexion();
    }catch(SQLException ex){
        System.out.println(ex.getMessage());
    }
   
    
}
   
   public void GuardarEdificio(String idEdificio, String NombreEdificio, String Campus){
        
        if((idEdificio.equals(""))){
            javax.swing.JOptionPane.showMessageDialog(null,"Debe ingresar el id del edificio.","Id edifico requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
          if((NombreEdificio.equals(""))){
            javax.swing.JOptionPane.showMessageDialog(null,"Debe ingresar el nombre del edificio.","Nombre edifico requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }
          
           if((Campus.equals(""))){
            javax.swing.JOptionPane.showMessageDialog(null,"Debe ingresar el nombre del edificio.","Nombre edifico requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        if(existeEdificio(idEdificio)){
            return;
        }
        
        
        if(!validarLongitud(idEdificio,1)){
            JOptionPane.showMessageDialog(null, "El id del edificio debe ser de 1 caracter.", "Longitud de id del edificio", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
         
        if(!validarLongitud(NombreEdificio,10)){
            JOptionPane.showMessageDialog(null, "El nombre del edificio es muy corto el mínimo es de 10 caracteres.", "Longitud del nombre del edificio", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        if(!validarLongitud(Campus,4)){
            JOptionPane.showMessageDialog(null, "El código del campus es muy corto el mínimo es de 4 caracteres.", "Longitud del id del campus", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
         if(!validarLongitudMax(idEdificio,1)){
            JOptionPane.showMessageDialog(null, "Número máximo de caracteres permitidos.", "Longitud de id del edificio", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
         
         if(!validarLongitudMax(NombreEdificio,40)){
            JOptionPane.showMessageDialog(null, "Número máximo de caracteres permitidos.", "Longitud de nombre del edificio", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
          if(!validarLongitudMax(Campus,4)){
            JOptionPane.showMessageDialog(null, "Número máximo de caracteres permitidos.", "Longitud del id del campus", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
          
          if(contieneNumero(idEdificio)){
               JOptionPane.showMessageDialog(null, "El id edificio no puede contener números");
               return;
          }
          
           if(contieneNumero(NombreEdificio)){
               JOptionPane.showMessageDialog(null, "El nombre edificio no puede contener números");
               return;
          }
          
        
        
         try{
            PreparedStatement ps;
            ResultSet rs;

            ps=con.prepareStatement("Insert into Edificio (id_edificio, nombre_edificio,id_campus)"
                + "                VALUES(?,?,?)");
            ps.setString(1,idEdificio);
            ps.setString(2,NombreEdificio);
            ps.setString(3, Campus);
         
            
            int res= ps.executeUpdate(); 
            JOptionPane.showMessageDialog(null, "Se ha guardado la información del edificio.");
             } catch ( Exception e) {
            System.out.println(e);
        
             JOptionPane.showMessageDialog(null, e.getMessage());
        }
          
        
   }
   
   public void ActualizarEdificio(String idEdificio, String NombreEdificio, String Campus){
         if((idEdificio.equals(""))){
            javax.swing.JOptionPane.showMessageDialog(null,"Debe ingresar el id del edificio.","Id edifico requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
          if((NombreEdificio.equals(""))){
            javax.swing.JOptionPane.showMessageDialog(null,"Debe ingresar el nombre del edificio.","Nombre edifico requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }
          
           if((Campus.equals(""))){
            javax.swing.JOptionPane.showMessageDialog(null,"Debe ingresar el nombre del edificio.","Nombre edifico requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
         if(!validarLongitud(idEdificio,1)){
            JOptionPane.showMessageDialog(null, "El id del edificio debe ser de 1 caracter.", "Longitud de id del edificio", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
         
        if(!validarLongitud(NombreEdificio,10)){
            JOptionPane.showMessageDialog(null, "El nombre del edificio es muy corto el mínimo es de 10 caracteres.", "Longitud del nombre del edificio", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        if(!validarLongitud(Campus,4)){
            JOptionPane.showMessageDialog(null, "El código del campus es muy corto el mínimo es de 4 caracteres.", "Longitud del id del campus", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
         if(!validarLongitudMax(idEdificio,1)){
            JOptionPane.showMessageDialog(null, "Número máximo de caracteres permitidos.", "Longitud de id del edificio", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
         
         if(!validarLongitudMax(NombreEdificio,40)){
            JOptionPane.showMessageDialog(null, "Número máximo de caracteres permitidos.", "Longitud de nombre del edificio", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
          if(!validarLongitudMax(Campus,4)){
            JOptionPane.showMessageDialog(null, "Número máximo de caracteres permitidos.", "Longitud del id del campus", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
           if(contieneNumero(idEdificio)){
               JOptionPane.showMessageDialog(null, "El id edificio no puede contener números");
               return;
          }
          
           if(contieneNumero(NombreEdificio)){
               JOptionPane.showMessageDialog(null, "El nombre edificio no puede contener números");
               return;
          }
          
          
       
         if(JOptionPane.showConfirmDialog(null, "¿Está seguro que desea actualizar el registro del edificio." +NombreEdificio + "?", "Confirmación de actualización", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE
        ) == JOptionPane.YES_OPTION) {
            
          try {
                PreparedStatement ps;
                ResultSet rs;
                ps = con.prepareStatement("Update Edificio set"
                    + " id_edificio = ? ,"
                    + " nombre_edificio = ? , "
                    + " id_campus = ?  "
                  + " where id_edificio ="+idEdificio+"");
                  ps.setString(1, idEdificio);
                  ps.setString(2, NombreEdificio);
                  ps.setString(3,Campus);
                 int res = ps.executeUpdate();
             JOptionPane.showMessageDialog(null, "Se ha actualizado la información en de la asignatura: " + NombreEdificio);
          } catch (Exception e) {
                System.out.println(e);
                JOptionPane.showMessageDialog(null, "Error al actualizar la informacion del edificio, podria ser por: \n 1.El edificio ya está en uso."
                         + "\n 2. No se encuentra el código del edificio a actualizar.","¡Error al Actuarlizar!", JOptionPane.ERROR_MESSAGE);
            }
   }
   
   
   }
   
   public void EliminarEdificio(String idEdificio, String NombreEdificio, String Campus){
        if ((idEdificio.equals("")) || (NombreEdificio.equals(""))  || (Campus.equals(""))  ) {

            javax.swing.JOptionPane.showMessageDialog(null,"¡Debe seleccionar el edificio que desea eliminar!. \n","¡AVISO!",javax.swing.JOptionPane.INFORMATION_MESSAGE);
           
        }
          else if (JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar el registro del edificio " + NombreEdificio + ".", "Confirmación de eliminación",
            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE
        ) == JOptionPane.YES_OPTION) {

            try {
                Statement st2 = con.createStatement();
                String sql = "Delete Edificio "
                + "where id_edificio = (Select id_edificio from Edificio where nombre_edificio = '"+NombreEdificio+"')";
                int rs2 = st2.executeUpdate(sql);
                System.out.println(rs2);
                if(rs2 > 0){
                    JOptionPane.showMessageDialog(null, "Se ha borrado la información del edificio " + NombreEdificio + " correctamente.");

                }else {
                    JOptionPane.showMessageDialog(null, "¡Error al eliminar la información!.");

                }

            } catch (Exception e) {
               // JOptionPane.showMessageDialog(null, e.getMessage());
                JOptionPane.showMessageDialog(null, "Error al borrar la informacion del edificio, podria ser por: \n 1.El edificio ya está en uso."
                         + "\n 2. No se encuentra el código del edificio a borrar.","¡Error al borrar!", JOptionPane.ERROR_MESSAGE);
            }
   }
   }
   
   public void ConsultarEdificio(String idEdificio, String NombreEdificio, String Campus){
       try {
               
               String sql = "SELECT * FROM Edificio";
               stmt = con.createStatement();
               ResultSet rs = stmt.executeQuery(sql);
               
                 while(rs.next()) {
                     
                      String []datos= new String[3];
                      datos[0] =rs.getString("id_edificio");
                      datos[1] =rs.getString("nombre_edificio");          
                      datos[2] =rs.getString("id_campus");
                      
                      
                     
                 }    
        }
        catch (Exception e) {
           
            System.err.println(e);
        }
   }

       
   

    private boolean existeEdificio(String idEdificio) {
       
        
       
       try {
            Statement st = con.createStatement();
            String sql = "Select id_edificio from Edificio where id_edificio = '"+idEdificio+"'";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                JOptionPane.showMessageDialog(null, "Ya existe este edificio: "+idEdificio+".", "Id Edificio: "+idEdificio+ " ¡Ya existe!.", JOptionPane.INFORMATION_MESSAGE);
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
    //Longitud minima
     private boolean validarLongitud(String texto, int longitud){
       if(texto.length() >= longitud){
           return true;
       }
       else{
           return false;
       }
    
     }
     //Longitud maxima
     private boolean validarLongitudMax(String texto, int longitud){
       if(texto.length() <= longitud){ JOptionPane.showMessageDialog(null, "La unidad valorativa de la asignatura no puede contener letras");
           return true;
       }
       else{
           return false;
       }
    
     }
   
    private boolean contieneNumero(String texto){
          for (int i = 0; i < texto.length(); i++) {
              if(Character.isDigit(texto.charAt(i)))
                  return true;
          }
          return false;
      }
   
     


}
