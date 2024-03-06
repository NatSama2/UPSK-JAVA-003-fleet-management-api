package com.fleetmanagement.demo.service;

import com.fleetmanagement.demo.model.Trajectory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

//import java.time.LocalDateTime;

public interface TrajectoryService {
    Page<Trajectory> getTrajectoryHistory(Long taxiId, String date, Pageable pageable);

    Page<Trajectory> getLastLocations(Long taxiId, Pageable pageable);
}