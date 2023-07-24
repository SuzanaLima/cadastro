package br.com.cadastro_command.service.validation.atualizacao.rules;

import br.com.cadastro_command.datacontract.validation.AtualizacaoUsuario;
import br.com.cadastro_command.exception.NaoInformadoDadosAtualizacaoUsuarioException;
import br.com.cadastro_command.service.validation.atualizacao.AtualizacaoRule;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class DadosAtualizacaoUsuarioValidationRule implements AtualizacaoRule {

    @Override
    public void valida(AtualizacaoUsuario atualizacaoUsuario) {
        var dataNascimento = atualizacaoUsuario.getDataNascimento();
        var nomeUsuario = atualizacaoUsuario.getNomeUsuario();
        var emailUsuario = atualizacaoUsuario.getEmailUsuario();
        var telefoneUsuario = atualizacaoUsuario.getTelefone();
        var celularUsuario = atualizacaoUsuario.getCelular();

        if(!StringUtils.hasText(nomeUsuario) && !StringUtils.hasText(emailUsuario)
                && !StringUtils.hasText(telefoneUsuario) && !StringUtils.hasText(celularUsuario)
                && dataNascimento == null){
            throw new NaoInformadoDadosAtualizacaoUsuarioException();
        }
    }
}
