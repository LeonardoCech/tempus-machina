package com.tempusmachina.app.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.tempusmachina.app.model.Media;
import com.tempusmachina.app.mvvm.MediaViewModel;

@RestController
@RequestMapping("/medias")
public class MediaController {

    @Autowired private MediaViewModel mediaViewModel;

    @GetMapping
    public String showMediaPage() {
        return "media";
    }

    @PostMapping
    public Media create(@RequestBody Media media) {
        return mediaViewModel.create(media);
    }

    @GetMapping("/{id}")
    public Media readOne(@PathVariable UUID id) {
        return mediaViewModel.readOne(id);
    }

    @GetMapping("/all")
    public List<Media> readAll() {
        return mediaViewModel.readAll();
    }

    @PutMapping("/{id}")
    public Media update(@PathVariable UUID id, @RequestBody Media media) {
        return mediaViewModel.update(id, media);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        mediaViewModel.delete(id);
    }
}
