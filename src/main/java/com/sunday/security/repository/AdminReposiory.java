package com.sunday.security.repository;

import com.sunday.security.entities.admin.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminReposiory extends JpaRepository<Admin, Long> {
    Optional<Admin> findUsersByEmail(String email);

    Boolean existsByEmail(String email);
}
