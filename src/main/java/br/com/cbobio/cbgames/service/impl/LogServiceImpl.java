package br.com.cbobio.cbgames.service.impl;

import br.com.cbobio.cbgames.persistence.entity.TbLog;
import br.com.cbobio.cbgames.persistence.repository.LogRepository;
import br.com.cbobio.cbgames.service.LogService;
import br.com.cbobio.cbgames.service.exceptions.LogNaoEncontradoException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LogServiceImpl implements LogService {

    private final LogRepository logRepository;

    @Override
    public TbLog salvar(TbLog log) {
        return logRepository.save(log);
    }

    @Override
    public TbLog buscarPorId(Long id) {
        return logRepository.findById(id)
                .orElseThrow(() ->
                        new LogNaoEncontradoException("Log não encontrado: " + id));
    }

    @Override
    public List<TbLog> listar() {
        return logRepository.findAll();
    }

}