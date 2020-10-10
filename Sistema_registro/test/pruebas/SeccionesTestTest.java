/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

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
public class SeccionesTestTest {
    
    public SeccionesTestTest() {
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
     * Test of SeccionesTest method, of class SeccionesTest.
     */
    @Test
    public void testSeccionesTest() {
        System.out.println("SeccionesTest");
        SeccionesTest instance = new SeccionesTest();
        instance.SeccionesTest();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of GuardarSecciones method, of class SeccionesTest.
     */
    @Test
    public void testGuardarSecciones() {
        System.out.println("GuardarSecciones");
        String codigoAsignatura = "N";
        String nombreSeccion = "CAL201";
        String horaInicial = "12:30";
        String horaFinal = "14:30";
        String idPeriodo = "2";
        String idAula = "";
        String cantidadMaxima = "38";
        String dias = "";
        SeccionesTest instance = new SeccionesTest();
        instance.GuardarSecciones(codigoAsignatura, nombreSeccion, horaInicial, horaFinal, idPeriodo, idAula, cantidadMaxima, dias);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of ActualizarSecciones method, of class SeccionesTest.
     */
    @Test
    public void testActualizarSecciones() {
        System.out.println("ActualizarSecciones");
       
       String idPeriodo = "";
        String idAula = "";
        String nombreSeccion = "";
        String codigoAsignatura = "";
        String horaInicial = "";
        String horaFinal = "";
        String cantidadMaxima = "";
        String dias = "";
        SeccionesTest instance = new SeccionesTest();
        instance.ActualizarSecciones( idPeriodo, idAula, codigoAsignatura, horaInicial, horaFinal, cantidadMaxima, dias, nombreSeccion);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of BuscarSecciones method, of class SeccionesTest.
     */
    @Test
    public void testBuscarSecciones() {
        System.out.println("BuscarSecciones");
        SeccionesTest instance = new SeccionesTest();
        instance.BuscarSecciones();
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of EliminarSecciones method, of class SeccionesTest.
     */
    @Test
    public void testEliminarSecciones() {
        System.out.println("EliminarSecciones");
        
        
        
        String idPeriodo = "2";
        String idAula = "A101";
        String nombreSeccion = "Z";
        String codigoAsignatura = "ESP520";
        String horaInicial = "14:50";
        String horaFinal = "17:40";
        String cantidadMaxima = "60";
        String dias = "LuMiVi";
        
        SeccionesTest instance = new SeccionesTest();
        instance.EliminarSecciones( idPeriodo, idAula, codigoAsignatura, horaInicial, horaFinal, cantidadMaxima, dias, nombreSeccion);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of existeSeccion method, of class SeccionesTest.
     */
    @Test
    public void testExisteSeccion() {
        System.out.println("existeSeccion");
        SeccionesTest instance = new SeccionesTest();
        boolean expResult = false;
        boolean result = instance.existeSeccion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of existeidSeccion method, of class SeccionesTest.
     */
    @Test
    public void testExisteidSeccion() {
        System.out.println("existeidSeccion");
        SeccionesTest instance = new SeccionesTest();
        boolean expResult = false;
        boolean result = instance.existeidSeccion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of actualizarDatos method, of class SeccionesTest.
     */
    @Test
    public void testActualizarDatos() {
        System.out.println("actualizarDatos");
        SeccionesTest instance = new SeccionesTest();
        instance.actualizarDatos();
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
