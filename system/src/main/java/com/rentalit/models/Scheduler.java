package com.rentalit.models;

import com.rentalit.error.RentedException;

public class Scheduler {
    public void requestRental(Listing listing) throws RentedException {
    		listing.acceptRental();
    }
}
