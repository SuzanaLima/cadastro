package br.com.cadastro_command.datacontract.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
//@Table(name = "", schema = "")
public class Usuario {

    //todo adicionar nome tabela e colunas
    @Id
    @Column(name = "")
    private String cpf;

    @Column(name = "")
    private String nomeUsuario;

    @Column(name = "")
    private String emailUsuario;

    @Column(name = "")
    private String telefone;

    @Column(name = "")
    private String celular;
}
