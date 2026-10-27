
package br.com.cbobio.cbgames.web.controller.endpoint;

import br.com.cbobio.cbgames.web.controller.dto.request.jogo.JogoAtualizacaoRequestDto;
import br.com.cbobio.cbgames.web.controller.dto.request.jogo.JogoRequestDto;
import br.com.cbobio.cbgames.web.controller.dto.response.jogo.JogoResponseDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/jogos")
public interface IJogoController {

    @PostMapping
    ResponseEntity<JogoResponseDto> cadastrar(
            @Valid @RequestBody JogoRequestDto dto);

    @GetMapping("/{id}")
    ResponseEntity<JogoResponseDto> buscarPorId(
            @PathVariable Long id);

    @GetMapping
    ResponseEntity<List<JogoResponseDto>> listarTodos();

    @PutMapping("/{id}")
    ResponseEntity<JogoResponseDto> atualizar(
            @PathVariable Long id,
            @Valid @RequestBody JogoAtualizacaoRequestDto dto);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> excluir(
            @PathVariable Long id);
}
