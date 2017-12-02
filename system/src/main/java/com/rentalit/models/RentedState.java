package com.rentalit.models;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Configurable;
import com.rentalit.error.RentedException;

@Configurable
public class RentedState implements ProductState {
	static Logger log = LoggerFactory.getLogger(RentedState.class);
	
	MongoDB mongo = new MongoDB();

	@Override
	public void acceptRental(Listing listing) throws RentedException {
		log.error("Attempting to checkout rented item:" + listing.getProductName());
		
		throw new RentedException(listing.getProductName() + "is already rented");
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
