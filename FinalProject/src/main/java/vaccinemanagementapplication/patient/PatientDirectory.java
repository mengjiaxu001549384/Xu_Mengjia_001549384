/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vaccinemanagementapplication.patient;


import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import vaccinemanagementapplication.System.VaccineManagementSystem;

/**
 *
 * @author apple
 */
public class PatientDirectory {
    Map<String, PatientProfile> patientList;
    VaccineManagementSystem vms;

    public PatientDirectory(VaccineManagementSystem vms) {
        this.vms = vms;
        patientList = new HashMap();
    }
    
    public PatientProfile newPatient(Person person){
        PatientProfile pp = person.getPatientProfile();
        patientList.put(person.getSSN(),pp);
        return pp;
    }

    public Map<String, PatientProfile> getPatientList() {
        return patientList;
    }
    
    public PatientProfile findPatientProfile(String SSN){
        return patientList.get(SSN);
    }
    
    public void generateReport(){
        int fullyImmuned = 0, partialImmuned = 0;
        int pfizer = 0, moderna = 0, jj = 0;
        for(PatientProfile pp: patientList.values()){
            VaccineCertification vc = vms.searchForVaccineCertification(pp.person.getSSN(), LocalDate.of(2021, 6, 1));
            if(vc.vaccine == null){
                continue;
            }
            
            if(vc.vaccine.getDose()==1){
                if(vc.firstShot != null){
                    fullyImmuned++;
                }
            } else{
                if(vc.secondShot != null){
                    fullyImmuned++;
                } else if(vc.firstShot != null){
                    partialImmuned++;
                }
            }
        }
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("===============================Vaccination Progress=============================");
        System.out.println("Number of people fully immuned: " + fullyImmuned);
        System.out.println("Number of people partial immuned: " + partialImmuned);
    }
    
}
