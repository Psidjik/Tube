package com.example.tube.models;

import jakarta.persistence.*;
@Entity
@Table(name = "tube")
public class Tube {
    private int id;
    private int length;
    private int price;
    private double coef;

    public Tube() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @Column
    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
    @Column
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    @Column
    public double getCoef() {
        return coef;
    }

    public void setCoef(double coef) {
        this.coef = coef;
    }
}
