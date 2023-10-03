/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Flower;
import Model.Order;
import Model.OrderDetail;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author VietBao
 */
public class Store {
    private Set<Flower> flowerSet = new HashSet<Flower>();
    private Set<Order> orderSet = new HashSet<Order>();

    public Store(){        
    }
    
    public Store(Set<Flower> flowerSet, Set<Order> orderSet) {
        this.flowerSet = flowerSet;
        this.orderSet = orderSet;
    }   
    
    public void dislayFlower(){
        System.out.println("LIST OF FLOWER");
        for (Flower flower : flowerSet) {
            System.out.println(flower);
        }
    }
    
    public void addFlower(){
        System.out.print("Enter flowerID: ");
        String flowerID = Validation.checkInputString();
            for (Flower flower : flowerSet) {
                if(flower.getFlowerID().equalsIgnoreCase(flowerID))
                    System.out.println("");
                    return;
            }
           
        System.out.print("Enter description: ");
        String Description = Validation.checkInputDescription();
        DateTimeFormatter form = DateTimeFormatter.ofPattern("d/M/yyyy");
        System.out.print("Enter import date: ");
        LocalDate importDate = LocalDate.parse(Validation.checkInputString(), form);
        System.out.print("Enter price: ");
        double unitPrice = Validation.checkInputPrice();
        System.out.print("Enter category: ");
        String Category = Validation.checkInputString();  
        Flower hoa = new Flower(flowerID, Description, importDate, unitPrice, Category);
        flowerSet.add(hoa);
        System.out.println("Successfully");
        //confirm
        System.out.println("*Do you want to add Flower more (Y/N)*");
        String check = Validation.checkInputString();
        if(check.equalsIgnoreCase("y")){
            addFlower();
        }
    }   
    
    public void findFlower(){
        if(flowerSet.isEmpty()){
            System.err.println("List Flower Empty");
            return;
        }
        System.out.print("Enter FlowerID or Name you want to find: ");
        String idFind = Validation.checkInputString();   
        boolean hasFlower = false;   
        for (Flower flower : flowerSet) {
            if(flower.getFlowerID().toUpperCase().contains(idFind.toUpperCase()) ||
                    flower.getDescription().toUpperCase().contains(idFind.toUpperCase())){
                System.out.println(flower.toString());
                hasFlower = true;
            }
        }
        if(!hasFlower){
            System.err.println("The flower does not exis");
        }       
    }
    
    public void updateFlower(){    
        // empty
        if(flowerSet.isEmpty()){
            System.err.println("List Flower Empty");
            return;
        }          
        // Available Flower
        System.out.println("------Available flower------");
        for (Flower flower : flowerSet) {
            System.out.print("FlowerID: " + flower.getFlowerID());
            System.out.println("; Description: "+flower.getDescription());
        }
        System.out.println("----------------------------");
        //Update
        System.out.println("Enter Flower's Name you want to update: ");
        String flowerName = Validation.checkInputString(); 
        for (Flower flower : flowerSet) {
            if(flowerName.trim().equalsIgnoreCase(flower.getDescription().trim())){            
                System.out.print("Enter new description: ");
                String Description = Validation.checkInputDescription();
                DateTimeFormatter form = DateTimeFormatter.ofPattern("d/M/yyyy");
                System.out.print("Enter new import date: ");
                LocalDate importDate = LocalDate.parse(Validation.checkInputString(), form);
                System.out.print("Enter new price: ");
                double unitPrice = Validation.checkInputPrice();
                System.out.print("Enter new category: ");
                String Category = Validation.checkInputString();     
                    flower.setDescription(Description);
                    flower.setImportDate(importDate);
                    flower.setUnitPrice(unitPrice);
                    flower.setCategory(Category);
                    System.out.println("Succesfull");
            }
        }     
    }

    //check if a flower is used in any order details
    private boolean isFlowerUsedInOrderDetails(Flower flower) {
        for (Order order : orderSet) {
            for (OrderDetail orderDetail : order.getOrderDetails()) {
                if (orderDetail.getFlowerId().equalsIgnoreCase(flower.getFlowerID())) {
                    return true;
                }
            }
        }
        return false;
    }   
    public void deleteFlower(){
        // empty
        if(flowerSet.isEmpty()){
            System.err.println("List Flower Empty");
            return;
        }
         // Available Flower
        System.out.println("------Available flower------");
        for (Flower flower : flowerSet) {
            System.out.print("FlowerID: " + flower.getFlowerID());
            System.out.println("; Description: "+flower.getDescription());
        }
        
        System.out.println("Enter FlowerID you want to update: ");
        String idHoa = Validation.checkInputString();       
        Flower foundFlower = null;
        
        for (Flower flower : flowerSet) {
            if (flower.getFlowerID().equalsIgnoreCase(idHoa)) {
                foundFlower = flower;
                break;
            }
        }
        
        if (foundFlower != null) {
            // Check if the flower is used in any order details
            if (isFlowerUsedInOrderDetails(foundFlower)) {
                System.out.println("The flower cannot be deleted as it is used in an order detail.");
            } else {
                // Confirm the deletion with the user
                System.out.print("Are you sure you want to delete the flower? (Y/N): ");
                String choice = Validation.checkInputString();

                if (choice.equalsIgnoreCase("Y")) {
                    // Remove the flower from the collection of flowers
                    flowerSet.remove(foundFlower);
                    System.out.println("Flower deleted successfully.");
                } else {
                    System.out.println("Deletion canceled.");
                }
            }
        } else {
            System.out.println("The flower does not exist.");
        }
    }
   
    public void addOrder() {  
        if(flowerSet.size() == 0){ 
            System.err.println("Dont have any flowers");        
        }else{
            System.out.print("Enter order ID: ");
            String orderID = Validation.checkInputString();
            //Check Exist OrderID
            for (Order order : orderSet) {
                if (order.getOrderID().equals(orderID)) {
                    System.err.println("Exist OrderID");
                    return;
                }
            }
            DateTimeFormatter form = DateTimeFormatter.ofPattern("d/M/yyyy");
            System.out.print("Enter order Date: ");
            LocalDate orderDate = LocalDate.parse(Validation.checkInputString(), form);
            System.out.print("Enter customer's name: ");
            String customerName = Validation.checkInputString();
            
            Order order = new Order(orderID, orderDate, customerName);

            // Available Flower
            System.out.println("------Available flower------");
            for (Flower flower : flowerSet) {
                System.out.print("FlowerID: " + flower.getFlowerID());
                System.out.println("; Description: " + flower.getDescription());
            }
            System.out.println("----------------------------");

            //Input order Detail
            boolean addMoreOrderDetails = true;
            while (addMoreOrderDetails) {
                System.out.print("Enter flowerID you want to order: ");
                String flowerID = Validation.checkInputString();
                for (Flower flower : flowerSet) {
                    if (flower.getFlowerID().contains(flowerID)) {
                        System.out.print("Enter quantity: ");
                        int Quantity = Validation.checkInputInt();
                        double flowerCost = Quantity * flower.getUnitPrice();
                        OrderDetail ord = new OrderDetail(orderID, flowerID, Quantity, flowerCost);
                        // add orderDetail
                        order.addOrderDetail(ord);
//                        order.addOrderTotal(Quantity);
                        System.out.println("-----OrderDetail add successfully-----");
                        //check
                        System.out.print("*Do you want to add another order detail? (Y/N)*");
                        String choice = Validation.checkInputString();
                            if (choice.equalsIgnoreCase("N")) {
                                addMoreOrderDetails = false;
                            }
                    }   
                }
            }
            //add order
            orderSet.add(order);
            System.out.println("-----Order added successfully-----");
            //check
            System.out.print("*Do you want to add another order? (Y/N)*");
            String choiceOrder = Validation.checkInputString();
            if (choiceOrder.equalsIgnoreCase("Y")) {
                addOrder();
            }
        }
    }    
    
    public void dislayAllOrder(){
        System.out.println("LIST ALL ORDER");
        List<Order> RangeOrders = new ArrayList<>();
        
         int totalFlowerCount = 0;
        double totalOrderTotal = 0.0;
        for (int i = 0; i < RangeOrders.size(); i++) {
            Order order = RangeOrders.get(i);
            List<OrderDetail> orderDetails = order.getOrderDetails();
            int flowerCount = 0;
            double orderTotal = 0.0;
                for (OrderDetail orderDetail : orderDetails) {
                    flowerCount += orderDetail.getQuantity();
                    orderTotal += orderDetail.getFlowerCost();
                }
            totalFlowerCount = totalFlowerCount + flowerCount;
            totalOrderTotal = totalOrderTotal + orderTotal;
            System.out.printf("%-3d  %-8s  %-10s  %-8s  %-12d  $%.2f%n",(i + 1), 
                    order.getOrderID(), order.getOrderDate(), order.getCustomerName(),
                    flowerCount, orderTotal);
        }
        System.out.printf("%-36s %-13d $%.2f%n", "Total", totalFlowerCount, totalOrderTotal);
    } 

    public void dislayOrder(){
        DateTimeFormatter form = DateTimeFormatter.ofPattern("d/M/yyyy");
        System.out.print("Enter start date (dd/MM/yyyy): ");
        String startDateStr = Validation.checkInputString();
        LocalDate startDate = LocalDate.parse(startDateStr, form);
        System.out.print("Enter end date (dd/MM/yyyy): ");
        String endDateStr = Validation.checkInputString();
        LocalDate endDate = LocalDate.parse(endDateStr, form);

        // Filter the orders within the specified date range
        List<Order> RangeOrders = new ArrayList<>();
        for (Order order : orderSet) {
            LocalDate orderDate = order.getOrderDate();
            if (orderDate.equals(startDate)||orderDate.equals(endDate)|| 
                orderDate.isAfter(startDate) && orderDate.isBefore(endDate)) {
                RangeOrders.add(order);
            }
        }
        // Check if any orders are found
        if (RangeOrders.isEmpty()) {
            System.out.println("No orders found within the specified date range.");
            return;
        }

        // Display the header
        System.out.println("LIST ORDERS FROM " + startDateStr + "TO "+endDateStr);
        System.out.println("No.  Order Id  Order Date  Customer  Flower Count  Order Total");
        int totalFlowerCount = 0;
        double totalOrderTotal = 0.0;
        for (int i = 0; i < RangeOrders.size(); i++) {
            Order order = RangeOrders.get(i);
            List<OrderDetail> orderDetails = order.getOrderDetails();
            int flowerCount = 0;
            double orderTotal = 0.0;
                for (OrderDetail orderDetail : orderDetails) {
                    flowerCount = flowerCount + orderDetail.getQuantity();
                    orderTotal = orderTotal + orderDetail.getFlowerCost();
                }
            totalFlowerCount = totalFlowerCount + flowerCount;
            totalOrderTotal = totalOrderTotal + orderTotal;
            System.out.printf("%-3d  %-8s  %-10s  %-8s  %-12d  $%.2f%n",(i + 1), 
                    order.getOrderID(), order.getOrderDate(), order.getCustomerName(),
                    flowerCount, orderTotal);
        }
        System.out.printf("%-36s %-13d $%.2f%n", "Total", totalFlowerCount, totalOrderTotal);
    }    
   
    public void sort(){
        System.out.print("Sorted by(ID, Name, Date, Total): ");
        String field = Validation.checkInputString().toLowerCase();
        System.out.println("Sort order (ASC, DESC): ");
        String order = Validation.checkInputString().toLowerCase();        
        //convert set to list
        Collection<Order> values = orderSet;
        ArrayList<Order> orderList = new ArrayList<>(values);    
        switch (field) {
            case "id":
                Collections.sort(orderList, Comparator.comparing(Order::getOrderID));
                break;
            case "date":
                Collections.sort(orderList, Comparator.comparing(Order::getOrderDate));
                break;
            case "name":
                Collections.sort(orderList, Comparator.comparing(Order::getCustomerName));
                break;
            case "order total":
                Collections.sort(orderList, Comparator.comparing(Order::getOrderTotal));
                break;
            default:
                System.out.println("Invalid field entered. Sorting aborted.");
                return;
        }       
        if(order.equalsIgnoreCase("ASC")){
            for (Order order1 : orderList) {
                System.out.println(order1);
            }
        }else if(order.equalsIgnoreCase("DESC")){
            Collections.reverse(orderList );    
            for (Order order1 : orderList) {
                System.out.println(order1);
            }      
        }else{
            System.out.println("Invalid sort order entered. Sorting aborted.");
            return;
        }
    
    }
    
    public void saveData() {
        try{
            ObjectOutputStream flowerData = new ObjectOutputStream(new FileOutputStream("Flower.dat"));
            ObjectOutputStream orderData = new ObjectOutputStream(new FileOutputStream("Order.dat"));
            // Save the collection of flowers
            flowerData.writeObject(flowerSet);
            // Save the collection of orders
            orderData.writeObject(orderSet);
            flowerData.close();
            orderData.close();
            System.out.println("Data saved successfully.");
        } catch (IOException e) {
            System.out.println("Error occurred while saving data: " + e.getMessage());
        }
    }
    
    public void loadData() {
        try {
            ObjectInputStream flowerInput = new ObjectInputStream(new FileInputStream("Flower.dat")); 
            ObjectInputStream orderInput = new ObjectInputStream(new FileInputStream("Order.dat"));
            // Load the collection of flowers
            flowerSet = (Set<Flower>) flowerInput.readObject();
            // Load the collection of orders
            orderSet = (Set<Order>) orderInput.readObject();
            flowerInput.close();
            orderInput.close();
            System.out.println("Data loaded successfully.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error occurred while loading data: " + e.getMessage());
        }
    }
    
}
