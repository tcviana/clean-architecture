package com.cleanarchitecture.school.domain.gamification;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * A interface {@link MedalRepository} representa o repositório de dados das {@link Medal}
 *
 * @author Tiago Coutinho Viana
 * @version 1.0
 */

public interface MedalRepository extends JpaRepository<Medal, Long>, JpaSpecificationExecutor {
}
