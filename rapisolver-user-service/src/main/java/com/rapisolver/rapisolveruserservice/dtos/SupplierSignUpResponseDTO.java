package com.rapisolver.rapisolveruserservice.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
@NoArgsConstructor
public class SupplierSignUpResponseDTO {
    private Long id;
    private String email;
    private String firstName;
    private String role;
}
