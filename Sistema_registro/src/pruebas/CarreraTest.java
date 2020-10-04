/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import static java.awt.Frame.ICONIFIED;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import sistema_registro.Carrera;
import sistema_registro.SQL.ConectorSQL;

/**
 *
 * @author asus
 */
public class CarreraTest {
     Connection con = null;
    Statement stmt = null;
    String NombreCarrera;
    String idCarrera;
   public CarreraTest() {
    try{
        this.con = ConectorSQL.obtenerConexion();
    }catch(SQLException ex){
        System.out.println(ex.getMessage());
    }
   }
   
   public void GuardarCarrera(String idCarrera,String NombreCarrera,String Facultad){
       if((idCarrera.equals(""))){
            javax.swing.JOptionPane.showMessageDialog(null,"Debe ingresar el id de la carrera.","Id carrera requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        if((NombreCarrera.equals(""))){
            javax.swing.JOptionPane.showMessageDialog(null,"Debe ingresar el nombre de la carrera.","Nombre carrera requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
          
        if((Facultad.equals("Seleccione una facultad"))){
            javax.swing.JOptionPane.showMessageDialog(null,"Debe seleccionar una facultad para la carrea","Facultad de la carrera requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
         if (existeCarrera()) {
            return;
        }
        
          if (existeidCarrera()) {
            return;
        }
          
         if (!validarLongitud(idCarrera, 4)) {
            JOptionPane.showMessageDialog(null, "El id ingresado es muy pequeños el mínimo es de 4 caracteres", "Longitud de id carrera", JOptionPane.INFORMATION_MESSAGE);
            return;

        }

        if (!validarLongitud(NombreCarrera,10)) {
            JOptionPane.showMessageDialog(null, "El  nombre ingresado es muy pequeño el mínimo es de 10 caracteres", "Longitud de nombre carrera", JOptionPane.INFORMATION_MESSAGE);
            return;

        }
        
          if (!validarLongitud(Facultad,2)) {
            JOptionPane.showMessageDialog(null, "El  nombre de facultad ingresado es muy pequeños el mínimo es de 3 caracteres", "Longitud de nombre facultad", JOptionPane.INFORMATION_MESSAGE);
            return;

        }
        
           if (!validarLongitudMax(idCarrera, 4)) {
            JOptionPane.showMessageDialog(null, "Número máximo de caracteres admitidos", "Longitud de id carrera", JOptionPane.INFORMATION_MESSAGE);
            return;

        }

        if (!validarLongitudMax(NombreCarrera,100 )) {
            JOptionPane.showMessageDialog(null, "Número máximo de caracteres admitidos", "Longitud de nombre carrera", JOptionPane.INFORMATION_MESSAGE);
            return;

        }
        
          if (!validarLongitudMax(Facultad,3)) {
            JOptionPane.showMessageDialog(null, "Número máximo de caracteres admitidos", "Longitud de nombre facultad", JOptionPane.INFORMATION_MESSAGE);
            return;

        }
          
        if (contieneLetrayNumeros(Facultad)) {
           return;
       }
         
         if(contieneLetra(NombreCarrera)){
             return;
         }
         
         if(contieneLetrayNumeros(idCarrera)){
             return;
         }
    
      try {
            PreparedStatement ps;
            ResultSet rs;
            ps = con.prepareStatement("INSERT INTO Carrera (id_carrera, nombre_carrera,id_facultad)"
                + "                VALUES(?,?,?)");
            ps.setString(1, idCarrera);
            ps.setString(2, NombreCarrera);
            ps.setString(3, Facultad);
            int res = ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se ha guradado la información del carrera");
        } catch (Exception e) {
            System.out.println(e);

        }
   }
   
   public void ActualizarCarrera(String idCarrera, String NombreCarrera, String Facultad){
               
      
          if((idCarrera.equals(""))){
            javax.swing.JOptionPane.showMessageDialog(null,"Debe ingresar el id de la carrera.","Id carrera requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        if((NombreCarrera.equals(""))){
            javax.swing.JOptionPane.showMessageDialog(null,"Debe ingresar el nombre de la carrera.","Nombre carrera requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
          
        if((Facultad.equals("Seleccione una facultad"))){
            javax.swing.JOptionPane.showMessageDialog(null,"Debe seleccionar una facultad para la carrea","Facultad de la carrera requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }
            else if(JOptionPane.showConfirmDialog(null, "¿Está seguro que desea actualizar el registro de carrera" +NombreCarrera + "?", "Confirmación de actualización", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE
        ) == JOptionPane.YES_OPTION) {
                String Carrera = null;
          
            try {
                PreparedStatement ps;
                ResultSet rs;
                ps = con.prepareStatement("Update Carrera set"
                        + " nombre_carrera = ? ,"
                        + " id_carrera = ? ,"
                        + " id_facultad = ? "
                        + " where id_carrera =\'"+idCarrera+"\'");
                
                ps.setString(1, NombreCarrera);
                ps.setString(2, idCarrera);
                ps.setString(3, Facultad);
                int res = ps.executeUpdate();
                 if(res > 0){
                    JOptionPane.showMessageDialog(null, "Se ha actualizado la información de la carrera" +Carrera+ " correctamente.");

                }else {
                    JOptionPane.showMessageDialog(null, "¡Error al actualizado la información!.");

                 }
            
            } catch (Exception e) {
                System.out.println(e);
            }
           
        }
   }
   
   public void EliminarCarrera(String idCarrera, String NombreCarrera, String Facultad){
        if((idCarrera.equals(""))){
            javax.swing.JOptionPane.showMessageDialog(null,"Debe ingresar el id de la carrera.","Id carrera requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        if((NombreCarrera.equals(""))){
            javax.swing.JOptionPane.showMessageDialog(null,"Debe ingresar el nombre de la carrera.","Nombre carrera requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
          
        if((Facultad.equals("Seleccione una facultad"))){
            javax.swing.JOptionPane.showMessageDialog(null,"Debe seleccionar una facultad para la carrea","Facultad de la carrera requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }
          else if(JOptionPane.showConfirmDialog(null,"¿Está seguro que desea eliminar el registro de la carrera "+NombreCarrera+"","Confirmación de eliminación",
                   JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE
            )==JOptionPane.YES_OPTION){   
             
      try{
          PreparedStatement ps;
          ResultSet rs;
          ps=con.prepareStatement("Delete Carrera "
                  + "where id_carrera = (Select id_carrera from Carrera where nombre_carrera = '"+NombreCarrera+"')");
               
                int res= ps.executeUpdate();
                  JOptionPane.showMessageDialog(null, "Se ha borrado la información de la carrera "+NombreCarrera+" correctamente");
                  if(res > 0){ 
                  }else {
                      JOptionPane.showMessageDialog(null, "¡Error al eliminar la información!"); 
                  }
      } catch ( Exception e) {
            System.out.println(e);
        }
          }
   }
   
   public void ConsultarCarrera(String idCarrera, String NombreCarrera, String Facultad){
       
         try {
            String sql = "SELECT * FROM Carrera as c join Facultad as f on f.id_facultad = c.id_facultad";
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                String[] datos = new String[4];
                datos[0] = rs.getString("id_carrera");
                datos[1] = rs.getString("nombre_carrera");
                datos[2] =rs.getString("id_facultad");
                datos[3] =rs.getString("nombre_facultad");
                
            }
           
        } catch (Exception e) {
           /* JOptionPane.showMessageDialog(null, e.getMessage());*/
            System.err.println(e);
        }
   }
   
   
   private boolean existeidCarrera() {
      
        try {
            Statement st = con.createStatement();
            String sql = "Select id_carrera from Carrera where id_carrera = '" + idCarrera+ "'";
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "El id carrera: " + idCarrera + " ya existe", "El id  carrera ¡Ya existe!.", JOptionPane.INFORMATION_MESSAGE);
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Carrera.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
  
      private boolean existeCarrera() {
       
        try {
            Statement st = con.createStatement();
            String sql = "Select nombre_carrera from Carrera where nombre_carrera = '" +NombreCarrera+ "'";
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "La carrera: " + NombreCarrera+ " ya existe", "La  carrera ¡Ya existe!.", JOptionPane.INFORMATION_MESSAGE);
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Carrera.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    private boolean validarLongitudMax( String texto, int longitud) {
        if (texto.length() >= longitud) {
            return true;
        } else {
            return false;
        }
    }
    
     private boolean validarLongitud( String texto, int longitud) {
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
   
      private boolean contieneLetra(String texto){
          for (int i = 0; i < texto.length(); i++) {
              if(Character.isLetter(texto.charAt(i)))
                  return true;
          }
          return false;
      }
      
      private boolean contieneLetrayNumeros(String texto){
          for (int i = 0; i < texto.length(); i++) {
              if(Character.isLetterOrDigit(texto.charAt(i)))
                  return true;
          }
          return false;
      }

   
}
