/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testinghtml2pdf;

import java.io.File;
import java.io.FileOutputStream;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 *
 * @author MQ0162246
 */
public class XMLGenerator {

    private String xmlFileName;
    DocumentBuilderFactory icFactory = null;
    DocumentBuilder icBuilder = null;

    public XMLGenerator(String xmlFileName) {
        this.xmlFileName = xmlFileName;
    }

    public String jobXMLGenerator(ArrayList<Job> jobList) {
        //Array list not used yet...jobs hard coded
        //xml
        Document doc = null;
        try {

            FileOutputStream fos = new FileOutputStream(getXmlFileName());
            StreamResult xmlStreamSourceObject = new StreamResult(fos);

            icFactory = DocumentBuilderFactory.newInstance();
            icBuilder = icFactory.newDocumentBuilder();

            doc = icBuilder.newDocument();
            Element mainRootElement = doc.createElement("Experience"); // doc.createElementNS();
            doc.appendChild(mainRootElement);

            // Append child elements to root element
            Job job1 = new Job("Walmart", "Quweider MK", "Brownsville", "Texas", "doing nothing...", "2 years");
            mainRootElement.appendChild(getJob(doc, job1, 1));

            Job job2 = new Job("HEB", "Juan Iglesias", "Harlingen", "Texas", "doing nothing...", "5 years");
            mainRootElement.appendChild(getJob(doc, job2, 2));

            Job job3 = new Job("UTRGV", "Fitra Khan", "Toledo", "Ohio", "doing everything...", "3 years");
            mainRootElement.appendChild(getJob(doc, job3, 3));

            // Output DOM XML to xml file 
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "5");

            DOMSource source = new DOMSource(doc);
            transformer.transform(source, xmlStreamSourceObject);

            System.out.println("\nXML DOM Created Successfully..");
//            System.out.println("The xml is:");
//            System.out.println(xmlDocToString(doc, "yes"));
//
//            System.out.println("The xml is:");
//            System.out.println(xmlDocToString(doc, "no"));


        } catch (Exception e) {
            e.printStackTrace();
        }
        return xmlFileName;
    }

    public static void mergeMultipleXMLDocs(List<String> list, String jointXmlRootNode, String outName) {
        File in;

        //String xmlFileName;
        try {
            DocumentBuilderFactory dbFactory;
            DocumentBuilder dBuilder;

            Document mergedDoc;

            FileOutputStream fos = new FileOutputStream(outName);
            StreamResult xmlStreamSourceObject = new StreamResult(fos);

            dbFactory = DocumentBuilderFactory.newInstance();
            dBuilder = dbFactory.newDocumentBuilder();

            mergedDoc = dBuilder.newDocument();
            Element mainRootElement = mergedDoc.createElement(jointXmlRootNode); // doc.createElementNS();
            mergedDoc.appendChild(mainRootElement);

            //Get Top Level Node
            for (String inFile : list) {
                in = new File(inFile);
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

            System.out.println("The Merged xml is:");
            System.out.println(xmlDocToString(mergedDoc, "yes"));

        } catch (Exception e) {
        }

    }

    public static String xmlDocToString(Document doc, String omitXmlDeclaration)
            throws Exception {
        try {
            Transformer transformer = TransformerFactory.newInstance().newTransformer();

            //
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, omitXmlDeclaration);
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "5");
            transformer.setOutputProperty(OutputKeys.METHOD, "xml");
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            //
            StreamResult result = new StreamResult(new StringWriter());
            DOMSource source = new DOMSource(doc);
            transformer.transform(source, result);
            String xmlString = result.getWriter().toString();
            return xmlString;
        } catch (Exception e) {
            e.printStackTrace();

            throw e;
        }
    }

    public Node getJob(Document doc, Job jobObject, int id) {
        Element job = doc.createElement("Job");
        // Top level attributes
        job.setAttribute("id", Integer.toString(id));

        // Job subelements
        job.appendChild(getJobElements(doc, job, "employer", jobObject.getEmployer()));
        job.appendChild(getJobElements(doc, job, "supervisor", jobObject.getSupervisor()));
        job.appendChild(getJobElements(doc, job, "city", jobObject.getCity()));
        job.appendChild(getJobElements(doc, job, "state", jobObject.getState()));
        job.appendChild(getJobElements(doc, job, "description", jobObject.getDescription()));
        job.appendChild(getJobElements(doc, job, "years", jobObject.getYears()));
        return job;
    }

    // utility method to create text node
    public Node getJobElements(Document doc, Element element, String name, String value) {
        Element node = doc.createElement(name);
        node.appendChild(doc.createTextNode(value));
        return node;
    }

    /**
     * @return the xmlFileName
     */
    public String getXmlFileName() {
        return xmlFileName;
    }

    /**
     * @param xmlFileName the xmlFileName to set
     */
    public void setXmlFileName(String xmlFileName) {
        this.xmlFileName = xmlFileName;
    }
}
