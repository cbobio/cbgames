
package br.com.cbobio.cbgames.service;

import br.com.cbobio.cbgames.persistence.entity.TbJogo;
import br.com.cbobio.cbgames.persistence.repository.JogoRepository;
import br.com.cbobio.cbgames.service.exceptions.JogoNaoEncontradoException;
import br.com.cbobio.cbgames.web.controller.dto.mapper.JogoMapper;
import br.com.cbobio.cbgames.web.controller.dto.request.jogo.JogoAtualizacaoRequestDto;
import br.com.cbobio.cbgames.web.controller.dto.request.jogo.JogoRequestDto;
import br.com.cbobio.cbgames.web.controller.dto.response.jogo.JogoResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JogoService {

    private final JogoRepository jogoRepository;
    private final JogoMapper jogoMapper;

    @Transactional
    public JogoResponseDto cadastrar(JogoRequestDto request) {
        TbJogo jogo = jogoMapper.toEntity(request);

        TbJogo jogoSalvo = jogoRepository.save(jogo);

        return jogoMapper.toResponse(jogoSalvo);
    }

    @Transactional(readOnly = true)
    public JogoResponseDto buscarPorId(Long id) {
        TbJogo jogo = buscarJogo(id);

        return jogoMapper.toResponse(jogo);
    }

    @Transactional(readOnly = true)
    public List<JogoResponseDto> listarTodos() {
        List<TbJogo> jogos = jogoRepository.findAll();

        return jogoMapper.toResponseList(jogos);
    }

    @Transactional
    public JogoResponseDto atualizar(
            Long id,
            JogoAtualizacaoRequestDto request) {

        TbJogo jogo = buscarJogo(id);

        if (request.getNomeJogo() != null) {
            jogo.setNomeJogo(request.getNomeJogo());
        }

        if (request.getGeneroJogo() != null) {
            jogo.setGeneroJogo(request.getGeneroJogo());
        }

        if (request.getPlataformaJogo() != null) {
            jogo.setPlataformaJogo(request.getPlataformaJogo());
        }

        if (request.getDesenvolvedora() != null) {
            jogo.setDesenvolvedora(request.getDesenvolvedora());
        }

        if (request.getAnoLancamento() != null) {
            jogo.setAnoLancamento(request.getAnoLancamento());
        }

        jogo.setPreco(request.getPreco());
        jogo.setQuantidadeEstoque(request.getQuantidadeEstoque());
        jogo.setEstoqueMinimo(request.getEstoqueMinimo());

        TbJogo jogoAtualizado = jogoRepository.save(jogo);

        return jogoMapper.toResponse(jogoAtualizado);
    }

    @Transactional
    public void excluir(Long id) {
        TbJogo jogo = buscarJogo(id);

        jogoRepository.delete(jogo);
    }

    private TbJogo buscarJogo(Long id) {
        return jogoRepository.findById(id)
                .orElseThrow(() -> new JogoNaoEncontradoException(
                        "Jogo não encontrado com o ID: " + id
                ));
    }
}