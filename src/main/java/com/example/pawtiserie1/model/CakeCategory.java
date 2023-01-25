package com.example.pawtiserie1.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cake_categories")
public class CakeCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cake_category_id")
    private int cakeCategoryID;
    private String categoryName;

    @OneToMany(mappedBy = "cakeCategory")
    private List<Cake> cakes = new ArrayList<>();

    private String categoryDescription;

    public CakeCategory() {
    }

    public CakeCategory(String categoryName, String categoryDescription) {
        this.categoryName = categoryName;
        this.categoryDescription = categoryDescription;
    }

    public CakeCategory(int cakeCategoryID, String categoryName, String categoryDescription) {
        this.cakeCategoryID = cakeCategoryID;
        this.categoryName = categoryName;
        this.categoryDescription = categoryDescription;
    }

    public int getCakeCategoryID() {
        return cakeCategoryID;
    }

    public void setCakeCategoryID(int cakeCategoryID) {
        this.cakeCategoryID = cakeCategoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

}
