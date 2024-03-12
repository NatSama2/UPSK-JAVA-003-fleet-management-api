package com.fleetmanagement.demo.repository;

import com.fleetmanagement.demo.model.Trajectory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.web.bind.annotation.RequestParam;

//import java.time.LocalDateTime;

public interface TrajectoryRepository extends JpaRepository<Trajectory, Long> {

    //Page<Trajectory> findByTaxi_Id(Long taxiId, Pageable pageable);
    @Query (value= "SELECT * FROM trajectories t WHERE taxi_id = :taxiId AND TO_CHAR(date, 'dd-MM-yyyy') = :date", nativeQuery = true)
    Page<Trajectory> findByTaxi_Id(Long taxiId, String date, Pageable pageable);

    @Query(value = "SELECT DISTINCT ON (t.taxi_id) t.* FROM trajectories t " +
    "ORDER BY t.taxi_id, t.date DESC",
    countQuery = "SELECT COUNT(DISTINCT taxi_id) FROM trajectories",
    nativeQuery = true)
    Page<Trajectory> findLastLocations(Pageable pageable);
}