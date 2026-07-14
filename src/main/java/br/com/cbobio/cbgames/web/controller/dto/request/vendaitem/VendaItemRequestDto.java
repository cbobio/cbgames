package br.com.cbobio.cbgames.web.controller.dto.request.vendaitem;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VendaItemRequestDto {

    private Long jogoId;

    private Integer quantidade;

}