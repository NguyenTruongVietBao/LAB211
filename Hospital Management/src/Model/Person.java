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
public class Person implements Serializable{
    private String Id, Name, Gender, Address, Phone;
    private int age;

    public Person(){       
    }
    
    public Person(String Id, String Name, String Gender, String Address, String Phone, int age) {
        this.Id = Id;
        this.Name = Name;
        this.Gender = Gender;
        this.Address = Address;
        this.Phone = Phone;
        this.age = age;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return  ", Name: " + Name + ", Age: " + age + ", Gender: " + Gender +
                ", Address: " + Address + ", Phone: " + Phone ;
    }
    
    
}
