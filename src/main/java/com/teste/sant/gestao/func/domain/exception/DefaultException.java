package com.teste.sant.gestao.func.domain.exception;

import com.teste.sant.gestao.func.domain.enumeration.ExceptionMessage;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

@Getter
public class DefaultException extends RuntimeException {


    private final ExceptionMessage reason;
    private final HttpStatus status;


    public DefaultException(HttpStatus status, ExceptionMessage reason) {
        super(reason.getMessageKey());
        this.status = status;
        this.reason = reason;
    }
}
