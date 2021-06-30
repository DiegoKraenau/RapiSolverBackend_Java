package com.rapisolver.service.dtos;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class UserRapiServiceDTO {
    private Long id;
    private String detail;
    private double price;
    private SupplierDTO supplier;
}
