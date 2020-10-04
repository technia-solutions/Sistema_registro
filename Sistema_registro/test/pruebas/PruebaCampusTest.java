/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import pruebas.PruebaCampus;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sistema_registro.SQL.ConectorSQL;

/**
 *
 * @author Mitsuki
 */
public class PruebaCampusTest {
     Connection con =null;
    
    public PruebaCampusTest() {
         try{
            this.con=ConectorSQL.obtenerConexion();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());      
        }
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of guardarCampus method, of class PruebaCampus.
     */
    @Test
    public void testGuardarCampus() {
        System.out.println("guardarCampus");
        String id = "C665";
        String campus = "prueba";
        PruebaCampus instance = new PruebaCampus();
        instance.guardarCampus(id, campus);
         try{
            Statement st =con.createStatement();
            String sql="Select* from Campus where id_campus ='"+id+"'";
            st.executeQuery(sql);
            ResultSet rs=st.executeQuery(sql);
            
            if(rs.next()){
                  assertEquals(id,rs.getString("id_campus"));
                assertEquals(campus,rs.getString("nombre_campus"));
 
            }
            
        }catch(SQLException ex){
             fail("The test case is a prototype."+ex.getMessage());
            System.out.println(ex.getMessage()); 
        }
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of actualizarCampus method, of class PruebaCampus.
     */
    @Test
    public void testActualizarCampus() {
        System.out.println("actualizarCampus");
         String id = "C665";
        String campus = "pruebados";
        PruebaCampus instance = new PruebaCampus();
        instance.actualizarCampus(id, campus);
          try{
            Statement st =con.createStatement();
            String sql="Select* from Campus where id_campus ='"+id+"'";
            st.executeQuery(sql);
            ResultSet rs=st.executeQuery(sql);
            
            if(rs.next()){
                  assertEquals(id,rs.getString("id_campus"));
                assertEquals(campus,rs.getString("nombre_campus"));
 
            }
            
        }catch(SQLException ex){
             fail("The test case is a prototype."+ex.getMessage());
            System.out.println(ex.getMessage()); 
        }
        
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarCampus method, of class PruebaCampus.
     */
    @Test
    public void testEliminarCampus() {
        System.out.println("eliminarCampus");
         String id = "C666";
        String campus = "prueba";
        PruebaCampus instance = new PruebaCampus();
        instance.eliminarCampus(id, campus);
          try{
            Statement st =con.createStatement();
            String sql="Select* from Campus where id_campus ='"+id+"'";
            st.executeQuery(sql);
            ResultSet rs=st.executeQuery(sql);
            
            if(rs.next()){
                  assertEquals(id,rs.getString("id_campus"));
                assertEquals(campus,rs.getString("nombre_campus"));
 
            }
            
        }catch(SQLException ex){
             fail("The test case is a prototype."+ex.getMessage());
            System.out.println(ex.getMessage()); 
        }
        // TODO review the generated test code and remove the default call to fail.
     //   fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class PruebaCampus.
     */
 @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        PruebaCampus.main(args);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }
    
}
