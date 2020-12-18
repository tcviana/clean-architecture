package com.cleanarchitecture.school.domain.recommendation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RecommendationRepository extends JpaRepository<Recommendation, Long>, JpaSpecificationExecutor {
}
