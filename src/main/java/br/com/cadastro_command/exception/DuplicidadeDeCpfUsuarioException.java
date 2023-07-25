package br.com.cadastro_command.exception;

import org.springframework.http.HttpStatus;

public class DuplicidadeDeCpfUsuarioException extends GenericException {
    public DuplicidadeDeCpfUsuarioException() {
        super(
                HttpStatus.UNPROCESSABLE_ENTITY, "Cpf já cadastrado!");
    }
}
