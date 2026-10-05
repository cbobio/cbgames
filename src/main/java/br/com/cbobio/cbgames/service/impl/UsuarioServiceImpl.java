package br.com.cbobio.cbgames.service.impl;

import br.com.cbobio.cbgames.persistence.entity.TbUsuario;
import br.com.cbobio.cbgames.persistence.repository.UsuarioRepository;
import br.com.cbobio.cbgames.service.UsuarioService;
import br.com.cbobio.cbgames.service.exceptions.UsuarioNaoEncontradoException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Override
    public TbUsuario salvar(TbUsuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public TbUsuario buscarPorId(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() ->
                        new UsuarioNaoEncontradoException("Usuário não encontrado: " + id));
    }

    @Override
    public TbUsuario buscarPorLogin(String login) {
        return usuarioRepository.findByLoginUsuario(login)
                .orElseThrow(() ->
                        new UsuarioNaoEncontradoException("Usuário não encontrado."));
    }

    @Override
    public List<TbUsuario> listar() {
        return usuarioRepository.findAll();
    }

    @Override
    public void excluir(Long id) {
        usuarioRepository.delete(buscarPorId(id));
    }

}