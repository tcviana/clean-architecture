/**
 *
 * Esta classe representa o telefone de uma entidade
 *
 * Value Object
 *
 * @author Tiago Viana
 * @version 1.0
 */

package com.cleanarchitecture.school.domain.student;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "TELEPHONE")
public class Phone {

    private static final Pattern PHONE_PATTERN = Pattern.compile("\\d{2}\\d{5}\\d{4}");

    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "TELEPHONE_SEQUENCE")
    @Column(name = "ID_TELEPHONE")
    @Id
    private Long id;

    @Column(name = "NUMBER")
    private String number;

    @ManyToOne
    @Setter
    @JoinColumn(name = "ID_STUDENT")
    private Student student;

    public Phone(final String number) {
        super();
        this.setNumber(number);
    }

    public void setNumber(final String number) {
        this.number = number.replaceAll("\\.|\\-|\\(|\\)|\\,", "");
    }

    public String getNumber() {
        if (this.number == null) {
            return null;
        }
        final Matcher matcher = PHONE_PATTERN.matcher(this.number);
        if (matcher.matches()) {
            return matcher.replaceAll("$1-$2.$3");
        }
        return number;
    }
}
