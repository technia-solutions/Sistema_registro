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
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import sistema_registro.Empleado;
import sistema_registro.SQL.ConectorSQL;

/**
 *
 * @author Carlos
 */
public class AlumnoPrueba {
    Connection con;
    
    public AlumnoPrueba(){
         try {
             this.con = ConectorSQL.obtenerConexion();
         } catch (SQLException ex) {
             System.out.println(ex.getMessage());
         }
    }
    
    public void agregarAlumno(String nombreAlumno, String apellidoAlumno, String identidad ,String telefonoAlumno, String fechaNacimiento, String idCarrera, String idPeriodo, String idCampus){
        String numeroDeCuenta = "";

        String periodo = idPeriodo + "0";

        if((nombreAlumno.equals(""))){
            javax.swing.JOptionPane.showMessageDialog(null,"Debe ingresar los nombres del alumno.","Nombres del alumno requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        if((apellidoAlumno.equals(""))){
             javax.swing.JOptionPane.showMessageDialog(null,"Debe ingresar los apellidos del alumno.","Apellidos del alumno requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        if((telefonoAlumno.equals(""))){
             javax.swing.JOptionPane.showMessageDialog(null,"Debe ingresar el teléfono del alumno.","Teléfono del alumno requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        if((identidad.equals(""))){
            javax.swing.JOptionPane.showMessageDialog(null,"Debe ingresar el número de identidad del alumno.","Número de identidad del alumno requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
         }
        
        
        if((idCarrera.equals(""))){
            javax.swing.JOptionPane.showMessageDialog(null,"Debe seleccionar una carrera para el alumno.","Carrera del alumno requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
         if((idPeriodo.equals(""))){
            javax.swing.JOptionPane.showMessageDialog(null,"Debe seleccionar el período de inscripción del alumno.","Período de inscripción del alumno requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }
         
          if((idCampus.equals(""))){
            javax.swing.JOptionPane.showMessageDialog(null,"Debe seleccionar un campus para el alumno.","Campus del alumno requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }
          
     
        if((fechaNacimiento.equals(""))){
             javax.swing.JOptionPane.showMessageDialog(null,"Debe ingresar la fecha de nacimiento del alumno.","Fecha de nacimiento del alumno requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
       
    
        
        if(existeAlumno(identidad)){
            return;
        }
        
         
        if(!validarLongitud(nombreAlumno,5)){
            JOptionPane.showMessageDialog(null, "Los nombres ingresados son muy pequeños el mínimo es de 5 caracteres", "Longitud de los nombres", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
         if(!validarLongitud(apellidoAlumno,5)){
            JOptionPane.showMessageDialog(null, "Los apellidos ingresados son muy pequeños el mínimo es de 5 caracteres", "Longitud de los apellidos", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        
        
         
         if (!validarLongitudMax(nombreAlumno, 40)) {
            JOptionPane.showMessageDialog(null, "Los nombres del alumno ingresados son muy largos el máximo es de 40 caracteres, usted ingresó " + nombreAlumno.length() + " caracteres.", "Longitud de los nombres del alumno", JOptionPane.INFORMATION_MESSAGE);
            return;
            }
         
          if (!validarLongitudMax(apellidoAlumno, 40)) {
            JOptionPane.showMessageDialog(null, "Los apellidos del alumno ingresados son muy largos el máximo es de 40 caracteres, usted ingresó " + apellidoAlumno.length() + " caracteres.", "Longitud de los apellidos del alumno", JOptionPane.INFORMATION_MESSAGE);
            return;
            }
          
           if (!validarLongitudMax(telefonoAlumno, 8)) {
            JOptionPane.showMessageDialog(null, "El teléfono del alumno ingresado es muy largo el máximo es de 8 dígitos, usted ingresó " + telefonoAlumno.length() + " dígitos.", "Longitud del teléfono del alumno", JOptionPane.INFORMATION_MESSAGE);
            return;
            }
           
           if (!validarLongitudMax(identidad, 13)) {
            JOptionPane.showMessageDialog(null, "El numero de identidad del alumno ingresado es muy largo el máximo es de 13 dígitos, usted ingresó " + identidad.length() + " dígitos.", "Longitud del número de identidad del alumno", JOptionPane.INFORMATION_MESSAGE);
            return;
            }
           
           if (!validarLongitudMax(idCarrera, 4)) {
            JOptionPane.showMessageDialog(null, "El id de la carrera del alumno ingresado es muy largo el máximo es de 4 caracteres, usted ingresó " + idCarrera.length() + " dígitos.", "Longitud del id de la carrera del alumno", JOptionPane.INFORMATION_MESSAGE);
            return;
            }
           
           if (!validarLongitudMax(idPeriodo, 3)) {
            JOptionPane.showMessageDialog(null, "El id del período del alumno ingresado es muy largo el máximo es de 3 caracteres, usted ingresó " + idPeriodo.length() + " dígitos.", "Longitud del id del periodo de ingreso del alumno", JOptionPane.INFORMATION_MESSAGE);
            return;
            }
           
           if (!validarLongitudMax(idCampus, 4)) {
            JOptionPane.showMessageDialog(null, "El id del campus del alumno ingresado es muy largo el máximo es de 4 caracteres, usted ingresó " + idCampus.length() + " dígitos.", "Longitud del id del campus de ingreso del alumno", JOptionPane.INFORMATION_MESSAGE);
            return;
            }
           
           if (!validarLongitudMax(fechaNacimiento, 10)) {
            JOptionPane.showMessageDialog(null, "La fecha de nacimiento del alumno ingresada es muy largo el máximo es de 10 caracteres, usted ingresó " + fechaNacimiento.length() + " dígitos.", "Longitud de la fecha de nacimiento del alumno", JOptionPane.INFORMATION_MESSAGE);
            return;
            }
           
           if(contieneNumerosYSimbolos(nombreAlumno)){
            JOptionPane.showMessageDialog(null, "Los nombres sólo pueden contener letras");
            return;
            }
           if(contieneNumerosYSimbolos(apellidoAlumno)){
            JOptionPane.showMessageDialog(null, "Los apellidos sólo pueden contener letras");
            return;
            }
           
           if(!validarIdentidad(identidad)){
            return;   
            }
           
            if(!validarLongitudTelefono(telefonoAlumno,8)){
            return;
            }
         
         
           if(contieneLetrasYSimbolos(telefonoAlumno)){
            JOptionPane.showMessageDialog(null, "El teléfono sólo puede contener números");
            return;
            }
           
           if(contieneLetrasYSimbolos(identidad)){
            JOptionPane.showMessageDialog(null, "El número de identidad sólo puede contener números");
            return;
            }
           
           if(contieneSimbolos(idCarrera)){
            JOptionPane.showMessageDialog(null, "El Id de la carrera no puede contener símbolos");
            return;
            }
           
           if(contieneLetrasYSimbolos(idPeriodo)){
            JOptionPane.showMessageDialog(null, "El Id del periodo sólo puede contener números");
            return;
            }
           
           if(contieneSimbolos(idCampus)){
            JOptionPane.showMessageDialog(null, "El Id del campus no puede contener símbolos");
            return;
            }
           
      try{
          PreparedStatement ps;
          ResultSet rs;
          ps=con.prepareStatement("INSERT INTO Alumno (numero_cuenta_alumno,nombres_alumno, apellidos_alumno, telefono_alumno, fecha_nacimiento, id_carrera, fecha_inscripcion,numero_identidad,id_campus,id_periodo)"
                  + "   "
                  + "             VALUES(?,?,?,?,?,?,?,?,?,?)");
          Calendar f;
       
       f=Calendar.getInstance();
       
       int d=f.get(Calendar.DATE), mes=1+(f.get(Calendar.MONTH)), año=f.get(Calendar.YEAR);
       
       String fecha2=(año+"-"+mes+"-"+d);
       String fechaHoy= fecha2;
       
      
       String consulta = "select campus,periodo,cantidad from NumerosCuenta\n" +
                          "where id_campus = '"+idCampus+"' and periodo = '"+periodo+"' ";
            Statement st1 = con.createStatement();
            ResultSet rs1;
            rs1 = st1.executeQuery(consulta);
            if(rs1.next()){
            int cantidad = Integer.parseInt(rs1.getString("cantidad")) + 1;
            numeroDeCuenta = f.get(Calendar.YEAR)+ rs1.getString("campus")+rs1.getString("periodo")+cantidad;
            String cons = "Update NumerosCuenta set cantidad = '"+cantidad+"'"
                        + "where id_campus = '"+idCampus+"' and periodo = '"+periodo+"'";
            Statement statement = con.createStatement();
            statement.executeUpdate(cons);
            }
                  ps.setString(1, numeroDeCuenta);
                  ps.setString(2, nombreAlumno);
                  ps.setString(3, apellidoAlumno);
                  ps.setString(4, telefonoAlumno);
                  ps.setString(5,fechaNacimiento);
                  ps.setString(6, idCarrera);
                  ps.setString(7,fechaHoy);
                  ps.setString(8,identidad);
                  ps.setString(9,idCampus);
                  ps.setString(10,idPeriodo);
        
                  int res= ps.executeUpdate();
                  if(res > 0){
                       JOptionPane.showMessageDialog(null, "Se ha guardado con éxito el alumno: "+nombreAlumno+" "+apellidoAlumno+""); 
                  }else {
                      JOptionPane.showMessageDialog(null, "Error al Guardar la informacion"); 
                  }
                  
       
      } catch ( Exception e) {
            System.out.println(e);
        }
    }
    
    public void actualizarAlumno(String nombreAlumno, String apellidoAlumno, String identidad ,String telefonoAlumno, String fechaNacimiento, String idCarrera, String idPeriodo, String idCampus){
        String nombresAlumno = nombreAlumno + " " + apellidoAlumno;
        
        if(JOptionPane.showConfirmDialog(null,"¿Está seguro que desea actualizar el registro del alumno: "+nombresAlumno+"?","Confirmación de actualización de alumno",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE
        )==JOptionPane.YES_OPTION){ 
           
        
         if((nombreAlumno.equals(""))){
            javax.swing.JOptionPane.showMessageDialog(null,"Debe ingresar los nombres del alumno.","Nombres del alumno requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        if((apellidoAlumno.equals(""))){
             javax.swing.JOptionPane.showMessageDialog(null,"Debe ingresar los apellidos del alumno.","Apellidos del alumno requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        if((telefonoAlumno.equals(""))){
             javax.swing.JOptionPane.showMessageDialog(null,"Debe ingresar el teléfono del alumno.","Teléfono del alumno requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        if((identidad.equals(""))){
            javax.swing.JOptionPane.showMessageDialog(null,"Debe ingresar el número de identidad del alumno.","Número de identidad del alumno requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
         }
        
        
        if((idCarrera.equals(""))){
            javax.swing.JOptionPane.showMessageDialog(null,"Debe seleccionar una carrera para el alumno.","Carrera del alumno requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
         if((idPeriodo.equals(""))){
            javax.swing.JOptionPane.showMessageDialog(null,"Debe seleccionar el período de inscripción del alumno.","Período de inscripción del alumno requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }
         
          if((idCampus.equals(""))){
            javax.swing.JOptionPane.showMessageDialog(null,"Debe seleccionar un campus para el alumno.","Campus del alumno requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }
          
     
        if((fechaNacimiento.equals(""))){
             javax.swing.JOptionPane.showMessageDialog(null,"Debe ingresar la fecha de nacimiento del alumno.","Fecha de nacimiento del alumno requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
       
    
       /* 
        if(existeAlumno(identidad)){
            return;
        }
        
         */
        if(!validarLongitud(nombreAlumno,5)){
            JOptionPane.showMessageDialog(null, "Los nombres ingresados son muy pequeños el mínimo es de 5 caracteres", "Longitud de los nombres", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
         if(!validarLongitud(apellidoAlumno,5)){
            JOptionPane.showMessageDialog(null, "Los apellidos ingresados son muy pequeños el mínimo es de 5 caracteres", "Longitud de los apellidos", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        
         if(!validarLongitudTelefono(telefonoAlumno,8)){
            return;
        }
         
         if(!validarIdentidad(identidad)){
            return;
            
        }
         if (!validarLongitudMax(nombreAlumno, 40)) {
            JOptionPane.showMessageDialog(null, "Los nombres del alumno ingresados son muy largos el máximo es de 40 caracteres, usted ingresó " + nombreAlumno.length() + " caracteres.", "Longitud de los nombres del alumno", JOptionPane.INFORMATION_MESSAGE);
            return;
            }
         
          if (!validarLongitudMax(apellidoAlumno, 40)) {
            JOptionPane.showMessageDialog(null, "Los apellidos del alumno ingresados son muy largos el máximo es de 40 caracteres, usted ingresó " + apellidoAlumno.length() + " caracteres.", "Longitud de los apellidos del alumno", JOptionPane.INFORMATION_MESSAGE);
            return;
            }
          
           if (!validarLongitudMax(telefonoAlumno, 8)) {
            JOptionPane.showMessageDialog(null, "El teléfono del alumno ingresado es muy largo el máximo es de 8 dígitos, usted ingresó " + telefonoAlumno.length() + " dígitos.", "Longitud del teléfono del alumno", JOptionPane.INFORMATION_MESSAGE);
            return;
            }
           
           if (!validarLongitudMax(identidad, 13)) {
            JOptionPane.showMessageDialog(null, "El numero de identidad del alumno ingresado es muy largo el máximo es de 13 dígitos, usted ingresó " + identidad.length() + " dígitos.", "Longitud del número de identidad del alumno", JOptionPane.INFORMATION_MESSAGE);
            return;
            }
           
           if (!validarLongitudMax(idCarrera, 4)) {
            JOptionPane.showMessageDialog(null, "El id de la carrera del alumno ingresado es muy largo el máximo es de 4 caracteres, usted ingresó " + idCarrera.length() + " dígitos.", "Longitud del id de la carrera del alumno", JOptionPane.INFORMATION_MESSAGE);
            return;
            }
           
           if (!validarLongitudMax(idPeriodo, 3)) {
            JOptionPane.showMessageDialog(null, "El id del período del alumno ingresado es muy largo el máximo es de 3 caracteres, usted ingresó " + idPeriodo.length() + " dígitos.", "Longitud del id del periodo de ingreso del alumno", JOptionPane.INFORMATION_MESSAGE);
            return;
            }
           
           if (!validarLongitudMax(idCampus, 4)) {
            JOptionPane.showMessageDialog(null, "El id del campus del alumno ingresado es muy largo el máximo es de 4 caracteres, usted ingresó " + idCampus.length() + " dígitos.", "Longitud del id del campus de ingreso del alumno", JOptionPane.INFORMATION_MESSAGE);
            return;
            }
           
           if (!validarLongitudMax(fechaNacimiento, 10)) {
            JOptionPane.showMessageDialog(null, "La fecha de nacimiento del alumno ingresada es muy largo el máximo es de 10 caracteres, usted ingresó " + fechaNacimiento.length() + " dígitos.", "Longitud de la fecha de nacimiento del alumno", JOptionPane.INFORMATION_MESSAGE);
            return;
            }
           if(contieneNumerosYSimbolos(nombreAlumno)){
            JOptionPane.showMessageDialog(null, "Los nombres sólo pueden contener letras");
            return;
            }
           if(contieneNumerosYSimbolos(apellidoAlumno)){
            JOptionPane.showMessageDialog(null, "Los apellidos sólo pueden contener letras");
            return;
            }
           
           if(contieneLetrasYSimbolos(telefonoAlumno)){
            JOptionPane.showMessageDialog(null, "El teléfono sólo puede contener números");
            return;
            }
           
           if(contieneLetrasYSimbolos(identidad)){
            JOptionPane.showMessageDialog(null, "El número de identidad sólo puede contener números");
            return;
            }
           
           if(contieneSimbolos(idCarrera)){
            JOptionPane.showMessageDialog(null, "El Id de la carrera no puede contener símbolos");
            return;
            }
           
           if(contieneLetrasYSimbolos(idPeriodo)){
            JOptionPane.showMessageDialog(null, "El Id del periodo sólo puede contener números");
            return;
            }
           
           if(contieneSimbolos(idCampus)){
            JOptionPane.showMessageDialog(null, "El Id del campus no puede contener símbolos");
            return;
            }
            
           
            }
          try{
            String numeroDeCuenta = "";
            Statement st2 = con.createStatement();
            String sql2 = "select * from Alumno\n" +
                         "where numero_identidad = '"+identidad+"' ";
            ResultSet rs2 = st2.executeQuery(sql2);
            if(rs2.next()){
               numeroDeCuenta = rs2.getString("numero_cuenta_alumno");
            }
            else{
                return;
            }
              PreparedStatement ps;
              ResultSet rs;
              ps=con.prepareStatement("Update Alumno\n" +
"                      set nombres_alumno = ?,\n" +
"                      apellidos_alumno = ?,\n" +
"                      telefono_alumno = ?,\n" +
"                      fecha_nacimiento = ?,\n" +
"                      id_carrera = ?,\n" +
"                      numero_identidad = ?,\n" +
"                      id_campus =?,\n" +
"                      id_periodo= ?\n" +
"                      where numero_cuenta_alumno = '"+numeroDeCuenta+"' or "
                       + "numero_identidad = '"+identidad+"'");
                      ps.setString(1,nombreAlumno);
                      ps.setString(2,apellidoAlumno);
                      ps.setString(3,telefonoAlumno);
                      ps.setString(4,fechaNacimiento);
                      ps.setString(5,idCarrera);
                      ps.setString(6,identidad);
                      ps.setString(7,idCampus);
                      ps.setString(8,idPeriodo);
                      int res= ps.executeUpdate();
                      JOptionPane.showMessageDialog(null, "Se ha actualizado la información del alumno: "+nombreAlumno+" correctamente.");
            } catch ( Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
                    
            }
         }
    
    public void buscarAlumno(){
                        try{
                    String cap="";
                    ResultSet rs2 = null;
                    String var = JOptionPane.showInputDialog(null,"Ingrese el número de identidad, o el número de cuenta del alumno que desea consultar","Consulta de alumno",JOptionPane.QUESTION_MESSAGE);
                    if(var == null)
                        JOptionPane.showMessageDialog(null,"La acción fue cancelada","¡AVISO!",JOptionPane.INFORMATION_MESSAGE);
                    else {
                        if (var.equals("")) {
                            JOptionPane.showMessageDialog(null,"Favor de ingresar los datos del alumno\n que desea consultar","¡AVISO!",JOptionPane.INFORMATION_MESSAGE);
                        }
                        else{
                            String sql = "Select nombres_alumno,apellidos_alumno,telefono_alumno,fecha_nacimiento, c.id_carrera,nombre_carrera, "
                                        + "ca.id_campus,nombre_campus,numero_cuenta_alumno,a.id_periodo,descripcion,numero_identidad,ph.nombre_periodo_historico from alumno as a join Carrera as c on a.id_carrera = c.id_carrera\n" +
                                        "join Campus as ca on ca.id_campus = a.id_campus join periodo as j on j.id_periodo = a.id_periodo\n"
                                    + "join Periodo_historico as ph on ph.id_periodo = j.id_periodo" +
                                        " where numero_cuenta_alumno = '"+var+"' or numero_identidad = '"+var+"'";
                            Statement stmt = con.createStatement();
                            rs2 = stmt.executeQuery(sql);
                            if(rs2.next()) {
                                System.out.println("\n=========================");
                                System.out.println("Número de cuenta del alumno: " + rs2.getString("numero_cuenta_alumno"));
                                System.out.println("Número de identidad del alumno: " + rs2.getString("numero_identidad"));
                                System.out.println("Nombres del alumno: " + rs2.getString("nombres_alumno"));
                                System.out.println("Apellidos del alumno: " + rs2.getString("apellidos_alumno"));
                                System.out.println("Teléfono del alumno: " + rs2.getString("telefono_alumno"));
                                System.out.println("Fecha de nacimiento del alumno: " + rs2.getDate("fecha_nacimiento"));
                                System.out.println("Carrera del alumno: " + rs2.getString("nombre_carrera"));
                                System.out.println("Período del alumno: " + rs2.getString("nombre_periodo_historico") + " Período");
                                System.out.println("Campus del alumno: " + rs2.getString("nombre_campus"));
                                System.out.println("\n=========================");
                            }
                            else{
                               JOptionPane.showMessageDialog(null,"¡No se encuentra el alumno! Por favor verifique sí, lo escribió correctamente");
                            }
                        }  
                    }
                    }catch (Exception e) {
                            JOptionPane.showMessageDialog(null,e.getMessage());
                            } 
    }
    
    private boolean existeAlumno(String identidad){
       try {
            Statement st = con.createStatement();
            String sql = "Select numero_identidad from Alumno where numero_identidad = '"+identidad+"'";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
           javax.swing.JOptionPane.showMessageDialog(null,"El número de identidad: "+identidad+" ya existe","AVISO",javax.swing.JOptionPane.INFORMATION_MESSAGE);
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
    
     private boolean validarLongitud(String texto, int longitud){
       if(texto.length() >= longitud){
           return true;
       }
       else{
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
    
     private boolean validarIdentidad(String identidad){
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
      
        private boolean contieneSimbolos(String texto){
          for (int i = 0; i < texto.length(); i++) {
              if(!Character.isLetterOrDigit(texto.charAt(i)))
                  return true;
          }
          return false;
      }
        
      
        
    
    
}
