package com.fleetmanagement.demo.modelTest;

import com.fleetmanagement.demo.model.Taxi;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TaxiTest {

    @Test
    public void testSetAndGetId() {
        Taxi taxi = new Taxi();

        // Usar un valor de tipo Long para setId
        Long idValue = 1L;
        taxi.setId(idValue);

        // Verificar que getId devuelve el valor correcto
        assertEquals(idValue, taxi.getId());
    }
}
