package com.fleetmanagement.demo.controllerTest;

import com.fleetmanagement.demo.controller.TaxiController;
import com.fleetmanagement.demo.model.Taxi;
import com.fleetmanagement.demo.service.TaxiService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Collections;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(TaxiController.class)
public class TaxiControllerTest {

    @MockBean
    private TaxiService taxiService;

    @Autowired
    private MockMvc mockMvc;

    @SuppressWarnings("null")
    @Test
    public void testGetTaxis() throws Exception {
        // Mock data
        Taxi taxi = new Taxi();
        taxi.setId(1);
        taxi.setPlate("ABC123");

        Pageable pageable = PageRequest.of(1, 10);
        Page<Taxi> taxisPage = new PageImpl<>(Collections.singletonList(taxi), pageable, 1);

        // Mock service response
        when(taxiService.findAll(pageable)).thenReturn(taxisPage);

        // Perform GET request
        mockMvc.perform(MockMvcRequestBuilders.get("/api/taxis"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.content[0].id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.content[0].plate").value("ABC123"));
    }

    @SuppressWarnings("null")
    @Test
    public void testGetTaxisError() throws Exception {
        // Mock service response with an exception
        when(taxiService.findAll(Mockito.any(Pageable.class))).thenThrow(new RuntimeException("Error fetching taxis"));

        // Perform GET request
        mockMvc.perform(MockMvcRequestBuilders.get("/api/taxis"))
                .andExpect(MockMvcResultMatchers.status().isInternalServerError())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Error fetching taxis"));
    }
}