package com.rapisolver.service.dtos;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRapiServiceDTO {
    private Long id;
    private String detail;
    private double price;
    private SupplierDTO supplier;

    //TODO: Agregar atributos de relacion
}
