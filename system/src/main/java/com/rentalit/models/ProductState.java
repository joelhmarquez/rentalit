package com.rentalit.models;

public interface ProductState {
	public void acceptRental(Listing listing);
	public void requestRental(Listing listing);
	public void returnRental(Listing listing);
}
