/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rangepricingapplication.Personnel;


import rangepricingapplication.OrderManagement.MasterOrderList;
import rangepricingapplication.OrderManagement.Order;
import rangepricingapplication.OrderManagement.OrderItem;

/**
 *
 * @author kal bugrara
 */
public class EmployeeProfile {

    Person person;
    Order order;
    MasterOrderList masterOrderList;

    public EmployeeProfile() {
    }

    

    public EmployeeProfile(Person p) {
        person = p;
        masterOrderList = new MasterOrderList();
    }

    public void setMasterOrderList(MasterOrderList masterOrderList) {
        this.masterOrderList = masterOrderList;
    }
    
    
    public int getSalesVolume(){
        int sum = 0;
        for(Order o : masterOrderList.getOrders()){
            if(this == o.getSalesperson()){
                for(OrderItem oi: o.getOrderitems()){
                    sum += oi.getOrderItemTotal();
                }
            }
        }
        return sum;
    }
    
    public String getID(){
        return person.getPersonId();
    }

    public int getPricePerformance(){
        int sum = 0;
        for(Order o : masterOrderList.getOrders()){
            if(this == o.getSalesperson()){
                for(OrderItem oi: o.getOrderitems()){
                    sum += oi.calculatePricePerformance();
                }
            }
        }
        return sum;
    }
    public boolean isMatch(String id) {
        if (person.getPersonId().equals(id)) {
            return true;
        }
        return false;
    }




}
