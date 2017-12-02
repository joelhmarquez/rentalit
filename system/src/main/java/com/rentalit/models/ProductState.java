package com.rentalit.models;

import com.rentalit.error.RentedException;

public interface ProductState {
	public void acceptRental(Listing listing) throws RentedException;
	public void requestRental(Listing listing);
	public void returnRental(Listing listing);
}
