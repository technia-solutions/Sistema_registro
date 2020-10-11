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
import org.apache.commons.codec.digest.DigestUtils;
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
public class EmpleadoPruebaIT {
    Connection con = null;
    
    public EmpleadoPruebaIT() {
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
     * Test of agregarEmpleado method, of class EmpleadoPrueba.
     */
    
    // Todas las pruebas de agregar el empleado aprobadas
    
    
    @Test
    public void testAgregarEmpleado() {
        System.out.println("agregarEmpleado");
        String nombres = "Walter";
        String apellidos = "White";
        String salario = "10500";
        String telefono = "97126534";
        String identidad = "0801199905220";
        String idCampus = "C001";
        String nombreUsuario = "walterwhite";
        String contraseña = "Admin1234";
        String tipoUsuario = "E";
        String contraseñaEncriptada=DigestUtils.md5Hex(contraseña);
        EmpleadoPrueba instance = new EmpleadoPrueba();
        instance.agregarEmpleado(nombres, apellidos, salario, telefono, identidad, idCampus, nombreUsuario, contraseña, tipoUsuario);
        try {
            Statement st = con.createStatement();
            String sql = "select top 1 * from Empleados as e join Acceso as a on e.id_empleado= a.id_empleado\n" +
                         "where numero_identidad = '"+identidad+"' or nombre_usuario = '"+nombreUsuario+"' order by e.id_empleado desc ";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                assertEquals(nombres,rs.getString("nombres_empleado"));
                assertEquals(apellidos,rs.getString("apellido_empleado"));
                assertEquals(salario,rs.getString("salario").substring(0, (salario.length())));
                assertEquals(telefono,rs.getString("telefono_empleado"));
                assertEquals(identidad,rs.getString("numero_identidad"));
                assertEquals(idCampus,rs.getString("id_campus"));
                assertEquals(nombreUsuario,rs.getString("nombre_usuario"));
                assertEquals(contraseñaEncriptada,rs.getString("clave_acceso"));
                assertEquals(tipoUsuario,rs.getString("id_tipoUsuario"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(FacultadPruebaIT.class.getName()).log(Level.SEVERE, null, ex);
        }
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of actualizarEmpleado method, of class EmpleadoPrueba.
     */
    
    //Todas las pruebas de actualizar empleado aprobadas
    
    
    @Test
    public void testActualizarEmpleado() {
        System.out.println("actualizarEmpleado");
        String nombres = "WalterManuel";
        String apellidos = "WhiteCruz";
        String salario = "10500";
        String telefono = "97126534";
        String identidad = "0801199905220";
        String idCampus = "C001";
        String nombreUsuario = "walterwhite";
        String contraseña = "Admin12345";
        String tipoUsuario = "E";
        String contraseñaEncriptada=DigestUtils.md5Hex(contraseña);
        EmpleadoPrueba instance = new EmpleadoPrueba();
        instance.actualizarEmpleado(nombres, apellidos, salario, telefono, identidad, idCampus, nombreUsuario, contraseña, tipoUsuario);
        // TODO review the generated test code and remove the default call to fail.
       try {
            Statement st = con.createStatement();
            String sql = "select top 1 * from Empleados as e join Acceso as a on e.id_empleado= a.id_empleado\n" +
                         "where numero_identidad = '"+identidad+"' or nombre_usuario = '"+nombreUsuario+"' order by e.id_empleado desc ";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                assertEquals(nombres,rs.getString("nombres_empleado"));
                assertEquals(apellidos,rs.getString("apellido_empleado"));
                assertEquals(salario,rs.getString("salario").substring(0, (salario.length())));
                assertEquals(telefono,rs.getString("telefono_empleado"));
                assertEquals(identidad,rs.getString("numero_identidad"));
                assertEquals(idCampus,rs.getString("id_campus"));
                assertEquals(nombreUsuario,rs.getString("nombre_usuario"));
                assertEquals(contraseñaEncriptada,rs.getString("clave_acceso"));
                assertEquals(tipoUsuario,rs.getString("id_tipoUsuario"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(FacultadPruebaIT.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of eliminarEmpleado method, of class EmpleadoPrueba.
     */
    
    //Todos los test de eliminar aprobados
    
    
    @Test
    public void testEliminarEmpleado() {
        System.out.println("eliminarEmpleado");
        String nombreUsuario = "walterwhite";
        String identidad = "0801199905220";
        EmpleadoPrueba instance = new EmpleadoPrueba();
        instance.eliminarEmpleado(nombreUsuario, identidad);
        // TODO review the generated test code and remove the default call to fail.
  
    }

    /**
     * Test of consultarEmpleado method, of class EmpleadoPrueba.
     */
    
    // Todos los test de consultarEmpleado aprobados
    
    
    @Test
    public void testConsultarEmpleado() {
        System.out.println("consultarEmpleado");
        EmpleadoPrueba instance = new EmpleadoPrueba();
        instance.consultarEmpleado();
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of consultaIndividualEmpleado method, of class EmpleadoPrueba.
     */
    
    //Todas las pruebas aprobadas
    
    
    @Test
    public void testConsultaIndividualEmpleado() {
        System.out.println("consultaIndividualEmpleado");
        String var = "Carlosb";
        EmpleadoPrueba instance = new EmpleadoPrueba();
        instance.consultaIndividualEmpleado(var);           
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of desbloquearUsuario method, of class EmpleadoPrueba.
     */
    
    //Todas las pruebas aprobadas
    
    @Test
    public void testDesbloquearUsuario() {
        System.out.println("desbloquearUsuario");
        EmpleadoPrueba instance = new EmpleadoPrueba();
        instance.desbloquearUsuario();
        // TODO review the generated test code and remove the default call to fail.
    }


}
