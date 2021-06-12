package com.rapisolver.rapisolveruserservice.service.impl;

import com.rapisolver.rapisolveruserservice.config.UserServiceConfig;
import com.rapisolver.rapisolveruserservice.dtos.UserSignUpRequestDTO;
import com.rapisolver.rapisolveruserservice.dtos.UserSignUpResponseDTO;
import com.rapisolver.rapisolveruserservice.entity.Role;
import com.rapisolver.rapisolveruserservice.entity.User;
import com.rapisolver.rapisolveruserservice.enums.ERole;
import com.rapisolver.rapisolveruserservice.exceptions.RoleNotFoundException;
import com.rapisolver.rapisolveruserservice.repository.RoleRepository;
import com.rapisolver.rapisolveruserservice.repository.UserRepository;
import com.rapisolver.rapisolveruserservice.service.UserService;
import com.rapisolver.rapisolveruserservice.util.EntityDtoConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    EntityDtoConverter entityDtoConverter;

    @Override
    public UserSignUpResponseDTO registerNewUser(UserSignUpRequestDTO request, ERole role) {
        Role userRole = roleRepository.findRoleByName(role.name()).orElseThrow(() -> new RoleNotFoundException("RS0215: Role No Encontrado"));
        User user = entityDtoConverter.mapSignUpRequestToUserEntity(request);
        user.setRole(userRole);
        User savedUser=this.userRepository.save(user);
        return this.entityDtoConverter.mapToSignUpResponse(savedUser);
    }
}
