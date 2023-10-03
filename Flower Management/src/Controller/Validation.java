/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

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
    
    public static double checkInputPrice(){       
        double data;          
        while(true){
            try {
                data = Double.parseDouble(scan.nextLine());
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
    
    public static String checkInputDescription() {      
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

    
}