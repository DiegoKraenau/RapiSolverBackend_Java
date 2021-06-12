package com.rapisolver.reservation.service.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Data
@Table(name="LOCATION")
@Entity
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "COUNTRY",length = 20, nullable = false)
    private String country;

    @Column(name = "STATE", length = 20, nullable = false)
    private String state;

    @Column(name = "CITY", length = 20, nullable = false)
    private String city;

    @Column(length = 70, nullable = false)
    private String address;
    /* TODO = PONER LA RELACION CON RESERVATIONS*/

    public Location(String country, String state, String city, String address) {
        this.country = country;
        this.state = state;
        this.city = city;
        this.address = address;
    }
}
