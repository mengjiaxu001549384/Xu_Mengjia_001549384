/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import model.VitalSigns;

/**
 *
 * @author apple
 */
public class Patient {
    
    Person person;
    public VitalSigns currentVitalSigns;
    public ArrayList<VitalSigns> vitalSignHistoryList= new ArrayList<VitalSigns>();;
    
    
    
    public Patient(Person person){
       this.vitalSignHistoryList = vitalSignHistoryList;
       this.person = person;
       this.currentVitalSigns = currentVitalSigns;
       }
    
    public void check(){
            
        if(!this.isPatientNormal(currentVitalSigns)){
            System.out.println(this.person.getName() + "'s vital signs are not normal");
        }else{
            System.out.println(this.person.getName() + "'s vital signs are normal");
        }
    }
    
    public VitalSigns newCheckUp(double age,double respiratoryRate, double heartRate, double systolicBloodPressure, double weightInKilos, double weightInPounds){
        
        VitalSigns newCheckUp = new VitalSigns();
        newCheckUp.setAge(age);
        newCheckUp.setRespiratoryRate(respiratoryRate);
        newCheckUp.setHeartRate(heartRate);
        newCheckUp.setSystolicBloodPressure(systolicBloodPressure);
        newCheckUp.setWeightInKilos(weightInKilos);
        newCheckUp.setWeightInPounds(weightInPounds);
        this.vitalSignHistoryList.add(new VitalSigns(newCheckUp));
        if(weightInPounds < (weightInKilos * 2.1) || weightInPounds > (weightInKilos * 2.3)){
                System.out.println("Attention: wrong input in WeightInPounds or WeightInKilos");
            }
        return newCheckUp;
    }
    
    public boolean isPatientNormal(VitalSigns currentVitalSigns){
      
      if(currentVitalSigns.getAge()== 0){
          if(currentVitalSigns.getRespiratoryRate() < 30
                  ||currentVitalSigns.getRespiratoryRate() > 50
                  ||currentVitalSigns.getHeartRate() < 120
                  ||currentVitalSigns.getHeartRate() > 160
                  ||currentVitalSigns.getSystolicBloodPressure()<50
                  ||currentVitalSigns.getSystolicBloodPressure()>70
                  ||currentVitalSigns.getWeightInKilos() < 2
                  ||currentVitalSigns.getWeightInKilos() > 3
                  ||currentVitalSigns.getWeightInPounds() < 4.5
                  ||currentVitalSigns.getWeightInPounds() > 7
                  ){
          
          return false;
          }
      } else if(currentVitalSigns.getAge() <= 1){
          if(currentVitalSigns.getRespiratoryRate() < 20
                  ||currentVitalSigns.getRespiratoryRate() > 30
                  ||currentVitalSigns.getHeartRate() < 80
                  ||currentVitalSigns.getHeartRate() > 140
                  ||currentVitalSigns.getSystolicBloodPressure()<70
                  ||currentVitalSigns.getSystolicBloodPressure()>100
                  ||currentVitalSigns.getWeightInKilos() < 4
                  ||currentVitalSigns.getWeightInKilos() > 10
                  ||currentVitalSigns.getWeightInPounds() < 9
                  ||currentVitalSigns.getWeightInPounds() > 22
                  ){
          return false;
          }
      }else if(currentVitalSigns.getAge() > 1 & currentVitalSigns.getAge() <= 3){
          if(currentVitalSigns.getRespiratoryRate() < 20
                  ||currentVitalSigns.getRespiratoryRate() > 30
                  ||currentVitalSigns.getHeartRate() < 80
                  ||currentVitalSigns.getHeartRate() > 130
                  ||currentVitalSigns.getSystolicBloodPressure()<80
                  ||currentVitalSigns.getSystolicBloodPressure()>110
                  ||currentVitalSigns.getWeightInKilos() < 10
                  ||currentVitalSigns.getWeightInKilos() > 14
                  ||currentVitalSigns.getWeightInPounds() < 22
                  ||currentVitalSigns.getWeightInPounds() > 31
                  ){
          return false;
          }
      }else if(currentVitalSigns.getAge() > 3 & currentVitalSigns.getAge() <= 5){
          if(currentVitalSigns.getRespiratoryRate() < 20
                  ||currentVitalSigns.getRespiratoryRate() > 30
                  ||currentVitalSigns.getHeartRate() < 80
                  ||currentVitalSigns.getHeartRate() > 120
                  ||currentVitalSigns.getSystolicBloodPressure()<80
                  ||currentVitalSigns.getSystolicBloodPressure()>110
                  ||currentVitalSigns.getWeightInKilos() < 14
                  ||currentVitalSigns.getWeightInKilos() > 18
                  ||currentVitalSigns.getWeightInPounds() < 31
                  ||currentVitalSigns.getWeightInPounds() > 40
                  ){
          return false;
          }
      }else if(currentVitalSigns.getAge() > 5 & currentVitalSigns.getAge() <= 12){
          if(currentVitalSigns.getRespiratoryRate() < 20
                  ||currentVitalSigns.getRespiratoryRate() > 30
                  ||currentVitalSigns.getHeartRate() < 70
                  ||currentVitalSigns.getHeartRate() > 110
                  ||currentVitalSigns.getSystolicBloodPressure()<80
                  ||currentVitalSigns.getSystolicBloodPressure()>120
                  ||currentVitalSigns.getWeightInKilos() < 20
                  ||currentVitalSigns.getWeightInKilos() > 42
                  ||currentVitalSigns.getWeightInPounds() < 41
                  ||currentVitalSigns.getWeightInPounds() > 92
                  ){
          return false;
          }
      }else if(currentVitalSigns.getAge() > 12 & currentVitalSigns.getAge() <= 120){
          if(currentVitalSigns.getRespiratoryRate() < 12
                  ||currentVitalSigns.getRespiratoryRate() > 20
                  ||currentVitalSigns.getHeartRate() < 55
                  ||currentVitalSigns.getHeartRate() > 105
                  ||currentVitalSigns.getSystolicBloodPressure()<110
                  ||currentVitalSigns.getSystolicBloodPressure()>120
                  ||currentVitalSigns.getWeightInKilos() < 50
                  ||currentVitalSigns.getWeightInPounds() < 110
                  ){
          return false;
          }
      } else{
          System.out.println("Age format is Wrong");
          return false;
      }
      
      return true;
    }
    
    public void printHistory(ArrayList<VitalSigns> vitalSignHistoryList){
        System.out.println("Name: " + person.getName());
        
        int i = 1;
        
        for(VitalSigns sign : vitalSignHistoryList){
            System.out.println(i + " time check: ");
            System.out.println("Age:" + sign.getAge());
            System.out.println("Respiratory Rate: " + sign.getRespiratoryRate());
            System.out.println("Heart Rate: " + sign.getHeartRate());
            System.out.println("Systolic Blood Pressure: " + sign.getSystolicBloodPressure());
            System.out.println("Weight In Kilos: " + sign.getWeightInKilos());
            System.out.println("weight In Pounds: " + sign.getWeightInPounds());
            System.out.println("--------------------------------------------");
            i++;
        }
    }
}


