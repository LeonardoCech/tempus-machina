package com.tempusmachina.app.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class MediaEventListener {

    @EventListener
    public void handleMediaEvent(MediaEvent event) {
        // handle the event
        System.out.println("Media event received: " + event.getMedia());
    }
}
