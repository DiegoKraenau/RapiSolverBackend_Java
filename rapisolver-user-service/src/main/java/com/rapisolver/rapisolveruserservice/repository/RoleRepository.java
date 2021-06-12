package com.rapisolver.rapisolveruserservice.repository;

import com.rapisolver.rapisolveruserservice.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {

    Optional<Role> findRoleByName(String name);

}
