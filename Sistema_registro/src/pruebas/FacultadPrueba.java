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
import sistema_registro.Facultad;
import sistema_registro.SQL.ConectorSQL;

/**
 *
 * @author Carlos
 */
public class FacultadPrueba {
     Connection con = null;
    
    public FacultadPrueba(){
         try {
             this.con = ConectorSQL.obtenerConexion();
         } catch (SQLException ex) {
             System.out.println(ex.getMessage());
         }
        }
    
    public static void main(String args[]){
        new FacultadPrueba().guardarFacultad("F00369","Ciencias sociales999");
        new FacultadPrueba().buscarFacultad();
    }
    
    
    public void guardarFacultad(String idFacultad, String nombreFacultad){
         
        if((idFacultad.equals(""))){
            javax.swing.JOptionPane.showMessageDialog(null,"Debe ingresar el id de la facultad.","Id facultad requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        if((nombreFacultad.equals(""))){
            javax.swing.JOptionPane.showMessageDialog(null,"Debe ingresar el nombre de la facultad.","Nombre facultad requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        if (existeidFacultad(idFacultad)) {
            return;
        }

         if (existeFacultad(nombreFacultad)) {
            return;
        }
         
        if (!validarLongitud(idFacultad, 2)) {
            JOptionPane.showMessageDialog(null, "El id  ingresados es muy pequeño el mínimo es de 2 caracteres", "Longitud de id facultad", JOptionPane.INFORMATION_MESSAGE);
            return;

        }

        if (!validarLongitud(nombreFacultad, 15)) {
            JOptionPane.showMessageDialog(null, "El nombre de la facultad ingresado es muy pequeños el mínimo es de 15 caracteres", "Longitud de  nombre facultad", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        if (!validarLongitudMax(idFacultad, 5)) {
            JOptionPane.showMessageDialog(null, "El id ingresado es muy grande el máximo es de 5 caracteres, usted ingresó " + idFacultad.length() + " caracteres.", "Longitud de id facultad", JOptionPane.INFORMATION_MESSAGE);
            return;

        }

        if (!validarLongitudMax(nombreFacultad, 40)) {
            JOptionPane.showMessageDialog(null, "El nombre de la facultad ingresado es muy grande el máximo es de 40 caracteres, usted ingresó " +nombreFacultad.length() + " caracteres", "Longitud de  nombre facultad", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        if(contieneNumeros(nombreFacultad)){
            JOptionPane.showMessageDialog(null, "El nombre de la facultad no puede contener números");
            return;
        }

        try {
            PreparedStatement ps;
            ResultSet rs;
            ps = con.prepareStatement("INSERT INTO Facultad (id_facultad, nombre_facultad)"
                + "                VALUES(?,?)");
            ps.setString(1, idFacultad);
            ps.setString(2, nombreFacultad);
            int res = ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se ha guardado la información de la facultad: "+nombreFacultad);
        } catch (Exception e) {
            System.out.println(e);
             JOptionPane.showMessageDialog(null, "Error al Guardar la información");

        }
    }
    
    public void actualizarNombreFacultad(String idFacultad, String nombreFacultad){
         
        if ((idFacultad.equals("") || (nombreFacultad.equals("")))) {
            JOptionPane.showMessageDialog(null, "¡Debe seleccionar la facultad que desea actualizar!");
        }
        
         if (!validarLongitud(idFacultad, 2)) {
            JOptionPane.showMessageDialog(null, "El id  ingresados es muy pequeño el mínimo es de 2 caracteres", "Longitud de id facultad", JOptionPane.INFORMATION_MESSAGE);
            return;

        }

        if (!validarLongitud(nombreFacultad, 15)) {
            JOptionPane.showMessageDialog(null, "El nombre facultad ingresado es muy pequeños el mínimo es de 15 caracteres", "Longitud de  nombre facultad", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
          if (!validarLongitudMax(idFacultad, 5)) {
            JOptionPane.showMessageDialog(null, "El id ingresado es muy grande el máximo es de 5 caracteres, usted ingresó " + idFacultad.length() + " caracteres.", "Longitud de id facultad", JOptionPane.INFORMATION_MESSAGE);
            return;

        }

        if (!validarLongitudMax(nombreFacultad, 40)) {
            JOptionPane.showMessageDialog(null, "El nombre facultad ingresado es muy grande el máximo es de 40 caracteres, usted ingresó " +nombreFacultad.length() + " caracteres", "Longitud de  nombre facultad", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        if(contieneNumeros(nombreFacultad)){
            JOptionPane.showMessageDialog(null, "El nombre de la facultad no puede contener números");
            return;
        }
        

       else if (JOptionPane.showConfirmDialog(null, "¿Está seguro que desea actualizar el registro de facultad " + nombreFacultad + "?", "Confirmación de actualización", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE
        ) == JOptionPane.YES_OPTION) {
            try {
                PreparedStatement ps;
                ResultSet rs;
                ps = con.prepareStatement("Update Facultad set"
                    + " nombre_facultad = ? ,"
                    + "id_facultad = ? "
                    + " where id_facultad =\'"+idFacultad+"\'");
                /*ps.setString(1, txt_NombreCampus.getText());*/
                ps.setString(1, nombreFacultad);
                ps.setString(2, idFacultad);
                int res = ps.executeUpdate();
            } catch (Exception e) {
                System.out.println(e);
                              JOptionPane.showMessageDialog(null, "No se ha realizado la actualización por: \n 1.La facultad ya está en uso."
                         + "\n 2. No se encuentra el código de la facultad a actualizar.","¡Error al Actualizar!", JOptionPane.ERROR_MESSAGE);
            }
        }  
    }
    
    public void eliminarFacultad(String nombreFacultad){
         if ((nombreFacultad.equals("") )) {
            JOptionPane.showMessageDialog(null, "¡Debe seleccionar la facultad que desea eliminar!");
        }
         else if (JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar el registro de facultad " + nombreFacultad + "", "Confirmación de eliminación",
            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE
        ) == JOptionPane.YES_OPTION) {

            try {
                if (!existeFacultad(nombreFacultad)) {
                    JOptionPane.showMessageDialog(null, "La facultad: " + nombreFacultad + " no existe");
                    return;
                }
                
                Statement st2 = con.createStatement();
                String sql = "Delete Facultad "
                + "where id_facultad = (Select id_facultad from Facultad where nombre_facultad = '"+nombreFacultad+"')";
                int rs2 = st2.executeUpdate(sql);
                System.out.println(rs2);
                if(rs2 > 0){
                    JOptionPane.showMessageDialog(null, "Se ha borrado la información de la facultad " + nombreFacultad + " correctamente");

                }else {
                    JOptionPane.showMessageDialog(null, "¡Error al eliminar la información!");

                }

            } catch (Exception e) {
                //JOptionPane.showMessageDialog(null, e.getMessage());
                     JOptionPane.showMessageDialog(null, "Error al borrar la información, podría ser por: \n 1.La facultad ya está en uso."
                         + "\n 2. No se encuentra el código de la facultad a borrar.","¡Error al Borrar!", JOptionPane.ERROR_MESSAGE);
            
            }
        }
    }
    
    public void buscarFacultad(){
        try {
            String sql = "SELECT * FROM Facultad";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String[] datos = new String[2];
                datos[0] = rs.getString("id_facultad");
                datos[1] = rs.getString("nombre_facultad");
                System.out.println("Id Facultad: " + datos[0] +" - "+"Nombre Facultad: " + datos[1]);
            }
        } catch (Exception e) {
           /* JOptionPane.showMessageDialog(null, e.getMessage());*/
            System.err.println(e);
        }
    }
    
     private boolean existeFacultad(String nombreFacultad) {
        try {
            Statement st = con.createStatement();
            String sql = "Select nombre_facultad from Facultad where nombre_facultad = '" + nombreFacultad + "'";
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "El nombre facultad: " + nombreFacultad + " ya existe", "La facultad ¡Ya existe!.", JOptionPane.INFORMATION_MESSAGE);
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Facultad.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
     
     private boolean existeFacultad2(String nombreFacultad) {
        try {
            Statement st = con.createStatement();
            String sql = "Select nombre_facultad from Facultad where nombre_facultad = '" + nombreFacultad + "'";
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Facultad.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
     
   

    
      private boolean existeidFacultad(String idFacultad) {
        try {
            Statement st = con.createStatement();
            String sql = "Select id_facultad from Facultad where id_facultad = '" + idFacultad + "'";
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "El id facultad: " + idFacultad + " ya existe", "El id facultad ¡Ya existe!.", JOptionPane.INFORMATION_MESSAGE);
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Facultad.class.getName()).log(Level.SEVERE, null, ex);
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