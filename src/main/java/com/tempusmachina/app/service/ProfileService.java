package com.tempusmachina.app.service;

import com.tempusmachina.app.config.Utils;
import com.tempusmachina.app.model.Media;
import com.tempusmachina.app.model.MediaDTO;
import com.tempusmachina.app.model.Profile;
import com.tempusmachina.app.repository.ProfileRepository;
import com.tempusmachina.app.repository.MediaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProfileService implements UserDetailsService {

    @Autowired private Utils utils;
    @Autowired private ProfileRepository profileRepository;
    @Autowired private MediaRepository mediaRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Profile profile = profileRepository.findByEmail(email)
            .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));

        return org.springframework.security.core.userdetails.User
            .withUsername(profile.getEmail())
            .password(profile.getPassword())
            .roles("USER")
            .build();
    }

    public Profile create(Profile profile) {
        profile.setPassword(
            utils.passwordEncoder().encode(profile.getPassword())
        );
        profile.setCreatedAt(System.currentTimeMillis());
        profile.setUpdatedAt(System.currentTimeMillis());

        return profileRepository.save(profile);
    }

    public Profile update(UUID id, Profile profile) {
        if (!profileRepository.existsById(id)) {
            return null;
        }
        profile.setUpdatedAt(System.currentTimeMillis());
        return profileRepository.save(profile);
    }

    public List<Profile> readAll() {
        return profileRepository.findAll();
    }

    public Profile getById(UUID id) {
        return profileRepository.findById(id).orElse(null);
    }

    public void delete(UUID id) {
        profileRepository.deleteById(id);
    }

    public Set<MediaDTO> readMedias(UUID profileId) {
        Profile profile = profileRepository.findById(profileId)
                .orElseThrow(() -> new RuntimeException("Profile not found"));

        return profile.getMedias().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toSet());
    }

    @Transactional
    public void addMediaToProfile(UUID profileId, UUID mediaId) {
        Profile profile = profileRepository.findById(profileId)
                .orElseThrow(() -> new RuntimeException("Profile not found"));

        Media media = mediaRepository.findById(mediaId)
                .orElseThrow(() -> new RuntimeException("Media not found"));

        profile.getMedias().add(media);
        profileRepository.save(profile);
    }

    @Transactional
    public void updateMediaInProfile(UUID profileId, UUID mediaId, MediaDTO mediaDTO) {
        Profile profile = profileRepository.findById(profileId)
                .orElseThrow(() -> new RuntimeException("Profile not found"));

        Media media = mediaRepository.findById(mediaId)
                .orElseThrow(() -> new RuntimeException("Media not found"));

        if (profile.getMedias().contains(media)) {
            media.setType(mediaDTO.getType());
            media.setName(mediaDTO.getName());
            media.setYoutubeLink(mediaDTO.getYoutubeLink());
            media.setWikipediaLink(mediaDTO.getWikipediaLink());
            media.setStreamingLinks(mediaDTO.getStreamingLinks());
            media.setUpdatedAt(mediaDTO.getUpdatedAt());
            mediaRepository.save(media);
        } else {
            throw new RuntimeException("Media not associated with profile");
        }
    }

    @Transactional
    public void removeMediaFromProfile(UUID profileId, UUID mediaId) {
        Profile profile = profileRepository.findById(profileId)
                .orElseThrow(() -> new RuntimeException("Profile not found"));

        Media media = mediaRepository.findById(mediaId)
                .orElseThrow(() -> new RuntimeException("Media not found"));

        if (profile.getMedias().contains(media)) {
            profile.getMedias().remove(media);
            profileRepository.save(profile);
        } else {
            throw new RuntimeException("Media not associated with profile");
        }
    }

    private MediaDTO convertToDTO(Media media) {
        MediaDTO mediaDTO = new MediaDTO();
        mediaDTO.setId(media.getId());
        mediaDTO.setType(media.getType());
        mediaDTO.setName(media.getName());
        mediaDTO.setYoutubeLink(media.getYoutubeLink());
        mediaDTO.setWikipediaLink(media.getWikipediaLink());
        mediaDTO.setStreamingLinks(media.getStreamingLinks());
        mediaDTO.setCreatedAt(media.getCreatedAt());
        mediaDTO.setUpdatedAt(media.getUpdatedAt());
        return mediaDTO;
    }
}
