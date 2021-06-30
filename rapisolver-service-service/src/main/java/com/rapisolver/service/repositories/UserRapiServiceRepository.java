package com.rapisolver.service.repositories;

import com.rapisolver.service.entities.UserRapiService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRapiServiceRepository extends JpaRepository<UserRapiService, Long> {

    //TODO: Crear el metodo para buscar por userId
    Optional<List<UserRapiService>> findBySupplierId(Long id);
}
