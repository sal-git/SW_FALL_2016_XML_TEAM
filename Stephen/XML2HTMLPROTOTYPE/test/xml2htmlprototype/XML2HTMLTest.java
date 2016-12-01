/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xml2htmlprototype;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Germex
 */
public class XML2HTMLTest {
    
    public XML2HTMLTest() {
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
     * Test of getInstance method, of class XML2HTML.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        XML2HTML expResult = XML2HTML.getInstance();
        XML2HTML result = XML2HTML.getInstance();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of convert2Html method, of class XML2HTML.
     */
    @Test
    public void testConvert2Html() {
        System.out.println("convert2Html");
        String xmlFileName = "";
        String xslFileName = "";
        XML2HTML instance = XML2HTML.getInstance();
        String expResult = "";
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of convertDirectory2Html method, of class XML2HTML.
     */
    @Test
    public void testConvertDirectory2Html() {
        System.out.println("convertDirectory2Html");
        String directoryName = "";
        String xslFileName = "";
        String type = "";
        XML2HTML instance = new XML2HTML();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
