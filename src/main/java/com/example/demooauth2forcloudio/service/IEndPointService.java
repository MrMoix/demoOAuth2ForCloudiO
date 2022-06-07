package com.example.demooauth2forcloudio.service;

import com.example.demooauth2forcloudio.entity.EndPoint;

public interface IEndPointService {
    Iterable<EndPoint> findAll();
    void deleteEndPoint(Long endPointId);
    EndPoint getEndPoint(Long endPointId);
}
