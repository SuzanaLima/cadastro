package br.com.cadastro_command.datacontract.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioAtualizaHttpRequest {
    @JsonProperty("nome_usuario")
    private String nomeUsuario;

    @JsonProperty("email_usuario")
    private String emailUsuario;

    @JsonProperty("data_nascimento")
    private LocalDate dataNascimento;

    @JsonProperty("telefone")
    private String telefone;

    @JsonProperty("celular")
    private String celular;
}
