/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.Persona;

import info5100.university.example.CourseCatalog.Course;
import info5100.university.example.CourseSchedule.CourseLoad;
import info5100.university.example.Department.DegreeProgram;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author kal bugrara
 */
public class Transcript {
    
    StudentProfile student;
    HashMap<String, CourseLoad> courseloadlist;
    DegreeProgram degreeProgram;
    
    CourseLoad currentcourseload;
    
    public Transcript(StudentProfile sp){
        student = sp;
        courseloadlist = new HashMap<String, CourseLoad>();
        degreeProgram = new DegreeProgram();
    }
    
    public CourseLoad newCourseLoad(String sem){
        
        currentcourseload = new CourseLoad(sem);
        courseloadlist.put(sem, currentcourseload);
        return currentcourseload;
    }
    
    public CourseLoad getCurrentCourseLoad(){
        
        return currentcourseload;
        
    }
        public CourseLoad getCourseLoadBySemester(String semester){
        
        return courseloadlist.get(semester);
        
    }
    public float getStudentTotalScore(){
            
        float sum = 0;
 
        for( CourseLoad cl: courseloadlist.values()){
            sum = sum + cl.getSemesterScore();
                
        }
        return sum;
    }
        
    public int getTotalCreditHours(){
        int total = 0;
 
        for( CourseLoad cl: courseloadlist.values()){
            total = total + cl.getCreditHours();
                
        }
        return total;
    }
        
    public float getTotalGPA(){
            
        float gpa = this.getStudentTotalScore()/this.getTotalCreditHours();
        return gpa;
    }
    
    public ArrayList<Course> getCourseList(){
        ArrayList<Course> courseList = new ArrayList<>();
        for( CourseLoad cl: courseloadlist.values()){
            for(Course co: cl.getCourseList()){
                courseList.add(co);
            }
        }
        return courseList;
    }
    
    public boolean graduate(DegreeProgram dp){
        int count = 0;
        for(Course co: dp.getCoreCourses()){
                if(!this.getCourseList().contains(co)){
                    return false;
                } else{
                    count += co.getCredits();
                }
        }
        for(Course co: dp.getElectiveCourses()){
            if(this.getCourseList().contains(co)){
                count += co.getCredits();
            }
        }
        if(count < dp.getRequiredCredits()){
            return false;
        }
        return true;
    }
        
}
