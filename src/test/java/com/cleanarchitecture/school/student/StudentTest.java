package com.cleanarchitecture.school.student;


import com.cleanarchitecture.school.domain.student.PhoneExceeded;
import com.cleanarchitecture.school.domain.student.Student;
import com.cleanarchitecture.school.domain.student.Phone;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StudentTest {

    private Student student;

    @BeforeEach
    private void createStudent() {
        this.student = new Student("test@test.com", "45645678910", "Benedito");
    }

    @Test
    public void shouldEnrollStudent() {
        this.student.addTelephone("1232123421");

        assertEquals("Benedito", student.getName());
        assertEquals("45645678910", student.getCpfUnformattedValue());
        assertEquals("456.456.789-10", student.getCpfValue());
        assertEquals("test@test.com", student.getEmail());
    }

    @Test
    public void shouldAddTwoPhones() {
        this.student.addTelephone("1232212356");
        this.student.addTelephone("1232212355");
        assertEquals(2, this.student.getPhone().size());
    }

    @Test
    public void shouldExceptionAddThreePhones() throws Exception {
        assertThrows(PhoneExceeded.class, () -> {
            student.addTelephone("1232212355");
            student.addTelephone("1243352345");
            student.addTelephone("1245454566");
        });

    }
}
