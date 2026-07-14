package br.com.cbobio.cbgames.web.controller.dto.response.usuario;
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
public class UsuarioResponseDto {

    private Long id;

    private String nomeUsuario;

    private String emailUsuario;

    private String loginUsuario;

}