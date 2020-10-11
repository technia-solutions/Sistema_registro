/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Carlos
 */
public class LoginPruebaIT {
    
    public LoginPruebaIT() {
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
     * Test of ingresar method, of class LoginPrueba.
     */
    @Test
    public void testIngresar() {
        System.out.println("ingresar");
        String usuario = "carloschamorro";
        String contraseña = "Admin1234";
        LoginPrueba instance = new LoginPrueba();
        instance.ingresar(usuario, contraseña);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
