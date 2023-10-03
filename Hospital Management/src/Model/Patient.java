/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author VietBao
 */
public class Patient extends Person implements Serializable{
    private String Diagnosis;
    private LocalDate admissionDate, dischargeDate;
    private ArrayList<Nurse> nursesAssigned = new ArrayList<>();
    
    public Patient(){       
    }

    public Patient(String Diagnosis, LocalDate admissionDate, LocalDate dischargeDate, String Id, String Name, String Gender, String Address, String Phone, int age) {
        super(Id, Name, Gender, Address, Phone, age);
        this.Diagnosis = Diagnosis;
        this.admissionDate = admissionDate;
        this.dischargeDate = dischargeDate;
    }
    
    
    
    public String getDiagnosis() {
        return Diagnosis;
    }

    public void setDiagnosis(String Diagnosis) {
        this.Diagnosis = Diagnosis;
    }

    public LocalDate getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(LocalDate admissionDate) {
        this.admissionDate = admissionDate;
    }

    public LocalDate getDischargeDate() {
        return dischargeDate;
    }

    public void setDischargeDate(LocalDate dischargeDate) {
        this.dischargeDate = dischargeDate;
    }

    public ArrayList<Nurse> getNursesAssigned() {
        return nursesAssigned;
    }

    public void setNursesAssigned(ArrayList<Nurse> nursesAssigned) {
        this.nursesAssigned = nursesAssigned;
    }

    @Override
    public String toString() {
        return  super.getId() + ", AdmissionDate: " + admissionDate +", FullName: " + super.getName()
                + ", Phone: " + super.getPhone()+ ", Diagnosis: " + Diagnosis  ;
                               
    }
    
    public String toString2() {
        return  super.toString() + ", Diagnosis: " + Diagnosis 
                + ", AdmissionDate: " + admissionDate + ", DischargeDate: " + dischargeDate;
                                        
    }
    
    
    public void addNurseAssigned(Nurse nurse) {
        nursesAssigned.add(nurse);
    }  
}
