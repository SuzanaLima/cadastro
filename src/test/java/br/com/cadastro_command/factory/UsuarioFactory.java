package br.com.cadastro_command.factory;

import br.com.cadastro_command.datacontract.domain.Usuario;
import org.junit.jupiter.api.TestFactory;

import java.time.LocalDate;

public class UsuarioFactory {

    @TestFactory
    public static Usuario constroiUsuario(){
        return Usuario.builder()
                .nomeUsuario("Joao")
                .emailUsuario("email@test")
                .cpfUsuario("000.000.000-00")
                .celularUsuario("1234546")
                .telefoneUsuario("31546")
                .dataNascimentoUsuario(LocalDate.of(1995,07,2))
                .build();
    }
}
