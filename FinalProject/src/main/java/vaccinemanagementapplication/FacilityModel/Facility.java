/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vaccinemanagementapplication.FacilityModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import vaccinemanagementapplication.patient.Appointment;
import vaccinemanagementapplication.patient.Encounter;
import vaccinemanagementapplication.patient.PatientProfile;
import vaccinemanagementapplication.vaccine.Vaccine;

/**
 *
 * @author apple
 */
public class Facility {
    String name;
    String address;
    String type;
    boolean isQualified;
    List<Doctor> doctorDirectory;
    List<Nurse> nurseDirectory;
    List<Inventory> inventorylist;
    HashMap<TimeSlot,ShotGroup> vaccineSchedule;
    List<Appointment> appointmentRecord;
    List<Encounter> encounterRecord;
    List<VaccineDoseAssignment> vaccineDoseAssignments;

    

    public Facility(String name, String address, String type) {
        this.name = name;
        this.address = address;
        this.type = type;
        doctorDirectory = new ArrayList();
        nurseDirectory = new ArrayList();
        vaccineSchedule = new HashMap();
        encounterRecord = new ArrayList();
        appointmentRecord = new ArrayList();
        inventorylist = new ArrayList();
        vaccineDoseAssignments = new ArrayList();
    }

    public void setIsQualified(boolean isQualified) {
        this.isQualified = isQualified;
    }
    
    public String getName() {
        return name;
    }

    public HashMap<TimeSlot, ShotGroup> getVaccineSchedule() {
        return vaccineSchedule;
    }
    
    
    public void generateVaccineSchedule(){
        for(Doctor doctor: doctorDirectory){
            for(TimeSlot timeSlot: doctor.getSchedules()){
                ShotGroup shotGroup = vaccineSchedule.getOrDefault(timeSlot, new ShotGroup());
                shotGroup.AddNewDoctor(doctor);
                vaccineSchedule.put(timeSlot, shotGroup);
            }
        }
        for(Nurse nurse: nurseDirectory){
            for(TimeSlot timeSlot: nurse.getSchedules()){
                ShotGroup shotGroup = vaccineSchedule.getOrDefault(timeSlot, new ShotGroup());
                shotGroup.AddNewNurse(nurse);
                vaccineSchedule.put(timeSlot, shotGroup);
            }
        }
        
    }
    
    public Doctor AddNewDoctor(Doctor doctor){
        doctorDirectory.add(doctor);
        
        for(TimeSlot s : doctor.getSchedules()){
           ShotGroup newShotGroup = vaccineSchedule.getOrDefault(s, new ShotGroup());
           newShotGroup.AddNewDoctor(doctor);
           vaccineSchedule.put(s,newShotGroup);
        }
        
        return null;
    }
    
    public Nurse AddNewNurse(Nurse nurse){
        nurseDirectory.add(nurse);
        
        for(TimeSlot s : nurse.getSchedules()){
           ShotGroup newShotGroup = vaccineSchedule.getOrDefault(s, new ShotGroup());
           newShotGroup.AddNewNurse(nurse);
           vaccineSchedule.put(s,newShotGroup);
        }
        
        return null;
    }
    
    public Inventory receiveInventory(Inventory inventory){
        inventorylist.add(inventory);
        return inventory;
    }

    public Inventory getInventory(Vaccine vaccine) {
        for(Inventory inventory : inventorylist){
            if(inventory.getVaccine() == vaccine && inventory.getUnusedDose() != null){
                return inventory;
            }
        }
        return null;
    }

    public List<Encounter> getEncounterRecord() {
        return encounterRecord;
    }
    
    public boolean hasAvalibleTimeSlot(TimeSlot timeSlot, Vaccine vaccine){
        Inventory inventory = this.getInventory(vaccine);
        ShotGroup shotGroup = vaccineSchedule.getOrDefault(timeSlot, new ShotGroup());
        
        if(shotGroup.doctors.isEmpty() || shotGroup.nurses.isEmpty()){
            System.out.println("    Error: Doctors/Nurses are not able to serve in this timeslot.");
            return false;
        }
        
        if(inventory == null){
            System.out.println("    Error: This Vaccine is out of stock. ");
            return false;
        }
        
        return true;
    }
    
    public Appointment generateAppointment(TimeSlot timeSlot, Vaccine vaccine, Appointment.Type type, PatientProfile patient){
        
        String appointmentID = this.getName()+timeSlot.getStartTime();
        Inventory inventory = this.getInventory(vaccine);
        ShotGroup shotGroup = vaccineSchedule.getOrDefault(timeSlot, new ShotGroup());
        
        shotGroup.getANurse();
        shotGroup.getADoctor();
        
        vaccineSchedule.put(timeSlot, shotGroup);
        
        Appointment ap = new Appointment(appointmentID, type, patient, timeSlot, vaccine, this);
        
        VaccineDoseAssignment vda = inventory.assignVaccineDose(ap);
        
        ap.setVaccineDoseAssignment(vda);
        
        appointmentRecord.add(ap);
        
        return ap;
    }
    
    public void addToEncounterRecord(Encounter encounter){
        encounterRecord.add(encounter);
        vaccineDoseAssignments.add(encounter.getVaccineDoseAssignment());
    }

    public List<VaccineDoseAssignment> getVaccineDoseAssignments() {
        return vaccineDoseAssignments;
    }
    
    
}


