package com.rapisolver.service.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserServiceDTO {
    private Long id;
    private String detail;
    private double price;

    //TODO: Agregar atributos de relacion
}
