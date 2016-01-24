/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.co.DT2.view;

import javafx.collections.ObservableList;
import uk.co.DT2.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
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
    private TableColumn<TimeItem, String> timeSpentColumn;
    //private TableColumn<TimeItem, Integer> timeSpentColumn;
    
    @FXML
    private TableColumn<TimeItem, Boolean> activeColumn;
    //private TableColumn<TimeItem, RadioButton> activeColumn;
    
    @FXML
    private Label activeLabel;
    
    @FXML
    private Button pauseResumeButton;
    
    private MainApp mainApp;
    
    private TimeItem lastActiveItem;
    
    private boolean active;
    
    // constructor
    public TimeOverviewController(){}
    
    // initialisation- appears to run automatically
    
    @FXML
    private void initialize(){
        
        // load column data
        jobCodeColumn.setCellValueFactory(cellData -> cellData.getValue().getJobCodeProp());
        descriptionColumn.setCellValueFactory(cellData -> cellData.getValue().getDescription());
        timeSpentColumn.setCellValueFactory(cellData -> cellData.getValue().getTimeSpentStr());
        activeColumn.setCellValueFactory(cellData -> cellData.getValue().getActive());
        
        // listen for mouse clicks on table
        timeItemTable.setRowFactory( tv -> {
            TableRow<TimeItem> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                // right-click to activate an item
                if (event.getButton() == MouseButton.SECONDARY && (! row.isEmpty()) ) 
                    handleActivate();
                // double click to edit an item
                else if (event.getClickCount() == 2 && (! row.isEmpty()) ) 
                    handleEdit();
                
                
            });
            return row ;
        });
        
        activeLabel.setText("Not active");
        active=false;
    
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
    
    /**
    * Called when the user clicks the table. Opens a dialog to edit
    * details for the selected person.
    */
    @FXML
    private void handleRowClicked() {
     }    
    /**
    * Called when the user clicks the add button. Opens a dialog to edit
    * details for the selected person.
    */
    @FXML
    private void handleAdd() {
        TimeItem timeItem = new TimeItem();
        boolean okClicked = mainApp.showTimeMaintenance(timeItem);
        
        // if new item confirmed then add to table
        if (okClicked){
            timeItemTable.getItems().add(timeItem);
        }
    }
    
    /**
    * Called when the user clicks the pause/resume button.
    */
    @FXML
    private void handlePauseResume() {
        if(active){
            handlePause();
        } else {
            handleResume();
        }   
    }
    
    /**
    * Called when the user clicks the activate button.
    */
    @FXML
    private void handleActivate() {
        // if selected item is not already active, pause currently active item
        // and activate selected item
        if(!timeItemTable.getSelectionModel().getSelectedItem().isActive()){
            handlePause();
            timeItemTable.getSelectionModel().getSelectedItem().activate();
            lastActiveItem=timeItemTable.getSelectionModel().getSelectedItem();
            showActive();
        }    
    }
    
    /**
    * Called when the user clicks the pause button.
    */
    private void handlePause() {
        // the getItems method returns an observable list of the TimeItems
        // which are in the tableview, so this can be iterated through
        
        for(TimeItem ti:timeItemTable.getItems()){
            // if active, deactivate and save
            if(ti.isActive()){
                lastActiveItem=ti;
                ti.deactivate();
            }
            
        }
        showPause();
    }
    
    /**
    * Called when the user clicks the resume button
    */
    private void handleResume() {
        // Reactivate previous item
        if(lastActiveItem!=null){
            lastActiveItem.activate();
        } else {
            for(TimeItem ti:timeItemTable.getItems()){
                ti.activate();
                lastActiveItem=ti;
                break;
            }
            
        }
        showActive();
    }
    
    @FXML
    private void handleDelete(){
        int selectedIndex = timeItemTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            // if selected item is active, then need to set screen to inactive
            if(timeItemTable.getSelectionModel().getSelectedItem().isActive()){
                showPause();
                lastActiveItem=null;
            }
            // remove
            timeItemTable.getItems().remove(selectedIndex);
        } else {
            // Nothing selected.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Item Selected");
            alert.setContentText("Please select an item in the table.");

            alert.showAndWait();
        }
    }
    
    @FXML
    private void handleSave(){
        int selectedIndex = timeItemTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            // if selected item is active, then need to set screen to inactive
            if(timeItemTable.getSelectionModel().getSelectedItem().isActive()){
                showPause();
                lastActiveItem=null;
            }
            // remove
            timeItemTable.getItems().remove(selectedIndex);
        } else {
            // Nothing selected.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Item Selected");
            alert.setContentText("Please select an item in the table.");

            alert.showAndWait();
        }
    }
    
    /**
     * set display to active mode
     */
    private void showActive(){
        active=true;
        activeLabel.setText("Active");
        pauseResumeButton.setText("Pause");
    }
    
    /**
     * set display to pause mode
     */
    private void showPause(){
        active=false;
        activeLabel.setText("Not active");
        pauseResumeButton.setText("Resume");
    }

}
