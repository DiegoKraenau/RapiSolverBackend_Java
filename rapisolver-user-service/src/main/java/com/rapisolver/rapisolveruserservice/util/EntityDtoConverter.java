package com.rapisolver.rapisolveruserservice.util;

import com.rapisolver.rapisolveruserservice.dtos.FindUserResponseDTO;
import com.rapisolver.rapisolveruserservice.dtos.UserSignUpRequestDTO;
import com.rapisolver.rapisolveruserservice.dtos.UserSignUpResponseDTO;
import com.rapisolver.rapisolveruserservice.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EntityDtoConverter {
    @Autowired
    ModelMapper modelMapper;

    public User mapSignUpRequestToUserEntity(UserSignUpRequestDTO userSignUpRequestDTO){
        return this.modelMapper.map(userSignUpRequestDTO,User.class);
    }

    public UserSignUpResponseDTO mapToSignUpResponse(User savedUser) {
        UserSignUpResponseDTO ob = this.modelMapper.map(savedUser,UserSignUpResponseDTO.class);
        ob.setRole(savedUser.getRole().getName());
        return ob;
    }

    public FindUserResponseDTO mapToFindUserResponse(User user) {
        FindUserResponseDTO ob = this.modelMapper.map(user,FindUserResponseDTO.class);
        ob.setRole(user.getRole().getName());
        return ob;
    }
}
