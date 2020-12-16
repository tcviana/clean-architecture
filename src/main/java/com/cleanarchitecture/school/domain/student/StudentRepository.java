package com.cleanarchitecture.school.domain.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * A interface {@link StudentRepository} representa o repositório de dados das {@link Student}
 *
 * @author Tiago Coutinho Viana
 * @version 1.0
 */

public interface StudentRepository extends JpaRepository<Student, Long>, JpaSpecificationExecutor {
}
