package com.rentalit.controllers;

import com.rentalit.error.InvalidListingException;

import java.util.List;

import org.bson.Document;
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
	MongoDB mongo = new MongoDB();

    @GetMapping("/post")
    public void listingForm( Model model) {
        model.addAttribute("listing", new Listing());
    }

	@PostMapping("/createListing")
    public String createListing(@ModelAttribute Listing listing) {
        try {
            mongo.addListing(listing);            
            return "result";

        } catch (InvalidListingException e) {
        		log.error("Unable to create posting", e);
        		return "Unable to create posting.";

        }
    }
	
//	@GetMapping("/search")
//	public List<Document> queryAllListings() {
//		return mongo.search_Item("");
//	}
	
//	@GetMapping("/search")
//	public  queryListings() {
//		
//	}
}