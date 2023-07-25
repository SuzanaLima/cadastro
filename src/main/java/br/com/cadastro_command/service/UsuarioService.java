package br.com.cadastro_command.service;

import br.com.cadastro_command.datacontract.domain.Usuario;
import br.com.cadastro_command.datacontract.request.UsuarioAtualizaHttpRequest;
import br.com.cadastro_command.datacontract.request.UsuarioHttpRequest;
import br.com.cadastro_command.datacontract.response.UsuarioAtualizaHttpResponse;
import br.com.cadastro_command.datacontract.response.UsuarioHttpResponse;
import br.com.cadastro_command.datacontract.validation.AtualizacaoUsuario;
import br.com.cadastro_command.datacontract.validation.InclusaoUsuario;
import br.com.cadastro_command.exception.UsuarioInexistenteException;
import br.com.cadastro_command.mapper.UsuarioAtualizarMapper;
import br.com.cadastro_command.mapper.UsuarioMapper;
import br.com.cadastro_command.repository.UsuarioRepository;
import br.com.cadastro_command.service.validation.atualizacao.AtualizacaoValidator;
import br.com.cadastro_command.service.validation.inclusao.InclusaoValidator;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final InclusaoValidator inclusaoValidator;
    private final AtualizacaoValidator atualizacaoValidator;
    @Transactional
    public UsuarioHttpResponse inclusaoUsuario(UsuarioHttpRequest usuarioHttpRequest){
        var validadorInclusao = InclusaoUsuario.builder()
                .cpf(usuarioHttpRequest.getCpf())
                .emailUsuario(usuarioHttpRequest.getEmailUsuario())
                .nomeUsuario(usuarioHttpRequest.getNomeUsuario())
                .celular(usuarioHttpRequest.getCelular())
                .telefone(usuarioHttpRequest.getTelefone())
                .dataNascimento(usuarioHttpRequest.getDataNascimento())
                .build();

        inclusaoValidator.valida(validadorInclusao);

        var usuarioDomain = UsuarioMapper.INSTANCE.ResquestToDomain(usuarioHttpRequest);
        try{
            usuarioRepository.save(usuarioDomain);
        } catch (Exception e){
            throw e;
        }

        return UsuarioMapper.INSTANCE.DomainToResponse(usuarioDomain);
    }

    @Transactional
    public UsuarioAtualizaHttpResponse atualizaDadosUsuario(UsuarioAtualizaHttpRequest dadosAtualizacao,
                                                            String cpfUsuario){
        var validadorAtualizacao = AtualizacaoUsuario.builder()
                .dataNascimento(dadosAtualizacao.getDataNascimento())
                .celular(dadosAtualizacao.getCelular())
                .telefone(dadosAtualizacao.getTelefone())
                .celular(dadosAtualizacao.getCelular())
                .emailUsuario(dadosAtualizacao.getEmailUsuario())
                .build();
        atualizacaoValidator.valida(validadorAtualizacao);
        var usuarioAtual = usuarioRepository.findByCpfUsuario(cpfUsuario).orElseThrow(UsuarioInexistenteException::new);

        var usuarioAtualizado = AtualizaeSalvaUsuario(dadosAtualizacao, usuarioAtual);

        return UsuarioAtualizarMapper.INSTANCE.domainToAtualizaResponse(usuarioAtualizado);
    }

    @Transactional
    private Usuario AtualizaeSalvaUsuario(UsuarioAtualizaHttpRequest request, Usuario usuario){
        try{
            if(StringUtils.isNoneEmpty(request.getNomeUsuario())){
                usuario.setNomeUsuario(request.getNomeUsuario());
            }
            if(StringUtils.isNoneEmpty(request.getEmailUsuario())){
                usuario.setEmailUsuario(request.getEmailUsuario());
            }
            if(StringUtils.isNotEmpty(request.getCelular())){
                usuario.setCelularUsuario(request.getCelular());
            }
            if(StringUtils.isNotEmpty(request.getTelefone())){
                usuario.setTelefoneUsuario(request.getTelefone());
            }
            if(request.getDataNascimento() != null){
                usuario.setDataNascimentoUsuario(request.getDataNascimento());
            }
            usuarioRepository.save(usuario);
        } catch (Exception e){
            throw e;
        }
        return usuario;
    }

    public UsuarioAtualizaHttpResponse consultaUsuarioPorCpf(String idUsuario){
        var usuario = usuarioRepository.findByCpfUsuario(idUsuario)
                .orElseThrow(UsuarioInexistenteException::new);

        return UsuarioAtualizarMapper.INSTANCE.domainToAtualizaResponse(usuario);
    }

    public UsuarioAtualizaHttpResponse consultaUsuarioPorNome(String nomeUsuario){
        var usuario = usuarioRepository.findByNomeUsuario(nomeUsuario)
                .orElseThrow(UsuarioInexistenteException::new);
        return UsuarioAtualizarMapper.INSTANCE.domainToAtualizaResponse(usuario);
    }

    public List<UsuarioAtualizaHttpResponse> listaUsuarioCadastrados(){
        var usuarios = usuarioRepository.findAll();
        List<UsuarioAtualizaHttpResponse> usuariosHttpResponse = new ArrayList<>();

        for (Usuario usuario: usuarios) {
            usuariosHttpResponse.add(UsuarioAtualizarMapper.INSTANCE.domainToAtualizaResponse(usuario));
        }

        return usuariosHttpResponse;
    }
}
