package com.tempusmachina.app.event;

import com.tempusmachina.app.model.Media;
import org.springframework.context.ApplicationEvent;

public class MediaEvent extends ApplicationEvent {

	private static final long serialVersionUID = 1L;
	private Media profile;

    public MediaEvent(Object source, Media profile) {
        super(source);
        this.profile = profile;
    }

    public Media getMedia() {
        return profile;
    }
}
