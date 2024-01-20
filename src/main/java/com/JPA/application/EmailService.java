package com.JPA.application;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmailService {

    public void sendEmail(String to, String subject, String body) {
        System.out.println("Email send to: " + to + " - Subject: " + subject + " - Body: " + body);
    }

    @Bean
    public EmailService start() {
        return new EmailService();
    }
}