package br.com.cbobio.cbgames.web.controller.dto.mapper;

import br.com.cbobio.cbgames.persistence.entity.TbCliente;
import br.com.cbobio.cbgames.web.controller.dto.request.cliente.ClienteRequestDto;
import br.com.cbobio.cbgames.web.controller.dto.response.cliente.ClienteResponseDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    TbCliente toEntity(ClienteRequestDto request);

    ClienteResponseDto toResponse(TbCliente entity);

    List<ClienteResponseDto> toResponseList(List<TbCliente> entities);

}