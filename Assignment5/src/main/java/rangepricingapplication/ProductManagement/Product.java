/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rangepricingapplication.ProductManagement;

import java.util.ArrayList;
import rangepricingapplication.OrderManagement.OrderItem;
import rangepricingapplication.Supplier.Supplier;

/**
 *
 * @author kal bugrara
 */
public class Product {
    String name;
    private int floorPrice;
    private int ceilingPrice;
    private int targetPrice;
    Supplier supplier;
    
    ArrayList<OrderItem> orderitems;
    public Product(String name, int fp, int cp, int tp, Supplier s) {
        this.name = name;
        floorPrice = fp;
        ceilingPrice = cp;
        targetPrice = tp;
        supplier = s;
        orderitems = new ArrayList();
        supplier.addProduct(this);
    }

    public String getName() {
        return name;
    }
    
    public void addSupplier(){
        
    }

    public Supplier getSupplier(){
        return this.supplier;
    }

    public int getFloorPrice() {
        return floorPrice;
    }

    public int getCeilingPrice() {
        return ceilingPrice;
    }

    public ArrayList<OrderItem> getOrderitems() {
        return orderitems;
    }
    
    public Product updateProduct(int fp, int cp, int tp) {
        floorPrice = fp;
        ceilingPrice = cp;
        targetPrice = tp;
        return this; //returns itself
    }
    public int getTargetPrice() {
        return targetPrice;
    }
    
    public void addOrderItem(OrderItem oi){     
        orderitems.add(oi);
    }
    //Number of item sales above target 
    public int getNumberOfProductSalesAboveTarget(){
        int sum = 0;
        for (OrderItem oi: orderitems){
            if(oi.isActualAboveTarget()==true) sum = sum +1;
        }
        return sum;
    }  
    //calculates the revenues gained or lost (in relation to the target)
    //For example, if target is at $2000 and actual is $2500 then revenue gained
    // is $500 above the expected target. If the actual is $1800 then the lose will be $200
    // Add all these difference to get the total including wins and loses
    
        public int getOrderPricePerformance() {
        int sum = 0;
        for (OrderItem oi : orderitems) {
            sum = sum + oi.calculatePricePerformance();     //positive and negative values       
        }
        return sum;
    }
    
        public int getSalesVolume(){
            int sum = 0;
            for (OrderItem oi: orderitems){
                if(oi.getSelectedproduct() == this) {
                    sum = sum +oi.getOrderItemTotal();
                }
            }
            return sum;
        }
}
