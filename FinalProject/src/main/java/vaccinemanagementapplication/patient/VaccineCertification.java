/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vaccinemanagementapplication.patient;

import java.time.LocalDate;
import vaccinemanagementapplication.FacilityModel.Facility;
import vaccinemanagementapplication.FacilityModel.VaccineDoseAssignment;
import vaccinemanagementapplication.System.VaccineManagementSystem;
import vaccinemanagementapplication.vaccine.Vaccine;

/**
 *
 * @author apple
 */
public class VaccineCertification {
    Person person;
    Vaccine vaccine;
    LocalDate firstShotDate;
    Facility firstShotFacility;
    LocalDate secondShotDate;
    Facility secondShotFacility;
    LocalDate effectiveDate;
    LocalDate endDate;
    VaccineDoseAssignment firstShot;
    VaccineDoseAssignment secondShot;

    public VaccineCertification() {
        
    }

    public void refresh(){
        this.vaccine = null;
        this.firstShotDate = null;
        this.secondShotDate = null;
        this.effectiveDate = null;
        this.endDate = null;
    }
    
    public boolean verify(VaccineManagementSystem vms){
        boolean veriftFacility;
        boolean verifyPatient = vms.getPatientList().containsKey(person.SSN);
        System.out.println("PatientProfile verified: " + verifyPatient);
        boolean verifyVaccineDose;
        
        if(vaccine == null){
            System.out.println("No record found");
            return false;
        }
        
        if(vaccine.getDose()==1){
            veriftFacility = vms.getFacilityList().contains(firstShotFacility);
            System.out.println("Facility verified: " + veriftFacility);
            verifyVaccineDose = firstShotFacility.getVaccineDoseAssignments().contains(firstShot);
            System.out.println("VaccineDose verified: " + verifyVaccineDose);
        } else{
            if(secondShotFacility == null){
                veriftFacility = vms.getFacilityList().contains(firstShotFacility);
            } else{
                veriftFacility = vms.getFacilityList().contains(firstShotFacility) && vms.getFacilityList().contains(secondShotFacility);
            }
            
            System.out.println("Facility verified: " + veriftFacility);
            boolean verifyFirstVaccineDose = firstShotFacility.getVaccineDoseAssignments().contains(firstShot);
            System.out.println("First Vaccine Dose verified: " + verifyFirstVaccineDose);
            boolean verifySecondVaccineDose;
            if(secondShotFacility == null){
                verifySecondVaccineDose = true;
                System.out.println("Second dose not been given yet.");
            }else{
                verifySecondVaccineDose = secondShotFacility.getVaccineDoseAssignments().contains(secondShot);
                System.out.println("Second Vaccine Dose verified: " + verifySecondVaccineDose);
            }
            
            verifyVaccineDose = verifyFirstVaccineDose && verifySecondVaccineDose;
        }
        for(Encounter en: person.patientProfile.encounterHistory){
            
            if(en.getVaccine() != this.vaccine){
                verifyVaccineDose = false;
                System.out.println("Earning: Multiple vaccine injection.");
            }
        }
        
        return veriftFacility && verifyPatient && verifyVaccineDose;
    }
    
    public void printVaccineCertification(){
        System.out.println("===============================Vaccine Certification for: " + this.person.firstName +" "+ this.person.lastName+ "================================");
        if(this.person == null){
            System.out.println("Error: Wrong Entering_SSN");
        } else if(this.vaccine == null){
            System.out.println("Error: No Record of Covid-19 Vaccination Information Found");
        } else if(this.vaccine.getDose() == 1){
            System.out.println("Name: "+ this.person.firstName+" "+ this.person.lastName);
            System.out.println("SSN: "+this.person.SSN);
            System.out.println("Vaccine Type: "+ this.vaccine.getName());
            System.out.println("Shot Date: " + this.firstShotDate.toString());
            System.out.println("Shot Facility: " + this.firstShotFacility.getName());
            System.out.println("Effective from: " + this.effectiveDate.toString() + " to " + this.endDate.toString());
        } else if(this.vaccine.getDose() != 1 && this.secondShotDate == null){
            System.out.println("Name: "+ this.person.firstName+" "+ this.person.lastName);
            System.out.println("SSN: "+this.person.SSN);
            System.out.println("Vaccine Type: "+ this.vaccine.getName());
            System.out.println("First Shot Date: " + this.firstShotDate.toString());
            System.out.println("First Shot Facility: " + this.firstShotFacility.getName());
            System.out.println("Warning: Not Fully Vaccinated");
        } else{
            System.out.println("Name: "+ this.person.firstName+" "+ this.person.lastName);
            System.out.println("SSN: "+this.person.SSN);
            System.out.println("Vaccine Type: "+ this.vaccine.getName());
            System.out.println("First Shot Date: " + this.firstShotDate.toString());
            System.out.println("First Shot Facility: " + this.firstShotFacility.getName());
            System.out.println("Second Shot Date: " + this.secondShotDate.toString());
            System.out.println("First Shot Facility: " + this.secondShotFacility.getName());
            System.out.println("Effective from: " + this.effectiveDate.toString() + " to " + this.endDate.toString());
        }
    }
}
