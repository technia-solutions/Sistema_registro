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
import javax.swing.JOptionPane;
import sistema_registro.SQL.ConectorSQL;

/**
 *
 * @author Mitsuki
 */
public class MatriculaPrueba {
     Connection con = null;
     
     public MatriculaPrueba(){
           try {
             this.con = ConectorSQL.obtenerConexion();
         } catch (SQLException ex) {
             System.out.println(ex.getMessage());
         }
     }
      public static void main(String args[]){
     
        new MatriculaPrueba().agregarMatricula("MT1014", "F", "20201301", "2");
    }
       public boolean agregarMatricula(String nombreAsignatura, String codigoAsignatura,String numeroCuenta,String id_periodo){
    String estado, reposicion, nota1, nota2, nota3, promedio;
        ResultSet rs=null;
       /* numeroCuenta =txt_numeroCuenta.getText();
        id_periodo= lbl_periodo.getText().substring(5);*/
        estado="RPB";
        reposicion="S/N";
        nota1="0";
        nota2="0";
        nota3="0";
        promedio="0";
        existeNumeroCuenta(numeroCuenta);
        PreparedStatement pst = null;
        PreparedStatement pst2 = null;
        PreparedStatement pst3 = null;

        try{
         String idseccion = null;
         Statement stat = con.createStatement();
           String sql2="select * from Secciones as S\n" +
       "where S.cod_asignaturas= '"+nombreAsignatura+"' and S.Nombre_seccion='"+codigoAsignatura+"'";
         ResultSet rs2 = stat.executeQuery(sql2);
                  if (rs2.next()) {
                        idseccion = rs2.getString("id_seccion");
                        } 
                  else{
                      JOptionPane.showMessageDialog(null,"error SECCIONES");
                  }
                  
            Statement cantidast = con.createStatement();
            String cantidadAlumno = "";
            String maximaAlumno="";
            String cantidadsql = "select  cantidad_alumnos, cantidad_maxima from Secciones where id_seccion='"+idseccion+"'";
             ResultSet rs5 = stat.executeQuery(cantidadsql);
                  if (rs5.next()) {
                        cantidadAlumno = rs5.getString("cantidad_alumnos");
                        maximaAlumno=rs5.getString("cantidad_maxima");
                        } 
                  else{
                      JOptionPane.showMessageDialog(null,"error CANTIDAD MAXIMA");
                  }
       int minima=Integer.parseInt(cantidadAlumno);
       int maxima=Integer.parseInt(maximaAlumno);
       
       /* if(minima<maxima){
            return true;
        }
        else{*/
            if(minima>=maxima){
                JOptionPane.showMessageDialog(null,"Esta Sección está llena");
                return false;
               
            }
   
        
         
        Statement stdoble2 = con.createStatement();
               String sqldoble2 = "select * from matricula as m join secciones as s on s.id_seccion = m.id_seccion join Asignaturas as a on a.cod_asignaturas = s.cod_asignaturas \n" +
                           "where numero_cuenta_alumno='"+numeroCuenta+"' and s.cod_asignaturas='"+codigoAsignatura+"'";
               ResultSet rsdoble2 = stdoble2.executeQuery(sqldoble2);
               if (rsdoble2.next()) {

                  JOptionPane.showMessageDialog(null, "El Alumno tiene la asignatura: " +rsdoble2.getString("nombre_asignaturas")+ " ya matriculada  ", "Asignatura Ya Matriculada", JOptionPane.ERROR_MESSAGE);
                   return true;
               }     
     
               Statement stdoble = con.createStatement();
               String sqldoble = "select * from matricula as m\n" +
                           "where numero_cuenta_alumno='"+numeroCuenta+"' and id_seccion='"+idseccion+"'";
               ResultSet rsdoble = stdoble.executeQuery(sqldoble);
               if (rsdoble.next()) {

                  JOptionPane.showMessageDialog(null, "El Alumno esta matriculado en la seccion: " +idseccion+ " ", "Asignatura Ya Matriculada", JOptionPane.ERROR_MESSAGE);
                   return true;
               }         
        
                   
            
            String sql="insert Matricula (numero_cuenta_alumno,id_seccion)\n" +
                  "values (?,?)";
            
            pst=con.prepareStatement(sql);
           
            pst.setString(1,numeroCuenta);
             
            pst.setString(2,idseccion);
            
              int i= pst.executeUpdate();
              
           
            Statement prueba = con.createStatement();
            String id_matricula = "";
            String pruebasql = "select top 1 * from Matricula order by id_matricula desc";
             ResultSet rs3 = stat.executeQuery(pruebasql);
                  if (rs3.next()) {
                        id_matricula = rs3.getString("id_matricula");
                        } 
                  else{
                      JOptionPane.showMessageDialog(null,"error");
                  }
              
             String sql3="Insert into Notas (numero_cuenta,id_periodo,estado,reposicion,nota1,nota2,nota3,promedio,id_matricula)\n" +
                  "values (?,?,?,?,?,?,?,?,?)";  
             pst2=con.prepareStatement(sql3);
           
            pst2.setString(1,numeroCuenta);
            pst2.setString(2,id_periodo);
            pst2.setString(3,estado);
            pst2.setString(4,reposicion);
            pst2.setString(5,nota1);
            pst2.setString(6,nota2);
            pst2.setString(7,nota3);
            pst2.setString(8,promedio);
            pst2.setString(9,id_matricula);
             int res= pst2.executeUpdate();
              if(res > 0){
                      
                  }else {
                      JOptionPane.showMessageDialog(null, "Error al Guardar la calificación"); 
 
                  }
         
          PreparedStatement ps;
          ResultSet rs4;
          ps=con.prepareStatement("Update Secciones\n" +
                                        "set cantidad_alumnos=cantidad_alumnos+1\n" +
                                        "where id_seccion= '"+idseccion+"'");
                
                
                 // ps.setString(6,reposicion);
                  int res4= ps.executeUpdate();
                  if(res > 0){
                      
                  }else {
                      JOptionPane.showMessageDialog(null, "Error al Guardar"); 
 
                  }
            if(i !=0){
                
            JOptionPane.showMessageDialog(null, "La matrícula del alumno "+numeroCuenta+" se ha realizado con éxito");
                return true;
            }else{
                JOptionPane.showMessageDialog(null, "Error al Guardar la calificación"); 
            
                return false;
            }
       
             
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
        
    }
       
       private boolean existeNumeroCuenta(String numeroCuenta) {
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
