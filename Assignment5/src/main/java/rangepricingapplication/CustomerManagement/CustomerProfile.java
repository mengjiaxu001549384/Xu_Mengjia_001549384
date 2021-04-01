/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rangepricingapplication.CustomerManagement;

import java.util.ArrayList;
import rangepricingapplication.OrderManagement.Order;
import rangepricingapplication.Personnel.*;

/**
 *
 * @author kal bugrara
 */
public class CustomerProfile {
    ArrayList<Order> orders;

    Person person;

    

    public CustomerProfile(Person p) {

        person = p;
        orders = new ArrayList();

    }

    public boolean isMatch(String id) {
        if (person.getPersonId().equals(id)) {
            return true;
        }
        return false;
    }
    public void addCustomerOrder(Order o){
        orders.add(o);
    }
}
