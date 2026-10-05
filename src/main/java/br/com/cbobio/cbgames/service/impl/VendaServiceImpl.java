package br.com.cbobio.cbgames.service.impl;

import br.com.cbobio.cbgames.machine.enums.estados.StatusVenda;
import br.com.cbobio.cbgames.machine.enums.eventos.EventoVenda;
import br.com.cbobio.cbgames.machine.service.VendaStateMachineService;
import br.com.cbobio.cbgames.persistence.entity.TbVenda;
import br.com.cbobio.cbgames.persistence.repository.VendaRepository;
import br.com.cbobio.cbgames.service.VendaService;
import br.com.cbobio.cbgames.service.exceptions.VendaNaoEncontradaException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VendaServiceImpl implements VendaService {

    private final VendaRepository vendaRepository;

    private final VendaStateMachineService vendaStateMachineService;

    @Override
    @Transactional
    public TbVenda salvar(TbVenda venda) {

        venda.setStatusVenda(StatusVenda.NOVO);

        venda.setValorTotal(BigDecimal.ZERO);

        return vendaRepository.save(venda);

    }

    @Override
    public TbVenda buscarPorId(Long id) {

        return vendaRepository.findById(id)
                .orElseThrow(() -> new VendaNaoEncontradaException("Venda não encontrada: " + id));
    }

    @Override
    public List<TbVenda> listar() {

        return vendaRepository.findAll();

    }

    @Override
    public void excluir(Long id) {

        TbVenda venda = buscarPorId(id);

        vendaRepository.delete(venda);

    }

    @Override
    public TbVenda alterarStatus(Long vendaId, EventoVenda evento) {

        return vendaStateMachineService.enviarEvento(vendaId, evento);

    }

}