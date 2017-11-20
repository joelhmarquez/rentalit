package com.rentalit;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RentalitController {

    @GetMapping("/post")
    public String listingForm( Model model) {
        model.addAttribute("listing", new Listing());
        return "post";
    }

    @PostMapping("/post")
    public String listingSubmit(@ModelAttribute Listing listing) {
        return "result";
    }

}