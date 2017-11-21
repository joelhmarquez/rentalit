package com.rentalit.models;

import org.springframework.beans.factory.annotation.Configurable;

@Configurable
public class AvailableState implements ProductState{

	@Override
	public void acceptRental(Listing listing) {
		listing.setCurrentState(listing.getRentedState());
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
