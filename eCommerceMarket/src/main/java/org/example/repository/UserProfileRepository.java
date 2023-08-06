package org.example.repository;

import org.example.model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface UserProfileRepository extends JpaRepository<UserProfile, Integer> {
}
