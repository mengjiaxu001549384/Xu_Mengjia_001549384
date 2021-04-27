/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vaccinemanagementapplication.patient;

import java.time.LocalDate;
import vaccinemanagementapplication.FacilityModel.Facility;
import vaccinemanagementapplication.FacilityModel.TimeSlot;
import vaccinemanagementapplication.FacilityModel.VaccineDoseAssignment;
import vaccinemanagementapplication.vaccine.Vaccine;

/**
 *
 * @author apple
 */
public class Appointment {
    String appointmentID;
    boolean isMissed;
    boolean isEligible;
    public enum Type {firstDose, secondDose;}
    public Type type;
    PatientProfile patient;
    Facility facility;
    Vaccine vaccine;
    TimeSlot timeSlot;
    PhaseTime phaseTime;
    VaccineDoseAssignment vaccineDoseAssignment;

    public Appointment(String appointmentID, Type type, PatientProfile patient, TimeSlot timeSlot, Vaccine vaccine, Facility facility) {
        this.appointmentID = appointmentID;
        this.type = type;
        this.patient = patient;
        this.facility = facility;
        this.timeSlot = timeSlot;
        this.vaccine = vaccine;
        this.isEligible = false;
    }

    public void setVaccineDoseAssignment(VaccineDoseAssignment vda) {
        this.vaccineDoseAssignment = vda;
    }
    
    
    
    
    public boolean isIsMissed() {
        return isMissed;
    }

    public LocalDate getDate(){
        return this.timeSlot.getDate();
    }

    public int getTimeBetweenDose() {
        return vaccine.getTimeBetweenDose();
    }

    public int getEffectiveDuration() {
        return vaccine.getEffectiveDuration();
    }
    
    public int getEffectiveAfterLastDose(){
        return vaccine.getEffectiveAfterLastDose();
    }
    
    public Vaccine getVaccine(){
        return this.vaccine;
    }
    
    public Facility getFacility(){
        return this.facility;
    }
    
    public void assignToAppointment(VaccineDoseAssignment vda){
        vda.assignToAppointment(this);
    }

}
