package com.cleanarchitecture.school.application;

import com.cleanarchitecture.school.domain.recommendation.Recommendation;
import com.cleanarchitecture.school.domain.recommendation.RecommendationRepository;
import com.cleanarchitecture.school.domain.student.Student;
import com.cleanarchitecture.school.infra.ApplicationServices;
import lombok.RequiredArgsConstructor;


@ApplicationServices
@RequiredArgsConstructor
public class RecommendationApplicationService {

    private final RecommendationRepository repository;

    public Recommendation addIndicationByIndicative(Student indicated, Student indicative) {
        Recommendation recommendation = new Recommendation(indicated, indicative);
        return repository.save(recommendation);
    }
}
