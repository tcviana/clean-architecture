package com.cleanarchitecture.school.domain.student;

/**
 * A classe {@link PhoneExceeded} envia uma mensagem de exceção quando excede a quantidade máxima de telefones por {@link Student}
 *
 * @author Tiago Coutinho Viana
 * @version 1.0
 */

public class PhoneExceeded extends IllegalArgumentException {

    public PhoneExceeded() {
        super("Quantidade de telefone excedido! Máximo 2 por aluno");
    }
}
