package br.com.cadastro_command.service.validation;

import br.com.cadastro_command.repository.UsuarioRepository;
import br.com.cadastro_command.service.validation.atualizacao.AtualizacaoValidator;
import br.com.cadastro_command.service.validation.inclusao.InclusaoValidator;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
public class UsuarioServiceTest {

    private final UsuarioRepository usuarioRepository = mock(UsuarioRepository.class);
    private final InclusaoValidator inclusaoValidator = mock(InclusaoValidator.class) ;
    private final AtualizacaoValidator atualizacaoValidator = mock(AtualizacaoValidator.class) ;

    void incluiUsuarioComSucesso(){

    }

    void atualizaUsuarioComSucesso(){

    }
}
