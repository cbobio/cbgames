package br.com.cbobio.cbgames.persistence.repository;

import br.com.cbobio.cbgames.enums.TipoMovimentacaoEstoque;
import br.com.cbobio.cbgames.persistence.entity.TbMovimentacaoEstoque;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovimentacaoEstoqueRepository extends JpaRepository<TbMovimentacaoEstoque, Long> {

}