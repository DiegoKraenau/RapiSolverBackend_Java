package com.rapisolver.service.repositories;

import com.rapisolver.service.entities.UserService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserServiceRepository extends JpaRepository<UserService, Long> {

    //TODO: Crear el metodo para buscar por userId

}
