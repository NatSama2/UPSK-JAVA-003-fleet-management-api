package com.fleetmanagement.demo.repository;

import com.fleetmanagement.demo.model.Taxi;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TaxiRepository extends JpaRepository<Taxi, Long> {

    Optional<Taxi> findByPlate(String plate);
}