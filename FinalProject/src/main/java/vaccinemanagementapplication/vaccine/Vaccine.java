/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vaccinemanagementapplication.vaccine;

import java.util.ArrayList;
import java.util.List;
import vaccinemanagementapplication.FacilityModel.Inventory;
import vaccinemanagementapplication.FacilityModel.VaccineDoseAssignment;

/**
 *
 * @author apple
 */
public class Vaccine {
    String name;
    int timeBetweenDose;
    int dose;
    int effectiveDuration;
    int effectiveAfterLastDose;
    List<VaccineBatch> batchs;
    
    public Vaccine(String name, int timeBetweenDose, int dose, int effectiveDuration,int effectiveAfterLastDose) {
        this.name = name;
        this.timeBetweenDose = timeBetweenDose;
        this.dose = dose;
        this.effectiveDuration = effectiveDuration;
        this.effectiveAfterLastDose = effectiveAfterLastDose;
        batchs = new ArrayList();
    }
    
    
    public VaccineBatch newBatch(String batchID, Vaccine vaccine, int amount){
        VaccineBatch vb = new VaccineBatch(batchID, vaccine, amount);
        batchs.add(vb);
        return vb;
    }

    public String getName() {
        return name;
    }

    public int getDose() {
        return dose;
    }

    public int getTimeBetweenDose() {
        return timeBetweenDose;
    }

    public int getEffectiveDuration() {
        return effectiveDuration;
    }

    public int getEffectiveAfterLastDose() {
        return effectiveAfterLastDose;
    }
    
    public List<VaccineDose> getVaccineDoses() {
        List<VaccineDose> vaccineDoses = new ArrayList();
        for(VaccineBatch vb: batchs){
            vaccineDoses.addAll(vb.getVaccineDoses());
        }
        return vaccineDoses;
    }
    
    public List<Inventory> getInventories() {
        List<Inventory> inventories = new ArrayList();
        for(VaccineBatch vb: batchs){
            inventories.addAll(vb.getInventories());
        }
        return inventories;
    }
    
}
