package br.com.cadastro_command.interceptor;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class ExceptionResponse {
    public static final String DEFAULT_ERROR_MESSAGE = "Não foi possivel processar sua requisição";
    private HttpStatus httpStatus;
    private LocalDateTime timestamp;
    private String descricao;

    public ExceptionResponse(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
        this.descricao = DEFAULT_ERROR_MESSAGE;
        this.timestamp = LocalDateTime.now();
    }

    public ExceptionResponse(HttpStatus httpStatus, String descricao) {
        this.httpStatus = httpStatus;
        this.descricao = (descricao == null || descricao.isBlank()) ? DEFAULT_ERROR_MESSAGE : descricao;
        this.timestamp = LocalDateTime.now();
    }
}
