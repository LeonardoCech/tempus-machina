package com.tempusmachina.app.controller;

import com.tempusmachina.app.model.MediaDTO;
import com.tempusmachina.app.model.Profile;
import com.tempusmachina.app.mvvm.ProfileViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping("/profiles")
public class ProfileController {

    @Autowired private ProfileViewModel profileViewModel;

    @GetMapping
    public String showProfilesPage() {
        return "profiles";
    }

    @PostMapping
    public Profile create(@RequestBody Profile profile) {
        return profileViewModel.create(profile);
    }

    @GetMapping("/{id}")
    public Profile readOne(@PathVariable UUID id) {
        return profileViewModel.readOne(id);
    }

    @GetMapping("/all")
    public List<Profile> readAll() {
        return profileViewModel.readAll();
    }

    @PutMapping("/{id}")
    public Profile update(@PathVariable UUID id, @RequestBody Profile profile) {
        return profileViewModel.update(id, profile);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        profileViewModel.delete(id);
    }

    @GetMapping("/{id}/medias")
    public Set<MediaDTO> findMedias(@PathVariable UUID id) {
        return profileViewModel.readMedias(id);
    }

    @PostMapping("/{id}/medias")
    public void addMediaToProfile(@PathVariable UUID id, @RequestBody UUID mediaId) {
        profileViewModel.addMediaToProfile(id, mediaId);
    }

    @PutMapping("/{profileId}/medias/{mediaId}")
    public void updateMediaInProfile(@PathVariable UUID profileId, @PathVariable UUID mediaId, @RequestBody MediaDTO mediaDTO) {
        profileViewModel.updateMediaInProfile(profileId, mediaId, mediaDTO);
    }

    @DeleteMapping("/{profileId}/medias/{mediaId}")
    public void removeMediaFromProfile(@PathVariable UUID profileId, @PathVariable UUID mediaId) {
        profileViewModel.removeMediaFromProfile(profileId, mediaId);
    }
}
