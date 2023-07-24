package br.com.cadastro_command.service.validation;

import java.util.List;

public interface Validator<R extends Rule<T>, T>{
    List<R> getRules();

    default void valida(T t){
        getRules().stream()
                .filter(rule -> rule.aceita(t))
                .forEach(rule -> rule.valida(t));
    }
}
