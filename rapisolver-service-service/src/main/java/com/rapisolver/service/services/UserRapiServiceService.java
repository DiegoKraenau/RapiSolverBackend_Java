package com.rapisolver.service.services;

import com.rapisolver.service.dtos.CreateUserRapiServiceDTO;
import com.rapisolver.service.dtos.ListUserRapiServiceDTO;
import com.rapisolver.service.dtos.UserRapiServiceDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserRapiServiceService {

    UserRapiServiceDTO create(CreateUserRapiServiceDTO c) throws RuntimeException;

    List<UserRapiServiceDTO> getAll() throws RuntimeException;

    UserRapiServiceDTO getById(Long id) throws RuntimeException;

    ListUserRapiServiceDTO getServicesBySupplierId(Long id) throws  RuntimeException;
}
