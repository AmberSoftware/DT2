/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.co.DT2.model;

import java.util.*;

/**
 *
 * @author Mike
 */
public class TimeItem_UnitTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<TimeItem> TIs = new ArrayList<>();
        int jobno = 242654;
        TIs.add(new TimeItem(jobno, "Emails/admin",0));
        TIs.add(new TimeItem(242654, "Emails/admin2",60));
        TIs.add(new TimeItem(123456, "Training",360));
        
        TIs.get(0).setActive(true);
        TIs.get(0).setTimeSpent(180);
        TIs.get(0).setDescription("Updated description");
        
        for(TimeItem ti:TIs){
            System.out.println(ti.toString());
        }
        
        //todo: TIs.get(0).setTimeActive(true);
        
    }
    
}
