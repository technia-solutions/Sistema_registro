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
}
