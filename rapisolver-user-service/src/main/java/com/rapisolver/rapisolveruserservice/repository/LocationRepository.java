package com.rapisolver.rapisolveruserservice.repository;

import com.rapisolver.rapisolveruserservice.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location,Long> {
}
