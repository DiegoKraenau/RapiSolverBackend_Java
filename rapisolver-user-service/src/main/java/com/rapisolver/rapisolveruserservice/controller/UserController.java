package com.rapisolver.rapisolveruserservice.controller;

import com.rapisolver.rapisolveruserservice.dtos.*;
import com.rapisolver.rapisolveruserservice.enums.ERole;
import com.rapisolver.rapisolveruserservice.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "http://localhost:4200")
@Api
@RestController
public class UserController {
    @Autowired
    UserService userService;
/*
    @ApiOperation(value = "Register new customer user", notes = "None")
    @PostMapping(value = "/user/customer")
    public ResponseEntity<UserSignUpResponseDTO> signUpCustomer(@Valid @RequestBody UserSignUpRequestDTO customer) throws Exception {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.userService.registerNewUser(customer, ERole.CUSTOMER));
    }
    */



    @ApiOperation(value = "Register new supplier user", notes = "None")
    @PostMapping(value = "/user/supplier")
    public ResponseEntity<SupplierSignUpResponseDTO> signUpSupplier(@Valid @RequestBody SupplierSignUpRequestDTO supplier) throws Exception {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.userService.registerNewUserSupplier(supplier));
    }

    @ApiOperation(value = "Get User", notes = "None")
    @GetMapping(value = "/user/{userId}")
    public ResponseEntity<FindUserResponseDTO> signUpSupplier(@PathVariable Long userId) throws Exception {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.userService.findUser(userId));
    }

    @ApiOperation(value = "Get Supplier's Services", notes = "None")
    @GetMapping(value = "/user/suppliers/{supplierId}/services")
    public ResponseEntity<SupplierServiceDTO> getSupplierServices(@PathVariable Long supplierId) throws Exception {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.userService.getSupplierServices(supplierId));
    }

    @ApiOperation(value = "Get All Suppliers", notes = "None")
    @GetMapping(value = "/user/suppliers")
    public ResponseEntity<ListSuppliers> getAllSuppliers() throws Exception {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.userService.getAllSuppliers());
    }


}
