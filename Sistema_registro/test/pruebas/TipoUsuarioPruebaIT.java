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
 * @author Carlos
 */
public class TipoUsuarioPruebaIT {
     Connection con = null;
    
    public TipoUsuarioPruebaIT() throws SQLException {
        this.con = ConectorSQL.obtenerConexion();
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
     * Test of guardarTipoUsuario method, of class TipoUsuarioPrueba.
     */
    
    
    //Todas las pruebas del test guardar aprobadas
    
    
    @Test
    public void testGuardarTipoUsuario() {
        System.out.println("guardarTipoUsuario");
        String idTipoUsuario = "S";
        String nombreTipoUsuario = "Supervisor";
        TipoUsuarioPrueba instance = new TipoUsuarioPrueba();
        instance.guardarTipoUsuario(idTipoUsuario, nombreTipoUsuario);
       try {
            Statement st = con.createStatement();
            String sql = "Select * from Tipo_Usuarios where id_tipoUsuario = '"+idTipoUsuario+"'";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                assertEquals(idTipoUsuario,rs.getString("id_tipoUsuario"));
                assertEquals(nombreTipoUsuario,rs.getString("Tipo_Usuario"));
            }
        } catch (SQLException ex) {
           System.out.println(ex.getMessage());
        }
        // TODO review the generated test code and remove the default call to fail.
    }
    
 

    /**
     * Test of actualizarTipoUsuario method, of class TipoUsuarioPrueba.
     */
    
    // Todas las pruebas aprobadas del metodo actualizar
    
    
    @Test
    public void testActualizarTipoUsuario() {
        System.out.println("actualizarTipoUsuario");
        String idTipoUsuario = "S";
        String nombreTipoUsuario = "Supervisores";
        TipoUsuarioPrueba instance = new TipoUsuarioPrueba();
        instance.actualizarTipoUsuario(idTipoUsuario, nombreTipoUsuario);
        // TODO review the generated test code and remove the default call to fail.
       try {
            Statement st = con.createStatement();
            String sql = "Select * from Tipo_Usuarios where id_tipoUsuario = '"+idTipoUsuario+"'";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                assertEquals(idTipoUsuario,rs.getString("id_tipoUsuario"));
                assertEquals(nombreTipoUsuario,rs.getString("Tipo_Usuario"));
            }
        } catch (SQLException ex) {
           System.out.println(ex.getMessage());
        }
    }

    /**
     * Test of eliminarTipoUsuario method, of class TipoUsuarioPrueba.
     */
    
    //Todas las pruebas aprobadas del metodo eliminar
    
    
    @Test
    public void testEliminarTipoUsuario() {
        System.out.println("eliminarTipoUsuario");
        String idTipoUsuario = "S";
        String nombreTipoUsuario = "Supervisoresasaddsa";
        TipoUsuarioPrueba instance = new TipoUsuarioPrueba();
        instance.eliminarTipoUsuario(idTipoUsuario, nombreTipoUsuario);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of buscarTipoUsuario method, of class TipoUsuarioPrueba.
     */
    
    
    @Test
    public void testBuscarTipoUsuario() {
        System.out.println("buscarTipoUsuario");
        TipoUsuarioPrueba instance = new TipoUsuarioPrueba();
        instance.buscarTipoUsuario();
        // TODO review the generated test code and remove the default call to fail.
    
    }
    
}
