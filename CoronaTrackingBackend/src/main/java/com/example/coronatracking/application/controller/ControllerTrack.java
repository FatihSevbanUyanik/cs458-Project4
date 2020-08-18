package com.example.coronatracking.application.controller;

import com.example.coronatracking.application.model.request.RequestId;
import com.example.coronatracking.application.model.request.RequestTrack;
import com.example.coronatracking.application.model.response.ResponseOperation;
import com.example.coronatracking.application.model.response.ResponseTrack;
import com.example.coronatracking.application.service.interfaces.ServiceTrack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/track")
public class ControllerTrack {

    private ServiceTrack serviceTrack;

    @Autowired
    public ControllerTrack(ServiceTrack serviceTrack) {
        this.serviceTrack = serviceTrack;
    }

    @PostMapping
    public ResponseEntity<ResponseOperation> createTrack(@RequestBody RequestTrack requestTrack) {
        return ResponseEntity.ok(serviceTrack.createTrack(requestTrack));
    }

    @GetMapping
    public ResponseEntity<List<ResponseTrack>> getTracks() {
        return ResponseEntity.ok(serviceTrack.retrieveTracks());
    }

    @DeleteMapping
    public ResponseEntity<ResponseOperation> deleteTrack(@RequestBody RequestId requestId) {
        return ResponseEntity.ok(serviceTrack.deleteTrack(requestId));
    }

}
