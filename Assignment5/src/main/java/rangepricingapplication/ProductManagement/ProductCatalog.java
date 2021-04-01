/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rangepricingapplication.ProductManagement;

import java.util.ArrayList;
import rangepricingapplication.Supplier.Supplier;

/**
 *
 * @author kal bugrara
 */
public class ProductCatalog {
    String type;
    ArrayList<Product> products;
    
    public ProductCatalog(String n){
        type = n;
        products = new ArrayList();
    }
        public ProductCatalog(){
        type = "noname";
        products = new ArrayList();
    }
    public Product newProduct(String name, int fp, int cp, int tp,Supplier supplier){
        Product p = new Product(name, fp, cp, tp, supplier);
        products.add(p);
        
        return p;
    }
    public ProductsReport generatPerformanceReport(){
        ProductsReport productsreport = new ProductsReport();
    
        for(Product p: products){
            productsreport.addProductSummary(new ProductSummary(p));
        }
        return productsreport; 
    }  

    public ArrayList<Product> getProducts() {
        return products;
    }
    
    
}



