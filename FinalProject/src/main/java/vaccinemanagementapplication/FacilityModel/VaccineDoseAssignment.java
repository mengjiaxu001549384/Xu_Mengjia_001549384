/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vaccinemanagementapplication.FacilityModel;

import vaccinemanagementapplication.patient.Appointment;
import vaccinemanagementapplication.vaccine.VaccineDose;

/**
 *
 * @author apple
 */
public class VaccineDoseAssignment {
    VaccineDose vaccineDose;
    Appointment appointment;

    public VaccineDoseAssignment(VaccineDose vaccineDose, Appointment appointment) {
        this.vaccineDose = vaccineDose;
        this.appointment = appointment;
    }
    
    public void assignToAppointment(Appointment ap){
        appointment = ap;
    }

    public VaccineDose getVaccineDose() {
        return vaccineDose;
    }
    
    
    
}
