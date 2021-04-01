/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rangepricingapplication.Supplier;

import java.util.ArrayList;
import java.util.List;
import rangepricingapplication.OrderManagement.MasterOrderList;
import rangepricingapplication.OrderManagement.Order;
import rangepricingapplication.OrderManagement.OrderItem;
import rangepricingapplication.ProductManagement.Product;
import rangepricingapplication.ProductManagement.ProductCatalog;

/**
 *
 * @author kal bugrara
 */
public class Supplier {
    String name;
    List<Product> productlist;
    
    public Supplier(String n){
        name = n;
        productlist = new ArrayList<>();
    }

    public void addProduct(Product product){
        productlist.add(product);
    }
    
    public int getSalesVolume(){
        int sum = 0;
        for(Product p: productlist){
            for(OrderItem oi: p.getOrderitems()){
                sum += oi.getOrderItemTotal();
            }
        }
        return sum;
    }
}
