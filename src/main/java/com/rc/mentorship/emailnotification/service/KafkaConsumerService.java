package com.rc.mentorship.emailnotification.service;

import com.rc.mentorship.emailnotification.dto.ReservationMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaConsumerService {
    private final MailSendingService mailSendingService;

    @KafkaListener(topicPattern = "${kafka.topic}", groupId = "${spring.kafka.consumer.group-id}")
    public void receiveReservationMessage(ReservationMessage message) {
        mailSendingService.send(message);
    }
}
