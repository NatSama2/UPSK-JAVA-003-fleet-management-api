package com.fleetmanagement.demo.service;

import com.fleetmanagement.demo.model.Taxi;  
import com.fleetmanagement.demo.repository.TaxiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TaxiServiceImpl implements TaxiService {

    @Autowired
    private TaxiRepository taxiRepository;

    @Override
    public Page<Taxi> findAll(Pageable pageable) {
        Page<Taxi> result = taxiRepository.findAll(pageable != null ? pageable : Pageable.unpaged());
        return result;
    }

    // Otros métodos relacionados con TaxiService
}