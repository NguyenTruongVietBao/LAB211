/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.Store;
import Controller.Validation; 
import java.util.Scanner;

/**
 *
 * @author VietBao
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int choiceMenu, choiceFlower, choiceOrder;     
        Store store = new Store();
        do {            
            System.out.println("-----FLOWERS STORE-----");
            System.out.println("1. Manage Flower");
            System.out.println("2. Manage Order");            
            System.out.println("3. Save FILE");
            System.out.println("4. Load FILE");         
            System.out.println("5. Quit");
            System.out.print("Enter your choice: "); 
            choiceMenu = Validation.checkInputIntLimit(1, 5);
            switch(choiceMenu){
                case 1: do {                        
                            System.out.println("-----Manage Flower-----");
                            System.out.println("1. Add a Flower ");
                            System.out.println("2. Find a Flower ");
                            System.out.println("3. Update a Flower ");
                            System.out.println("4. Delete a Flower ");
                            System.out.println("5. Dislay all Flower available");
                            System.out.println("6. Exit ");
                            System.out.print("Enter your choice: ");                           
                            choiceFlower = Validation.checkInputIntLimit(1, 6);
                            switch(choiceFlower){
                                case 1: store.addFlower();
                                    break;
                                case 2: store.findFlower();;
                                    break;
                                case 3: store.updateFlower();
                                    break;
                                case 4: store.deleteFlower();
                                    break;
                                case 5: store.dislayFlower();
                                    break;
                            }
                        } while (choiceFlower != 6);
                    break;
                    
                case 2: do {                        
                            System.out.println("-----Patient's management-----");
                            System.out.println("1. Add an Order");
                            System.out.println("2. Display Orders");
                            System.out.println("3. Sort Orders");
                            System.out.println("4. Dislay all Order");
                            System.out.println("5. Exit ");
                            System.out.print("Enter your choice: ");                           
                            choiceOrder = Validation.checkInputIntLimit(1, 5);
                            switch(choiceOrder){
                                case 1: store.addOrder();
                                    break;
                                case 2: store.dislayOrder();
                                    break;
                                case 3: store.sort();
                                    break;
                                case 4: store.dislayAllOrder();
                                    break;
                            }
                        } while (choiceOrder != 5);
                    break;

                case 3: store.saveData();
                    break;
                case 4: store.loadData();
                    break;
                default:
                    System.out.println("Goodbyeeeee");
            }
        } while (choiceMenu != 5);
    }
}
