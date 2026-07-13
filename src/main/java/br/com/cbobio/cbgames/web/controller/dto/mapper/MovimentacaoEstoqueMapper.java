package br.com.cbobio.cbgames.web.controller.dto.mapper;

import br.com.cbobio.cbgames.persistence.entity.TbMovimentacaoEstoque;
import br.com.cbobio.cbgames.web.controller.dto.response.MovimentacaoEstoqueResponseDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MovimentacaoEstoqueMapper {

    MovimentacaoEstoqueResponseDto toResponse(TbMovimentacaoEstoque entity);

    List<MovimentacaoEstoqueResponseDto> toResponseList(List<TbMovimentacaoEstoque> entities);

}