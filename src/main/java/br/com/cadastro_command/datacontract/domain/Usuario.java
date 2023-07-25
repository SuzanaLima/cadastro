package br.com.cadastro_command.datacontract.domain;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Data
@Builder
@Entity
@Table(name = "tb_usuarios")
public class Usuario {

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
