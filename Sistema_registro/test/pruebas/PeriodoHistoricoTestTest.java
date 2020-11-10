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
import pruebas.PeriodoHistoricoTest;
import java.util.Date;
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
public class PeriodoHistoricoTestTest {
    
        Connection con = null;
    
    public PeriodoHistoricoTestTest() {
        
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
        
         try {
           Statement st = con.createStatement();
           String sql = "Select * from Periodo_historico where nombre_periodo_historico = '"+nombrePeriodo+"'";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                assertEquals(idPeriodo,rs.getString("id_periodo"));
                assertEquals(nombrePeriodo,rs.getString("nombre_periodo_historico"));
                assertEquals(fechaInicial,rs.getString("fecha_inicial"));
                assertEquals(fechaFinal,rs.getString("fecha_final"));
            }
                
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
        
    }

    /**
     * Test of ActualizarPriodoHistorico method, of class PeriodoHistoricoTest.
     */
    @Test
    public void testActualizarPriodoHistorico() {
        System.out.println("ActualizarPriodoHistorico");
        String idPeriodo = "2";
        String nombrePeriodo = "Quinto Periodo";
        String fechaInicial = "21/04/2020";
        String fechaFinal = "21/04/2020";
        PeriodoHistoricoTest instance = new PeriodoHistoricoTest();
        instance.ActualizarPriodoHistorico(idPeriodo, nombrePeriodo, fechaInicial, fechaFinal);
        // TODO review the generated test code and remove the default call to fail.
        
        try {
           Statement st = con.createStatement();
           String sql = "Select * from Periodo_historico where nombre_periodo_historico= '"+nombrePeriodo+"'";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                assertEquals(idPeriodo,rs.getString("id_periodo"));
                assertEquals(nombrePeriodo,rs.getString("nombre_periodo_historico"));
                assertEquals(fechaInicial,rs.getString("fecha_inicial"));
                assertEquals(fechaFinal,rs.getString("fecha_final"));
            }
                
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
        
    }

    /**
     * Test of ConsultarPeriodoHistorico method, of class PeriodoHistoricoTest.
     */
    @Test
    public void testConsultarPeriodoHistorico() {
        System.out.println("ConsultarPeriodoHistorico");
        String idPeriodo = "";
        String nombrePeriodo = "";
        String fechaInicial = "";
        String fechaFinal = "";
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
