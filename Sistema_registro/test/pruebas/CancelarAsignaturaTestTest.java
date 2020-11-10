/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import pruebas.CancelarAsignaturaTest;
import java.sql.Connection;
import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sistema_registro.SQL.ConectorSQL;

/**
 *
 * @author wianp
 */
public class CancelarAsignaturaTestTest {
    
    Connection con = null;
    
    public CancelarAsignaturaTestTest() {
        
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
        String numeroCuenta = "";
        String idPeriodo = "";
        String idMatricula = "";
        String idSeccion = "";
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
