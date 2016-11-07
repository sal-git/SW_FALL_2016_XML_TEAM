/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team_2;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 *
 * @author Germex
 */
public class StephenProtoypeDriver extends Application {

    private Scene scene;
    XMLGenerator gen = new XMLGenerator(null);
    public int count = 0;
    Button back = new Button("BACK");
    Button forward = new Button("FORWARD");
    BorderPane mainPane = new BorderPane();
    File[] listOfFiles;
    HBox controls = new HBox(10);
    MyBrowser myBrowser;
    URL urlHello;

    ArrayList<File> xmlCourses = new ArrayList<>();

    //"C:/Users/Germex/Documents/NetBeansProjects/Team_2/XML/csci-3340.xml";
    String xmlFile;
    String xslFile = "C:/Users/Germex/Documents/NetBeansProjects/Team_2/XSL/courseXsl.xsl";
    String htmlFile = "C:/Users/Germex/Documents/NetBeansProjects/Team_2/output/output.html";

    @Override
    public void start(Stage primaryStage) throws MalformedURLException {

        configureDisplay();

        configureListeners();

        generateFiles();

        scene = new Scene(mainPane, 800, 650);

        primaryStage.setScene(scene);
        primaryStage.show();

        primaryStage.setTitle("Prototype XML2HTML");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Listeners for buttons.
     */
    private void configureListeners() {

        /**
         * Forward click. Count increases to go to next XML file and merges said
         * file.
         */
        forward.setOnAction((ActionEvent event) -> {
            count++;
            XML2HTML xml2htmlObject = new XML2HTML(listOfFiles[count].getAbsolutePath(), xslFile, htmlFile);
            xml2htmlObject.convert2Html(xml2htmlObject.getXmlFileName(), xml2htmlObject.getXslFileName(), xml2htmlObject.getHtmlFileName());
            try {
                configureDisplay();
            } catch (MalformedURLException ex) {
                Logger.getLogger(StephenProtoypeDriver.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        /**
         * Back button click, Count decreases in array to go to said XML file
         * and converts it again to output.htm
         */
        back.setOnAction((ActionEvent event) -> {
            count--;
            XML2HTML xml2htmlObject = new XML2HTML(listOfFiles[count].getAbsolutePath(), xslFile, htmlFile);
            xml2htmlObject.convert2Html(xml2htmlObject.getXmlFileName(), xml2htmlObject.getXslFileName(), xml2htmlObject.getHtmlFileName());
            try {
                configureDisplay();
            } catch (MalformedURLException ex) {
                Logger.getLogger(StephenProtoypeDriver.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    /**
     * Configure display. Main pane and buttons.
     */
    private void configureDisplay() throws MalformedURLException {
        controls.getChildren().removeAll(back, forward);
        myBrowser = new MyBrowser();
        mainPane.setCenter(myBrowser);
        controls.setAlignment(Pos.CENTER);
        controls.getChildren().addAll(back, forward);
        mainPane.setBottom(controls);
    }

    private void generateFiles() {
        File folder = new File("C:/Users/Germex/Documents/NetBeansProjects/Team_2/XML/");
        listOfFiles = folder.listFiles();

        for (File listOfFile : listOfFiles) {
            if (listOfFile.isFile()) {
                System.out.println("File " + listOfFile.getName());
            }
        }
        try {
            configureDisplay();
        } catch (MalformedURLException ex) {
            Logger.getLogger(StephenProtoypeDriver.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

/**
 * Create own browser to display .html document.
 *
 * @author Germex
 */
class MyBrowser extends Region {

    final String hellohtml = "output.htm";

    WebView webView = new WebView();
    WebEngine webEngine = webView.getEngine();

    public MyBrowser() throws MalformedURLException {

        String path = "C:/Users/Germex/Documents/NetBeansProjects/Team_2/output/output.html";
        URL url = new URL("file:///" + path);
<<<<<<< HEAD
=======
        //System.out.println(urlHello.getPath());
>>>>>>> origin/master
        webEngine.load(url.toExternalForm());

        getChildren().add(webView);
    }
}
