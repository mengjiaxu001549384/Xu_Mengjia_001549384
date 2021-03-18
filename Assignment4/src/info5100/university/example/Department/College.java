/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.Department;

import java.util.ArrayList;


/**
 *
 * @author apple
 */
public class College {
    String name;
    ArrayList <Department> departmentList;

    public College(String n) {
        name = n;
        departmentList = new ArrayList();
    }

    public ArrayList<Department> getDepartmentList() {
        return departmentList;
    }
    
    public Department newDepartment(String name){
        Department d = new Department(name);
        departmentList.add(d);
        return d;
    }
    
    public int calculateRevenuesBySemester(String semester){
        int sum = 0;
        for(Department d: departmentList){
            sum += d.calculateRevenuesBySemester(semester);
        }
        return sum;
    }

}
