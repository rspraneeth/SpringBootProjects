package com.rsp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSendException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(String toEmail, String subject, String body){
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("hashtagrsp@gmail.com");
            message.setTo(toEmail);
            message.setText(body);
            message.setSubject(subject);
            mailSender.send(message);
            System.out.println("Mail sent successfully...");
        } catch (MailSendException e){
            System.out.println(e.getMessage());
        }

    }
}
