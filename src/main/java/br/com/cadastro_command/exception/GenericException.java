package br.com.cadastro_command.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class GenericException  extends RuntimeException{
    final HttpStatus httpStatus;
    final String descricao;

    public GenericException(HttpStatus httpStatus, String descricao){
        super(descricao);
        this.descricao = descricao;
        this.httpStatus = httpStatus;
    }

    public GenericException(String descricao) {
        super(descricao);
        this.descricao = descricao;
        this.httpStatus = null;
    }
}
