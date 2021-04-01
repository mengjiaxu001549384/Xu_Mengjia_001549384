/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rangepricingapplication.Supplier;

import java.util.ArrayList;
import rangepricingapplication.Business.Business;
import rangepricingapplication.OrderManagement.MasterOrderList;


/**
 *
 * @author kal bugrara
 */
public class SupplierDirectory {
    Business business;
    ArrayList<Supplier> supplierlist;
    
    
    public SupplierDirectory(Business d){
        this.business = d;
        supplierlist = new ArrayList();
        
    }
    public Supplier newSupplier(String n){
        Supplier supplier = new Supplier(n);
        supplierlist.add(supplier);
        return supplier;

    }

    public ArrayList<Supplier> getSupplierlist() {
        return supplierlist;
    }
    
    
    
    public SupplierReport generatPerformanceReport(){
        SupplierReport supplierReport = new SupplierReport();
    
        for(Supplier s: supplierlist){
            
            SupplierSummary ss = new SupplierSummary(s);
            supplierReport.addSupplierSummary(ss);
        }
        return supplierReport; 
    } 
}
