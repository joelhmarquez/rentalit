package com.rentalit.models;

public class Scheduler {
    public void requestRental(Calendar calendar, Listing listing){
    		listing.acceptRental(calendar);
    }
}
