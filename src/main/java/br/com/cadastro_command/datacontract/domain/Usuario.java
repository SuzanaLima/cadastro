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
    @Column(name = "")
    private String cpfUsuario;

    @Column(name = "")
    private String nomeUsuario;

    @Column(name = "")
    private LocalDate dataNascimentoUsuario;

    @Column(name = "")
    private String emailUsuario;

    @Column(name = "")
    private String telefoneUsuario;

    @Column(name = "")
    private String celularUsuario;
}
