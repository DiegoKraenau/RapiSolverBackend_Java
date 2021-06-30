package com.rapisolver.rapisolveruserservice.service;


import com.rapisolver.rapisolveruserservice.dtos.FindUserResponseDTO;
import com.rapisolver.rapisolveruserservice.dtos.SupplierServiceDTO;
import com.rapisolver.rapisolveruserservice.dtos.SupplierSignUpRequestDTO;
import com.rapisolver.rapisolveruserservice.dtos.SupplierSignUpResponseDTO;

public interface UserService {
    SupplierSignUpResponseDTO registerNewUserSupplier(SupplierSignUpRequestDTO request) throws Exception;

    FindUserResponseDTO findUser(Long userId) throws Exception;

    SupplierServiceDTO getSupplierServices(Long supplierId);
}
