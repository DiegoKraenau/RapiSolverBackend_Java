package com.rapisolver.rapisolveruserservice.service;


import com.rapisolver.rapisolveruserservice.dtos.*;

public interface UserService {
    SupplierSignUpResponseDTO registerNewUserSupplier(SupplierSignUpRequestDTO request) throws Exception;

    FindUserResponseDTO findUser(Long userId) throws Exception;

    SupplierServiceDTO getSupplierServices(Long supplierId);

    ListSuppliers getAllSuppliers();
}
