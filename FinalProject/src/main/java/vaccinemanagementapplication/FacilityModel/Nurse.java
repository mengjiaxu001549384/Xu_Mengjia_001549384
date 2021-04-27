/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vaccinemanagementapplication.FacilityModel;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author apple
 */
public class Nurse {
    String Name;
    String staffID;
    Facility facility;
    List<TimeSlot> nurseSchedule;
    
    public Nurse(String Name, String staffID, Facility facility) {
        this.Name = Name;
        this.staffID = staffID;
        this.facility = facility;
        this.nurseSchedule = new ArrayList();
    }

    public Nurse(String Name, String staffID, Facility facility, List<TimeSlot> nurseSchedule) {
        this.Name = Name;
        this.staffID = staffID;
        this.facility = facility;
        this.nurseSchedule = nurseSchedule;
    }

    public TimeSlot newTimeSlot(LocalDateTime st){
        TimeSlot ts = new TimeSlot(st);
        nurseSchedule.add(ts);
        return ts;
    }
    
    public List<TimeSlot> getSchedules(){
        return this.nurseSchedule;
    }
}
