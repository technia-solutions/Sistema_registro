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
import java.text.NumberFormat;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import org.apache.commons.codec.digest.DigestUtils;
import sistema_registro.Empleado;
import sistema_registro.SQL.ConectorSQL;

/**
 *
 * @author Carlos
 */
public class EmpleadoPrueba {
    Connection con = null;
    
    public EmpleadoPrueba(){
        try {
            this.con = ConectorSQL.obtenerConexion();
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoPrueba.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void agregarEmpleado(String nombres, String apellidos, String salario, String telefono, String identidad, String idCampus, String nombreUsuario, String contraseña, String tipoUsuario){
        String nombreEmpleado = nombres + " " + apellidos;
        
         if((nombres.equals(""))){
            javax.swing.JOptionPane.showMessageDialog(null,"Debe ingresar los nombres del empleado.","Nombres empleado requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }
         
         if((apellidos.equals(""))){
             javax.swing.JOptionPane.showMessageDialog(null,"Debe ingresar los apellidos del empleado.","Apellidos del empleado requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }
         
          if((salario.equals(""))){
             javax.swing.JOptionPane.showMessageDialog(null,"Debe ingresar el salario del empleado.","Salario del empleado requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }
          
         if((telefono.equals(""))){
             javax.swing.JOptionPane.showMessageDialog(null,"Debe ingresar el teléfono del empleado.","Teléfono del empleado requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }
         
         if((identidad.equals(""))){
            javax.swing.JOptionPane.showMessageDialog(null,"Debe ingresar el número de identidad del empleado.","Número de identidad del empleado requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
         }
         
          if((nombreUsuario.equals(""))){
            javax.swing.JOptionPane.showMessageDialog(null,"Debe ingresar el nombre de usuario del empleado.","Nombre  de usuario del empleado requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
         }
        
          if((contraseña.equals(""))){
            javax.swing.JOptionPane.showMessageDialog(null,"Debe ingresar la contraseña del usuario del empleado.","Contraseña de usuario del empleado requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
         }
          
           if((idCampus.equals(""))){
            javax.swing.JOptionPane.showMessageDialog(null,"Debe seleccionar un campus para el empleado","Campus del empleado requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }
           
            if((tipoUsuario.equals(""))){
            javax.swing.JOptionPane.showMessageDialog(null,"Debe seleccionar un tipo de usuario para el empleado","Tipo de usuario del empleado requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }
       
        
        if(existeEmpleado(identidad)){
            return;
        }
        
        if(existeUsuario(nombreUsuario)){
            return;
        }
        
       
        if(!validarSalario(salario)){
            return;
        }
        
        if(!validarLongitudTelefono(telefono,8)){
            return;
        }
        
        
        
        if(!validarIdentidad(identidad)){
            return;
            
        }
        
        
        if(!validarLongitud(nombres,5)){
            JOptionPane.showMessageDialog(null, "Los nombres ingresados son muy pequeños el mínimo es de 5 caracteres", "Longitud de los nombres", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
         if(!validarLongitud(apellidos,5)){
            JOptionPane.showMessageDialog(null, "Los apellidos ingresados son muy pequeños el mínimo es de 5 caracteres", "Longitud de los apellidos", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
         
         if(!validarLongitud(salario,4)){
             
            JOptionPane.showMessageDialog(null, "El salario debe ser de mínimo 4 dígitos", "Longitud del salario", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
         
         
         
          if(!validarLongitud(nombreUsuario,8)){
            JOptionPane.showMessageDialog(null, "El nombre de usuario debe ser de mínimo 8 caracteres", "Longitud del nombre de usuario", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
             if (!validarLongitudMax(apellidos, 40)) {
            JOptionPane.showMessageDialog(null, "Los apellidos del empleado ingresados son muy largos el máximo es de 40 caracteres, usted ingresó " + apellidos.length() + " caracteres.", "Longitud de los apellidos del empleado", JOptionPane.INFORMATION_MESSAGE);
            return;
            }
           if (!validarLongitudMax(salario, 10)) {
            JOptionPane.showMessageDialog(null, "El salario del empleado ingresado es muy largo el máximo es de 10 dígitos, usted ingresó " + salario.length() + " dígitos.", "Longitud del salario del empleado", JOptionPane.INFORMATION_MESSAGE);
            return;
            }
           
           if (!validarLongitudMax(telefono, 8)) {
            JOptionPane.showMessageDialog(null, "El teléfono del empleado ingresado es muy largo el máximo es de 8 dígitos, usted ingresó " + telefono.length() + " dígitos.", "Longitud del teléfono del empleado", JOptionPane.INFORMATION_MESSAGE);
            return;
            }
           
           if (!validarLongitudMax(identidad, 13)) {
            JOptionPane.showMessageDialog(null, "El salario del empleado ingresado es muy largo el máximo es de 13 dígitos, usted ingresó " + identidad.length() + " dígitos.", "Longitud del número de identidad del empleado", JOptionPane.INFORMATION_MESSAGE);
            return;
            }
           if (!validarLongitudMax(nombreUsuario, 25)) {
            JOptionPane.showMessageDialog(null, "El nombre de usuario del empleado ingresado es muy largo el máximo es de 25 caracteres, usted ingresó " + nombreUsuario.length() + " caracteres.", "Longitud del nombre de usuario del empleado", JOptionPane.INFORMATION_MESSAGE);
            return;
            }
           if (!validarLongitudMax(contraseña, 25)) {
            JOptionPane.showMessageDialog(null, "La contraseña del empleado ingresada es muy larga el máximo es de 25 caracteres, usted ingresó " + contraseña.length() + " caracteres.", "Longitud de la contraseña del empleado", JOptionPane.INFORMATION_MESSAGE);
            return;
            }
           
           if (!validarLongitudMax(idCampus, 4)) {
            JOptionPane.showMessageDialog(null, "El Id del campus del empleado ingresado es muy largo el máximo es de 4 caracteres, usted ingresó " + idCampus.length() + " caracteres.", "Longitud del Id del campus del empleado", JOptionPane.INFORMATION_MESSAGE);
            return;
            }
           
           if (!validarLongitudMax(tipoUsuario, 1)) {
            JOptionPane.showMessageDialog(null, "El tipo de usuario del empleado ingresado es muy largo el máximo es de 1 caracter, usted ingresó " + tipoUsuario.length() + " caracteres.", "Longitud del tipo de usuario del empleado", JOptionPane.INFORMATION_MESSAGE);
            return;
            }
           
        
        if(!validarContraseñas(contraseña)){
            return;
        }
        if(contieneNumerosYSimbolos(nombres)){
            JOptionPane.showMessageDialog(null, "Los nombres sólo pueden contener letras");
            return;
            }
           if(contieneNumerosYSimbolos(apellidos)){
            JOptionPane.showMessageDialog(null, "Los apellidos sólo pueden contener letras");
            return;
            }
           
           if(contieneLetrasYSimbolos(salario)){
            JOptionPane.showMessageDialog(null, "El salario sólo puede contener números");
            return;
            }
           if(contieneLetrasYSimbolos(telefono)){
            JOptionPane.showMessageDialog(null, "El teléfono sólo puede contener números");
            return;
            }
           if(contieneLetrasYSimbolos(identidad)){
            JOptionPane.showMessageDialog(null, "El número de identidad sólo puede contener números");
            return;
            }
           if(contieneLetrasYSimbolos(salario)){
            JOptionPane.showMessageDialog(null, "El salario sólo puede contener números");
            return;
            }
           if(contieneSimbolos(nombreUsuario)){
            JOptionPane.showMessageDialog(null, "El nombre de usuario no puede contener símbolos");
            return;
            }
           if(validacionSimbolosContraseña(contraseña)){
            JOptionPane.showMessageDialog(null, "La contraseña no puede contener espacios ( ) o barras largas (|) ");
            return;
            }
           if(contieneLetrasYSimbolos(salario)){
            JOptionPane.showMessageDialog(null, "El salario sólo puede contener números");
            return;
            }
           if(contieneSimbolos(idCampus)){
            JOptionPane.showMessageDialog(null, "El Id del campus no puede contener símbolos");
            return;
            }
           if(contieneNumerosYSimbolos(tipoUsuario)){
            JOptionPane.showMessageDialog(null, "El tipo de usuario solo puede contener letras");
            return;
            }
       
      try{
          PreparedStatement ps;
          ResultSet rs;
        
          ps=con.prepareStatement("INSERT INTO Empleados (nombres_empleado, apellido_empleado, telefono_empleado, id_campus, salario, numero_identidad)"
                  + "                VALUES(?,?,?,?,?,?)");
                  ps.setString(1, nombres);
                  ps.setString(2, apellidos);
                  ps.setString(3, telefono);
                  ps.setString(4, idCampus);
                  ps.setString(5, salario);
                  ps.setString(6, identidad);
                  int res= ps.executeUpdate();
      } catch ( Exception e) {
            System.out.println(e);
        }
         try{
             Statement st2=con.createStatement();
            String contraseñaEncriptada=DigestUtils.md5Hex(contraseña);
            String estadoDelUsuario = "";
            if(tipoUsuario.equals("A")){
                estadoDelUsuario = "Administrador";
            }
            else{
                 estadoDelUsuario = "Activo";
            }
            
            String sql ="Insert into Acceso(nombre_usuario,clave_acceso,id_tipoUsuario,estado,intentos) values('"+nombreUsuario+"','"+contraseñaEncriptada+"','"+tipoUsuario+"','"+estadoDelUsuario+"',0)";
            int rs2 = st2.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Se ha guardado la informacion del empleado "+nombreEmpleado+" correctamente");
          }catch ( Exception e) {
           JOptionPane.showMessageDialog(null, e.getMessage()); 
        }
   
    }
    
    public void actualizarEmpleado(String nombres, String apellidos, String salario, String telefono, String identidad, String idCampus, String nombreUsuario, String contraseña, String tipoUsuario){
        String nombreEmpleado = nombres + " " + apellidos;
        
        if(JOptionPane.showConfirmDialog(null,"¿Está seguro que desea actualizar el registro del empleado "+nombreEmpleado+"?","Confirmación de actualización",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE
        )==JOptionPane.YES_OPTION){ 
     String contraseñaEncriptada=DigestUtils.md5Hex(contraseña);
  
 
     
     if((nombres.equals(""))){
            javax.swing.JOptionPane.showMessageDialog(null,"Debe ingresar los nombres del empleado.","Nombres empleado requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }
         
         if((apellidos.equals(""))){
             javax.swing.JOptionPane.showMessageDialog(null,"Debe ingresar los apellidos del empleado.","Apellidos del empleado requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }
         
          if((salario.equals(""))){
             javax.swing.JOptionPane.showMessageDialog(null,"Debe ingresar el salario del empleado.","Salario del empleado requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }
          
         if((telefono.equals(""))){
             javax.swing.JOptionPane.showMessageDialog(null,"Debe ingresar el teléfono del empleado.","Teléfono del empleado requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }
         
         if((identidad.equals(""))){
            javax.swing.JOptionPane.showMessageDialog(null,"Debe ingresar el número de identidad del empleado.","Número de identidad del empleado requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
         }
         
          if((nombreUsuario.equals(""))){
            javax.swing.JOptionPane.showMessageDialog(null,"Debe ingresar el nombre de usuario del empleado.","Nombre  de usuario del empleado requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
         }
        
          if((contraseña.equals(""))){
            javax.swing.JOptionPane.showMessageDialog(null,"Debe ingresar la contraseña del usuario del empleado.","Contraseña de usuario del empleado requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
         }
          
           if((idCampus.equals(""))){
            javax.swing.JOptionPane.showMessageDialog(null,"Debe seleccionar un campus para el empleado","Campus del empleado requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }
           
            if((tipoUsuario.equals(""))){
            javax.swing.JOptionPane.showMessageDialog(null,"Debe seleccionar un tipo de usuario para el empleado","Tipo de usuario del empleado requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }
       
        
        if(existeEmpleado(identidad)){
            return;
        }
        
        if(existeUsuario(nombreUsuario)){
            return;
        }
        
       
        if(!validarSalario(salario)){
            return;
        }
        
        if(!validarLongitudTelefono(telefono,8)){
            return;
        }
        
        
        
        if(!validarIdentidad(identidad)){
            return;
            
        }
        
        
        if(!validarLongitud(nombres,5)){
            JOptionPane.showMessageDialog(null, "Los nombres ingresados son muy pequeños el mínimo es de 5 caracteres", "Longitud de los nombres", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
         if(!validarLongitud(apellidos,5)){
            JOptionPane.showMessageDialog(null, "Los apellidos ingresados son muy pequeños el mínimo es de 5 caracteres", "Longitud de los apellidos", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
         
         if(!validarLongitud(salario,4)){
             
            JOptionPane.showMessageDialog(null, "El salario debe ser de mínimo 4 dígitos", "Longitud del salario", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
         
         
          if(!validarLongitud(nombreUsuario,8)){
            JOptionPane.showMessageDialog(null, "El nombre de usuario debe ser de mínimo 8 caracteres", "Longitud del nombre de usuario", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
          
           if (!validarLongitudMax(nombres, 40)) {
            JOptionPane.showMessageDialog(null, "Los nombres del empleado ingresados son muy largos el máximo es de 40 caracteres, usted ingresó " + nombres.length() + " caracteres.", "Longitud de los nombres del empleado", JOptionPane.INFORMATION_MESSAGE);
            return;
            }
           
           if (!validarLongitudMax(apellidos, 40)) {
            JOptionPane.showMessageDialog(null, "Los apellidos del empleado ingresados son muy largos el máximo es de 40 caracteres, usted ingresó " + apellidos.length() + " caracteres.", "Longitud de los apellidos del empleado", JOptionPane.INFORMATION_MESSAGE);
            return;
            }
           if (!validarLongitudMax(salario, 10)) {
            JOptionPane.showMessageDialog(null, "El salario del empleado ingresado es muy largo el máximo es de 10 dígitos, usted ingresó " + salario.length() + " dígitos.", "Longitud del salario del empleado", JOptionPane.INFORMATION_MESSAGE);
            return;
            }
           
           if (!validarLongitudMax(telefono, 8)) {
            JOptionPane.showMessageDialog(null, "El teléfono del empleado ingresado es muy largo el máximo es de 8 dígitos, usted ingresó " + telefono.length() + " dígitos.", "Longitud del teléfono del empleado", JOptionPane.INFORMATION_MESSAGE);
            return;
            }
           
           if (!validarLongitudMax(identidad, 13)) {
            JOptionPane.showMessageDialog(null, "El salario del empleado ingresado es muy largo el máximo es de 13 dígitos, usted ingresó " + identidad.length() + " dígitos.", "Longitud del número de identidad del empleado", JOptionPane.INFORMATION_MESSAGE);
            return;
            }
           if (!validarLongitudMax(nombreUsuario, 25)) {
            JOptionPane.showMessageDialog(null, "El nombre de usuario del empleado ingresado es muy largo el máximo es de 25 caracteres, usted ingresó " + nombreUsuario.length() + " caracteres.", "Longitud del nombre de usuario del empleado", JOptionPane.INFORMATION_MESSAGE);
            return;
            }
           if (!validarLongitudMax(contraseña, 25)) {
            JOptionPane.showMessageDialog(null, "La contraseña del empleado ingresada es muy larga el máximo es de 25 caracteres, usted ingresó " + contraseña.length() + " caracteres.", "Longitud de la contraseña del empleado", JOptionPane.INFORMATION_MESSAGE);
            return;
            }
           
           if (!validarLongitudMax(idCampus, 4)) {
            JOptionPane.showMessageDialog(null, "El Id del campus del empleado ingresado es muy largo el máximo es de 4 caracteres, usted ingresó " + idCampus.length() + " caracteres.", "Longitud del Id del campus del empleado", JOptionPane.INFORMATION_MESSAGE);
            return;
            }
           
           if (!validarLongitudMax(tipoUsuario, 1)) {
            JOptionPane.showMessageDialog(null, "El tipo de usuario del empleado ingresado es muy largo el máximo es de 1 caracter, usted ingresó " + tipoUsuario.length() + " caracteres.", "Longitud del tipo de usuario del empleado", JOptionPane.INFORMATION_MESSAGE);
            return;
            }
           if(contieneNumerosYSimbolos(nombres)){
            JOptionPane.showMessageDialog(null, "Los nombres sólo pueden contener letras");
            return;
            }
           if(contieneNumerosYSimbolos(apellidos)){
            JOptionPane.showMessageDialog(null, "Los apellidos sólo pueden contener letras");
            return;
            }
           
           if(contieneLetrasYSimbolos(salario)){
            JOptionPane.showMessageDialog(null, "El salario sólo puede contener números");
            return;
            }
           if(contieneLetrasYSimbolos(telefono)){
            JOptionPane.showMessageDialog(null, "El teléfono sólo puede contener números");
            return;
            }
           if(contieneLetrasYSimbolos(identidad)){
            JOptionPane.showMessageDialog(null, "El número de identidad sólo puede contener números");
            return;
            }
       
           if(contieneSimbolos(nombreUsuario)){
            JOptionPane.showMessageDialog(null, "El nombre de usuario no puede contener símbolos");
            return;
            }
           if(validacionSimbolosContraseña(contraseña)){
            JOptionPane.showMessageDialog(null, "La contraseña no puede contener espacios ( ) o barras largas (|) ");
            return;
            }
           if(contieneLetrasYSimbolos(salario)){
            JOptionPane.showMessageDialog(null, "El salario sólo puede contener números");
            return;
            }
           if(contieneSimbolos(idCampus)){
            JOptionPane.showMessageDialog(null, "El Id del campus no puede contener símbolos");
            return;
            }
           if(contieneNumerosYSimbolos(tipoUsuario)){
            JOptionPane.showMessageDialog(null, "El tipo de usuario solo puede contener letras");
            return;
            }
           
        if(!validarContraseñas(contraseña)){
            return;
        }
         try{
          Statement ps = con.createStatement();
          String cons = "Update Empleados "
                  + "set nombres_empleado = '"+nombres+"',"
                  + "apellido_empleado =  '"+apellidos+"', "
                  + "telefono_empleado = '"+telefono+"', "
                  + "id_campus = '"+idCampus+"', "
                  + "salario = '"+salario+"', "
                  + "numero_identidad = '"+identidad+"'"
                  + "where numero_identidad = '"+identidad+"'";
          int re = ps.executeUpdate(cons);
        } catch ( Exception e) {
            System.out.println(e);
        }
         try{
             if(contraseña.equals("")){
              Statement st2=con.createStatement();
            
              String sql ="Update Acceso "
                      + "set nombre_usuario = '"+nombreUsuario+"'"
                      + ",id_tipoUsuario= '"+tipoUsuario+"'"
                      + "where id_empleado = (Select id_empleado from Acceso where nombre_usuario = '"+nombreUsuario+"')";
               int rs2 = st2.executeUpdate(sql);
              JOptionPane.showMessageDialog(null, "Se ha actualizado la información del empleado "+nombreEmpleado+" correctamente.");
              return;
             }
             
             Statement st2=con.createStatement();
            
              String sql ="Update Acceso "
                      + "set nombre_usuario = '"+nombreUsuario+"'"
                      + ",clave_acceso = '"+contraseñaEncriptada+"',"
                      + "id_tipoUsuario= '"+tipoUsuario+"'"
                      + "where id_empleado = (Select id_empleado from Acceso where nombre_usuario = '"+nombreUsuario+"')";
               int rs2 = st2.executeUpdate(sql);
              JOptionPane.showMessageDialog(null, "Se ha actualizado la información del empleado "+nombreEmpleado+" correctamente.");
          }catch ( Exception e) {
           JOptionPane.showMessageDialog(null, e.getMessage()); 
            }
         }
     
    }
    
    public void eliminarEmpleado(String nombreUsuario, String identidad){
          String nombreEmpleado ="";
          Statement st3;
          
           if(noexisteEmpleado(identidad)){
            return;
        }
        
        if(noexisteUsuario(nombreUsuario)){
            return;
        }
        
        try {
            st3 = con.createStatement();
            String sql2 = "Select * from Empleados where numero_identidad = '"+identidad+"'";
            ResultSet rs2 = st3.executeQuery(sql2);
            if(rs2.next()){
                nombreEmpleado = rs2.getString("nombres_empleado") + " " + rs2.getString("apellido_empleado");
            }
            else{
                JOptionPane.showMessageDialog(null, "El empleado no existe");
                return;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoPrueba.class.getName()).log(Level.SEVERE, null, ex);
        }
          
    
           if(JOptionPane.showConfirmDialog(null,"¿Está seguro que desea eliminar el registro del empleado "+nombreEmpleado+"","Confirmación de eliminación",
                   JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE
            )==JOptionPane.YES_OPTION){   
       try{
             Statement st2=con.createStatement();
              String sql ="Delete Acceso "
                      + "where id_empleado = (Select id_empleado from Acceso where nombre_usuario = '"+nombreUsuario+"')";
               int res2 = st2.executeUpdate(sql);
          }catch ( Exception e) {
           JOptionPane.showMessageDialog(null, e.getMessage()); 
        }
      try{
          PreparedStatement ps;
          ResultSet rs;
         Statement st=con.createStatement();
         String sql ="Delete Empleados "
                      + "where numero_identidad = "+identidad+"";
                  int res=st.executeUpdate(sql);
                  if(res > 0){ 
                      JOptionPane.showMessageDialog(null, "Se ha borrado la información del empleado "+nombreEmpleado+" correctamente"); 
                  }else {
                      JOptionPane.showMessageDialog(null, "¡Error al eliminar la información!"); 
                  }
      } catch ( Exception e) {
            System.out.println(e);
        }
         }
    }
    
    public void consultarEmpleado(){
         try {
               String sql = "select * from Empleados as e join Acceso as a on e.id_empleado = a.id_empleado join\n" +
"                Campus as c on c.id_campus = e.id_campus join \n" +
"               Tipo_Usuarios as t on a.id_tipoUsuario =  t.id_tipoUsuario order by e.id_empleado ";
               Statement stmt = con.createStatement();
               ResultSet rs = stmt.executeQuery(sql);
               Locale locale = new Locale("es", "HN");      
               NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
               NumberFormat formatter = NumberFormat.getCurrencyInstance();
               String encabezado [] = {"Id Empleado","Nombres","Apellidos","Salario","Teléfono","Número de identidad","Nombre Campus","Nombre Usuario","Tipo Usuario"};
               System.out.println("\n=========================");
               while(rs.next()) {
                      String []datos= new String[9];
                      datos[0] =rs.getString("id_empleado");
                      datos[1] =rs.getString("nombres_empleado");
                      datos[2] =rs.getString("apellido_empleado");
                      datos[3] =currencyFormatter.format(rs.getDouble("salario"));
                      datos[4] =rs.getString("telefono_empleado");
                      datos[5] =rs.getString("numero_identidad");
                      datos[6] =rs.getString("nombre_campus");
                      datos[7] =rs.getString("nombre_usuario");
                      datos[8] = rs.getString("Tipo_Usuario");
                    
                      for (int i = 0; i < datos.length; i++) {
                          System.out.println(encabezado[i] +": " + datos[i]);  
                     }
                      System.out.println("=========================");
                
               }
                
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }
    
    public void consultaIndividualEmpleado(String var){
        if(var == null)
            JOptionPane.showMessageDialog(null,"La acción fue cancelada","¡AVISO!",JOptionPane.INFORMATION_MESSAGE);
               else {
                     if (var.equals("")) {
                            JOptionPane.showMessageDialog(null,"Favor de ingresar los datos del empleado\n que desea consultar","¡AVISO!",JOptionPane.INFORMATION_MESSAGE);
                        }
                        else{
            try {
               String sql = "select * from Empleados as e join Acceso as a on e.id_empleado = a.id_empleado join\n" +
                            "Campus as c on c.id_campus = e.id_campus join \n" +
                            "Tipo_Usuarios as t on a.id_tipoUsuario =  t.id_tipoUsuario\n" +
                            "where nombres_empleado = '"+var+"' or apellido_empleado = '"+var+"' or numero_identidad = '"+var+"'";
               Statement stmt = con.createStatement();
               ResultSet rs = stmt.executeQuery(sql);
               Locale locale = new Locale("es", "HN");      
               NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
               NumberFormat formatter = NumberFormat.getCurrencyInstance();
               String encabezado [] = {"Id Empleado","Nombres","Apellidos","Salario","Teléfono","Número de identidad","Nombre Campus","Nombre Usuario","Tipo Usuario"};
                if(!rs.next()){
                    System.out.println("No se pudo encontrar los datos solicitados, "+var+" no es ni: \n1. Nombres del empleado. \n2. Apellidos del empleado. \n3. Número de identidad del empleado.");
                    return;
                }
               while(rs.next()) {
                      String []datos= new String[9];
                      datos[0] =rs.getString("id_empleado");
                      datos[1] =rs.getString("nombres_empleado");
                      datos[2] =rs.getString("apellido_empleado");
                      datos[3] =currencyFormatter.format(rs.getDouble("salario"));
                      datos[4] =rs.getString("telefono_empleado");
                      datos[5] =rs.getString("numero_identidad");
                      datos[6] =rs.getString("nombre_campus");
                      datos[7] =rs.getString("nombre_usuario");
                      datos[8] = rs.getString("Tipo_Usuario");
                      
                      System.out.println("=========================");
                      for (int i = 0; i < datos.length; i++) {
                          System.out.println(encabezado[i] +": " + datos[i]);  
                     }
                      System.out.println("=========================");
                
               }
                
                }
                catch (Exception e) {
                    JOptionPane.showMessageDialog(null,e.getMessage());
                } 
            }
       }
    }
    
    public void desbloquearUsuario(){
        String var = JOptionPane.showInputDialog(null,"Ingrese el nombre de usuario del empleado que desea desbloquar","Desbloqueo de usuarios",JOptionPane.QUESTION_MESSAGE);
            if(var == null){
                JOptionPane.showMessageDialog(null,"La acción fue cancelada","¡AVISO!",JOptionPane.INFORMATION_MESSAGE);
            }
                else if (var.equals("")) {
                        JOptionPane.showMessageDialog(null,"¡Por favor ingrese el nombre de usuario que desea desbloquear!","¡AVISO!",JOptionPane.INFORMATION_MESSAGE);
                                    }
                else{
                    try {
                        String sql = "update Acceso \n" +
                                     "set estado ='Activo',\n" +
                                     "intentos = 0"
                                     +"where nombre_usuario ='"+var+"'";
                    Statement stmt = con.createStatement();
                    int rs = stmt.executeUpdate(sql);
                    if(rs >0){
                        JOptionPane.showMessageDialog(null,"Se ha desbloqueado exitosamente al usuario: "+var+"","Usuario desbloquedo satisfactoriamente",JOptionPane.INFORMATION_MESSAGE);
                    }
                    else{
                               JOptionPane.showMessageDialog(null,"¡No se encuentra el nombre de usuario! Por favor verifique sí, lo escribió correctamente","Nombre de usuario no encontrado",JOptionPane.ERROR_MESSAGE);
                            }
                    } catch (SQLException ex) {
                        Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
    }
    
     private boolean validarLongitud(String texto, int longitud){
       if(texto.length() >= longitud){
           return true;
       }
       else{
           return false;
       }
    }
    private boolean validarLongitudTelefono(String texto, int longitud){
       if(texto.length() == longitud){
                Pattern pattern = Pattern.compile("[23789]");
                Matcher matcher=pattern.matcher(texto.substring(0,1));
                if(matcher.matches()){ 
                        return true;
                    }else{
                        JOptionPane.showMessageDialog(null, "El número de teléfono debe comenzar con: 2,3,7,8 o 9");
                        return false;
                    } 
       }
        else{
       }
       JOptionPane.showMessageDialog(null, "El número de teléfono debe ser de 8 dígitos", "Longitud del número de telefono",JOptionPane.INFORMATION_MESSAGE);
       return false;
    }
    
    private boolean validarLongitudSalario(String texto, int longitud){
       if(texto.length() == longitud){
                Pattern pattern = Pattern.compile("[123456789]");
                Matcher matcher=pattern.matcher(texto.substring(0,1));
                if(matcher.matches()){ 
                        return true;
                    }else{
                        JOptionPane.showMessageDialog(null, "El salario no puede comenzar con 0");
                        return false;
                    } 
       }
        else{
       }
       JOptionPane.showMessageDialog(null, "El salario debe ser de mínimo 4 dígitos", "Longitud del salario", JOptionPane.INFORMATION_MESSAGE);
       return false;
    }
    
     public boolean existeUsuario(String usuario){
        try {
            Statement st = con.createStatement();
            String sql = "Select nombre_usuario from Acceso where nombre_usuario = '"+usuario+"'";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                JOptionPane.showMessageDialog(null, "Ya existe el nombre de usuario: "+usuario+" ", "Nombre de usuario ¡Ya existe!", JOptionPane.INFORMATION_MESSAGE);
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
    
    public boolean existeEmpleado(String idEmpleado){
        try {
            Statement st = con.createStatement();
            String sql = "Select numero_identidad from Empleados where numero_identidad = '"+idEmpleado+"'";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                JOptionPane.showMessageDialog(null, "El número de identidad: "+idEmpleado+" ya existe", "Número de identidad ¡Ya existe!", JOptionPane.INFORMATION_MESSAGE);
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

    public boolean validarContraseñas(String contraseña){
        if(contraseña.length() > 7){
             if(politicasContraseña(contraseña)){
                 return true;
             }
             else{
                 JOptionPane.showMessageDialog(null, "La contraseña no cumple las siguientes directrices: \n 1. Debe contener al menos una letra minúscula (a-z)"
                         + "\n 2. Debe contener al menos una letra mayúscula (A-Z) \n 3. Debe contener al menos un número (0-9)", "¡Directrices de contraseña no cumplidas!", JOptionPane.ERROR_MESSAGE);
                 return false;
             }
        }
        else{
            JOptionPane.showMessageDialog(null, "La contraseña es muy pequeña debe ser de al menos 8 caracteres.", "Longitud de contraseña menor al requerido", JOptionPane.ERROR_MESSAGE); 
           return false; 
        }    
    }
    
     public boolean validarSalario(String salario){
           String salario2; 
          //  salario2=txt_Salario.toString().substring(0,1)
        if(salario.length() < 10){
             if(!"0".equals(salario.substring(0,1))){
                 return true;
             }
             else{
                 JOptionPane.showMessageDialog(null, "El campo salario no puede comenzar con 0 ", "Error en campo salario", JOptionPane.ERROR_MESSAGE);
                 return false;
             }
        }
        else{
            
           return false; 
        }    
    }
     
      public boolean validarIdentidad(String identidad){
        String id = identidad.substring(0, 1);
        
        if(identidad.length() < 13){
             JOptionPane.showMessageDialog(null, "El número de identidad es de 13 dígitos, usted ha ingresado solamente "+identidad.length()+" dígitos.", "Número de identidad muy corto", JOptionPane.ERROR_MESSAGE);
        }
        if(identidad.length() == 13){
             if("0".equals(id)){
                 return true;
             }
             else if("1".equals(id)){
                 return true;
             }
             else{
                 JOptionPane.showMessageDialog(null, "El número de identidad sólo puede comenzar con 0 o 1 ", "Error en campo identidad", JOptionPane.ERROR_MESSAGE);
                 return false;
             }
        }
        else{
           return false; 
        }    
    }
    
    
    
    public boolean politicasContraseña(String contraseña){
        boolean tieneNumero = false; 
        boolean tieneMayusculas = false; 
        boolean tieneMinusculas = false;
        char c;
        
        for(int i=0; i<contraseña.length();i++){
            c = contraseña.charAt(i);
            if(Character.isDigit(c)){
                tieneNumero = true;
            }
            else if(Character.isUpperCase(c)){
                tieneMayusculas = true;
            }
            else if(Character.isLowerCase(c)){
                tieneMinusculas = true;
            }
            if(tieneNumero && tieneMayusculas && tieneMinusculas){
                return true;
            }
        }
        return false;
    }
    
 
      private boolean validarLongitudMax(String texto, int longitud) {
        if (texto.length() <= longitud) {
            return true;
        } else {
            return false;
        }
    }
      
      private boolean contieneNumerosYSimbolos(String texto){
          for (int i = 0; i < texto.length(); i++) {
               if(Character.isDigit(texto.charAt(i)) || !Character.isLetterOrDigit(texto.charAt(i)))
                  return true;
          }
          return false;
      }
      
      private boolean contieneLetrasYSimbolos(String texto){
          for (int i = 0; i < texto.length(); i++) {
              if(Character.isLetter(texto.charAt(i)) || !Character.isLetterOrDigit(texto.charAt(i)))
                  return true;
          }
          return false;
      }
      
      private boolean contieneNumeros(String texto){
          for (int i = 0; i < texto.length(); i++) {
              if(Character.isDigit(texto.charAt(i)))
                  return true;
          }
          return false;
      }
      
      private boolean contieneSimbolos(String texto){
          for (int i = 0; i < texto.length(); i++) {
              if(!Character.isLetterOrDigit(texto.charAt(i)))
                  return true;
          }
          return false;
      }
      
      private boolean validacionSimbolosContraseña(String texto){
          for (int i = 0; i < texto.length(); i++) {
              if(texto.contains(" ") || texto.contains("|"))
                  return true;
          }
          return false;
      }
      
       public boolean noexisteUsuario(String usuario){
        try {
            Statement st = con.createStatement();
            String sql = "Select nombre_usuario from Acceso where nombre_usuario = '"+usuario+"'";
            ResultSet rs = st.executeQuery(sql);
            if(!rs.next()){
                JOptionPane.showMessageDialog(null, "No existe el nombre de usuario: "+usuario+" ", "Nombre de usuario ¡No existe!", JOptionPane.INFORMATION_MESSAGE);
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
    
    public boolean noexisteEmpleado(String idEmpleado){
        try {
            Statement st = con.createStatement();
            String sql = "Select numero_identidad from Empleados where numero_identidad = '"+idEmpleado+"'";
            ResultSet rs = st.executeQuery(sql);
            if(!rs.next()){
                JOptionPane.showMessageDialog(null, "El número de identidad: "+idEmpleado+" no existe", "Número de identidad ¡No existe!", JOptionPane.INFORMATION_MESSAGE);
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
                                        
}
