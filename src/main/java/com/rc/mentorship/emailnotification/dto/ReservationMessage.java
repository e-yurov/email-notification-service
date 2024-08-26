package com.rc.mentorship.emailnotification.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class ReservationMessage {
    private String email;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private UUID workplaceId;
}
