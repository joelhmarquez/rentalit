package com.rentalit.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Calendar {

    public String startDate;
    public String endDate;

    public String getStartDate() {
        return startDate;
    }

    public String getEnd_Date() {
        return endDate;
    }


    @JsonProperty("startDate")
    public void setEnd_Date(String end_Date) {
        this.endDate = end_Date;
    }

    @JsonProperty("endDate")
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

}
