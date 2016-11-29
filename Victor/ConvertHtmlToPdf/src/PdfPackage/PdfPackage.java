/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PdfPackage;


import com.lowagie.text.DocumentException;
import java.io.File;
import java.io.IOException;
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
    public static void main(String[] args) throws DocumentException, IOException {
        // TODO code application logic here
        String htmlFile1 = "1.html";
        String pdfFile1 = "1.pdf";
        String htmlFile2 = "2.html";
        String pdfFile2 = "2.pdf";
        String htmlFile3 = "3.html";
        String pdfFile3 = "3.pdf";
        String htmlFile4 = "4.html";
        String pdfFile4 = "4.pdf";
        
        // Testing the HTML 2 PDF Conversion
        ConvertHtmlToPdfClass html2pdfObject1 = new ConvertHtmlToPdfClass(htmlFile1, pdfFile1);
        html2pdfObject1.convert2Pdf(htmlFile1, pdfFile1);        
        html2pdfObject1.convert2Pdf(htmlFile2, pdfFile2);
        html2pdfObject1.convert2Pdf(htmlFile3, pdfFile3);        
        html2pdfObject1.convert2Pdf(htmlFile4, pdfFile4);
        
        MergePDFClass pdfcom = new MergePDFClass();

        List<String> pdf = new ArrayList<>();
        pdf.add("1.pdf");
        pdf.add("2.pdf");
        pdf.add("3.pdf");
        pdf.add("4.pdf");
        
        pdfcom.combinePDFFiles(pdf, "MergedPDF.pdf");
    }
    
}
