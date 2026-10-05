package br.com.cbobio.cbgames.web.controller.dto.response.jogo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JogoResponseDto {

    private Long id;

    private String nomeJogo;

    private String generoJogo;

    private String plataformaJogo;

    private String desenvolvedora;

    private Integer anoLancamento;

    private BigDecimal preco;

    private Integer quantidadeEstoque;

    private Integer estoqueMinimo;

}