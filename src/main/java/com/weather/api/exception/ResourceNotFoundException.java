package com.weather.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exceção lançada quando um recurso não é encontrado.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * Construtor com mensagem de erro.
     *
     * @param message Mensagem de erro
     */
    public ResourceNotFoundException(String message) {
        super(message);
    }

    /**
     * Construtor com mensagem de erro e causa.
     *
     * @param message Mensagem de erro
     * @param cause   Causa da exceção
     */
    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}

