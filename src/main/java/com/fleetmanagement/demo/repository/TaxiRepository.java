package com.fleetmanagement.demo.repository;

import com.fleetmanagement.demo.model.Taxi;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaxiRepository extends JpaRepository<Taxi, Long> {
    // Puedes añadir consultas personalizadas si es necesario
}