package br.com.cbobio.cbgames.web.controller.endpoint;

import br.com.cbobio.cbgames.web.controller.dto.request.cliente.ClienteRequestDto;
import br.com.cbobio.cbgames.web.controller.dto.response.cliente.ClienteResponseDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/clientes")
public interface IClienteController {

    @PostMapping
    ResponseEntity<ClienteResponseDto> cadastrar(
            @Valid @RequestBody ClienteRequestDto dto);

    @GetMapping("/{id}")
    ResponseEntity<ClienteResponseDto> buscarPorId(
            @PathVariable Long id);

    @GetMapping
    ResponseEntity<List<ClienteResponseDto>> listarTodos();

    @PutMapping("/{id}")
    ResponseEntity<ClienteResponseDto> atualizar(
            @PathVariable Long id,
            @Valid @RequestBody ClienteRequestDto dto);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> excluir(
            @PathVariable Long id);
}