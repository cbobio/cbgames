package br.com.cbobio.cbgames.web.controller.endpoint;

import br.com.cbobio.cbgames.web.controller.dto.request.usuario.UsuarioAtualizacaoRequestDto;
import br.com.cbobio.cbgames.web.controller.dto.request.usuario.UsuarioRequestDto;
import br.com.cbobio.cbgames.web.controller.dto.response.usuario.UsuarioResponseDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/usuarios")
public interface IUsuarioController {

    @PostMapping
    ResponseEntity<UsuarioResponseDto> cadastrar(
            @Valid @RequestBody UsuarioRequestDto dto);

    @GetMapping("/{id}")
    ResponseEntity<UsuarioResponseDto> buscarPorId(
            @PathVariable Long id);

    @GetMapping
    ResponseEntity<List<UsuarioResponseDto>> listarTodos();

    @PutMapping("/{id}")
    ResponseEntity<UsuarioResponseDto> atualizar(
            @PathVariable Long id,
            @Valid @RequestBody UsuarioAtualizacaoRequestDto dto);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> excluir(
            @PathVariable Long id);
}