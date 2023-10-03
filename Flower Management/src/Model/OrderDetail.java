/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.Serializable;

/**
 *
 * @author VietBao
 */
public class OrderDetail implements Serializable{
    private String orderDetailId;
    private String flowerId;
    private int Quantity;
    private double flowerCost;

    public OrderDetail(String orderDetailId, String flowerId, int Quantity, double flowerCost) {
        this.orderDetailId = orderDetailId;
        this.flowerId = flowerId;
        this.Quantity = Quantity;
        this.flowerCost = flowerCost;
    }

    public String getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(String orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public String getFlowerId() {
        return flowerId;
    }

    public void setFlowerId(String flowerId) {
        this.flowerId = flowerId;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public double getFlowerCost() {
        return flowerCost;
    }

    public void setFlowerCost(double flowerCost) {
        this.flowerCost = flowerCost;
    }
    
    public double calculateFlowerCost(double unitPrice) {
        flowerCost = Quantity * unitPrice;
        return flowerCost;
    }

    @Override
    public String toString() {
        return ", Quantity: " + Quantity + ", FlowerCost: " + flowerCost ;
    }
    
}
