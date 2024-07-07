package com.tempusmachina.app.repository;

import com.tempusmachina.app.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.lang.NonNull;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, UUID> {
    
    Optional<Profile> findByEmail(String email);
    @NonNull
	Optional<Profile> findById(@NonNull UUID id);
}
