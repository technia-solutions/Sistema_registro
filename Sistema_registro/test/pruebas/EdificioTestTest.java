/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import pruebas.EdificioTest;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author asus
 */
public class EdificioTestTest {
    
    public EdificioTestTest() {
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
        
    }

    /**
     * Test of EliminarEdificio method, of class EdificioTest.
     */
    @Test
    public void testEliminarEdificio() {
        System.out.println("EliminarEdificio");
        String idEdificio = "D";
        String NombreEdificio = "Gimnasios Poli";
        String Campus = "C004";
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
