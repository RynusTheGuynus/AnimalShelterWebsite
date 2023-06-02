package com.techelevator.controller;

import com.techelevator.model.EmailService;
import com.techelevator.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class EmailController {


    @Autowired
    private EmailService emailService;
    private User user;

    @PostMapping("/messages/approved")
    String sendEmailApproveMessage(@RequestBody String email) {
        this.emailService.sendApproveEmail(
                email,
                "Rising Sun Animal Shelter: Volunteer Request",
                "Thank you for applying to be a volunteer at Rising Sun Animal Shelter! We are happy to say that you meet all of the qualifications we are looking for! Please visit our website and login!"
        );
        return "Message Sent (approved)";
    }

    @PostMapping("/messages/declined")
    String sendEmailDeclineMessage(@RequestBody String email) {
        this.emailService.sendDeclineEmail(
                email,
                "Rising Sun Animal Shelter: Volunteer Request",
                "Thank you for applying to be a volunteer at Rising Sun Animal Shelter! Unfortunately, we are sad to say that one or more submits on your form conflict with our volunteer criteria. You may apply again after reviewing our terms or try calling us directly (555) 555-5555"
        );
        return "Message Sent (declined)";
    }
}