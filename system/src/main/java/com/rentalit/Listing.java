package com.rentalit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


public class Listing {

    public enum Conditions {BAD, USED , GOOD, NEW}
    private String productName;
    private String description;
    private Integer rented;
    private Conditions condition;

    public Conditions getCondition() {
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

    public void setCondition(Conditions condition) {
        this.condition = condition;
    }

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

