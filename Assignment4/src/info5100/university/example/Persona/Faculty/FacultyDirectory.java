/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.Persona.Faculty;

import info5100.university.example.CourseCatalog.Course;
import info5100.university.example.CourseSchedule.CourseLoad;
import info5100.university.example.CourseSchedule.CourseOffer;
import info5100.university.example.CourseSchedule.CourseSchedule;
import info5100.university.example.CourseSchedule.SeatAssignment;
import info5100.university.example.Persona.*;
import info5100.university.example.Department.Department;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

/**
 *
 * @author kal bugrara
 */
public class FacultyDirectory {

    Department department;
    ArrayList<FacultyProfile> teacherlist;
    

    public FacultyDirectory(Department d) {

        department = d;
        teacherlist = new ArrayList();
        

    }

    public FacultyProfile newFacultyProfile(Person p) {

        FacultyProfile fp = new FacultyProfile(p);
        teacherlist.add(fp);
        return fp;
    }

    public FacultyProfile findTeachingFaculty(String id) {

        for (FacultyProfile sp : teacherlist) {

            if (sp.isMatch(id)) {
                return sp;
            }
        }
            return null; //not found after going through the whole list
    }
    
    public void courseRatingBySemester(CourseSchedule cs){
        
        
        ArrayList<FacultyAssignment> list = new ArrayList<>();
        for(FacultyProfile fp: teacherlist){
            for(FacultyAssignment fa : fp.facultyassignments){
                if(cs.getSchedule().contains(fa.courseoffer)){
                    list.add(fa);
                }
            }
        }
        
        Collections.sort(list);
        for(FacultyAssignment fa: list){
            System.out.println("Faculty ID: "+ fa.getFacultyID()+", Course Name: "+fa.getCourseNumber()+", Average rating is: "+fa.getCourseRating());
            
        }
        
    }
    
}
