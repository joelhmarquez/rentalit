package com.rentalit.models;
import java.sql.Date;
public class Calendar {
    public Date start_Date;
    public Date end_Date;

    public Date getStart_Date() {
        return start_Date;
    }

    public Date getEnd_Date() {
        return end_Date;
    }

    public void setEnd_Date(Date end_Date) {
        this.end_Date = end_Date;
    }

    public void setStart_Date(Date start_Date) {
        this.start_Date = start_Date;
    }

}
