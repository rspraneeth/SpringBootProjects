package com.rsp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class MailSenderApplication {


    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(MailSenderApplication.class, args);

        EmailSenderService service = context.getBean(EmailSenderService.class);
        service.sendEmail("praneeth.3j2@gmail.com", "Test", "Hi Just testing java mail sender service!!! Hope it works.");

    }


}
