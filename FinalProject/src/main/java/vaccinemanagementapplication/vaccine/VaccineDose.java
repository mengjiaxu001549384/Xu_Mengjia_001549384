/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vaccinemanagementapplication.vaccine;


import vaccinemanagementapplication.FacilityModel.Inventory;
import vaccinemanagementapplication.FacilityModel.VaccineDoseAssignment;
import vaccinemanagementapplication.patient.Appointment;

/**
 *
 * @author apple
 */
public class VaccineDose {
    Boolean isUsed; 
    Boolean occupied;
    VaccineDoseAssignment vaccineDoseAssignment;
    Inventory inventory;
    int number;

    public VaccineDose(Inventory inventory, int number) {
        this.isUsed = false;
        this.occupied = false;
        this.inventory = inventory;
        this.number = number;
    }

    public Boolean getIsUsed() {
        return isUsed;
    }

    public void setIsUsed(Boolean isUsed) {
        this.isUsed = isUsed;
    }
    
    
    
    public VaccineDoseAssignment newVaccineDoseAssignment(Appointment appointment){
        VaccineDoseAssignment vda = new VaccineDoseAssignment(this, appointment); 
        occupied = true;   
        return vda;
    }

    public VaccineDoseAssignment getVaccineDoseAssignment() {
        return vaccineDoseAssignment;
    }
    
    
    
}
