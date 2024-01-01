package com.sunday.security.service.serviceImpl;

import com.sunday.security.entities.admin.Admin;
import com.sunday.security.repository.AdminReposiory;
import com.sunday.security.service.EmailSenderService;
import com.sunday.security.utils.HelperClass;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class EmailSenderServiceImpl implements EmailSenderService {
    private final JavaMailSender mailSender;
    private final HelperClass helperClass;
    private final AdminReposiory adminReposiory;

    private Admin admin;

    @Value("${spring.mail.username}")
    private String sendMail;

    @Override
    public void sendRegistrationEmailVerification(String url, String email, String firstName) {
        String action = "Verify Email";
        String serviceProvider = "Ochefi-Technologies Select Registration Portal Service";
        String subject = "Email Verification";
        String description = "Please follow the link below to complete your registration, as this link will expire in 5min.";

        helperClass.sendEmail(
                firstName,
                url,
                mailSender,
                sendMail,
                email,
                action,
                serviceProvider,
                subject,
                description
        );
    }
}
