package br.com.cadastro_command.factory;

import br.com.cadastro_command.datacontract.request.UsuarioAtualizaHttpRequest;
import org.junit.jupiter.api.TestFactory;

public class UsuarioAtualizacaoRequestFactory {

    @TestFactory
    public static UsuarioAtualizaHttpRequest constroiUsuarioAtualizaHttpRequestVazio(){
        return UsuarioAtualizaHttpRequest.builder()
                .nomeUsuario("")
                .emailUsuario("")
                .celular("")
                .telefone("")
                .dataNascimento(null).build();
    }

    @TestFactory
    public static UsuarioAtualizaHttpRequest constroiUsuarioAtualizaHttpRequestComApenasUmCampo(){
        return UsuarioAtualizaHttpRequest.builder()
                .nomeUsuario("")
                .emailUsuario("suzanalima@hotmail")
                .celular("")
                .telefone("")
                .dataNascimento(null).build();
    }
}
