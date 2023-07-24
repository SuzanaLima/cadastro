package br.com.cadastro_command.exception;

import br.com.cadastro_command.exception.GenericException;
import org.springframework.http.HttpStatus;

public class NaoInformadoDadosAtualizacaoUsuarioException extends GenericException {
    public NaoInformadoDadosAtualizacaoUsuarioException() {
        super(HttpStatus.UNPROCESSABLE_ENTITY, "Não foram informados dados para atualizacao");
    }
}
