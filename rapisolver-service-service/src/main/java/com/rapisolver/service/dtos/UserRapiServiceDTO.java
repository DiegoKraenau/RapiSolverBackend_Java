package com.rapisolver.service.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class UserRapiServiceDTO {
    private Long id;
    private String detail;
    private double price;
    private SupplierDTO supplier;

    //TODO: Agregar atributos de relacion
}
