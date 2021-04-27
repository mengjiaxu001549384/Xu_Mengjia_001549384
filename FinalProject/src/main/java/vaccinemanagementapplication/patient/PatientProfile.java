/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vaccinemanagementapplication.patient;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import vaccinemanagementapplication.FacilityModel.Facility;
import vaccinemanagementapplication.FacilityModel.TimeSlot;
import vaccinemanagementapplication.vaccine.Vaccine;

/**
 *
 * @author apple
 */
public class PatientProfile {
    Person person;
    public enum Phase {I,II,III;}
    Phase phase;
    List<Allergy> allergies;
    Insurance insurance;
    List<Appointment> appointmentHistory;
    List<Encounter> encounterHistory;
    VaccineCertification vanccineCertification;
   

    public PatientProfile(Person p) {
        this.person = p;
        this.phase = getPhase(p);
        allergies = new ArrayList();
        
        encounterHistory = new ArrayList();
        appointmentHistory =new ArrayList();
    }

    public Phase getPhase(Person p) {
        
        if(p.getOccupation() == "Health care worker" 
                || p.getOccupation() == "Long term care staff"
                ||p.getOccupation() == "Home-based health care worker"){
            this.phase = Phase.I;
        }else if(p.getAge() >= 75){
            this.phase = Phase.II;
        } else{
            this.phase = Phase.III;
        }
        return phase;
    }

    public Phase getPhase() {
        return phase;
    }
    
    public void setInsurance(String companyName, String insuranceName, String ID) {
        this.insurance = new Insurance(companyName, insuranceName, ID);
    }

    public Allergy newAllergy(String name, String level){
        Allergy a = new Allergy(name, level);
        this.allergies.add(a);
        return a;
    }
    
    public boolean isEligibleNow(PhaseTime phaseTime, TimeSlot timeSlot){
        if(this.phase == Phase.I && timeSlot.getDate().isAfter(phaseTime.firstPhase)){
            return true;
        } else if(this.phase == Phase.II && timeSlot.getDate().isAfter(phaseTime.secondPhase)){
            return true;
        } else if(this.phase == Phase.III && timeSlot.getDate().isAfter(phaseTime.thirdPhase)){
            return true;
        } else {
           return false;
        }
    }
    
    public Appointment newAppointmentforFirstDose(TimeSlot timeSlot, Vaccine vaccine, Facility facility, PhaseTime phaseTime){
        System.out.println("Patient "+ this.person.firstName + " call " + facility.getName()+" to get an appointment for: " + vaccine.getName()+"- First dose" +" at "+ timeSlot.getStartTime().toString());
        
        if(facility.hasAvalibleTimeSlot(timeSlot, vaccine)){
            if(! this.isEligibleNow(phaseTime,timeSlot)){
                System.out.println("    Error: This patient is not eligible in this phase.");
                System.out.println();
                return null;
            }
            Appointment ap = facility.generateAppointment(timeSlot, vaccine, Appointment.Type.firstDose, this);
            this.appointmentHistory.add(ap);
            System.out.println();
            return ap;
        }
        System.out.println("    Error: This timeslot is unavalible in this facility for this vaccine. ");
        System.out.println();
        return null;
    }
    
    public Appointment newAppointmentforSecondDose(TimeSlot timeSlot, Vaccine vaccine, Facility facility){
        System.out.println("Patient "+ this.person.firstName + " call " + facility.getName()+" to get an appointment for: " + vaccine.getName()+"- Second dose" +" at "+ timeSlot.getStartTime().toString());

        if(facility.hasAvalibleTimeSlot(timeSlot, vaccine)){
            Appointment ap = facility.generateAppointment(timeSlot, vaccine, Appointment.Type.secondDose, this);
            System.out.println();
            return ap;
        }
        System.out.println("    Error: This timeslot is unavalible in this facility for this vaccine: ");
        System.out.println();
        return null;
    }
    
    public Encounter newEncounter(Appointment appointment){
        Encounter encounter = new Encounter(appointment);
        if(encounter.getMedicalScreen() && appointment.vaccineDoseAssignment != null){
            encounter.getShot();
            encounterHistory.add(encounter);
        }
        
        
        return encounter;
    }
    
    public Encounter reportSideEffect(Encounter encounter, Encounter.SideEffect sideEffect){
        
        encounter.setSideEffect(sideEffect);
        return encounter;
    }
    
    public VaccineCertification getCurrentImmunizationStatus(LocalDate today){
        
        VaccineCertification vc = new VaccineCertification();
        vc.person = this.person;
        if(encounterHistory.isEmpty()){
            return vc;
        }
        vc.vaccine = encounterHistory.get(0).getVaccine();
        for(Encounter encounter: encounterHistory){
            
            if(encounter.type == Encounter.Type.firstDose){
                vc.firstShotDate = encounter.getDate();
                vc.firstShotFacility = encounter.getFacility();
                vc.firstShot = encounter.getVaccineDoseAssignment();
                if(encounter.vaccine.getDose() == 1){
                    vc.effectiveDate = vc.firstShotDate.plusDays(encounter.getEffectiveAfterLastDose());
                    vc.endDate = vc.effectiveDate.plusDays(encounter.getEffectiveDuration());
                    return vc;
                }
            }
            
            if(encounter.type == Encounter.Type.secondDose){
                vc.secondShotDate = encounter.getDate();
                vc.secondShotFacility = encounter.getFacility();
                vc.secondShot = encounter.getVaccineDoseAssignment();
                
                if(vc.secondShotDate.isAfter(vc.firstShotDate.plusDays(encounter.getTimeBetweenDose() + 14))){
                    vc.refresh();
                } else{
                    vc.effectiveDate = vc.secondShotDate.plusDays(encounter.getEffectiveAfterLastDose());
                    vc.endDate = vc.effectiveDate.plusDays(encounter.getEffectiveDuration());
                    vc.vaccine = encounter.getVaccine();
                    break;
                }
            }
        }
        this.vanccineCertification = vc;
        
        
        return vc;
    }

    public List<Encounter> getEncounterHistory() {
        return encounterHistory;
    }
    
    
    
    
}