package com.sunday.security.repository;

import com.sunday.security.entities.user.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<AppUser, Long> {
    Optional<AppUser> findUsersByEmail(String email);

    Boolean existsByEmail(String email);
}
