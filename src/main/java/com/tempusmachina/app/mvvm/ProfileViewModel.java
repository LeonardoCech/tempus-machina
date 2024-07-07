package com.tempusmachina.app.mvvm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tempusmachina.app.model.MediaDTO;
import com.tempusmachina.app.model.Profile;
import com.tempusmachina.app.service.ProfileService;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Component
public class ProfileViewModel {

    @Autowired
    private ProfileService profileService;

    public Profile create(Profile user) {
        return profileService.create(user);
    }

    public Profile readOne(UUID id) {
        return profileService.getById(id);
    }

    public List<Profile> readAll() {
        return profileService.readAll();
    }

    public Profile update(UUID id, Profile user) {
        return profileService.update(id, user);
    }

    public void delete(UUID id) {
        profileService.delete(id);
    }

    public Set<MediaDTO> readMedias(UUID id) {
        return profileService.readMedias(id);
    }

    public void addMediaToProfile(UUID profileId, UUID mediaId) {
        profileService.addMediaToProfile(profileId, mediaId);
    }

    public void updateMediaInProfile(UUID profileId, UUID mediaId, MediaDTO mediaDTO) {
        profileService.updateMediaInProfile(profileId, mediaId, mediaDTO);
    }

    public void removeMediaFromProfile(UUID profileId, UUID mediaId) {
        profileService.removeMediaFromProfile(profileId, mediaId);
    }
}
