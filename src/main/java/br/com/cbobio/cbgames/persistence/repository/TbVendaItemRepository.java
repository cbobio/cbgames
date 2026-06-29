package br.com.cbobio.cbgames.persistence.repository;

import br.com.cbobio.cbgames.persistence.entity.TbVendaItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TbVendaItemRepository extends JpaRepository<TbVendaItem, Long> {

    List<TbVendaItem> findByVendaId(Long vendaId);

    List<TbVendaItem> findByJogoId(Long jogoId);
}