/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rangepricingapplication.OrderManagement;

import java.util.ArrayList;
import rangepricingapplication.CustomerManagement.CustomerProfile;
import rangepricingapplication.Personnel.EmployeeProfile;
import rangepricingapplication.ProductManagement.Product;

/**
 *
 * @author kal bugrara
 */
public class Order {

    ArrayList<OrderItem> orderitems;
    CustomerProfile customer;
    EmployeeProfile salesperson;

    public Order(){}
    
    public Order(CustomerProfile cp, EmployeeProfile saleperson) {
        orderitems = new ArrayList();
        customer = cp;
        salesperson = saleperson;
        salesperson.addOrder(this);
    }

    public ArrayList<OrderItem> getOrderitems() {
        return orderitems;
    }
    
    

    public OrderItem newOrderItem(Product p, int q) {
        OrderItem oi = new OrderItem(p, q);
        orderitems.add(oi);
        return oi;
    }

    public int getOrderTotal() {
        int sum = 0;
        for (OrderItem oi : orderitems) {
            sum = sum + oi.getOrderItemTotal();
        }
        return sum;
    }

    public int getOrderPricePerformance() {
        int sum = 0;
        for (OrderItem oi : orderitems) {
            sum = sum + oi.calculatePricePerformance();     //positive and negative values       
        }
        return sum;
    }

    public int getNumberOfOrderItemsAboveTarget() {
        int sum = 0;
        for (OrderItem oi : orderitems) {
            if (oi.isActualAboveTarget() == true) {
                sum = sum + 1;
            }
        }
        return sum;
    }

    public EmployeeProfile getSalesperson() {
        return salesperson;
    }
    
    

}
