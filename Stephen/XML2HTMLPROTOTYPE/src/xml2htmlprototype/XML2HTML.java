/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xml2htmlprototype;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * Class implements only one instance of the converter to convert single XML
 * files to HTML given the correct XSL, or an entire directory of sub
 * directories given the file you want - 'course', 'abet', or 'outcomes'. It can
 * also merge XML files given that the newly merged XML will be converted to an
 * HTML file.
 *
 * @author Germex
 */
public class XML2HTML {

    //List of files of the given direcotry
    private ArrayList<File> filesGathered = new ArrayList<>();

    //Single instance of the convert
    private static XML2HTML instance = null;

    //remove .xml from file name 
    private int eliminateFileExtenz;

    //Constructor 
    /**
     *
     */
    protected XML2HTML() {
        // Exists only to defeat instantiation.
    }

    /**
     * Get single instance of the converter
     *
     * @return
     */
    public static XML2HTML getInstance() {
        if (instance == null) {
            instance = new XML2HTML();
        }
        return instance;
    }

    /**
     * Converts 1 XML to HTML
     *
     * @param xmlFileName
     * @param xslFileName
     * @return
     */
    public void convert2Html(String xmlFileName, String xslFileName, String output) {
        try {
            // Obtain transformer object
            TransformerFactory tFactory = TransformerFactory.newInstance();
            // xsl
            StreamSource xslStreamSourceObject = new StreamSource(xslFileName);
            //xml
            StreamSource xmlStreamSourceObject = new StreamSource(xmlFileName);
            //html
            FileOutputStream fos = new FileOutputStream(output);
            StreamResult htmlStreamSourceObject = new StreamResult(fos);
            //Transform & results
            Transformer transformer = tFactory.newTransformer(xslStreamSourceObject);
            transformer.setOutputProperty(OutputKeys.METHOD, "xml");
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");

            transformer.transform(xmlStreamSourceObject, htmlStreamSourceObject);
        } catch (Exception e) {
            System.out.println("Error in convert2Html method: " + e);
        }
    }

    /**
     * Generate HTML files for every XML file in Directory given the type - i.e
     * ABET, Course, Faculty, or Outcomes. Ex: If user wants to only get courses
     * type = 'course' , if you user wants only ABET, then type = 'ABET'.
     * 'outcomes' = TYPE. Output should only be the destination of the file as
     * the output will be the same name as the input xml - i.e csci-xxxx.xml
     * should get an output of "TEMP/" so that the path will be:
     * TEMP/csci-xxx.html
     *
     * @param directoryName
     * @param xslFileName
     * @param type
     * @param output
     */
    public void convertDirectory2Html(String directoryName, String xslFileName, String type, String output) {
        //Get all files and put them into a arraylist
        generateAllFilesInDirectory(directoryName, filesGathered, type);

        //Remove the extension after conversion: csci-xxxx.xml.html -> csci-xxxx.html
        switch (type) {
            case "course":
                eliminateFileExtenz = 9;
                break;
            case "abet":
                eliminateFileExtenz = 14;
                break;
            case "outcomes":
                eliminateFileExtenz = 18;
                break;
            default:
                //Nothing
                break;
        }

        //Loop thorugh all files and generate a html for them
        for (int i = 0; i < filesGathered.size(); i++) {
            try {
                // Obtain transformer object
                TransformerFactory tFactory = TransformerFactory.newInstance();
                // xsl
                StreamSource xslStreamSourceObject = new StreamSource(xslFileName);
                //xml
                StreamSource xmlStreamSourceObject = new StreamSource(filesGathered.get(i).getPath());
                //Output HTML with corresponding XML name: csci-xxxx.xml -> csci-xxxx.html
                FileOutputStream fos = new FileOutputStream(output + filesGathered.get(i).getName().substring(0, eliminateFileExtenz) + ".html");
                StreamResult htmlStreamSourceObject = new StreamResult(fos);
                //Transform & results
                Transformer transformer = tFactory.newTransformer(xslStreamSourceObject);
                transformer.setOutputProperty(OutputKeys.METHOD, "xml");
                transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");

                transformer.transform(xmlStreamSourceObject, htmlStreamSourceObject);
            } catch (Exception e) {
                System.out.println("Error in convertDirectory2Html method: " + e);
            }

        }

        //Remove all files from list
        clearFileList();

    }

    /**
     * Recursively get all files in any given directory that is of the 'type'
     * the user specified.
     *
     * @param directoryName
     * @param filesGathered
     * @param type
     */
    private void generateAllFilesInDirectory(String directoryName, ArrayList<File> filesGathered, String type) {

        try {
            File directory = new File(directoryName);

            // get all the files from a directory
            File[] fList = directory.listFiles();

            for (File file : fList) {
                if (file.isFile()) {

                    //get only 'ABET' or 'outcomes'
                    if (file.getName().contains(type)) {
                        System.out.println("here");
                        filesGathered.add(file);
                        //get only courses
                    } else if ("course".equals(type) && file.getName().length() == 13) {
                        filesGathered.add(file);
                    }

                } else if (file.isDirectory()) {
                    //Recursively call in for any sub directories
                    generateAllFilesInDirectory(file.getAbsolutePath(), filesGathered, type);
                }

            }
        } catch (NullPointerException e) {
            System.out.print("Error in generateAllFilesInDirectory method " + e);
        }
    }

    /**
     * Given a list, this method will combine all the files in said list and
     * output them into the given location with the output param.
     *
     * @param files
     * @param jointXMLRootNode
     * @param output
     */
    public void mergeXMLThenConvert2HTML(List<File> files, String jointXMLRootNode, String xslFile, String output) {
        File in;

        //String xmlFileName;
        try {
            DocumentBuilderFactory dbFactory;
            DocumentBuilder dBuilder;

            Document mergedDoc;

            FileOutputStream fos = new FileOutputStream(output);
            StreamResult xmlStreamSourceObject = new StreamResult(fos);

            dbFactory = DocumentBuilderFactory.newInstance();
            dBuilder = dbFactory.newDocumentBuilder();

            mergedDoc = dBuilder.newDocument();
            Element mainRootElement = mergedDoc.createElement(jointXMLRootNode); // doc.createElementNS();
            mergedDoc.appendChild(mainRootElement);

            //Get Top Level Node
            for (File inFile : files) {
                in = new File(inFile.getAbsolutePath());
                Document current_doc1 = dBuilder.parse(in);
                Node n = mergedDoc.importNode(current_doc1.getFirstChild(), true);
                mainRootElement.appendChild(n);
            }

            // Output DOM XML to xml file 
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
            transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "5");

            DOMSource source = new DOMSource(mergedDoc);
            transformer.transform(source, xmlStreamSourceObject);

            System.out.println("The Merged xml is:" + output);

        } catch (Exception e) {
            System.out.println("This error is in the mergeFiles method" + e);
        }

    }

    /**
     * Merge all course files in a directory and output an HTML from all the
     * files.
     *
     * @param directoryName
     * @param jointXMLRootNode
     * @param xslFile
     * @param output
     */
    public void mergeFilesFromDirectory2HTML(String directoryName, String jointXMLRootNode, String xslFile, String output) {

        //Get all files and put them into a arraylist
        generateAllFilesInDirectory(directoryName, filesGathered, "course");

        File in;
        File del; 

        //String xmlFileName;
        try {
            DocumentBuilderFactory dbFactory;
            DocumentBuilder dBuilder;

            Document mergedDoc;

            FileOutputStream fos = new FileOutputStream(output);
            StreamResult xmlStreamSourceObject = new StreamResult(fos);

            dbFactory = DocumentBuilderFactory.newInstance();
            dBuilder = dbFactory.newDocumentBuilder();

            mergedDoc = dBuilder.newDocument();
            Element mainRootElement = mergedDoc.createElement(jointXMLRootNode); // doc.createElementNS();
            mergedDoc.appendChild(mainRootElement);

            //Get Top Level Node
            for (File inFile : filesGathered) {
                in = new File(inFile.getAbsolutePath());
                Document current_doc1 = dBuilder.parse(in);
                Node n = mergedDoc.importNode(current_doc1.getFirstChild(), true);
                mainRootElement.appendChild(n);
            }

            // Output DOM XML to xml file 
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
            transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "5");

            DOMSource source = new DOMSource(mergedDoc);
            transformer.transform(source, xmlStreamSourceObject);

            System.out.println("The Merged xml is:  " + output);
            
            try {
                
                convert2Html(output, xslFile, output + ".html");
                del = new File(output + ".html"); 
                del.delete();
                
            } catch (Exception e) {

            }
            

        } catch (Exception e) {
            System.out.println("This error is in the mergeFiles method" + e);
        }

        //clean list
        clearFileList();

    }

    /**
     * Clears list after it is used. Avoids memory leaks and an overly large
     * list from being made and continually added to.
     */
    private void clearFileList() {
        filesGathered.clear();
    }

}
