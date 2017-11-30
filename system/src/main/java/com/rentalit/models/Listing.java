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
    private Calendar calendar;
//    private String startDate;
    private String endDate;
    
    /* State Pattern */
    ProductState availableState = new AvailableState();
	ProductState rentedState = new RentedState();;
	ProductState currentState;
    
    public Listing(){
    	
    }

    public String getEndDate() {
        return endDate;
    }

    public String getId() {
		return this.id;
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
    
    public Calendar getCalendar() {
		return calendar;
	}

    @JsonProperty("_id")
	private void setId(Map<String, String> idObj) {
	    this.id = idObj.get("$oid");
	}
    
    public void setCondition(String condition) { this.condition = Condition.valueOf(condition);}


    public void setDescription(String description) {
        this.description = description;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
    
	public void setCalendar(Calendar calendar) {
		this.calendar = calendar;
	}

    //public void setEndDate(String endDate) {
      //  this.endDate = endDate;
    //}

    @JsonProperty("rented")
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
	
	public void setCurrentState(ProductState newState) {
		this.currentState = newState;
	}
	
	public void acceptRental(Calendar calendar) {
		setCalendar(calendar);
		this.currentState.acceptRental(this);
	}
	
	public void RequestRental(Calendar calendar) {
		setCalendar(calendar);
		this.currentState.requestRental(this);
	}
	
	public void ReturnRental(Calendar calendar) {
		setCalendar(calendar);
		this.currentState.requestRental(this);
	}
}

