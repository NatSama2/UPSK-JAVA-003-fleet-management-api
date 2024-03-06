package com.fleetmanagement.demo.repository;

import com.fleetmanagement.demo.model.Trajectory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

//import java.time.LocalDateTime;

public interface TrajectoryRepository extends JpaRepository<Trajectory, Long> {

    //Page<Trajectory> findByTaxi_Id(Long taxiId, Pageable pageable);
    @Query (value= "SELECT * FROM trajectories t WHERE taxi_id = :taxiId AND TO_CHAR(date, 'dd-MM-yyyy') = :date", nativeQuery = true)
    Page<Trajectory> findByTaxi_Id(Long taxiId, String date, Pageable pageable);

    @Query("SELECT t FROM Trajectory t WHERE t.taxi.id = :taxiId AND (t.taxi.id, t.date) IN (SELECT t2.taxi.id, MAX(t2.date) FROM Trajectory t2 WHERE t2.taxi.id = :taxiId GROUP BY t2.taxi.id)")
    Page<Trajectory> findLastLocations(@Param("taxiId") Long taxiId, Pageable pageable);
}