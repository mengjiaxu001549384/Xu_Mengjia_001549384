/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rangepricingapplication.Personnel;

import rangepricingapplication.OrderManagement.MasterOrderList;

/**
 *
 * @author apple
 */
public class EmployeeSummary {

    EmployeeProfile subjectEmployeeProfile;
    int salesVolume;
    int pricePerformance;
    
    
    public EmployeeSummary(EmployeeProfile ep){
        
        salesVolume = ep.getSalesVolume();
        pricePerformance = ep.getPricePerformance();
        subjectEmployeeProfile = ep; //keeps track of the product itself not as well;
        
    }
    
    

    
    public int getSalesVolume() {
        return salesVolume;
    }

    public int getPricePerformance() {
        return pricePerformance;
    }
    
    public String getID(){
        return subjectEmployeeProfile.getID();
    }
    

    
    
}
