/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import codigo.Conexion_consulta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import sistema_registro.Empleado;
import sistema_registro.SQL.ConectorSQL;

/**
 *
 * @author wianp
 */
public class SeccionesTest {
    
     Connection con = null;
   Statement stmt;
    String var, var2;
    int Contador=0;
    String CantidadAl =String.valueOf(Contador);
    String idPeriodo;
    String idAula;
    String nombreAsignaturas;
    String idSeccion;
    String codigoAsignatura;
    String horaInicial;
    String horaFinal;
    String cantidadMaxima;
    String dias;
    String nombreSeccion;
    
    
    
   public void SeccionesTest(){
   
    try{
            this.con = ConectorSQL.obtenerConexion();
        } catch (SQLException ex) {
            
            System.out.println(ex.getMessage());
   
   }
    
   }
   
   
  
   
       public void GuardarSecciones (String codigoAsignatura, String nombreSeccion, String horaInicial, String horaFinal, String idPeriodo, String idAula, String cantidadMaxima, String dias){
           
          if((idPeriodo.equals(""))){
            javax.swing.JOptionPane.showMessageDialog(null,"Debe ingresar el id del periodo" ,"Id deperiodo requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
            }
           
           if((codigoAsignatura.equals(""))){
            javax.swing.JOptionPane.showMessageDialog(null,"Debe ingresar el codigo de la asignatura.","Codigo asignatura requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }
           
           if((horaInicial.equals(""))){
            javax.swing.JOptionPane.showMessageDialog(null,"Debe ingresar la hora inicial","Hora inicial requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }
           
           if((horaFinal.equals(""))){
            javax.swing.JOptionPane.showMessageDialog(null,"Debe ingresar la hora final","Hora final requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }
           
                       
             if((idAula.equals(""))){
            javax.swing.JOptionPane.showMessageDialog(null,"Debe seleccionar una aula para la seccion","Id de aula requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
             }
             
              if((cantidadMaxima.equals(""))){
            javax.swing.JOptionPane.showMessageDialog(null,"Debe ingresar la cantidad maxima","Cantidad maxima requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
             }
           
           
  
             
        
        //int cantidad=Integer.parseInt(cadena9);
        
         if(dias.equals("")){
         javax.swing.JOptionPane.showMessageDialog(null,"Debe seleccionar los dias correspndientes","Dias requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
         }

       
      //  lbl_MensajeDias.setText(Mensaje);
       
      
        
        /*if((txt_IdSeccion.getText().equals(""))){
            javax.swing.JOptionPane.showMessageDialog(this,"Debe ingresar el id de la sección.","Id sección requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            txt_IdSeccion.requestFocus();
            return;
        }*/
        
            if((nombreSeccion.equals(""))){
            javax.swing.JOptionPane.showMessageDialog(null,"Debe ingresar el nombre de la sección.","Nombre sección requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            
            return;
        }
            
         if((codigoAsignatura.equals("Seleccione una asignatura"))){
            javax.swing.JOptionPane.showMessageDialog(null,"Debe seleccionar una asignatura para la sección.","Asignatura de la sección requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }
         
          if((horaInicial.equals(""))){
            javax.swing.JOptionPane.showMessageDialog(null,"Debe ingresar la hora inicial de la sección.","Hora inicial requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
          
            return;
        }
        
           if((horaFinal.equals(""))){
            javax.swing.JOptionPane.showMessageDialog(null,"Debe ingresar la hora final de la sección.","Hora final requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            
            return;
        }
           
         if((idPeriodo.equals("Seleccione un período"))){
            javax.swing.JOptionPane.showMessageDialog(null,"Debe seleccionar un período para la sección.","Período de la sección requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }
         
           if((idAula.equals("Seleccione un aula"))){
            javax.swing.JOptionPane.showMessageDialog(null,"Debe seleccionar una para la sección.","Aula de la sección requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }
           
        if ((dias.equals("")) ){

            javax.swing.JOptionPane.showMessageDialog(null,"¡Debe seleccionar el día de la sección!. \n","¡AVISO!",javax.swing.JOptionPane.INFORMATION_MESSAGE);
           
            return;
        }
           
                     
                    
    

        if(existeSeccion()){
            return;
        }
        
           if(existeidSeccion()){
            return;
        }

        if(!validarLongitudMinima(cantidadMaxima,1)){
            JOptionPane.showMessageDialog(null, "La cantidad máxima tiene que ser minimo de 1 caracteres", "Longitud de cantidad máxima", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        if(!validarLongitudMinima(nombreSeccion,1)){
            JOptionPane.showMessageDialog(null, "El Nombre de la sección es muy corto el mínimo es de 1 caracteres", "Longitud del nombre de la sección", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
       
/*         if(!validarLongitud(CantidadAl,1)){
            JOptionPane.showMessageDialog(null, "La cantidad de alumnos debe ser de un mínimo de 2 caracter", "Longitud de las unidades valorativas", JOptionPane.INFORMATION_MESSAGE);
            return;
        }*/
         
         if(!validarLongitudMinima(horaInicial,4)){
            JOptionPane.showMessageDialog(null, "La Hora inicial es muy corto el mínimo es de 5 caracteres", "Longitud de la hora inicial", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
       
         if(!validarLongitudMinima(horaFinal,4)){
            JOptionPane.showMessageDialog(null, "La Hora final  debe ser de un mínimo de 5 caracter", "Longitud de la hora final", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        try{
            PreparedStatement ps;


            ps=con.prepareStatement("INSERT INTO Secciones  set"
                        
            + " id_seccion = ? ,"
                    + " Nombre_seccion = ? ,"
                    + " cod_asignaturas = ? ,"
                    + " cantidad_alumnos = ? ,"
                    + "Hora_inicial = ? "
                    + "Hora_final = ? "
                    + "id_periodo = ? "
                    + "id_aula = ? "
                    + "dias = ? "
                    + "cantidad_maxima = ? "
                    + " where id_seccion ='"+idSeccion.equals("")+"'");
            ps.setString(1, idSeccion);
            ps.setString(2, nombreSeccion);
            ps.setString(3,codigoAsignatura);
            ps.setString(4,"0");
            ps.setString(5, horaInicial);
            ps.setString(6, horaFinal);
            ps.setString(7, idPeriodo);
            ps.setString(8,idAula);
            ps.setString(9, dias);
            ps.setString(10, cantidadMaxima);
            
            
            
            int res= ps.executeUpdate(); 
            JOptionPane.showMessageDialog(null, "Se ha guardado la información en Registro de Sección");
             } catch ( Exception e) {
            System.out.println(e);
        
             JOptionPane.showMessageDialog(null, e.getMessage());
        }
        

        actualizarDatos();
      
           
       }
       
       public void ActualizarSecciones( String idPeriodo, String idAula, String nombreSeccion, String codigoAsignatura, String horaInicial, String horaFinal, String cantidadMaxima, String dias){
       
       // String dias =  new Mensaje;
      //  String Seccion = nombreSeccion.setString() + " ";
          if((nombreSeccion.equals(""))){
            javax.swing.JOptionPane.showMessageDialog(null,"Debe ingresar el nombre de la sección.","Nombre sección requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            
            return;
        }
          
          if((cantidadMaxima.equals(""))){
            javax.swing.JOptionPane.showMessageDialog(null,"Debe ngresar la cantidad maxima para la sección.","Asignatura de la sección requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }
            
         if((codigoAsignatura.equals("Seleccione una asignatura"))){
            javax.swing.JOptionPane.showMessageDialog(null,"Debe seleccionar una asignatura para la sección.","Asignatura de la sección requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }
         
          if((horaInicial.equals(""))){
            javax.swing.JOptionPane.showMessageDialog(null,"Debe ingresar la hora inicial de la sección.","Hora inicial requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
           
            return;
        }
        
           if((horaFinal.equals(""))){
            javax.swing.JOptionPane.showMessageDialog(null,"Debe ingresar la hora final de la sección.","Hora final requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
         
            return;
        }
           
         if((idPeriodo.equals("Seleccione un período"))){
            javax.swing.JOptionPane.showMessageDialog(null,"Debe seleccionar un período para la sección.","Período de la sección requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }
         
           if((idAula.equals("Seleccione un aula"))){
            javax.swing.JOptionPane.showMessageDialog(null,"Debe seleccionar una para la sección.","Aula de la sección requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }
           
        if ((dias.equals(null)) ) {

            javax.swing.JOptionPane.showMessageDialog(null,"¡Debe seleccionar el día de la sección!. \n","¡AVISO!",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            
            return;
        }
        
       
            
        
            try {
                PreparedStatement ps;
                ResultSet rs;
                ps = con.prepareStatement("Update Secciones set"
                    + " id_seccion = ? ,"
                    + " Nombre_seccion = ? , "
                    + " cod_asignaturas = ? , "
                    + " Hora_inicial= ? , "
                    + " Hora_final= ? , "
                    + " id_periodo= ? , "
                    + " id_aula= ? , "
                    + "dias= ?, "
                   + "cantidad_maxima = ? "
                  + " where id_seccion =\'"+idSeccion+"\'");
                  ps.setString(1,idSeccion);
                  ps.setString(2, nombreSeccion);
                  ps.setString(3, codigoAsignatura);
                  ps.setString(4, horaInicial);
                  ps.setString(5, horaFinal);
                  ps.setString(6,idPeriodo);
                  ps.setString(7,idAula);
                  ps.setString(8,dias);
                  ps.setString(9, cantidadMaxima);
             
           
                  
            
             int res = ps.executeUpdate();
               if(res > 0){
                    JOptionPane.showMessageDialog(null, "Se ha actualizado la información de la sección " + idSeccion + " correctamente.");

                }else {
                    JOptionPane.showMessageDialog(null, "¡Error al actualizar la información!.");

                }
             
            } catch (Exception e) {
                //JOptionPane.showMessageDialog(null,e.getMessage());
                JOptionPane.showMessageDialog(null, "Error al actualizar la información de la sección, podría ser por: \n 1.La sección ya está en uso con alumnos matriculados."
                         + "\n 2. No se encuentra el código de la sección a borrar.\n 3.La sección tiene asignaturas creadas","¡Error al actualizar!", JOptionPane.ERROR_MESSAGE);
            }
            
            actualizarDatos();
            

       
       }
       
       
        public void BuscarSecciones(){
       
       actualizarDatos();
       
       }
       
       public void EliminarSecciones(  String idPeriodo, String idAula, String codigoAsignatura, String horaInicial, String horaFinal, String cantidadMaxima, String dias, String nombreSeccion){
       
      // String Seccion = nombreSeccion.setString();
          // String id_seccion = codigoAsignatura.getSelectedItem().toString().substring(0, 4) + "-" +  txt_NombreSeccion.getText();
                      if((nombreSeccion.equals(""))){
            javax.swing.JOptionPane.showMessageDialog(null,"Debe ingresar el nombre de la sección.","Nombre sección requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            
            return;
        }
            
         if((codigoAsignatura.equals("Seleccione una asignatura"))){
            javax.swing.JOptionPane.showMessageDialog(null,"Debe seleccionar una asignatura para la sección.","Asignatura de la sección requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }
         
          if((horaInicial.equals(""))){
            javax.swing.JOptionPane.showMessageDialog(null,"Debe ingresar la hora inicial de la sección.","Hora inicial requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            
            return;
        }
        
           if((horaFinal.equals(""))){
            javax.swing.JOptionPane.showMessageDialog(null,"Debe ingresar la hora final de la sección.","Hora final requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            
            return;
        }
           
         if((idPeriodo.equals("Seleccione un período"))){
            javax.swing.JOptionPane.showMessageDialog(null,"Debe seleccionar un período para la sección.","Período de la sección requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }
         
           if((idAula.equals("Seleccione un aula"))){
            javax.swing.JOptionPane.showMessageDialog(null,"Debe seleccionar una para la sección.","Aula de la sección requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }
           
        if ((dias.equals(null)) ) {

            javax.swing.JOptionPane.showMessageDialog(null,"¡Debe seleccionar el día de la sección!. \n","¡AVISO!",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            
            return;
        }
          else if (JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar el registro de sección" + nombreSeccion+ "", "Confirmación de eliminación",
            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE
        ) == JOptionPane.YES_OPTION) {

            try {
                Statement st2 = con.createStatement();
                String sql = "Delete Secciones "
                + "where id_seccion = '"+idSeccion+"' ";
                

                int rs2 = st2.executeUpdate(sql);
                System.out.println(rs2);
                if(rs2 > 0){
                    JOptionPane.showMessageDialog(null, "Se ha borrado la información de la sección" + idSeccion+ " correctamente");

                }else {
                    JOptionPane.showMessageDialog(null, "¡Error al eliminar la información!");

                }

            } catch (Exception e) {
               // JOptionPane.showMessageDialog(null, "¡Error al eliminar la información!");
               JOptionPane.showMessageDialog(null, "Error al eliminar la información de la sección, podría ser por: \n 1.La sección ya está en uso con alumnos matriculados."
                         + "\n 2. No se encuentra el código de la sección a borrar.\n 3.La sección tiene asignaturas creadas","¡Error al eliminar!", JOptionPane.ERROR_MESSAGE);
            }

        }
        actualizarDatos();
       

        
       
       }
       
        public boolean existeSeccion(){
        try {
            
            Statement st = con.createStatement();
            String sql = "Select Nombre_seccion from Secciones where Nombre_seccion = '"+nombreSeccion+"'";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                JOptionPane.showMessageDialog(null, "Ya existe esta Sección: "+nombreSeccion+" ", " Sección ¡Ya existe!", JOptionPane.INFORMATION_MESSAGE);
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
    
     public boolean existeidSeccion(){
    //      String id_seccion = codigoAsignatura.getSelectedItem().toString().substring(0, 4) + "-" +  txt_NombreSeccion.getText();
        try {
            
            Statement st = con.createStatement();
            String sql = "Select id_seccion from Secciones where id_seccion = '"+idSeccion+"'";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                JOptionPane.showMessageDialog(null, "Ya existe el id de esta sección: "+idSeccion+" ", " Id sección ¡Ya existe!", JOptionPane.INFORMATION_MESSAGE);
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

    public void actualizarDatos(){
        try {
               
               String sql = "SELECT * FROM Secciones";
               stmt = con.createStatement();
               ResultSet rs = stmt.executeQuery(sql);
               
                 while(rs.next()) {
                     
                     //Registro Anterior (Posible Error)//
                       String []datos= new String[11];
                      datos[0] =rs.getString("id_seccion");
                      datos[1] =rs.getString("Nombre_seccion");
                      datos[2] =rs.getString("cod_asignaturas");
                      datos[3] =rs.getString("cantidad_alumnos");
                      datos[4] =rs.getString("Hora_inicial");
                      datos[5] =rs.getString("Hora_final");
                      datos[6] =rs.getString("id_periodo");
                      datos[7] =rs.getString("id_aula");
                      datos[8] =rs.getString("dias");
                      datos[9] =rs.getString("cantidad_maxima");
                      
            
                 }
            
          
        }
        catch (Exception e) {
           
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
           }
    
    
       
}
