/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package htmlconverter;

import com.lowagie.text.DocumentException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Germex
 */
public class HTMLConverter {

    
//    public ArrayList<String> files = new ArrayList<>(); 
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws DocumentException, IOException {
        // TODO code application logic here
//        
//        XML2HTML.convert2Html("XML/Courses/biol-1406.xml", "STYLES/course.xsl", "TEMP/output.html");
        
//        XML2HTML.convertDirectory2Html("XML/Courses", "STYLES/course.xsl", "TEMP/");
        
//        List<String> files = new ArrayList<>();
//        
//        files.add("csci-1101.pdf");
//        files.add("csci-1105.pdf");
//        files.add("csci-1170.pdf");
        
        
//        PDFConverter.convert2Pdf("csci-1380.xml", "XML2PDFTEST.pdf");

//        PDFConverter.combinePDFFiles(files, "CombinedPDFFiles.pdf");

//        PDFConverter.combinePDFFiles(currentNode);


          XMLMerger.mergeFilesFromDirectory("XML/Courses", "POS", "STYLES/CMPE-POS.xsl", "CMPE-POS.xml");
        
    }
    
}
