/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Nurse;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author VietBao
 */
public class Validation {
    static Scanner scan = new Scanner(System.in);
   
    public static int checkInputIntLimit(int min, int max){
        //loop until user input correct
        while (true) {
            try { 
                int result = Integer.parseInt(scan.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input number in rage [" + min + ", " + max + "]"); 
                System.out.print("Enter again: ");
            }
        }
    }

    public static String checkInputString() {
        while (true) {
            String result = scan.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Not empty");
                System.out.print("Enter again: ");
            } else {
                return result;
            }
        }
    }

    public static boolean checkInputYN() {
        while (true) {
            String result = checkInputString();
            if (result.equalsIgnoreCase("Y")) {
                return true;
            } else if (result.equalsIgnoreCase("N")) {
                return false;
            }
            System.err.println("Please input y/Y or n/N.");
            System.out.print("Enter again: ");
        }
    }

    public static String checkInputPhone() {
        while (true) {
            String result = checkInputString();
            if (result.matches("0[0-9]{9,10}")) {
                return result;
            } else {
                System.err.println("Phone is number with minimum 10,11 characters start with '0': ");
                System.out.print("Enter again: ");
            }
        }
    }
    
    public static double checkInputSalary(){       
        long data;          
        while(true){
            try {
                data = Long.parseLong(scan.nextLine());
                if (data <= 0) {
                    throw new NumberFormatException();
                }
                return data;
            }catch (NumberFormatException e) {
                System.err.print("Invalid number, pls input again: ");
            } 
        }
    }
    
    public static int checkInputInt() {
        int data;
        while(true){
            try {
                data = Integer.parseInt(scan.nextLine());
                if (data <= 0) {
                    throw new NumberFormatException();
                }
                return data;
            } catch (NumberFormatException e) {
                 System.err.println("Invalid number, pls input again: ");
                 System.out.print("Enter again: ");
            }
        }
    }
    
    public static String checkInputDepartment() {      
        while (true) {
            String result = checkInputString();
            if (result.matches("^.{3,50}$")) {
                return result;
            } else {
                System.err.println("3 < x < 50 character");
                System.out.print("Enter again: ");
            }
        }
    }

    public static String checkDate(){
        String regex = "([0-9]{1,2})/([0-9]{1,2})/([0-9]{4})";
        while (true) {
            String result = checkInputString();
            if (result.matches(regex)) {
                return result;
            } else {
                System.err.println("Invalid format. Please use format dd/MM/yyyy.");
                System.out.print("Enter again: ");
            }
        }
    }  
    
}