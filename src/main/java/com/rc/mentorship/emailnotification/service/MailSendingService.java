package com.rc.mentorship.emailnotification.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailSendingService {
    private static final String ADDRESS_POSTFIX = "@yandex.ru";

    private final JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String from;

    public void send() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from + ADDRESS_POSTFIX);
        message.setSubject("Test subject");
        message.setText("test2");
        message.setTo(from + ADDRESS_POSTFIX);

        mailSender.send(message);
    }
}
