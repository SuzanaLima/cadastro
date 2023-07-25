package br.com.cadastro_command.service.validation;

import br.com.cadastro_command.datacontract.domain.Usuario;
import br.com.cadastro_command.datacontract.response.UsuarioAtualizaHttpResponse;
import br.com.cadastro_command.datacontract.response.UsuarioHttpResponse;
import br.com.cadastro_command.factory.UsuarioAtualizacaoRequestFactory;
import br.com.cadastro_command.factory.UsuarioFactory;
import br.com.cadastro_command.factory.UsuarioResquestFactory;
import br.com.cadastro_command.repository.UsuarioRepository;
import br.com.cadastro_command.service.UsuarioService;
import br.com.cadastro_command.service.validation.atualizacao.AtualizacaoValidator;
import br.com.cadastro_command.service.validation.inclusao.InclusaoValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UsuarioServiceTest {

    private final UsuarioRepository usuarioRepository = mock(UsuarioRepository.class);
    private final InclusaoValidator inclusaoValidator = mock(InclusaoValidator.class);
    private final AtualizacaoValidator atualizacaoValidator = mock(AtualizacaoValidator.class);
    private final UsuarioService usuarioService = new UsuarioService(
            usuarioRepository,
            inclusaoValidator,
            atualizacaoValidator
    );

    @DisplayName("Teste de inclusao")
    @Test
    void incluiUsuarioComSucesso(){
        var request = UsuarioResquestFactory.constroiUsuarioMaiorDeIdade();
        UsuarioHttpResponse response = usuarioService.inclusaoUsuario(request);

        verify(usuarioRepository, times(1)).save(any(Usuario.class));
        Assertions.assertNotNull(response.getEmailUsuario());
        Assertions.assertNotNull(response.getNomeUsuario());
        Assertions.assertEquals(response.getEmailUsuario(), request.getEmailUsuario());
        Assertions.assertEquals(response.getNomeUsuario(), request.getNomeUsuario());
    }

    @DisplayName("Teste de atualizacao")
    @Test
    void atualizaUsuarioComSucesso(){
        Usuario usuario = UsuarioFactory.constroiUsuario();
        when(usuarioRepository.findByCpfUsuario("000.000.000-00")).thenReturn(Optional.of(usuario));

        var request = UsuarioAtualizacaoRequestFactory.constroiUsuarioAtualizaHttpRequestComApenasUmCampo();
        request.setEmailUsuario("Teste alterou campo");
        UsuarioAtualizaHttpResponse response = usuarioService.atualizaDadosUsuario(request, "000.000.000-00");

        verify(usuarioRepository, times(1)).save(any(Usuario.class));
        Assertions.assertEquals(response.getEmailUsuario(), request.getEmailUsuario());
    }
}
