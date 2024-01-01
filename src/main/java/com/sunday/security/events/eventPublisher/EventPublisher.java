package com.sunday.security.events.eventPublisher;

import com.sunday.security.events.events.CompleteRegistrationEvent;
import com.sunday.security.utils.AppUtils;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EventPublisher {
    private final ApplicationEventPublisher eventPublisher;

    public void completeRegistrationEventPublisher(String email, String firstName, HttpServletRequest request) {
        eventPublisher.publishEvent(new CompleteRegistrationEvent(email, firstName, AppUtils.applicationUrl(request)));
    }
}
