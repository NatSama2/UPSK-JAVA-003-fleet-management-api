package com.fleetmanagement.demo.controllerTest;

import com.fleetmanagement.demo.controller.TaxiController;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootTest
public class TaxiControllerTest {

    @Autowired
    private TaxiController taxiController;

    @Test
    public void testGetAllTaxis() {
        // Aquí puedes agregar pruebas para el método getAllTaxis del controlador
        // Asegúrate de mockear o configurar un entorno controlado para las pruebas
        assertNotNull(taxiController.getAllTaxis(null));
    }
}

