/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.Persona.Faculty;

import info5100.university.example.CourseSchedule.CourseOffer;
import info5100.university.example.CourseSchedule.CourseSchedule;

/**
 *
 * @author kal bugrara
 */
public class FacultyAssignment implements Comparable<FacultyAssignment>{
    
    CourseOffer courseoffer;
    FacultyProfile facultyprofile;
    
    public FacultyAssignment(FacultyProfile fp, CourseOffer co){
        courseoffer = co;
        facultyprofile = fp;
    }
    
    public FacultyProfile getFacultyProfile(){
        return facultyprofile;
    }
    
    public Float getCourseRating(){
        float res = this.courseoffer.getCourseRating();
        return res;
    }

    public String getCourseNumber() {
        return courseoffer.getCourseNumber();
    }
    
    public String getFacultyID(){
        return facultyprofile.getFacultyID();
    }
    
    
    
    @Override
    public int compareTo(FacultyAssignment other) {
        return Float.compare(other.getCourseRating(), getCourseRating());
    }  

    
}
