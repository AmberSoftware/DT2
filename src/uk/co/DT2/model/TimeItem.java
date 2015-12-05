/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.co.DT2.model;

import java.time.LocalDate;
import java.util.Date;
import javafx.beans.Observable;
import javafx.beans.property.*;
import javafx.beans.value.ObservableValue;
//import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author Mike
 */
public class TimeItem {
    private final IntegerProperty jobCode = new SimpleIntegerProperty();
    private final StringProperty description = new SimpleStringProperty();
    private final IntegerProperty timeSpent = new SimpleIntegerProperty();
    private final BooleanProperty active = new SimpleBooleanProperty();
    private long timeActivated ;
    
    /**
     * default constructor to create blank item
     */

    public TimeItem(){
        
        this(0,"",0);
    }
    
    /**
     * constructor allowing job code, description and time
     */
    public TimeItem(int jobCode, String description, int timeSpent){
        
        //this.jobCode = new SimpleIntegerProperty();
        setJobCode(jobCode);
        setDescription(description);
        setTimeSpent(timeSpent);
        setActive(false);
        timeActivated = 0;
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
    public ObservableValue getJobCodeProp() {
        return jobCode;
    }
    
    /**
     * @return the jobCode
     */
    //public ObservableValue<Integer> getJobCodeObVal() {
    //    
    //    ObservableValue<Integer> jobCodeObVal;
    //    jobCodeObVal.
    //    return jobCodeObVal;
    //}
    
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

    public String getDescriptionStr() {
        return description.get();
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
    
    public ObservableValue getTimeSpentProp(){
        return timeSpent;
    }

    /**
     * @return the timeSpent in mins
     */
    public IntegerProperty getTimeSpentMins() {
        return new SimpleIntegerProperty(timeSpent.intValue()/60);
    }
    
    public Integer getTimeSpentMinsInt() {
        return timeSpent.intValue()/60;
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

    public void setTimeSpentMins(int timeSpent) {
        this.timeSpent.set(timeSpent*60);
    }
    
    public StringProperty getTimeSpentStr(){
        StringProperty returnTime = new SimpleStringProperty();
        
        int hours = timeSpent.get()/3600;
        String hourStr;
        if (hours<10) hourStr = "0"+hours;
        else hourStr=Integer.toString(hours);
        
        int mins = (timeSpent.get()-(hours*3600))/60;
        String minStr;
        if (mins<10) minStr = "0"+mins;
        else minStr=Integer.toString(mins);
        
        int secs = timeSpent.get()-(hours*3600)-(mins*60);
        String secStr;
        if (secs<10) secStr = "0"+secs;
        else secStr=Integer.toString(secs);
        
        returnTime.set(hourStr+":"+minStr+":"+secStr);
        return returnTime;
    }

    /**
     * @return the active
     */
    public BooleanProperty getActive() {
        return active;
    }
    
    /**
     * @return the active
     */
    public boolean isActive() {
        return active.get();
    }
    
    /**
     * @param active the active to set
     */
    private void setActive(boolean active) {
        this.active.set(active);
    }

    /**
     * @return the timeActivated
     */
    public long getTimeActivated() {
        return timeActivated;
    }

    /**
     * @param timeActivated the timeActivated to set
     */
    public void setTimeActivated(long timeActivated) {
        this.timeActivated = timeActivated;
    }
    
    /**
     * deactivate and save time spent
     */
    public void deactivate(){
        if(active.get()){
            setActive(false);
            Date now = new Date();
            timeSpent.set(timeSpent.get() + (int) ((now.getTime() - timeActivated) / 1000));
        }
    }
    
    /**
     * activate and set start time
     */
    public void activate(){
        if(!active.get()){
            setActive(true);
            Date now = new Date();
            timeActivated = now.getTime();
        }
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

// class ReturnVal implements ObservableValue{
//     public ObservableValue<Integer> getValue(){
//         
//     }
        
//    }