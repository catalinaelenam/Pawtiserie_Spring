package com.example.pawtiserie1.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Min;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Cake {
    public Cake(String s) {
    }

    public enum Type {

        PortraitCakes("PortraitCakes"),
        BirthdayCakes("BirthdayCakes");
        public final String label;

        private Type(String label) {
            this.label = label;
        }
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cakeId;

    @Enumerated(EnumType.STRING)
    private Type type;

    @Column(name= "price")

    @Min(0)
    private double price;

    @ManyToOne
    @JsonIgnore
    private CakeCategory cakeCategory;

    @ManyToMany
    @JoinTable(name = "cake_order", joinColumns = @JoinColumn(name = "cake_id"),
            inverseJoinColumns =  @JoinColumn(name = "order_id"))
    private List<Order> ordersList = new ArrayList<>();

    public int getCakeId() {
        return cakeId;
    }

    public void setCakeId(int cakeId) {
        this.cakeId = cakeId;
    }

    public Cake() {
    }

    public Cake(Type type, double price) {
        this.type = type;
        this.price = price;
    }

    public String getType() {
        return type.label;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCakeCategory(CakeCategory cakeCategory) {

        this.cakeCategory = cakeCategory;
    }

    public Cake(Type type, double price, CakeCategory cakeCategory) {
        this.type = type;
        this.price = price;
        this.cakeCategory = cakeCategory;
    }
}
