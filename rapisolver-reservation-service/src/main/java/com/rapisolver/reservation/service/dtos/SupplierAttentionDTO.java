package com.rapisolver.reservation.service.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SupplierAttentionDTO {

    private Long supplierId;

    private Long id;
    private double price;

    private AttentionDTO attention;
}