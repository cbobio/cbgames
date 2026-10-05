package br.com.cbobio.cbgames.web.controller.dto.response.venda;

import br.com.cbobio.cbgames.machine.enums.estados.StatusVenda;
import br.com.cbobio.cbgames.web.controller.dto.response.cliente.ClienteResponseDto;
import br.com.cbobio.cbgames.web.controller.dto.response.usuario.UsuarioResponseDto;
import br.com.cbobio.cbgames.web.controller.dto.response.vendaitem.VendaItemResponseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VendaResponseDto {

    private Long id;

    private LocalDateTime dataVenda;

    private BigDecimal valorTotal;

    private StatusVenda statusVenda;

    private ClienteResponseDto cliente;

    private UsuarioResponseDto usuario;

    private List<VendaItemResponseDto> itens;

}