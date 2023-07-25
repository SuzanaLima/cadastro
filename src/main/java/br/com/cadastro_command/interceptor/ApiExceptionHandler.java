package br.com.cadastro_command.interceptor;

import br.com.cadastro_command.exception.GenericException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(GenericException.class)
    public ResponseEntity<ExceptionResponse> handleGenericException(GenericException e){
        ExceptionResponse exceptionResponse = new ExceptionResponse(e.getHttpStatus(), e.getDescricao());
        return ResponseEntity.status(exceptionResponse.getHttpStatus()).body(exceptionResponse);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponse> handleGenericException(Exception e){
        ExceptionResponse exceptionResponse = new ExceptionResponse(HttpStatus.INTERNAL_SERVER_ERROR);
        return ResponseEntity.status(exceptionResponse.getHttpStatus()).body(exceptionResponse);
    }

    @ExceptionHandler({HttpMessageNotReadableException.class, MethodArgumentTypeMismatchException.class})
    public ResponseEntity<ExceptionResponse> handleUnprocessableException(Exception e){
        ExceptionResponse exceptionResponse = new ExceptionResponse(HttpStatus.UNPROCESSABLE_ENTITY);
        return ResponseEntity.status(exceptionResponse.getHttpStatus()).body(exceptionResponse);
    }
}
