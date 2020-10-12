/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import pruebas.EdificioTest;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sistema_registro.SQL.ConectorSQL;

/**
 *
 * @author asus
 */
public class EdificioTestTest {
      Connection con = null;
    public EdificioTestTest() {
           try {
          this.con = ConectorSQL.obtenerConexion();
         } catch (SQLException ex) {
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
     * Test of GuardarEdificio method, of class EdificioTest.
     */
    @Test
    public void testGuardarEdificio() {
        System.out.println("GuardarEdificio");
        String idEdificio = "";
        String NombreEdificio = "";
        String Campus = "";
        EdificioTest instance = new EdificioTest();
        instance.GuardarEdificio(idEdificio, NombreEdificio, Campus);
        // TODO review the generated test code and remove the default call to fail.
         try {
            Statement st = con.createStatement();
            String sql = "Select * from Edificio where id_edificio  = '"+idEdificio+"'";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                assertEquals(idEdificio,rs.getString("id_edificio "));
                assertEquals(NombreEdificio,rs.getString("nombre_edificio"));
                assertEquals(Campus,rs.getString("id_campus"));   
            }
        } catch (SQLException ex) {
           System.out.println(ex.getMessage());
        }
       
    }

    /**
     * Test of ActualizarEdificio method, of class EdificioTest.
     */
    @Test
    public void testActualizarEdificio() {
        System.out.println("ActualizarEdificio");
        String idEdificio = "";
        String NombreEdificio = "";
        String Campus = "";
        EdificioTest instance = new EdificioTest();
        instance.ActualizarEdificio(idEdificio, NombreEdificio, Campus);
        // TODO review the generated test code and remove the default call to fail.
        try {
            Statement st = con.createStatement();
            String sql = "Select * from Edificio where id_edificio  = '"+idEdificio+"'";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                assertEquals(idEdificio,rs.getString("id_edificio "));
                assertEquals(NombreEdificio,rs.getString("nombre_edificio"));
                assertEquals(Campus,rs.getString("id_campus"));   
            }
        } catch (SQLException ex) {
           System.out.println(ex.getMessage());
        }
        
    }

    /**
     * Test of EliminarEdificio method, of class EdificioTest.
     */
    @Test
    public void testEliminarEdificio() {
        System.out.println("EliminarEdificio");
        String idEdificio = "";
        String NombreEdificio = "";
        String Campus = "";
        EdificioTest instance = new EdificioTest();
        instance.EliminarEdificio(idEdificio, NombreEdificio, Campus);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of ConsultarEdificio method, of class EdificioTest.
     */
    @Test
    public void testConsultarEdificio() {
        System.out.println("ConsultarEdificio");
        String idEdificio = "";
        String NombreEdificio = "";
        String Campus = "";
        EdificioTest instance = new EdificioTest();
        instance.ConsultarEdificio(idEdificio, NombreEdificio, Campus);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
