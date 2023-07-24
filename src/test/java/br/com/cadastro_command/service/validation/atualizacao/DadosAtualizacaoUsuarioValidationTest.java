package br.com.cadastro_command.service.validation.atualizacao;


import br.com.cadastro_command.datacontract.validation.AtualizacaoUsuario;
import br.com.cadastro_command.exception.NaoInformadoDadosAtualizacaoUsuarioException;
import br.com.cadastro_command.service.validation.atualizacao.rules.DadosAtualizacaoUsuarioValidationRule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DadosAtualizacaoUsuarioValidationTest {

    private DadosAtualizacaoUsuarioValidationRule dadosAtualizacaoUsuarioValidationRule = new DadosAtualizacaoUsuarioValidationRule();

    @Test
    public void deveRetornarExceptionComCamposNulos(){
        var validadorAtualizacao = AtualizacaoUsuario.builder()
                .build();
        Assertions.assertThrows(NaoInformadoDadosAtualizacaoUsuarioException.class, () -> dadosAtualizacaoUsuarioValidationRule.valida(validadorAtualizacao));
    }

    @Test
    public void naoDeveRetornarExceptionComCampoPreenchido(){
        var validadorAtualizacao = AtualizacaoUsuario.builder()
        .celular("143321")
        .build();
        Assertions.assertDoesNotThrow(() -> dadosAtualizacaoUsuarioValidationRule.valida(validadorAtualizacao));
    }
}
