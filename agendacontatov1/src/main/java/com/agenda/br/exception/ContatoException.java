package com.agenda.br.exception;

import org.springframework.http.HttpStatus;

public class ContatoException extends Exception{

	private static final long serialVersionUID = 1L;

	private final String message;
    private final HttpStatus status;

    public ContatoException(String message) {
        this.message = message;
        this.status = HttpStatus.BAD_REQUEST;
    }

    public ContatoException(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public HttpStatus getStatus() {
        return status;
    }

}
