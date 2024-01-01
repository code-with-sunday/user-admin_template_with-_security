package com.sunday.security.events.eventListener;

import com.sunday.security.events.events.CompleteRegistrationEvent;
import com.sunday.security.security.JwtTokenProvider;
import com.sunday.security.service.EmailSenderService;
import com.sunday.security.utils.SecurityConstants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Slf4j
@Async
@Component
@RequiredArgsConstructor
public class CompleteRegistrationEventListener implements ApplicationListener<CompleteRegistrationEvent> {
    private final EmailSenderService emailSenderService;
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public void onApplicationEvent(CompleteRegistrationEvent event) {

        String verificationToken = jwtTokenProvider.generateValidationToken(event.getEmail(), SecurityConstants.JWT_EXPIRATION);

        // Build the verification url to be sent to the user
        String url = event.getApplicationUrl() + "/auth/register/verify-email?email=" + event.getEmail() + "&token=" + verificationToken;

        // Send the email to the user
        emailSenderService.sendRegistrationEmailVerification(url, event.getEmail(), event.getFirstName());

        log.info("Click the link to verify your email and change ur password : {}", url);
    }
}
