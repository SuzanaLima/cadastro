package br.com.cadastro_command.service.validation;

public interface Rule <T>{
    default boolean aceita(T t) {
        return true;
    }

    void valida(T t);
}
