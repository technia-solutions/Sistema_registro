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
public class CancelarAsignaturaTestTest {
    
    public CancelarAsignaturaTestTest() {
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
     * Test of Buscar method, of class CancelarAsignaturaTest.
     */
    @Test
    public void testBuscar1() {
        System.out.println("Buscar");
        CancelarAsignaturaTest instance = new CancelarAsignaturaTest();
        instance.Buscar();
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of EliminarMatricula method, of class CancelarAsignaturaTest.
     */
    @Test
    public void testEliminarMatricula() {
        System.out.println("EliminarMatricula");
        boolean validar = false;
        String numeroCuenta = "";
        String idPeriodo = "";
        CancelarAsignaturaTest instance = new CancelarAsignaturaTest();
        instance.EliminarMatricula(validar, numeroCuenta, idPeriodo);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of CancelarAsignatura method, of class CancelarAsignaturaTest.
     */
    @Test
    public void testCancelarAsignatura() {
        System.out.println("CancelarAsignatura");
        String numeroCuenta = "20201202";
        String idPeriodo = "3";
        String idMatricula = "42";
        String idSeccion = "ESP520-Z";
        CancelarAsignaturaTest instance = new CancelarAsignaturaTest();
        instance.CancelarAsignatura(numeroCuenta, idPeriodo, idMatricula, idSeccion);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of buscar method, of class CancelarAsignaturaTest.
     */
    @Test
    public void testBuscar2() {
        System.out.println("buscar");
        CancelarAsignaturaTest instance = new CancelarAsignaturaTest();
        instance.buscar();
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
