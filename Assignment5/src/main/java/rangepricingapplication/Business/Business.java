/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rangepricingapplication.Business;

import java.util.ArrayList;
import rangepricingapplication.CustomerManagement.CustomerDirectory;
import rangepricingapplication.OrderManagement.MasterOrderList;
import rangepricingapplication.Personnel.EmployeeDirectory;
import rangepricingapplication.Personnel.PersonDirectory;
import rangepricingapplication.ProductManagement.ProductCatalog;
import rangepricingapplication.Supplier.SupplierDirectory;

/**
 *
 * @author kal bugrara
 */
public class Business {
    String name;
    CustomerDirectory customerDirectory;
    MasterOrderList masterOrderList;
    EmployeeDirectory employeeDirectory;
    
    ProductCatalog productCatalog;
    SupplierDirectory supplierDirectory;
    PersonDirectory personDirectory;
    

    public Business(String name) {
        this.name = name;
        this.personDirectory = new PersonDirectory(this);
        this.customerDirectory = new CustomerDirectory(this);
        this.employeeDirectory = new EmployeeDirectory(this);
        this.masterOrderList = new MasterOrderList(this);
        this.productCatalog = new ProductCatalog(name);
        this.supplierDirectory = new SupplierDirectory(this);
        
    }

    public String getName() {
        return name;
    }

    public CustomerDirectory getCustomerDirectory() {
        return customerDirectory;
    }

    public MasterOrderList getMasterOrderList() {
        return masterOrderList;
    }

    public EmployeeDirectory getEmployeeDirectory() {
        return employeeDirectory;
    }

    public ProductCatalog getProductCatalog() {
        return productCatalog;
    }

    public SupplierDirectory getSupplierDirectory() {
        return supplierDirectory;
    }

    public PersonDirectory getPersonDirectory() {
        return personDirectory;
    }
    
}
