package br.com.cbobio.cbgames.web.controller.dto.mapper;

import br.com.cbobio.cbgames.persistence.entity.TbCliente;
import br.com.cbobio.cbgames.persistence.entity.TbEndereco;
import br.com.cbobio.cbgames.web.controller.dto.request.cliente.ClienteRequestDto;
import br.com.cbobio.cbgames.web.controller.dto.request.endereco.EnderecoRequestDto;
import br.com.cbobio.cbgames.web.controller.dto.response.cliente.ClienteResponseDto;
import br.com.cbobio.cbgames.web.controller.dto.response.endereco.EnderecoResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "usuario", ignore = true)
    @Mapping(target = "vendas", ignore = true)
    TbCliente toEntity(ClienteRequestDto request);

    TbEndereco toEndereco(EnderecoRequestDto dto);

    EnderecoResponseDto toEnderecoResponse(TbEndereco endereco);

    @Mapping(target = "createdAt", source = "createdAt")
    @Mapping(target = "updatedAt", source = "updatedAt")
    @Mapping(target = "usuarioId", source = "usuario.id")
    ClienteResponseDto toResponse(TbCliente entity);

    List<ClienteResponseDto> toResponseList(List<TbCliente> entities);
}