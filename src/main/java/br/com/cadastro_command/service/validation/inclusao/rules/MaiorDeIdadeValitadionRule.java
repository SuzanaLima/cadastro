package br.com.cadastro_command.service.validation.inclusao.rules;

import br.com.cadastro_command.datacontract.validation.InclusaoUsuario;
import br.com.cadastro_command.exception.IdadeNaoPermitidaUsuarioException;
import br.com.cadastro_command.service.validation.inclusao.InclusaoRule;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class MaiorDeIdadeValitadionRule implements InclusaoRule {
    @Override
    public void valida(InclusaoUsuario inclusaoUsuario) {
        var dataNascimento = inclusaoUsuario.getDataNascimento();
        Period p = dataNascimento.until(LocalDate.now());
        if (p.getYears() < 18){
            throw new IdadeNaoPermitidaUsuarioException();
        }
    }
}
