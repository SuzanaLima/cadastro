package br.com.cadastro_command.mapper;

import br.com.cadastro_command.datacontract.domain.Usuario;
import br.com.cadastro_command.datacontract.request.UsuarioAtualizaHttpRequest;
import br.com.cadastro_command.datacontract.response.UsuarioAtualizaHttpResponse;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.function.Function;

public interface UsuarioAtualizarMapper extends Function<UsuarioAtualizaHttpRequest, Usuario> {

    UsuarioAtualizarMapper INSTANCE = Mappers.getMapper(UsuarioAtualizarMapper.class);

    @Mapping(source = "dataNascimento", target = "dataNascimentoUsuario")
    @Mapping(source = "telefone", target = "telefoneUsuario")
    @Mapping(source = "celular", target = "celularUsuario")
    Usuario atualizaRequestToDomain(UsuarioAtualizaHttpRequest atualizaHttpRequest);

    @Mapping(source = "dataNascimentoUsuario", target = "dataNascimento")
    @Mapping(source = "telefoneUsuario", target = "telefone")
    @Mapping(source = "celularUsuario", target = "celular")
    UsuarioAtualizaHttpResponse domainToAtualizaResponse(Usuario usuario);

}
