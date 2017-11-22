package com.rentalit.models;

import org.springframework.beans.factory.annotation.Configurable;

@Configurable
public class RentedState implements ProductState {
	MongoDB mongo = new MongoDB();

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
		listing.setRented(0);
		mongo.updateListing(listing);
	}
}
