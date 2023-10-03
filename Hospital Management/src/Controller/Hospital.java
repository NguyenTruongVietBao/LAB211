/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import static Controller.Validation.checkInputString;
import Model.Nurse;
import Model.Patient;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.zip.DataFormatException;

/**
 *
 * @author VietBao
 */
public class Hospital {
    private HashMap<String, Patient> patientMap = new HashMap<>();
    private HashMap<String, Nurse> nurseMap = new HashMap<>();

    public Hospital() {
    }

    public Hospital(HashMap<String, Patient> patientMap, HashMap<String, Nurse> nurseMap) {
        this.patientMap = patientMap;
        this.nurseMap = nurseMap;
    }    
    
    public void createNurse(){  
        System.out.print("Enter StaffID: ");
        String staffID = Validation.checkInputString();
            //check Exists ID
            if (nurseMap.containsKey(staffID)) {
                System.err.println("Nurse with staffID: " + staffID + " already exists.");
                return;
            }
        System.out.print("Enter Name: ");
        String Name = Validation.checkInputString();
        System.out.print("Enter Age: ");
        int Age = Validation.checkInputInt();
        System.out.print("Enter Gender: ");
        String Gender = Validation.checkInputString();
        System.out.print("Enter Address: ");
        String Address = Validation.checkInputString();
        System.out.print("Enter Phone: ");
        String Phone = Validation.checkInputPhone();
        System.out.print("Enter Department: ");
        String Department = Validation.checkInputDepartment();
        System.out.print("Enter Shift: ");
        String Shift = Validation.checkInputString();
        System.out.print("Enter Salary: ");
        long Salary = (long) Validation.checkInputSalary();                  
        Nurse yta = new Nurse(staffID, Department, Shift, Salary, null, Name, Gender, Address, Phone, Age);
        nurseMap.put(staffID, yta);
        System.out.println("Nurse created successfully.");     
    }            

    public void findNurse() {
        System.out.print("Enter the nurse's name or part of the name: "); 
        String name = Validation.checkInputString();
        boolean nurseFound = false;
        System.out.println("Nurse found:");
        for (Nurse value : nurseMap.values()) {
            if(value.getName().toUpperCase().contains(name.toUpperCase())){
                System.out.println(value);
                nurseFound = true;
            }
        }
        if (!nurseFound) {
            System.err.println("The nurse does not exist.");
        }
    }   
    
    public void updateNurse() {
        System.out.print("Enter StaffID you want to update: ");
        String staffID = Validation.checkInputString();      
        if (nurseMap.containsKey(staffID)) {
            Nurse nurse = nurseMap.get(staffID);
            System.out.print("Enter new Name: ");
            String Name = Validation.checkInputString();
            System.out.print("Enter new Age: ");
            int Age = Validation.checkInputInt();
            System.out.print("Enter new Gender: ");
            String Gender = Validation.checkInputString();
            System.out.print("Enter new Address: ");
            String Address = Validation.checkInputString();
            System.out.print("Enter new Phone: ");
            String Phone = Validation.checkInputPhone();
            System.out.print("Enter new Department: ");
            String Department = Validation.checkInputDepartment();
            System.out.print("Enter new Shift: ");
            String Shift = Validation.checkInputString();
            System.out.print("Enter new Salary: ");
            long Salary = (long) Validation.checkInputSalary();
                nurse.setName(Name);
                nurse.setAge(Age);
                nurse.setGender(Gender);
                nurse.setAddress(Address);
                nurse.setPhone(Phone);
                nurse.setDepartment(Department);
                nurse.setShift(Shift);
                nurse.setSalary((long) Salary);
                System.out.println("Succesfull");
        } else {
            System.err.println("The nurse does not exist.");
        }
    }
    
    private boolean nurseHasAssignedPatients(Nurse nurse) {
        for (Patient patient : patientMap.values()) {
            if (patient.getNursesAssigned().contains(nurse)) {
                return true;
            }
        }
        return false;
    }
    public void deleteNurse() {
        System.out.print("Enter StaffID you want to delete: ");
        String staffID = Validation.checkInputString();      
        if (nurseMap.containsKey(staffID)) {
            Nurse nurse = nurseMap.get(staffID);         
            // check nurse assigned patients or not
            if (nurseHasAssignedPatients(nurse)) {
                System.err.println("Cannot delete the nurse. The nurse has assigned patients.");
                return;
            }
            // check sure to delete
            System.out.println("Are you sure you want to delete the nurse? (Y/N)");
            String confirm = Validation.checkInputString();
                if (confirm.equalsIgnoreCase("Y")) {
                    nurseMap.remove(staffID);   
                    System.out.println("Nurse deleted successfully.");
                } else if (confirm.equalsIgnoreCase("N")) {
                    System.out.println("Deletion canceled.");
                }           
        } else {
            System.err.println("The nurse does not exist.");
        }
    }    
    
    public void addPatient(){
        System.out.print("Enter ID: ");
        String ID = Validation.checkInputString();  
            //check Exists ID
            if (patientMap.containsKey(ID)) {
                System.out.println("Nurse with staffID " + ID + " already exists.");
                return;
            }
        System.out.print("Enter Name: ");
        String Name = Validation.checkInputString();
        System.out.print("Enter Age: ");
        int Age = Validation.checkInputInt();
        System.out.print("Enter Gender: ");
        String Gender = Validation.checkInputString();
        System.out.print("Enter Address: ");
        String Address = Validation.checkInputString();
        System.out.print("Enter Phone: ");
        String Phone = Validation.checkInputPhone();
        System.out.print("Enter Diagnosis: ");
        String Diagnosis = Validation.checkInputString();
        DateTimeFormatter form = DateTimeFormatter.ofPattern("d/M/yyyy");
        System.out.print("Enter Admission Date: ");
        String admissionDate = Validation.checkDate();
        LocalDate ad = LocalDate.parse(admissionDate, form);
        System.out.print("Enter Discharge Date: ");
        String dischargeDate = Validation.checkDate();
        LocalDate dd = LocalDate.parse(dischargeDate, form);
        
        HashSet<Nurse> availableNurses = new HashSet<>();         
        //khong con y ta nao
        if (availableNurses.isEmpty()) {
            System.err.println("No available nurses to assign. Please add Nurse later");
            Patient benhnhan = new Patient(Diagnosis, ad, dd, ID, Name,
                                        Gender, Address, Phone, Age);
            patientMap.put(ID, benhnhan);
            return;
        }     
        // Nurse cham soc <=2
        for (Map.Entry<String, Nurse> entry : nurseMap.entrySet()) {
            Nurse nurse = entry.getValue();
            if (nurse.getAssignedPatients().size() < 2) {       // da cham soc > 2 benh nhan thi kh add
                availableNurses.add(nurse);
            }
        }
        //Cac y ta co the cham soc
        System.out.println("Available Nurses:");
        for (Nurse nurse : availableNurses) {
            System.out.println("Staff ID: " + nurse.getStaffID() + ", Name: " + nurse.getName());
        }
        //Tao va Add patient
        Patient benhnhan = new Patient(Diagnosis, ad, dd, ID, Name,
                                        Gender, Address, Phone, Age);
        patientMap.put(ID, benhnhan);      
        // Them yta and kiem tra yta co ton tai hay k
        System.out.print("Select Nurse 1 (Staff ID): ");
        String nurse1ID = Validation.checkInputString();
        if (!availableNurses.contains(nurseMap.get(nurse1ID))) {
            System.out.println("Invalid nurse selection. Please try again.");
            return;
        } else {
            Nurse nurse1 = nurseMap.get(nurse1ID);
            benhnhan.addNurseAssigned(nurse1);
            nurse1.addPatient(benhnhan);
        }
        if (availableNurses.size() < 2) {
            System.out.println("Patient added successfully.");
        }else {
            System.out.print("Select Nurse 2 (Staff ID): ");
            String nurse2ID = Validation.checkInputString();
            if (!availableNurses.contains(nurseMap.get(nurse2ID))) {
                System.out.println("Invalid nurse selection. Please try again.");
                return;
            } else if (nurse2ID.equalsIgnoreCase(nurse1ID)) {
                System.err.println("Can not same NurseAssign");
                return;
            } else {
                Nurse nurse2 = nurseMap.get(nurse2ID);
                benhnhan.addNurseAssigned(nurse2);
                nurse2.addPatient(benhnhan);
            }
            System.out.println("Patient added successfully.");
        }       
    }
    
    public void addNurseAssign(){
        System.out.print("Enter Patient ID: ");
        String ID = Validation.checkInputString();  
        //check Exists ID
        if (patientMap.containsKey(ID)) {
            // Nurse cham soc <=2
            HashSet<Nurse> availableNurses = new HashSet<>();  
            for (Map.Entry<String, Nurse> entry : nurseMap.entrySet()) {
                Nurse nurse = entry.getValue();
                if (nurse.getAssignedPatients().size() < 2) {
                    availableNurses.add(nurse);
                }
            }          
            //khong con y ta nao
            if (availableNurses.isEmpty()) {
                System.err.println("No available nurses to assign. Please add Nurse later");
                return;
            }            
            //Cac y ta co the cham soc
            System.out.println("Available Nurses:");
            for (Nurse nurse : availableNurses) {
                System.out.println("Staff ID: " + nurse.getStaffID() + ", Name: " + nurse.getName());
            }           
            //Tao va Add patient
            Patient benhnhan = new Patient();
            patientMap.put(ID, benhnhan);
            // Them yta and kiem tra yta co ton tai hay k   
            System.out.print("Select Nurse 1 (Staff ID): ");
            String nurse1ID = Validation.checkInputString();
            if (!availableNurses.contains(nurseMap.get(nurse1ID))) {
                System.out.println("Invalid nurse selection. Please try again.");
                return;
            } else {
                Nurse nurse1 = nurseMap.get(nurse1ID);
                benhnhan.addNurseAssigned(nurse1);
                nurse1.addPatient(benhnhan);
            }
            if (availableNurses.size() < 2) {
                System.out.println("Patient added successfully.");
            } else {
                System.out.print("Select Nurse 2 (Staff ID): ");
                String nurse2ID = Validation.checkInputString();
                if (!availableNurses.contains(nurseMap.get(nurse2ID))) {
                    System.out.println("Invalid nurse selection. Please try again.");
                    return;
                } else if (nurse2ID.equalsIgnoreCase(nurse1ID)) {
                    System.err.println("Can not same StaffID");
                    return;
                } else {
                    Nurse nurse2 = nurseMap.get(nurse2ID);
                    benhnhan.addNurseAssigned(nurse2);
                    nurse2.addPatient(benhnhan);
                }
                System.out.println("Nurse added successfully.");
            }
        }else{
            System.err.println("PatientID not exist");
        }
    }
    
    public void displayPatient() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
        System.out.print("Enter start date (dd/MM/yyyy): ");
        String startDateStr = Validation.checkInputString();
        LocalDate startDate = LocalDate.parse(startDateStr, formatter);
        System.out.print("Enter end date (dd/MM/yyyy): ");
        String endDateStr = Validation.checkInputString();
        LocalDate endDate = LocalDate.parse(endDateStr, formatter);

        List<Patient> patientsInRange = new ArrayList<>();
        int count = 0;
        for (Patient patient : patientMap.values()) {
            LocalDate admissionDate = patient.getAdmissionDate();
            // start <= x <= end
            if (admissionDate.isEqual(startDate) || admissionDate.isEqual(endDate)
                    || (admissionDate.isAfter(startDate) && admissionDate.isBefore(endDate))) {
                patientsInRange.add(patient);
            }
        }
        if (patientsInRange.isEmpty()) {
            System.out.println("No patients found within the specified date range.");
        } else {
            System.out.println("\nLIST OF PATIENTS");
            System.out.println("Start date: " + startDateStr);
            System.out.println("End date: " + endDateStr);
            for (Patient patient : patientsInRange) {
                count++;
                System.out.print("No." + count + " ");
                System.out.println(patient.toString());
            }
        }
    }
    
    public void displayAllPatient() {
        System.out.println("LIST ALL PATIENT: ");
        int count = 0;
        if (patientMap.isEmpty()) {
            System.out.println("Empty");
        } else {
            for (Patient value : patientMap.values()) {
                count++;
                System.out.print("No." + count + " ");
                System.out.println(value.toString());
            }
        }
    }
    
    public void sortPatient(){   
//        convert hashmap to arrlist
        Collection<Patient> values = patientMap.values();
        ArrayList<Patient> patientList = new ArrayList<>(values);
        System.out.println("LIST OF PATIENTS");
        System.out.print("Sorted by (patient id or patient's name): ");
        String field  = Validation.checkInputString();
        if(field.equalsIgnoreCase("patient id")){
            System.out.print("Sort order (asc or desc): ");
            String order = Validation.checkInputString();
            if(order.equalsIgnoreCase("asc")){
                Collections.sort(patientList, Comparator.comparing(Patient::getId)); //ASC id
                displayAllPatient();
            }else if(order.equalsIgnoreCase("desc")){
                Collections.sort(patientList, Comparator.comparing(Patient::getId).reversed()); //DESC id 
                displayAllPatient();
            }else{
                System.err.println("Invalid choice");
            }
        }else if(field.equalsIgnoreCase("patient's name")){
            System.out.print("Sort order (asc or desc): ");
            String order = Validation.checkInputString();
            if(order.equalsIgnoreCase("asc")){
                Collections.sort(patientList, Comparator.comparing(Patient::getName));   //ASC name
                displayAllPatient();
            }else if(order.equalsIgnoreCase("desc")){
                Collections.sort(patientList, Comparator.comparing(Patient::getName).reversed()); //DESC name 
                displayAllPatient();
            }else{
                System.err.println("Invalid choice");
            }
        }else{
            System.out.println("Invalid choice");
        }                        
    }
    
    public void writeToFileNurse(){
        File file = new File("D:\\University\\Chuyên ngành 3\\LAB\\Hospital Management\\src\\FileDATA\\Nurse.txt");
        try {
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            for (Map.Entry<String, Nurse> entry : nurseMap.entrySet()) {
                Nurse n = entry.getValue();
                String line = n.getStaffID() + ", " + n.getName() + ", " + n.getAge() + ", " + n.getGender() 
                                            + ", " + n.getAddress() + ", " + n.getPhone() + ", " 
                                            + n.getDepartment() + ", " + n.getShift() + ", " + n.getSalary() + "\n";
                bw.write(line);
            }
            bw.close();
            fw.close();
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
        System.out.println("Success");
    }  
    public void writeToFilePatient(){
        File file = new File("D:\\University\\Chuyên ngành 3\\LAB\\Hospital Management\\src\\FileDATA\\Patient.txt");
        try {
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            for (Map.Entry<String, Patient> entry : patientMap.entrySet()) {
                Patient p = entry.getValue();
                String line = p.getId() + ", " + p.getName() + ", " + p.getAge() + ", " + p.getGender() 
                              + ", " + p.getAddress() + ", " + p.getPhone() + ", " + p.getDiagnosis()
                              + ", " + p.getAdmissionDate()+ ", " + p.getDischargeDate()+ "\n";
                bw.write(line);
            }
            bw.close();
            fw.close();
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
    
    public void readFromFileNurse() throws ParseException  {
        try {
            File file = new File("D:\\University\\Chuyên ngành 3\\LAB\\Hospital Management\\src\\FileDATA\\Nurse.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] txt = line.split(",");
                String staffID = txt[0].trim();
                String name = txt[1].trim();
                int age = Integer.parseInt(txt[2].trim());              
                String gender = txt[3].trim();
                String address = txt[4].trim();
                String phone = txt[5].trim();
                String department = txt[6].trim();
                String shift = txt[7].trim();
                long salary = Long.parseLong(txt[8].trim());
                Nurse nur = new Nurse(staffID, department, shift, salary, 
                                    null, name, gender, address, phone, age);
                nurseMap.put(staffID, nur);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format: " + e.getMessage());
        }
    }
    public void readFromFilePatient() throws ParseException {
        try {
            File file = new File("D:\\University\\Chuyên ngành 3\\LAB\\Hospital Management\\src\\FileDATA\\Patient.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] txt = line.split(",");
                String ID = txt[0].trim();
                String name = txt[1].trim();
                int age = Integer.parseInt(txt[2].trim());
                String gender = txt[3].trim();
                String address = txt[4].trim();
                String phone = txt[5].trim();
                String diagnosis = txt[6].trim();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); 
                LocalDate admissionDate = LocalDate.parse(txt[7].trim());
                LocalDate dischargeDate = LocalDate.parse(txt[8].trim());
                Patient pat = new Patient(diagnosis, admissionDate, dischargeDate,ID , name, gender, address, phone, age);
                patientMap.put(ID, pat);
            }
            scanner.close();
            System.out.println("Success");
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format: " + e.getMessage());
        }
    }
    
    public boolean Quit(){
        System.out.print("Are you sure you want to quit? (Y/N): ");
        String confirm = Validation.checkInputString();

        if (confirm.equalsIgnoreCase("Y")) {
            System.out.println("Goodbyeeeee");
                return false;
        }
        return true;
    }
    
    public boolean checkYNNurse(){
        while(true){
            System.out.println("* Do you want to continue adding a new nurse *");
            System.out.println("* Enter 'Y' to countinue or 'N' to back the main menu *");
            String check = checkInputString();
            if(check.equalsIgnoreCase("Y")){
                createNurse();
            } else if (check.equalsIgnoreCase("N")){              
                return false;
            } 
        }   
    }   
    public boolean checkYNPatient(){
        while(true){
            System.out.println("* Do you want to continue adding a new nurse *");
            System.out.println("* Enter 'Y' to countinue or 'N' to back the main menu *");
            String check = checkInputString();
            if(check.equalsIgnoreCase("Y")){
                addPatient();
            } else if (check.equalsIgnoreCase("N")){              
                return false;
            } 
        }   
    }
    
}
