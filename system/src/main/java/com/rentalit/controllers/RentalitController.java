package com.rentalit.controllers;

import com.rentalit.error.InvalidListingException;

import java.util.List;

import com.rentalit.models.Calendar;
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
import com.rentalit.models.Scheduler;

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

    @GetMapping("/search")
    public void searchForm( Model model) {
        model.addAttribute("listing", new Listing());
    }

    @PostMapping("/searchresult")
    public String submitSearch(Model model, @ModelAttribute Listing listing) {
        Document query = mongo.query_builder(listing);
        log.info("Querying for: " + query.toString());
        List <Listing> results = mongo.search_Item(query);
        model.addAttribute("results", results);
        log.info("Successful search");
        model.addAttribute("listing", new Listing());
        return "searchresult";
    }
    
    @PostMapping("/rent")
    public String rentPreview( Model model, @ModelAttribute Listing listing) {
        listing.setCalendar(new Calendar());
        return "rent";
    }
    
    @PostMapping("/rentcheckout")
    public String rentItemc(Model model, @ModelAttribute Listing listing) {
    		Scheduler scheduler = new Scheduler();
    		scheduler.requestRental(listing);
    		return "succesfully rented item";
    }
}