package com.fleetmanagement.demo.repository;

import com.fleetmanagement.demo.model.Trajectory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

//import java.sql.Timestamp;
import java.time.LocalDateTime;
//import java.util.Date;

public  interface TrajectoryRepository extends JpaRepository<Trajectory, Integer> {
    Page<Trajectory> findByTaxiIdAndDateGreaterThanEqual(int taxi_id, LocalDateTime date, Pageable pageable);
}