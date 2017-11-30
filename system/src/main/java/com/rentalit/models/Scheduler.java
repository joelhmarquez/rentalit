package com.rentalit.models;
import org.bson.Document;

import java.util.List;

public class Scheduler {
    public void requestRental(String start_Date, String end_Date, Listing listing){
            Calendar schedule = new Calendar();
            schedule.setStartDate(start_Date);
            schedule.setEnd_Date(end_Date);
//            MongoDB mongo = new MongoDB();
//            Document query = mongo.mongo_Query(listing);
//            List<Listing> item = mongo.search_Item(query);
//            if(item.isEmpty()){
//
//            }else if(item.size() > 1){
//
//            }
            listing.acceptRental(schedule);
    }
}
