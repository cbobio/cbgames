package br.com.cbobio.cbgames.web.controller;

import br.com.cbobio.cbgames.service.UsuarioService;
import br.com.cbobio.cbgames.web.controller.dto.request.usuario.UsuarioAtualizacaoRequestDto;
import br.com.cbobio.cbgames.web.controller.dto.request.usuario.UsuarioRequestDto;
import br.com.cbobio.cbgames.web.controller.dto.response.usuario.UsuarioResponseDto;
import br.com.cbobio.cbgames.web.controller.endpoint.IUsuarioController;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UsuarioControllerImpl implements IUsuarioController {

    private final UsuarioService usuarioService;

    @Override
    public ResponseEntity<UsuarioResponseDto> cadastrar(
            UsuarioRequestDto dto) {

        UsuarioResponseDto usuario = usuarioService.cadastrar(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }

    @Override
    public ResponseEntity<UsuarioResponseDto> buscarPorId(Long id) {

        UsuarioResponseDto usuario = usuarioService.buscarPorId(id);

        return ResponseEntity.ok(usuario);
    }

    @Override
    public ResponseEntity<List<UsuarioResponseDto>> listarTodos() {

        List<UsuarioResponseDto> usuarios = usuarioService.listarTodos();

        return ResponseEntity.ok(usuarios);
    }

    @Override
    public ResponseEntity<UsuarioResponseDto> atualizar(
            Long id,
            UsuarioAtualizacaoRequestDto dto) {

        UsuarioResponseDto usuario = usuarioService.atualizar(id, dto);

        return ResponseEntity.ok(usuario);
    }

    @Override
    public ResponseEntity<Void> excluir(Long id) {

        usuarioService.excluir(id);

        return ResponseEntity.noContent().build();
    }
}