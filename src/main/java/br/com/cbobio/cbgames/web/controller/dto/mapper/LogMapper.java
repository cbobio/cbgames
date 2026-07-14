package br.com.cbobio.cbgames.web.controller.dto.mapper;

import br.com.cbobio.cbgames.persistence.entity.TbLog;
import br.com.cbobio.cbgames.web.controller.dto.response.log.LogResponseDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LogMapper {

    LogResponseDto toResponse(TbLog entity);

    List<LogResponseDto> toResponseList(List<TbLog> entities);

}
