/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.co.DT2.view;

import uk.co.DT2.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import uk.co.DT2.model.TimeItem;

/**
 *
 * @author Mike
 */
public class TimeOverviewController {
    
    @FXML
    private TableView<TimeItem> timeItemTable;
    
    @FXML
    private TableColumn<TimeItem, Integer> jobCodeColumn;
    //private TableColumn<TimeItem, String> jobCodeColumn;
    
    @FXML
    private TableColumn<TimeItem, String> descriptionColumn;
    
    @FXML
    //private TableColumn<TimeItem, String> timeSpentColumn;
    private TableColumn<TimeItem, Integer> timeSpentColumn;
    
    @FXML
    private TableColumn<TimeItem, Boolean> activeColumn;
    //private TableColumn<TimeItem, RadioButton> activeColumn;
    
    private MainApp mainApp;
    
    // constructor
    public TimeOverviewController(){}
    
    // initialisation- appears to run automatically
    
    @FXML
    private void initialize(){
        
        // load column data
        //jobCodeColumn.setCellValueFactory(cellData -> cellData.getValue().getJobCodeStrProperty());
        jobCodeColumn.setCellValueFactory(cellData -> cellData.getValue().getJobCodeProp());
        descriptionColumn.setCellValueFactory(cellData -> cellData.getValue().getDescription());
        timeSpentColumn.setCellValueFactory(cellData -> cellData.getValue().getTimeSpentProp());
        activeColumn.setCellValueFactory(cellData -> cellData.getValue().getActive());
    
    }
    
    /* public method called from main app to pass reference of itself to controller
    * @param mainApp
    */
    
    public void setMainApp(MainApp mainApp){
        this.mainApp=mainApp;
        // Add observable list data to the table
        timeItemTable.setItems(mainApp.getTimeItemData());
    }
    
    @FXML
    private void handleExit(){
        System.exit(0);
    }
    
    
    /**
    * Called when the user clicks the edit button. Opens a dialog to edit
    * details for the selected person.
    */
    @FXML
    private void handleEdit() {
        TimeItem selectedTimeItem = timeItemTable.getSelectionModel().getSelectedItem();
        if (selectedTimeItem != null) {
            boolean okClicked = mainApp.showTimeMaintenance(selectedTimeItem);
        } else {
            // Nothing selected.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Person Selected");
            alert.setContentText("Please select a person in the table.");

            alert.showAndWait();
        }
    }

}
