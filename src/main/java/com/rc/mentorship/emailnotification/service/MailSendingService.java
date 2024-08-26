package com.rc.mentorship.emailnotification.service;

import com.rc.mentorship.emailnotification.dto.ReservationMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailSendingService {
    @Value("${spring.mail.username}")
    private String from;
    private static final String ADDRESS_POSTFIX = "@yandex.ru";

    private final JavaMailSender mailSender;

    public void send(ReservationMessage kafkaMessage) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from + ADDRESS_POSTFIX);
        message.setSubject("Бронирование рабочего места");
        message.setText(createMessageText(kafkaMessage));
        message.setTo(kafkaMessage.getEmail());

        mailSender.send(message);
    }

    private String createMessageText(ReservationMessage kafkaMessage) {
        String result = "Уважаемый пользователь, вы забронировали рабочее место c ID %s на период с %s до %s";
        return String.format(result, kafkaMessage.getWorkplaceId(),
                kafkaMessage.getStartDateTime(), kafkaMessage.getEndDateTime());
    }
}
