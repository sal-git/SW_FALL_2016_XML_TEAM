/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package htmlconverter;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
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
public class PDFConverterTest {

    public PDFConverterTest() {
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
     * Test of convert2Pdf method, of class PDFConverter.
     */
    @Test
    public void testConvert2Pdf() {
        System.out.println("convert2Pdf");
        String htmlFileName = "TEMP/csci-1170.html";
        String pdfFileName = "test.pdf";
        PDFConverter.convert2Pdf(htmlFileName, pdfFileName);
        // TODO review the generated test code and remove the default call to fail.
        File file = new File("test.pdf");
        assertTrue(file.exists());
    }

    /**
     * Test of combinePDFFiles method, of class PDFConverter.
     */
    @Test
    public void testCombinePDFFiles() throws Exception {
        System.out.println("combinePDFFiles");
        List<String> list = new ArrayList<>();
        
        list.add("csci-1101.pdf");
        list.add("csci-1105.pdf");
        list.add("csci-1170.pdf");
        
        String outName = "combinedPDFTest.pdf";
        PDFConverter.combinePDFFiles(list, outName);
        // TODO review the generated test code and remove the default call to fail.
        
        File file = new File("combinedPDFTest.pdf");
        assertTrue(file.exists());
    }

}
