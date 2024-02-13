package com.fleetmanagement.demo.controller;

import com.fleetmanagement.demo.model.Taxi; 
import com.fleetmanagement.demo.service.TaxiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/taxis")
public class TaxiController {

    @Autowired
    private TaxiService taxiService;

    @GetMapping
    public ResponseEntity<Object> getAllTaxis(@PageableDefault(size = 10) Pageable pageable) {
        Map<String, Object> map = new HashMap<>();

        try {
            Page<Taxi> taxis = taxiService.findAll(pageable);
            return new ResponseEntity<>(taxis, HttpStatus.OK);
        } catch (Exception e) {
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}