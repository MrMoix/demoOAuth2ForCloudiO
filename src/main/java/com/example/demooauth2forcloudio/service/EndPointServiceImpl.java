package com.example.demooauth2forcloudio.service;

import com.example.demooauth2forcloudio.entity.EndPoint;
import com.example.demooauth2forcloudio.repository.IEndPointRepository;
import org.springframework.stereotype.Service;

@Service
public class EndPointServiceImpl implements IEndPointService {

    private final IEndPointRepository endPointRepository;


    public EndPointServiceImpl(IEndPointRepository endPointRepository) {
        this.endPointRepository = endPointRepository;
    }

    @Override
    public Iterable<EndPoint> findAll() {
        return endPointRepository.findAll();
    }

    @Override
    public void deleteEndPoint(Long endPointId) {
        EndPoint endPoint = getEndPoint(endPointId);
        endPointRepository.delete(endPoint);
    }

    @Override
    public EndPoint getEndPoint(Long endPointId) {
        return endPointRepository.findById(Long.valueOf(endPointId)).orElseThrow(() -> new IllegalArgumentException("Invalid product id"));
    }
}
