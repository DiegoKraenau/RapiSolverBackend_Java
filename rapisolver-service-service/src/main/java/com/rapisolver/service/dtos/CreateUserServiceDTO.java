package com.rapisolver.service.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserServiceDTO {
    private String detail;
    private double price;
    private String serviceName;
    private String categoryName;
    private Long supplierId;

    //TODO: Agregar atributos de relacion
}
