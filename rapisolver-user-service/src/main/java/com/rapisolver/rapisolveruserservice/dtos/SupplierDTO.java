package com.rapisolver.rapisolveruserservice.dtos;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class SupplierDTO {
    private String email;
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String country;
}
