package br.com.cadastro_command.exception;

import org.springframework.http.HttpStatus;

public class IdadeNaoPermitidaUsuarioException extends GenericException{
    public IdadeNaoPermitidaUsuarioException(){
        super(
                HttpStatus.UNPROCESSABLE_ENTITY,
                "Idade não permitida para castro de usuario"
        );
    }
}
