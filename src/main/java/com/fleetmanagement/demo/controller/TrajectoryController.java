package com.fleetmanagement.demo.controller;

import com.fleetmanagement.demo.model.Trajectory;
import com.fleetmanagement.demo.service.TrajectoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
//import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
//import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/trajectory")
@Tag(name = "Trajectories", description = "Colección de endpoints para obtener ubicaciones de los taxis")
public class TrajectoryController {

    @Autowired
    private TrajectoryService trajectoryService;

    @GetMapping(value = "/getTrajectoryHistory/{id}")
    @Operation(summary = "Obtiene todas las ubicaciones por id y fecha")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Page.class))
            }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) })})
    public ResponseEntity<Object> getTrajectoryHistory(
            @PathVariable Long id,
            @RequestParam(value = "date", required = true) String date,
            Pageable pageable) {
        Map<String, Object> map = new HashMap<>();
        try {
            //LocalDateTime dateSearch = date.atStartOfDay();
            Page<Trajectory> list = trajectoryService.getTrajectoryHistory(id, date, pageable);
            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception e) {
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}