package com.rentalit;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RentalitController {

    @RequestMapping("/post")
    public String greeting(@RequestParam(value="username", required=false, defaultValue="anonymous") String name, Model model) {
        model.addAttribute("name", name);
        return "post";
    }

}