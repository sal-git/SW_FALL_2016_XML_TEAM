/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package posprototypedriver;

import java.io.File;
import static java.lang.System.out;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
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
public class POSPrototypeDriver extends Application {

    List<String> listOfFiles = new ArrayList<>();
    HBox hbox = new HBox(10);
    Button btn = new Button();
    Button merge = new Button();
    MyBrowser myBrowser;
    MyBrowser myBrowser2;
    BorderPane root = new BorderPane();

    @Override
    public void start(Stage primaryStage) throws MalformedURLException {

        configureControls();

        configureWebView();

//        hbox.getChildren().addAll(btn, merge);
        root.setPadding(new Insets(30, 15, 30, 15));
        root.setCenter(hbox);

        Scene scene = new Scene(root, 300, 80);

        primaryStage.setTitle("Merger");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    public void merge() {
        Merge.mergeMultipleXMLDocs(listOfFiles, "POS", "POS1.xml");

        XML2HTML xml2htmlObject = new XML2HTML("POS1.xml", "franPOS.xsl", "output.html");
        xml2htmlObject.convert2Html(xml2htmlObject.getXmlFileName(), xml2htmlObject.getXslFileName(), xml2htmlObject.getHtmlFileName());
    }

    public void generateFiles() {
        File folder = new File("C:/Users/Germex/Documents/NetBeansProjects/POSPrototypeDriver/CoursesXML/");
        listOfFiles = new ArrayList<String>(Arrays.asList(folder.list()));

        for (int i = 0; i < listOfFiles.size(); i++) {
            listOfFiles.set(i, "CoursesXML/" + listOfFiles.get(i));
            out.println(listOfFiles.get(i));
        }
    }

    private void configureControls() {

        btn.setText("Get Files");
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                generateFiles();

            }
        });

        merge.setText("Merge them");
        merge.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                merge();
            }
        });

        
        hbox.getChildren().addAll(btn, merge);
    }

    private void configureWebView() throws MalformedURLException {
        myBrowser = new MyBrowser("C:/Users/Germex/Documents/NetBeansProjects/POSPrototypeDriver/output.html");
        
//        myBrowser = new MyBrowser();
        root.setRight(myBrowser);
        root.setLeft(myBrowser2);

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

    public MyBrowser(String path) throws MalformedURLException {
//        String path = "C:/Users/Germex/Documents/NetBeansProjects/POSPrototypeDriver/output.html";
        URL url = new URL("file:///" + path);
        webEngine.load(url.toExternalForm());
        getChildren().add(webView);

        
    }

}
