package br.com.cbobio.cbgames.persistence.repository;

import br.com.cbobio.cbgames.machine.enums.TipoMovimentacaoEstoque;
import br.com.cbobio.cbgames.persistence.entity.TbMovimentacaoEstoque;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TbMovimentacaoEstoqueRepository extends JpaRepository<TbMovimentacaoEstoque, Long> {

    List<TbMovimentacaoEstoque> findByJogoId(Long jogoId);

    List<TbMovimentacaoEstoque> findByTipoMovimentacao(TipoMovimentacaoEstoque tipoMovimentacao);
}