/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import sistema_registro.Campus;
import sistema_registro.CancelarAsignatura;
import sistema_registro.SQL.ConectorSQL;

/**
 *
 * @author wianp
 */
public class CancelarAsignaturaTest {
    
       Connection con = null;
   Statement stmt;
   String idSeccion;
     String idPeriodo;
   String nombreAsignatura;
   String idMatricula;
   String numeroCuenta;
   String nombreSeccion;
   String horaInicial;
   String horaFinal;
   String nombrePeriodo;
   String nombreAula;
   boolean validarNotas;
 
    
   public CancelarAsignaturaTest (){
   
          try{
            this.con = ConectorSQL.obtenerConexion();
        } catch (SQLException ex) {
            
            System.out.println(ex.getMessage());
   
   }
   
}
   
   public void Buscar(){
   
   buscar();
   }
   
   private void ObtencionDatosAsignatura(){
   
       if ( (numeroCuenta.equals("") ))   {
            javax.swing.JOptionPane.showMessageDialog(null,"Debe ingresar el numero de cuenta.","Numero de cuenta requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
             return;
        }    
       
     //  if(CancelarAsignaturaTest() >= 0){
         // idSeccion.setText(Tabla_Cancelar.getValueAt(i,0).toString()/*+"-"+Tabla_Cancelar.getValueAt(i,2).toString()*/);
          //idPeriodo.setText(Tabla_Cancelar.getValueAt(i,5).toString());
          //nombreAsignatura.setText(Tabla_Cancelar.getValueAt(i, 2).toString());
              try {
                   Statement st = con.createStatement();
                   String sql2 = "select * from Matricula as m join Secciones as s on m.id_seccion = s.id_seccion\n" +
                    "where m.numero_cuenta_alumno = '"+numeroCuenta+"' and s.id_seccion = '"+idSeccion+"'\n" +
                    "and s.id_periodo = '"+idPeriodo+"'";
                  ResultSet rs = st.executeQuery(sql2);
                 if(rs.next()){
                     idMatricula.equals("id_matricula");
                 }
          
              } catch (SQLException ex) {
                  Logger.getLogger(CancelarAsignatura.class.getName()).log(Level.SEVERE, null, ex);
              }
       }
       
       public void EliminarMatricula(boolean validar, String numeroCuenta, String idPeriodo){
       
           
          if ( (numeroCuenta.equals("") )){
            javax.swing.JOptionPane.showMessageDialog(null,"Debe ingresar el numero de cuenta.","Numero de cuenta requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
             return;
        }
           
        if (validarNotas) {
            return;
        }
         try {
             Statement st = con.createStatement();
             String sql2 = "select * from Matricula as m join Secciones as s on m.id_seccion = s.id_seccion\n" +
            "where m.numero_cuenta_alumno = '"+numeroCuenta+"'" +
            "and s.id_periodo = '"+idPeriodo+"'";
             ResultSet rs2 = st.executeQuery(sql2);
             ArrayList<String> idMatricula = new ArrayList<String>();
             ArrayList<String> idSeccion = new ArrayList<String>();
             while(rs2.next()){
                 
                 //Duda al momento de traer estos valores.
                 idMatricula.add(rs2.getString(3));
                 idSeccion.add(rs2.getString(2));
             }
             if(idMatricula.size() > 0){
             for (int i = 0; i < idMatricula.size(); i++) {
                 Statement st2 = con.createStatement();
                
                 String sql3 = "Delete Notas\n" +
                                "where id_matricula = '"+idMatricula.get(i)+"'";
                 int rs3 = st2.executeUpdate(sql3);
                 
                 Statement st3 = con.createStatement();
                 String sql4 = "Delete Matricula\n"
                         + "where id_matricula = '"+idMatricula.get(i)+"'";
                 int rs4 = st3.executeUpdate(sql4);
                 
                 Statement st4 = con.createStatement();
                 String sql5 = "Update Secciones\n" +
                            "set cantidad_alumnos = cantidad_alumnos - 1 "
                         + " where id_seccion = '"+idSeccion.get(i)+"'";
              
                 int rs5 = st4.executeUpdate(sql5);
                 
             }
             JOptionPane.showMessageDialog(null,"Se ha cancelado la matricula exitosamente");
                }
             else if(idMatricula.isEmpty()){
                  JOptionPane.showMessageDialog(null,"No hay matricula registrada");
             }
             
             
         } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,ex.getMessage());
         }
           
       }
       
       public void CancelarAsignatura(String numeroCuenta, String idPeriodo, String idMatricula,String idSeccion){
       
            //CancelarA(var, var);
     
        if ( (numeroCuenta.equals("") )){
            javax.swing.JOptionPane.showMessageDialog(null,"Debe ingresar el numero de cuenta.","Numero de cuenta requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
             return;
        }
        
       /*
            numeroCuenta.setString("numero_cuenta_alumno");
            idMatricula.setString("id_matricula");
            idSeccion .setString("id_seccion");
            idPeriodo.setString("id_periodo");
            */
            
           // int matricula =Integer.parseInt(id_matricula);
          
            if (validarNotas2()) {
            return;
        }
             
        else if (JOptionPane.showConfirmDialog(null, "¿Está seguro que desea cancelar la matricula " + nombrePeriodo + ".", "Confirmación de cancelacion de matricula",
            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE
        ) == JOptionPane.YES_OPTION) {
        
        try{
          
                if ((numeroCuenta.equals(""))  ) {

                javax.swing.JOptionPane.showMessageDialog(null,"¡Debe llenar el espacio! \n","¡AVISO!",javax.swing.JOptionPane.INFORMATION_MESSAGE);
                     
                        return;
                        
              }
                
              
           
             Statement st2 =con.createStatement();
             String sql = "Delete  Notas "
                      + "where numero_cuenta='"+numeroCuenta+"' and id_periodo='"+idPeriodo+"' and id_matricula='"+idMatricula+"'"; 
                     
                     
              int rs2 = st2.executeUpdate(sql);
          }catch ( Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage()); 
            
        }
      try{
          PreparedStatement ps;
          ResultSet rs4;
         Statement st=con.createStatement();
         String sql ="Delete  Matricula "
                            + "where id_matricula='"+idMatricula+"' and numero_cuenta_alumno='"+numeroCuenta+"' and id_seccion ='"+idSeccion+"' ";
                 
                 
                 
                    int res=st.executeUpdate(sql);
                    
                    
                  Statement st4 = con.createStatement();
                 String sql5 = "Update Secciones\n" +
                            "set cantidad_alumnos = cantidad_alumnos - 1"
                         + " where id_seccion = '"+idSeccion+"'";
              
                 int rs5 = st4.executeUpdate(sql5);
                    
                  
                  if(res > 0){ 
                      
                      JOptionPane.showMessageDialog(null, "Se ha cancelado la asignatura "+nombreAsignatura+" del alumno: "+numeroCuenta+" correctamente."); 
                  }else {
                      JOptionPane.showMessageDialog(null, "¡Error al cancelar la asignatura!"); 
                  }
      } catch ( Exception e) { 
           JOptionPane.showMessageDialog(null, "Error al borrar la información, podría ser por: \n 1.Podria ser porque la asignatura ya contenga notas"
                         + "\n 2. No existe una matricula de esta clase.","¡Error al Borrar!", JOptionPane.ERROR_MESSAGE);
        }
      buscar();
     
         
       }
       }
       
     private boolean validarNotas(){
         try {
            Statement st = con.createStatement();
            String sql = "Select * from Notas where numero_cuenta = '" + numeroCuenta+ "'";
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "El número de cuenta: " + numeroCuenta + " ya contiene notas. \n No se puede eliminar la matrícula", "Notas ya ingresadas.", JOptionPane.INFORMATION_MESSAGE);
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Campus.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    private boolean validarNotas2(){
         try {
            Statement st = con.createStatement();
            String sql = "Select * from Notas where numero_cuenta = '" +  numeroCuenta+ "' and id_matricula = '"+idMatricula+"'";
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                if(rs.getString("nota1").equals("0.00000")){
                    return false;
                }
                JOptionPane.showMessageDialog(null, "El número de cuenta : " + numeroCuenta + " ya contiene notas. \n No se puede eliminar la asignatura, ", "Notas ya ingresadas.", JOptionPane.INFORMATION_MESSAGE);
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Campus.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
       
    private void ObtenerPeriodo() throws SQLException{
    
    Statement st = con.createStatement();
        Calendar f;
       
       f=Calendar.getInstance();
       
       int d=f.get(Calendar.DATE), mes=1+(f.get(Calendar.MONTH)), año=f.get(Calendar.YEAR);
       String fecha = año+"-"+mes+"-"+ d;
        String sql = "select id_periodo from Periodo_historico\n" +
        "where fecha_inicial < '"+fecha+"' and fecha_final > '"+fecha+"'";
        ResultSet rs2 = st.executeQuery(sql);
        if(rs2.next()){
            idPeriodo.equals("id_periodo");
            
        }
        else{
            JOptionPane.showMessageDialog(null,"Error");
        }
        
    }
    
    public void buscar(){
    
    
         numeroCuenta.equals("numero_cuenta");
           
        if((numeroCuenta.equals(""))){
            javax.swing.JOptionPane.showMessageDialog(null, "Debe ingresar el número de cuenta.","Número de Cuenta requerido",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            
            return;
        }
         if(existeNumeroCuenta()){
            return;
            
        }
        try{
            
            
            PreparedStatement ps=null;
            ResultSet rs=null;
            
           
           
           String sql= "select S.id_seccion, S.Nombre_seccion,A.nombre_asignaturas, S.Hora_inicial, S.Hora_final, S.id_periodo,S.id_aula from Secciones as S\n"+
                         "join Matricula as M on S.id_seccion = M.id_seccion\n"+
                          "join Asignaturas as A on S.cod_asignaturas = A.cod_asignaturas\n"+
                         "where numero_cuenta_alumno = '"+numeroCuenta+"'";

            ps= con.prepareStatement(sql);
            rs= ps.executeQuery(); 
            
            ResultSetMetaData rsMd =rs.getMetaData();
           // int cantidadColumnas = rsMd.getColumnCount();
            idSeccion.equals("Id Sección");
            nombreSeccion.equals("Sección");
            nombreAsignatura.equals("Asignatura");
            horaInicial.equals("Hora Inicial");
            horaFinal.equals("Hora Final");
            nombrePeriodo.equals("Período");
            nombreAula.equals("Aula");
            
            
            
           
         }catch(SQLException ex){
             System.out.println(ex.toString());
             
         }    
        
    }
    
    private boolean existeNumeroCuenta(){
    
     try {
            Statement st = con.createStatement();
            String sql = "select A.numero_cuenta_alumno from Alumno as A\n" +
                           "where A.numero_cuenta_alumno='"+numeroCuenta+"';";
            ResultSet rs = st.executeQuery(sql);
            if (!rs.next()) {
                    
                JOptionPane.showMessageDialog(null, "El número de cuenta: " +numeroCuenta+ " no existe", "Número de Cuenta Incorrecto", JOptionPane.ERROR_MESSAGE);
                return true;
            } else {
                
                return false;
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return false;
        
    }
    
    
    
   }


   

