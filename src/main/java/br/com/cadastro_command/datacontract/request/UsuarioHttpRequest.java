package br.com.cadastro_command.datacontract.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioHttpRequest {
    @JsonProperty("nome_usuario")
    private String nomeUsuario;

    @JsonProperty("email_usuario")
    private String emailUsuario;

    @JsonProperty("cpf_usuario")
    private String cpf;

    @JsonProperty("telefone")
    private String telefone;

    @JsonProperty("celular")
    private String celular;
}
