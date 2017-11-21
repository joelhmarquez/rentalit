package com.rentalit.models;

import com.rentalit.resources.Condition;


public class Listing {
    private String productName;
    private String description;
    private Integer rented;
    private Condition condition;
    
    public Listing(){
    	
    }

    public Condition getCondition() {
        return condition;
    }

    public Integer getRented() {
        return rented;
    }

    public String getDescription() {
        return description;
    }

    public String getProductName() {
        return productName;
    }

    public void setCondition(String condition) { this.condition = Condition.valueOf(condition);}


    public void setDescription(String description) {
        this.description = description;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setRented(Integer rented) {
        this.rented = rented;
    }

}

