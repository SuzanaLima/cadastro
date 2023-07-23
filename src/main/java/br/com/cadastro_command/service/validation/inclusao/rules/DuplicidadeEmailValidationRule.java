package br.com.cadastro_command.service.validation.inclusao.rules;

import br.com.cadastro_command.datacontract.request.UsuarioHttpRequest;
import br.com.cadastro_command.exception.DuplicidadeDeEmailUsuarioException;
import br.com.cadastro_command.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DuplicidadeEmailValidationRule {
    private UsuarioRepository repository;

    @Transactional(readOnly = true)
    public void valida(UsuarioHttpRequest usuarioHttpRequest){
        repository.findByEmailUsuario(usuarioHttpRequest.getEmailUsuario())
                .ifPresent(usuario -> {
                    throw new DuplicidadeDeEmailUsuarioException();
                });
    }
}
