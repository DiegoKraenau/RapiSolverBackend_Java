package com.rapisolver.rapisolveruserservice.dtos;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class ServiceDTO {
    private Long id;
    private String detail;
    private double price;
}
