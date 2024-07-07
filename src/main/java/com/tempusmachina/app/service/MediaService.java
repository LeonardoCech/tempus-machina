package com.tempusmachina.app.service;

import com.tempusmachina.app.model.Media;
import com.tempusmachina.app.repository.MediaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MediaService {

    @Autowired private MediaRepository mediaRepository;

    public Media create(Media profile) {
        profile.setCreatedAt(System.currentTimeMillis());
        profile.setUpdatedAt(System.currentTimeMillis());
        return mediaRepository.save(profile);
    }

    public Media update(UUID id, Media profile) {
        if (!mediaRepository.existsById(id)) {
            return null;
        }
        profile.setUpdatedAt(System.currentTimeMillis());
        return mediaRepository.save(profile);
    }

    public List<Media> readAll() {
        return mediaRepository.findAll();
    }

    public Media getById(UUID id) {
        return mediaRepository.findById(id).orElse(null);
    }

    public void delete(UUID id) {
        mediaRepository.deleteById(id);
    }
}
