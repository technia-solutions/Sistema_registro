/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import static java.awt.Frame.ICONIFIED;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import sistema_registro.Campus;
import sistema_registro.SQL.ConectorSQL;

/**
 *
 * @author asus
 */
public class ReqAsignaturaTest {
        Connection con = null;
  public ReqAsignaturaTest(){
         try {
             this.con = ConectorSQL.obtenerConexion();
         } catch (SQLException ex) {
             System.out.println(ex.getMessage());
         }
  }
  
  
  public void GuardarReqAsignatura(String idReqAsignatura, String NombreAsignatura, String Carrera){
       if((idReqAsignatura.equals(""))){
            javax.swing.JOptionPane.showMessageDialog(null,"Debe ingresar el código de la asignatura requisito.","Código asignatura requisito requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
           
            return;
        }
          
        if((NombreAsignatura.equals(""))){
            javax.swing.JOptionPane.showMessageDialog(null,"Debe ingresar el nombre de la asignatura requisito.","Nombre asignatura requisito requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
         if((Carrera.equals("Seleccione una carrera"))){
            javax.swing.JOptionPane.showMessageDialog(null,"Debe seleccionar una carrera para la asignatura requisito","Carrera de la asignatura requisito requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        

        if (existeRequisitoAsignatura(NombreAsignatura)) {
            return;
        }
        
        if (existeidRequsitoAsignatura(idReqAsignatura)) {
            return;
        }

        if (!validarLongitud(idReqAsignatura, 4)) {
            JOptionPane.showMessageDialog(null, "El id para la asignatura requisito ingresado es muy pequeño, el mínimo es de 4 caracteres", "Longitud de id la asignatura requisito", JOptionPane.INFORMATION_MESSAGE);
            return;

        }

        if (!validarLongitud(NombreAsignatura,7)) {
            JOptionPane.showMessageDialog(null, "El  nombre de la asignatura requisito ingresado es muy pequeño, el mínimo es de 7 caracteres", "Longitud de nombre de la asignatura requisito", JOptionPane.INFORMATION_MESSAGE);
            return;

        }
        
        
        if (!validarLongitudMax(idReqAsignatura, 6)) {
            JOptionPane.showMessageDialog(null, "Número máximo de caracteres", "Longitud de id la asignatura requisito", JOptionPane.INFORMATION_MESSAGE);
            return;

        }

        if (!validarLongitudMax(NombreAsignatura,50)) {
            JOptionPane.showMessageDialog(null, "Número máximo de caracteres", "Longitud de nombre de la asignatura requisito", JOptionPane.INFORMATION_MESSAGE);
            return;

        }
        
         if(contieneNumeros(NombreAsignatura)){
            JOptionPane.showMessageDialog(null, "El nombre de la asignatura no puede contener números");
            return;
        }
        
        try {
            PreparedStatement ps;
            ResultSet rs;
            ps = con.prepareStatement("INSERT INTO Requisito_Asignatura (id_asignatura, RequisitoAsignatura,id_carrera)"
                + "                VALUES(?,?,?)");
            ps.setString(1, idReqAsignatura);
            ps.setString(2, NombreAsignatura);
            ps.setString(3, Carrera);
            int res = ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se ha guardado la información de la asignatura requisito");
        } catch (Exception e) {
            System.out.println(e);

        }
  }
  
  
  public void ActualizarReqAsignatura(String idReqAsignatura, String NombreAsignatura, String Carrera){
      
       if((idReqAsignatura.equals(""))){
            javax.swing.JOptionPane.showMessageDialog(null,"Debe ingresar el código de la asignatura requisito.","Código asignatura requisito requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
           
            return;
        }
          
        if((NombreAsignatura.equals(""))){
            javax.swing.JOptionPane.showMessageDialog(null,"Debe ingresar el nombre de la asignatura requisito.","Nombre asignatura requisito requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
         if((Carrera.equals("Seleccione una carrera"))){
            javax.swing.JOptionPane.showMessageDialog(null,"Debe seleccionar una carrera para la asignatura requisito","Carrera de la asignatura requisito requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }
         
        if (!validarLongitud(idReqAsignatura, 4)) {
            JOptionPane.showMessageDialog(null, "El id para la asignatura requisito ingresado es muy pequeño, el mínimo es de 4 caracteres", "Longitud de id la asignatura requisito", JOptionPane.INFORMATION_MESSAGE);
            return;

        }

        if (!validarLongitud(NombreAsignatura,7)) {
            JOptionPane.showMessageDialog(null, "El  nombre de la asignatura requisito ingresado es muy pequeño, el mínimo es de 7 caracteres", "Longitud de nombre de la asignatura requisito", JOptionPane.INFORMATION_MESSAGE);
            return;

        }
        
        
        if (!validarLongitudMax(idReqAsignatura, 6)) {
            JOptionPane.showMessageDialog(null, "Número máximo de caracteres", "Longitud de id la asignatura requisito", JOptionPane.INFORMATION_MESSAGE);
            return;

        }

        if (!validarLongitudMax(NombreAsignatura,50)) {
            JOptionPane.showMessageDialog(null, "Número máximo de caracteres", "Longitud de nombre de la asignatura requisito", JOptionPane.INFORMATION_MESSAGE);
            return;

        }
        
         if(contieneNumeros(NombreAsignatura)){
            JOptionPane.showMessageDialog(null, "El nombre de la asignatura no puede contener números");
            return;
        }
       
       
        else if(JOptionPane.showConfirmDialog(null, "¿Está seguro que desea actualizar el registro de la asignatura requisito" + NombreAsignatura+ "?", "Confirmación de actualización", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE
        ) == JOptionPane.YES_OPTION) {
           
            try {
                PreparedStatement ps;
                ResultSet rs;
                ps = con.prepareStatement("Update Requisito_Asignatura set"
                    + " RequisitoAsignatura = ? ,"
                    + " id_asignatura = ? "
                    + " where id_asignatura =\'"+idReqAsignatura+"\'");

                ps.setString(1, NombreAsignatura);
                ps.setString(2, idReqAsignatura);
                ps.setString(3, Carrera);
                 
                int res = ps.executeUpdate();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
  }
  
  
  public void EliminarReqAsignatura(String idReqAsignatura, String NombreAsignatura, String Carrera){
       if ((idReqAsignatura.equals("")) || (NombreAsignatura.equals("")) ||
            (Carrera.equals("Seleccione la asignatura requisito"))) {

            javax.swing.JOptionPane.showMessageDialog(null,"¡Debe seleccionar la asignatura requisito a eliminar! \n","¡AVISO!",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            
            
        }
        else if(JOptionPane.showConfirmDialog(null,"¿Está seguro que desea eliminar el registro de la asignatura requisito "+NombreAsignatura+"","Confirmación de eliminación",
            JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE
        )==JOptionPane.YES_OPTION){
           
            try{
                PreparedStatement ps;
                ResultSet rs;
                ps=con.prepareStatement("Delete Requisito_Asignatura "
                    + "where id_asignatura = (Select id_asignatura from Requisito_Asignatura   where RequisitoAsignatura = '"+NombreAsignatura+"')");
                
                int res= ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Se ha borrado la información de la asignatura requisito "+NombreAsignatura+" correctamente");
                if(res > 0){
                }else {
                    JOptionPane.showMessageDialog(null, "¡Error al eliminar la información!");
                }
            } catch ( Exception e) {
                System.out.println(e);
            }
        }
    }
  
  
  public void BuscarReqAsignatura(String idReqAsignatura, String NombreAsignatura, String Carrera){
      try {
            String sql = "SELECT * FROM Requisito_Asignatura";
            Statement stmt = con.createStatement();
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String[] datos = new String[3];
                datos[0] = rs.getString("id_asignatura");
                datos[1] = rs.getString("RequisitoAsignatura");
                datos[2] =rs.getString("id_carrera");
            
            }
          
        } catch (Exception e) {
           /* JOptionPane.showMessageDialog(null, e.getMessage());*/
            System.err.println(e);
        }
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
     
       
     private boolean contieneLetras(String texto){
          for (int i = 0; i < texto.length(); i++) {
              if(Character.isLetter(texto.charAt(i)))
                  return true;
          }
          return false;
      }
           
     private boolean existeidRequsitoAsignatura(String CodAsignatura) {
        try {
            Statement st = con.createStatement();
            String sql = "Select * from Asignaturas where cod_asignaturas = '" + CodAsignatura + "'";
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "El código de la asignatura: " + CodAsignatura + " ya existe", "El código de la asignatura ¡Ya existe!.", JOptionPane.INFORMATION_MESSAGE);
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Campus.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
     private boolean existeRequisitoAsignatura(String Asignatura) {
        try {
            Statement st = con.createStatement();
            String sql = "Select * from Asignaturas where nombre_asignaturas = '" + Asignatura+ "'";
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "La asignatura: " + Asignatura+ " ya existe", "El nombre de la asignatura ¡Ya existe!.", JOptionPane.INFORMATION_MESSAGE);
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Campus.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
