package br.com.cadastro_command.datacontract.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioAtualizaHttpResponse {
    @JsonProperty("nome_usuario")
    private String nomeUsuario;

    @JsonProperty("email_usuario")
    private String emailUsuario;

    @JsonProperty("telefone")
    private String telefone;

    @JsonProperty("celular")
    private String celular;
}
