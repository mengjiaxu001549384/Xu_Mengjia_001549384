/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rangepricingapplication.Supplier;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author apple
 */
public class SupplierReport {
    ArrayList<SupplierSummary> suppliersummarylist;
    public SupplierReport(){
        suppliersummarylist = new ArrayList<>();
    }
    
    
    
    public void addSupplierSummary(SupplierSummary ss){
        suppliersummarylist.add(ss);
    }
    
    public List<SupplierSummary> getTopTenLargestSuppliers(){
        List<SupplierSummary> res = new ArrayList<>();
        Collections.sort(suppliersummarylist, new SupplierVolumeComparator());
        for(int i = 0; i < 10; i++){
            res.add(suppliersummarylist.get(i));
        }
        return res;
    }
}
