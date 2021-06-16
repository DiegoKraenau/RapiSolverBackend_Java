package com.rapisolver.rapisolveruserservice.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FindUserResponseDTO {
    private Long id;
    private String email;
    private String firstName;
    private String role;
}
