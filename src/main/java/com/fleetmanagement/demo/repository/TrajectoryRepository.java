package com.fleetmanagement.demo.repository;

import com.fleetmanagement.demo.model.Trajectory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface TrajectoryRepository extends JpaRepository<Trajectory, Long> {

    Page<Trajectory> findByTaxi_IdAndDate(Long taxiId, LocalDateTime date, Pageable pageable);
}