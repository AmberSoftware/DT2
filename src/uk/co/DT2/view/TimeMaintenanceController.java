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
        descriptionField.setText(timeItem.getDescriptionStr());
        timeSpentField.setText(timeItem.getTimeSpentMinsInt().toString());
                
    }
    
    /**
     * Returns OKClicked
     */
    public boolean isOKClicked(){
        return OKClicked;
    }
    /**
     * Called when the user clicks ok.
     */
    @FXML
    private void handleOK() {
        if (isInputValid()) {
            String jobst = jobCodeField.getText();
            int jobint=0;
            jobint = Integer.getInteger(jobst);
            
            timeItem.setJobCode(Integer.getInteger(jobCodeField.toString()));
            timeItem.setDescription(descriptionField.toString());
            timeItem.setTimeSpentMins(Integer.getInteger(timeSpentField.toString()));

            OKClicked = true;
            maintenanceStage.close();
        }
    }

    /**
     * Called when the user clicks ok.
     */
    @FXML
    private void handleCancel() {
        OKClicked = false;
        maintenanceStage.close();
    }
    
    /**
     * Validate user input
     */
    
    private boolean isInputValid(){
        //TODO
        return true;
    }
}
