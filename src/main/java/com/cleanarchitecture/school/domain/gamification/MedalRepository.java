package com.cleanarchitecture.school.domain.gamification;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MedalRepository extends JpaRepository<Medal, Long>, JpaSpecificationExecutor {
}
