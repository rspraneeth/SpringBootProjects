package com.rsp.loginendtoendapp.event.listener;

import com.rsp.loginendtoendapp.event.RegistrationCompleteEvent;
import com.rsp.loginendtoendapp.registration.token.VerificationTokenService;
import com.rsp.loginendtoendapp.user.User;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class RegistrationCompleteEventListener implements ApplicationListener<RegistrationCompleteEvent> {
    private final VerificationTokenService tokenService;
    private final JavaMailSender mailSender;
    private User user;

    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {
        //get the user
        user = event.getUser();
        //2. generate a  token for the user
        String vToken = UUID.randomUUID().toString();
        //3. save the token for the user
        tokenService.saveVerificationTokenForUser(user, vToken);
        //4. Build the verification url
        String url = event.getConfirmationUrl() + "registration/verifyEmail?token" + vToken;
        //5. send the email to user
        try {
            sendVerificationEmail(url);
        } catch (MessagingException | UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public void sendVerificationEmail(String url) throws MessagingException, UnsupportedEncodingException {
        //build the email
        String subject = "Email Verification";
        String senderName = "User Verification Portal Service";
        String mailContent = "<p> Hi, " + user.getFirstName() + ",</p>" +
                "<p>Thank you for registering with us. Please click on the below link to verify your email address.</p>" +
                "<a href=\"" + url + "\">Verify Email to activate  account</a>" +
                "<p>Thank you.</p>";
        //send the email
        emailMessage(subject, senderName, mailContent, mailSender, user);

    }

    private void emailMessage(String subject, String senderName, String mailContent, JavaMailSender mailSender, User theUser) throws MessagingException, UnsupportedEncodingException {
        MimeMessage  message = mailSender.createMimeMessage();
        var messageHelper = new MimeMessageHelper(message);
        messageHelper.setFrom("hashtagrsp@gmail.com", senderName);
        messageHelper.setTo(theUser.getEmail());
        messageHelper.setSubject(subject);
        messageHelper.setText(mailContent, true);
        mailSender.send(message);
    }

}
