/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rangepricingapplication.ProductManagement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author kal bugrara
 */
public class ProductsReport {
 
    ArrayList<ProductSummary> productsummarylist;
    
    public ProductsReport(){
       productsummarylist = new ArrayList<>(); 
    }
    public void addProductSummary(ProductSummary ps){
    productsummarylist.add(ps);
    
}
    
    public ProductSummary getTopProductAboveTarget(){
        ProductSummary currenttopproduct = null;
        
        for (ProductSummary ps: productsummarylist){
            if(currenttopproduct == null)currenttopproduct = ps; // initial step 
            else if(currenttopproduct.getNumberAboveTarget()<= ps.getNumberAboveTarget()){
                currenttopproduct = ps; //we have a new higher total
            }
        
                }
        return currenttopproduct;
    }
    
    public List<ProductSummary> getTopTenProductsBySalesVolume(){
        List<ProductSummary> res = new ArrayList<>();
        Collections.sort(productsummarylist, new ProductVolumeComparator());
        for(int i = 0; i < 10; i++){
            res.add(productsummarylist.get(i));
        }
        return res;
    }
    
    public List<ProductSummary> getTopTenProductsByPricepPerformance(){
        List<ProductSummary> res = new ArrayList<>();
        Collections.sort(productsummarylist, new ProductPriceComparator());
        for(int i = 0; i < 10; i++){
            res.add(productsummarylist.get(i));
        }
        return res;
    }
    
    
    
    
}
