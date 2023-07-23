package br.com.cadastro_command.service.validation.atualizacao.rules;

import br.com.cadastro_command.datacontract.request.UsuarioAtualizaHttpRequest;
import br.com.cadastro_command.exception.atualiza.NaoInformadoDadosAtualizacaoUsuarioException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class DadosAtualizacaoUsuarioValidationRule {

    public void valida(UsuarioAtualizaHttpRequest atualizaHttpRequest){
        var dataNascimento = atualizaHttpRequest.getDataNascimento();
        var nomeUsuario = atualizaHttpRequest.getNomeUsuario();
        var emailUsuario = atualizaHttpRequest.getEmailUsuario();
        var telefoneUsuario = atualizaHttpRequest.getTelefone();
        var celularUsuario = atualizaHttpRequest.getCelular();

        if(!StringUtils.hasText(nomeUsuario) && !StringUtils.hasText(emailUsuario)
         && !StringUtils.hasText(telefoneUsuario) && !StringUtils.hasText(celularUsuario)
         && dataNascimento == null){
            throw new NaoInformadoDadosAtualizacaoUsuarioException();
        }
    }
}
