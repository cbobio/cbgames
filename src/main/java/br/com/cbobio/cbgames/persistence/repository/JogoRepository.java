package br.com.cbobio.cbgames.persistence.repository;

import br.com.cbobio.cbgames.persistence.entity.TbJogo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface JogoRepository extends JpaRepository<TbJogo, Long> {

    Optional<TbJogo> findByNomeJogoIgnoreCase(String nomeJogo);

    boolean existsByNomeJogoIgnoreCase(String nomeJogo);

    List<TbJogo> findByNomeJogoContainingIgnoreCase(String nomeJogo);

    List<TbJogo> findByPlataformaJogoIgnoreCase(String plataformaJogo);

    List<TbJogo> findByGeneroJogoIgnoreCase(String generoJogo);

    List<TbJogo> findByQuantidadeEstoqueLessThanEqual(
            Integer quantidadeEstoque
    );
}