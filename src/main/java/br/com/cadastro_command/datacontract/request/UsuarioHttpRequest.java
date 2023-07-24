package br.com.cadastro_command.datacontract.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuarioHttpRequest {
    @JsonProperty("nome_usuario")
    private String nomeUsuario;

    @JsonProperty("email_usuario")
    private String emailUsuario;

    @JsonProperty("data_nascimento")
    private LocalDate dataNascimento;

    @Pattern(regexp = "(^\\d{3}\\x2E\\d{3}\\x2E\\d{3}\\x2D\\d{2}$)", message = "cpj inválido")
    @NotEmpty(message = "É obrigatório informar cpf")
    @JsonProperty("cpf_usuario")
    private String cpf;

    @JsonProperty("telefone")
    private String telefone;

    @JsonProperty("celular")
    private String celular;
}
