package com.fleetmanagement.demo.controller;

import com.fleetmanagement.demo.model.Trajectory;
import com.fleetmanagement.demo.service.TrajectoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/trajectories")
public class TrajectoryController {

    @Autowired
    private TrajectoryService trajectoryService;

    @GetMapping("/api/trajectories/taxi")
    public ResponseEntity<Page<Trajectory>> getTrajectoriesByTaxiAndDate(
            @RequestParam Long taxiId,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date date,
            Pageable pageable) {
        // Llama al servicio para obtener las trayectorias por taxi y fecha
        Page<Trajectory> trajectories = trajectoryService.getTrajectoriesByTaxiAndDate(taxiId, date, pageable);
        
        // Devuelve la respuesta con las trayectorias y el código de estado OK
        return new ResponseEntity<>(trajectories, HttpStatus.OK);

    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Map<String, Object>> handleException(Exception ex) {
        // Log the exception
        ex.printStackTrace();
    
        // Devuelve una respuesta personalizada
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("timestamp", LocalDateTime.now());
        responseBody.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        responseBody.put("error", "Internal Server Error");
        responseBody.put("message", "Ocurrió un error interno en el servidor.");
    
        // Utiliza el constructor adecuado de ResponseEntity
        return new ResponseEntity<>(responseBody, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }    