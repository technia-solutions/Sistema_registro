/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import pruebas.PeriodoHistoricoTest;
import java.util.Date;
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
public class PeriodoHistoricoTestTest {
    
    public PeriodoHistoricoTestTest() {
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
     * Test of cargarFecha method, of class PeriodoHistoricoTest.
     */
    @Test
    public void testCargarFecha() {
        System.out.println("cargarFecha");
        int dia = 0;
        int mes = 0;
        int anio = 0;
        PeriodoHistoricoTest.cargarFecha(dia, mes, anio);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDateCalendar method, of class PeriodoHistoricoTest.
     */
    @Test
    public void testGetDateCalendar() {
        System.out.println("getDateCalendar");
        Date expResult = null;
        Date result = PeriodoHistoricoTest.getDateCalendar();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of DateAString method, of class PeriodoHistoricoTest.
     */
    @Test
    public void testDateAString() {
        System.out.println("DateAString");
        Date fecha = null;
        String expResult = "";
        String result = PeriodoHistoricoTest.DateAString(fecha);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of AgregarPeriodoHistorico method, of class PeriodoHistoricoTest.
     */
    @Test
    public void testAgregarPeriodoHistorico() {
        System.out.println("AgregarPeriodoHistorico");
        String idPeriodo = "";
        String nombrePeriodo = "";
        String fechaInicial = "";
        String fechaFinal = "";
        PeriodoHistoricoTest instance = new PeriodoHistoricoTest();
        instance.AgregarPeriodoHistorico(idPeriodo, nombrePeriodo, fechaInicial, fechaFinal);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of ActualizarPriodoHistorico method, of class PeriodoHistoricoTest.
     */
    @Test
    public void testActualizarPriodoHistorico() {
        System.out.println("ActualizarPriodoHistorico");
        String idPeriodo = "";
        String nombrePeriodo = "";
        String fechaInicial = "";
        String fechaFinal = "";
        PeriodoHistoricoTest instance = new PeriodoHistoricoTest();
        instance.ActualizarPriodoHistorico(idPeriodo, nombrePeriodo, fechaInicial, fechaFinal);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of ConsultarPeriodoHistorico method, of class PeriodoHistoricoTest.
     */
    @Test
    public void testConsultarPeriodoHistorico() {
        System.out.println("ConsultarPeriodoHistorico");
        String idPeriodo = "1";
        String nombrePeriodo = "2020-1";
        String fechaInicial = "2020-05-15";
        String fechaFinal = "2020-09-25";
        PeriodoHistoricoTest instance = new PeriodoHistoricoTest();
        instance.ConsultarPeriodoHistorico(idPeriodo, nombrePeriodo, fechaInicial, fechaFinal);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of ActualizarDatos method, of class PeriodoHistoricoTest.
     */
    @Test
    public void testActualizarDatos() {
        System.out.println("ActualizarDatos");
        PeriodoHistoricoTest instance = new PeriodoHistoricoTest();
        instance.ActualizarDatos();
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
