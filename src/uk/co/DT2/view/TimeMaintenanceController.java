/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.co.DT2.view;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import uk.co.DT2.model.TimeItem;

/**
 *
 * @author Mike
 */
public class TimeMaintenanceController {
    
    @FXML
    private TextField jobCodeField;
    
    @FXML
    private TextField descriptionField;
    
    @FXML
    private TextField timeSpentField;
    
    private Stage maintenanceStage;
    private TimeItem timeItem;
    private boolean OKClicked;
    
    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
    }

    /**
     * Sets the stage of this dialog.
     * 
     * @param maintenanceStage
     */
    public void setMaintenanceStage(Stage maintenanceStage) {
        this.maintenanceStage = maintenanceStage;
    }
    
    /**
     * Loads in TimeItem to maintain
     */
    
    public void setTimeItem(TimeItem timeItem){
        this.timeItem = timeItem;
        jobCodeField.setText(timeItem.getJobCode().toString());
        descriptionField.setText(timeItem.getDescription().toString());
        timeSpentField.setText(timeItem.getTimeSpentMins().toString());
                
    }
}
