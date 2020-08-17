package com.example.coronatracking.application.repo;

import com.example.coronatracking.application.model.entity.EntityUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RepoUser extends JpaRepository<EntityUser, Long> {
    boolean existsByEmailOrUsername(String email, String username);
    Optional<EntityUser> findByUsernameOrEmail(String username, String email);
    Optional<EntityUser> findByEmail(String email);
    Optional<EntityUser> findByPasswordResetToken(String token);
}
