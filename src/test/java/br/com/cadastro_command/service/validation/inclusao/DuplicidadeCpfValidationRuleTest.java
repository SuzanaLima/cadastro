package br.com.cadastro_command.service.validation.inclusao;

import br.com.cadastro_command.datacontract.domain.Usuario;
import br.com.cadastro_command.datacontract.validation.InclusaoUsuario;
import br.com.cadastro_command.factory.UsuarioFactory;
import br.com.cadastro_command.factory.UsuarioResquestFactory;
import br.com.cadastro_command.repository.UsuarioRepository;
import br.com.cadastro_command.service.validation.inclusao.rules.DuplicidadeCpfValidationRule;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DuplicidadeCpfValidationRuleTest {
    private DuplicidadeCpfValidationRule duplicidadeCpfValidationRule = new DuplicidadeCpfValidationRule();
    private UsuarioRepository usuarioRepository = mock(UsuarioRepository.class);

    @Test
    public void deveRetornarExceptionNaDuplicidadeCpf(){
        Usuario usuario = UsuarioFactory.constroiUsuario();
        var usuarioHttpRequest =  UsuarioResquestFactory.constroiUsuarioMaiorDeIdade();
        var validadorInclusao = InclusaoUsuario.builder()
                .cpf(usuarioHttpRequest.getCpf())
                .emailUsuario(usuarioHttpRequest.getEmailUsuario())
                .nomeUsuario(usuarioHttpRequest.getNomeUsuario())
                .celular(usuarioHttpRequest.getCelular())
                .telefone(usuarioHttpRequest.getTelefone())
                .dataNascimento(usuarioHttpRequest.getDataNascimento())
                .build();

        when(usuarioRepository.findByCpfUsuario("000.000.000-00")).thenReturn(Optional.of(usuario));
    }
}
