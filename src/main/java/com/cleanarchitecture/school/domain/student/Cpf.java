package com.cleanarchitecture.school.domain.student;

import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A classe {@link Cpf} representa o número do <b>Cadastro de Pessoa Física</b>, que identifica uma pessoa física
 * junto a Receita Federal brasileira
 *
 * @author Tiago Coutinho Viana
 * @version 1.0
 */

@Embeddable
@EqualsAndHashCode(of = "value")
@ToString(of = "value")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Cpf {

    private static final Pattern CPF_PATTERN = Pattern.compile("(\\d{3})(\\d{3})(\\d{3})(\\d{2})");

    @NonNull
    @CPF
    @Column(name = "CPF")
    private String value;

    public Cpf(final String value) {
        super();
        setValue(value);
    }

    public void setValue(final String value){
        this.value = value.replaceAll("\\.|\\-", "");
    }

    public String getValue() {
        if (value == null) {
            return null;
        }
        final Matcher matcher = CPF_PATTERN.matcher(value);
        if (matcher.matches()) {
            return matcher.replaceAll("$1.$2.$3-$4");
        }
        return value;
    }

    public String getUnformattedValue() {
        return value;
    }
}
