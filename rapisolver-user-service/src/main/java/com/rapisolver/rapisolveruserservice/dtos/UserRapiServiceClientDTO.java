package com.rapisolver.rapisolveruserservice.dtos;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class UserRapiServiceClientDTO {
    private Long id;
    private String detail;
    private double price;
    //private SupplierDTO supplier; No es necesario

    //TODO: Agregar atributos de relacion
}
