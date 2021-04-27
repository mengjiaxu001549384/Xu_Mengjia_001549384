/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vaccinemanagementapplication.System;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import vaccinemanagementapplication.FacilityModel.Facility;
import vaccinemanagementapplication.FacilityModel.FacilityDirectory;
import vaccinemanagementapplication.patient.PatientDirectory;
import vaccinemanagementapplication.patient.PatientProfile;
import vaccinemanagementapplication.patient.PhaseTime;
import vaccinemanagementapplication.patient.VaccineCertification;
import vaccinemanagementapplication.vaccine.VaccineCatalog;

/**
 *
 * @author apple
 */
public class VaccineManagementSystem {
    String name;
    PatientDirectory patientDirectory;
    FacilityDirectory facilityDirectory;
    VaccineCatalog vaccineCatalong;
    PhaseTime phaseTime;

    public VaccineManagementSystem(String name) {
        this.name = name;
        this.facilityDirectory = new FacilityDirectory(this);
        this.patientDirectory = new PatientDirectory(this);
        this.vaccineCatalong = new VaccineCatalog(this);
    }

    public Map<String, PatientProfile> getPatientList() {
        return patientDirectory.getPatientList();
    }
    
    public List<Facility> getFacilityList() {
        return facilityDirectory.getFacilityList();
    }

    public PatientDirectory getPatientDirectory() {
        return patientDirectory;
    }

    public FacilityDirectory getFacilityDirectory() {
        return facilityDirectory;
    }

    public VaccineCatalog getVaccineCatalong() {
        return vaccineCatalong;
    }

    public void setPhaseTime(LocalDate firstPhase, LocalDate secondPhase, LocalDate thirdPhase) {
        this.phaseTime = new PhaseTime(firstPhase,secondPhase,thirdPhase, this);
    }

    public String getName() {
        return name;
    }

    public PhaseTime getPhaseTime() {
        return phaseTime;
    }
    
    
    
    public VaccineCertification searchForVaccineCertification(String SSN, LocalDate today){
        PatientProfile pp = patientDirectory.findPatientProfile(SSN);
        VaccineCertification vc = pp.getCurrentImmunizationStatus(today);
        
        return vc;
    }
    
    public boolean verifyForVaccineCertification(VaccineCertification vc){
        return vc.verify(this);
    }
    
    public void generateReport(){
        facilityDirectory.generateReport();
        patientDirectory.generateReport();
        vaccineCatalong.generateReport();
        //side effect
    }
    

}
