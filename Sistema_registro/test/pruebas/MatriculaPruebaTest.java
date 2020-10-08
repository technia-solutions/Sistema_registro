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
 * @author Mitsuki
 */
public class MatriculaPruebaTest {
      Connection con = null;
    public MatriculaPruebaTest() {
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
     * Test of main method, of class MatriculaPrueba.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        MatriculaPrueba.main(args);
        // TODO review the generated test code and remove the default call to fail.
      //  fail("The test case is a prototype.");
    }

    /**
     * Test of agregarMatricula method, of class MatriculaPrueba.
     */
    @Test
    public void testAgregarMatricula() {
        System.out.println("agregarMatricula");
        String nombreAsignatura = "MT1014";
        String codigoAsignatura = "F";
        String numeroCuenta = "20201301";
        String id_periodo = "2";
        MatriculaPrueba instance = new MatriculaPrueba();
        String matricula="65";
       /* boolean expResult = false;
        boolean result = instance.agregarMatricula(nombreAsignatura, codigoAsignatura, numeroCuenta, id_periodo);
        assertEquals(expResult, result);*/
         try {          
            Statement st = con.createStatement();
            String sql = "Select * Matricula where id_facultad = '65'";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                assertEquals(matricula,rs.getString("id_matricula"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(FacultadPruebaIT.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
