package com.rapisolver.service.repositories;

import com.rapisolver.service.entities.RapiService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends JpaRepository<RapiService,Long> {
}
