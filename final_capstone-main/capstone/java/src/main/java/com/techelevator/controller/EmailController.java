package com.techelevator.controller;

import com.techelevator.model.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class EmailController {


    @Autowired
    private EmailService emailService;


    @PostMapping("/messages")
    String sendEmailMessage() {
        this.emailService.sendEmail(
                "2053rwilliamson@gmail.com",
                "Test Subject",
                "Test Text"
        );
        return "Message Sent";
    }
}