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
public class UserRapiService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "DETAIL")
    private String detail;

    @Column(name = "PRICE", nullable = false)
    private double price;

    @Column(nullable = false)
    private Long supplierId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "service_id", nullable = false)
    private RapiService service;
}
