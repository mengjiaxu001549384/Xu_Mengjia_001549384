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
public class Encounter {
    Appointment appointment;
    VaccineDoseAssignment vaccineDoseAssignment;
    public enum SideEffect {pain,redness,swelling,tiredness,headache,musclepain,chills,fever,nausea;}
    public SideEffect sideEffect;
    Facility facility;
    Vaccine vaccine;
    TimeSlot timeSlot;
    public enum Type {firstDose, secondDose;}
    public Type type;

    public Encounter(Appointment appointment) {
        this.appointment = appointment;
        this.facility = appointment.getFacility();
        this.timeSlot = appointment.timeSlot;
        this.vaccine = appointment.getVaccine();
        this.type = Type.valueOf(appointment.type.toString());
        this.vaccineDoseAssignment = appointment.vaccineDoseAssignment;
    }

    
    
    
    public SideEffect getSideEffect() {
        return sideEffect;
    }
    
    public void setSideEffect(SideEffect sideEffect) {
        this.sideEffect = sideEffect;
    }
    
    public void getShot(){
        this.vaccineDoseAssignment.getVaccineDose().setIsUsed(true);
        this.facility.addToEncounterRecord(this);
    }

    public VaccineDoseAssignment getVaccineDoseAssignment() {
        return vaccineDoseAssignment;
    }
    
    public boolean getMedicalScreen(){
        //doctor do the medicalscreen for patient
        return true;
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
}
