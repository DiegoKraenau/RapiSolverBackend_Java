package com.rapisolver.rapisolveruserservice.repository;

import com.rapisolver.rapisolveruserservice.entity.Recommendation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecommendationRepository extends JpaRepository<Recommendation, Long> {

}
