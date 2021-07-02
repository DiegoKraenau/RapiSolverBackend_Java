package com.rapisolver.service.controllers;

import com.rapisolver.service.dtos.CreateUserRapiServiceDTO;
import com.rapisolver.service.dtos.ListUserRapiServiceDTO;
import com.rapisolver.service.dtos.UserRapiServiceDTO;
import com.rapisolver.service.services.UserRapiServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "users-services")
public class UserRapiServiceController {

    @Autowired
    private UserRapiServiceService service;

    @CrossOrigin(origins = "http://localhost:4200/%22")
    @PostMapping
    public ResponseEntity<UserRapiServiceDTO> create(@RequestBody CreateUserRapiServiceDTO c) throws RuntimeException {
        return new ResponseEntity<>(service.create(c), HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "http://localhost:4200/%22")
    @GetMapping
    public ResponseEntity<List<UserRapiServiceDTO>> getAll() throws RuntimeException {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:4200/%22")
    @GetMapping(value = "/{id}")
    public ResponseEntity<UserRapiServiceDTO> getById(@PathVariable Long id) throws RuntimeException {
        return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:4200/%22")
    @GetMapping(value = "/supplier/{id}")
    public ResponseEntity<ListUserRapiServiceDTO> getServicesBySupplierId(@PathVariable Long id) throws RuntimeException {
        return new ResponseEntity<>(service.getServicesBySupplierId(id), HttpStatus.OK);
    }

}
