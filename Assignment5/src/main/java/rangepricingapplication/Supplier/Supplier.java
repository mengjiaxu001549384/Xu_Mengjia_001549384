/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rangepricingapplication.Supplier;

import rangepricingapplication.OrderManagement.MasterOrderList;
import rangepricingapplication.OrderManagement.Order;
import rangepricingapplication.OrderManagement.OrderItem;
import rangepricingapplication.ProductManagement.ProductCatalog;

/**
 *
 * @author kal bugrara
 */
public class Supplier {
    String name;
    ProductCatalog productcatalog;
    MasterOrderList masterOrderList;
    
    public Supplier(String n){
        name = n;
        productcatalog = new ProductCatalog();
        masterOrderList = new MasterOrderList();
    }

    public void setMasterOrderList(MasterOrderList masterOrderList) {
        this.masterOrderList = masterOrderList;
    }
    
    public int getSalesVolume(){
        int sum = 0;
        for(Order o : masterOrderList.getOrders()){
            for(OrderItem oi: o.getOrderitems()){
                if(oi.getSupplier() == this){
                    sum += oi.getOrderItemTotal();
                }
            }
        }
        return sum;
    }
}
