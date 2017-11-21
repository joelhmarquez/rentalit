package com.rentalit.resources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rentalit.error.InvalidListingException;

public class Validator {
	static Logger log = LoggerFactory.getLogger(Validator.class);
			
    public static void validate(String productName, String description, String condition) throws InvalidListingException{
        if(!(productName.length()>0)){
        		log.error("Invalid Posting: Empty Name");
            throw new InvalidListingException("Invalid Product Name!");
        }
        if(!(description.length()>0)){
        		log.error("Invalid Posting: Empty Description");
            throw new InvalidListingException("Please enter a Description");
        }
        if(!((condition.toUpperCase().equals(Condition.BAD.toString()) || condition.toUpperCase().equals(Condition.GOOD.toString()) || condition.toUpperCase().equals(Condition.NEW.toString()) || condition.toUpperCase().equals(Condition.USED.toString())))){
        		log.error("Invalid Posting: Invalid Condition");
        		throw new InvalidListingException("Please Enter one of the Following for your Condition : BAD, USED, GOOD, NEW");
        }
    }
}
