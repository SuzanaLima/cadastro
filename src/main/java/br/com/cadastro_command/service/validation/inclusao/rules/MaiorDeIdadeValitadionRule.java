package br.com.cadastro_command.service.validation.inclusao.rules;

import br.com.cadastro_command.datacontract.request.UsuarioHttpRequest;
import br.com.cadastro_command.exception.IdadeNaoPermitidaUsuarioException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class MaiorDeIdadeValitadionRule {
    public void valida(UsuarioHttpRequest usuarioHttpRequest){
        var dataNascimento = usuarioHttpRequest.getDataNascimento();
        Period p = dataNascimento.until(LocalDate.now());
        if (p.getYears() < 18){
            throw new IdadeNaoPermitidaUsuarioException();
        }
    }
}
