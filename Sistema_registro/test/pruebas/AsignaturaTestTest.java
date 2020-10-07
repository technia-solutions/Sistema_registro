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
public class AsignaturaTestTest {
      Connection con = null;
    
    public AsignaturaTestTest() {
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
     * Test of GuardarAsignatura method, of class AsignaturaTest.
     */
    @Test
    public void testGuardarAsignatura() {
        System.out.println("GuardarAsignatura");
        String CodAsignatura = "";
        String NombreAsignatura = "";
        String UnidadValorativa = "";
        String Carrera = "";
        String Req1 = "";
        String Req2 = "";
        AsignaturaTest instance = new AsignaturaTest();
        instance.GuardarAsignatura(CodAsignatura, NombreAsignatura, UnidadValorativa, Carrera, Req1, Req2);
        // TODO review the generated test code and remove the default call to fail.
       try {
            Statement st = con.createStatement();
            String sql = "Select * from Asignaturas where cod_asignaturas  = '"+CodAsignatura+"'";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                assertEquals(CodAsignatura,rs.getString("cod_asignaturas"));
                assertEquals(NombreAsignatura,rs.getString("nombre_asignaturas"));
                assertEquals(UnidadValorativa,rs.getString("UV"));
                assertEquals(Carrera,rs.getString("id_carrera"));
                assertEquals(Req1,rs.getString("requisito1"));
                assertEquals(Req2,rs.getString("requisito2"));
                
                
            }
        } catch (SQLException ex) {
           System.out.println(ex.getMessage());
        }
    }

    /**
     * Test of ActualizarAsignatura method, of class AsignaturaTest.
     */
    @Test
    public void testActualizarAsignatura() {
        System.out.println("ActualizarAsignatura");
        String CodAsignatura = "";
        String NombreAsignatura = "";
        String UnidadValorativa = "";
        String Carrera = "";
        String Req1 = "";
        String Req2 = "";
        AsignaturaTest instance = new AsignaturaTest();
        instance.ActualizarAsignatura(CodAsignatura, NombreAsignatura, UnidadValorativa, Carrera, Req1, Req2);
        // TODO review the generated test code and remove the default call to fail.
        try {
            Statement st = con.createStatement();
            String sql = "Select * from Asignaturas where cod_asignaturas  = '"+CodAsignatura+"'";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                assertEquals(CodAsignatura,rs.getString("cod_asignaturas"));
                assertEquals(NombreAsignatura,rs.getString("nombre_asignaturas"));
                assertEquals(UnidadValorativa,rs.getString("UV"));
                assertEquals(Carrera,rs.getString("id_carrera"));
                assertEquals(Req1,rs.getString("requisito1"));
                assertEquals(Req2,rs.getString("requisito2"));
                
                
            }
        } catch (SQLException ex) {
           System.out.println(ex.getMessage());
        }
    }

    /**
     * Test of EliminarAsignatura method, of class AsignaturaTest.
     */
    @Test
    public void testEliminarAsignatura() {
        System.out.println("EliminarAsignatura");
        String CodAsignatura = "";
        String NombreAsignatura = "";
        String UnidadValorativa = "";
        String Carrera = " ";
        String Req1 = "";
        String Req2 = "";
        AsignaturaTest instance = new AsignaturaTest();
        instance.EliminarAsignatura(CodAsignatura, NombreAsignatura, UnidadValorativa, Carrera, Req1, Req2);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of BuscarAsignatura method, of class AsignaturaTest.
     */
    @Test
    public void testBuscarAsignatura() {
        System.out.println("BuscarAsignatura");
        AsignaturaTest instance = new AsignaturaTest();
        instance.BuscarAsignatura();
        // TODO review the generated test code and remove the default call to fail.
      
    }
    
}
