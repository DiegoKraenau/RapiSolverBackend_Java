package com.rapisolver.rapisolveruserservice.dtos;

import lombok.*;

import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class SupplierServiceDTO {
    SupplierDTO supplier;
    List<ServiceDTO> serviceList;
}
