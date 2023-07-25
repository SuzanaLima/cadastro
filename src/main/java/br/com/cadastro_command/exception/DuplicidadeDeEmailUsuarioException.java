package br.com.cadastro_command.exception;

import org.springframework.http.HttpStatus;

public class DuplicidadeDeEmailUsuarioException extends GenericException{
    public DuplicidadeDeEmailUsuarioException() {
        super(HttpStatus.UNPROCESSABLE_ENTITY, "Email já cadastrado!");
    }
}
