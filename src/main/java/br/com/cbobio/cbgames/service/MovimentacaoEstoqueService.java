package br.com.cbobio.cbgames.service;

import br.com.cbobio.cbgames.persistence.entity.TbMovimentacaoEstoque;

import java.util.List;

public interface MovimentacaoEstoqueService {

    TbMovimentacaoEstoque salvar(TbMovimentacaoEstoque movimentacao);

    TbMovimentacaoEstoque buscarPorId(Long id);

    List<TbMovimentacaoEstoque> listar();

    void excluir(Long id);

}