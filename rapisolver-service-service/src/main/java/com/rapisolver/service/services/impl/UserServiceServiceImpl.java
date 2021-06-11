package com.rapisolver.service.services.impl;

import com.rapisolver.service.dtos.CreateUserServiceDTO;
import com.rapisolver.service.dtos.UserServiceDTO;
import com.rapisolver.service.entities.UserService;
import com.rapisolver.service.repositories.UserServiceRepository;
import com.rapisolver.service.services.UserServiceService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceServiceImpl implements UserServiceService {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private UserServiceRepository repository;

    @Override
    public UserServiceDTO create(CreateUserServiceDTO c) throws RuntimeException {

        try {
            UserService userService = UserService.builder()
                    .detail(c.getDetail())
                    .price(c.getPrice())
                    .build();
            userService = repository.save(userService);
            return mapper.map(userService, UserServiceDTO.class);
        } catch (Exception e) {
            throw new RuntimeException("CREATE_USER_SERVICE_ERROR");
        }
    }

    @Override
    public List<UserServiceDTO> getAll() throws RuntimeException {
        List<UserService> userServices = repository.findAll();
        return userServices.stream().map(us -> mapper.map(us, UserServiceDTO.class)).collect(Collectors.toList());
    }

    @Override
    public UserServiceDTO getById(Long id) throws RuntimeException {
        UserService userServiceDB = repository.findById(id).orElseThrow(() -> new RuntimeException("USER_SERVICE_NOT_FOUND"));
        return mapper.map(userServiceDB, UserServiceDTO.class);
    }
}
