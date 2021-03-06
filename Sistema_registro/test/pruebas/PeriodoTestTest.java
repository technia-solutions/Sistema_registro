/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import pruebas.PeriodoTest;
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
public class PeriodoTestTest {
    
    Connection con = null;
    
    
    public PeriodoTestTest() {
        
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
     * Test of GuardarPeriodo method, of class PeriodoTest.
     */
    @Test
    public void testGuardarPeriodo() {
        System.out.println("GuardarPeriodo");
        String idPeriodo = "s";
        String nombrePeriodo = "s";
        String descripcion = "Cuarto periodo";
        PeriodoTest instance = new PeriodoTest();
        instance.GuardarPeriodo(idPeriodo, nombrePeriodo, descripcion);
        // TODO review the generated test code and remove the default call to fail.
   
        try {
           Statement st = con.createStatement();
           String sql = "Select * from Periodo where id_periodo = '"+idPeriodo+"'";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                assertEquals(idPeriodo,rs.getString("id_periodo"));
                assertEquals(nombrePeriodo,rs.getString("periodo"));
                assertEquals(descripcion,rs.getString("descripcion"));
            }
                
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
        
     
        
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
      
          try {
           Statement st = con.createStatement();
           String sql = "Select * from Periodo where id_periodo = '"+idPeriodo+"'";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                assertEquals(idPeriodo,rs.getString("id_periodo"));
                assertEquals(nombrePeriodo,rs.getString("periodo"));
                assertEquals(descripcion,rs.getString("descripcion"));
            }
                
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
        
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
