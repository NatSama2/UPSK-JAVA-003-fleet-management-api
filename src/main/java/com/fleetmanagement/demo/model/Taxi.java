package com.fleetmanagement.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
//import javax.persistence.GeneratedValue;
//mport javax.persistence.GenerationType;

@Entity
@Table(name = "taxis")
public class Taxi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "plate")
    private String plate;

    public Long getId() {
        return id;
    } //son métodos de acceso (getters) para los atributos id y plate, respectivamente.

    public void setId(Long id) { // son métodos de modificación (setters) para los atributos id y plate, respectivamente.
        this.id = id;
    }

    public String getPlate() {
        return plate;
    } //devuelve el valor actual del atributo plate de la instancia de Taxi en la que se llama al método.

    public void setPlate(String plate) {
        this.plate = plate;
    }//Este método se utiliza para establecer el valor del atributo plate de la clase Taxi con el valor proporcionado.
}