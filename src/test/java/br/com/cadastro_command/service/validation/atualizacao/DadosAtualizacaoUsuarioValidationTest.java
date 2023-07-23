package br.com.cadastro_command.service.validation.atualizacao;


import br.com.cadastro_command.exception.atualiza.NaoInformadoDadosAtualizacaoUsuarioException;
import br.com.cadastro_command.factory.UsuarioAtualizacaoRequestFactory;
import br.com.cadastro_command.service.validation.atualizacao.rules.DadosAtualizacaoUsuarioValidationRule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DadosAtualizacaoUsuarioValidationTest {

    private DadosAtualizacaoUsuarioValidationRule dadosAtualizacaoUsuarioValidationRule = new DadosAtualizacaoUsuarioValidationRule();

    @Test
    public void deveRetornarExceptionComCamposNulos(){
        var atualizaRequest  = UsuarioAtualizacaoRequestFactory.constroiUsuarioAtualizaHttpRequestVazio();
        Assertions.assertThrows(NaoInformadoDadosAtualizacaoUsuarioException.class, () -> dadosAtualizacaoUsuarioValidationRule.valida(atualizaRequest));
    }

    @Test
    public void naoDeveRetornarExceptionComCampoPreenchido(){
        var atualizaRequest = UsuarioAtualizacaoRequestFactory.constroiUsuarioAtualizaHttpRequestComApenasUmCampo();
        Assertions.assertDoesNotThrow(() -> dadosAtualizacaoUsuarioValidationRule.valida(atualizaRequest));
    }
}
