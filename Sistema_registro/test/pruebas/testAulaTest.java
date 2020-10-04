/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import pruebas.testAula;
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
public class testAulaTest {
    Connection con =null;
    public testAulaTest() {
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
     * Test of guardarAula method, of class testAula.
     */
    @Test
    public void testGuardarAula() {
        System.out.println("guardarAula");
      /*  String id = "";
        String aula = "";
        String piso = "";
        String edificio = "";*/
        String id = "C444";
        String aula = "444";
        String piso = "A";
        String edificio = "A";
        testAula instance = new testAula();
        instance.guardarAula(id, aula, piso, edificio);
        try{
            Statement st =con.createStatement();
            String sql="Select* from Aula where id_aula ='"+id+"'";
            st.executeQuery(sql);
            ResultSet rs=st.executeQuery(sql);
            
            if(rs.next()){
                  assertEquals(id,rs.getString("id_aula"));
                assertEquals(edificio,rs.getString("id_edificio"));
                assertEquals(aula,rs.getString("nombre_aula"));
                assertEquals(piso,rs.getString("piso_aula"));
            }
            
        }catch(SQLException ex){
             fail("The test case is a prototype."+ex.getMessage());
            System.out.println(ex.getMessage()); 
        }
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of actualizarAula method, of class testAula.
     */
   // @Test
/*    public void testActualizarAula() {
        System.out.println("actualizarAula");
        String id = "";
        String aula = "";
        String piso = "";
        String edificio = "";
        testAula instance = new testAula();
        instance.actualizarAula(id, aula, piso, edificio);
        // TODO review the generated test code and remove the default call to fail.
       try{
            Statement st =con.createStatement();
            String sql="Select* from Aula where id_aula ='"+id+"'";
            st.executeQuery(sql);
            ResultSet rs=st.executeQuery(sql);
            
            if(rs.next()){
                  assertEquals(id,rs.getString("id_aula"));
                assertEquals(edificio,rs.getString("id_edificio"));
                assertEquals(aula,rs.getString("nombre_aula"));
                assertEquals(piso,rs.getString("piso_aula"));
            }
            
        }catch(SQLException ex){
             fail("The test case is a prototype."+ex.getMessage());
            System.out.println(ex.getMessage()); 
        }
    }

    /**
     * Test of eliminarAula method, of class testAula.
     */
   /* @Test
    public void testEliminarAula() {
        System.out.println("eliminarAula");
        String id = "";
        String aula = "";
        String piso = "";
        String edificio = "";
        testAula instance = new testAula();
        instance.eliminarAula(id, aula, piso, edificio);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class testAula.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        testAula.main(args);
        // TODO review the generated test code and remove the default call to fail.
      //  fail("The test case is a prototype.");
    }

    /**
     * Test of actualizarAula method, of class testAula.
     */
    @Test
    public void testActualizarAula() {
        System.out.println("actualizarAula");
         String id = "C444";
        String aula = "455";
        String piso = "8";
        String edificio = "P";
        testAula instance = new testAula();
        instance.actualizarAula(id, aula, piso, edificio);
        // TODO review the generated test code and remove the default call to fail.
         try{
            Statement st =con.createStatement();
            String sql="Select* from Aula where id_aula ='"+id+"'";
            st.executeQuery(sql);
            ResultSet rs=st.executeQuery(sql);
            
            if(rs.next()){
                  assertEquals(id,rs.getString("id_aula"));
                assertEquals(edificio,rs.getString("id_edificio"));
                assertEquals(aula,rs.getString("nombre_aula"));
                assertEquals(piso,rs.getString("piso_aula"));
            }
            
        }catch(SQLException ex){
             fail("The test case is a prototype."+ex.getMessage());
            System.out.println(ex.getMessage()); 
        }
    }

    /**
     * Test of eliminarAula method, of class testAula.
     */
    @Test
    public void testEliminarAula() {
        System.out.println("eliminarAula");
        String id = "C666";
        String aula = "444";
        String piso = "4";
        String edificio = "P";
        testAula instance = new testAula();
        instance.eliminarAula(id, aula, piso, edificio);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of ActualizarAula method, of class testAula.
     */
   /* @Test
    public void testActualizarAula() {
        System.out.println("ActualizarAula");
        String id = "C445";
        String aula = "544";
        String piso = "4";
        String edificio = "A";
        testAula instance = new testAula();
        instance.actualizarAula(id, aula, piso, edificio);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarAula method, of class testAula.
     */
   /* @Test
    public void testEliminarAula() {
        System.out.println("eliminarAula");
      String id = "C444";
        String aula = "444";
        String piso = "4";
        String edificio = "A";
        testAula instance = new testAula();
        instance.eliminarAula(id, aula, piso, edificio);
        // TODO review the generated test code and remove the default call to fail.
      //  fail("The test case is a prototype.");
    }*/
    
    
   
    
}
