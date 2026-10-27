
package br.com.cbobio.cbgames.web.controller;

import br.com.cbobio.cbgames.service.JogoService;
import br.com.cbobio.cbgames.web.controller.dto.request.jogo.JogoAtualizacaoRequestDto;
import br.com.cbobio.cbgames.web.controller.dto.request.jogo.JogoRequestDto;
import br.com.cbobio.cbgames.web.controller.dto.response.jogo.JogoResponseDto;
import br.com.cbobio.cbgames.web.controller.endpoint.IJogoController;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class JogoControllerImpl implements IJogoController {

    private final JogoService jogoService;

    @Override
    public ResponseEntity<JogoResponseDto> cadastrar(
            JogoRequestDto dto) {

        JogoResponseDto jogo = jogoService.cadastrar(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(jogo);
    }

    @Override
    public ResponseEntity<JogoResponseDto> buscarPorId(Long id) {

        JogoResponseDto jogo = jogoService.buscarPorId(id);

        return ResponseEntity.ok(jogo);
    }

    @Override
    public ResponseEntity<List<JogoResponseDto>> listarTodos() {

        List<JogoResponseDto> jogos = jogoService.listarTodos();

        return ResponseEntity.ok(jogos);
    }

    @Override
    public ResponseEntity<JogoResponseDto> atualizar(
            Long id,
            JogoAtualizacaoRequestDto dto) {

        JogoResponseDto jogo = jogoService.atualizar(id, dto);

        return ResponseEntity.ok(jogo);
    }

    @Override
    public ResponseEntity<Void> excluir(Long id) {

        jogoService.excluir(id);

        return ResponseEntity.noContent().build();
    }
}