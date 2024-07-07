package com.tempusmachina.app.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.AccessLevel;


@Entity
@Table(name="media")
@NoArgsConstructor
@Getter
@Setter
public class Media {
	@Id
	@UuidGenerator(style = UuidGenerator.Style.TIME)
	private UUID id;
	
    private String type;
    private String name;
    private String bannerLink;
    private String youtubeLink;
    private String wikipediaLink;
    private List<String> streamingLinks;
	private long createdAt;
	private long updatedAt;

    @ManyToMany(mappedBy = "medias")
    @Getter(AccessLevel.NONE)
    private Set<Profile> profiles = new HashSet<>();
}
