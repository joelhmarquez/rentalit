package com.rentalit.models;
import java.sql.Date;
public class Calendar {
    public String start_Date;
    public String end_Date;

    public String getStart_Date() {
        return start_Date;
    }

    public String getEnd_Date() {
        return end_Date;
    }

    public void setEnd_Date(String end_Date) {
        this.end_Date = end_Date;
    }

    public void setStart_Date(String start_Date) {
        this.start_Date = start_Date;
    }

}
