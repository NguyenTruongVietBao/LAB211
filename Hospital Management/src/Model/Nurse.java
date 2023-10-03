/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author VietBao
 */
public class Nurse extends Person implements Serializable{
    private String staffID;
    private String Department;
    private String Shift;
    private long Salary;
    private ArrayList<Patient> assignedPatients = new ArrayList<>();
    
    public Nurse(){
    }
    
    public Nurse(String staffID, String Department, String Shift, long Salary,
                 String Id, String Name, String Gender, String Address, String Phone, int age) {
        super(Id, Name, Gender, Address, Phone, age);
        this.staffID = staffID;
        this.Department = Department;
        this.Shift = Shift;
        this.Salary = Salary;
    }

    public String getStaffID() {
        return staffID;
    }

    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String Department) {
        this.Department = Department;
    }

    public String getShift() {
        return Shift;
    }

    public void setShift(String Shift) {
        this.Shift = Shift;
    }

    public long getSalary() {
        return Salary;
    }

    public void setSalary(long Salary) {
        this.Salary = Salary;
    }

    public ArrayList<Patient> getAssignedPatients() {
        return assignedPatients;
    }
    
    @Override
    public String toString() {
        return  "StaffID: " + staffID + super.toString() + ", Department: " + Department +
               ", Shift: " + Shift +", Salary: " + Salary;
    }
    
    public void addPatient(Patient patient) {
        assignedPatients.add(patient);
    }
}
