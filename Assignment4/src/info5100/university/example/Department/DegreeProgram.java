/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.Department;

import info5100.university.example.CourseCatalog.Course;
import java.util.ArrayList;

/**
 *
 * @author apple
 */
public class DegreeProgram {
    String name;
    int requiredCredits;
    ArrayList<Course> coreCourses;
    ArrayList<Course> electiveCourses;

    public DegreeProgram( ) {
        coreCourses = new ArrayList<>();
        electiveCourses = new ArrayList<>();
    }

    public int getRequiredCredits() {
        return requiredCredits;
    }

    public void setRequiredCredits(int requiredCredits) {
        this.requiredCredits = requiredCredits;
    }

    public ArrayList<Course> getCoreCourses() {
        return coreCourses;
    }

    public void setCoreCourses(ArrayList<Course> coreCourses) {
        this.coreCourses = coreCourses;
    }

    public ArrayList<Course> getElectiveCourses() {
        return electiveCourses;
    }

    public void setElectiveCourses(ArrayList<Course> electiveCourses) {
        this.electiveCourses = electiveCourses;
    }
    
    
}
