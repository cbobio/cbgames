package br.com.cbobio.cbgames.persistence.repository;

import br.com.cbobio.cbgames.persistence.entity.TbJogo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JogoRepository extends JpaRepository<TbJogo, Long> {

}