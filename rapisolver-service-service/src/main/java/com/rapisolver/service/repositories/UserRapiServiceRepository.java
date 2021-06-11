package com.rapisolver.service.repositories;

import com.rapisolver.service.entities.UserRapiService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRapiServiceRepository extends JpaRepository<UserRapiService, Long> {

    //TODO: Crear el metodo para buscar por userId

}
