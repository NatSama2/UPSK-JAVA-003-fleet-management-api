package com.fleetmanagement.demo.service;

import com.fleetmanagement.demo.model.Trajectory;
import com.fleetmanagement.demo.repository.TrajectoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

//import java.time.LocalDateTime;

@Service
public class TrajectoryServiceImpl implements TrajectoryService {

    @Autowired
    private TrajectoryRepository trajectoryRepository;

    @Override
    public Page<Trajectory> getTrajectoryHistory(Long taxiId, String date, Pageable pageable) {
        System.out.println("Searching trajectories for taxiId: " + taxiId + ", date: " + date);


        Page<Trajectory> result = trajectoryRepository.findByTaxi_Id(taxiId, date,  pageable);

        System.out.println("Found " + result.getTotalElements() + " trajectories.");

        return result;
    }
}