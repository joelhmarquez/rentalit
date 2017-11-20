package com.rentalit.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.rentalit.models.Listing;
import com.rentalit.models.MongoDB;

@Controller
public class RentalitController {

    @GetMapping("/post")
    public String listingForm(Model model) {
        model.addAttribute("listing", new Listing());
        return "post";
    }

    @PostMapping("/post")
    public String listingSubmit(@ModelAttribute Listing listing) {
        MongoDB mongoDB = new MongoDB();
        mongoDB.addListing(listing);
        return "result";
    }
}