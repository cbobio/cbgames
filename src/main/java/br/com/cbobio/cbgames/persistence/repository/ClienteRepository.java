package br.com.cbobio.cbgames.persistence.repository;

import br.com.cbobio.cbgames.persistence.entity.TbCliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<TbCliente, Long> {

    Optional<TbCliente> findByCpfCliente(String cpfCliente);

    Optional<TbCliente> findByEmailCliente(String emailCliente);

    boolean existsByCpfCliente(String cpfCliente);

    boolean existsByEmailCliente(String emailCliente);
}