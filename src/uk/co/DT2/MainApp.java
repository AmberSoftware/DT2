/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.co.DT2;

import java.io.IOException;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import uk.co.DT2.model.TimeItem;
import uk.co.DT2.view.RootLayoutController;
import uk.co.DT2.view.TimeOverviewController;

/**
 *
 * @author Mike
 */
public class MainApp extends Application {
    
    private Stage primaryStage;
    private BorderPane rootLayout;
    
    // list of time items to maintain
    private ObservableList<TimeItem> timeItemData = FXCollections.observableArrayList();
    
    public MainApp(){
        // Test data
        timeItemData.add(new TimeItem(242654, "Emails/admin",0));
        timeItemData.add(new TimeItem(242654, "Emails/admin2",60));
        timeItemData.add(new TimeItem(123456, "Training",360));
        timeItemData.add(new TimeItem(232445, "Design Work",180));
    }
    
    /**
     * Returns the data as an observable list of Persons. 
     * @return
     */
    public ObservableList<TimeItem> getTimeItemData() {
        return timeItemData;
    }
    
    
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("DT2- Time Entry");
        
        // intialise
        initRootLayout();
        
        // Display Time Item overview
        showTimeItemOverview();
    }
    
    private void initRootLayout(){
        
        try{
            // create new FXML loader and use FXML file to create contents
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));

            // load MainApp's rootLayout member
            this.rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);

            // create controller for the rootLayout and 
            // give it access to the MainApp
            RootLayoutController controller = loader.getController();
            controller.setMainApp(this);
            
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
    }
    
    private void showTimeItemOverview(){
        try{
            // create new FXML loader and use FXML file to create contents
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/TimeOverview.fxml"));

            // create object reference for overview
            AnchorPane timeOverview = (AnchorPane) loader.load();

            // Show time overview in centre of root layout
            rootLayout.setCenter(timeOverview);

            // create controller for the rootLayout and 
            // give it access to the MainApp
            TimeOverviewController controller = loader.getController();
            controller.setMainApp(this);
            
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
        
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
