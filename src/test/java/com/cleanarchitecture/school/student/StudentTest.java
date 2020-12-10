package com.cleanarchitecture.school.student;


import com.cleanarchitecture.school.domain.student.PhoneExceeded;
import com.cleanarchitecture.school.domain.student.Student;
import com.cleanarchitecture.school.domain.student.Phone;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class StudentTest {

    @Test
    public void shouldExceptionAddThreeTelephones() throws Exception {
        final Student student = new Student("test@test.com", "45645678910", "Benedito", null);
        final Phone telephone = new Phone(1232212355);
        final Phone telephone2 = new Phone(1243352345);
        final Phone telephone3 = new Phone(1245454566);
        student.addTelephone(telephone);
        student.addTelephone(telephone2);

        try {
            student.addTelephone(telephone3);
        } catch (PhoneExceeded e){
            assertThat(student.getPhone().size(), equalTo(2));
        }
    }
}
