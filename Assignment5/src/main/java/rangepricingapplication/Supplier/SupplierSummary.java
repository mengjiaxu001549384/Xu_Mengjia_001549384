/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rangepricingapplication.Supplier;


/**
 *
 * @author apple
 */
public class SupplierSummary {
    Supplier subjectSupplier;
    int salesVolume;
    
    
    public SupplierSummary(Supplier s){
        
        salesVolume = s.getSalesVolume();
        subjectSupplier = s; //keeps track of the product itself not as well;
        
    }
    
    public String getName(){
        return subjectSupplier.name;
    }

    public int getSalesVolume() {
        return salesVolume;
    }

    
}
