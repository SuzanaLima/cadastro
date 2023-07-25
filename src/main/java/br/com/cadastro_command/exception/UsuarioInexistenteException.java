package br.com.cadastro_command.exception;

import org.springframework.http.HttpStatus;

public class UsuarioInexistenteException extends GenericException{
    public UsuarioInexistenteException() {
        super(HttpStatus.NOT_FOUND, "Usuario não encontrado");
    }
}
