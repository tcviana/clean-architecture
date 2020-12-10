package com.cleanarchitecture.school.domain.student;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.util.CollectionUtils;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@Getter
public class Student {

    @Pattern(regexp = "^[a-zA-Z0-9._]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")
    private String email;

    @Pattern(regexp = "^[0-9]{11}$")
    private String cpf;

    private String name;

    @Size(max=2)
    private Set<Phone> phone;

    private boolean validAddTelephone() {
        if (CollectionUtils.isEmpty(this.phone)) {
            this.phone = new HashSet<>();
        }
        if (this.phone.size() == 2) {
            throw new PhoneExceeded();
        }
        return true;
    }

    public void addTelephone(final Phone phone) {
        if (validAddTelephone()) {
            this.phone.add(phone);
        }
    }

}
