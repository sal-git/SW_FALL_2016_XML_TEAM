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
        
        //Test converting whole directory 
        test.convertDirectory2Html("File:///../XML/COURSES/", "STYLES/course.xsl", "course");
        
        
    }
    
}
