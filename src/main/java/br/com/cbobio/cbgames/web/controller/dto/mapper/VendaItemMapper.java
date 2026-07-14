package br.com.cbobio.cbgames.web.controller.dto.mapper;

import br.com.cbobio.cbgames.persistence.entity.TbVendaItem;
import br.com.cbobio.cbgames.web.controller.dto.request.vendaitem.VendaItemRequestDto;
import br.com.cbobio.cbgames.web.controller.dto.response.vendaitem.VendaItemResponseDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VendaItemMapper {

    TbVendaItem toEntity(VendaItemRequestDto request);

    VendaItemResponseDto toResponse(TbVendaItem entity);

    List<VendaItemResponseDto> toResponseList(List<TbVendaItem> entities);

}
