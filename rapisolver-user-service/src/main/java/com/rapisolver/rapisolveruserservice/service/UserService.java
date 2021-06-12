package com.rapisolver.rapisolveruserservice.service;


import com.rapisolver.rapisolveruserservice.dtos.UserSignUpRequestDTO;
import com.rapisolver.rapisolveruserservice.dtos.UserSignUpResponseDTO;
import com.rapisolver.rapisolveruserservice.enums.ERole;

public interface UserService {
    UserSignUpResponseDTO registerNewUser(UserSignUpRequestDTO request, ERole role);

}
