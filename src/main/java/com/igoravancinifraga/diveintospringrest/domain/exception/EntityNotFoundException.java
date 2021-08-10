package com.igoravancinifraga.diveintospringrest.domain.exception;

public class EntityNotFoundException extends BusinessException{

    public EntityNotFoundException(String message) {
        super(message);
    }
}
