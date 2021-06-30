package com.rapisolver.rapisolveruserservice.service.impl;

import com.rapisolver.rapisolveruserservice.client.ServiceClient;
import com.rapisolver.rapisolveruserservice.dtos.*;
import com.rapisolver.rapisolveruserservice.entity.*;
import com.rapisolver.rapisolveruserservice.enums.ERole;
import com.rapisolver.rapisolveruserservice.exceptions.RoleNotFoundException;
import com.rapisolver.rapisolveruserservice.exceptions.ServiceClientException;
import com.rapisolver.rapisolveruserservice.exceptions.UserNotFoundException;
import com.rapisolver.rapisolveruserservice.repository.LocationRepository;
import com.rapisolver.rapisolveruserservice.repository.RoleRepository;
import com.rapisolver.rapisolveruserservice.repository.UserRepository;
import com.rapisolver.rapisolveruserservice.service.UserService;
import com.rapisolver.rapisolveruserservice.util.EntityDtoConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    LocationRepository locationRepository;

    @Autowired
    ServiceClient serviceClient;

    /*
    @Autowired
    PasswordEncoder encoder;
     */

    @Autowired
    EntityDtoConverter entityDtoConverter;

    @Override
    public SupplierSignUpResponseDTO registerNewUserSupplier(SupplierSignUpRequestDTO request) throws Exception {

        Role userRole = roleRepository.findRoleByName(ERole.SUPPLIER.name()).orElseThrow(() -> new RoleNotFoundException("ROLE_NOT_FOUND"));

        Location location = new Location();
        location.setAddress(request.getAddress());
        location.setCity(request.getCity());
        location.setCountry(request.getCountry());
        location.setState(request.getCountry());
        Location savedLocation = this.locationRepository.save(location);

        Supplier supplier = new Supplier();
        supplier.setFirstName(request.getFirstname());
        supplier.setLastName(request.getLastname());
        supplier.setEmail(request.getEmail());
        supplier.setPassword(request.getPassword());
        supplier.setPhone(request.getPhone());
        supplier.setBirthdate(request.getBirthdate());
        supplier.setRole(userRole);
        supplier.setComercialName("");
        supplier.setLocation(savedLocation);
        Supplier savedUser = this.userRepository.save(supplier);

        SupplierSignUpResponseDTO userSignUpResponseDTO = this.entityDtoConverter.mapToSignUpResponse(savedUser);
        userSignUpResponseDTO.setRole(userRole.getName());
        return userSignUpResponseDTO;

    }

    @Override
    public FindUserResponseDTO findUser(Long userId) throws Exception {
        User user = this.userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("USER_NOT_FOUND"));
        Location location = user.getLocation();
        FindUserResponseDTO responseDTO = this.entityDtoConverter.mapToFindUserResponse(user);
        responseDTO.setAddress(location.getAddress());
        responseDTO.setCity(location.getCity());
        responseDTO.setState(location.getState());
        responseDTO.setCountry(location.getCountry());
        return responseDTO;
    }

    @Override
    public SupplierServiceDTO getSupplierServices(Long supplierId) throws RuntimeException {
        User user = this.userRepository.findById(supplierId).orElseThrow(() -> new UserNotFoundException("USER_NOT_FOUND"));
        ListUserRapiServiceClientDTO listUserRapiServiceClientDTO = this.serviceClient.getSupplierServices(supplierId).orElseThrow(()->new ServiceClientException("ERROR COMUNICACION CON SERVICE CLIENT"));

        List<ServiceDTO> serviceDTOList = listUserRapiServiceClientDTO.getUserRapiServiceDTOList().stream()
                .map(service -> new ServiceDTO(service.getId(), service.getDetail(),service.getPrice()))
                .collect(Collectors.toList());

        return SupplierServiceDTO.builder().
                supplier(SupplierDTO.builder().
                        email(user.getEmail()).
                        firstName(user.getFirstName()).
                        lastName(user.getLastName()).
                        address(user.getLocation().getAddress()).
                        city(user.getLocation().getCity()).
                        state(user.getLocation().getState()).
                        country(user.getLocation().getCountry()).
                        build()).
                serviceList(serviceDTOList).
                build();
    }
}
