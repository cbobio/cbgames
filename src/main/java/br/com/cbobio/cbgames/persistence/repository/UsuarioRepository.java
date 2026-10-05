package br.com.cbobio.cbgames.persistence.repository;

import br.com.cbobio.cbgames.persistence.entity.TbUsuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<TbUsuario, Long> {

}