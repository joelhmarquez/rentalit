package com.rentalit.resources;

import com.rentalit.error.InvalidListingException;

public class Validator {
    public static void validate(String productName, String description, String condition) throws InvalidListingException{
//        return (productName.length() > 0 && Description.length() > 0 && ((condition.toUpperCase().equals(Condition.BAD.toString()) || condition.toUpperCase().equals(Condition.GOOD.toString()) || condition.toUpperCase().equals(Condition.NEW.toString()) || condition.toUpperCase().equals(Condition.USED.toString()))));
        if(!(productName.length()>0)){
            throw new InvalidListingException("Invalid Product Name!");
        }
        if(!(description.length()>0)){
            throw new InvalidListingException("Please enter a Description");
        }
        if(!((condition.toUpperCase().equals(Condition.BAD.toString()) || condition.toUpperCase().equals(Condition.GOOD.toString()) || condition.toUpperCase().equals(Condition.NEW.toString()) || condition.toUpperCase().equals(Condition.USED.toString())))){
            throw new InvalidListingException("Please Enter one of the Following for your Condition : BAD, USED, GOOD, NEW");
        }
    }
}
