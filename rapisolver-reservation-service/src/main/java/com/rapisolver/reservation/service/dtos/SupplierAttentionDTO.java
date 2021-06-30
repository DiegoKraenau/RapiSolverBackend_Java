package com.rapisolver.reservation.service.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SupplierAttentionDTO {

    private Long id;
    private String detail;
    private double price;

    private AttentionDTO attention;
}
