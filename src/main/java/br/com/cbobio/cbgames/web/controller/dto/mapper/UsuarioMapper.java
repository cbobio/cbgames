package br.com.cbobio.cbgames.web.controller.dto.mapper;

import br.com.cbobio.cbgames.persistence.entity.TbUsuario;
import br.com.cbobio.cbgames.web.controller.dto.request.usuario.UsuarioRequestDto;
import br.com.cbobio.cbgames.web.controller.dto.response.usuario.UsuarioResponseDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    TbUsuario toEntity(UsuarioRequestDto dto);

    UsuarioResponseDto toResponseDto(TbUsuario entity);

    List<UsuarioResponseDto> toResponseDtoList(List<TbUsuario> entities);

}