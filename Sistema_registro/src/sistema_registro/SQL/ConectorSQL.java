/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema_registro.SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Carlos
 */
public class ConectorSQL {
    
    private static Connection con = null;
    private String driver;
    private String url;
    private String user;
    private String pass;
   
    
    private ConectorSQL() throws SQLException{
        
       String url = "jdbc:sqlserver://CARLOS:1433;"
               + "databaseName=Technia;user=admin;"
               + "password=admin";
       String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
      
       try{
       Class.forName(driver);
       con = DriverManager.getConnection(url);
       } catch(ClassNotFoundException | SQLException e){
                e.printStackTrace();
        }
    }
    
    public static Connection obtenerConexion() throws SQLException{
        if (con == null){
            ConectorSQL conectorSQL = new ConectorSQL(); 
        }
        return con;
    }  
}
