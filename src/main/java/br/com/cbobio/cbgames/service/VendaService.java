package br.com.cbobio.cbgames.service;

import br.com.cbobio.cbgames.machine.enums.eventos.EventoVenda;
import br.com.cbobio.cbgames.persistence.entity.TbVenda;

import java.util.List;

public interface VendaService {

    TbVenda salvar(TbVenda venda);

    TbVenda buscarPorId(Long id);

    List<TbVenda> listar();

    void excluir(Long id);

    TbVenda alterarStatus(Long vendaId, EventoVenda evento);

}