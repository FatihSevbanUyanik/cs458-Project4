package com.example.coronatracking.application.service.impl;

import com.example.coronatracking.application.model.entity.EntityTrack;
import com.example.coronatracking.application.model.entity.EntityUser;
import com.example.coronatracking.application.model.request.RequestId;
import com.example.coronatracking.application.model.request.RequestTrack;
import com.example.coronatracking.application.model.response.ResponseOperation;
import com.example.coronatracking.application.model.response.ResponseTrack;
import com.example.coronatracking.application.repo.RepoTrack;
import com.example.coronatracking.application.repo.RepoUser;
import com.example.coronatracking.application.security.JwtUserDetail;
import com.example.coronatracking.application.service.interfaces.ServiceTrack;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceTrackImpl implements ServiceTrack {

    private ModelMapper mapper;
    private RepoTrack repoTrack;
    private RepoUser repoUser;

    @Autowired
    public ServiceTrackImpl(RepoTrack repoTrack, RepoUser repoUser) {
        this.repoUser = repoUser;
        this.repoTrack = repoTrack;
        this.mapper = new ModelMapper();
    }

    @Override
    @Transactional
    public ResponseOperation createTrack(RequestTrack requestTrack) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Long userId = ((JwtUserDetail) auth.getPrincipal()).getId();
        Optional<EntityUser> optional = repoUser.findById(userId);
        if (!optional.isPresent()) {
            throw new RuntimeException("User not found");
        }

        EntityUser entityUser = optional.get();
        EntityTrack entityTrack = mapper.map(requestTrack, EntityTrack.class);

        int metric = 0;
        int symptomCount = 0;

        if (entityTrack.isFever()) { metric += 3; symptomCount++; }
        if (entityTrack.isDifficultBreathing()) { metric += 3; symptomCount++; }
        if (entityTrack.isCough()) { metric += 3; symptomCount++; }
        if (entityTrack.isTiredness()) { metric += 2; symptomCount++; }
        if (entityTrack.isChestPain()) { metric += 2; symptomCount++; }
        if (entityTrack.isChills()) { metric += 1; symptomCount++; }
        if (entityTrack.isHeadAche()) { metric += 1; symptomCount++; }
        if (entityTrack.isMuscleAche()) { metric += 1; symptomCount++; }
        if (entityTrack.isSoreThroat()) { metric += 1; symptomCount++; }
        if (entityTrack.isRunnyNose()) { metric += 1; symptomCount++; }

        if (metric <= 6) { entityTrack.setStatus("Low Risk"); }
        else if (metric <= 10) { entityTrack.setStatus("Medium Risk"); }
        else { entityTrack.setStatus("High Risk"); }
        entityTrack.setSymptomCount(symptomCount);
        entityUser.addTrack(entityTrack);
        repoUser.save(entityUser);
        return new ResponseOperation(true, "Track Created", "CREATE");
    }

    @Override
    @Transactional
    public List<ResponseTrack> retrieveTracks() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Long userId = ((JwtUserDetail) auth.getPrincipal()).getId();

        Optional<EntityUser> optional = repoUser.findById(userId);
        if (!optional.isPresent()) {
            throw new RuntimeException("User not found");
        }

        EntityUser entityUser = optional.get();
        List<EntityTrack> entityTracks = repoTrack.findAllByCreatorOrderByCreatedAtDesc(entityUser);

        Type listType = new TypeToken<List<ResponseTrack>>() {}.getType();
        return mapper.map(entityTracks, listType);
    }

    @Override
    @Transactional
    public ResponseOperation deleteTrack(RequestId requestId) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Long userId = ((JwtUserDetail) auth.getPrincipal()).getId();

        Optional<EntityTrack> optional = repoTrack.findByCreatorIdAndId(userId, requestId.getId());
        if (!optional.isPresent()) { throw new RuntimeException("Track not found"); }

        EntityTrack entityTrack = optional.get();
        repoTrack.delete(entityTrack);
        return new ResponseOperation(true, "Track Deleted", "DELETE");
    }

}
