package com.rapisolver.rapisolveruserservice.service.impl;

import com.rapisolver.rapisolveruserservice.config.UserServiceConfig;
import com.rapisolver.rapisolveruserservice.dtos.FindUserResponseDTO;
import com.rapisolver.rapisolveruserservice.dtos.UserSignUpRequestDTO;
import com.rapisolver.rapisolveruserservice.dtos.UserSignUpResponseDTO;
import com.rapisolver.rapisolveruserservice.entity.Customer;
import com.rapisolver.rapisolveruserservice.entity.Role;
import com.rapisolver.rapisolveruserservice.entity.Supplier;
import com.rapisolver.rapisolveruserservice.entity.User;
import com.rapisolver.rapisolveruserservice.enums.ERole;
import com.rapisolver.rapisolveruserservice.exceptions.RoleNotFoundException;
import com.rapisolver.rapisolveruserservice.exceptions.UserNotFoundException;
import com.rapisolver.rapisolveruserservice.repository.RoleRepository;
import com.rapisolver.rapisolveruserservice.repository.UserRepository;
import com.rapisolver.rapisolveruserservice.service.UserService;
import com.rapisolver.rapisolveruserservice.util.EntityDtoConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRepository userRepository;

    /*
    @Autowired
    PasswordEncoder encoder;
     */

    @Autowired
    EntityDtoConverter entityDtoConverter;

    @Override
    public UserSignUpResponseDTO registerNewUser(UserSignUpRequestDTO request, ERole role) throws Exception {
        Role userRole = roleRepository.findRoleByName(role.name()).orElseThrow(() -> new RoleNotFoundException("ROLE_NOT_FOUND"));
        User savedUser;
        if(role.equals(ERole.CUSTOMER)){
            Customer customer = new Customer();
            customer.setFirstName(request.getFirstname());
            customer.setLastName(request.getLastname());
            customer.setEmail(request.getEmail());
            customer.setPassword(request.getPassword());
            customer.setPhone(request.getPhone());
            customer.setBirthdate(request.getBirthdate());
            customer.setRole(userRole);
            customer.setRandomColumn("");
            System.out.println("-<<<<<<<<<<<<<<Customer"+customer.getEmail());
            savedUser=this.userRepository.save(customer);
        } else if (role.equals(ERole.SUPPLIER)){
            Supplier supplier = new Supplier();
            supplier.setFirstName(request.getFirstname());
            supplier.setLastName(request.getLastname());
            supplier.setEmail(request.getEmail());
            supplier.setPassword(request.getPassword());
            supplier.setPhone(request.getPhone());
            supplier.setBirthdate(request.getBirthdate());
            supplier.setRole(userRole);
            supplier.setComercialName("");
            savedUser=this.userRepository.save(supplier);
        } else {
            throw new Exception("ROLE_NO_VALIDO");
        }
        UserSignUpResponseDTO userSignUpResponseDTO = this.entityDtoConverter.mapToSignUpResponse(savedUser);
        userSignUpResponseDTO.setRole(userRole.getName());
        return userSignUpResponseDTO;
    }

    @Override
    public FindUserResponseDTO findUser(Long userId) throws Exception {
        User user = this.userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("USER_NOT_FOUND"));
        return this.entityDtoConverter.mapToFindUserResponse(user);
    }
}
