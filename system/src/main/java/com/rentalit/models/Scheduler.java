package com.rentalit.models;
import java.sql.Date;
import java.util.List;

public class Scheduler {
    public void requestRental(Date start_Date, Date end_Date, Listing listing){
            Calendar schedule = new Calendar();
            schedule.setStart_Date(start_Date);
            schedule.setEnd_Date(end_Date);
    }
}
