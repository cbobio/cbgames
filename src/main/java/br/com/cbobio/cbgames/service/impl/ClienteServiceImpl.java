package br.com.cbobio.cbgames.service.impl;

import br.com.cbobio.cbgames.persistence.entity.TbCliente;
import br.com.cbobio.cbgames.persistence.repository.ClienteRepository;
import br.com.cbobio.cbgames.service.ClienteService;
import br.com.cbobio.cbgames.service.exceptions.ClienteNaoEncontradoException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;


    @Override
    public TbCliente salvar(TbCliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public TbCliente buscarPorId(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() ->
                        new ClienteNaoEncontradoException("Cliente não encontrado: " + id));
    }

    @Override
    public TbCliente buscarPorCpf(String cpf) {
        return clienteRepository.findByCpfCliente(cpf)
                .orElseThrow(() ->
                new ClienteNaoEncontradoException("Cliente não encontrado: " + cpf));
    }

    @Override
    public List<TbCliente> listar() {
        return clienteRepository.findAll();
    }

    @Override
    public void excluir(Long id) {
        clienteRepository.deleteById(id);
    }
}
