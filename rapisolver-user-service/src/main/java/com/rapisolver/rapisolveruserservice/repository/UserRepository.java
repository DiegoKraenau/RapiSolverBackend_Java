package com.rapisolver.rapisolveruserservice.repository;

import com.rapisolver.rapisolveruserservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
