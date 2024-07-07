package com.tempusmachina.app.model;

import java.util.List;
import java.util.UUID;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class MediaDTO {

    private UUID id;
    private String type;
    private String name;
    private String bannerLink;
    private String youtubeLink;
    private String wikipediaLink;
    private List<String> streamingLinks;
    private long createdAt;
    private long updatedAt;    
}
