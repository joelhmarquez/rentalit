package com.rentalit.models;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rentalit.error.RentedException;
import com.rentalit.resources.Condition;

public class Listing {

	private String id;
    private String productName;
    private String description;
    private Integer rented;
    private Condition condition;
    private Calendar calendar;
    private String url;
    
    /* State Pattern */
    ProductState availableState = new AvailableState();
	ProductState rentedState = new RentedState();;
	ProductState currentState;
    
    public Listing(){
    	
    }

    public String getId() {
		return this.id;
	}
    
    public Calendar getCalendar() {
		return calendar;
	}

    public Condition getCondition() {
        return condition;
    }
    
    public String getDescription() {
        return description;
    }
    
    public String getProductName() {
        return productName;
    }

    public Integer getRented() {
        return rented;
    }
    
    public String getUrl() {
        return url;
    }

    @JsonProperty("_id")
	private void setId(Map<String, String> idObj) {
	    this.id = idObj.get("$oid");
	}
    
    @JsonProperty("calendar")
	public void setCalendar(Calendar calendar) {
		this.calendar = calendar;
	}
    
    @JsonProperty("condition")
    public void setCondition(String condition) { this.condition = Condition.valueOf(condition);}

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("product_Name")
    public void setProductName(String productName) {
        this.productName = productName;
    }
	
    @JsonProperty("rented")
    public void setRented(Integer rented) {
        this.rented = rented;
        if(this.rented == 1) {
        		setCurrentState(this.rentedState);
        } else {
        		setCurrentState(this.availableState);
        }
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    /* State Pattern Methods */
    public ProductState getCurrentState() {
		return this.currentState;
	}
	
	public void setCurrentState(ProductState newState) {
		this.currentState = newState;
	}
	
	public void acceptRental() throws RentedException {
		this.currentState.acceptRental(this);
	}
	
	public void RequestRental() {
		this.currentState.requestRental(this);
	}
	
	public void ReturnRental() {
		this.currentState.requestRental(this);
	}
}

