package br.com.cbobio.cbgames.service;

import br.com.cbobio.cbgames.persistence.entity.TbEndereco;

import java.util.List;

public interface EnderecoService {

    TbEndereco salvar(TbEndereco endereco);

    TbEndereco buscarPorId(Long id);

    List<TbEndereco> listar();

    void excluir(Long id);

}