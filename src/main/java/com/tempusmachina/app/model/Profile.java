package com.tempusmachina.app.model;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="profile")
@NoArgsConstructor
@Getter
@Setter
public class Profile {
    @Id
    @UuidGenerator(style = UuidGenerator.Style.TIME)
    private UUID id;
    
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private long createdAt;
    private long updatedAt;

	@ManyToMany
    @JoinTable(
        name = "profile_media",
        joinColumns = @JoinColumn(name = "profile_id"),
        inverseJoinColumns = @JoinColumn(name = "media_id")
    )
    private Set<Media> medias = new HashSet<>();
}
