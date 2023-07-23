package br.com.cadastro_command.service.validation.inclusao;

import br.com.cadastro_command.exception.IdadeNaoPermitidaUsuarioException;
import br.com.cadastro_command.factory.UsuarioResquestFactory;
import br.com.cadastro_command.service.validation.inclusao.rules.MaiorDeIdadeValitadionRule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MaiorDeIdadeValidationRuleTest {

    private MaiorDeIdadeValitadionRule maiorDeIdadeValitadionRule = new MaiorDeIdadeValitadionRule();
    @Test
    public void deveRetornarExceptionUsuarioMenorDeIdade(){
        var request = UsuarioResquestFactory.constroiUsuarioMenorDeIdade();
        Assertions.assertThrows(IdadeNaoPermitidaUsuarioException.class, () -> maiorDeIdadeValitadionRule.valida(request));
    }

    @Test
    public void naoDeveRetornarExceptionUsuarioMaiorDeIdade(){
        var request = UsuarioResquestFactory.constroiUsuarioMaiorDeIdade();
        Assertions.assertDoesNotThrow(() -> maiorDeIdadeValitadionRule.valida(request));
    }

}
