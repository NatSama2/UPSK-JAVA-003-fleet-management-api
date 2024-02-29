package com.fleetmanagement.demo.modelTest;

import com.fleetmanagement.demo.model.Taxi;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TaxiTest {

    @Test
    public void testTaxiGettersAndSetters() {
        // Arrange
        Taxi taxi = new Taxi();
        taxi.setId(1);
        taxi.setPlate("ABC123");

        // Act
        int id = taxi.getId();
        String plate = taxi.getPlate();

        // Assert
        assertThat(id).isEqualTo(1);
        assertThat(plate).isEqualTo("ABC123");
    }
}