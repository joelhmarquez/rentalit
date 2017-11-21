package com.rentalit.models;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rentalit.resources.Condition;


public class Listing {
	private String id;
    private String productName;
    private String description;
    private Integer rented;
    private Condition condition;
    
    /* State Pattern */
    ProductState availableState = new AvailableState();
	ProductState rentedState = new RentedState();;
	ProductState currentState;
    
    public Listing(){
    	
    }
    
    public String getId() {
		return this.id;
	}

	public void set_Id(String id) {
		this.id = id;
	}
	
	@JsonProperty("_id")
	private void unpackNameFromNestedObject(Map<String, String> idObj) {
	    this.id = idObj.get("$oid");
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

    @JsonProperty("product_Name")
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

    @JsonProperty("isRented")
    public void setRented(Integer rented) {
        this.rented = rented;
        if(this.rented == 1) {
        		setCurrentState(this.rentedState);
        } else {
        		setCurrentState(this.availableState);
        }
    }
    
    /* State Pattern Methods */
    public ProductState getCurrentState() {
		return this.currentState;
	}
    
    public ProductState getAvailableState() {
		return this.availableState;
	}
    
    public ProductState getRentedState() {
		return this.rentedState;
	}
	
	public void setCurrentState(ProductState newState) {
		this.currentState = newState;
	}
	
	public void acceptRental() {
		this.currentState.acceptRental(this);
	}
	
	public void RequestRental() {
		this.currentState.requestRental(this);
	}
	
	public void ReturnRental() {
		this.currentState.requestRental(this);
	}
}

