/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PdfPackage;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author VIC31
 */
public class PdfPackage {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String htmlFile1 = "1.html";
        String pdfFile1 = "1.pdf";
        String htmlFile2 = "2.html";
        String pdfFile2 = "2.pdf";
        
        // Testing the HTML 2 PDF Conversion
        ConvertHtmlToPdfClass html2pdfObject1 = new ConvertHtmlToPdfClass(htmlFile1, pdfFile1);
        html2pdfObject1.convert2Pdf(html2pdfObject1.getHtmlFileName(), html2pdfObject1.getPdfFileName());
        
        MergePDFClass pdfcom = new MergePDFClass();

        List<String> pdf = new ArrayList<>();
        
        //pdfcom.combinePDFFiles(pdf, "newPDF.pdf");
    }
    
}
