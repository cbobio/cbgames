package br.com.cbobio.cbgames.service;

import br.com.cbobio.cbgames.persistence.entity.TbVendaItem;

import java.util.List;

public interface VendaItemService {

    TbVendaItem salvar(TbVendaItem item);

    TbVendaItem buscarPorId(Long id);

    List<TbVendaItem> listar();

    void excluir(Long id);

}