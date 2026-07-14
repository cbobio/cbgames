package br.com.cbobio.cbgames.service;

import br.com.cbobio.cbgames.persistence.entity.TbCliente;

import java.util.List;

public interface ClienteService {

    TbCliente salvar(TbCliente cliente);

    TbCliente buscarPorId(Long id);

    TbCliente buscarPorCpf(String cpf);

    List<TbCliente> listar();

    void excluir(Long id);

}