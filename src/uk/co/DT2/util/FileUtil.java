/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.co.DT2.util;

import java.io.File;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import uk.co.DT2.model.TimeItem;
import uk.co.DT2.model.TimeItemListWrapper;

/**
 *
 * @author Mike
 */
public final class FileUtil {
    public static void loadTimeItemDataFromFile(File file) {
        try {
        JAXBContext context = JAXBContext
                .newInstance(TimeItemListWrapper.class);
        Unmarshaller um = context.createUnmarshaller();

        // Reading XML from the file and unmarshalling.
        TimeItemListWrapper wrapper = (TimeItemListWrapper) um.unmarshal(file);

        //timeItemData.clear();
        ObservableList<TimeItem> timeItemData = FXCollections.observableArrayList();

        timeItemData.addAll(wrapper.getTimeItems());

        // Save the file path to the registry.
        // add back in later: setTimeItemFilePath(file);

    } catch (Exception e) { // catches ANY exception
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Could not load data");
        alert.setContentText("Could not load data from file:\n" + file.getPath());

        alert.showAndWait();
    }
}

/**
 * Saves the current person data to the specified file.
 * 
 * @param file
 */
public static void saveTimeItemDataToFile(File file, ObservableList<TimeItem> timeItemData) {
    try {
        JAXBContext context = JAXBContext
                .newInstance(TimeItemListWrapper.class);
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        // Wrapping our person data.
        TimeItemListWrapper wrapper = new TimeItemListWrapper();
        //ObservableList<TimeItem> timeItemData = FXCollections.observableArrayList();

        wrapper.setTimeItems(timeItemData);

        // Marshalling and saving XML to the file.
        m.marshal(wrapper, file);

        // Save the file path to the registry.
        // add back in later: setTimeItemFilePath(file);
    } catch (Exception e) { // catches ANY exception
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Could not save data");
        alert.setContentText("Could not save data to file:\n" + file.getPath());

        alert.showAndWait();
    }
}    
}
