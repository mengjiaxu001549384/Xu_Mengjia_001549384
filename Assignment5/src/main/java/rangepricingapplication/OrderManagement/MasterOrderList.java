/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rangepricingapplication.OrderManagement;

import java.util.ArrayList;
import rangepricingapplication.Business.Business;
import rangepricingapplication.CustomerManagement.CustomerProfile;
import rangepricingapplication.Personnel.EmployeeProfile;

/**
 *
 * @author kal bugrara
 */
public class MasterOrderList {
    
    Business business;
    ArrayList<Order> orders;

    public MasterOrderList() {
        orders = new ArrayList();
    }
    
    public MasterOrderList(Business d){
        this.business = d;
        orders = new ArrayList();
    }
    
    

    public ArrayList<Order> getOrders() {
        return orders;
    }
    
    public Order newOrder(CustomerProfile cp, EmployeeProfile salesperson){
        Order o= new Order(cp, salesperson);
        orders.add(o);
        return o;
    }
    
    
}
