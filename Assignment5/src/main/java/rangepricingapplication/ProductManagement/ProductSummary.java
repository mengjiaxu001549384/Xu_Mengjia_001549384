/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rangepricingapplication.ProductManagement;

/**
 *
 * @author kal bugrara
 */
//this class will extract summary data from the product
public class ProductSummary {
    Product subjectproduct;
    int numberofsalesabovetarget;
    int numberofsalesbelowtarget;
    int salesperformance;
    int rank; // will be done later
    int salesVolume;
    
    public ProductSummary(Product p){
        
        numberofsalesabovetarget = p.getNumberOfProductSalesAboveTarget();
        salesperformance = p.getOrderPricePerformance();
        salesVolume = p.getSalesVolume();
        subjectproduct = p; //keeps track of the product itself not as well;
        
    }
    
    public int getNumberAboveTarget(){
    
        return subjectproduct.getOrderPricePerformance();
    }
    
    public int getSalesVolume(){
        return subjectproduct.getSalesVolume();
    }
    
    public String getName(){
        return subjectproduct.getName();
    }

    public int getSalesperformance() {
        return salesperformance;
    }
    
    
}
