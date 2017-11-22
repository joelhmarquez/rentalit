package com.rentalit.models;
import javax.print.Doc;
import org.bson.Document;
import java.sql.Date;
import java.util.List;

public class Scheduler {
    public void requestRental(Date start_Date, Date end_Date, Listing listing){
            Calendar schedule = new Calendar();
            schedule.setStart_Date(start_Date);
            schedule.setEnd_Date(end_Date);
            MongoDB mongo = new MongoDB();
            Document query = mongo.mongo_Query(listing);
            List<Listing> item = mongo.search_Item(query);
            if(item.isEmpty()){

            }else if(item.size() > 1){

            }
    }
}
