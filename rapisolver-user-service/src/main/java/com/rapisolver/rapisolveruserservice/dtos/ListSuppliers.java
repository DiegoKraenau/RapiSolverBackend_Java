package com.rapisolver.rapisolveruserservice.dtos;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class ListSuppliers {
    List<SupplierDTO> supplierDTOList;
}
