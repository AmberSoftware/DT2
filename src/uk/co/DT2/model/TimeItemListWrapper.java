/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.co.DT2.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Helper class to wrap a list of persons. This is used for saving the
 * list of persons to XML.
 * 
 * @author Mike Dodd
 */
@XmlRootElement(name = "timeItems")
public class TimeItemListWrapper {

    private List<TimeItem> timeItems;

    @XmlElement(name = "timeItem")
    public List<TimeItem> getTimeItems() {
        return timeItems;
    }

    public void setTimeItems(List<TimeItem> timeItems) {
        this.timeItems = timeItems;
    }
}
