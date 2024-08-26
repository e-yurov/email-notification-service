package com.rc.mentorship.emailnotification.controller;

import com.rc.mentorship.emailnotification.service.MailSendingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/mail")
@RequiredArgsConstructor
public class MailController {
    private final MailSendingService mailSendingService;

    @PostMapping("/send")
    public void send() {
        mailSendingService.send(null);
    }
}
