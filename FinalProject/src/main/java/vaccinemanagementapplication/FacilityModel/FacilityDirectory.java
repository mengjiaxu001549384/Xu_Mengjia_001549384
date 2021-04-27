/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vaccinemanagementapplication.FacilityModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import vaccinemanagementapplication.System.VaccineManagementSystem;
import vaccinemanagementapplication.patient.Encounter;

/**
 *
 * @author apple
 */
public class FacilityDirectory {
    List<Facility> facilityList;
    VaccineManagementSystem vaccineManagementSystem;

    public FacilityDirectory(VaccineManagementSystem vms) {
        this.vaccineManagementSystem = vms;
        facilityList = new ArrayList();
    }
    
    public Facility newFacility(String name, String address, String type){
        Facility f = new Facility(name,address,type);
        facilityList.add(f);
        return f;
    }

    public List<Facility> getFacilityList() {
        return facilityList;
    }
    
    public void generateReport(){
        
        int sum = 0;
        HashMap<Encounter.SideEffect, Integer> sideEffects= new HashMap();
        for(Facility f: facilityList){
            sum += f.getEncounterRecord().size();
            for(Encounter ec: f.getEncounterRecord()){
                if(ec.getSideEffect() != null){
                    sideEffects.put(ec.sideEffect, sideEffects.getOrDefault(ec.sideEffect, 0)+1);
                }
            }
        }
        
        
        System.out.println("===============================Side Effects Reported===============================");
        System.out.println("Total number of Shot: " + sum);
        System.out.println();
        System.out.println();
        for(Encounter.SideEffect se: sideEffects.keySet()){
            System.out.println(se.toString() +": "+ sideEffects.get(se) + " Cases");
        }
    }
    
}
