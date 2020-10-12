/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import pruebas.CarreraTest;
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
 * @author asus
 */
public class CarreraTestTest {
     Connection con = null;
    
    public CarreraTestTest() {
        try{
        this.con = ConectorSQL.obtenerConexion();
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
     * Test of GuardarCarrera method, of class CarreraTest.
     */
    @Test
    public void testGuardarCarrera() {
        System.out.println("GuardarCarrera");
        String idCarrera = "";
        String NombreCarrera = "";
        String Facultad = "";
        CarreraTest instance = new CarreraTest();
        instance.GuardarCarrera(idCarrera, NombreCarrera, Facultad);
        // TODO review the generated test code and remove the default call to fail.
         try {
            Statement st = con.createStatement();
            String sql = "Select * from Edificio where id_carrera  = '"+idCarrera+"'";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                assertEquals(idCarrera,rs.getString("id_edificio "));
                assertEquals(NombreCarrera,rs.getString("nombre_edificio"));
                assertEquals(Facultad,rs.getString("id_campus"));   
            }
        } catch (SQLException ex) {
           System.out.println(ex.getMessage());
        }
       
    }

    /**
     * Test of ActualizarCarrera method, of class CarreraTest.
     */
    @Test
    public void testActualizarCarrera() {
        System.out.println("ActualizarCarrera");
        String idCarrera = "";
        String NombreCarrera = "";
        String Facultad = "";
        CarreraTest instance = new CarreraTest();
        instance.ActualizarCarrera(idCarrera, NombreCarrera, Facultad);
        // TODO review the generated test code and remove the default call to fail.
         try {
            Statement st = con.createStatement();
            String sql = "Select * from Edificio where id_carrera  = '"+idCarrera+"'";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                assertEquals(idCarrera,rs.getString("id_edificio "));
                assertEquals(NombreCarrera,rs.getString("nombre_edificio"));
                assertEquals(Facultad,rs.getString("id_campus"));   
            }
        } catch (SQLException ex) {
           System.out.println(ex.getMessage());
        }
    }

    /**
     * Test of EliminarCarrera method, of class CarreraTest.
     */
    @Test
    public void testEliminarCarrera() {
        System.out.println("EliminarCarrera");
        String idCarrera = "";
        String NombreCarrera = "";
        String Facultad = "";
        CarreraTest instance = new CarreraTest();
        instance.EliminarCarrera(idCarrera, NombreCarrera, Facultad);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of ConsultarCarrera method, of class CarreraTest.
     */
    @Test
    public void testConsultarCarrera() {
        System.out.println("ConsultarCarrera");
        String idCarrera = "";
        String NombreCarrera = "";
        String Facultad = "";
        CarreraTest instance = new CarreraTest();
        instance.ConsultarCarrera(idCarrera, NombreCarrera, Facultad);
        // TODO review the generated test code and remove the default call to fail.
       
    }
    
}
