package com.rentalit.models;

import org.springframework.beans.factory.annotation.Autowired;

import com.rentalit.resources.Condition;


public class Listing {
	private String _id;
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
    
    public String get_Id() {
		return this._id;
	}

	public void set_Id(String _id) {
		this._id = _id;
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

