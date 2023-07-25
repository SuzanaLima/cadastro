package br.com.cadastro_command.mapper;

import br.com.cadastro_command.datacontract.domain.Usuario;
import br.com.cadastro_command.datacontract.request.UsuarioHttpRequest;
import br.com.cadastro_command.datacontract.response.UsuarioHttpResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.function.Function;

@Mapper
public interface UsuarioMapper extends Function<UsuarioHttpRequest, Usuario> {
   UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

   @Mapping(source = "cpf", target = "cpfUsuario")
   @Mapping(source = "dataNascimento", target = "dataNascimentoUsuario")
   @Mapping(source = "telefone", target = "telefoneUsuario")
   @Mapping(source = "celular", target = "celularUsuario")
   Usuario ResquestToDomain(UsuarioHttpRequest usuarioHttpRequest);

   @Mapping(source = "nomeUsuario", target = "nomeUsuario")
   @Mapping(source = "emailUsuario", target = "emailUsuario")
   UsuarioHttpResponse DomainToResponse(Usuario usuario);

}
