/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package htmlconverter;

/**
 *
 * @author Germex
 */
public class HTMLConverter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        
//        XML2HTML.convert2Html("XML/Courses/csci-1170/csci-1170.xml", "STYLES/course.xsl", "TEMP/output.html");
        
        XML2HTML.convertDirectory2Html("XML/Courses", "STYLES/course.xsl", "TEMP/");
        
    }
    
}
