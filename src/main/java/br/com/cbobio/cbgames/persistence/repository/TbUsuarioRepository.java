package br.com.cbobio.cbgames.persistence.repository;

import br.com.cbobio.cbgames.persistence.entity.TbUsuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TbUsuarioRepository extends JpaRepository<TbUsuario, Long> {

    Optional<TbUsuario> findByLoginUsuario(String loginUsuario);

    Optional<TbUsuario> findByEmailUsuario(String emailUsuario);

    boolean existsByLoginUsuario(String loginUsuario);

    boolean existsByEmailUsuario(String emailUsuario);
}