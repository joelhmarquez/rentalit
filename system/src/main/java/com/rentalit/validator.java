package com.rentalit;


public class validator {
    public Boolean isValid(String productName, String Description, String condition) {
        return (productName.length() > 0 && Description.length() > 0 && ((condition.toUpperCase().equals(Condition.BAD.toString()) || condition.toUpperCase().equals(Condition.GOOD.toString()) || condition.toUpperCase().equals(Condition.NEW.toString()) || condition.toUpperCase().equals(Condition.USED.toString()))));
    }
}
