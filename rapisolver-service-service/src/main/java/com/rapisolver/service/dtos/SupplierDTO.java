package com.rapisolver.service.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class SupplierDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String role;
}
