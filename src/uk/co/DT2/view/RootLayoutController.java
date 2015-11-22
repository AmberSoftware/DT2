/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.co.DT2.view;

import uk.co.DT2.MainApp;
import javafx.fxml.FXML;

/**
 *
 * @author Mike
 */
public class RootLayoutController {
    
    private MainApp mainApp;
    
    /* public method called from main app to pass reference to itself to controller
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
