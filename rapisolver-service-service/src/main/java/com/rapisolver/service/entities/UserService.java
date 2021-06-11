package com.rapisolver.service.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "USERS_SERVICES")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "DETAIL")
    private String detail;

    @Column(name = "PRICE", nullable = false)
    private double price;

    @Column(nullable = false)
    private Long userId;

    //TODO: Agregar relacion con Service
}
