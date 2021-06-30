package com.rapisolver.service.dtos;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class ListUserRapiServiceDTO {
    List<UserRapiServiceDTO> userRapiServiceDTOList;
}
