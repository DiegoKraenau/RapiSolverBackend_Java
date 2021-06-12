package com.rapisolver.reservation.service.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleDTO {

    private Long id;
    private String name;
    private boolean canPublish;

}
