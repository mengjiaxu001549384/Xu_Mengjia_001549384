package vaccinemanagementapplication;

import com.github.javafaker.Faker;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import vaccinemanagementapplication.FacilityModel.Doctor;
import vaccinemanagementapplication.FacilityModel.Facility;
import vaccinemanagementapplication.FacilityModel.FacilityDirectory;
import vaccinemanagementapplication.FacilityModel.Nurse;
import vaccinemanagementapplication.FacilityModel.TimeSlot;
import vaccinemanagementapplication.System.VaccineManagementSystem;
import vaccinemanagementapplication.patient.Appointment;
import vaccinemanagementapplication.patient.Encounter;
import vaccinemanagementapplication.patient.PatientDirectory;
import vaccinemanagementapplication.patient.PatientProfile;
import vaccinemanagementapplication.patient.Person;
import vaccinemanagementapplication.patient.VaccineCertification;
import vaccinemanagementapplication.vaccine.Vaccine;
import vaccinemanagementapplication.vaccine.VaccineBatch;
import vaccinemanagementapplication.vaccine.VaccineCatalog;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author apple
 */
public class vaccineoperation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        VaccineManagementSystem vms = new VaccineManagementSystem("Vaccine Management System");   
        LocalDate phase1 = LocalDate.of(2020, 12, 1); 
        LocalDate phase2 = LocalDate.of(2021, 2, 1); 
        LocalDate phase3 = LocalDate.of(2021, 4, 15); 
        vms.setPhaseTime(phase1, phase2, phase3);
        
        PatientDirectory patientDirectory = vms.getPatientDirectory();
        FacilityDirectory facilityDirectory = vms.getFacilityDirectory();
        VaccineCatalog vaccineCatalong = vms.getVaccineCatalong();
        
        Faker faker = new Faker();
        
 //vaccine
        
        Vaccine pfizer = vaccineCatalong.newVaccine("Pfizer", 21, 2, 183, 14);
        Vaccine moderna = vaccineCatalong.newVaccine("Moderna", 28, 2, 183, 14);
        Vaccine jj = vaccineCatalong.newVaccine("J&J", 0, 1, 183, 14);
        
// vaccine batch
        
        VaccineBatch p001 = pfizer.newBatch("p001", pfizer, 30);
        VaccineBatch p002 = pfizer.newBatch("p002", pfizer, 60);
        VaccineBatch p003 = pfizer.newBatch("p003", pfizer, 90);
        
        VaccineBatch m001 = moderna.newBatch("m001", moderna, 30);
        VaccineBatch m002 = moderna.newBatch("m002", moderna, 40);
        VaccineBatch m003 = moderna.newBatch("m003", moderna, 50);
                
        VaccineBatch j001 = moderna.newBatch("j001", jj, 10);
        VaccineBatch j002 = moderna.newBatch("j002", jj, 20);
        VaccineBatch j003 = moderna.newBatch("j003", jj, 30);
   
        
//facility
        
        Facility cvs001 = facilityDirectory.newFacility("cvs001", "1 Madison Ave", "pharmacy");
        Facility cvs002 = facilityDirectory.newFacility("cvs002", "2 StAndrews Pl", "pharmacy");
        Facility cvs003 = facilityDirectory.newFacility("cvs003", "3 College Blvd", "pharmacy");
        Facility clinic001 = facilityDirectory.newFacility("clinic001", "4 Edwards Pl", "clinic");
        Facility clinic002 = facilityDirectory.newFacility("clinic002", "5 Sam Way", "clinic");
        Facility clinic003 = facilityDirectory.newFacility("clinic003", "6 Costco Ave", "clinic");
 
        cvs001.setIsQualified(true);
        cvs002.setIsQualified(true);
        cvs003.setIsQualified(true);
        clinic001.setIsQualified(true);
        clinic002.setIsQualified(true);
        clinic003.setIsQualified(false);
        
//Batch distribute to facilities

        p001.distribute(cvs001, 4);
        p001.distribute(cvs002, 6);
        p001.distribute(cvs003, 5);
        p001.distribute(clinic001, 10);
        p001.distribute(clinic002, 5);
        
        p002.distribute(cvs001, 6);
        p002.distribute(cvs002, 12);
        p002.distribute(cvs003, 7);
        p002.distribute(clinic001, 10);
        p002.distribute(clinic002, 25);
        
        p003.distribute(cvs001, 15);
        p003.distribute(cvs002, 10);
        p003.distribute(cvs003, 20);
        p003.distribute(clinic001, 30);
        p003.distribute(clinic002, 15);
        
        
        m001.distribute(cvs001, 4);
        m001.distribute(cvs002, 6);
        m001.distribute(cvs003, 5);
        m001.distribute(clinic001, 10);
        m001.distribute(clinic002, 5);
        
        m002.distribute(cvs001, 6);
        m002.distribute(cvs002, 12);
        m002.distribute(cvs003, 6);
        m002.distribute(clinic001, 10);
        m002.distribute(clinic002, 6);
        
        m003.distribute(cvs001, 10);
        m003.distribute(cvs002, 10);
        m003.distribute(cvs003, 10);
        m003.distribute(clinic001, 10);
        m003.distribute(clinic002, 10);
        
        j001.distribute(cvs001, 2);
        j001.distribute(cvs002, 2);
        j001.distribute(cvs003, 2);
        j001.distribute(clinic001, 2);
        j001.distribute(clinic002, 2);
        
        j002.distribute(cvs001, 6);
        j002.distribute(cvs002, 3);
        j002.distribute(cvs003, 3);
        j002.distribute(clinic001, 4);
        j002.distribute(clinic002, 4);
        
        j003.distribute(cvs001, 7);
        j003.distribute(cvs002, 7);
        j003.distribute(cvs003, 7);
        j003.distribute(clinic001, 3);
        j003.distribute(clinic002, 6);
        
//person & patient
        
        List<Person> personlist = new ArrayList<>();
        List<String> occupations = new ArrayList<>();
        
        for(int i = 0; i < 17; i++){
            occupations.add(faker.job().toString());
        }
        occupations.add("Health care worker");
        occupations.add("Long term care staff");
        occupations.add("Home-based health care worker");
        
        for(int i = 0; i < 200; i++){
            Person person = new Person(faker.name().firstName(),faker.name().lastName(),
                    faker.number().numberBetween(18,90), 
                    occupations.get(faker.number().numberBetween(0,occupations.size()-1)), 
                    faker.idNumber().ssnValid());
            personlist.add(person);
        }
        
        for(int i = 0; i < 200; i++){
            patientDirectory.newPatient(personlist.get(i));
        }
        
// create doctors & nurses and their timeslots

        LocalDate date20210416 = LocalDate.of(2021, 4, 16);
        LocalDate date20210101 = LocalDate.of(2021, 1, 1);
        LocalDate date20210301 = LocalDate.of(2021, 3, 1);
        LocalDate date20210129 = date20210101.plusDays(28);
        LocalDate date20210329 = date20210301.plusDays(28);
        LocalDate date20210514 = date20210416.plusDays(28);
        
        List<LocalDate> dates = new ArrayList();
        List<LocalTime> times = new ArrayList();
        
        dates.add(date20210101);
        dates.add(date20210301);
        dates.add(date20210416);
        dates.add(date20210129);
        dates.add(date20210329);
        dates.add(date20210514);
        
        LocalTime time = LocalTime.of(8, 0);
        for(int i = 0; i < 16; i++){
            times.add(time);
            time = time.plusMinutes(15);
        }
        
        List<TimeSlot> timeSlots = new ArrayList();
        for(LocalDate ld: dates){
            for(LocalTime lt: times){
                timeSlots.add(new TimeSlot(LocalDateTime.of(ld, lt)));
            }
        }
        
        cvs001.generateVaccineSchedule();
        cvs002.generateVaccineSchedule();
        cvs003.generateVaccineSchedule();
        clinic001.generateVaccineSchedule();
        clinic002.generateVaccineSchedule();
        
        for(int i = 0; i < 2; i++){
            cvs001.AddNewDoctor(new Doctor(faker.name().fullName(), faker.idNumber().ssnValid(),cvs001, timeSlots));
            cvs001.AddNewNurse(new Nurse(faker.name().fullName(), faker.idNumber().ssnValid(),cvs001,timeSlots));
        }
        
        for(int i = 0; i < 3; i++){
            cvs002.AddNewDoctor(new Doctor(faker.name().fullName(), faker.idNumber().ssnValid(),cvs002, timeSlots));
            cvs002.AddNewNurse(new Nurse(faker.name().fullName(), faker.idNumber().ssnValid(),cvs002,timeSlots));
        }
        
        for(int i = 0; i < 4; i++){
            cvs003.AddNewDoctor(new Doctor(faker.name().fullName(), faker.idNumber().ssnValid(),cvs003, timeSlots));
            cvs003.AddNewNurse(new Nurse(faker.name().fullName(), faker.idNumber().ssnValid(),cvs003,timeSlots));
        }
        
        for(int i = 0; i < 5; i++){
            clinic001.AddNewDoctor(new Doctor(faker.name().fullName(), faker.idNumber().ssnValid(),clinic001, timeSlots));
            clinic001.AddNewNurse(new Nurse(faker.name().fullName(), faker.idNumber().ssnValid(),clinic001,timeSlots));
        }
        
        for(int i = 0; i < 6; i++){
            clinic002.AddNewDoctor(new Doctor(faker.name().fullName(), faker.idNumber().ssnValid(),clinic002, timeSlots));
            clinic002.AddNewNurse(new Nurse(faker.name().fullName(), faker.idNumber().ssnValid(),clinic002,timeSlots));
        }
        
        TimeSlot timeSlot = new TimeSlot();
        int index = -1;
        
//first dose
        
        for(PatientProfile pp: patientDirectory.getPatientList().values()){
            
            if(pp.getPhase() == PatientProfile.Phase.I){
                index = faker.number().numberBetween(0, 15);
                timeSlot = timeSlots.get(index);
                
            } else if(pp.getPhase() == PatientProfile.Phase.II){
                index = faker.number().numberBetween(16, 31);
                timeSlot = timeSlots.get(index);
                
            } else {
                index = faker.number().numberBetween(32, 47);
                timeSlot = timeSlots.get(index);
                
            }
            Appointment appointmentForFirstDose = pp.newAppointmentforFirstDose(timeSlot, vaccineCatalong.getVaccineCatalog().get(faker.number().numberBetween(0, 2)),  facilityDirectory.getFacilityList().get(faker.number().numberBetween(0, 4)), vms.getPhaseTime());
            int calltimes = 0;
            while(appointmentForFirstDose == null){
                if(calltimes > 5){
                    break;
                }
                if(index < 16){
                    index = faker.number().numberBetween(0, 15);
                } else if(index > 15 && index <32){
                    index = faker.number().numberBetween(16, 31);
                } else{
                    index = faker.number().numberBetween(32, 47);
                }
                timeSlot = timeSlots.get(index);
                appointmentForFirstDose = pp.newAppointmentforFirstDose(timeSlot, vaccineCatalong.getVaccineCatalog().get(faker.number().numberBetween(0, 2)),  facilityDirectory.getFacilityList().get(faker.number().numberBetween(0, 4)), vms.getPhaseTime());
                calltimes++;
            }
            

// go to appointment for first dose
            if(appointmentForFirstDose != null){
                pp.newEncounter(appointmentForFirstDose);
            }
        }
        
//second dose : only 50 people got second dose
        int count = 0;
        for(PatientProfile pp: patientDirectory.getPatientList().values()){
            if(count >= 50){
                break;
            }
            if(pp.getEncounterHistory().isEmpty()){
                continue;
            }
            
            if(pp.getEncounterHistory().get(0).getVaccine() == jj){
                continue;
            }
            
            if(pp.getEncounterHistory().get(0).getDate()== date20210101){
                index = faker.number().numberBetween(48, 63);
                timeSlot = timeSlots.get(index);
                
            } else if(pp.getEncounterHistory().get(0).getDate()== date20210301){
                index = faker.number().numberBetween(64, 79);
                timeSlot = timeSlots.get(index);
                
            } else {
                index = faker.number().numberBetween(80, 95);
                timeSlot = timeSlots.get(index);
                
            }
            
            Appointment appointmentForSecondDose = pp.newAppointmentforSecondDose(timeSlot, pp.getEncounterHistory().get(0).getVaccine(),  facilityDirectory.getFacilityList().get(faker.number().numberBetween(0, 3)));
            
            int calltimes = 0;
            while(appointmentForSecondDose == null){
                if(calltimes > 5){
                    break;
                }
                if(index < 64){
                    index = faker.number().numberBetween(48, 63);
                } else if(index > 63 && index < 80){
                    index = faker.number().numberBetween(64, 79);
                } else{
                    index = faker.number().numberBetween(80, 95);
                }
                timeSlot = timeSlots.get(index);
                appointmentForSecondDose = pp.newAppointmentforSecondDose(timeSlot, pp.getEncounterHistory().get(0).getVaccine(),  facilityDirectory.getFacilityList().get(faker.number().numberBetween(0, 3)));
                calltimes++;
            }

// go to appointment for second dose
            if(appointmentForSecondDose != null){
                pp.newEncounter(appointmentForSecondDose);
            }
            count++;
        }        
        
// get vaccine certification & verify the certification        
        
        for(Person person: personlist){
            
            VaccineCertification vc = vms.searchForVaccineCertification(person.getSSN(), LocalDate.of(2021, 6, 1));
            vc.printVaccineCertification();
            System.out.println("===================Verification Step===================");
            
            if(vms.verifyForVaccineCertification(vc)){
                System.out.println("This certification has been verified.");
            } else{
                System.out.println("Verification failed.");
            }
        }        
        
// when someone try to cheat       
        
        Person liar = new Person("Pinocchio", "Disney", 24, "Stay at home", "123456");
        personlist.add(liar);
        PatientProfile fakepp = patientDirectory.newPatient(liar);
        Appointment firstfakeshot = new Appointment("1111" , Appointment.Type.firstDose, fakepp, new TimeSlot(LocalDateTime.of(2021, 1, 1, 8, 0)), pfizer, clinic003);
        Appointment secondfakeshot = new Appointment("2222" , Appointment.Type.secondDose, fakepp, new TimeSlot(LocalDateTime.of(2021, 1, 29, 8, 0)), pfizer, clinic003);
        fakepp.getEncounterHistory().add(new Encounter(firstfakeshot));
        fakepp.getEncounterHistory().add(new Encounter(secondfakeshot));
        VaccineCertification fakevc = vms.searchForVaccineCertification(liar.getSSN(), LocalDate.of(2021, 6, 1));
        fakevc.printVaccineCertification();
        System.out.println("===================Verification Step===================");
            
        if(vms.verifyForVaccineCertification(fakevc)){
                System.out.println("This certification has been verified.");
            } else{
                System.out.println("Verification failed.");
            }

// people report side effects
        for(PatientProfile pp: patientDirectory.getPatientList().values()){
            if(pp.getEncounterHistory().isEmpty()){
                continue;
            }
            
            for(Encounter en: pp.getEncounterHistory()){
                
                Encounter.SideEffect[] symptoms = new Encounter.SideEffect[]{Encounter.SideEffect.tiredness,Encounter.SideEffect.chills,Encounter.SideEffect.fever,Encounter.SideEffect.headache, Encounter.SideEffect.musclepain, Encounter.SideEffect.nausea, Encounter.SideEffect.pain, Encounter.SideEffect.redness, Encounter.SideEffect.swelling};
                int random = faker.number().numberBetween(0, symptoms.length);
                if(random != symptoms.length){
                    en.setSideEffect(symptoms[random]);
                }
            }
        }       
// reports      
        System.out.println("");
        System.out.println("");
        System.out.println("");
        vms.generateReport();
        }
}
