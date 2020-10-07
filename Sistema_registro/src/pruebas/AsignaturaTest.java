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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import sistema_registro.Campus;
import sistema_registro.SQL.ConectorSQL;

/**
 *
 * @author asus
 */
public class AsignaturaTest {
    Connection con = null;
  
     
     public AsignaturaTest(){
         try {
             this.con = ConectorSQL.obtenerConexion();
         } catch (SQLException ex) {
             System.out.println(ex.getMessage());
         }
     }
     
     
     public void GuardarAsignatura(String CodAsignatura, String NombreAsignatura, String UnidadValorativa, String Carrera, String Req1, String Req2){
           if((CodAsignatura.equals(""))){
            javax.swing.JOptionPane.showMessageDialog(null,"Debe ingresar el código de la asignatura.","Código asignatura requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
          if((NombreAsignatura.equals(""))){
            javax.swing.JOptionPane.showMessageDialog(null,"Debe ingresar el nombre de la asignatura.","Nombre asignatura requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }
         
          if((UnidadValorativa.equals(""))){
            javax.swing.JOptionPane.showMessageDialog(null,"Debe ingresar la unidad valorativa de la asignatura.","Unidad valorativa de la asignatura requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }
          
         if((Carrera.equals("Seleccione una carrera"))){
            javax.swing.JOptionPane.showMessageDialog(null,"Debe seleccionar una carrera para la asignatura","Carrera de la asignatura requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }
         
         if((Req1.equals("Seleccione requsito 1"))){
            javax.swing.JOptionPane.showMessageDialog(null,"Debe seleccionar un requisito para la asignatura","Requisito1 de la asignatura requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        if((Req2.equals("Seleccione requsito 2"))){
            javax.swing.JOptionPane.showMessageDialog(null,"Debe seleccionar un requisito para la asignatura","Requisito2 de la asignatura requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        if(existeCodAsignatura(CodAsignatura)){
            return;
        }
        
        if(existeAsignatura(NombreAsignatura)){
            return;
        }
        

        if(!validarLongitud(CodAsignatura,3)){
            JOptionPane.showMessageDialog(null, "El codigo de asignaturas tiene que ser minimo de 3 caracteres", "Longitud de codigo de asignatura", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

       if(!validarLongitud(NombreAsignatura,7)){
            JOptionPane.showMessageDialog(null, "El Nombre de la asignatura es muy corto el mínimo es de 7 caracteres", "Longitud del nombre de asignatura", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
       
         if(!validarLongitud(UnidadValorativa,1)){
            JOptionPane.showMessageDialog(null, "La unidades valorativas debe ser de un mínimo de 1 caracter", "Longitud de las unidades valorativas", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
         
        if(!validarUV(UnidadValorativa)){
            JOptionPane.showMessageDialog(null, "La unidades solo pueden ser valores entre 1 y 15", "Valor de la unidad valorativa", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        if(!validarRequisitos(Req1.toString(),Req2.toString())){
            JOptionPane.showMessageDialog(null, "El requisito 1 no puede ser igual al requisito 2", "Requisitos iguales", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        
        if(!validarLongitudMax(CodAsignatura,6)){
            JOptionPane.showMessageDialog(null, "Número máximo de caracteres", "Longitud de código de asignatura", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

       if(!validarLongitudMax(NombreAsignatura,50)){
            JOptionPane.showMessageDialog(null, "Número máximo de caracteres", "Longitud del nombre de asignatura", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
       
         if(!validarLongitudMax(UnidadValorativa,2)){
            JOptionPane.showMessageDialog(null, "Número máximo de caracteres", "Longitud de las unidades valorativas", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
         
        if(contieneNumeros(NombreAsignatura)){
            JOptionPane.showMessageDialog(null, "El nombre de la asignatura no puede contener números");
            return;
        }
        
          if(contieneLetras(UnidadValorativa)){
            JOptionPane.showMessageDialog(null, "La unidad valorativa de la asignatura no puede contener letras");
            return;
        }
         
         

        try{
            PreparedStatement ps;
            ResultSet rs;

            ps=con.prepareStatement("Insert into Asignaturas (cod_asignaturas, nombre_asignaturas, UV, id_carrera, requisito1, requisito2 )"
                + "                VALUES(?,?,?,?,?,?)");
            ps.setString(1, CodAsignatura);
            ps.setString(2, NombreAsignatura);
            ps.setString(3, UnidadValorativa);
            ps.setString(4, Carrera);
            ps.setString(5, Req1);
            ps.setString(6,Req2);
            
            int res= ps.executeUpdate(); 
            JOptionPane.showMessageDialog(null, "Se ha guardado la información en Registro de Asignatura");
             } catch ( Exception e) {
            System.out.println(e);
        
             JOptionPane.showMessageDialog(null, "Error al guardar la información");
        }
         
     }
     
     public void ActualizarAsignatura(String CodAsignatura, String NombreAsignatura, String UnidadValorativa, String Carrera, String Req1, String Req2){
          if((CodAsignatura.equals(""))){
            javax.swing.JOptionPane.showMessageDialog(null,"Debe ingresar el código de la asignatura.","Código asignatura requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
          if((NombreAsignatura.equals(""))){
            javax.swing.JOptionPane.showMessageDialog(null,"Debe ingresar el nombre de la asignatura.","Nombre asignatura requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }
         
          if((UnidadValorativa.equals(""))){
            javax.swing.JOptionPane.showMessageDialog(null,"Debe ingresar la unidad valorativa de la asignatura.","Unidad valorativa de la asignatura requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }
          
         if((Carrera.equals("Seleccione una carrera"))){
            javax.swing.JOptionPane.showMessageDialog(null,"Debe seleccionar una carrera para la asignatura","Carrera de la asignatura requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }
         
         if((Req1.equals("Seleccione requsito 1"))){
            javax.swing.JOptionPane.showMessageDialog(null,"Debe seleccionar un requisito para la asignatura","Requisito1 de la asignatura requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        if((Req2.equals("Seleccione requsito 2"))){
            javax.swing.JOptionPane.showMessageDialog(null,"Debe seleccionar un requisito para la asignatura","Requisito2 de la asignatura requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        if(!validarLongitud(CodAsignatura,3)){
            JOptionPane.showMessageDialog(null, "El codigo de asignaturas tiene que ser minimo de 3 caracteres", "Longitud de codigo de asignatura", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

       if(!validarLongitud(NombreAsignatura,7)){
            JOptionPane.showMessageDialog(null, "El Nombre de la asignatura es muy corto el mínimo es de 7 caracteres", "Longitud del nombre de asignatura", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
       
         if(!validarLongitud(UnidadValorativa,1)){
            JOptionPane.showMessageDialog(null, "La unidades valorativas debe ser de un mínimo de 1 caracter", "Longitud de las unidades valorativas", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
         
        if(!validarUV(UnidadValorativa)){
            JOptionPane.showMessageDialog(null, "La unidades solo pueden ser valores entre 1 y 15", "Valor de la unidad valorativa", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        if(!validarRequisitos(Req1.toString(),Req2.toString())){
            JOptionPane.showMessageDialog(null, "El requisito 1 no puede ser igual al requisito 2", "Requisitos iguales", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        
        if(!validarLongitudMax(CodAsignatura,6)){
            JOptionPane.showMessageDialog(null, "Número máximo de caracteres", "Longitud de código de asignatura", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

       if(!validarLongitudMax(NombreAsignatura,50)){
            JOptionPane.showMessageDialog(null, "Número máximo de caracteres", "Longitud del nombre de asignatura", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
       
         if(!validarLongitudMax(UnidadValorativa,2)){
            JOptionPane.showMessageDialog(null, "Número máximo de caracteres", "Longitud de las unidades valorativas", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
         
        if(contieneNumeros(NombreAsignatura)){
            JOptionPane.showMessageDialog(null, "El nombre de la asignatura no puede contener números");
            return;
        }
        
          if(contieneLetras(UnidadValorativa)){
            JOptionPane.showMessageDialog(null, "La unidad valorativa de la asignatura no puede contener letras");
            return;
        }
         
           else if(JOptionPane.showConfirmDialog(null, "¿Está seguro que desea actualizar el registro de la asignatura " +NombreAsignatura + "?", "Confirmación de actualización", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE
        ) == JOptionPane.YES_OPTION) {
            
            try {
                PreparedStatement ps;
                ResultSet rs;
                ps = con.prepareStatement("Update Asignaturas set"
                    + " cod_asignaturas = ? ,"
                    + " nombre_asignaturas = ? , "
                    + " UV = ?, "
                    + " id_carrera =?, "
                    + " requisito1 = ? , "
                    + " requisito2 = ? "
                    + " where cod_asignaturas ='"+CodAsignatura+"'");
                  ps.setString(1, CodAsignatura);
                  ps.setString(2, NombreAsignatura);
                  ps.setString(3, UnidadValorativa);
                  ps.setString(4, Carrera);
                  ps.setString(5, Req1);
                  ps.setString(6, Req2);
               
                int res = ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Se ha actualizado la información en de la asignatura: " + NombreAsignatura);
      
            } catch (Exception e) {
               // System.out.println(e);
                JOptionPane.showMessageDialog(null, "Error al actualizar la informacion de la asignatura, podría ser por: \n 1.La Asignatura ya está en uso con alumnos matriculados."
                         + "\n 2. No se encuentra el código de la Asignatura a actualizar.\n 3.La Asignatura tiene secciones creadas","¡Error al Actuarlizar!", JOptionPane.ERROR_MESSAGE);
            }
            

        }
     }
     
     public void EliminarAsignatura(String CodAsignatura, String NombreAsignatura, String UnidadValorativa, String Carrera, String Req1, String Req2){
           if ((NombreAsignatura.equals("")) || (CodAsignatura.equals(""))  || ((UnidadValorativa.equals(""))) ) {

            javax.swing.JOptionPane.showMessageDialog(null,"¡Debe seleccionar la asignatura que desea eliminar! \n","¡AVISO!",javax.swing.JOptionPane.INFORMATION_MESSAGE);
           
        }
          else if (JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar el registro de asignatura " + NombreAsignatura + "", "Confirmación de eliminación",
            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE
        ) == JOptionPane.YES_OPTION) {

            try {
                Statement st2 = con.createStatement();
                String sql = "Delete Asignaturas "
                + "where cod_asignaturas = (Select cod_asignaturas from Asignaturas where nombre_asignaturas = '"+NombreAsignatura+"')";

                int rs2 = st2.executeUpdate(sql);
                System.out.println(rs2);
                if(rs2 > 0){
                    JOptionPane.showMessageDialog(null, "Se ha borrado la información de la asignatura" + NombreAsignatura + " correctamente");

                }else {
                    JOptionPane.showMessageDialog(null, "¡Error al eliminar la información!");

                }

            } catch (Exception e) {
                //JOptionPane.showMessageDialog(null, e.getMessage());
                   JOptionPane.showMessageDialog(null, "Error al borrar la información de la asignatura, podría ser por: \n 1.La Asignatura ya está en uso con alumnos matriculados."
                         + "\n 2. No se encuentra el código de la Asignatura a borrar.\n 3.La Asignatura tiene secciones creadas","¡Error al Borrar!", JOptionPane.ERROR_MESSAGE);
            }

        }
     }
     
     public void BuscarAsignatura(){
          try {
               
               String sql = "SELECT * FROM Asignaturas";
               Statement stmt = con.createStatement();
               stmt = con.createStatement();
               ResultSet rs = stmt.executeQuery(sql);
              
                 while(rs.next()) {
                     
                          String []datos= new String[6];
                      datos[0] =rs.getString("cod_asignaturas");
                      datos[1] =rs.getString("nombre_asignaturas");
                      datos[2] =rs.getString("UV");
                      datos[3] =rs.getString("id_carrera");
                      datos[4] =rs.getString("requisito1");
                      datos[5] =rs.getString("requisito2");
                   
                 }
          
        }
        catch (Exception e) {
           
            System.err.println(e);
        }
           
     }
     
     
      private boolean validarUV(String uv){
        int unidad = Integer.parseInt(uv);
        if(unidad >= 1 && unidad <= 15){
            return true;
        }
        else{
            return false;
        }
    }
      
      private boolean validarRequisitos(String requisitoA, String requisitoB){
        if(requisitoA.equals("Sin requisito") || requisitoA.equals("Sin requisito")){
            return true;
        }
       
        if(!requisitoA.equals(requisitoB)){
            return true;
        }
        else{
            return false;
        }
    }
      
     private boolean existeCodAsignatura(String CodAsignatura) {
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
    
     private boolean existeAsignatura(String Asignatura) {
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
     
    
}
