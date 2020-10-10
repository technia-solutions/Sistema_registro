package pruebas;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static org.codehaus.groovy.ast.tools.GeneralUtils.stmt;
import sistema_registro.Campus;
import sistema_registro.Campus;
import sistema_registro.SQL.ConectorSQL;





/**
 *
 * @author wianp
 */
public class PeriodoTest {
    
   Connection con = null;
   Statement stmt;
   String idPeriodo;
   String nombrePeriodo;
   String descripcion;
     
    public  PeriodoTest () {
    
        try{
            this.con = ConectorSQL.obtenerConexion();
        } catch (SQLException ex) {
            
            System.out.println(ex.getMessage());
            
        }
        
 }
 
     public void GuardarPeriodo ( String idPeriodo, String nombrePeriodo, String descripcion) {
         
         if((idPeriodo.equals(""))){
            javax.swing.JOptionPane.showMessageDialog(null,"Debe ingresar el id período.","Id de período requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
           
            return;
        }
          
        if((nombrePeriodo.equals(""))){
            javax.swing.JOptionPane.showMessageDialog(null,"Debe ingresar el período.","Período requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            
            return;
        }
        
         if((descripcion.equals(""))){
            javax.swing.JOptionPane.showMessageDialog(null,"Debe ingresar una descripcion del período","Descripcion del período",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        
        }
         
            if(existeidPeriodo( )) {
            return;
        }
        
               if(idPeriodo.equals(idPeriodo) ) {
                   javax.swing.JOptionPane.showMessageDialog(null,"Error al guardar el id del período","Id del período no valido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }
               if(nombrePeriodo.equals(nombrePeriodo) ) {
                   javax.swing.JOptionPane.showMessageDialog(null,"Error al guardar el nombre del período","Nombre del período no valido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
               }
               
               if(descripcion.equals(descripcion) ) {
                   javax.swing.JOptionPane.showMessageDialog(null,"Error al guardar la descripcion del período","Descripcion del período no valido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
               }
               
            if (existenombrePeriodo()) {
            return;
        }

        

        if (!validarLongitudMinima(nombrePeriodo,1 )) {
            JOptionPane.showMessageDialog(null, "El  período ingresado es muy pequeño, el mínimo es de 1 caracter", "Longitud del período", JOptionPane.INFORMATION_MESSAGE);
            return;

        }
        
         if (!validarLongitudMaxima(descripcion,10 )) {
            JOptionPane.showMessageDialog(null, "La descripcion del período ingresado es muy pequeño, el mínimo es de 10 caracter", "Longitud del período", JOptionPane.INFORMATION_MESSAGE);
            return;

        }
      /*  else if (JOptionPane.showConfirmDialog(null, "¿Está seguro que desea actualizar el registro del período " + nombrePeriodo + "?.", "Confirmación de actualización", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE
        ) == JOptionPane.YES_OPTION)*/{
         
         try {
              PreparedStatement ps;
            ResultSet rs;
             ps = con.prepareStatement("INSERT INTO Periodo (id_periodo, periodo ,descripcion)"
                + "                VALUES(?,?,?)");
             ps.setString(1, idPeriodo);
             ps.setString(2, nombrePeriodo);
             ps.setString(3, descripcion);
             int res = ps.executeUpdate();
             JOptionPane.showMessageDialog(null, "Se ha guardado la información del período");
         } catch (Exception e){
                
             System.out.println(e);
             
         }
     }
     }
     
         
 public void ActualizarPeriodo (String nombrePeriodo, String idPeriodo, String descripcion) {
          
       
           
        if ( (idPeriodo.equals("") ) || (nombrePeriodo.equals("") ) || (nombrePeriodo.equals("") ) )   {
            javax.swing.JOptionPane.showMessageDialog(null,"Debe ingresar el id período.","Id de período requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
             return;
        }
         
 
        else if (JOptionPane.showConfirmDialog(null, "¿Está seguro que desea actualizar el registro del período " + nombrePeriodo + "?", "Confirmación de actualización", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE
        ) == JOptionPane.YES_OPTION) {
        
          try{
                PreparedStatement ps;
                 ResultSet rs;
                 ps = con.prepareStatement ("Update Periodo set"
                    + " id_periodo = ? ,"
                    + " periodo = ? ,"
                    + "descripcion = ? "
                    + " where id_periodo ='"+idPeriodo.equals("")+"'");
              ps.setString(1, idPeriodo);
             ps.setString(2, nombrePeriodo);
             ps.setString(3, descripcion);
             int res = ps.executeUpdate();
            if(res > 0){
                    JOptionPane.showMessageDialog(null, "Se ha actualizado la información del período " + nombrePeriodo + " correctamente.");
             JOptionPane.showMessageDialog(null,  "Se ha actualizado la información del período " + nombrePeriodo + " correctamente.");
              }else {
                    JOptionPane.showMessageDialog(null, "¡Error al actualizar la información!.");
                }
            } catch (Exception e){
                  JOptionPane.showMessageDialog(null, "Error al actualizar la información del período, podría ser por: \n 1.El período ya empezo."
                         + "\n 2. No se encuentra el código del período.\n 3.El período tiene alumnos matriculados","¡Error al actualizar!", JOptionPane.ERROR_MESSAGE);
             }
         }
 }
        
        public void BuscarPeriodo  (){
    
//Metodo             actualizarDatos();
            
} 
        
        public void EliminarPeriodo ( String idPeriodo, String nombrePeriodo, String descripcion){
            
             if ( (idPeriodo.equals("") ) || (nombrePeriodo.equals("") ) || (nombrePeriodo.equals("") ) )   {
            javax.swing.JOptionPane.showMessageDialog(null,"Debe ingresar el id período.","Id de período requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
             return;
        }
        else if (JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar el registro del período " + nombrePeriodo + ".", "Confirmación de eliminación",
            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE
        ) == JOptionPane.YES_OPTION) {

            try {
                Statement st2 ;
                st2= con.createStatement();
                String sql = "Delete Periodo "
                + "where id_periodo = (Select id_periodo from Periodo where id_periodo = '"+nombrePeriodo+"')";
                 

                int rs2 = st2.executeUpdate(sql);
                System.out.println(rs2);
                if(rs2 > 0){
                    JOptionPane.showMessageDialog(null, "Se ha borrado la información del período " + nombrePeriodo + " correctamente.");

                }else {
                    JOptionPane.showMessageDialog(null, "¡Error al eliminar la información!");

                }

            } catch (Exception e) {
                //JOptionPane.showMessageDialog(null,"¡Error al eliminar la información!" );
                 JOptionPane.showMessageDialog(null, "Error al borrar la información del período, podría ser por: \n 1.El período ya empezo."
                         + "\n 2. No se encuentra el código del período.\n 3.El período tiene alumnos matriculados","¡Error al eliminar!", JOptionPane.ERROR_MESSAGE);
            }

           
           //Metodo -> actualizarDatos();
            //LimpiarCajas();
        }
            
        }
        
        public void LimpiarPeriodo (String idPeriodo, String nombrePeriodo, String descripcion){
            
             //LimpiarCajas();
            
        }
        
        /*private void  idPeriodo(){
            
            char a
}*/
        
        public void actualizarDatos() {
        
            try {
            String sql = "SELECT * FROM Periodo";
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                
                String[] datos = new String[3];
                datos[0] = rs.getString("id_periodo");
                datos[1] = rs.getString("periodo");
                datos[2] =rs.getString("descripcion");
                
               /* idPeriodo == set("id_periodo");
                nombrePeriodo.setString("periodo");
                descripcion.setString("descripcion");*/
               
            }
           
        } catch (Exception e) {
            System.err.println(e);
        }
    }   

 /* private void LimpiarCajas( ){
        nombrePeriodo.setText(null);
        idPeriodo.setText(null);
           descripcion.setText(null);
        
    }*/
        
    private boolean existeidPeriodo( ) {
        try {
            Statement st = con.createStatement();
            String sql = "Select id_periodo from Periodo where id_periodo = '" + idPeriodo+ "'";
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "El id del período " + idPeriodo+ " ya existe", "El id período ¡Ya existe!.", JOptionPane.INFORMATION_MESSAGE);
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Campus.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    private boolean existenombrePeriodo( ) {
        try {
            Statement st = con.createStatement();
            String sql = "Select descripcion from Periodo where descripcion = '" + descripcion + "'";
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "El nombre del período " + descripcion + " ya existe", "El nombre período ¡Ya existe!.", JOptionPane.INFORMATION_MESSAGE);
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Campus.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

  
       private boolean validarLongitudMaxima( String texto, int longitud) {
        if (texto.length() >= longitud) {
            return true;
        } else {
            return false;
        }
    }
    
     private boolean validarLongitudMinima( String texto, int longitud) {
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

     
    
     

