package com.rentalit.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Calendar {

    public String startDate;
    public String endDate;

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }


    @JsonProperty("startDate")
    public void setStartDate(String end_Date) {
        this.endDate = end_Date;
    }

    @JsonProperty("endDate")
    public void setEndDate(String startDate) {
        this.startDate = startDate;
    }

}
