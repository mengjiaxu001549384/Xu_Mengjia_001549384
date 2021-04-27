/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vaccinemanagementapplication.vaccine;


import java.util.ArrayList;
import java.util.List;
import vaccinemanagementapplication.FacilityModel.Facility;
import vaccinemanagementapplication.FacilityModel.Inventory;

/**
 *
 * @author apple
 */
public class VaccineBatch {
    String batchID;
    Vaccine vaccine;
    int amount ;
    List <Inventory> inventories;

    public VaccineBatch(String batchID, Vaccine vaccine, int amount) {
        this.batchID = batchID;
        this.vaccine = vaccine;
        this.amount = amount;
        this.inventories = new ArrayList();
    }
    
    public void distribute(Facility facility, int amount){
        int currentStorage = this.remainAmount();
        if(amount > currentStorage){
            System.out.println("Error: Unreasonable Distribution");
            return;
        }
        Inventory inventory = new Inventory(facility, this, amount);
        inventories.add(inventory);
        facility.receiveInventory(inventory);
    }
    
    public int remainAmount(){
        int sum = 0;
        for(Inventory i: inventories){
            sum += i.getVaccineDoses().size();
        }
        return amount - sum;
    }

    public Vaccine getVaccine() {
        return vaccine;
    }
    
    public int getTimeBetweenDose() {
        return vaccine.getTimeBetweenDose();
    }

    public int getEffectiveDuration() {
        return vaccine.getEffectiveDuration();
    }

    public List<VaccineDose> getVaccineDoses() {
        List<VaccineDose> vaccineDoses = new ArrayList();
        for(Inventory inventory: inventories){
            vaccineDoses.addAll(inventory.getVaccineDoses());
        }
        return vaccineDoses;
    }

    public List<Inventory> getInventories() {
        return inventories;
    }
    
}
