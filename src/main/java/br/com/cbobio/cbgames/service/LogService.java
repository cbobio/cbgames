package br.com.cbobio.cbgames.service;

import br.com.cbobio.cbgames.persistence.entity.TbLog;

import java.util.List;

public interface LogService {

    TbLog salvar(TbLog log);

    TbLog buscarPorId(Long id);

    List<TbLog> listar();

}