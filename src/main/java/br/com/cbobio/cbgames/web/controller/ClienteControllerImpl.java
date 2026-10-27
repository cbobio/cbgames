package br.com.cbobio.cbgames.web.controller;

import br.com.cbobio.cbgames.service.ClienteService;
import br.com.cbobio.cbgames.web.controller.dto.request.cliente.ClienteRequestDto;
import br.com.cbobio.cbgames.web.controller.dto.response.cliente.ClienteResponseDto;
import br.com.cbobio.cbgames.web.controller.endpoint.IClienteController;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ClienteControllerImpl implements IClienteController {

    private final ClienteService clienteService;

    @Override
    public ResponseEntity<ClienteResponseDto> cadastrar(
            ClienteRequestDto dto) {

        ClienteResponseDto cliente = clienteService.cadastrar(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
    }

    @Override
    public ResponseEntity<ClienteResponseDto> buscarPorId(Long id) {

        ClienteResponseDto cliente = clienteService.buscarPorId(id);

        return ResponseEntity.ok(cliente);
    }

    @Override
    public ResponseEntity<List<ClienteResponseDto>> listarTodos() {

        List<ClienteResponseDto> clientes = clienteService.listarTodos();

        return ResponseEntity.ok(clientes);
    }

    @Override
    public ResponseEntity<ClienteResponseDto> atualizar(
            Long id,
            ClienteRequestDto dto) {

        ClienteResponseDto cliente = clienteService.atualizar(id, dto);

        return ResponseEntity.ok(cliente);
    }

    @Override
    public ResponseEntity<Void> excluir(Long id) {

        clienteService.excluir(id);

        return ResponseEntity.noContent().build();
    }
}