package br.com.cadastro_command.service.validation.atualizacao;

import br.com.cadastro_command.datacontract.validation.AtualizacaoUsuario;
import br.com.cadastro_command.service.validation.Validator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AtualizacaoValidator implements Validator<AtualizacaoRule, AtualizacaoUsuario> {

    private final List<AtualizacaoRule> atualizacaoRules;

    @Override
    public List<AtualizacaoRule> getRules() {
        return atualizacaoRules;
    }
}
