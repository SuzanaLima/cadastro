package br.com.cadastro_command.service.validation.inclusao;

import br.com.cadastro_command.datacontract.domain.Usuario;
import br.com.cadastro_command.datacontract.validation.InclusaoUsuario;
import br.com.cadastro_command.exception.DuplicidadeDeCpfUsuarioException;
import br.com.cadastro_command.factory.UsuarioResquestFactory;
import br.com.cadastro_command.repository.UsuarioRepository;
import br.com.cadastro_command.service.validation.inclusao.rules.DuplicidadeCpfValidationRule;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

//import static utils.JsonLoader.loadObjectFrom;
public class DuplicidadeCpfValidationRuleTest {
    //todo ajustar impl
//    private DuplicidadeCpfValidationRule duplicidadeCpfValidationRule = new DuplicidadeCpfValidationRule();
//    private UsuarioRepository usuarioRepository = mock(UsuarioRepository.class);
//    @Test
//    public void deveRetornarExceptionNaDuplicidadeCpf(){
//       // when(usuarioRepository.findByCpfUsuario(anyString())).thenReturn(Optional.of(mock(Usuario.class)));
//
//        var usuarioHttpRequest =  UsuarioResquestFactory.constroiUsuarioMaiorDeIdade();
//        var validadorInclusao = InclusaoUsuario.builder()
//                .cpf(usuarioHttpRequest.getCpf())
//                .emailUsuario(usuarioHttpRequest.getEmailUsuario())
//                .nomeUsuario(usuarioHttpRequest.getNomeUsuario())
//                .celular(usuarioHttpRequest.getCelular())
//                .telefone(usuarioHttpRequest.getTelefone())
//                .dataNascimento(usuarioHttpRequest.getDataNascimento())
//                .build();
//        assertThrows(DuplicidadeDeCpfUsuarioException.class, () -> duplicidadeCpfValidationRule.valida(validadorInclusao));
//    }
}
