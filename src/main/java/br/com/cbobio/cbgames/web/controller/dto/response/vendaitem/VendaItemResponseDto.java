package br.com.cbobio.cbgames.web.controller.dto.response.vendaitem;

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
public class VendaItemResponseDto {

    private Long id;

    private Long jogoId;

    private String nomeJogo;

    private Integer quantidade;

    private BigDecimal valorUnitario;

    private BigDecimal subtotal;

}