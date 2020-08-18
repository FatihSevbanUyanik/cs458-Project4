package com.example.coronatracking.application.repo;

import com.example.coronatracking.application.model.entity.EntityTrack;
import com.example.coronatracking.application.model.entity.EntityUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RepoTrack extends JpaRepository<EntityTrack, Long> {
    List<EntityTrack> findAllByCreatorOrderByCreatedAtDesc(EntityUser entityUser);
    Optional<EntityTrack> findByCreatorIdAndId(Long creatorId, Long id);
}
