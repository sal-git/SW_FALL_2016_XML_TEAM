/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package htmlconverter;

import java.io.File;
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
     * Test of convert2Html method, of class XML2HTML.
     */
    @Test
    public void testConvert2Html() {
        System.out.println("convert2Html");
        String xmlFileName = "XML/Courses/csci-1101.xml";
        String xslFileName = "STYLES/course.xsl";
        String htmlFileName = "testHtml.html";
        XML2HTML.convert2Html(xmlFileName, xslFileName, htmlFileName);
        // TODO review the generated test code and remove the default call to fail.
        File file = new File("testHtml.html");
        assertTrue(file.exists());
    }

    /**
     * Test of convertDirectory2Html method, of class XML2HTML.
     */
    @Test
    public void testConvertDirectory2Html() {
        System.out.println("convertDirectory2Html");
        String directoryName = "XML/Courses/";
        String xslFileName = "STYLES/course.xsl";
        String outputDirectoryName = "TEMP/";
        XML2HTML.convertDirectory2Html(directoryName, xslFileName, outputDirectoryName);
        // TODO review the generated test code and remove the default call to fail.
        File file = new File("TEMP/csci-1378.html");
        File file2 = new File("TEMP/csci-4327.html");
        File file3 = new File("TEMP/csci-6305.html");
        assertTrue(file.exists() && file2.exists() && file3.exists());
    }
    
}
