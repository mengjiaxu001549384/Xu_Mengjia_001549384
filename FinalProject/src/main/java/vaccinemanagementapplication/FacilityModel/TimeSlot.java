/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vaccinemanagementapplication.FacilityModel;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author apple
 */
public class TimeSlot {

    LocalDate date;
    LocalDateTime startTime;
    LocalDateTime endTime;

    public TimeSlot() {
    }

    public TimeSlot(LocalDateTime st) {
        this.date = st.toLocalDate();
        this.startTime = st;
        this.endTime = st.plusMinutes(15);
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }
    
    

}
