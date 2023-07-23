package br.com.cadastro_command.factory;


import br.com.cadastro_command.datacontract.request.UsuarioHttpRequest;
import org.junit.jupiter.api.TestFactory;

import java.time.LocalDate;

public class UsuarioResquestFactory {

    @TestFactory
    public static UsuarioHttpRequest constroiUsuarioMenorDeIdade(){
        return UsuarioHttpRequest.builder()
                .cpf("000.000.000-00")
                .nomeUsuario("userTesteMenorDeIdade")
                .celular("123456")
                .telefone("315456")
                .emailUsuario("emailTeste")
                .dataNascimento(LocalDate.of(2007,07,2))
                .build();
    }

    @TestFactory
    public static UsuarioHttpRequest constroiUsuarioMaiorDeIdade(){
        return UsuarioHttpRequest.builder()
                .cpf("000.000.000-00")
                .nomeUsuario("userTesteMenorDeIdade")
                .celular("123456")
                .telefone("315456")
                .emailUsuario("emailTeste")
                .dataNascimento(LocalDate.of(1995,07,2))
                .build();
    }

}
