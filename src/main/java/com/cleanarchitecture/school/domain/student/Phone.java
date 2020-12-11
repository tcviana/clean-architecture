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

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.Pattern;

@AllArgsConstructor
@Getter
public class Phone {

    @Pattern(regexp = "^[0-9]{14}$")
    private Integer number;

}
