package br.com.cadastro_command.datacontract.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@Entity
//@Table(name = "", schema = "")
public class Usuario {

    //todo adicionar nome tabela e colunas
    @Id
    @Column(name = "codigoIdentificado")
    private String cpfUsuario;

    @Column(name = "nome")
    private String nomeUsuario;

    @Column(name = "dataNascimento")
    private LocalDate dataNascimentoUsuario;

    @Column(name = "email")
    private String emailUsuario;

    @Column(name = "telefone")
    private String telefoneUsuario;

    @Column(name = "celular")
    private String celularUsuario;
}
