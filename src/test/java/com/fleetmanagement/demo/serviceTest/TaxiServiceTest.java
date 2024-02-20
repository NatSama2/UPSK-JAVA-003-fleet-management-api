package com.fleetmanagement.demo.serviceTest;

import com.fleetmanagement.demo.model.Taxi;
import com.fleetmanagement.demo.service.TaxiService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.util.Assert;

@SpringBootTest
public class TaxiServiceTest {

    @Autowired
    private TaxiService taxiService;

    @Test
    public void testFindAll() {
        // Aquí puedes agregar pruebas para el servicio, como obtener todos los taxis
        Page<Taxi> taxis = taxiService.findAll(Pageable.unpaged());  // Asegúrate de que Pageable se inicialice correctamente
        Assert.notNull(taxis, "La lista de taxis no debe ser nula");
    }
}
