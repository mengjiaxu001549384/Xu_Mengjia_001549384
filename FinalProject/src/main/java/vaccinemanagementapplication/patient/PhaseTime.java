/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vaccinemanagementapplication.patient;

import java.time.LocalDate;
import vaccinemanagementapplication.System.VaccineManagementSystem;

/**
 *
 * @author apple
 */
public class PhaseTime {
    LocalDate firstPhase;
    LocalDate secondPhase;
    LocalDate thirdPhase;
    VaccineManagementSystem vaccineManagementSystem;
    

    public PhaseTime(LocalDate firstPhase, LocalDate secondPhase, LocalDate thirdPhase) {
        this.firstPhase = firstPhase;
        this.secondPhase = secondPhase;
        this.thirdPhase = thirdPhase;
    }

    public PhaseTime(LocalDate firstPhase, LocalDate secondPhase, LocalDate thirdPhase, VaccineManagementSystem vaccineManagementSystem) {
        this.firstPhase = firstPhase;
        this.secondPhase = secondPhase;
        this.thirdPhase = thirdPhase;
        this.vaccineManagementSystem = vaccineManagementSystem;
    }
    
    
}
