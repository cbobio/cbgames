package br.com.cbobio.cbgames.web.controller.dto.mapper;

import br.com.cbobio.cbgames.persistence.entity.TbJogo;
import br.com.cbobio.cbgames.web.controller.dto.request.jogo.JogoRequestDto;
import br.com.cbobio.cbgames.web.controller.dto.response.jogo.JogoResponseDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface JogoMapper {

    TbJogo toEntity(JogoRequestDto request);

    JogoResponseDto toResponse(TbJogo entity);

    List<JogoResponseDto> toResponseList(List<TbJogo> entities);

}