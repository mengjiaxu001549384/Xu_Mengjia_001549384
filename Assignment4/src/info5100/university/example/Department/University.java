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
public class University {
    String name;
    ArrayList <College> collegeList;

    public University(String name) {
        this.name = name;
        collegeList = new ArrayList<>();
    }

    public ArrayList<College> getCollegeList() {
        return collegeList;
    }
    
    public College newCollege(String name){
        College c = new College(name);
        collegeList.add(c);
        return c;
    }
    
    public int calculateRevenuesBySemester(String semester){
        int sum = 0;
        for(College c: collegeList){
            sum += c.calculateRevenuesBySemester(semester);
        }
        return sum;
    }
    
    
}
