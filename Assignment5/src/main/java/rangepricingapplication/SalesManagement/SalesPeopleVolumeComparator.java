/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rangepricingapplication.SalesManagement;

import java.util.Comparator;
import rangepricingapplication.Personnel.EmployeeSummary;

/**
 *
 * @author apple
 */
public class SalesPeopleVolumeComparator implements Comparator<EmployeeSummary> {

    @Override
    public int compare(EmployeeSummary o1, EmployeeSummary o2) {
        if(o1.getSalesVolume() != o2.getSalesVolume()){
            return (-1)*(o1.getSalesVolume() - o2.getSalesVolume());
        }
        
        return (o1.getID().compareTo(o2.getID()));
    }
    
}
