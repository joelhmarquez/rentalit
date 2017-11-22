package com.rentalit.models;

import org.springframework.beans.factory.annotation.Configurable;

@Configurable
public class AvailableState implements ProductState{
	MongoDB mongo = new MongoDB();
	
	@Override
	public void acceptRental(Listing listing) {
		listing.setRented(1);
		mongo.updateListing(listing);
	}
	
	@Override
	public void requestRental(Listing listing) {
		// TODO Auto-generated method stub
	}

	@Override
	public void returnRental(Listing listing) {
		// TODO Auto-generated method stub
	}

}
