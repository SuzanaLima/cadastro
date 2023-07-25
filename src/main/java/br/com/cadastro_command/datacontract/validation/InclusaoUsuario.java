package br.com.cadastro_command.datacontract.validation;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class InclusaoUsuario {

    private String nomeUsuario;
    private String emailUsuario;
    private LocalDate dataNascimento;
    private String cpf;
    private String telefone;
    private String celular;
}
