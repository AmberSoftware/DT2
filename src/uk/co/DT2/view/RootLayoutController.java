/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.co.DT2.view;

import java.io.File;
import javafx.collections.ObservableList;
import uk.co.DT2.MainApp;
import javafx.fxml.FXML;
import javafx.stage.FileChooser;
import uk.co.DT2.model.TimeItem;
import uk.co.DT2.util.FileUtil;

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
    
        /**
     * Opens a FileChooser to let the user select a file to save to.
     */
    @FXML
    private void handleSaveAs() {
        FileChooser fileChooser = new FileChooser();

        // Set extension filter
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
                "XML files (*.xml)", "*.xml");
        fileChooser.getExtensionFilters().add(extFilter);

        // Show save file dialog
        File file = fileChooser.showSaveDialog(mainApp.getPrimaryStage());

        if (file != null) {
            // Make sure it has the correct extension
            if (!file.getPath().endsWith(".xml")) {
                file = new File(file.getPath() + ".xml");
            }
            //ObservableList<TimeItem> til = mainApp.getTimeItemData();// for debugging
            FileUtil.saveTimeItemDataToFile(file, mainApp.getTimeItemData());
        }
    }
}
