package com.tempusmachina.app.repository;

import com.tempusmachina.app.model.Media;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.lang.NonNull;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface MediaRepository extends JpaRepository<Media, UUID> {
    
    Optional<Media> findByName(String name);
    Optional<Media> findByType(String type);
    @NonNull
	Optional<Media> findById(@NonNull UUID id);
}
