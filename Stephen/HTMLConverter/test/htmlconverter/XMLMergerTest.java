/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package htmlconverter;

import java.io.File;
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
public class XMLMergerTest {

    /**
     * Test of mergeMultipleXMLDocs method, of class XMLMerger.
     */
    @Test
    public void testMergeMultipleXMLDocs() {
        System.out.println("mergeMultipleXMLDocs");
        List<File> list = null;
        String jointXmlRootNode = "";
        String outName = "";
        XMLMerger.mergeMultipleXMLDocs(list, jointXmlRootNode, outName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mergeFilesFromDirectory method, of class XMLMerger.
     */
    @Test
    public void testMergeFilesFromDirectory() {
        System.out.println("mergeFilesFromDirectory");
        String directoryName = "";
        String jointXMLRootNode = "";
        String output = "";
        XMLMerger.mergeFilesFromDirectory(directoryName, jointXMLRootNode, output);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
