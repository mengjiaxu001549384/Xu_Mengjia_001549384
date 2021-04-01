/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rangepricingapplication.Personnel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import rangepricingapplication.SalesManagement.SalesPeoplePriceComparator;
import rangepricingapplication.SalesManagement.SalesPeopleVolumeComparator;

/**
 *
 * @author apple
 */
public class EmployeeReport {
    
    ArrayList<EmployeeSummary> employeeSummaryList;

    public EmployeeReport() {
        employeeSummaryList = new ArrayList<>();
    }

    
    public void addEmployeeSummary(EmployeeSummary es){
        employeeSummaryList.add(es);
    }
    
    public List<EmployeeSummary> getTopTenSalesPersonBySalesVolume(){
        List<EmployeeSummary> res = new ArrayList<>();
        Collections.sort(employeeSummaryList, new SalesPeopleVolumeComparator());
        for(int i = 0; i < 10; i++){
            res.add(employeeSummaryList.get(i));
        }
        return res;
    }
    
    public List<EmployeeSummary> getTopTenSalesPersonByPricepPerformance(){
        List<EmployeeSummary> res = new ArrayList<>();
        Collections.sort(employeeSummaryList, new SalesPeoplePriceComparator());
        for(int i = 0; i < 10; i++){
            res.add(employeeSummaryList.get(i));
        }
        return res;
    }
}
