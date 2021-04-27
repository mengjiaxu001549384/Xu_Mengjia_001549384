/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vaccinemanagementapplication.patient;

/**
 *
 * @author apple
 */
public class Person {
    String firstName;
    String lastName;
    int age;
    String Occupation;
    String SSN;
    PatientProfile patientProfile;

    public Person(String firstName, String lastName, int age, String Occupation, String SSN) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.Occupation = Occupation;
        this.SSN = SSN;
        this.patientProfile = new PatientProfile(this);
    }

    public PatientProfile getPatientProfile() {
        return patientProfile;
    }

    public int getAge() {
        return age;
    }

    public String getOccupation() {
        return Occupation;
    }

    public String getSSN() {
        return SSN;
    }
    
    
}
