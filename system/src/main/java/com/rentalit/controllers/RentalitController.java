package com.rentalit.controllers;

import com.rentalit.error.InvalidListingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.rentalit.models.Listing;
import com.rentalit.models.MongoDB;

@Controller
public class RentalitController {

//    @GetMapping("/post")
//    public String listingForm( Model model) {
//        model.addAttribute("listing", new Listing());
//        return "post";
//    }
//
//    @PostMapping("/post")
//    public String listingSubmit(@ModelAttribute Listing listing) {
//        MongoDB mongoDB = new MongoDB();
//        mongoDB.addListing(listing);
//        return "result";
//    }

    @RequestMapping(method = RequestMethod.POST, value = "/createListing")
    public ResponseEntity<?> createListing(@RequestBody Listing listing) {
        try {
            MongoDB mongo = new MongoDB();
            mongo.addListing(listing);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (InvalidListingException e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}