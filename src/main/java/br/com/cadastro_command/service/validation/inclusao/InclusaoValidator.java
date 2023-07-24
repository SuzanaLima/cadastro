package br.com.cadastro_command.service.validation.inclusao;

import br.com.cadastro_command.datacontract.validation.InclusaoUsuario;
import br.com.cadastro_command.service.validation.Validator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class InclusaoValidator implements Validator<InclusaoRule, InclusaoUsuario> {
    private final List<InclusaoRule> inclusaoRule;


    @Override
    public List<InclusaoRule> getRules() {
        return inclusaoRule;
    }
}
