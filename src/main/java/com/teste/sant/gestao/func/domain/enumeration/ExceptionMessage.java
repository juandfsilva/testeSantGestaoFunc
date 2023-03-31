package com.teste.sant.gestao.func.domain.enumeration;

import lombok.Getter;

@Getter
public enum ExceptionMessage {
    BAD_REQUEST("Erro ao realizar requisição"),
    NOT_FOUND("Sem dados para a solicitação");


    private final String messageKey;

    ExceptionMessage(String messageKey) {
        this.messageKey = messageKey;
    }

    @Override
    public String toString(){
        return messageKey;
    }
}
