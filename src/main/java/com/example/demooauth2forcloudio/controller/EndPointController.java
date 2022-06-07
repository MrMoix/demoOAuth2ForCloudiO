package com.example.demooauth2forcloudio.controller;

import com.example.demooauth2forcloudio.dto.EndPointDto;
import com.example.demooauth2forcloudio.entity.EndPoint;
import com.example.demooauth2forcloudio.service.IEndPointService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
public class EndPointController {

    private IEndPointService endPointService;

    public EndPointController(IEndPointService endPointService) {
        this.endPointService = endPointService;
    }

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/api/test/message")
    public String test() {
        return "Tu ne peux pas accéder aux données";
    }

    @GetMapping("/api/endpoint/{endPointId}")
    public EndPoint getProduct(@PathVariable("endPointId") Long endPointId){
        return endPointService.getEndPoint(endPointId);
    }

    @DeleteMapping("/api/endpoint/{endPointId}")
    public void deleteProduct(@PathVariable("endPointId") Long endPointId){
        endPointService.deleteEndPoint(endPointId);
    }

    @GetMapping("/api/endpoint")
    public Collection<EndPointDto> findAll() {
        Iterable<EndPoint> boards = this.endPointService.findAll();
        List<EndPointDto> endPointDtos = new ArrayList<>();
        boards.forEach(b -> endPointDtos.add(convertToDto(b)));
        return endPointDtos;
    }

    protected EndPointDto convertToDto(EndPoint endPoint) {
        EndPointDto endPointDto = modelMapper.map(endPoint, EndPointDto.class);
        return endPointDto;
    }
}
