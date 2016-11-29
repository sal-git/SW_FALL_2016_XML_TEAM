/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testinghtml2pdf;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static testinghtml2pdf.XMLGenerator.mergeMultipleXMLDocs;

/**
 *
 * @author MQ0162246
 */
public class MainApplication {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {

        // input files:
        String xmlFile  = "csci-3370.xml";
        String xslFile  = "course.xsl";
       
        // Output Files
        String htmlFile = "output.htm";
        String pdfFile  = "Job.pdf";
        
//        // Create XML document; you should have the xsl designed for it as well
//        XMLGenerator jobXML = new XMLGenerator(xmlFile);
//        jobXML.jobXMLGenerator(null);

        // Testing the XML 2 HTML Conversion
        XML2HTML xml2htmlObject = new XML2HTML(xmlFile, xslFile, htmlFile);
        xml2htmlObject.convert2Html(xml2htmlObject.getXmlFileName(), xml2htmlObject.getXslFileName(), xml2htmlObject.getHtmlFileName());

//        // Testing the HTML 2 PDF Conversion
//        HTML2PDF html2pdfObject = new HTML2PDF(xml2htmlObject.getHtmlFileName(), pdfFile);
//        html2pdfObject.convert2Pdf(html2pdfObject.getHtmlFileName(), html2pdfObject.getPdfFileName());
       
//        // Testing combine xml files into another xml
//          List<String> list = new ArrayList<>();
//          //list is hard coded...
//          list.add("Job.xml");
//          list.add("Faculty.xml");
//          //mergeMultipleXMLDocs(list of files,root node, output file);
//          mergeMultipleXMLDocs(list,"Resume-2016", "mkq-job-faculty.xml");

    }
}
