package com.rapisolver.service.services;

import com.rapisolver.service.dtos.CreateUserServiceDTO;
import com.rapisolver.service.dtos.UserServiceDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserServiceService {

    @Transactional
    UserServiceDTO create(CreateUserServiceDTO c) throws RuntimeException;

    List<UserServiceDTO> getAll() throws RuntimeException;

    UserServiceDTO getById(Long id) throws RuntimeException;
}
