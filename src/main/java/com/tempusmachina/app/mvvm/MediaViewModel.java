package com.tempusmachina.app.mvvm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.tempusmachina.app.model.Media;
import com.tempusmachina.app.service.MediaService;

import java.util.List;
import java.util.UUID;

@Component
public class MediaViewModel {

    @Autowired
    private MediaService profileService;

    public Media create(Media user) {
        return profileService.create(user);
    }

    public Media readOne(UUID id) {
        return profileService.getById(id);
    }

    public List<Media> readAll() {
        return profileService.readAll();
    }

    public Media update(UUID id, Media user) {
        return profileService.update(id, user);
    }

    public void delete(UUID id) {
        profileService.delete(id);
    }
}
