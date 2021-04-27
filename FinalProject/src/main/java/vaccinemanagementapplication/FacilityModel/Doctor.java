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
public class Doctor {
    String Name;
    String staffID;
    Facility facility;
    List<TimeSlot> doctorSchedule;

    public Doctor(String Name, String staffID, Facility facility) {
        this.Name = Name;
        this.staffID = staffID;
        this.facility = facility;
        this.doctorSchedule = new ArrayList();
    }

    public Doctor(String Name, String staffID, Facility facility, List<TimeSlot> doctorSchedule) {
        this.Name = Name;
        this.staffID = staffID;
        this.facility = facility;
        this.doctorSchedule = doctorSchedule;
    }
    
    public TimeSlot newTimeSlot(LocalDateTime st){
        TimeSlot ts = new TimeSlot(st);
        this.doctorSchedule.add(ts);
        return ts;
    }
    
    public List<TimeSlot> getSchedules(){
        return this.doctorSchedule;
    }
    
}
