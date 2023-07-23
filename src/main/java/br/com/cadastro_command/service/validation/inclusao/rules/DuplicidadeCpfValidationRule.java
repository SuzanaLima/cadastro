package br.com.cadastro_command.service.validation.inclusao.rules;

import br.com.cadastro_command.datacontract.request.UsuarioHttpRequest;
import br.com.cadastro_command.exception.DuplicidadeDeCpfUsuarioException;
import br.com.cadastro_command.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DuplicidadeCpfValidationRule {

    private UsuarioRepository repository;

    @Transactional(readOnly = true)
    public void valida(UsuarioHttpRequest usuarioHttpRequest){
        repository.findByCpfUsuario(usuarioHttpRequest.getCpf())
                .ifPresent(usuario -> {
                    throw new DuplicidadeDeCpfUsuarioException();
                });
    }
}
