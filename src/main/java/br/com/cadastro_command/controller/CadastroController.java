package br.com.cadastro_command.controller;

import br.com.cadastro_command.datacontract.request.UsuarioAtualizaHttpRequest;
import br.com.cadastro_command.datacontract.request.UsuarioHttpRequest;
import br.com.cadastro_command.datacontract.response.UsuarioAtualizaHttpResponse;
import br.com.cadastro_command.datacontract.response.UsuarioHttpResponse;
import br.com.cadastro_command.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")
public class CadastroController {

    private UsuarioService usuarioService;
    @PostMapping
    public ResponseEntity<UsuarioHttpResponse> incluirUsuario(@RequestBody UsuarioHttpRequest usuarioHttpRequest){
        try{
            var usuarioResponse = usuarioService.inclusaoUsuario(usuarioHttpRequest);
            return new ResponseEntity<>(usuarioResponse,HttpStatus.OK);
        } catch (Exception e){
            throw e;
        }
    }

    @PatchMapping("/{id_usuario}")
    public ResponseEntity<UsuarioAtualizaHttpResponse> atualizarUsuario(@RequestBody UsuarioAtualizaHttpRequest
                                                                                    usuarioAtualizaHttpRequest){
        try{
            var usuarioAtualizado =  usuarioService.atualizaDadosUsuario(usuarioAtualizaHttpRequest);
            return new ResponseEntity<>(usuarioAtualizado,HttpStatus.OK);
        } catch (Exception e){
            throw e;
        }
    }

    @GetMapping("/{id_usuario}")
    public ResponseEntity<UsuarioAtualizaHttpResponse> consultarUsuario(@PathVariable("id_usuario") String cpfUsuario){
        try{
            var usuarioResponse = usuarioService.consultaUsuarioPorCpf(cpfUsuario);
            return new ResponseEntity<>(usuarioResponse,HttpStatus.OK);
        } catch (Exception e){
            throw e;
        }
    }

    @GetMapping("/{nome_usuario}")
    public ResponseEntity<UsuarioAtualizaHttpResponse> consultarUsuarioPorNome(@PathVariable("nome_usuario") String nomeUsuario){
        try{
            var usuarioResponse = usuarioService.consultaUsuarioPorNome(nomeUsuario);
            return new ResponseEntity<>(usuarioResponse,HttpStatus.OK);
        } catch (Exception e){
            throw e;
        }
    }

    @GetMapping("/usuarios")
    public ResponseEntity<List<UsuarioAtualizaHttpResponse>> listaUsuarios(){
        try{
            List<UsuarioAtualizaHttpResponse> usuariosCadastrados = usuarioService.listaUsuarioCadastrados();
            return new ResponseEntity<>(usuariosCadastrados,HttpStatus.OK);
        } catch (Exception e){
            throw e;
        }
    }


}
