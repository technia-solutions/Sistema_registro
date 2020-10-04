/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import pruebas.PeriodoTest;
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
public class PeriodoTestTest {
    
    public PeriodoTestTest() {
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
     * Test of GuardarPeriodo method, of class PeriodoTest.
     */
    @Test
    public void testGuardarPeriodo() {
        System.out.println("GuardarPeriodo");
        String idPeriodo = "";
        String nombrePeriodo = "";
        String descripcion = "";
        PeriodoTest instance = new PeriodoTest();
        instance.GuardarPeriodo(idPeriodo, nombrePeriodo, descripcion);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of ActualizarPeriodo method, of class PeriodoTest.
     */
    @Test
    public void testActualizarPeriodo() {
        System.out.println("ActualizarPeriodo");
        String idPeriodo = "";
         String nombrePeriodo = "";
        String descripcion = "";
        PeriodoTest instance = new PeriodoTest();
        instance.ActualizarPeriodo(nombrePeriodo, idPeriodo, descripcion);
        // TODO review the generated test code and remove the default call to fail.
      
    }

    /**
     * Test of BuscarPeriodo method, of class PeriodoTest.
     */
    @Test
    public void testBuscarPeriodo() {
        System.out.println("BuscarPeriodo");
        PeriodoTest instance = new PeriodoTest();
        instance.BuscarPeriodo();
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of EliminarPeriodo method, of class PeriodoTest.
     */
    @Test
    public void testEliminarPeriodo() {
        System.out.println("EliminarPeriodo");
        String idPeriodo = "@";
        String nombrePeriodo = "@";
        String descripcion = "12345 Periodo";
        PeriodoTest instance = new PeriodoTest();
        instance.EliminarPeriodo(idPeriodo, nombrePeriodo, descripcion);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of LimpiarPeriodo method, of class PeriodoTest.
     */
    @Test
    public void testLimpiarPeriodo() {
        System.out.println("LimpiarPeriodo");
        String idPeriodo = "";
        String nombrePeriodo = "";
        String descripcion = "";
        PeriodoTest instance = new PeriodoTest();
        instance.LimpiarPeriodo(idPeriodo, nombrePeriodo, descripcion);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of actualizarDatos method, of class PeriodoTest.
     */
    @Test
    public void testActualizarDatos() {
        System.out.println("actualizarDatos");
        PeriodoTest instance = new PeriodoTest();
        instance.actualizarDatos();
        // TODO review the generated test code and remove the default call to fail.
       
    }
    
}
