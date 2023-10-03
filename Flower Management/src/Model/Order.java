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
public class Order implements Serializable {
    private String orderID;
    private LocalDate orderDate;
    private String customerName;
    private ArrayList<OrderDetail> orderDetails;
    private int orderTotal;

    public Order(){
        
    }
    
    public Order(String orderID, LocalDate orderDate, String customerName) {
        this.orderID = orderID;
        this.orderDate = orderDate;
        this.customerName = customerName;
        this.orderDetails = new ArrayList<>();
    }

    public Order(String orderID, LocalDate orderDate, String customerName, int orderTotal) {
        this.orderID = orderID;
        this.orderDate = orderDate;
        this.customerName = customerName;
        this.orderTotal = orderTotal;
        this.orderDetails = new ArrayList<>();
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public String getCustomerName() {
        return customerName;
    }
    
    public int getOrderTotal( ) {
        int flowerCount = 0;
        int orderTotal2 = 0;
        for (OrderDetail orderDetail : orderDetails) {
            flowerCount += orderDetail.getQuantity();
            orderTotal += orderDetail.getFlowerCost();
        }
        return orderTotal2;
    }
    
    public void setOrderTotal(int orderTotal ) {
        
        this.orderTotal = orderTotal;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public ArrayList<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(ArrayList<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    @Override
    public String toString() {
        return "OrderID: " + orderID + ", OrderDate: " + orderDate +
                        ", CustomerName: " + customerName ;
    }

    public void addOrderDetail(OrderDetail orderDetail) {
        orderDetails.add(orderDetail);
    }
}
