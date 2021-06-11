package com.rapisolver.service.controllers;

import com.rapisolver.service.dtos.CreateUserServiceDTO;
import com.rapisolver.service.dtos.UserServiceDTO;
import com.rapisolver.service.services.UserServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "users-services")
public class UserServiceController {

    @Autowired
    private UserServiceService service;

    @PostMapping
    public ResponseEntity<UserServiceDTO> create(@RequestBody CreateUserServiceDTO c) {
        return new ResponseEntity<>(service.create(c), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UserServiceDTO>> getAll()  {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserServiceDTO> getById(@PathVariable Long id)  {
        return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
    }

}
