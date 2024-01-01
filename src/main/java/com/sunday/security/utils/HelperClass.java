package com.sunday.security.utils;

import com.sunday.security.exceptions.ApplicationException;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import java.io.UnsupportedEncodingException;

public class HelperClass {

    public void sendEmail(
            String firstName,
            String url,
            JavaMailSender mailSender,
            String sendMail,
            String recipient,
            String action,
            String serviceProvider,
            String subject,
            String description
    ) {

        try {
            String mailContent ="<div style='padding: 1rem; background-color: rgb(138, 36, 36); color: white'>"
                    + "<p style='text-align: center'>"
                    + "<img src=" + AppUtils.LOGO + " style='width: 8rem; height: 10rem'></p>"
                    + "<hr style='color: black'>"
                    + "<p> Hi, " + firstName + " </p>"
                    + "<p> " + description + " </p>"
                    + "<a href=" + url + " style='padding: 0.7rem; background-color: #383896; text-decoration: none; border-radius: 0.3rem; color: white'>" + action + "</a> <br>"
                    + "<p> Thank you. <br> " + serviceProvider + " </p>"
                    + "</div>";

            MimeMessage message = mailSender.createMimeMessage();

            var messageHelper = new MimeMessageHelper(message);

            messageHelper.setFrom(sendMail, serviceProvider);
            messageHelper.setTo(recipient);
            messageHelper.setSubject(subject);
            messageHelper.setText(mailContent, true);

            mailSender.send(message);

        } catch (MailException | MessagingException | UnsupportedEncodingException e) {
            throw new ApplicationException(e.getMessage());
        }
    }
}
