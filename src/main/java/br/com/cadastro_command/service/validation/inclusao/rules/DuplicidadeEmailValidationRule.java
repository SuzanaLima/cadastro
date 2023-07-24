package br.com.cadastro_command.service.validation.inclusao.rules;

import br.com.cadastro_command.datacontract.validation.InclusaoUsuario;
import br.com.cadastro_command.exception.DuplicidadeDeEmailUsuarioException;
import br.com.cadastro_command.repository.UsuarioRepository;
import br.com.cadastro_command.service.validation.inclusao.InclusaoRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DuplicidadeEmailValidationRule implements InclusaoRule {
    @Autowired
    private UsuarioRepository repository;

    @Transactional(readOnly = true)
    @Override
    public void valida(InclusaoUsuario inclusaoUsuario) {
        repository.findByEmailUsuario(inclusaoUsuario.getEmailUsuario())
                .ifPresent(usuario -> {
                    throw new DuplicidadeDeEmailUsuarioException();
                });
    }
}
