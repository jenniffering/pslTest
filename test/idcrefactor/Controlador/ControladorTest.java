/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idcrefactor.Controlador;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jenniffer
 */
public class ControladorTest {
    
    public ControladorTest() {
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
     * Prueba del metodo isNumeric, de la clase controlador.
     */
    @Test
    public void testIsNumeric() {
        System.out.println("isNumeric");
        String cadena = "567";
        boolean expResult = true;
        boolean result = Controlador.isNumeric(cadena);
        assertEquals(expResult, result);
        
        if (result != expResult){
        fail("The test case is a prototype.");
        }else{
        }
    }
    
}
