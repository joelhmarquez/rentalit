package com.rentalit.models;

import org.springframework.beans.factory.annotation.Configurable;

@Configurable
public class RentedState implements ProductState {

	@Override
	public void acceptRental(Listing listing) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void requestRental(Listing listing) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void returnRental(Listing listing) {
		listing.setCurrentState(listing.getAvailableState());
	}
}
