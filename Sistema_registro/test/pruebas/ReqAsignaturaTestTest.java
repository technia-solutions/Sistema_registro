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
public class ReqAsignaturaTestTest {
      Connection con = null;
    public ReqAsignaturaTestTest() {
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
     * Test of GuardarReqAsignatura method, of class ReqAsignaturaTest.
     */
    @Test
    public void testGuardarReqAsignatura() {
        System.out.println("GuardarReqAsignatura");
        String idReqAsignatura = "";
        String NombreAsignatura = "";
        String Carrera = "";
        ReqAsignaturaTest instance = new ReqAsignaturaTest();
        instance.GuardarReqAsignatura(idReqAsignatura, NombreAsignatura, Carrera);
        // TODO review the generated test code and remove the default call to fail.
          try {
            Statement st = con.createStatement();
            String sql = "Select * from Requisito_Asignatura where id_asignatura  = '"+idReqAsignatura+"'";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                assertEquals(idReqAsignatura,rs.getString("id_asignatura"));
                assertEquals(NombreAsignatura,rs.getString("RequisitoAsignatura"));
                assertEquals(Carrera,rs.getString("id_carrera"));
                
                
                
            }
        } catch (SQLException ex) {
           System.out.println(ex.getMessage());
        }
    }

    /**
     * Test of ActualizarReqAsignatura method, of class ReqAsignaturaTest.
     */
    @Test
    public void testActualizarReqAsignatura() {
        System.out.println("ActualizarReqAsignatura");
        String idReqAsignatura = "";
        String NombreAsignatura = "";
        String Carrera = "";
        ReqAsignaturaTest instance = new ReqAsignaturaTest();
        instance.ActualizarReqAsignatura(idReqAsignatura, NombreAsignatura, Carrera);
        // TODO review the generated test code and remove the default call to fail.
        try {
            Statement st = con.createStatement();
            String sql = "Select * from Requisito_Asignatura where id_asignatura  = '"+idReqAsignatura+"'";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                assertEquals(idReqAsignatura,rs.getString("id_asignatura"));
                assertEquals(NombreAsignatura,rs.getString("RequisitoAsignatura"));
                assertEquals(Carrera,rs.getString("id_carrera"));
            }
        } catch (SQLException ex) {
           System.out.println(ex.getMessage());
        }
    }

    /**
     * Test of EliminarReqAsignatura method, of class ReqAsignaturaTest.
     */
    @Test
    public void testEliminarReqAsignatura() {
        System.out.println("EliminarReqAsignatura");
        String idReqAsignatura = "Ing101";
        String NombreAsignatura = "@@@@@@@@@";
        String Carrera = "c005";
        ReqAsignaturaTest instance = new ReqAsignaturaTest();
        instance.EliminarReqAsignatura(idReqAsignatura, NombreAsignatura, Carrera);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of BuscarReqAsignatura method, of class ReqAsignaturaTest.
     */
    @Test
    public void testBuscarReqAsignatura() {
        System.out.println("BuscarReqAsignatura");
        String idReqAsignatura = "";
        String NombreAsignatura = "";
        String Carrera = "";
        ReqAsignaturaTest instance = new ReqAsignaturaTest();
        instance.BuscarReqAsignatura(idReqAsignatura, NombreAsignatura, Carrera);
        // TODO review the generated test code and remove the default call to fail.
       
    }
    
}
