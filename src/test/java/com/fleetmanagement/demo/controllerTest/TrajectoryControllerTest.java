package com.fleetmanagement.demo.controllerTest;

import com.fleetmanagement.demo.controller.TrajectoryController;
import com.fleetmanagement.demo.model.Trajectory;
import com.fleetmanagement.demo.service.TrajectoryService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Collections;
import java.util.Date;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(TrajectoryController.class)
public class TrajectoryControllerTest {

    @MockBean
    private TrajectoryService trajectoryService;

    @Autowired
    private MockMvc mockMvc;

    @SuppressWarnings("null")
    @Test
    public void testGetTrajectoryHistory() throws Exception {
        // Mock data
        Trajectory trajectory = new Trajectory();
        trajectory.setId(1L);
        trajectory.setDate(new Date());
        // Mock service response
        when(trajectoryService.getTrajectoryHistory(Mockito.anyLong(), Mockito.anyString(), Mockito.any(Pageable.class)))
                .thenReturn(new PageImpl<>(Collections.singletonList(trajectory)));

        // Perform GET request
        mockMvc.perform(MockMvcRequestBuilders.get("/api/trajectory/getTrajectoryHistory/{id}", 1L)
                .param("date", "2024-03-14"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.content[0].id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.content[0].date").exists());
    }

    @SuppressWarnings("null")
    @Test
    public void testGetLastLocations() throws Exception {
        // Mock data
        Trajectory trajectory = new Trajectory();
        trajectory.setId(1L);
        trajectory.setDate(new Date());
        // Mock service response
        when(trajectoryService.getLastLocations(Mockito.any(Pageable.class)))
                .thenReturn(new PageImpl<>(Collections.singletonList(trajectory)));

        // Perform GET request
        mockMvc.perform(MockMvcRequestBuilders.get("/api/trajectory/getLastLocations"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.content[0].id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.content[0].date").exists());
    }
}