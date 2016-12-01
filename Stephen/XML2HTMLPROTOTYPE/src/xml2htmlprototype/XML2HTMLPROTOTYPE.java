/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xml2htmlprototype;

/**
 *
 * @author Germex
 */
public class XML2HTMLPROTOTYPE {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        XML2HTML test = XML2HTML.getInstance();
        Merger test2 = Merger.getInstance();
        
        //Text converting one file
        test.convert2Html("XML/COURSES/csci-1387/csci-1387.xml", "STYLES/course.xsl", "testOneXML2HTML.html");

        //Test converting whole directory 
        test.convertDirectory2Html("File:///../XML/COURSES/", "STYLES/course.xsl", "course", "TEMP/");
        
        //Test merging whole directory 
        test2.mergeFilesFromDirectory2HTML("File:///../XML/COURSES/", "POS", "STYLES/POS_XSL.xsl", "course", "testo.xml");
        
        
    }
    
}
