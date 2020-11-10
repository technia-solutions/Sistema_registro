/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import pruebas.SeccionesTest;
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
 * @author wianp
 */
public class SeccionesTestTest {
    
    Connection con = null;
    
    public SeccionesTestTest() {
        
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
        String codigoAsignatura = "";
        String nombreSeccion = "";
        String horaInicial = "";
        String horaFinal = "";
        String idPeriodo = "";
        String idAula = "";
        String cantidadMaxima = "";
        String dias = "";
        SeccionesTest instance = new SeccionesTest();
        instance.GuardarSecciones(codigoAsignatura, nombreSeccion, horaInicial, horaFinal, idPeriodo, idAula, cantidadMaxima, dias);
        // TODO review the generated test code and remove the default call to fail.
         try {
           Statement st = con.createStatement();
           String sql = "Select * from Secciones where id_periodo = '"+nombreSeccion+"'";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
               
                assertEquals(codigoAsignatura,rs.getString("cod_asignaturas"));
                assertEquals(nombreSeccion,rs.getString("Nombre_seccion"));
                assertEquals(horaInicial,rs.getString("Hora_inicial"));
                assertEquals(horaFinal,rs.getString("Hora_final"));
                assertEquals(idPeriodo,rs.getString("id_periodo"));
                assertEquals(idAula,rs.getString("id_aula"));
                assertEquals(cantidadMaxima,rs.getString("cantidad_maxima"));
                assertEquals(dias,rs.getString("dias"));
            }
                
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
        
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
        instance.ActualizarSecciones(idPeriodo, idAula, nombreSeccion, codigoAsignatura, horaInicial, horaFinal, cantidadMaxima, dias);
        // TODO review the generated test code and remove the default call to fail.
        try {
           Statement st = con.createStatement();
           String sql = "Select * from Secciones where id_periodo = '"+nombreSeccion+"'";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
               
                assertEquals(codigoAsignatura,rs.getString("cod_asignaturas"));
                assertEquals(nombreSeccion,rs.getString("Nombre_seccion"));
                assertEquals(horaInicial,rs.getString("Hora_inicial"));
                assertEquals(horaFinal,rs.getString("Hora_final"));
                assertEquals(idPeriodo,rs.getString("id_periodo"));
                assertEquals(idAula,rs.getString("id_aula"));
                assertEquals(cantidadMaxima,rs.getString("cantidad_maxima"));
                assertEquals(dias,rs.getString("dias"));
            }
                
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
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
        String idPeriodo = "";
        String idAula = "";
        String codigoAsignatura = "";
        String horaInicial = "";
        String horaFinal = "";
        String cantidadMaxima = "";
        String dias = "";
        String nombreSeccion = "";
        SeccionesTest instance = new SeccionesTest();
        instance.EliminarSecciones(idPeriodo, idAula, codigoAsignatura, horaInicial, horaFinal, cantidadMaxima, dias, nombreSeccion);
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
        fail("The test case is a prototype.");
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
