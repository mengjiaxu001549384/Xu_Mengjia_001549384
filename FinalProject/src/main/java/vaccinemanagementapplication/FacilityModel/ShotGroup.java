/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vaccinemanagementapplication.FacilityModel;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author apple
 */
public class ShotGroup {
    List<Nurse> nurses;
    List<Doctor> doctors;
    
    public ShotGroup(){
        nurses = new ArrayList();
        doctors = new ArrayList();
    }
    
    public void remove(){
        nurses.remove(0);
        doctors.remove(0);
    }
    
    public void AddNewDoctor(Doctor doctor){
        doctors.add(doctor);
    }
    
    public void AddNewNurse(Nurse nurse){
        nurses.add(nurse);
    }

    public List<Nurse> getNurses() {
        return nurses;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }
    
    
    
    public Nurse getANurse(){
        Nurse nurse = nurses.get(0);
        nurses.remove(0);
        return nurse;
    }
    
    public Doctor getADoctor(){
        Doctor doctor = doctors.get(0);
        doctors.remove(0);
        return doctor;
    }
}


