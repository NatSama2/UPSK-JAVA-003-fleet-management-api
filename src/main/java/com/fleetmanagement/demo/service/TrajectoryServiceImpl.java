package com.fleetmanagement.demo.service;

import com.fleetmanagement.demo.model.Trajectory;
import com.fleetmanagement.demo.repository.TrajectoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class TrajectoryServiceImpl implements TrajectoryService {

    @Autowired
    private TrajectoryRepository trajectoryRepository;

    public TrajectoryServiceImpl(TrajectoryRepository trajectoryRepository) {
        this.trajectoryRepository = trajectoryRepository;
    }

    @Override
    public Page<Trajectory> findByTaxiIdAndDateGreaterThanEqual(int taxiId, LocalDateTime date, Pageable pageable) {
        return trajectoryRepository.findByTaxiIdAndDateGreaterThanEqual(taxiId, date, pageable);
    }
}