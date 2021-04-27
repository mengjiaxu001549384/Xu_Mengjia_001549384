/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vaccinemanagementapplication.vaccine;

import java.util.ArrayList;
import java.util.List;
import vaccinemanagementapplication.FacilityModel.Inventory;
import vaccinemanagementapplication.System.VaccineManagementSystem;

/**
 *
 * @author apple
 */
public class VaccineCatalog {
    List<Vaccine>  vaccineCatalog;
    VaccineManagementSystem vms;

    public VaccineCatalog(VaccineManagementSystem vms) {
        this.vms = vms;
        vaccineCatalog = new ArrayList();
    }
    
    public Vaccine newVaccine(String name, int timeBetweenDose, int dose, int effectiveDuration,int effectiveAfterLastDose){
        Vaccine v = new Vaccine(name, timeBetweenDose, dose, effectiveDuration, effectiveAfterLastDose);
        vaccineCatalog.add(v);
        return v;
    }

    public List<Vaccine> getVaccineCatalog() {
        return vaccineCatalog;
    }
    
    public void generateReport(){
        
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("===============================Vaccination Inventory Level=============================");
        
        int sum = 0;
        for(VaccineDose vd : this.getVaccineDoses()){
            if (!vd.getIsUsed()) {
                sum++;
            }
        }
        
        System.out.println("Total Unused Amount: " + sum);
        System.out.println("");
        
        for(Inventory inv: this.getInventories()){
            System.out.print("Facility: " + inv.getFacility().getName());
            System.out.print("  Batch: " + inv.getVaccineBatch().batchID);
            System.out.print("  Total Amount: " + inv.getAmount());
            System.out.print("  Unused Amount: " + inv.countUnusedDose());
            System.out.println("");
        }
    }
    
    public List<VaccineDose> getVaccineDoses() {
        List<VaccineDose> vaccineDoses = new ArrayList();
        for(Vaccine v: vaccineCatalog){
            vaccineDoses.addAll(v.getVaccineDoses());
        }
        return vaccineDoses;
    }
    
    public List<Inventory> getInventories() {
        List<Inventory> inventories = new ArrayList();
        for(Vaccine v: vaccineCatalog){
            inventories.addAll(v.getInventories());
        }
        return inventories;
    }
}
