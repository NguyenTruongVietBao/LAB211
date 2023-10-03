/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author VietBao
 */
public class Flower implements Serializable{
    private String flowerID;
    private String Description;
    private LocalDate importDate;
    private double unitPrice;
    private String Category;

    public Flower() {
    }
    
    public Flower(String flowerID) {
        this.flowerID = flowerID;
    }

    public Flower(String flowerID, String Description, LocalDate importDate, double unitPrice, String Category) {
        this.flowerID = flowerID;
        this.Description = Description;
        this.importDate = importDate;
        this.unitPrice = unitPrice;
        this.Category = Category;
    }

    public String getFlowerID() {
        return flowerID;
    }

    public void setFlowerID(String flowerID) {
        this.flowerID = flowerID;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public LocalDate getImportDate() {
        return importDate;
    }

    public void setImportDate(LocalDate importDate) {
        this.importDate = importDate;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String Category) {
        this.Category = Category;
    }

    @Override
    public String toString() {
        return "Flower{" + "flowerID=" + flowerID + ", Description=" + Description + ", importDate=" 
                + importDate + ", unitPrice=" + unitPrice + ", Category=" + Category + '}';
    }
     
}
