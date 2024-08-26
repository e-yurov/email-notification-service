package com.rc.mentorship.emailnotification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class EmailNotificationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmailNotificationServiceApplication.class, args);
	}

}
