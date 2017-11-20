package com.rentalit;


public class validator {
    public Boolean isValid(String productName, String Description, String condition) {
        return (productName.length() > 0 && Description.length() > 0 && ((condition.toUpperCase().equals(mongo_DB.Conditions.BAD.toString()) || condition.toUpperCase().equals(mongo_DB.Conditions.GOOD.toString()) || condition.toUpperCase().equals(mongo_DB.Conditions.NEW.toString()) || condition.toUpperCase().equals(mongo_DB.Conditions.USED.toString()))));
    }
}
