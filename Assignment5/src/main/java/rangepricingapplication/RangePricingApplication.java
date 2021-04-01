/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rangepricingapplication;

import com.github.javafaker.Faker;
import java.util.List;
import rangepricingapplication.Business.Business;
import rangepricingapplication.CustomerManagement.CustomerDirectory;
import rangepricingapplication.CustomerManagement.CustomerProfile;
import rangepricingapplication.OrderManagement.MasterOrderList;
import rangepricingapplication.OrderManagement.Order;
import rangepricingapplication.OrderManagement.OrderItem;
import rangepricingapplication.Personnel.EmployeeDirectory;
import rangepricingapplication.Personnel.EmployeeProfile;
import rangepricingapplication.Personnel.EmployeeReport;
import rangepricingapplication.Personnel.EmployeeSummary;
import rangepricingapplication.Personnel.PersonDirectory;
import rangepricingapplication.ProductManagement.Product;
import rangepricingapplication.ProductManagement.ProductCatalog;
import rangepricingapplication.ProductManagement.ProductSummary;
import rangepricingapplication.ProductManagement.ProductsReport;
import rangepricingapplication.Supplier.Supplier;
import rangepricingapplication.Supplier.SupplierDirectory;
import rangepricingapplication.Supplier.SupplierReport;
import rangepricingapplication.Supplier.SupplierSummary;

/**
 *
 * @author kal bugrara
 */
public class RangePricingApplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        
        Business xerox = new Business("Xerox");
        CustomerDirectory customerDirectory = xerox.getCustomerDirectory();
        MasterOrderList masterOrderList = xerox.getMasterOrderList();
        EmployeeDirectory employeeDirectory = xerox.getEmployeeDirectory();
        ProductCatalog productCatalog = xerox.getProductCatalog();
        SupplierDirectory supplierDirectory = xerox.getSupplierDirectory();
        PersonDirectory personDirectory = xerox.getPersonDirectory();
        
        Faker faker = new Faker();

        
        
        
        //add 120 new products from 30 different suppliers;
        
        
        for(int i = 0 ; i < 30; i++){
            Supplier supplier = supplierDirectory.newSupplier(faker.company().name());
            
            for(int j = 0 ; j < 4; j++){
                int floor = faker.number().numberBetween(100, 1000);
                productCatalog.newProduct(faker.commerce().productName(),floor, floor+100, floor+50, supplier);
            }
        }
        
        //create 120 orders, each has 3 orderitems
        
        
        for(int i = 0 ; i < 15; i++){
            EmployeeProfile salesPerson = employeeDirectory.newEmployeeProfile(personDirectory.newPerson(faker.idNumber().ssnValid()));
            CustomerProfile customer = customerDirectory.newCustomerProfile(personDirectory.newPerson(faker.idNumber().ssnValid()));
            
            for(int j = 0 ; j < 8; j++){
                Order o = masterOrderList.newOrder(customer, salesPerson);
                int quantityOne = faker.number().numberBetween(1, 15);
                int quantityTwo = faker.number().numberBetween(1, 15);
                int quantityThree = faker.number().numberBetween(1, 15);
                Product pone = productCatalog.getProducts().get(faker.number().numberBetween(1, 120));
                Product ptwo = productCatalog.getProducts().get(faker.number().numberBetween(1, 120));
                Product pthree = productCatalog.getProducts().get(faker.number().numberBetween(1, 120));
                OrderItem one = o.newOrderItem(pone, quantityOne);
                OrderItem two = o.newOrderItem(ptwo, quantityTwo);
                OrderItem three = o.newOrderItem(pthree, quantityThree);
                one.setActualPrice(faker.number().numberBetween(pone.getFloorPrice(), pone.getCeilingPrice()));
                two.setActualPrice(faker.number().numberBetween(ptwo.getFloorPrice(), ptwo.getCeilingPrice()));
                three.setActualPrice(faker.number().numberBetween(pthree.getFloorPrice(), pthree.getCeilingPrice()));
            }
        }
        
        //generate reports
        ProductsReport pr = productCatalog.generatPerformanceReport();
        EmployeeReport er = employeeDirectory.generatPerformanceReport();
        SupplierReport sr = supplierDirectory.generatPerformanceReport();
        
        
        //Assignment one(1/2): 10 best performing products by sales volume.
        System.out.println("=================Assignment one(1/2)=================");
        List<ProductSummary> topTenProductsBySalesVolume = pr.getTopTenProductsBySalesVolume();
        int numOne = 1;
        for(ProductSummary ps: topTenProductsBySalesVolume){
            System.out.println(numOne +". Product name is "+ps.getName()+", which has sales volume of $"+ps.getSalesVolume());
            numOne++;
        }
        
        //Assignment one(2/2): 10 best performing products by price performance.
        System.out.println("=================Assignment one(2/2)=================");
        pr.getTopTenProductsByPricepPerformance();
        
        List<ProductSummary> topTenProductsByPricepPerformance = pr.getTopTenProductsByPricepPerformance();
        int numTwo = 1;
        for(ProductSummary ps: topTenProductsByPricepPerformance){
            System.out.println(numTwo +". Product name is "+ps.getName()+", which has a price performance of $"+ps.getSalesperformance());
            numTwo++;
        }
        
        
        
        
        //Assignment two(1/2):10 best performing sales people by sales volume.
        System.out.println("=================Assignment two(1/2)=================");
        List<EmployeeSummary> topTenSalesPeopleBySalesVolume = er.getTopTenSalesPersonBySalesVolume();
        int numThree = 1;
        for(EmployeeSummary es: topTenSalesPeopleBySalesVolume){
            System.out.println(numThree +". Employee ID is "+es.getID()+", which has sales volume of $"+es.getSalesVolume());
            numThree++;
        }
        //Assignment two(2/2):10 best performing sales people by price performance.
        System.out.println("=================Assignment two(2/2)=================");
        List<EmployeeSummary> topTenSalesPeopleByPricePerformance = er.getTopTenSalesPersonByPricepPerformance();
        int numFour = 1;
        for(EmployeeSummary es: topTenSalesPeopleByPricePerformance){
            System.out.println(numFour +". Employee ID is "+es.getID()+", which has a price performance of $"+es.getPricePerformance());
            numFour++;
        }
        
        
        
        //Assignment three: 10 largest suppliers by sales volume.
        System.out.println("=================Assignment three)=================");
        List<SupplierSummary> topTenSuppliersBySalesVolume = sr.getTopTenLargestSuppliers();
        int numFive = 1;
        for(SupplierSummary ss: topTenSuppliersBySalesVolume){
            System.out.println(numFive +". Supplier name is "+ss.getName()+", which has sales volume of $"+ss.getSalesVolume());
            numFive++;
        }
    }
    
}
