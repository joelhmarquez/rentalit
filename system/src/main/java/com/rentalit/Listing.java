package com.rentalit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


public class Listing {
    private String productName;
    private String description;
    private Integer rented;
    private String condition;

    public String getCondition() {
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

    public void setCondition(String condition) {
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

