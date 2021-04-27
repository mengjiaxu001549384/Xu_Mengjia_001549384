/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vaccinemanagementapplication.FacilityModel;

import java.util.ArrayList;
import java.util.List;
import vaccinemanagementapplication.patient.Appointment;
import vaccinemanagementapplication.vaccine.Vaccine;
import vaccinemanagementapplication.vaccine.VaccineBatch;
import vaccinemanagementapplication.vaccine.VaccineDose;

/**
 *
 * @author apple
 */
public class Inventory {
    Facility facility;
    VaccineBatch vaccineBatch;
    List<VaccineDose> vaccineDoses;

    public Inventory(Facility facility, VaccineBatch vaccineBatch, int amount) {
        this.facility = facility;
        this.vaccineBatch = vaccineBatch;
        vaccineDoses = new ArrayList();
        for (int i = 0; i < amount; i++) {
            vaccineDoses.add(new VaccineDose(this, i));

        }
    }

    public Facility getFacility() {
        return facility;
    }

    public VaccineBatch getVaccineBatch() {
        return vaccineBatch;
    }

    public List<VaccineDose> getVaccineDoses() {
        return vaccineDoses;
    }
    
    public Vaccine getVaccine() {
        return vaccineBatch.getVaccine();
    }
    
    public int countUnusedDose(){
        int count = 0;
        for (VaccineDose vd : vaccineDoses) {

            if (!vd.getIsUsed()) {
                count++;
            }
        }
        return count;
    }

    public VaccineDose getUnusedDose() {

        for (VaccineDose vd : vaccineDoses) {

            if (!vd.getIsUsed()) {
                return vd;
            }
        }
        return null;
    }


    public VaccineDoseAssignment assignVaccineDose(Appointment appointment) {

        VaccineDose vd = getUnusedDose();
        if (vd == null) {
            return null;
        }
        VaccineDoseAssignment vda = vd.newVaccineDoseAssignment(appointment); 
        return vda;
    }
    
    public int getAmount(){
        return vaccineDoses.size();
    }

}
