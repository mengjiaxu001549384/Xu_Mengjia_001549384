/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example;

import info5100.university.example.CourseCatalog.Course;
import info5100.university.example.CourseCatalog.CourseCatalog;
import info5100.university.example.CourseSchedule.CourseLoad;
import info5100.university.example.CourseSchedule.CourseOffer;
import info5100.university.example.CourseSchedule.CourseSchedule;
import info5100.university.example.CourseSchedule.SeatAssignment;
import info5100.university.example.Department.College;
import info5100.university.example.Department.DegreeProgram;
import info5100.university.example.Department.Department;
import info5100.university.example.Department.University;
import info5100.university.example.Persona.Faculty.FacultyAssignment;
import info5100.university.example.Persona.Faculty.FacultyDirectory;
import info5100.university.example.Persona.Faculty.FacultyProfile;
import info5100.university.example.Persona.Person;
import info5100.university.example.Persona.PersonDirectory;
import info5100.university.example.Persona.StudentDirectory;
import info5100.university.example.Persona.StudentProfile;
import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class Info5001UniversityExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        University neu = new University("Northeastern University");
        College coe = neu.newCollege("college of engineering");
        
        Department IS = coe.newDepartment("Information Systems");
        Department CS = coe.newDepartment("Computer Science");
        
        CourseCatalog isCoursecatalog = IS.getCourseCatalog();
        CourseCatalog csCoursecatalog = CS.getCourseCatalog();
        
        Course INFO5100 = isCoursecatalog.newCourse("app eng", "info 5100", 4);
        Course INFO6215 = isCoursecatalog.newCourse("bus ana", "info 6215", 4);
        Course CSYE7250 = csCoursecatalog.newCourse("big data", "csye 7250", 4);
        Course CSYE7280 = csCoursecatalog.newCourse("ux design", "csye 7280", 4);
        Course INFO6210 = isCoursecatalog.newCourse("db design", "info 6210", 4);
        Course CSYE7290 = csCoursecatalog.newCourse("Adv design", "csye 7290", 4);
        
        CourseSchedule coursescheduleISF2020 = IS.newCourseSchedule("Fall2020");
        CourseSchedule coursescheduleISS2021 = IS.newCourseSchedule("Spring2021");
        CourseSchedule coursescheduleCSF2020 = CS.newCourseSchedule("Fall2020");
        CourseSchedule coursescheduleCSS2021 = CS.newCourseSchedule("Spring2021");
  
        CourseOffer courseofferF2020Info5100 = coursescheduleISF2020.newCourseOffer("info 5100");
        CourseOffer courseofferF2020Csye7250 = coursescheduleCSF2020.newCourseOffer("csye 7250");
        CourseOffer courseofferS2021Info5100 = coursescheduleISS2021.newCourseOffer("info 5100");
        CourseOffer courseofferS2021Info6215 = coursescheduleISS2021.newCourseOffer("info 6215");
        CourseOffer courseofferS2021Csye7280 = coursescheduleCSS2021.newCourseOffer("csye 7280");
        CourseOffer courseofferS2021Info6210 = coursescheduleISS2021.newCourseOffer("info 6210");
        
        if (courseofferF2020Info5100!=null)
        courseofferF2020Info5100.generatSeats(10);
        
        if (courseofferS2021Info5100!=null)
        courseofferS2021Info5100.generatSeats(10);
        
        if (courseofferS2021Info6215!=null)
        courseofferS2021Info6215.generatSeats(15);
        
        if (courseofferF2020Csye7250!=null)
        courseofferF2020Csye7250.generatSeats(20);
        
        if (courseofferS2021Csye7280!=null)
        courseofferS2021Csye7280.generatSeats(25);
        
        if (courseofferS2021Info6210!=null)
        courseofferS2021Info6210.generatSeats(15);
        
        DegreeProgram isProgram = IS.getDegreeProgram();
        DegreeProgram csProgram = CS.getDegreeProgram();
        
        ArrayList<Course> isProgramCoreCourses = new ArrayList<>();
        isProgramCoreCourses.add(INFO5100);
        isProgram.setCoreCourses(isProgramCoreCourses);
        ArrayList<Course> isElectiveCourses = new ArrayList<>();
        isProgramCoreCourses.add(INFO6210);
        isProgramCoreCourses.add(INFO6215);
        isProgram.setElectiveCourses(isElectiveCourses);
        isProgram.setRequiredCredits(8);
        
        ArrayList<Course> csProgramCoreCourses = new ArrayList<>();
        csProgramCoreCourses.add(CSYE7250);
        csProgram.setCoreCourses(csProgramCoreCourses);
        ArrayList<Course> csElectiveCourses = new ArrayList<>();
        csProgramCoreCourses.add(CSYE7280);
        csProgramCoreCourses.add(CSYE7290);
        csProgram.setElectiveCourses(csElectiveCourses);
        csProgram.setRequiredCredits(12);
        
        //student one
        PersonDirectory ispd = IS.getPersonDirectory();
        Person personOne = ispd.newPerson("0112303");
        StudentDirectory issd = IS.getStudentDirectory();
        StudentProfile studentOne = issd.newStudentProfile(personOne);
        CourseLoad studentOneCourseloadF2020 = studentOne.newCourseLoad("Fall2020"); 
        CourseLoad studentOneCourseloadS2021 = studentOne.newCourseLoad("Spring2021"); 
       
        SeatAssignment studentOneSAINFO5100 = studentOneCourseloadF2020.newSeatAssignment(courseofferF2020Info5100); //register student in class
        SeatAssignment studentOneSAINFO6215 = studentOneCourseloadS2021.newSeatAssignment(courseofferS2021Info6215);
        SeatAssignment studentOneSAINFO6210 = studentOneCourseloadS2021.newSeatAssignment(courseofferS2021Info6210);
        
        studentOneSAINFO5100.setGrade((float) 3.7);
        studentOneSAINFO6215.setGrade((float) 4.0);
        studentOneSAINFO6210.setGrade((float) 4.0);
        studentOneSAINFO5100.setStudentEval(4);
        studentOneSAINFO6215.setStudentEval(4);
        studentOneSAINFO6210.setStudentEval(3);
        
        //student two     
        PersonDirectory cspd = CS.getPersonDirectory();
        Person personTwo = cspd.newPerson("0112404");
        StudentDirectory cssd = CS.getStudentDirectory();
        StudentProfile studentTwo = cssd.newStudentProfile(personTwo);
        CourseLoad studentTwoCourseloadF2020 = studentTwo.newCourseLoad("Fall2020"); 
        CourseLoad studentTwoCourseloadS2021 = studentTwo.newCourseLoad("Spring2021"); 
        
        SeatAssignment studentTwoSACYSE7250 = studentTwoCourseloadF2020.newSeatAssignment(courseofferF2020Csye7250); //register student in class
        SeatAssignment studentTwoSACYSE7280 = studentTwoCourseloadS2021.newSeatAssignment(courseofferS2021Csye7280);
        
        studentTwoSACYSE7250.setGrade((float) 3.3);
        studentTwoSACYSE7280.setGrade((float) 3.0);
        studentTwoSACYSE7250.setStudentEval(5);
        studentTwoSACYSE7280.setStudentEval(4);

        //student three
        Person personThree = ispd.newPerson("0112505");
        StudentProfile studentThree = issd.newStudentProfile(personThree);
        CourseLoad studentThreeCourseloadF2020 = studentThree.newCourseLoad("Fall2020"); 
        CourseLoad studentThreeCourseloadS2021 = studentThree.newCourseLoad("Spring2021"); 
        
        SeatAssignment studentThreeSACYSE7250 = studentThreeCourseloadF2020.newSeatAssignment(courseofferF2020Csye7250); //register student in class
        SeatAssignment studentThreeSAINFO5100 = studentThreeCourseloadS2021.newSeatAssignment(courseofferS2021Info5100);
        
        studentThreeSACYSE7250.setGrade((float) 3.7);
        studentThreeSAINFO5100.setGrade((float) 4.0);
        studentThreeSACYSE7250.setStudentEval(4);
        studentThreeSAINFO5100.setStudentEval(5);
        
        //Faculty One
        Person personFour = ispd.newPerson("111111");
        FacultyDirectory isfd = IS.getFacultydirectory();
        FacultyProfile facultyOne = isfd.newFacultyProfile(personFour);
        FacultyAssignment facultyOneFAINFO5100F = facultyOne.AssignAsTeacher(courseofferF2020Info5100);
        FacultyAssignment facultyOneFAINFO5100S = facultyOne.AssignAsTeacher(courseofferS2021Info5100);
        FacultyAssignment facultyOneFAINFO6210S = facultyOne.AssignAsTeacher(courseofferS2021Info6210);
        
        //Faculty two
        Person personFive = ispd.newPerson("222222");
        FacultyProfile facultyTwo = isfd.newFacultyProfile(personFive);
        FacultyAssignment facultyTwoFAINFO6215S = facultyTwo.AssignAsTeacher(courseofferS2021Info6215);
        
        //Faculty three
        Person personSix = ispd.newPerson("333333");
        FacultyDirectory csfd = CS.getFacultydirectory();
        FacultyProfile facultyThree = csfd.newFacultyProfile(personSix);
        FacultyAssignment facultyThreeFACSYE7250F = facultyThree.AssignAsTeacher(courseofferF2020Csye7250);
        FacultyAssignment facultyThreeFAcsye7280S = facultyThree.AssignAsTeacher(courseofferS2021Csye7280);
        
        //calculate GPA for students
        System.out.println("=================================================================");
        System.out.println("Q1: calculate GPA for three students");
        System.out.println("The total GPA for student one is: "+studentOne.getStudentTotalGPA());
        System.out.println("The total GPA for student two is: "+studentTwo.getStudentTotalGPA());
        System.out.println("The total GPA for student three is: "+studentThree.getStudentTotalGPA());
        System.out.println("=================================================================");
        
        //calculate revenue for department, college, and university
        System.out.println("Q2: calculate total revenue at the college and university levels.");
        int totalOne = IS.calculateRevenuesBySemester("Fall2020");
        System.out.println("Total Revenue for IS Department in Fall 2020: " + totalOne);
        
        int totalTwo = IS.calculateRevenuesBySemester("Spring2021");
        System.out.println("Total Revenue for IS Department in Spring 2021: " + totalTwo);
        
        int totalThree = CS.calculateRevenuesBySemester("Fall2020");
        System.out.println("Total Revenue for CS Department in Fall 2020: " + totalThree);
        
        int totalFour = CS.calculateRevenuesBySemester("Spring2021");
        System.out.println("Total Revenue for CS Department in Spring 2021: " + totalFour);
        
        int totalFive = coe.calculateRevenuesBySemester("Fall2020");
        System.out.println("Total Revenue for College of Engineering in Fall 2020: " + totalFive);
        
        int totalSix = coe.calculateRevenuesBySemester("Spring2021");
        System.out.println("Total Revenue for College of Engineering in Spring 2021: " + totalSix);
        
        int totalSeven = neu.calculateRevenuesBySemester("Fall2020");
        System.out.println("Total Revenue for Northeastern University in Fall 2020: " + totalSeven);
        
        int totalEight = neu.calculateRevenuesBySemester("Spring2021");
        System.out.println("Total Revenue for Northeastern University in Spring 2021: " + totalEight);
        System.out.println("=================================================================");
        
        //List all the teachers and the courses they taught for a given semester
        System.out.println("Q3: List all the teachers and the courses they taught for a given semester");
        System.out.println("List for IS Department in Fall 2020");
        isfd.courseRatingBySemester(coursescheduleISF2020);
        System.out.println("List for IS Department in Spring 2021");
        isfd.courseRatingBySemester(coursescheduleISS2021);
        System.out.println("List for CS Department in Fall 2020");
        csfd.courseRatingBySemester(coursescheduleCSF2020);
        System.out.println("List for CS Department in Spring 2021");
        csfd.courseRatingBySemester(coursescheduleCSS2021);
        System.out.println("=================================================================");
        
        //whether student fulfilled their course graduation requirements
        System.out.println("Q4: whether student fulfilled their course graduation requirements or not");
        
        
        System.out.println("Student ID: "+studentOne.getID()+", fulfill the graduation requirements: " + studentOne.graduate(isProgram));
        System.out.println("Student ID: "+studentTwo.getID()+", fulfill the graduation requirements: " + studentTwo.graduate(csProgram));
        System.out.println("Student ID: "+studentThree.getID()+", fulfill the graduation requirements: " + studentThree.graduate(isProgram));
    }
}
