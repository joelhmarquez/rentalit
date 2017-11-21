package com.rentalit.controllers;

import com.rentalit.error.InvalidListingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.rentalit.models.Listing;
import com.rentalit.models.MongoDB;

@Controller
public class RentalitController {
	
	static Logger log = LoggerFactory.getLogger(RentalitController.class);

    @GetMapping("/post")
    public void listingForm( Model model) {
        model.addAttribute("listing", new Listing());
    }

	@PostMapping("/createListing")
    public ResponseEntity<?> createListing(@RequestBody Listing listing) {
        try {
            MongoDB mongo = new MongoDB();
            mongo.addListing(listing);            
            return new ResponseEntity<>(HttpStatus.OK);        
        } catch (InvalidListingException e) {
        		log.error("Unable to create posting", e);
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}