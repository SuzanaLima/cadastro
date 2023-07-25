package br.com.cadastro_command.service.validation.inclusao;

import br.com.cadastro_command.datacontract.validation.InclusaoUsuario;
import br.com.cadastro_command.exception.IdadeNaoPermitidaUsuarioException;
import br.com.cadastro_command.factory.UsuarioResquestFactory;
import br.com.cadastro_command.service.validation.inclusao.rules.MaiorDeIdadeValitadionRule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MaiorDeIdadeValidationRuleTest {

    private MaiorDeIdadeValitadionRule maiorDeIdadeValitadionRule = new MaiorDeIdadeValitadionRule();
    @Test
    public void deveRetornarExceptionUsuarioMenorDeIdade(){
        var usuarioHttpRequest = UsuarioResquestFactory.constroiUsuarioMenorDeIdade();
        var validadorInclusao = InclusaoUsuario.builder()
                .cpf(usuarioHttpRequest.getCpf())
                .emailUsuario(usuarioHttpRequest.getEmailUsuario())
                .nomeUsuario(usuarioHttpRequest.getNomeUsuario())
                .celular(usuarioHttpRequest.getCelular())
                .telefone(usuarioHttpRequest.getTelefone())
                .dataNascimento(usuarioHttpRequest.getDataNascimento())
                .build();
        System.out.println(validadorInclusao.getDataNascimento().toString());
        Assertions.assertThrows(IdadeNaoPermitidaUsuarioException.class, () -> maiorDeIdadeValitadionRule.valida(validadorInclusao));
    }

    @Test
    public void naoDeveRetornarExceptionUsuarioMaiorDeIdade(){
        var usuarioHttpRequest = UsuarioResquestFactory.constroiUsuarioMaiorDeIdade();
        var validadorInclusao = InclusaoUsuario.builder()
                .cpf(usuarioHttpRequest.getCpf())
                .emailUsuario(usuarioHttpRequest.getEmailUsuario())
                .nomeUsuario(usuarioHttpRequest.getNomeUsuario())
                .celular(usuarioHttpRequest.getCelular())
                .telefone(usuarioHttpRequest.getTelefone())
                .dataNascimento(usuarioHttpRequest.getDataNascimento())
                .build();
        System.out.println(validadorInclusao.getDataNascimento().toString());
        Assertions.assertDoesNotThrow(() -> maiorDeIdadeValitadionRule.valida(validadorInclusao));
    }

}
