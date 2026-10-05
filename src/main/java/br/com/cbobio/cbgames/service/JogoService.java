package br.com.cbobio.cbgames.service;

import br.com.cbobio.cbgames.persistence.entity.TbJogo;

import java.util.List;

public interface JogoService {

    TbJogo salvar(TbJogo jogo);

    TbJogo buscarPorId(Long id);

    List<TbJogo> listar();

    List<TbJogo> listarEstoqueBaixo();

    void excluir(Long id);

}