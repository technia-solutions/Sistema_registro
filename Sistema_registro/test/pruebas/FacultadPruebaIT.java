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
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sistema_registro.SQL.ConectorSQL;
/**
 *
 * @author Carlos
 */
public class FacultadPruebaIT {
    Connection con = null;
    
    public FacultadPruebaIT() {
        try {
             this.con = ConectorSQL.obtenerConexion();
         } catch (SQLException ex) {
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
     * Test of guardarFacultad method, of class FacultadPrueba.
     */
    
    // Aprobadas todas las pruebas del test guardar
    
    
    @Test
    public void testGuardarFacultad() {
        System.out.println("guardarFacultad");
        String idFacultad = "F010";
        String nombreFacultad = "Facultad de ingenieria VS";
        FacultadPrueba instance = new FacultadPrueba();
        instance.guardarFacultad(idFacultad, nombreFacultad);
        try {
            Statement st = con.createStatement();
            String sql = "Select * from Facultad where id_facultad = '"+idFacultad+"'";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                assertEquals(idFacultad,rs.getString("id_facultad"));
                assertEquals(nombreFacultad,rs.getString("nombre_facultad"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(FacultadPruebaIT.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    

    /**
     * Test of actualizarNombreFacultad method, of class FacultadPrueba.
     */
    
    //Aprobadas todas las pruebas de actualizar
    
    
    
    @Test
    public void testActualizarNombreFacultad() {
        System.out.println("actualizarNombreFacultad");
        String idFacultad = "F010";
        String nombreFacultad = "Facultad de ingenieria V.S";
        FacultadPrueba instance = new FacultadPrueba();
        instance.actualizarNombreFacultad(idFacultad, nombreFacultad);
        // TODO review the generated test code and remove the default call to fail.
        try {          
            Statement st = con.createStatement();
            String sql = "Select * from Facultad where id_facultad = '"+idFacultad+"'";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                assertEquals(idFacultad,rs.getString("id_facultad"));
                assertEquals(nombreFacultad,rs.getString("nombre_facultad"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(FacultadPruebaIT.class.getName()).log(Level.SEVERE, null, ex);
        }
       // fail("The test case is a prototype.");
    }
    
    
    /**
     * Test of eliminarFacultad method, of class FacultadPrueba.
     */
    
    //Test aprobados correctamente
    
    @Test
    public void testEliminarFacultad() {
        System.out.println("eliminarFacultad");
        String nombreFacultad = "Facultad de ingenieria V.S";
        FacultadPrueba instance = new FacultadPrueba();
        instance.eliminarFacultad(nombreFacultad);
        // TODO review the generated test code and remove the default call to fail.
      //  fail("The test case is a prototype.");
    }

    /**
     * Test of buscarFacultad method, of class FacultadPrueba.
     */
    
    // Test aprobados en buscar facultad
    
    
    @Test
    public void testBuscarFacultad() {
        System.out.println("buscarFacultad");
        FacultadPrueba instance = new FacultadPrueba();
        instance.buscarFacultad();
        // TODO review the generated test code and remove the default call to fail.
      //  fail("The test case is a prototype.");
    }

    
    
    
}
