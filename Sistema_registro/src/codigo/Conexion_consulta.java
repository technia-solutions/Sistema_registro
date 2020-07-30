/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.sql.Connection;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.Calendar;
import sistema_registro.SQL.ConectorSQL;
/**
 *
 * @author Mitsuki
 */
public class Conexion_consulta {
    
 Connection con;
 ResultSet rs;
 public Conexion_consulta() throws SQLException {
        this.con = ConectorSQL.obtenerConexion();
       
    }
    
    public ArrayList<String> llenar_combo() throws SQLException{
         ArrayList<String> lista = new ArrayList<String>();
         String q= "SELECT * from Campus";
         Statement st;
         st = con.createStatement();
         try{
            rs=st.executeQuery(q);
            while(rs.next()){
                lista.add(rs.getString("id_campus") + " - " + rs.getString("nombre_campus"));
            }
         }
        catch(Exception e){ 
            
              }
          return lista;  
    }
    
    public ArrayList<String> llenar_tipoUsuario() throws SQLException{
         ArrayList<String> lista = new ArrayList<String>();
         String q= "Select * from tipo_usuarios";
         Statement st;
         st = con.createStatement();
         try{
            rs=st.executeQuery(q);
            while(rs.next()){
                lista.add(rs.getString("Tipo_Usuario"));
            }
         }
        catch(Exception e){ 
            
              }
          return lista;  
    }
    
    public ArrayList<String> llenar_Facultad() throws SQLException{
         ArrayList<String> lista = new ArrayList<String>();
         String q= "Select * from Facultad";
         Statement st;
         st = con.createStatement();
         try{
            rs=st.executeQuery(q);
            while(rs.next()){
                lista.add(rs.getString("id_facultad") + " - " + rs.getString("nombre_facultad"));
            }
         }
        catch(Exception e){ 
            
              }
          return lista;  
    }
    
        public ArrayList<String> llenar_combo2() throws SQLException{
         ArrayList<String> lista = new ArrayList<String>();
         String q= "SELECT * from Carrera";
         Statement st;
         st = con.createStatement();
         try{
            rs=st.executeQuery(q);
            while(rs.next()){
                lista.add(rs.getString("id_carrera") + " - " + rs.getString("nombre_carrera"));
            }
         }
        catch(Exception e){ 
            
              }
          return lista;
        
    }   
        
      public ArrayList<String> llenar_requisito() throws SQLException{
         ArrayList<String> lista = new ArrayList<String>();
         String q= "SELECT * from Requisito_Asignatura";
         Statement st;
         st = con.createStatement();
         try{
            rs=st.executeQuery(q);
            while(rs.next()){
                lista.add(rs.getString("id_asignatura") + " - " + rs.getString("RequisitoAsignatura"));
            }
         }
        catch(Exception e){ 
            
              }
          return lista;
    }   
        
       public ArrayList<String> llenar_periodo() throws SQLException{
         ArrayList<String> lista = new ArrayList<String>();
         Calendar f;
       f=Calendar.getInstance();
       int d=f.get(Calendar.DATE), mes=1+(f.get(Calendar.MONTH)), año=f.get(Calendar.YEAR);
         String fecha = d+"-"+mes+"-"+año;
         String q= "select * from periodo_historico\n" +
                "where fecha_inicial < '"+fecha+"' and fecha_final > '"+fecha+"'";
         Statement st;
         st = con.createStatement();
         try{
            rs=st.executeQuery(q);
            while(rs.next()){
                lista.add(rs.getString("nombre_periodo_historico") + " Período");
            }
         }
        catch(Exception e){ 
            
              }
          return lista;
    }   
       
        
       public ArrayList<String> llenar_edificio() throws SQLException{
         ArrayList<String> lista = new ArrayList<String>();
         String q= "SELECT * from Edificio";
         Statement st;
         st = con.createStatement();
         try{
            rs=st.executeQuery(q);
            while(rs.next()){
                lista.add(rs.getString("id_edificio") + " - " + rs.getString("nombre_edificio"));
            }
         }
        catch(Exception e){ 
            
              }
          return lista;
    }  
       
       
        
       public ArrayList<String> llenar_aula() throws SQLException{
         ArrayList<String> lista5 = new ArrayList<String>();
         String q= "SELECT * from Aula";
         Statement st;
         st = con.createStatement();
         try{
            rs=st.executeQuery(q);
            while(rs.next()){
                lista5.add(rs.getString("id_aula") + " - " + rs.getString("nombre_aula"));
            }
         }
        catch(Exception e){ 
            
              }
          return lista5;
    } 
        
         
}
