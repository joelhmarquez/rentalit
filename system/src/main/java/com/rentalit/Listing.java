package com.rentalit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


public class Listing {
    private String product_Name;
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

    public String getProduct_Name() {
        return product_Name;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setProduct_Name(String product_Name) {
        this.product_Name = product_Name;
    }

    public void setRented(Integer rented) {
        this.rented = rented;
    }

}

