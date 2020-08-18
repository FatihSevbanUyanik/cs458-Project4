package com.example.coronatracking.application.service.interfaces;

import com.example.coronatracking.application.model.request.RequestId;
import com.example.coronatracking.application.model.request.RequestTrack;
import com.example.coronatracking.application.model.response.ResponseOperation;
import com.example.coronatracking.application.model.response.ResponseTrack;

import java.util.List;

public interface ServiceTrack {
    ResponseOperation createTrack(RequestTrack requestTrack);
    List<ResponseTrack> retrieveTracks();
    ResponseOperation deleteTrack(RequestId requestId);
}
