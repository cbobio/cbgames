package br.com.cbobio.cbgames.service;

import br.com.cbobio.cbgames.persistence.entity.TbUsuario;

import java.util.List;

public interface UsuarioService {

    TbUsuario salvar(TbUsuario usuario);

    TbUsuario buscarPorId(Long id);

    TbUsuario buscarPorLogin(String login);

    List<TbUsuario> listar();

    void excluir(Long id);

}