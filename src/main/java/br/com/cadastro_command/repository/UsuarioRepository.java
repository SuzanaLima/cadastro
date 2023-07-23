package br.com.cadastro_command.repository;

import br.com.cadastro_command.datacontract.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {

    Optional<Usuario> findByCpfUsuario(String cpfUsuario);

    Optional<Usuario> findByNomeUsuario(String nomeUsuario);

    Optional<Usuario> findByEmailUsuario(String emailUsuario);

    List<Usuario> findAll();



}
