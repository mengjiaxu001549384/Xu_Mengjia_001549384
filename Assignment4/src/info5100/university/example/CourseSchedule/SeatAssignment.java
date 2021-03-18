/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.CourseSchedule;

import info5100.university.example.CourseCatalog.Course;

/**
 *
 * @author kal bugrara
 */
public class SeatAssignment {
    float grade; //(Letter grade mappings: A=4.0, A-=3.7, B+=3.3, B=3.0, )
    Seat seat;
    CourseLoad courseload;
    float studentEval;
    
    public SeatAssignment(CourseLoad cl, Seat s){
        seat = s;
        courseload = cl;
    }
     
    public void assignSeatToStudent(CourseLoad cl){
        courseload = cl;
    }
    
    public int getCreditHours(){
        return seat.getCourseCredits();
       
    }
    
    public float GetCourseStudentScore(){
        return getCreditHours()*grade;
    }

    public float getGrade() {
        return grade;
    }

    public void setGrade(float f) {
        this.grade = f;
    }

    public float getStudentEval() {
        return studentEval;
    }

    public void setStudentEval(float studentEval) {
        this.studentEval = studentEval;
    }

    public Course getCourse() {
        return seat.getCourse();
    }
    
    

}
