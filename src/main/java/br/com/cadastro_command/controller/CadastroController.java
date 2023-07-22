package br.com.cadastro_command.controller;

import br.com.cadastro_command.datacontract.request.UsuarioAtualizaHttpRequest;
import br.com.cadastro_command.datacontract.request.UsuarioHttpRequest;
import br.com.cadastro_command.datacontract.response.UsuarioAtualizaHttpResponse;
import br.com.cadastro_command.datacontract.response.UsuarioHttpResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")
public class CadastroController {
    @PostMapping
    public ResponseEntity<UsuarioHttpResponse> incluirUsuario(@RequestBody UsuarioHttpRequest usuarioHttpRequest){
        var logCode = "Post";
        //todo correcao
        return null;
    }

    @PatchMapping("/{id_usuario}")
    public ResponseEntity<UsuarioAtualizaHttpResponse> atualizarUsuario(@RequestBody UsuarioAtualizaHttpRequest
                                                                                    usuarioAtualizaHttpRequest){
        var LogCode = "Patch";
        //todo correcao
        return null;
    }

    @GetMapping("/{id_usuario}")
    public ResponseEntity<UsuarioAtualizaHttpResponse> consultarUsuario(@PathVariable("id_usuario") String cpfUsuario){
        var LogCode = "Get";
        //todo correcao
        return null;
    }

    @GetMapping("/{nome_usuario}")
    public ResponseEntity<UsuarioAtualizaHttpResponse> consultarUsuarioPorNome(@PathVariable("nome_usuario") String nomeUsuario){
        var LogCode = "Get";
        //todo correcao
        return null;
    }

    @GetMapping("/usuarios")
    public ResponseEntity<List<UsuarioAtualizaHttpResponse>> listaUsuarios(){
        var LogCode = "Get";
        //todo correcao
        return new ResponseEntity<>(HttpStatus.OK);
    }


}