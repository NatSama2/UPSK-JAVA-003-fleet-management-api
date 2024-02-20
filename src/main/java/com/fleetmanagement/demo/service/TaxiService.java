package com.fleetmanagement.demo.service;

import com.fleetmanagement.demo.model.Taxi;  
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TaxiService {
    Page<Taxi> findAll(Pageable pageable);
    
}