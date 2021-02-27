/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainclass;

import java.util.ArrayList;
import model.VitalSigns;
import model.Patient;
import model.Person;

/**
 *
 * @author apple
 */
public class Main {
    public static void main(String[] args){
        System.out.println("=============================instance one=================================");
        
        
        // James Smith registered at the reception
        
        Person smith = new Person("James Smith");
        Patient one = new Patient(smith);
        
        // smith did the first check up
        one.currentVitalSigns = one.newCheckUp(25,17,78,110,52,114.4);
        
        //use isPatientNormal() method to check vital signs
        
        one.check();
        
        //patient smith took the second check up
        
        one.currentVitalSigns = one.newCheckUp(25,18,80,110,50,110);
        one.check();
        
        //patient smith took the third check up
        
        one.currentVitalSigns = one.newCheckUp(25,17, 83, 110, 52,114.4);
        one.check();
        
        //patient smith took the fourth check up
        
        one.currentVitalSigns = one.newCheckUp(26,33, 83, 110, 49, 107.8);
        one.check();
        
        //use isThisVitalSignNormal() method to check vital signs
        
        one.currentVitalSigns.isThisVitalSignNormal("RespiratoryRate");
        one.currentVitalSigns.isThisVitalSignNormal("HeartRate");
        one.currentVitalSigns.isThisVitalSignNormal("SystolicBloodPressure");
        one.currentVitalSigns.isThisVitalSignNormal("WeightInKilos");
        one.currentVitalSigns.isThisVitalSignNormal("WeightInPounds");
        
        //patient smith looked into patient profile for his vital signs history
        
        System.out.println("====================" + smith.getName()+"====================");
        
        one.printHistory(one.vitalSignHistoryList);
        
        
        System.out.println("=============================instance two=================================");
        
        // Mary Johnson registered at the reception
        
        Person mary = new Person("Mary Johnson");
        Patient two = new Patient(mary);
        
        // Mary did the first check up
        two.currentVitalSigns = two.newCheckUp(8,23,74,100,30,66);
        
        //use isPatientNormal() method to check vital signs
        
        two.check();
        
        //patient Mary took the second check up
        
        two.currentVitalSigns = two.newCheckUp(8,24,78,110,34,74.8);
        two.check();
        
        //patient Mary took the third check up
        
        two.currentVitalSigns = two.newCheckUp(8,24,78,90,34,74.8);
        two.check();
        
        //patient Mary took the fourth check up
        
        two.currentVitalSigns = two.newCheckUp(8,24,78,110,45,99);
        two.check();
        
        //use isThisVitalSignNormal() method to check vital signs
        
        two.currentVitalSigns.isThisVitalSignNormal("RespiratoryRate");
        two.currentVitalSigns.isThisVitalSignNormal("HeartRate");
        two.currentVitalSigns.isThisVitalSignNormal("SystolicBloodPressure");
        two.currentVitalSigns.isThisVitalSignNormal("WeightInKilos");
        two.currentVitalSigns.isThisVitalSignNormal("WeightInPounds");
        
        //patient Mary looked into patient profile for his vital signs history
        
        System.out.println("====================" + mary.getName()+"====================");
        
        two.printHistory(two.vitalSignHistoryList);
    
    
        System.out.println("=============================instance three=================================");
        
        // Robert Williams registered at the reception
        
        Person robert= new Person("Robert Williams");
        Patient three = new Patient(robert);
        
        // Robert did the first check up
        three.currentVitalSigns = three.newCheckUp(4,25,82,90,15,33);
        
        //use isPatientNormal() method to check vital signs
        
        three.check();
        
        //patient Robert took the second check up
        
        three.currentVitalSigns = three.newCheckUp(4,28,84,90,15,33);
        three.check();
        
        //patient Robert took the third check up
        
        three.currentVitalSigns = three.newCheckUp(4,24,81,110,15,33);
        three.check();
        
        //patient Robert took the fourth check up
        
        three.currentVitalSigns = three.newCheckUp(4,33,125,120,18,39.6);
        three.check();
        
        //use isThisVitalSignNormal() method to check vital signs
        
        three.currentVitalSigns.isThisVitalSignNormal("RespiratoryRate");
        three.currentVitalSigns.isThisVitalSignNormal("HeartRate");
        three.currentVitalSigns.isThisVitalSignNormal("SystolicBloodPressure");
        three.currentVitalSigns.isThisVitalSignNormal("WeightInKilos");
        three.currentVitalSigns.isThisVitalSignNormal("WeightInPounds");
        
        //patient Robert looked into patient profile for his vital signs history
        
        System.out.println("====================" + robert.getName()+"====================");
        
        three.printHistory(three.vitalSignHistoryList);
        
        System.out.println("=============================instance four=================================");
        
        // Jennifer Brown registered at the reception
        
        Person jennifer= new Person("Jennifer Brown");
        Patient four = new Patient(jennifer);
        
        // Jennifer did the first check up
        four.currentVitalSigns = four.newCheckUp(2,26,82,90,10,22);
        
        //use isPatientNormal() method to check vital signs
        
        four.check();
        
        //patient Jennifer took the second check up
        
        four.currentVitalSigns = four.newCheckUp(2,28,84,90,12,26.4);
        four.check();
        
        //patient Jennifer took the third check up
        
        four.currentVitalSigns = four.newCheckUp(2,24,81,110,12,26.4);
        four.check();
        
        //patient Jennifer took the fourth check up
        
        four.currentVitalSigns = four.newCheckUp(2,33,130,120,12,26.4);
        four.check();
        
        //use isThisVitalSignNormal() method to check vital signs
        
        four.currentVitalSigns.isThisVitalSignNormal("RespiratoryRate");
        four.currentVitalSigns.isThisVitalSignNormal("HeartRate");
        four.currentVitalSigns.isThisVitalSignNormal("SystolicBloodPressure");
        four.currentVitalSigns.isThisVitalSignNormal("WeightInKilos");
        four.currentVitalSigns.isThisVitalSignNormal("WeightInPounds");
        
        //patient Jennifer looked into patient profile for his vital signs history
        
        System.out.println("====================" + jennifer.getName()+"====================");
        
        four.printHistory(four.vitalSignHistoryList);
        
        System.out.println("=============================instance five=================================");
        
        // Michael Miller registered at the reception
        
        Person michael= new Person("Michael Miller");
        Patient five = new Patient(michael);
        
        // Michael did the first check up
        five.currentVitalSigns = five.newCheckUp(0.5,26,82,90,5,11);
        
        //use isPatientNormal() method to check vital signs
        
        five.check();
        
        //patient Michael took the second check up
        
        five.currentVitalSigns = five.newCheckUp(0.5,28,84,90,5,11);
        five.check();
        
        //patient Michael took the third check up
        
        five.currentVitalSigns = five.newCheckUp(0.5,24,81,70,5,11);
        five.check();
        
        //patient Michael took the fiveth check up
        
        five.currentVitalSigns = five.newCheckUp(0.5,33,130,80,8,17.6);
        five.check();
        
        //use isThisVitalSignNormal() method to check vital signs
        
        five.currentVitalSigns.isThisVitalSignNormal("RespiratoryRate");
        five.currentVitalSigns.isThisVitalSignNormal("HeartRate");
        five.currentVitalSigns.isThisVitalSignNormal("SystolicBloodPressure");
        five.currentVitalSigns.isThisVitalSignNormal("WeightInKilos");
        five.currentVitalSigns.isThisVitalSignNormal("WeightInPounds");
        
        //patient Michael looked into patient profile for his vital signs history
        
        System.out.println("====================" + michael.getName()+"====================");
        
        five.printHistory(five.vitalSignHistoryList);
        
        System.out.println("=============================instance six=================================");
        
        // Linda Davis registered at the reception
        
        Person linda= new Person("Linda Davis");
        Patient six = new Patient(linda);
        
        // Linda did the first check up
        six.currentVitalSigns = six.newCheckUp(0,47,130,66,3,6.6);
        
        //use isPatientNormal() method to check vital signs
        
        six.check();
        
        //patient Linda took the second check up
        
        six.currentVitalSigns = six.newCheckUp(0,45,145,64,3,6.6);
        six.check();
        
        //patient Linda took the third check up
        
        six.currentVitalSigns = six.newCheckUp(0,43,157,67,3,6.6);
        six.check();
        
        //patient Linda took the sixth check up
        
        six.currentVitalSigns = six.newCheckUp(0,42,167,68,3,6.6);
        six.check();
        
        //use isThisVitalSignNormal() method to check vital signs
        
        six.currentVitalSigns.isThisVitalSignNormal("RespiratoryRate");
        six.currentVitalSigns.isThisVitalSignNormal("HeartRate");
        six.currentVitalSigns.isThisVitalSignNormal("SystolicBloodPressure");
        six.currentVitalSigns.isThisVitalSignNormal("WeightInKilos");
        six.currentVitalSigns.isThisVitalSignNormal("WeightInPounds");
        
        //patient Linda looked into patient profile for his vital signs history
        
        System.out.println("====================" + linda.getName()+"====================");
        
        six.printHistory(six.vitalSignHistoryList);

    }

}
