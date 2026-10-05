package br.com.cbobio.cbgames.web.controller.dto.response.movimentacao;


import br.com.cbobio.cbgames.enums.TipoMovimentacaoEstoque;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MovimentacaoEstoqueResponseDto {

    private Long id;

    private TipoMovimentacaoEstoque tipoMovimentacao;

    private Integer quantidade;

    private String observacao;

    private LocalDateTime dataMovimentacao;

}