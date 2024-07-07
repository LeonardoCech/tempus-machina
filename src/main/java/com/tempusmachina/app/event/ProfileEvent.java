package com.tempusmachina.app.event;

import com.tempusmachina.app.model.Profile;
import org.springframework.context.ApplicationEvent;

public class ProfileEvent extends ApplicationEvent {

	private static final long serialVersionUID = 1L;
	private Profile profile;

    public ProfileEvent(Object source, Profile profile) {
        super(source);
        this.profile = profile;
    }

    public Profile getProfile() {
        return profile;
    }
}
