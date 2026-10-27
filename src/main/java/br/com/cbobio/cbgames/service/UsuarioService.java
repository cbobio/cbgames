package br.com.cbobio.cbgames.service;

import br.com.cbobio.cbgames.persistence.entity.TbUsuario;
import br.com.cbobio.cbgames.persistence.repository.UsuarioRepository;
import br.com.cbobio.cbgames.service.exceptions.UsuarioNaoEncontradoException;
import br.com.cbobio.cbgames.web.controller.dto.mapper.UsuarioMapper;
import br.com.cbobio.cbgames.web.controller.dto.request.usuario.UsuarioRequestDto;
import br.com.cbobio.cbgames.web.controller.dto.response.usuario.UsuarioResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import br.com.cbobio.cbgames.web.controller.dto.request.usuario.UsuarioAtualizacaoRequestDto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;
    private final PasswordEncoder passwordEncoder;
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public UsuarioResponseDto cadastrar(UsuarioRequestDto dto) {

        if (usuarioRepository.existsByEmailUsuario(dto.getEmailUsuario())) {
            throw new IllegalArgumentException(
                    "Já existe um usuário cadastrado com este e-mail."
            );
        }

        if (usuarioRepository.existsByLoginUsuario(dto.getLoginUsuario())) {
            throw new IllegalArgumentException(
                    "Já existe um usuário cadastrado com este login."
            );
        }

        TbUsuario usuario = usuarioMapper.toEntity(dto);

        usuario.setSenhaUsuario(
                passwordEncoder.encode(dto.getSenhaUsuario())
        );

        TbUsuario usuarioSalvo = usuarioRepository.save(usuario);

        return usuarioMapper.toResponseDto(usuarioSalvo);
    }

    @Transactional
    public UsuarioResponseDto buscarPorId(Long id) {

        TbUsuario usuario = buscarUsuario(id);

        entityManager.refresh(usuario);

        return usuarioMapper.toResponseDto(usuario);
    }

    @Transactional(readOnly = true)
    public List<UsuarioResponseDto> listarTodos() {

        return usuarioMapper.toResponseDtoList(
                usuarioRepository.findAll()
        );
    }

    @Transactional
    public UsuarioResponseDto atualizar(
            Long id,
            UsuarioAtualizacaoRequestDto dto) {

        TbUsuario usuario = buscarUsuario(id);

        if (!usuario.getEmailUsuario().equals(dto.getEmailUsuario())
                && usuarioRepository.existsByEmailUsuario(dto.getEmailUsuario())) {
            throw new IllegalArgumentException(
                    "Já existe um usuário cadastrado com este e-mail."
            );
        }

        if (!usuario.getLoginUsuario().equals(dto.getLoginUsuario())
                && usuarioRepository.existsByLoginUsuario(dto.getLoginUsuario())) {
            throw new IllegalArgumentException(
                    "Já existe um usuário cadastrado com este login."
            );
        }

        usuario.setNomeUsuario(dto.getNomeUsuario());
        usuario.setEmailUsuario(dto.getEmailUsuario());
        usuario.setLoginUsuario(dto.getLoginUsuario());

        TbUsuario usuarioAtualizado = usuarioRepository.save(usuario);

        return usuarioMapper.toResponseDto(usuarioAtualizado);
    }

    @Transactional
    public void excluir(Long id) {

        TbUsuario usuario = buscarUsuario(id);

        usuarioRepository.delete(usuario);
    }

    private TbUsuario buscarUsuario(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNaoEncontradoException(
                        "Usuário não encontrado com o ID: " + id
                ));
    }
}