/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.co.DT2.view;

import dt2.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import uk.co.DT2.model.TimeItem;

/**
 *
 * @author Mike
 */
public class TimeOverviewController {
    
    @FXML
    private TableView<TimeItem> timeItemTable;
    
    @FXML
    private TableColumn<TimeItem, String> jobCodeColumn;
    
    //private TableColumn<TimeItem, Integer> jobCodeColumn;
    
    @FXML
    private TableColumn<TimeItem, String> descriptionColumn;
    
    @FXML
    private TableColumn<TimeItem, String> timeSpentColumn;
    //private TableColumn<TimeItem, Integer> timeSpentColumn;
    
    @FXML
    private TableColumn<TimeItem, Boolean> activeColumn;
    
    private MainApp mainApp;
    
    // constructor
    public TimeOverviewController(){}
    
    // initialisation- appears to run automatically
    
    @FXML
    private void initialize(){
        // load column data
        jobCodeColumn.setCellValueFactory(cellData -> cellData.getValue().getJobCodeStrProperty());
        descriptionColumn.setCellValueFactory(cellData -> cellData.getValue().getDescription());
        timeSpentColumn.setCellValueFactory(cellData -> cellData.getValue().getTimeSpentStrProperty());
        activeColumn.setCellValueFactory(cellData -> cellData.getValue().getActive());
    
    }
    
    /* public method called from main app to pass reference of itself to controller
    * @param mainApp
    */
    
    public void setMainApp(MainApp mainApp){
        this.mainApp=mainApp;
    }
    
    @FXML
    private void handleExit(){
        System.exit(0);
    }
    
}
