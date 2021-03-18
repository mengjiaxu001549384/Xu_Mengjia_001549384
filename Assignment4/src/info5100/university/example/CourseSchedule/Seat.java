/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.CourseSchedule;

import info5100.university.example.CourseCatalog.Course;
import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class Seat {
    
    Boolean occupied; 
    int number;
    SeatAssignment seatassignment;
    ArrayList<SeatAssignment> seatassignments;
    CourseOffer courseoffer;
    public Seat (CourseOffer co, int n){
        courseoffer = co;
        number = n;
        occupied = false;
        seatassignments = new ArrayList<>();
        
    }
    
    public Boolean isOccupied(){
        return occupied;

    }
    
    public SeatAssignment newSeatAssignment(CourseLoad cl){
        
        seatassignment = new SeatAssignment(cl, this); //links seatassignment to seat
        seatassignments.add(seatassignment);
        occupied = true;   
        return seatassignment;
    }
    
    public CourseOffer getCourseOffer(){
        return courseoffer;
    }
    
    public int getCourseCredits(){
        return courseoffer.getCreditHours();
    }
    
    public float getStudentEval() {
        return seatassignment.getStudentEval();
    }

    public Course getCourse() {
        return courseoffer.getCourse();
    }

    
}
