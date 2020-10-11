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
public class AlumnoPruebaIT {
    Connection con;
    
    public AlumnoPruebaIT() {
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
     * Test of agregarAlumno method, of class AlumnoPrueba.
     */
    
    // Todos los test de agregar alumno aprobados
    
    
    @Test
    public void testAgregarAlumno() {
        System.out.println("agregarAlumno");
        String nombreAlumno = "Walter";
        String apellidoAlumno = "White";
        String identidad = "0801199905225";
        String telefonoAlumno = "37174626";
        String fechaNacimiento = "1999-10-02";
        String idCarrera = "C001";
        String idPeriodo = "3";
        String idCampus = "C003";
        AlumnoPrueba instance = new AlumnoPrueba();
        instance.agregarAlumno(nombreAlumno, apellidoAlumno, identidad, telefonoAlumno, fechaNacimiento, idCarrera, idPeriodo, idCampus);
        
        // TODO review the generated test code and remove the default call to fail.
        try {
            String numeroDeCuenta = "";
            Statement st2 = con.createStatement();
            String sql2 = "select * from Alumno\n" +
                         "where numero_identidad = '"+identidad+"' ";
            ResultSet rs2 = st2.executeQuery(sql2);
            if(rs2.next()){
               numeroDeCuenta = rs2.getString("numero_cuenta_alumno");
            }
            else{
                return;
            }
            Statement st = con.createStatement();
            String sql = "select * from Alumno\n" +
                         "where numero_cuenta_alumno = '"+numeroDeCuenta+"' ";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                assertEquals(nombreAlumno,rs.getString("nombres_alumno"));
                assertEquals(apellidoAlumno,rs.getString("apellidos_alumno"));
                assertEquals(identidad,rs.getString("numero_identidad"));
                assertEquals(telefonoAlumno,rs.getString("telefono_alumno"));
                assertEquals(fechaNacimiento,rs.getString("fecha_nacimiento"));
                assertEquals(idCarrera,rs.getString("id_carrera"));
                assertEquals(idPeriodo,rs.getString("id_periodo"));
                assertEquals(idCampus,rs.getString("id_campus"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Test of actualizarAlumno method, of class AlumnoPrueba.
     */
    
    // Todas las pruebas de actualizar Alumno aprobadas
    
    
    @Test
    public void testActualizarAlumno() {
        System.out.println("actualizarAlumno");
       String nombreAlumno = "Walter";
        String apellidoAlumno = "White";
        String identidad = "0801199905225";
        String telefonoAlumno = "37174626";
        String fechaNacimiento = "1999-10-02";
        String idCarrera = "C001";
        String idPeriodo = "3";
        String idCampus = "C003";
        AlumnoPrueba instance = new AlumnoPrueba();
        instance.actualizarAlumno(nombreAlumno, apellidoAlumno, identidad, telefonoAlumno, fechaNacimiento, idCarrera, idPeriodo, idCampus);
        // TODO review the generated test code and remove the default call to fail.
         try {
            String numeroDeCuenta = "";
            Statement st2 = con.createStatement();
            String sql2 = "select * from Alumno\n" +
                         "where numero_identidad = '"+identidad+"' ";
            ResultSet rs2 = st2.executeQuery(sql2);
            if(rs2.next()){
               numeroDeCuenta = rs2.getString("numero_cuenta_alumno");
            }
            else{
                return;
            }
            Statement st = con.createStatement();
            String sql = "select * from Alumno\n" +
                         "where numero_cuenta_alumno = '"+numeroDeCuenta+"' ";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                assertEquals(nombreAlumno,rs.getString("nombres_alumno"));
                assertEquals(apellidoAlumno,rs.getString("apellidos_alumno"));
                assertEquals(identidad,rs.getString("numero_identidad"));
                assertEquals(telefonoAlumno,rs.getString("telefono_alumno"));
                assertEquals(fechaNacimiento,rs.getString("fecha_nacimiento"));
                assertEquals(idCarrera,rs.getString("id_carrera"));
                assertEquals(idPeriodo,rs.getString("id_periodo"));
                assertEquals(idCampus,rs.getString("id_campus"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Test of buscarAlumno method, of class AlumnoPrueba.
     */
    
    // Todas las pruebas aprobadas
    
    @Test
    public void testBuscarAlumno() {
        System.out.println("buscarAlumno");
        AlumnoPrueba instance = new AlumnoPrueba();
        instance.buscarAlumno();
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
