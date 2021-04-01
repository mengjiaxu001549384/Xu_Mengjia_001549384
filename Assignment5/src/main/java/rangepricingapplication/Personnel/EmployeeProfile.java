/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rangepricingapplication.Personnel;


import java.util.ArrayList;
import java.util.List;
import rangepricingapplication.OrderManagement.Order;
import rangepricingapplication.OrderManagement.OrderItem;

/**
 *
 * @author kal bugrara
 */
public class EmployeeProfile {

    Person person;
    Order order;
    List<Order> orderList;

    public EmployeeProfile() {
    }

    

    public EmployeeProfile(Person p) {
        person = p;
        orderList = new ArrayList<>();
    }

   
    
    public void addOrder(Order order){
        orderList.add(order);
    }
    
    public int getSalesVolume(){
        int sum = 0;
        for(Order o : orderList){
            for(OrderItem oi: o.getOrderitems()){
                    sum += oi.getOrderItemTotal();
            }
        }
        return sum;
    }
    
    public String getID(){
        return person.getPersonId();
    }

    public int getPricePerformance(){
        int sum = 0;
        for(Order o : orderList){
            for(OrderItem oi: o.getOrderitems()){
                sum += oi.calculatePricePerformance();
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
