package br.com.cbobio.cbgames.web.controller.dto.request.venda;

import br.com.cbobio.cbgames.web.controller.dto.request.vendaitem.VendaItemRequestDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VendaRequestDto {

    private Long clienteId;

    private Long usuarioId;

    private List<VendaItemRequestDto> itens;

}