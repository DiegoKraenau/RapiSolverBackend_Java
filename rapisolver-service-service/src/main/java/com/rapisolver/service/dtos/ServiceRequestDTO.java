package com.rapisolver.service.dtos;

import com.rapisolver.service.entities.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ServiceRequestDTO {

    private String name;

    private String categoryName;
}
