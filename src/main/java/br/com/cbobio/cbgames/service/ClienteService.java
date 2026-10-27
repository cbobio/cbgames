package br.com.cbobio.cbgames.service;

import br.com.cbobio.cbgames.persistence.entity.TbCliente;
import br.com.cbobio.cbgames.persistence.entity.TbUsuario;
import br.com.cbobio.cbgames.persistence.repository.ClienteRepository;
import br.com.cbobio.cbgames.persistence.repository.UsuarioRepository;
import br.com.cbobio.cbgames.service.exceptions.ClienteNaoEncontradoException;
import br.com.cbobio.cbgames.service.exceptions.UsuarioNaoEncontradoException;
import br.com.cbobio.cbgames.web.controller.dto.mapper.ClienteMapper;
import br.com.cbobio.cbgames.web.controller.dto.request.cliente.ClienteRequestDto;
import br.com.cbobio.cbgames.web.controller.dto.response.cliente.ClienteResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;
    private final UsuarioRepository usuarioRepository;
    private final ClienteMapper clienteMapper;

    @Transactional
    public ClienteResponseDto cadastrar(ClienteRequestDto dto) {

        validarEmailDisponivel(dto.getEmailCliente(), null);
        validarCpfDisponivel(dto.getCpfCliente(), null);

        TbUsuario usuario = buscarUsuario(dto.getUsuarioId());

        TbCliente cliente = clienteMapper.toEntity(dto);
        cliente.setUsuario(usuario);

        TbCliente clienteSalvo = clienteRepository.save(cliente);

        return clienteMapper.toResponse(clienteSalvo);
    }

    @Transactional(readOnly = true)
    public ClienteResponseDto buscarPorId(Long id) {

        TbCliente cliente = buscarCliente(id);

        return clienteMapper.toResponse(cliente);
    }

    @Transactional(readOnly = true)
    public List<ClienteResponseDto> listarTodos() {

        return clienteMapper.toResponseList(
                clienteRepository.findAll()
        );
    }

    @Transactional
    public ClienteResponseDto atualizar(
            Long id,
            ClienteRequestDto dto) {

        TbCliente cliente = buscarCliente(id);

        validarEmailDisponivel(dto.getEmailCliente(), id);
        validarCpfDisponivel(dto.getCpfCliente(), id);

        TbUsuario usuario = buscarUsuario(dto.getUsuarioId());

        TbCliente dadosAtualizados = clienteMapper.toEntity(dto);

        cliente.setNomeCliente(dadosAtualizados.getNomeCliente());
        cliente.setEmailCliente(dadosAtualizados.getEmailCliente());
        cliente.setCpfCliente(dadosAtualizados.getCpfCliente());
        cliente.setTelefoneCliente(dadosAtualizados.getTelefoneCliente());
        cliente.setEndereco(dadosAtualizados.getEndereco());
        cliente.setUsuario(usuario);

        TbCliente clienteAtualizado = clienteRepository.save(cliente);

        return clienteMapper.toResponse(clienteAtualizado);
    }

    @Transactional
    public void excluir(Long id) {

        TbCliente cliente = buscarCliente(id);

        clienteRepository.delete(cliente);
    }

    private TbCliente buscarCliente(Long id) {

        return clienteRepository.findById(id)
                .orElseThrow(() -> new ClienteNaoEncontradoException(
                        "Cliente não encontrado com o ID: " + id
                ));
    }

    private TbUsuario buscarUsuario(Long id) {

        return usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNaoEncontradoException(
                        "Usuário não encontrado com o ID: " + id
                ));
    }

    private void validarEmailDisponivel(String email, Long clienteId) {

        clienteRepository.findByEmailCliente(email)
                .filter(cliente -> !cliente.getId().equals(clienteId))
                .ifPresent(cliente -> {
                    throw new IllegalArgumentException(
                            "Já existe um cliente cadastrado com este e-mail."
                    );
                });
    }

    private void validarCpfDisponivel(String cpf, Long clienteId) {

        clienteRepository.findByCpfCliente(cpf)
                .filter(cliente -> !cliente.getId().equals(clienteId))
                .ifPresent(cliente -> {
                    throw new IllegalArgumentException(
                            "Já existe um cliente cadastrado com este CPF."
                    );
                });
    }
}