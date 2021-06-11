package com.rapisolver.service.services.impl;

import com.rapisolver.service.dtos.CreateUserServiceDTO;
import com.rapisolver.service.dtos.UserServiceDTO;
import com.rapisolver.service.repositories.UserServiceRepository;
import com.rapisolver.service.services.UserServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceServiceImpl implements UserServiceService {

    @Autowired
    private UserServiceRepository repository;

    @Override
    public UserServiceDTO create(CreateUserServiceDTO c) throws RuntimeException {
        return null;
    }

    @Override
    public List<UserServiceDTO> getAll() throws RuntimeException {
        return null;
    }

    @Override
    public UserServiceDTO getById(Long id) throws RuntimeException {
        return null;
    }
}
