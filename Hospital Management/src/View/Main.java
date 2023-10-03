/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.Hospital;
import Controller.Validation;
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author VietBao
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Hospital benhvien = new Hospital();
        int choiceMenu, choiceNurse, choicePatient;      
        do {            
            System.out.println("-----HOSTPITAL MANAGEMENTS-----");
            System.out.println("1. Nurse's management");
            System.out.println("2. Patient's management");            
            System.out.println("3. Save FILE");
            System.out.println("4. Load FILE");           
            System.out.println("5. Quit");
            System.out.print("Enter your choice: "); 
            choiceMenu = Validation.checkInputIntLimit(1, 5);
            switch(choiceMenu){
                case 1: do {                        
                            System.out.println("-----Nurse's management-----");
                            System.out.println("1. Create a nurse ");
                            System.out.println("2. Find the nurse ");
                            System.out.println("3. Update the nurse ");
                            System.out.println("4. Delete the nurse ");
                            System.out.println("5. Exit ");
                            System.out.print("Enter your choice: ");                           
                            choiceNurse = Validation.checkInputIntLimit(1, 5);
                            switch(choiceNurse){
                                case 1: benhvien.createNurse();
                                        benhvien.checkYNNurse();
                                    break;
                                case 2: benhvien.findNurse();
                                    break;
                                case 3: benhvien.updateNurse();
                                    break;
                                case 4: benhvien.deleteNurse();
                                    break;
                            }
                        } while (choiceNurse != 5);
                    break;
                    
                case 2: do {                        
                            System.out.println("-----Patient's management-----");
                            System.out.println("1. Add a patient");
                            System.out.println("2. Display patients in range");
                            System.out.println("3. Display all patients");
                            System.out.println("4. Add Nurse Assign");
                            System.out.println("5. Sort the patients list");
                            System.out.println("6. Exit ");
                            System.out.print("Enter your choice: ");                           
                            choicePatient = Validation.checkInputIntLimit(1, 6);
                            switch(choicePatient){
                                case 1: benhvien.addPatient();
                                        benhvien.checkYNPatient();
                                    break;
                                case 2: benhvien.displayPatient();
                                    break;
                                case 3: benhvien.displayAllPatient();
                                    break;
                                case 4: benhvien.addNurseAssign();
                                    break;
                                case 5: benhvien.sortPatient();
                                    break;
                            }
                        } while (choicePatient != 6);
                    break;

                case 3: benhvien.writeToFileNurse();
                        benhvien.writeToFilePatient();
                    break;
                case 4: benhvien.readFromFileNurse();
                        benhvien.readFromFilePatient();
                    break;
                default:
                    System.out.println("Goodbyeeeee");
            }
        } while (choiceMenu != 5);
    }
}
