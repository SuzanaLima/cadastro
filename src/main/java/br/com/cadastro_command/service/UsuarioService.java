package br.com.cadastro_command.service;

import br.com.cadastro_command.datacontract.request.UsuarioAtualizaHttpRequest;
import br.com.cadastro_command.datacontract.request.UsuarioHttpRequest;
import br.com.cadastro_command.datacontract.response.UsuarioAtualizaHttpResponse;
import br.com.cadastro_command.datacontract.response.UsuarioHttpResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UsuarioService {

    public UsuarioHttpResponse inclusaoUsuario(UsuarioHttpRequest usuarioHttpRequest){

        //todo validar
        // Somente usuários acima de 18 anos serão cadastrados
        // Não será permitido usuários com e-mail e CPF duplicados
        // Validar se o CPF é válido (dígitos verificadores);

        // map request to domain

        return null;
    }

    public UsuarioAtualizaHttpResponse atualizaDadosUsuario(UsuarioAtualizaHttpRequest dadosAtualizacao){
        return null;
    }

    public UsuarioAtualizaHttpResponse consultaUsuarioPorCpf(String idUsuario){
        return null;
    }

    public UsuarioAtualizaHttpResponse consultaUsuarioPorNome(String nomeUsuario){
        return null;
    }

    public List<UsuarioAtualizaHttpResponse> listaUsuarioCadastrados(){

        return null;
    }
}
