package com.cleanarchitecture.school.domain.student;

public class PhoneExceeded extends IllegalArgumentException {

    public PhoneExceeded() {
        super("Quantidade de telefone excedido! Máximo 2 por aluno");
    }
}
