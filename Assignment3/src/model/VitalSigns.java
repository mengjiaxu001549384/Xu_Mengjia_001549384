/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author apple
 */
public class VitalSigns {
    private double respiratoryRate;
    private double heartRate;
    private double systolicBloodPressure;
    private double weightInKilos;
    private double weightInPounds;
    private double age;
    
    public boolean isThisVitalSignNormal(String vsign){
        
        if("RespiratoryRate".equals(vsign)){
            double currentVitalSigns = getRespiratoryRate();
            if(age == 0){
                if(currentVitalSigns > 50||currentVitalSigns < 30){
                    System.out.println("Respiratory Rate " + currentVitalSigns + ", which is not normal");
                    return false;
                } else{
                    System.out.println("Respiratory Rate " + currentVitalSigns + ", which is normal");
                }
            } else if(age >=13){
                if(currentVitalSigns > 20||currentVitalSigns < 12){
                    System.out.println("Respiratory Rate " + currentVitalSigns + ", which is not normal");
                    return false;
                }else{
                    System.out.println("Respiratory Rate " + currentVitalSigns + ", which is normal");
                }
            
            } else{
                if(currentVitalSigns > 30||currentVitalSigns < 20){
                    System.out.println("Respiratory Rate " + currentVitalSigns + ", which is not normal");
                    return false;
                }else{
                    System.out.println("Respiratory Rate " + currentVitalSigns + ", which is normal");
                }
            }
        } else if("HeartRate".equals(vsign)){
            double currentVitalSigns = getHeartRate();
            if(age == 0){
                if(currentVitalSigns > 160||currentVitalSigns < 120){
                    System.out.println("Heart Rate "+ currentVitalSigns + ", which is not normal");
                    return false;
                }else{
                    System.out.println("Heart Rate " + currentVitalSigns + ", which is normal");
                }
            } else if(age > 0 && age < 1){
                if(currentVitalSigns > 140||currentVitalSigns < 80){
                    System.out.println("Heart Rate "+ currentVitalSigns + ", which is not normal");
                    return false;
                }else{
                    System.out.println("Heart Rate " + currentVitalSigns + ", which is normal");
                }
            }else if(age >= 1 && age < 3){
                if(currentVitalSigns > 130||currentVitalSigns < 80){
                    System.out.println("Heart Rate "+ currentVitalSigns + ", which is not normal");
                    return false;
                }else{
                    System.out.println("Heart Rate " + currentVitalSigns + ", which is normal");
                }
            } else if(age >=3 && age < 5){
                if(currentVitalSigns > 120||currentVitalSigns < 80){
                    System.out.println("Heart Rate "+ currentVitalSigns + ", which is not normal");
                    return false;
                }else{
                    System.out.println("Heart Rate " + currentVitalSigns + ", which is normal");
                }
            }  else if(age >=5 && age < 12){
                if(currentVitalSigns > 110||currentVitalSigns < 70){
                    System.out.println("Heart Rate "+ currentVitalSigns + ", which is not normal");
                    return false;
                }else{
                    System.out.println("Heart Rate " + currentVitalSigns + ", which is normal");
                }
            } else{
                if(currentVitalSigns > 105||currentVitalSigns < 55){
                    System.out.println("Heart Rate "+ currentVitalSigns + ", which is not normal");
                    return false;
                }else{
                    System.out.println("Heart Rate " + currentVitalSigns + ", which is normal");
                }
            }
        } else if("SystolicBloodPressure".equals(vsign)){
            double currentVitalSigns = getSystolicBloodPressure();
            if(age == 0){
                if(currentVitalSigns > 70||currentVitalSigns < 50){
                    System.out.println("Systolic Blood Pressure " + currentVitalSigns + ", which is not normal");
                    return false;
                }else{
                    System.out.println("Systolic Blood Pressure " + currentVitalSigns + ", which is normal");
                }
            } else if(age > 0 && age < 1){
                if(currentVitalSigns > 100||currentVitalSigns < 70){
                    System.out.println("Systolic Blood Pressure " + currentVitalSigns + ", which is not normal");
                    return false;
                }else{
                    System.out.println("Systolic Blood Pressure " + currentVitalSigns + ", which is normal");
                }
            }else if(age >= 1 && age < 5){
                if(currentVitalSigns > 110||currentVitalSigns < 80){
                    System.out.println("Systolic Blood Pressure " + currentVitalSigns + ", which is not normal");
                    return false;
                }else{
                    System.out.println("Systolic Blood Pressure " + currentVitalSigns + ", which is normal");
                }
            } else if(age >=5 && age < 12){
                if(currentVitalSigns > 120||currentVitalSigns < 80){
                    System.out.println("Systolic Blood Pressure " + currentVitalSigns + ", which is not normal");
                    return false;
                }else{
                    System.out.println("Systolic Blood Pressure " + currentVitalSigns + ", which is normal");
                }
            } else{
                if(currentVitalSigns > 120||currentVitalSigns < 110){
                    System.out.println("Systolic Blood Pressure " + currentVitalSigns + ", which is not normal");
                    return false;
                }else{
                    System.out.println("Systolic Blood Pressure " + currentVitalSigns + ", which is normal");
                }
            }
        }
        else if("WeightInKilos".equals(vsign)){
            double currentVitalSigns = getWeightInKilos();
            if(age == 0){
                if(currentVitalSigns > 3||currentVitalSigns < 2){
                    System.out.println("Weight In Kilos " +currentVitalSigns + ", which is not normal");
                    return false;
                }else{
                    System.out.println("Weight In Kilos " + currentVitalSigns + ", which is normal");
                }
            } else if(age > 0 && age < 1){
                if(currentVitalSigns > 10||currentVitalSigns < 4){
                    System.out.println("Weight In Kilos " +currentVitalSigns + ", which is not normal");
                    return false;
                }else{
                    System.out.println("Weight In Kilos " + currentVitalSigns + ", which is normal");
                }
            }else if(age >= 1 && age < 3){
                if(currentVitalSigns > 14||currentVitalSigns < 10){
                    System.out.println("Weight In Kilos " +currentVitalSigns + ", which is not normal");
                    return false;
                }else{
                    System.out.println("Weight In Kilos " + currentVitalSigns + ", which is normal");
                }
            } else if(age >=3 && age < 5){
                if(currentVitalSigns > 18||currentVitalSigns < 14){
                    System.out.println("Weight In Kilos " +currentVitalSigns + ", which is not normal");
                    return false;
                }else{
                    System.out.println("Weight In Kilos " + currentVitalSigns + ", which is normal");
                }
            } else if(age >=6 && age < 12){
                if(currentVitalSigns > 42||currentVitalSigns < 20){
                    System.out.println("Weight In Kilos " +currentVitalSigns + ", which is not normal");
                    return false;
                }else{
                    System.out.println("Weight In Kilos " + currentVitalSigns + ", which is normal");
                }
            } else{
                if(currentVitalSigns < 50){
                    System.out.println("Weight In Kilos " +currentVitalSigns + ", which is not normal");
                    return false;
                }else{
                    System.out.println("Weight In Kilos " + currentVitalSigns + ", which is normal");
                }
            }
        } else if("WeightInPounds".equals(vsign)){
            double currentVitalSigns = getWeightInPounds();
            if(age == 0){
                if(currentVitalSigns > 7||currentVitalSigns < 4.5){
                    System.out.println("Weight In Pounds " +currentVitalSigns + ", which is not normal");
                    return false;
                }else{
                    System.out.println("Weight In Pounds " + currentVitalSigns + ", which is normal");
                }
            } else if(age > 0 && age < 1){
                if(currentVitalSigns > 22||currentVitalSigns < 9){
                    System.out.println("Weight In Pounds " +currentVitalSigns + ", which is not normal");
                    return false;
                }else{
                    System.out.println("Weight In Pounds " + currentVitalSigns + ", which is normal");
                }
            }else if(age >= 1 && age < 3){
                if(currentVitalSigns > 31||currentVitalSigns < 22){
                    System.out.println("Weight In Pounds " +currentVitalSigns + ", which is not normal");
                    return false;
                }else{
                    System.out.println("Weight In Pounds " + currentVitalSigns + ", which is normal");
                }
            } else if(age >=3 && age < 5){
                if(currentVitalSigns > 40||currentVitalSigns < 31){
                    System.out.println("Weight In Pounds " +currentVitalSigns + ", which is not normal");
                    return false;
                }else{
                    System.out.println("Weight In Pounds " + currentVitalSigns + ", which is normal");
                }
            } else if(age >=6 && age < 12){
                if(currentVitalSigns > 92||currentVitalSigns < 41){
                    System.out.println("Weight In Pounds " +currentVitalSigns + ", which is not normal");
                    return false;
                } else{
                    System.out.println("Weight In Pounds " + currentVitalSigns + ", which is normal");
                }
            } else{
                if(currentVitalSigns < 110){
                    System.out.println("Weight In Pounds " +currentVitalSigns + ", which is not normal");
                    return false;
                }else{
                    System.out.println("Weight In Pounds " + currentVitalSigns + ", which is normal");
                }
            }
        } else{
        System.out.println("Wrong input");
        return false;
        }
        return true;
    }
          

    public VitalSigns() {
    }

    public VitalSigns(VitalSigns vitalSigns) {
        this.respiratoryRate = vitalSigns.respiratoryRate;
        this.heartRate = vitalSigns.heartRate;
        this.systolicBloodPressure = vitalSigns.systolicBloodPressure;
        this.weightInKilos = vitalSigns.weightInKilos;
        this.weightInPounds = vitalSigns.weightInPounds;
    }

    public double getRespiratoryRate() {
        return respiratoryRate;
    }

    public void setRespiratoryRate(double respiratoryRate) {
        this.respiratoryRate = respiratoryRate;
    }

    public double getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(double heartRate) {
        this.heartRate = heartRate;
    }

    public double getSystolicBloodPressure() {
        return systolicBloodPressure;
    }

    public void setSystolicBloodPressure(double systolicBloodPressure) {
        this.systolicBloodPressure = systolicBloodPressure;
    }

    public double getWeightInKilos() {
        return weightInKilos;
    }

    public void setWeightInKilos(double weightInKilos) {
        this.weightInKilos = weightInKilos;
    }

    public double getWeightInPounds() {
        return weightInPounds;
    }

    public void setWeightInPounds(double weightInPounds) {
        this.weightInPounds = weightInPounds;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public VitalSigns(double respiratoryRate, double heartRate, double systolicBloodPressure, double weightInKilos, double weightInPounds, double age) {
        this.respiratoryRate = respiratoryRate;
        this.heartRate = heartRate;
        this.systolicBloodPressure = systolicBloodPressure;
        this.weightInKilos = weightInKilos;
        this.weightInPounds = weightInPounds;
        this.age = age;
    }
    
    
    
}
