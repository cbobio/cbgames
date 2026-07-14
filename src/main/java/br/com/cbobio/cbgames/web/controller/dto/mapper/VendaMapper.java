package br.com.cbobio.cbgames.web.controller.dto.mapper;

import br.com.cbobio.cbgames.persistence.entity.TbVenda;
import br.com.cbobio.cbgames.web.controller.dto.request.venda.VendaRequestDto;
import br.com.cbobio.cbgames.web.controller.dto.response.venda.VendaResponseDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {
                VendaItemMapper.class
        }
)
public interface VendaMapper {

    TbVenda toEntity(VendaRequestDto request);

    VendaResponseDto toResponse(TbVenda entity);

    List<VendaResponseDto> toResponseList(List<TbVenda> entities);

}