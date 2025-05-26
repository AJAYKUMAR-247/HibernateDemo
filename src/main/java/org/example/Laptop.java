package org.example;


import jakarta.persistence.Embeddable;


// @Embeddable means when you want to use this complex data type in the same table without creating a new table then use @Embeddable
// this annotation will embed the laptop data in the student table, so that all the fields in the student class and in the table class will come in a row
@Embeddable
public class Laptop {
    private String brand;
    private int price;
    private String modal;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getModal() {
        return modal;
    }

    public void setModal(String modal) {
        this.modal = modal;
    }
}
