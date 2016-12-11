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
        // Input and output files
        String htmlFile1 = "csci-1170.html";
        String pdfFile1 = "1.pdf";
        String htmlFile2 = "csci-1178.html";
        String pdfFile2 = "2.pdf";
        String htmlFile3 = "csci-1378.html";
        String pdfFile3 = "3.pdf";
        String htmlFile4 = "csci-1380.html";
        String pdfFile4 = "4.pdf";
        String htmlFile5 = "csci-1387.html";
        String pdfFile5 = "5.pdf";
        String htmlFile6 = "csci-2344.html";
        String pdfFile6 = "6.pdf";
        String htmlFile7 = "csci-3300.html";
        String pdfFile7 = "7.pdf";
        String htmlFile8 = "csci-3310.html";
        String pdfFile8 = "8.pdf";
        String htmlFile9 = "csci-3333.html";
        String pdfFile9 = "9.pdf";
        String htmlFile10 = "csci-3336.html";
        String pdfFile10 = "10.pdf";
        String htmlFile11 = "csci-3340.html";
        String pdfFile11 = "11.pdf";
        String htmlFile12 = "csci-3341.html";
        String pdfFile12 = "12.pdf";
        String htmlFile13 = "csci-3342.html";
        String pdfFile13 = "13.pdf";
        String htmlFile14 = "csci-3350.html";
        String pdfFile14 = "14.pdf";
        String htmlFile15 = "csci-3370.html";
        String pdfFile15 = "15.pdf";
        
        
        // Testing the HTML 2 PDF Conversion
        ConvertHtmlToPdfClass html2pdfObject1 = new ConvertHtmlToPdfClass(htmlFile1, pdfFile1);
        html2pdfObject1.convert2Pdf(htmlFile1, pdfFile1);        
        html2pdfObject1.convert2Pdf(htmlFile2, pdfFile2);
        html2pdfObject1.convert2Pdf(htmlFile3, pdfFile3);        
        html2pdfObject1.convert2Pdf(htmlFile4, pdfFile4);
        html2pdfObject1.convert2Pdf(htmlFile5, pdfFile5);        
        html2pdfObject1.convert2Pdf(htmlFile6, pdfFile6);
        html2pdfObject1.convert2Pdf(htmlFile7, pdfFile7);        
        html2pdfObject1.convert2Pdf(htmlFile8, pdfFile8);
        html2pdfObject1.convert2Pdf(htmlFile9, pdfFile9);        
        html2pdfObject1.convert2Pdf(htmlFile10, pdfFile10);
        html2pdfObject1.convert2Pdf(htmlFile11, pdfFile11);        
        html2pdfObject1.convert2Pdf(htmlFile12, pdfFile12);
        html2pdfObject1.convert2Pdf(htmlFile13, pdfFile13);        
        html2pdfObject1.convert2Pdf(htmlFile14, pdfFile14);
        html2pdfObject1.convert2Pdf(htmlFile15, pdfFile15);        
                
        // Merge PDF objects
        MergePDFClass pdfcom = new MergePDFClass();
        // Add object files to arraylist to merge
        List<String> pdf = new ArrayList<>();
        pdf.add("1.pdf");
        pdf.add("2.pdf");
        pdf.add("3.pdf");
        pdf.add("4.pdf");
        pdf.add("5.pdf");
        pdf.add("6.pdf");
        pdf.add("7.pdf");
        pdf.add("8.pdf");
        pdf.add("9.pdf");
        pdf.add("10.pdf");
        pdf.add("11.pdf");
        pdf.add("12.pdf");
        pdf.add("13.pdf");
        pdf.add("14.pdf");
        pdf.add("15.pdf");
        
        //merge all file objects in arraylist to MergePDF.pdf
        pdfcom.combinePDFFiles(pdf, "MergedPDF.pdf");
    }
    
}
