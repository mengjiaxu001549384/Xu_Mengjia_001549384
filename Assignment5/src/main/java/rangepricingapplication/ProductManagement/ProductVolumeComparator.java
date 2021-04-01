/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rangepricingapplication.ProductManagement;

import java.util.Comparator;

/**
 *
 * @author apple
 */
public class ProductVolumeComparator implements Comparator<ProductSummary> {

    @Override
    public int compare(ProductSummary o1, ProductSummary o2) {
        if(o1.getSalesVolume()!= o2.getSalesVolume()){
            return (-1) * (o1.getSalesVolume()-o2.getSalesVolume());
        }
        return o1.getName().compareTo(o2.getName());
    }
    
}
