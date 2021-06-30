package com.rapisolver.rapisolveruserservice.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "locations")
@NoArgsConstructor
@Getter
@Setter
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, nullable = false)
    private String country;

    @Column(length = 20, nullable = false)
    private String state;

    @Column(length = 20, nullable = false)
    private String city;

    @Column(length = 70, nullable = false)
    private String address;

}
