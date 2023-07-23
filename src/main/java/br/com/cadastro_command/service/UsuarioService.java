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

        //todo - Validar se o CPF é válido (dígitos verificadores);
        // map request to domain

        return null;
    }

    public UsuarioAtualizaHttpResponse atualizaDadosUsuario(UsuarioAtualizaHttpRequest dadosAtualizacao){
        //todo - validar se foram informados dados para atualizacao
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
