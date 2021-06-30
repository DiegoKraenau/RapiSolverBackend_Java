package com.rapisolver.rapisolveruserservice.util;

import com.rapisolver.rapisolveruserservice.dtos.FindUserResponseDTO;
import com.rapisolver.rapisolveruserservice.dtos.SupplierSignUpRequestDTO;
import com.rapisolver.rapisolveruserservice.dtos.SupplierSignUpResponseDTO;
import com.rapisolver.rapisolveruserservice.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EntityDtoConverter {
    @Autowired
    ModelMapper modelMapper;

    public User mapSignUpRequestToUserEntity(SupplierSignUpRequestDTO userSignUpRequestDTO){
        return this.modelMapper.map(userSignUpRequestDTO,User.class);
    }

    public SupplierSignUpResponseDTO mapToSignUpResponse(User savedUser) {
        SupplierSignUpResponseDTO ob = this.modelMapper.map(savedUser, SupplierSignUpResponseDTO.class);
        ob.setRole(savedUser.getRole().getName());
        return ob;
    }

    public FindUserResponseDTO mapToFindUserResponse(User user) {
        FindUserResponseDTO ob = this.modelMapper.map(user,FindUserResponseDTO.class);
        ob.setRole(user.getRole().getName());
        return ob;
    }
}
