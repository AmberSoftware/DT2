/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.co.DT2.model;

import java.time.LocalDate;
import javafx.beans.property.*;
//import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author Mike
 */
public class TimeItem {
    private IntegerProperty jobCode = new SimpleIntegerProperty();
    private StringProperty description = new SimpleStringProperty();
    private IntegerProperty timeSpent = new SimpleIntegerProperty();
    private BooleanProperty active = new SimpleBooleanProperty();
    private ObjectProperty<LocalDate> timeActivated;
    

    
    public TimeItem(int jobCode, String description, int timeSpent){
        
        //this.jobCode = new SimpleIntegerProperty();
        setJobCode(jobCode);
        setDescription(description);
        setTimeSpent(timeSpent);
        setActive(false);
    }
    
    /**
     * @return the jobCode
     */
    public Integer getJobCode() {
        return jobCode.get();
    }
    
    /**
     * @return the jobCode
     */
    public IntegerProperty getJobCodeProperty() {
        return jobCode;
    }
    
    /**
     * @return the jobCode
     */
    public StringProperty getJobCodeStrProperty() {
        StringProperty returnProp = new SimpleStringProperty();
        returnProp.set(jobCode.toString()); 
        return returnProp;
    }
    
    /**
     * @param jobCode the jobCode to set
     */
    public void setJobCode(int jobCode) {
        this.jobCode.set(jobCode);
    }

    /**
     * @return the description
     */
    public StringProperty getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description.set(description);
    }

    /**
     * @return the timeSpent
     */
    public IntegerProperty getTimeSpent() {
        return timeSpent;
    }

    /**
     * @return the timeSpent in mins
     */
    public IntegerProperty getTimeSpentMins() {
        return new SimpleIntegerProperty(timeSpent.intValue()/60);
    }
    
    /**
     * @return the timeSpent
     */
    public StringProperty getTimeSpentStrProperty() {
        StringProperty returnProp = new SimpleStringProperty();
        returnProp.set(getTimeSpentMins().toString()); 
        return returnProp;
    }
    /**
     * @param timeSpent the timeSpent to set
     */
    public void setTimeSpent(int timeSpent) {
        this.timeSpent.set(timeSpent);
    }

    /**
     * @return the active
     */
    public BooleanProperty getActive() {
        return active;
    }

    /**
     * @param active the active to set
     */
    public void setActive(boolean active) {
        this.active.set(active);
    }

    /**
     * @return the timeActivated
     */
    public ObjectProperty<LocalDate> getTimeActivated() {
        return timeActivated;
    }

    /**
     * @param timeActivated the timeActivated to set
     */
    public void setTimeActivated(ObjectProperty<LocalDate> timeActivated) {
        this.timeActivated = timeActivated;
    }
    
    /**
     * @return the string description of time item
     */
    public String toString() {
        String returnStr = "Job: " + getJobCode() + ", " + getDescription() +
                ", time spent = " + getTimeSpentMins() + ", active: " +
                getActive();
        return returnStr;
    }
}