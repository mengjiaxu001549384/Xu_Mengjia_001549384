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
public class SalesPeoplePriceComparator implements Comparator<EmployeeSummary> {

    @Override
    public int compare(EmployeeSummary o1, EmployeeSummary o2) {
        if(o1.getPricePerformance()!= o2.getPricePerformance()){
            return (-1)*(o1.getPricePerformance()-o2.getPricePerformance());
        }
        return (o1.getID().compareTo(o2.getID()));
    }
    
}
