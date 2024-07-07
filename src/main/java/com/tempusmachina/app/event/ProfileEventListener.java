package com.tempusmachina.app.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ProfileEventListener {

    @EventListener
    public void handleProfileEvent(ProfileEvent event) {
        // handle the event
        System.out.println("Profile event received: " + event.getProfile());
    }
}
