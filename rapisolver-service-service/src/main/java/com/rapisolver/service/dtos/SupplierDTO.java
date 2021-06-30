package com.rapisolver.service.dtos;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SupplierDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String role;
}
