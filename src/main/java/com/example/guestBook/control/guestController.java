package com.example.guestBook.control;

import com.example.guestBook.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class guestController {

    @Autowired
    GuestService guestService;

    @GetMapping
    public String index() {
        return "index";
    }

}
