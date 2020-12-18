package com.cleanarchitecture.school.recommendation;

import com.cleanarchitecture.school.application.RecommendationApplicationService;
import com.cleanarchitecture.school.application.StudentApplicationService;
import com.cleanarchitecture.school.domain.recommendation.Recommendation;
import com.cleanarchitecture.school.domain.student.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class RecommendationServiceTest {

    @Autowired
    RecommendationApplicationService recommendationApplicationService;

    @Autowired
    StudentApplicationService studentApplicationService;

    @Test
    public void shouldAddRecommendation() {
        final Student indicated = studentApplicationService.findById(1L).get();
        final Student indicative = studentApplicationService.findById(2L).get();

        Recommendation recommendation = recommendationApplicationService.addIndicationByIndicative(indicated, indicative);

        Assertions.assertEquals(indicated.getCpfValue(), recommendation.getIndicated().getCpfValue());
        Assertions.assertEquals(indicative.getCpfValue(), recommendation.getIndicative().getCpfValue());

    }

}